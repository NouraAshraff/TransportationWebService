package com.transportation;

import com.transportation.application.IArea;
import com.transportation.core.Area;
import com.transportation.core.Driver;
import com.transportation.core.Ride;
import org.springframework.web.bind.annotation.*;

@RestController
public class AreaController {
    IArea area = new Area();

    @GetMapping("/getAdminDiscount")
    public boolean getAdminDiscount() {
        return ((Area) area).getAdminDiscount();
    }

    @GetMapping("/getAreaName")
    public String getName() {
        return ((Area) area).getName();
    }

    @PostMapping("/notifyDriverByRide")
    public void notifyDriver(@RequestBody Ride ride) {
         area.notifyDriver(ride);
    }

    @PostMapping("/addDriver")
    public boolean addDriver(@RequestBody Driver driver) {
        return  area.addDriver(driver);
    }

    @DeleteMapping("/removeDriver")
    public boolean removeDriver(@RequestBody Driver driver) {
        return  area.removeDriver(driver);
    }
}
