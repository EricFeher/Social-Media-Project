package com.example.sociallobster.Controller;

import com.example.sociallobster.Model.GroupsAdmins;
import com.example.sociallobster.Repository.GroupsAdminsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/groupsadmins")
public class GroupsAdminsController {

    @Autowired
    GroupsAdminsRepository groupsAdminsRepository;

    @PostMapping("/save")
    public ResponseEntity<String> SaveGroupsAdmins(@RequestBody GroupsAdmins groupsAdmins){
        try{
            groupsAdminsRepository.save(groupsAdmins);
        }
        catch (Exception e){
            return new ResponseEntity<String>("Not inserted", HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<String>("Successfully inserted", HttpStatus.OK);
    }

    @GetMapping("/select")
    public ResponseEntity<List<GroupsAdmins>> getGroupsAdmins() {
        List<GroupsAdmins> list = null;
        try {
            list = groupsAdminsRepository.findAll();
        } catch (Exception e) {
            return new ResponseEntity<List<GroupsAdmins>>(list, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<List<GroupsAdmins>>(list, HttpStatus.OK);
    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteGroupsAdmins(@PathVariable("id") Integer id){
        try{
            groupsAdminsRepository.deleteById(id);
        }
        catch(Exception e){
            return new ResponseEntity<>("Could not delete", HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<>("Successfully deleted", HttpStatus.OK);
    }

    public String updateGroupsAdmins(@RequestBody GroupsAdmins groupsAdmins){
        Optional<GroupsAdmins> temp = groupsAdminsRepository.findById(groupsAdmins.getId());
        GroupsAdmins groupsAdmins1 = temp.get();
        groupsAdmins1.setUser_id(groupsAdmins.getUser_id());
        groupsAdmins1.setGroup_id(groupsAdmins.getGroup_id());
        groupsAdminsRepository.save(groupsAdmins1);

        return "Successfully updated!";
    }
}
