package com.example.sociallobster.Controller;

import com.example.sociallobster.Model.User;
import com.example.sociallobster.Service.RegisterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class RegisterController {
    @Autowired
    private RegisterService service;

    @PostMapping("/registeruser")
    //@CrossOrigin(origins = "http://localhost:4200")
    public User registerUser(@RequestBody User user) throws Exception {
        String tempEmail = user.getEmail();
        if (tempEmail != null && !"".equals(tempEmail)){
            User userobj = service.fetchUserByEmail(tempEmail);
            if (userobj != null){
                throw new Exception("Létezik már felhasználó ezzel az emailel: "+tempEmail);
            }
        }
        User userObj = null;
        userObj = service.saveUser(user);
        return userObj;
    }
    @PostMapping("/login")
    //@CrossOrigin(origins = "http://localhost:4200")
    public User loginUser(@RequestBody User user) throws Exception {
        String tempEmail = user.getEmail();
        String tempPass = user.getPassword();
        User userObj = null;
        if(tempEmail != null && tempPass != null){
            userObj = service.fetchUserByEmailAndPassword(tempEmail,tempPass);
        }
        if(userObj == null){
            throw new Exception("Nem megfelelő adatok, vagy a felhasználó nem létezik!");
        }
        return userObj;


    }

}
