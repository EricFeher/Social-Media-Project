package com.example.sociallobster.Controller;


import com.example.sociallobster.Model.Photos;
import com.example.sociallobster.Repository.PhotosRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "/api/photos")
public class PhotosController {

    @Autowired
    private PhotosRepository photosRepository;

    @PostMapping("/save")
    public ResponseEntity<String> SavePhotos(@RequestBody Photos photos){
        try{
            photosRepository.save(photos);
        }
        catch (Exception e){
            return new ResponseEntity<String>("Not inserted", HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<String>("Successfully inserted", HttpStatus.OK);
    }

    @GetMapping("/select")
    public ResponseEntity<List<Photos>> getPhotos() {
        List<Photos> list = null;
        try {
            list = photosRepository.findAll();
        } catch (Exception e) {
            return new ResponseEntity<List<Photos>>(list, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<List<Photos>>(list, HttpStatus.OK);
    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deletePhotos(@PathVariable("id") Integer id){
        try{
            photosRepository.deleteById(id);
        }
        catch(Exception e){
            return new ResponseEntity<>("Could not delete", HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<>("Successfully deleted", HttpStatus.OK);
    }

    public String updatePhotos(@RequestBody Photos photos){
        Optional<Photos> temp = photosRepository.findById(photos.getId());
        Photos photos1 = temp.get();
        photos1.setUser_id(photos.getUser_id());
        photos1.setPhoto(photos.getPhoto());
        photosRepository.save(photos1);

        return "Successfully updated!";
    }
}
