package com.example.sociallobster.Repository;

import com.example.sociallobster.Model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RegisterRepository extends JpaRepository<User, Integer> {
   public User findByEmail(String email);
   public User findByEmailAndPassword(String email, String password);
}
