package com.example.sociallobster.Repository;

import com.example.sociallobster.Model.User;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Repository
public class UserInsertRepository {

    @PersistenceContext
    private EntityManager entityManager;

    @Transactional
    public void insertWithQuery(User user) {
        entityManager.createNativeQuery("INSERT INTO ENDUSER (username, password, email) VALUES (?,?,?)")
                .setParameter(1, user.getUsername())
                .setParameter(2, user.getPassword())
                .setParameter(3, user.getEmail())
                .executeUpdate();
    }
}
