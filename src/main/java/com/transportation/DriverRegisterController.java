package com.transportation;

import com.transportation.application.DriverRegister;
import com.transportation.application.IUser;
import com.transportation.application.Registration;
import com.transportation.core.Driver;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DriverRegisterController {
    Registration register = new DriverRegister();

    @PostMapping("/driverRegister/{userName}/{email}/{phoneNo}/{drivingLicense}/{nationalId}/{password}")
    public boolean Register(@PathVariable String userName, @PathVariable String email,
                            @PathVariable String phoneNo, @PathVariable String drivingLicense,
                            @PathVariable String nationalId, @PathVariable String password) {
        IUser driver=new Driver(userName,password,drivingLicense,nationalId,phoneNo,email);
        return register.Register(driver);
    }

    @PostMapping("/driverLogin/{userName}/{password}")
    public boolean login( @PathVariable String userName,@PathVariable String password) {
        IUser iuser= register.isaving.searchIUser(userName,password);
        return  register.login(iuser);
    }
}
