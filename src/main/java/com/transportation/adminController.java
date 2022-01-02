package com.transportation;
import com.transportation.application.IUser;
import com.transportation.core.*;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
@RestController
public class adminController {
        admin admin;

        public adminController(){
            admin=new admin();
        }

        @PostMapping("/addDiscount")
        public boolean addDiscount(@RequestBody Area area){
           return admin.addDiscount(area);
        }

        @GetMapping("/showEvents")
        public ArrayList<String> showEvents(@RequestBody RideRequest req)
        {
           return admin.showEvents(req);
        }

        @PutMapping("/suspendUser")
        public boolean suspend( @RequestBody User user) {
            return admin.suspend(user);
        }
        @PutMapping("/suspendDriver")
        public boolean suspend( @RequestBody Driver driver) {
            return admin.suspend(driver);
        }
        @PutMapping("/verify/{name}/{password}")
        public boolean verify(@PathVariable String name,@PathVariable String password) {
            IUser driver= admin.saving.searchPended(name,password);
            if(driver==null){
                return false;
            }

            return admin.verify(driver);
        }

        @GetMapping("/list")
        public ArrayList<IUser> listPendingRegistration() {
             return admin.listPendingRegistration();
        }

        @PostMapping("/loginAdmin")
        public boolean loginAdmin( @RequestBody IUser iuser) {
           return admin.loginAdmin(iuser);
    }
}
