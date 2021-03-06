package com.example.sociallobster.Repository;

import com.example.sociallobster.Model.Location;
import com.example.sociallobster.Model.School;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public class LocationInsertRepository {
    @PersistenceContext
    private EntityManager entityManager;

    @Transactional
    public void insertWithQuery(Location location) {
        entityManager.createNativeQuery("INSERT INTO LOCATION (postcode, city, street, housenumber) VALUES (?,?,?,?)")
                .setParameter(1, location.getPostcode())
                .setParameter(2, location.getCity())
                .setParameter(3, location.getStreet())
                .setParameter(4, location.getHousenumber())
                .executeUpdate();
    }

    public List<Location> getLocationForSchool(){
        return entityManager.createNativeQuery(" SELECT * FROM LOCATION WHERE LOCATION.ID IN (SELECT LOCATION_ID FROM SCHOOL WHERE NAME='Bayer Inc')",Location.class)
                .getResultList();
    }

}
