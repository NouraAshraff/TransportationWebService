package com.transportation;

import com.transportation.application.DriverRegister;
import com.transportation.application.IUser;
import com.transportation.application.Registration;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DriverRegisterController {
    Registration register=new DriverRegister();
    @PostMapping("/driverRegister")
    public boolean Register( @RequestBody IUser iuser) {
        return register.Register(iuser);
    }

    @PostMapping("/driverLogin")
    public boolean login(IUser iuser){
        return register.login(iuser);
    }
}
