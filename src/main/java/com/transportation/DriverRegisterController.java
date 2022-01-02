package com.transportation;

import com.transportation.application.DriverRegister;
import com.transportation.application.IUser;
import com.transportation.application.Registration;
import com.transportation.core.Driver;
import com.transportation.core.User;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DriverRegisterController {
    Registration register = new DriverRegister();
    public static class PersonContext{
        public String userName;
        public String password;
        PersonContext(String userName,String password){
            this.password=password;
            this.userName=userName;
        }
    }
    @PostMapping("/driverRegister")
    public boolean Register( @RequestBody Driver iuser ) {
        return register.Register(iuser);
    }
    @PostMapping("/driverLogin")
    public boolean login(@RequestBody PersonContext userData) {
        IUser iuser= register.isaving.searchIUser(userData.userName,userData.password);
        return  register.login(iuser);
    }

}
