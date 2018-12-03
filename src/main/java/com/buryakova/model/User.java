package com.buryakova.model;

/**
 * Created by anton on 03.12.2018.
 */
public class User {
    private String nicName;
    public User(){}
    public User(String nicName){
        this.nicName = nicName;
    }
    public String getNicName() {
        return nicName;
    }

    public void setNicName(String nicName) {
        this.nicName = nicName;
    }
}
