package com.example.sociallobster.Controller;

import com.example.sociallobster.Model.Workplace;
import com.example.sociallobster.Repository.WorkplaceInsertRepository;
import com.example.sociallobster.Repository.WorkplaceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/workplace")
public class WorkplaceController {
    @Autowired
    WorkplaceRepository workplaceRepository;
    @Autowired
    WorkplaceInsertRepository workplaceInsertRepository;

    @PostMapping("/save")
    public void SaveWorkplace(@RequestBody Workplace workplace) throws Exception {
        try{
            workplaceInsertRepository.insertWithQuery(workplace);
        }
        catch (Exception e){
            throw new Exception("Sikertelen beillesztés!");
        }
    }

    @GetMapping("/select")
    public ResponseEntity<List<Workplace>> getWorkplace() {
        List<Workplace> list = null;
        try {
            list = workplaceRepository.findAll();
        } catch (Exception e) {
            return new ResponseEntity<List<Workplace>>(list, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<List<Workplace>>(list, HttpStatus.OK);
    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteWorkplace(@PathVariable("id") Integer id){
        try{
            workplaceRepository.deleteById(id);
        }
        catch(Exception e){
            return new ResponseEntity<>("Could not delete", HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<>("Successfully deleted", HttpStatus.OK);
    }
    @PostMapping("/update/{id}")
    public String updateWorkplace(@RequestBody Workplace workplace){
        Optional<Workplace> temp = workplaceRepository.findById(workplace.getId());
        Workplace workplace1 = temp.get();
        workplace1.setLocation_id(workplace.getLocation_id());
        workplace1.setName(workplace.getName());
        workplace1.setWorkplace_type(workplace.getWorkplace_type());
        workplaceRepository.save(workplace1);

        return "Successfully updated!";
    }
}
