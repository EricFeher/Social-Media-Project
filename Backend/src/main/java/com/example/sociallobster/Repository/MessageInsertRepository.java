package com.example.sociallobster.Repository;

import com.example.sociallobster.Model.Message;
import com.example.sociallobster.Model.Photos;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Repository
public class MessageInsertRepository {
    @PersistenceContext
    private EntityManager entityManager;

    @Transactional
    public void insertWithQuery(Message message) {
        entityManager.createNativeQuery("INSERT INTO MESSAGE (user_id1, user_id2, content) VALUES (?,?,?)")
                .setParameter(1, message.getUser_id1())
                .setParameter(2, message.getUser_id2())
                .setParameter(3, message.getContent())
                .executeUpdate();
    }
}
