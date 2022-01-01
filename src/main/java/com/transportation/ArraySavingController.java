package com.transportation;

import com.transportation.Persistence.ISaving;
import com.transportation.Persistence.arraySaving;
import com.transportation.application.IArea;
import com.transportation.application.IRide;
import com.transportation.application.IUser;
import com.transportation.core.Area;
import com.transportation.core.Ride;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.ArrayList;

public class ArraySavingController {
    ISaving arraySaving = new arraySaving();

    @PostMapping("/saveUser")
    public boolean saveUser(IUser user) {
        return arraySaving.saveUser(user);
    }

    @PostMapping("/addAdmin")
    public boolean addAdmin(IUser admin) {
        return arraySaving.addAdmin(admin);
    }

    @PostMapping("/savePended")
    public boolean savePended(IUser pended) {
        return arraySaving.savePended(pended);

    }

    @PostMapping("/saveArea")
    public boolean saveArea(Area area) {
        return arraySaving.saveArea(area);
    }

    @PostMapping("/saveRide")
    public boolean saveRide(Ride ride) {
        return arraySaving.saveRide(ride);
    }

    @GetMapping("/retrieveUser")
    public ArrayList<IUser> retrieveUsers() {
        return arraySaving.retrieveUsers();
    }

    @GetMapping("/retrievePended")
    public ArrayList<IUser> retrievePended() {
        return arraySaving.retrievePended();
    }

    @GetMapping("/retrieveArea")
    public ArrayList<Area> retrieveArea() {
        return arraySaving.retrieveArea();
    }

    @GetMapping("/retrieveRide")
    public ArrayList<Ride> retrieveRide() {
        return arraySaving.retrieveRide();
    }

    @GetMapping("searchUser")
    public IUser searchIUser(@RequestBody String userName, @RequestBody String password) {
        return arraySaving.searchIUser(userName,password);
    }

    @GetMapping("searchRide")
    public IRide searchRide(Area source, Area destination) {
        return  arraySaving.searchRide(source,destination);
    }

    @GetMapping("searchArea")
    public IArea searchArea(String name) {
      return arraySaving.searchArea(name);
    }

    @GetMapping("searchAdmin")
    public IUser searchAdmin(String userName, String Password) {
       return  arraySaving.searchAdmin(userName,Password);
    }



}
