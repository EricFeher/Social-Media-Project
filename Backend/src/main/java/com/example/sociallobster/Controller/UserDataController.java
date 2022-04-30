package com.example.sociallobster.Controller;


import com.example.sociallobster.Model.User;
import com.example.sociallobster.Model.UserData;
import com.example.sociallobster.Repository.UserDataInsertRepository;
import com.example.sociallobster.Repository.UserDataRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/userdata")
public class UserDataController {

    @Autowired
    private UserDataRepository userDataRepository;
    @Autowired
    private UserDataInsertRepository userDataInsertRepository;

    @PostMapping("/save")
    public void SaveUserData(@RequestBody UserData userData) throws Exception {
        try{
            userDataInsertRepository.insertWithQuery(userData);
        }
        catch (Exception e){
            throw new Exception("Sikertelen beillesztés!");
        }
    }

    @GetMapping("/select")
    public ResponseEntity<List<UserData>> getUserData() {
        List<UserData> list = null;
        try {
            list = userDataRepository.findAll();
        } catch (Exception e) {
            return new ResponseEntity<List<UserData>>(list, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<List<UserData>>(list, HttpStatus.OK);
    }

    @GetMapping("/selectUsersWhereFollower")
    public ResponseEntity<List<UserData>> getUserDataWithQuery() {
        List<UserData> list = null;
        try {
            list = userDataInsertRepository.getUsersWhereFollower();
        } catch (Exception e){
            return new ResponseEntity<List<UserData>>(list, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<List<UserData>>(list, HttpStatus.OK);
    }

    @GetMapping("/getUserDataForUser/{id}")
    public ResponseEntity<List<UserData>> getUserDataForUser(@PathVariable("id") Integer id) {
        List<UserData> userData = new ArrayList<>();
        try {
            userData = userDataInsertRepository.getUserDataForUser(id);
            return new ResponseEntity<List<UserData>>(userData, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<List<UserData>>(userData, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteUserData(@PathVariable("id") Integer id){
        try{
            userDataRepository.deleteById(id);
        }
        catch(Exception e){
            return new ResponseEntity<>("Could not delete", HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<>("Successfully deleted", HttpStatus.OK);
    }

    public String updateUserData(@RequestBody UserData userData){
        Optional<UserData> temp = userDataRepository.findById(userData.getId());
        UserData userData1 = temp.get();
        userData1.setUser_id(userData.getUser_id());
        userData1.setLocation_id(userData.getLocation_id());
        userData1.setPhoto_id(userData.getPhoto_id());
        userData1.setFirst_name(userData.getFirst_name());
        userData1.setLast_name(userData.getLast_name());
        userData1.setGender(userData.getGender());
        userData1.setBirthday(userData.getBirthday());
        userDataRepository.save(userData1);

        return "Successfully updated!";
    }
}
