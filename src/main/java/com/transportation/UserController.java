package com.transportation;

import com.transportation.application.IRide;
import com.transportation.application.IUser;
import com.transportation.core.RideRequest;
import com.transportation.core.Ride;
import com.transportation.core.User;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.time.LocalDate;

public class UserController extends IUser {
    User user=new User();
    /*@PostMapping("/addRide")
    public void setChosenRide(Ride chosenRide) {
        user.chosenRide = chosenRide;
    }*/

    @PostMapping("/reqRide")
    public Ride requestRide(@RequestBody IRide ride,@RequestBody int noOfPass) {
        RideRequest nwRequest=new RideRequest();
        if(user.getUserRequest()==null){
            LocalDate date=LocalDate.now();
            nwRequest.setDate(date.toString());
            nwRequest.setNoOfPass(noOfPass);
            ((Ride)ride).addRequest(nwRequest);
            user.setUserRequest(nwRequest);
            ride.checkSourceArea(((Ride)ride).getSource());
        }
        return (Ride)ride;
    }

}
