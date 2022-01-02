package com.transportation;

import com.transportation.Persistence.ISaving;
import com.transportation.Persistence.arraySaving;
import com.transportation.application.IArea;
import com.transportation.application.IRide;
import com.transportation.application.IUser;
import com.transportation.core.Area;
import com.transportation.core.Ride;
import com.transportation.core.User;
import com.transportation.core.admin;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
@RequestMapping("/ArraySaving")
@RestController
public class ArraySavingController {
    ISaving saving = arraySaving.getInstance();

    @PostMapping("/saveUser")
    public boolean saveUser( @RequestBody User user) {
        return saving.saveUser(user);
    }

    @PostMapping("/addAdmin")
    public boolean addAdmin(@RequestBody admin admin) {
        return saving.addAdmin(admin);
    }

    @PostMapping("/savePended")
    public boolean savePended( @RequestBody IUser pended) {
        return saving.savePended(pended);
    }

    @PostMapping("/saveArea")
    public boolean saveArea( @RequestBody Area area) {
        return saving.saveArea(area);
    }

    @PostMapping("/saveRide")
    public boolean saveRide(@RequestBody Ride ride) {
        return saving.saveRide(ride);
    }

   @GetMapping("/retrieveUser")
    public ArrayList<IUser> retrieveUsers() {
        return saving.retrieveUsers();
    }

    @GetMapping("/retrievePended")
    public ArrayList<IUser> retrievePended() {
        return saving.retrievePended();
    }

    @GetMapping("/retrieveArea")
    public ArrayList<Area> retrieveArea() {
        return saving.retrieveArea();
    }

    @GetMapping("/retrieveRide")
    public ArrayList<Ride> retrieveRide() {
        return saving.retrieveRide();
    }

    @GetMapping("/searchUser")
    public IUser searchIUser(@RequestBody String userName, @RequestBody String password) {
        return saving.searchIUser(userName,password);
    }

    @GetMapping("/searchRide/{destination}")
    public IRide searchRide( @RequestBody Area source, @PathVariable Area destination) {
        return  saving.searchRide(source,destination);
    }

    @GetMapping("/searchArea")
    public IArea searchArea( @RequestBody String name) {
      return saving.searchArea(name);
    }

    @GetMapping("/searchAdmin")
    public IUser searchAdmin(@RequestBody String userName, @RequestBody String Password) {
       return  saving.searchAdmin(userName,Password);
    }
}
