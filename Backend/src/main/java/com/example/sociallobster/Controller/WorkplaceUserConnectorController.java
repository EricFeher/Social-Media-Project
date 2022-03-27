package com.example.sociallobster.Controller;

import com.example.sociallobster.Model.WorkplaceUserConnector;
import com.example.sociallobster.Repository.WorkplaceUserConnectorReopisotry;
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
    WorkplaceUserConnectorReopisotry workplaceUserConnectorReopisotry;

    @PostMapping("/save")
    public ResponseEntity<String> SaveWorkplaceUserConnector(@RequestBody WorkplaceUserConnector workplace){
        try{
            workplaceUserConnectorReopisotry.save(workplace);
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
            list = workplaceUserConnectorReopisotry.findAll();
        } catch (Exception e) {
            return new ResponseEntity<List<WorkplaceUserConnector>>(list, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<List<WorkplaceUserConnector>>(list, HttpStatus.OK);
    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteWorkplaceUserConnector(@PathVariable("id") Integer id){
        try{
            workplaceUserConnectorReopisotry.deleteById(id);
        }
        catch(Exception e){
            return new ResponseEntity<>("Could not delete", HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<>("Successfully deleted", HttpStatus.OK);
    }

    public String updateWorkplaceUserConnector(@RequestBody WorkplaceUserConnector workplaceUserConnector){
        Optional<WorkplaceUserConnector> temp = workplaceUserConnectorReopisotry.findById(workplaceUserConnector.getId());
        WorkplaceUserConnector workplaceUserConnector1 = temp.get();
        workplaceUserConnector1.setUser_id(workplaceUserConnector.getUser_id());
        workplaceUserConnector1.setWorkplace_id(workplaceUserConnector.getWorkplace_id());

        return "Successfully updated!";
    }
}
