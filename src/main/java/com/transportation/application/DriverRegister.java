package com.transportation.application;


import com.transportation.core.Driver;

public class DriverRegister extends Registration {
    public DriverRegister() {
    }

    @Override
    public boolean Register(IUser iuser) {
        IUser result;
        result = obj.searchIUser(iuser.getUserName(), iuser.getPassword());
        if (result != null) {
            return false;
        } else {
            return obj.savePended(iuser);
        }
    }

    @Override
    public boolean login(IUser iuser) {

        IUser result;
        boolean ans;
        result = obj.searchIUser(iuser.getUserName(), iuser.getPassword());
        if (iuser instanceof Driver&&result!=null) {

            if (((Driver) iuser).getVerified() == true) {
                ans=true;
                //System.out.println("You logged in successfully.");
            } else {
                ans=false;
                //System.out.println("You are not verified yet!");
            }
        }

        else{
            //System.out.println("you are not driver");
            ans=false;
        }
        return ans;
    }
}