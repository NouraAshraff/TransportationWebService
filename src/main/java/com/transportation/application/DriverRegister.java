package com.transportation.application;


import com.transportation.core.Driver;

public class DriverRegister extends Registration {
    public DriverRegister() {
    }

    @Override
    public boolean Register(IUser iuser) {
        IUser result;
        result = isaving.searchIUser(iuser.getUserName(), iuser.getPassword());
        if (result != null) {
            return false;
        } else {
           return isaving.savePended(iuser);
        }
    }

    @Override
    public boolean login(IUser iuser) {

        IUser result;
        result = isaving.searchIUser(iuser.getUserName(), iuser.getPassword());
        if (iuser instanceof Driver&&result!=null) {

            if (((Driver) iuser).getVerified() == true) {
                return true;
                //System.out.println("You logged in successfully.");
            } else {
                return false;
                //System.out.println("You are not verified yet!");
            }
        }
        return false;
    }
}