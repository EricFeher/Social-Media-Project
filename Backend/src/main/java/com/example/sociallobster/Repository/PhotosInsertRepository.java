package com.example.sociallobster.Repository;

import com.example.sociallobster.Model.Location;
import com.example.sociallobster.Model.Photos;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Repository
public class PhotosInsertRepository {
    @PersistenceContext
    private EntityManager entityManager;

    @Transactional
    public void insertWithQuery(Photos photos) {
        entityManager.createNativeQuery("INSERT INTO PHOTOS (user_id, photo) VALUES (?,?)")
                .setParameter(1, photos.getUser_id())
                .setParameter(2, photos.getPhoto())
                .executeUpdate();
    }
}
