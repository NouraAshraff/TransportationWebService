package com.transportation;

import com.transportation.application.DriverRegister;
import com.transportation.application.IUser;
import com.transportation.application.Registration;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

public class DriverRegisterController {
    Registration register=new DriverRegister();
    @PostMapping("/driverRegister")
    public void Register( @RequestBody IUser iuser) {
        register.Register(iuser);
    }
}
