package com.transportation;

import com.transportation.application.IArea;
import com.transportation.application.IRide;
import com.transportation.core.Area;
import com.transportation.core.Ride;
import com.transportation.core.RideRequest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

@RestController
public class RideController {
    IRide ride= new Ride();


    @PostMapping("/addRequest")
    public boolean addRequest(@RequestBody RideRequest nwRequest){
        return  ((Ride)ride).addRequest(nwRequest);
    }

    /*
    @GetMapping
    public boolean checkHoliday(){
        return ((Ride)ride).checkHoliday();
    }
    */
    @GetMapping("/getRequests")
    public ArrayList<RideRequest> getRequests() {
        return ((Ride)ride).getRequests();
    }

    @GetMapping("/getSource")
    public Area getSource() {
        return ((Ride)ride).getSource();
    }

    @GetMapping("/getDestenation")
    public Area getDestenation() {
        return ((Ride)ride).getDestenation();
    }



}
