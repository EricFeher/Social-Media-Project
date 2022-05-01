package com.example.sociallobster.Controller;

import com.example.sociallobster.Model.Post;
import com.example.sociallobster.Repository.PostInsertRepository;
import com.example.sociallobster.Repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Repository
@RequestMapping("/api/post")
public class PostController {

    @Autowired
    PostRepository postRepository;
    @Autowired
    PostInsertRepository postInsertRepository;

    @PostMapping("/save")
    public void SavePost(@RequestBody Post post) throws Exception {
        try{
            postInsertRepository.insertWithQuery(post);
        }
        catch (Exception e){
            throw new Exception("Sikertelen beillesztés!");
        }
    }

    @GetMapping("/select")
    public ResponseEntity<List<Post>> getPost() {
        List<Post> list = null;
        try {
            list = postRepository.findAll();
        } catch (Exception e) {
            return new ResponseEntity<List<Post>>(list, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<List<Post>>(list, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deletePost(@PathVariable("id") Integer id){
        try{
            postRepository.deleteById(id);
        }
        catch(Exception e){
            return new ResponseEntity<>("Could not delete", HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<>("Successfully deleted", HttpStatus.OK);
    }
    @PostMapping("/update/{id}")
    public String updatePost(@RequestBody Post post){
        Optional<Post> temp = postRepository.findById(post.getId());
        Post post1 = temp.get();
        post1.setUser_id(post.getUser_id());
        post1.setContent(post.getContent());
        post1.setCreation_time(post.getCreation_time());
        postRepository.save(post1);
        return "Successfully updated!";
    }

}
