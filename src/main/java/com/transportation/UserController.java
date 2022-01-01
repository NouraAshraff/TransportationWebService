package com.transportation;

import com.transportation.application.*;
import com.transportation.core.RideRequest;
import com.transportation.core.Ride;
import com.transportation.core.User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

@RestController
public class UserController {
    User user = new User();

    @GetMapping("/getUserRide")
    public IRide getChosenRide() {
        return user.getChosenRide();
    }

    @GetMapping("/getBirthDate")
    public String getBirthDate() {
        return user.getBirthDate();
    }

    @GetMapping("/getPhoneNum")
    public String getPhoneNum() {
        return user.getPhoneNum();
    }

    @GetMapping("/getOffer")
    public Offer getOffer() {
        return user.getOffer();
    }

    @GetMapping("/getUserRequest")
    public RideRequest getUserRequest() {
        return user.getUserRequest();
    }

    @PostMapping("/reqRide")
    public Ride requestRide(@RequestBody IRide ride, @RequestBody int noOfPass) {
        return user.requestRide(ride, noOfPass);
    }

    @GetMapping("/getUserReqOffers")
    public ArrayList<Offer> getUserReqOffers() {
        return user.getUserReqOffers();
    }

    @GetMapping("/chooseOffer")
    public Offer chooseOffer(@RequestBody Ride ride, @RequestBody Offer offer) {
        return user.chooseOffer(ride, offer);
    }


}
