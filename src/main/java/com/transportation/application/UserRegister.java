package com.transportation.application;

import com.transportation.core.User;

public class UserRegister extends Registration {
    public UserRegister() {
    }

    @Override
    public boolean Register(IUser iuser) {
        IUser result;
        result = isaving.searchIUser(iuser.getUserName(), iuser.getPassword());
        if (result != null) {
            return  false;
        } else {
            ((User) iuser).setVerified(true);
           return isaving.saveUser(iuser);

        }
    }

    @Override
    public boolean login(IUser iuser) {
        IUser result;
        result = isaving.searchIUser(iuser.getUserName(), iuser.getPassword());
        if ( result!=null && iuser instanceof User) {
            if (((User) iuser).getVerified() == true) {
               // System.out.println("You logged in successfully.");
                return true;
            } else {
               // System.out.println("You are not verified yet!");
                return  false;
            }
        }
        return false;
    }
}