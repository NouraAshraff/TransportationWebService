package com.transportation.application;


import com.transportation.Persistence.arraySaving;
import com.transportation.Persistence.ISaving;

public abstract class Registration {
    public ISaving obj  = new arraySaving();

    public Registration() {
    }

    public boolean Register(IUser iuser){
    }

    public abstract boolean login(IUser iuser);
}