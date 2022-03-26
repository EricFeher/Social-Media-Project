package com.example.sociallobster.Controller;

import com.example.sociallobster.Model.School;
import com.example.sociallobster.Repository.SchoolRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/school")
public class SchoolController {

    @Autowired
    SchoolRepository schoolRepository;

    @PostMapping("/save")
    public ResponseEntity<String> SaveSchool(@RequestBody School school){
        try{
            schoolRepository.save(school);
        }
        catch (Exception e){
            return new ResponseEntity<String>("Not inserted", HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<String>("Successfully inserted", HttpStatus.OK);
    }

    @GetMapping("/select")
    public ResponseEntity<List<School>> getSchool() {
        List<School> list = null;
        try {
            list = schoolRepository.findAll();
        } catch (Exception e) {
            return new ResponseEntity<List<School>>(list, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<List<School>>(list, HttpStatus.OK);
    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteSchool(@PathVariable("id") Integer id){
        try{
            schoolRepository.deleteById(id);
        }
        catch(Exception e){
            return new ResponseEntity<>("Could not delete", HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<>("Successfully deleted", HttpStatus.OK);
    }

    public String updateSchool(@RequestBody School school){
        Optional<School> temp = schoolRepository.findById(school.getId());
        School school1 = temp.get();
        school1.setLocation_id(school.getLocation_id());
        school1.setName(school.getName());
        school1.setSchool_type(school.getSchool_type());

        return "Successfully updated!";
    }
}
