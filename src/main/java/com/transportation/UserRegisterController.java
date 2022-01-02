package com.transportation;

import com.transportation.application.IUser;
import com.transportation.application.Registration;
import com.transportation.application.UserRegister;
import com.transportation.core.User;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
public class UserRegisterController {
    Registration userRegister = new UserRegister();

    @PostMapping("/RegisterUser")
    public boolean Register( @RequestBody User iuser ) {
       return userRegister.Register(iuser);
    }
    public static class PersonContext{
        public String userName;
        public String password;
        PersonContext(String userName,String password){
            this.password=password;
            this.userName=userName;
        }
    }
    @PostMapping("/loginUser")
    public boolean login(@RequestBody PersonContext userData) {
        IUser iuser= userRegister.isaving.searchIUser(userData.userName,userData.password);
        return  userRegister.login(iuser);
    }
}
