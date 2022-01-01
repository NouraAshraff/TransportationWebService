package com.transportation;

import com.transportation.application.IOffer;
import com.transportation.application.Offer;
import com.transportation.core.Driver;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class OfferController {
    Offer offer=new Offer();


    @GetMapping("/getUserPrice")
    public double getUserPrice() {
        return offer.getUserPrice();
    }

    @GetMapping("/to_String")
    public String to_String(){
        return offer.to_String();
    }

    @GetMapping("/calculatePrice")
    public double calculatePrice() {
        return offer.calculatePrice();
    }

}
