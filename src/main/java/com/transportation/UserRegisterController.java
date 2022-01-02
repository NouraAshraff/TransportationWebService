package com.transportation;

import com.transportation.application.IUser;
import com.transportation.application.Registration;
import com.transportation.application.UserRegister;
import com.transportation.core.User;
import org.springframework.web.bind.annotation.*;

@RestController
public class UserRegisterController {
    Registration userRegister = new UserRegister();

    @PostMapping("/RegisterUser/{userName}/{email}/{phoneNo}/{password}")
    public boolean Register( @PathVariable String userName,@PathVariable String email,
                             @PathVariable String phoneNo,@PathVariable String password ) {
        IUser iuser=new User(userName,password,phoneNo,email);
       return userRegister.Register(iuser);
    }

    @PostMapping("/loginUser/{userName}/{password}")
    public boolean login( @PathVariable String userName,@PathVariable String password) {
        IUser iuser= userRegister.isaving.searchIUser(userName,password);
        return  userRegister.login(iuser);
    }
}
