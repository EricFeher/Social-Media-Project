package com.example.sociallobster.Controller;

import com.example.sociallobster.Model.Groups;
import com.example.sociallobster.Repository.GroupsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/groups")
public class GroupsController {

    @Autowired
    GroupsRepository groupsRepository;

    @PostMapping("/save")
    public ResponseEntity<String> SaveGroups(@RequestBody Groups groups){
        try{
            groupsRepository.save(groups);
        }
        catch (Exception e){
            return new ResponseEntity<String>("Not inserted", HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<String>("Successfully inserted", HttpStatus.OK);
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

    public String updateUser(@RequestBody Groups groups){
        Optional<Groups> temp = groupsRepository.findById(groups.getId());
        Groups groups1 = temp.get();
        groups1.setName(groups.getName());
        groups1.setDescription(groups.getDescription());
        groupsRepository.save(groups1);

        return "Successfully updated!";
    }
}
