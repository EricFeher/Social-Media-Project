package com.example.sociallobster.Repository;

import com.example.sociallobster.Model.School;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Repository
public class SchoolInsertRepository {

    @PersistenceContext
    private EntityManager entityManager;

    @Transactional
    public void insertWithQuery(School school) {
        entityManager.createNativeQuery("INSERT INTO SCHOOL (location_id, name, school_type) VALUES (?,?,?)")
                .setParameter(1, school.getLocation_id())
                .setParameter(2, school.getName())
                .setParameter(3, school.getSchool_type())
                .executeUpdate();
    }

}
