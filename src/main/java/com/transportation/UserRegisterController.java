package com.transportation;

import com.transportation.application.IUser;
import com.transportation.application.Registration;
import com.transportation.application.UserRegister;
import com.transportation.core.User;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserRegisterController {
    Registration userRegister = new UserRegister();

    @PostMapping("/RegisterUser")
    public boolean Register( @RequestBody User iuser) {
       return userRegister.Register(iuser);
    }

    @PostMapping("/loginUser")
    public boolean login( @RequestBody User iuser) {
        return  userRegister.login(iuser);
    }
}
