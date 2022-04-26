package com.example.sociallobster.Controller;

import com.example.sociallobster.Model.Message;
import com.example.sociallobster.Repository.MessageInsertRepository;
import com.example.sociallobster.Repository.MessageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/message")
public class MessageController {

    @Autowired
    MessageRepository messageRepository;
    @Autowired
    MessageInsertRepository messageInsertRepository;

    @PostMapping("/save")
    public void SaveMessage(@RequestBody Message message) throws Exception {
        try{
            messageInsertRepository.insertWithQuery(message);
        }
        catch (Exception e){
            throw new Exception("Sikertelen beillesztés!");
        }
    }

    @GetMapping("/select")
    public ResponseEntity<List<Message>> getMessage() {
        List<Message> list = null;
        try {
            list = messageRepository.findAll();
        } catch (Exception e) {
            return new ResponseEntity<List<Message>>(list, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<List<Message>>(list, HttpStatus.OK);
    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteMessage(@PathVariable("id") Integer id){
        try{
            messageRepository.deleteById(id);
        }
        catch(Exception e){
            return new ResponseEntity<>("Could not delete", HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<>("Successfully deleted", HttpStatus.OK);
    }

    public String updateMessage(@RequestBody Message message){
        Optional<Message> temp = messageRepository.findById(message.getId());
        Message message1 = temp.get();
        message1.setUser_id1(message.getUser_id1());
        message1.setUser_id2(message.getUser_id2());
        message1.setContent(message.getContent());
        message1.setCreation_time(message.getCreation_time());
        messageRepository.save(message1);

        return "Successfully updated!";
    }
}
