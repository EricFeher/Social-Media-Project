package com.example.sociallobster.Controller;


import com.example.sociallobster.Model.Comments;
import com.example.sociallobster.Model.User;
import com.example.sociallobster.Repository.CommentsInsertRepository;
import com.example.sociallobster.Repository.CommentsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/comments")
public class CommentsController {

    @Autowired
    CommentsRepository commentsRepository;
    @Autowired
    CommentsInsertRepository commentsInsertRepository;

    @PostMapping("/save")
    public void SaveComments(@RequestBody Comments comments) throws Exception {
        try{
            commentsInsertRepository.insertWithQuery(comments);
        }
        catch (Exception e){
           throw new Exception("Sikertelen beillesztés!");
        }
    }

    @GetMapping("/select")
    public ResponseEntity<List<Comments>> getComments() {
        List<Comments> list = null;
        try {
            list = commentsRepository.findAll();
        } catch (Exception e) {
            return new ResponseEntity<List<Comments>>(list, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<List<Comments>>(list, HttpStatus.OK);
    }

    @GetMapping("/getCommentsFromPost/{id}")
    public ResponseEntity<List> getCommentsFromPost(@PathVariable("id") Integer id) {
        List list = new ArrayList();
        try {
            list = commentsInsertRepository.getCommentsFromPost(id);
            return new ResponseEntity<List>(list, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<List>(list, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/getUserForComment/{id}")
    public ResponseEntity<List> getUserForComment(@PathVariable("id") Integer id) {
        List list = new ArrayList();
        try {
            list = commentsInsertRepository.getUserForComment(id);
            return new ResponseEntity<List>(list, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<List>(list, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteComments(@PathVariable("id") Integer id){
        try{
            commentsRepository.deleteById(id);
        }
        catch(Exception e){
            return new ResponseEntity<>("Could not delete", HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<>("Successfully deleted", HttpStatus.OK);
    }
    @PostMapping("/update/{id}")
    public String updateComments(@RequestBody Comments comments){
        Optional<Comments> temp = commentsRepository.findById(comments.getId());
        Comments comments1 = temp.get();
        comments1.setUser_id(comments.getUser_id());
        comments1.setPost_id(comments.getPost_id());
        comments1.setContent(comments.getContent());
        comments1.setCreation_time(comments.getCreation_time());
        commentsRepository.save(comments1);
        return "Successfully updated!";
    }

}
