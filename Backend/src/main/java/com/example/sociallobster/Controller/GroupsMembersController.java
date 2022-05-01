package com.example.sociallobster.Controller;

import com.example.sociallobster.Model.GroupsMembers;
import com.example.sociallobster.Repository.GroupsMembersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/groupsmembers")
public class GroupsMembersController {

    @Autowired
    GroupsMembersRepository groupsMembersRepository;

    @PostMapping("/save")
    public ResponseEntity<String> SaveGroupsMembers(@RequestBody GroupsMembers groupsMembers){
        try{
            groupsMembersRepository.save(groupsMembers);
        }
        catch (Exception e){
            return new ResponseEntity<String>("Not inserted", HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<String>("Successfully inserted", HttpStatus.OK);
    }

    @GetMapping("/select")
    public ResponseEntity<List<GroupsMembers>> getGroupsMembers() {
        List<GroupsMembers> list = null;
        try {
            list = groupsMembersRepository.findAll();
        } catch (Exception e) {
            return new ResponseEntity<List<GroupsMembers>>(list, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<List<GroupsMembers>>(list, HttpStatus.OK);
    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteGroupsMembers(@PathVariable("id") Integer id){
        try{
            groupsMembersRepository.deleteById(id);
        }
        catch(Exception e){
            return new ResponseEntity<>("Could not delete", HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<>("Successfully deleted", HttpStatus.OK);
    }
    @PostMapping("/update/{id}")
    public String updateGroupsMembers(@RequestBody GroupsMembers groupsMembers){
        Optional<GroupsMembers> temp = groupsMembersRepository.findById(groupsMembers.getId());
        GroupsMembers groupsMembers1 = temp.get();
        groupsMembers1.setUser_id(groupsMembers.getUser_id());
        groupsMembers1.setGroup_id(groupsMembers.getGroup_id());
        groupsMembersRepository.save(groupsMembers1);

        return "Successfully updated!";
    }
}
