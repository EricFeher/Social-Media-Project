package com.example.sociallobster.Controller;

import com.example.sociallobster.Model.Follows;
import com.example.sociallobster.Model.UserData;
import com.example.sociallobster.Repository.FollowsInsertRepository;
import com.example.sociallobster.Repository.FollowsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/follows")
public class FollowsController {

    @Autowired
    FollowsRepository followsRepository;
    @Autowired
    FollowsInsertRepository followsInsertRepository;


    @PostMapping("/save")
    public void SaveFollows(@RequestBody Follows follows) throws Exception{
        try{
            followsInsertRepository.insertWithQuery(follows);
        }
        catch (Exception e){
            throw new Exception("Sikertelen beillesztés!");
        }
    }

    @GetMapping("/getFollowsByUserId1/{id}")
    public ResponseEntity<List<BigDecimal>> getFollowsByUserId1(@PathVariable("id") Integer id) {
        List<BigDecimal> db = new ArrayList<>();
        try {
           db = followsInsertRepository.getFollowsByUserId1(id);
            return new ResponseEntity<List<BigDecimal>>(db, HttpStatus.OK);
        } catch (Exception e){
            return new ResponseEntity<List<BigDecimal>>(db, HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }

    @GetMapping("/getFollowsByUserId2/{id}")
    public ResponseEntity<List<BigDecimal>> getFollowsByUserId2(@PathVariable("id") Integer id) {
        List<BigDecimal> db = new ArrayList<>();
        try {
            db = followsInsertRepository.getFollowsByUserId2(id);
            return new ResponseEntity<List<BigDecimal>>(db, HttpStatus.OK);
        } catch (Exception e){
            return new ResponseEntity<List<BigDecimal>>(db, HttpStatus.INTERNAL_SERVER_ERROR);
        }

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
    @PostMapping("/update/{id}")
    public String updateFollows(@RequestBody Follows follows){
        Optional<Follows> temp = followsRepository.findById(follows.getId());
        Follows follows1 = temp.get();
        follows1.setUser_id1(follows.getUser_id1());
        follows1.setUser_id2(follows.getUser_id2());
        followsRepository.save(follows1);

        return "Successfully updated!";
    }
}
