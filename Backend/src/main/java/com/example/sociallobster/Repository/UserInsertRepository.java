package com.example.sociallobster.Repository;

import com.example.sociallobster.Model.User;
import com.example.sociallobster.Model.UserData;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

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

    public List<User> getUsersWhoWriteComment(){
        return entityManager.createNativeQuery("SELECT * FROM ENDUSER WHERE ID IN (SELECT USER_ID FROM POST)", User.class)
                .getResultList();
    }
}
