package com.transportation;
import com.transportation.application.IUser;
import com.transportation.core.Area;
import com.transportation.core.RideRequest;
import com.transportation.core.admin;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
@RestController
public class adminController {
        admin admin;

        public adminController(){
            admin=new admin();
        }

        @PostMapping("/addDiscount")
        public void addDiscount(@RequestBody Area area){
           admin.addDiscount(area);
        }

        @GetMapping("/showEvents")
        public ArrayList<String> showEvents(@RequestBody RideRequest req)
        {
           return admin.showEvents(req);
        }

        @PutMapping("/suspend")
        public boolean suspend( @RequestBody IUser user) {
           return admin.suspend(user);
        }

        @PutMapping("/verify")
        public boolean verify(@RequestBody IUser driver) {
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
