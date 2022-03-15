package Controller;

import Model.User;
import Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping(path = "/api/user", produces = MediaType.APPLICATION_JSON_VALUE)
public class UserController {

    @Autowired
    UserRepository userRepository;
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
}
