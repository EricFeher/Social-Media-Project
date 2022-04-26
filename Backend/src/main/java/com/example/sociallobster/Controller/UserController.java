package com.example.sociallobster.Controller;


import com.example.sociallobster.Model.User;
import com.example.sociallobster.Repository.UserInsertRepository;
import com.example.sociallobster.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "/api/user")
public class UserController {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    UserInsertRepository userInsertRepository;


    @PostMapping("/save")
    public void SaveUser(@RequestBody User user) throws Exception {
        try{
            userInsertRepository.insertWithQuery(user);
        }
        catch (Exception e){
            throw new Exception("Sikertelen beillesztés!");
        }
    }

    @GetMapping("/select")
    public ResponseEntity<List<User>> getUser() {
        List<User> list = null;
        try {
            list = userRepository.findAll();
        } catch (Exception e) {
            return new ResponseEntity<List<User>>(list, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<List<User>>(list, HttpStatus.OK);
    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteUser(@PathVariable("id") Integer id){
        try{
            userRepository.deleteById(id);
        }
        catch(Exception e){
            return new ResponseEntity<>("Could not delete", HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<>("Successfully deleted", HttpStatus.OK);
    }

    public String updateUser(@RequestBody User user){
        Optional<User> temp = userRepository.findById(user.getId());
        User user1 = temp.get();
        user1.setUsername(user.getUsername());
        user1.setEmail(user.getEmail());
        user1.setPassword(user.getPassword());
        userRepository.save(user1);

        return "Successfully updated!";
    }
}
