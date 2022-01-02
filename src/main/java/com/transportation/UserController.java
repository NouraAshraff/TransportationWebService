package com.transportation;

import com.transportation.Persistence.ISaving;
import com.transportation.Persistence.arraySaving;
import com.transportation.application.*;
import com.transportation.core.RideRequest;
import com.transportation.core.Ride;
import com.transportation.core.User;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
public class UserController {
    User user = new User();
    ISaving saving= arraySaving.getInstance();
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

    @PostMapping("/reqRide/{noOfPass}")
    public Ride requestRide(@RequestBody Ride ride, @PathVariable int noOfPass) {
        Ride ride1= (Ride) saving.searchRide(ride.getSource(),ride.getDestenation());
        return user.requestRide(ride1, noOfPass);
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
