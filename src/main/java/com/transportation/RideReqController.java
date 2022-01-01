package com.transportation;

import com.transportation.application.Event;
import com.transportation.application.Offer;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.ArrayList;

public class RideReqController {
    RideReqController reqController = new RideReqController();

    @GetMapping("/getNoOfPass")
    public int getNoOfPass() {
        return reqController.getNoOfPass();
    }

    @PostMapping("/addOffer")
    public boolean addOffer(@RequestBody Offer newOffer) {
        return reqController.addOffer(newOffer);
    }

    @GetMapping("/getOffers")
    public ArrayList<Offer> getOffers() {
        return reqController.getOffers();
    }

    @GetMapping("/getDate")
    public String getDate() {
        return reqController.getDate();
    }

    @PostMapping("/addEvent")
    public boolean addEvent(@RequestBody Event event) {
        return reqController.addEvent(event);
    }

    @DeleteMapping("/removeEvent")
    public boolean removeEvent(Event event) {
            return reqController.removeEvent(event);
    }

    @GetMapping("/getEvents")
    public ArrayList<Event> getEvents() {
        return reqController.getEvents();
    }

    @GetMapping("/getStart")
    public boolean getStart() {
        return reqController.getStart();
    }

    @GetMapping("/getEnd")
    public boolean getEnd() {
        return reqController.getEnd();
    }

}
