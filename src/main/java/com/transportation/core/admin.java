package com.transportation.core;

import com.transportation.Persistence.ISaving;
import com.transportation.Persistence.arraySaving;
import com.transportation.application.Event;
import com.transportation.application.IUser;


import java.util.ArrayList;

public class admin extends IUser {
    ISaving saving = new arraySaving();
    public admin(){

    }

    public boolean addDiscount(Area area){
        for (Area area1:saving.retrieveArea()){
            if(area.getName()==area1.getName()){
                area.setHasAdminDiscount(true);
                return true;
            }
        }
        return false;
    }

    public ArrayList<String> showEvents(RideRequest req)
    {
     ArrayList<String>printing= new ArrayList<>();
       // for (RideRequest req:ride.getRequests()) {
            for(int j=0;j<req.getEvents().size();j++){
               printing.add( req.getEvents().get(j).printEvent());
            }
             return printing;
        //}

    }

    public boolean suspend(IUser user) {
        for (IUser iuser : saving.retrieveUsers()) {
            if (iuser.equals(user)) {
                if(iuser instanceof User) ((User)iuser).setVerified(false);
                if(iuser instanceof Driver) ((Driver)iuser).setVerified(false);
                saving.savePended(user);
                saving.retrieveUsers().remove(user);
                return true;

            }
        }
        return false;
    }

    @Override
    public String getPassword() {
        // TODO Auto-generated method stub
        return super.getPassword();
    }

    @Override
    public String getUserName() {
        // TODO Auto-generated method stub
        return super.getUserName();
    }

    @Override
    public void setPassword(String password) {
        // TODO Auto-generated method stub
        super.setPassword(password);
    }

    @Override
    public void setUserName(String userName) {
        // TODO Auto-generated method stub
        super.setUserName(userName);
    }

    @Override
    public String toString() {
        return "admin [name=" + this.userName + "pass"+ this.password+"]";
    }

    public boolean verify(IUser driver) {
        for (IUser itdriver : saving.retrievePended()) {
            //System.out.println( "in loop"+itdriver.toString());
            if (driver.equals(itdriver) && itdriver instanceof Driver) {
                ((Driver) driver).setVerified(true);
                // System.out.println( "in if");
                saving.retrievePended().remove(driver);
                saving.saveUser(driver);
                return true;
            }

        }
        return false;
    }

    public ArrayList<IUser> listPendingRegistration() {
        return saving.retrievePended();
    }

    public boolean loginAdmin(IUser iuser) {
        IUser result;
        result = saving.searchAdmin(iuser.getUserName(), iuser.getPassword());

        if (result == null) {
            saving.addAdmin(iuser);

           // System.out.println("You are not an admin!");
        } else {
           // System.out.println("You logged in successfully.");
            return true;
        }
        return false;
    }
}