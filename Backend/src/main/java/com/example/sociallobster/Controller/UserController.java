package com.example.sociallobster.Controller;

import com.example.sociallobster.Model.User;
import com.example.sociallobster.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "/api/user")
public class UserController {
    //
    @Autowired
    private UserRepository userRepository;

    @PostMapping("/save")
    public ResponseEntity<String> SaveUser(@RequestBody User user){
        try{
            userRepository.save(user);
        }
        catch (Exception e){
            return new ResponseEntity<String>("Not inserted", HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<String>("Successfully inserted", HttpStatus.OK);
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

    //
    /*
    @PostMapping("/")
    public User postUser(@Valid @RequestBody User user){
        return userRepository.saveAndFlush(user);
    }


    @GetMapping("/all")
    public List<User> getUsers(){
        return userRepository.findAll();
    }

    @GetMapping("/{id}")
    public User getUserById(@PathVariable("id") Long id){
        User user= userRepository.findById(id).get();
        return user;
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteUser(@PathVariable("id") Long id){
        userRepository.deleteById(id);
        return ResponseEntity.ok().build();
    }

    @PutMapping("/{id}/address")
    public User updateUser(@PathVariable("id") Long id, @Valid @RequestBody User User){
        User dbUser =  userRepository.findById(id).get();
        dbUser.setUsername(User.getUsername());
        dbUser.setPassword(User.getPassword());
        dbUser.setEmail(User.getEmail());
        return userRepository.save(dbUser);
    }

     */
}
