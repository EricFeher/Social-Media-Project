package com.example.sociallobster.Controller;


import com.example.sociallobster.Model.Location;
import com.example.sociallobster.Repository.LocationInsertRepository;
import com.example.sociallobster.Repository.LocationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path="/api/location")
public class LocationController {

    @Autowired
    private LocationRepository locationRepository;
    @Autowired
    private LocationInsertRepository locationInsertRepository;

    @PostMapping("/save")
    public void SaveLocation(@RequestBody Location location) throws Exception {
        try{
            locationInsertRepository.insertWithQuery(location);
        }
        catch (Exception e){
            throw new Exception("Sikertelen beillesztés!");
        }
    }

    @GetMapping("/select")
    public ResponseEntity<List<Location>> getLocation() {
        List<Location> list = null;
        try {
            list = locationRepository.findAll();
        } catch (Exception e) {
            return new ResponseEntity<List<Location>>(list, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<List<Location>>(list, HttpStatus.OK);
    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteLocation(@PathVariable("id") Integer id){
        try{
            locationRepository.deleteById(id);
        }
        catch(Exception e){
            return new ResponseEntity<>("Could not delete", HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<>("Successfully deleted", HttpStatus.OK);
    }

    public String updateLocation(@RequestBody Location location){
        Optional<Location> temp = locationRepository.findById(location.getId());
        Location location1 = temp.get();
        location1.setPostcode(location.getPostcode());
        location1.setCity(location.getCity());
        location1.setStreet(location.getStreet());
        location1.setHousenumber(location.getHousenumber());
        locationRepository.save(location1);
        return "Successfully updated!";
    }

}
