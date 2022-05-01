package com.example.sociallobster.Controller;

import com.example.sociallobster.Model.Groups;
import com.example.sociallobster.Model.User;
import com.example.sociallobster.Repository.GroupsInsertRepository;
import com.example.sociallobster.Repository.GroupsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/groups")
public class GroupsController {

    @Autowired
    GroupsRepository groupsRepository;
    @Autowired
    GroupsInsertRepository groupsInsertRepository;

    @PostMapping("/save")
    public void SaveGroups(@RequestBody Groups groups) throws Exception {
        try{
            groupsInsertRepository.insertWithQuery(groups);
        }
        catch (Exception e){
            throw new Exception("Sikertelen beillesztés!");
        }
    }

    @GetMapping("/select")
    public ResponseEntity<List<Groups>> getGroups() {
        List<Groups> list = null;
        try {
            list = groupsRepository.findAll();
        } catch (Exception e) {
            return new ResponseEntity<List<Groups>>(list, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<List<Groups>>(list, HttpStatus.OK);
    }

    @GetMapping("/selectGroupMembers/{id}")
    public ResponseEntity<List<BigDecimal>> getUsersWhereFollower(@PathVariable("id") Integer id) {
        List<BigDecimal> db = new ArrayList<>();
        try {
            db = groupsInsertRepository.getGroupMembersCount(id);
            return new ResponseEntity<List<BigDecimal>>(db, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<List<BigDecimal>>(db, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/getGroupAdminUser/{id}")
    public ResponseEntity<List<User>> getGroupAdminUser(@PathVariable("id") Integer id) {
        List<User> admin = new ArrayList<>();
        try {
            admin = groupsInsertRepository.getGroupAdminUser(id);
            return new ResponseEntity<List<User>>(admin, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<List<User>>(admin, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteGroups(@PathVariable("id") Integer id){
        try{
            groupsRepository.deleteById(id);
        }
        catch(Exception e){
            return new ResponseEntity<>("Could not delete", HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<>("Successfully deleted", HttpStatus.OK);
    }
    @PostMapping("/update/{id}")
    public String updateGroups(@RequestBody Groups groups){
        Optional<Groups> temp = groupsRepository.findById(groups.getId());
        Groups groups1 = temp.get();
        groups1.setName(groups.getName());
        groups1.setDescription(groups.getDescription());
        groupsRepository.save(groups1);

        return "Successfully updated!";
    }
}
