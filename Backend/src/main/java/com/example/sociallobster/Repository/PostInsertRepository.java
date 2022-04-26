package com.example.sociallobster.Repository;

import com.example.sociallobster.Model.Photos;
import com.example.sociallobster.Model.Post;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Repository
public class PostInsertRepository {
    @PersistenceContext
    private EntityManager entityManager;

    @Transactional
    public void insertWithQuery(Post post) {
        entityManager.createNativeQuery("INSERT INTO POST (user_id, content) VALUES (?,?)")
                .setParameter(1, post.getUser_id())
                .setParameter(2, post.getContent())
                .executeUpdate();
    }
}
