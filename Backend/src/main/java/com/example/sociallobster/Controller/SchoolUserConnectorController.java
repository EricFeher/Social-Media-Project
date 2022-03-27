package com.example.sociallobster.Controller;

import com.example.sociallobster.Model.SchoolUserConnector;
import com.example.sociallobster.Repository.SchoolUserConnectorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/schooluserconnector")
public class SchoolUserConnectorController {

    @Autowired
    SchoolUserConnectorRepository schoolUserConnectorRepository;

    @PostMapping("/save")
    public ResponseEntity<String> SaveSchoolUserConnector(@RequestBody SchoolUserConnector school){
        try{
            schoolUserConnectorRepository.save(school);
        }
        catch (Exception e){
            return new ResponseEntity<String>("Not inserted", HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<String>("Successfully inserted", HttpStatus.OK);
    }

    @GetMapping("/select")
    public ResponseEntity<List<SchoolUserConnector>> getSchoolUserConnector() {
        List<SchoolUserConnector> list = null;
        try {
            list = schoolUserConnectorRepository.findAll();
        } catch (Exception e) {
            return new ResponseEntity<List<SchoolUserConnector>>(list, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<List<SchoolUserConnector>>(list, HttpStatus.OK);
    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteSchoolUserConnector(@PathVariable("id") Integer id){
        try{
            schoolUserConnectorRepository.deleteById(id);
        }
        catch(Exception e){
            return new ResponseEntity<>("Could not delete", HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<>("Successfully deleted", HttpStatus.OK);
    }

    public String updateSchoolUserConncetor(@RequestBody SchoolUserConnector schoolUserConnector){
        Optional<SchoolUserConnector> temp = schoolUserConnectorRepository.findById(schoolUserConnector.getId());
        SchoolUserConnector schoolUserConnector1 = temp.get();
        schoolUserConnector1.setUser_id(schoolUserConnector.getUser_id());
        schoolUserConnector1.setSchool_id(schoolUserConnector.getSchool_id());
        schoolUserConnectorRepository.save(schoolUserConnector1);

        return "Successfully updated!";
    }
}
