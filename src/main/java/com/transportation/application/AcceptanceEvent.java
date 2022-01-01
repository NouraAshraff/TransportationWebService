package com.transportation.application;



import com.transportation.core.User;

import java.time.LocalTime;

public class AcceptanceEvent implements Event {

    private User user ;

    private String name = "User accepts the captain price";

    private String time;
    public AcceptanceEvent(){

    }

    public AcceptanceEvent(User user )
    {
        LocalTime time = LocalTime.now();
        String Time = time.toString();
        this.time = Time;
        this.user = user;
    }
    @Override
    public String printEvent() {
        return ("Name : " + name+
                             "  Time : " + time +
                             "  UserName : "+ user.getUserName());
    }
}
