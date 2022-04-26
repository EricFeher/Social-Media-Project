package com.example.sociallobster.Repository;

import com.example.sociallobster.Model.Photos;
import com.example.sociallobster.Model.UserData;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Repository
public class UserDataInsertRepository {
    @PersistenceContext
    private EntityManager entityManager;

    @Transactional
    public void insertWithQuery(UserData userData) {
        entityManager.createNativeQuery("INSERT INTO USERDATA (user_id, location_id, photo_id, first_name, last_name, gender, birthday) VALUES (?,?,?,?,?,?,?)")
                .setParameter(1, userData.getUser_id())
                .setParameter(2, userData.getLocation_id())
                .setParameter(3, userData.getPhoto_id())
                .setParameter(4,userData.getFirst_name())
                .setParameter(5, userData.getLast_name())
                .setParameter(6, userData.getGender())
                .setParameter(7, userData.getBirthday())
                .executeUpdate();
    }
}
