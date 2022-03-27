package com.example.sociallobster.Controller;


import com.example.sociallobster.Model.CommentsLikes;
import com.example.sociallobster.Repository.CommentsLikesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/commentslikes")
public class CommentsLikesController {

    @Autowired
    CommentsLikesRepository commentsLikesRepository;

    @PostMapping("/save")
    public ResponseEntity<String> SaveCommentsLikes(@RequestBody CommentsLikes commentsLikes) {
        try{
            commentsLikesRepository.save(commentsLikes);
        }
        catch (Exception e){
            return new ResponseEntity<String>("Not inserted", HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<String>("Successfully inserted", HttpStatus.OK);
    }

    @GetMapping("/select")
    public ResponseEntity<List<CommentsLikes>> getCommentsLikes() {
        List<CommentsLikes> list = null;
        try {
            list = commentsLikesRepository.findAll();
        } catch (Exception e) {
            return new ResponseEntity<List<CommentsLikes>>(list, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<List<CommentsLikes>>(list, HttpStatus.OK);
    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteCommentsLikes(@PathVariable("id") Integer id){
        try{
            commentsLikesRepository.deleteById(id);
        }
        catch(Exception e){
            return new ResponseEntity<>("Could not delete", HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<>("Successfully deleted", HttpStatus.OK);
    }

    public String updateCommentsLikes(@RequestBody CommentsLikes commentsLikes){
        Optional<CommentsLikes> temp = commentsLikesRepository.findById(commentsLikes.getId());
        CommentsLikes commentsLikes1 = temp.get();
        commentsLikes1.setUser_id(commentsLikes.getUser_id());
        commentsLikes1.setComment_id(commentsLikes.getComment_id());

        return "Successfully updated!";
    }
}
