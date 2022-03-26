package com.example.sociallobster.Service;


import com.example.sociallobster.Model.User;
import com.example.sociallobster.Repository.RegisterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RegisterService {

    @Autowired
    private RegisterRepository repo;

    public User saveUser(User user){
       return repo.save(user);
    }

    public User fetchUserByEmail(String email){
        return repo.findByEmail(email);
    }

    public User fetchUserByEmailAndPassword(String email, String password){
        return repo.findByEmailAndPassword(email,password);
    }
}
