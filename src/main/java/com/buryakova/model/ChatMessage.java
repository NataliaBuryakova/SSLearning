package com.buryakova.model;


import java.time.LocalDate;

public class ChatMessage {
   // private User sender;
    private String content;
    private MessageType type;
    private LocalDate messageDate;
    private String user;

    public ChatMessage(){}
    public ChatMessage( String user,String content)
    {
        this.user = user;
        this.content = content;
    }
    public enum MessageType {
        CHAT, JOIN, LEAVE
    }

    public MessageType getType() {
        return type;
    }

    public void setType(MessageType type) {
        this.type = type;
    }
   /* public User getSender() {
        return sender;
    }

    public void setSender(User sender) {
        this.sender = sender;
    }*/

    public String getContent() {
        return content;
    }

    public void setContent(String content) {this.content = content;}

    public LocalDate getMessageDate() {return messageDate;}
    public void setMessageDate(LocalDate messageDate) {this.messageDate = messageDate;}

    public String getUser() {

        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }
}
