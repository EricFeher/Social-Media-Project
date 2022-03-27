package com.example.sociallobster.Controller;


import com.example.sociallobster.Model.PostLikes;
import com.example.sociallobster.Repository.PostLikesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Repository
@RequestMapping("/api/postlikes")
public class PostLikesController {

    @Autowired
    PostLikesRepository postLikesRepository;

    @PostMapping("/save")
    public ResponseEntity<String> SavePostLikes(@RequestBody PostLikes postLikes){
        try{
            postLikesRepository.save(postLikes);
        }
        catch (Exception e){
            return new ResponseEntity<String>("Not inserted", HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<String>("Successfully inserted", HttpStatus.OK);
    }

    @GetMapping("/select")
    public ResponseEntity<List<PostLikes>> getPostLikes() {
        List<PostLikes> list = null;
        try {
            list = postLikesRepository.findAll();
        } catch (Exception e) {
            return new ResponseEntity<List<PostLikes>>(list, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<List<PostLikes>>(list, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deletePostLikes(@PathVariable("id") Integer id){
        try{
            postLikesRepository.deleteById(id);
        }
        catch(Exception e){
            return new ResponseEntity<>("Could not delete", HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<>("Successfully deleted", HttpStatus.OK);
    }

    public String updatePostLikes(@RequestBody PostLikes postLikes){
        Optional<PostLikes> temp = postLikesRepository.findById(postLikes.getId());
        PostLikes postLikes1 = temp.get();
        postLikes1.setUser_id(postLikes.getUser_id());
        postLikes1.setPost_id(postLikes.getPost_id());
        postLikesRepository.save(postLikes1);

        return "Successfully updated!";
    }

}
