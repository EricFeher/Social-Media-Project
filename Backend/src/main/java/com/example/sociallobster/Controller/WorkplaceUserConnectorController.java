package com.example.sociallobster.Controller;

import com.example.sociallobster.Model.WorkplaceUserConnector;
import com.example.sociallobster.Repository.WorkplaceUserConnectorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/workplaceusercontroller")
public class WorkplaceUserConnectorController {

    @Autowired
    WorkplaceUserConnectorRepository workplaceUserConnectorRepository;

    @PostMapping("/save")
    public ResponseEntity<String> SaveWorkplaceUserConnector(@RequestBody WorkplaceUserConnector workplace){
        try{
            workplaceUserConnectorRepository.save(workplace);
        }
        catch (Exception e){
            return new ResponseEntity<String>("Not inserted", HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<String>("Successfully inserted", HttpStatus.OK);
    }

    @GetMapping("/select")
    public ResponseEntity<List<WorkplaceUserConnector>> getWorkplaceUserConnector() {
        List<WorkplaceUserConnector> list = null;
        try {
            list = workplaceUserConnectorRepository.findAll();
        } catch (Exception e) {
            return new ResponseEntity<List<WorkplaceUserConnector>>(list, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<List<WorkplaceUserConnector>>(list, HttpStatus.OK);
    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteWorkplaceUserConnector(@PathVariable("id") Integer id){
        try{
            workplaceUserConnectorRepository.deleteById(id);
        }
        catch(Exception e){
            return new ResponseEntity<>("Could not delete", HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<>("Successfully deleted", HttpStatus.OK);
    }
    @PostMapping("/update/{id}")
    public String updateWorkplaceUserConnector(@RequestBody WorkplaceUserConnector workplaceUserConnector){
        Optional<WorkplaceUserConnector> temp = workplaceUserConnectorRepository.findById(workplaceUserConnector.getId());
        WorkplaceUserConnector workplaceUserConnector1 = temp.get();
        workplaceUserConnector1.setUser_id(workplaceUserConnector.getUser_id());
        workplaceUserConnector1.setWorkplace_id(workplaceUserConnector.getWorkplace_id());
        workplaceUserConnectorRepository.save(workplaceUserConnector1);
        return "Successfully updated!";
    }
}
