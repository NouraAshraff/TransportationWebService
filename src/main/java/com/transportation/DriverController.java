package com.transportation;
import com.transportation.application.*;
import com.transportation.core.Area;
import com.transportation.core.Driver;
import com.transportation.core.Ride;
import com.transportation.core.User;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
@RestController
public class DriverController  {
    private IDriver driver;
     DriverController(){
        driver= new Driver();
    }

    @PostMapping("/addDriverReq")
    public boolean addDriverReq(@RequestBody RideRequest nwRequest){
       return driver.addDriverReq(nwRequest);
    }

    @GetMapping("/getDriverRequsets")
    public ArrayList<RideRequest> getDriverRequsets() {
        return driver.getDriverRequsets();
    }

    @PostMapping("/calcbalance/{price}")
    public double calcbalance(@PathVariable double price)
    {
        return driver.calcbalance(price);
    }

    @PostMapping("/AddNewFavArea")
    public boolean AddNewFavArea(@RequestBody Area area)
    {
        return driver.AddNewFavArea(area);
    }

    @PostMapping("/rateDriver")
    public boolean rateMe(@RequestBody int rate ,@RequestBody User user)
    {
       return driver.rateMe(rate,user);
    }

   @PostMapping("/makeOffer")
    public void makeOffer(@RequestBody Ride ride ,@RequestBody double price)
    {
        driver.makeOffer(ride,price);
    }

    @GetMapping("/getFavAreas")
    public ArrayList<Area> getFavAreas()
    {
        return driver.getFavAreas();
    }

    @GetMapping("/listRides")
    public ArrayList<String> listRides()
    {
      return driver.listRides();
    }
    /*public String toString() {
        return driver.toString();
    }*/

    @GetMapping("/getRides")
    public ArrayList<Ride> getRides()
    {
        return driver.getRides();
    }

    @PostMapping("/addRide")
    public boolean addRide(@RequestBody Ride ride){
        return driver.addRide(ride);
    }

    @PostMapping("/startRide")
    public boolean startRide( @RequestBody User user)
    {
       return driver.startRide(user);
    }

    @PostMapping("/endRide")
    public boolean endRide(@RequestBody User user)
    {
        return driver.endRide(user);
    }
}
