package com.example.sociallobster.Controller;

import com.example.sociallobster.Model.School;
import com.example.sociallobster.Repository.SchoolInsertRepository;
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
    @Autowired
    SchoolInsertRepository schoolInsertRepository;

    @PostMapping("/save")
    public void SaveSchool(@RequestBody School school) throws Exception {
        try{
            schoolInsertRepository.insertWithQuery(school);
        }
        catch (Exception e){
            throw new Exception("Sikertelen beillesztés!");
        }

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
    @PostMapping("/update/{id}")
    public String updateSchool(@RequestBody School school){
        Optional<School> temp = schoolRepository.findById(school.getId());
        School school1 = temp.get();
        school1.setLocation_id(school.getLocation_id());
        school1.setName(school.getName());
        school1.setSchool_type(school.getSchool_type());
        schoolRepository.save(school1);

        return "Successfully updated!";
    }
}
