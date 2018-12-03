package com.buryakova.controller;

import com.buryakova.model.ChatMessage;
import com.buryakova.model.ChatModel;
import com.buryakova.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.jws.soap.SOAPBinding;
import javax.servlet.http.HttpServletRequest;
import java.time.LocalDate;
import java.util.ArrayList;


@Controller
public class ChatController {
    private static ArrayList<ChatMessage> messages = new ArrayList<ChatMessage>();
    private static ArrayList<User> users = new ArrayList<User>();

   @RequestMapping("/")
    public String index(HttpServletRequest request, Model model) {
        String username = (String) request.getSession().getAttribute("username");

        if (username == null || username.isEmpty()) {
            return "redirect:/login";
        }
        ChatMessage chatMessage = new ChatMessage(username, "ВСТУПИЛ В ЧАТ");
        messages.add(chatMessage);
        User user = new User();
        user.setNicName(username);
        users.add(user);
        model.addAttribute("username", username);
        model.addAttribute("messages", messages);
        model.addAttribute("users", users);
        model.addAttribute("chatMessage",new ChatMessage());

        return "chat";
    }
    @RequestMapping(path = "/setMessage" , method = RequestMethod.POST)
    public String setMessage(HttpServletRequest request,Model model,@ModelAttribute ChatMessage chatMessage) {
       // String message = (String) request.getSession().getAttribute("message");
        String username = (String) request.getSession().getAttribute("username");
        chatMessage.setMessageDate(LocalDate.now());
        chatMessage.setUser(username);
        messages.add(chatMessage);
        model.addAttribute("messages", messages);
        model.addAttribute("users", users);
        model.addAttribute("username", username);


        return "chat";
    }
   /* @RequestMapping(path ="/messageList" , method = RequestMethod.GET)
    public String messageList(Model model) {

        model.addAttribute("messages", messages);

        return "chat";
    }
    @RequestMapping(path = "/userList" , method = RequestMethod.GET)
    public String userList(Model model) {

        model.addAttribute("users", users);

        return "chat";
    }*/
    @RequestMapping(path = "/login", method = RequestMethod.GET)
    public String showLoginPage(Model model)  {
        model.addAttribute("user", new User ());
        return "login";
    }

    @RequestMapping(path = "/login", method = RequestMethod.POST)
    public String doLogin(HttpServletRequest request,  @ModelAttribute("user") User user) {
       String username = user.getNicName().trim();

        if (username.isEmpty()) {
            return "login";
        }
        request.getSession().setAttribute("username", username);

        return "redirect:/";
    }

    @RequestMapping(path = "/logout")
    public String logout(HttpServletRequest request) {
        String username = (String)request.getSession().getAttribute("username");
        ChatMessage chatMessage = new ChatMessage(username, "ПОКИНУЛ ЧАТ");
        messages.add(chatMessage);
      for (User user:users)
        {
            if (user.getNicName().equals(username)) {
                users.remove(user);
                break;
            }
            if (users.size()<1)  break;
        }
        request.getSession(true).invalidate();

        return "redirect:/login";
    }
}