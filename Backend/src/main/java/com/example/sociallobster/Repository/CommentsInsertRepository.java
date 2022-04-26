package com.example.sociallobster.Repository;

import com.example.sociallobster.Model.Comments;
import com.example.sociallobster.Model.User;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Repository
public class CommentsInsertRepository {
    @PersistenceContext
    private EntityManager entityManager;

    @Transactional
    public void insertWithQuery(Comments comments) {
        entityManager.createNativeQuery("INSERT INTO COMMENTS (user_id, post_id, content) VALUES (?,?,?)")
                .setParameter(1, comments.getUser_id())
                .setParameter(2, comments.getPost_id())
                .setParameter(3, comments.getContent())
                .executeUpdate();
    }
}
