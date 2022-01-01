package com.transportation;

import com.transportation.application.IUser;
import com.transportation.application.Registration;
import com.transportation.application.UserRegister;
import com.transportation.core.User;
import org.springframework.web.bind.annotation.PostMapping;

public class UserRegisterController {
    Registration userRegister = new UserRegister();

    @PostMapping("RegisterUser")
    public boolean Register(IUser iuser) {
       return userRegister.Register(iuser);
    }

    @PostMapping("loginUser")
    public boolean login(IUser iuser) {
        return  userRegister.login(iuser);
    }
}
