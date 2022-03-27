package com.example.sociallobster.Controller;

import com.example.sociallobster.Model.Follows;
import com.example.sociallobster.Repository.FollowsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/follows")
public class FollowsController {

    @Autowired
    FollowsRepository followsRepository;

    @PostMapping("/save")
    public ResponseEntity<String> SaveFollows(@RequestBody Follows follows){
        try{
            followsRepository.save(follows);
        }
        catch (Exception e){
            return new ResponseEntity<String>("Not inserted", HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<String>("Successfully inserted", HttpStatus.OK);
    }

    @GetMapping("/select")
    public ResponseEntity<List<Follows>> getFollows() {
        List<Follows> list = null;
        try {
            list = followsRepository.findAll();
        } catch (Exception e) {
            return new ResponseEntity<List<Follows>>(list, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<List<Follows>>(list, HttpStatus.OK);
    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteFollows(@PathVariable("id") Integer id){
        try{
            followsRepository.deleteById(id);
        }
        catch(Exception e){
            return new ResponseEntity<>("Could not delete", HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<>("Successfully deleted", HttpStatus.OK);
    }

    public String updateFollows(@RequestBody Follows follows){
        Optional<Follows> temp = followsRepository.findById(follows.getId());
        Follows follows1 = temp.get();
        follows1.setUser_id1(follows.getUser_id1());
        follows1.setUser_id2(follows.getUser_id2());
        followsRepository.save(follows1);

        return "Successfully updated!";
    }
}
