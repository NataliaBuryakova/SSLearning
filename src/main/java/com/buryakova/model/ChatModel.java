package com.buryakova.model;

import java.util.ArrayList;

/**
 * Created by anton on 03.12.2018.
 */
public class ChatModel {
    private ArrayList<ChatMessage> chatMessages;
    private ArrayList<User> users;

    public ArrayList<ChatMessage> getChatMessages() {
        return chatMessages;
    }

    public void setChatMessages(ArrayList<ChatMessage> chatMessages) {
        this.chatMessages = chatMessages;
    }

    public ArrayList<User> getUsers() {
        return users;
    }

    public void setUsers(ArrayList<User> users) {
        this.users = users;
    }
}
