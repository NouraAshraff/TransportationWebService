package com.transportation.application;


import com.transportation.Persistence.arraySaving;
import com.transportation.Persistence.ISaving;

public abstract class Registration {

    public ISaving isaving  = new arraySaving();

    public boolean Register(IUser iuser){
    }
    public Registration() {}


    public abstract boolean login(IUser iuser);
}