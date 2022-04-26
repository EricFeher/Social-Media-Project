package com.example.sociallobster.Repository;

import com.example.sociallobster.Model.Photos;
import com.example.sociallobster.Model.Workplace;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Repository
public class WorkplaceInsertRepository {
    @PersistenceContext
    private EntityManager entityManager;

    @Transactional
    public void insertWithQuery(Workplace workplace) {
        entityManager.createNativeQuery("INSERT INTO WORKPLACE (location_id, name, workplace_type) VALUES (?,?,?)")
                .setParameter(1, workplace.getLocation_id())
                .setParameter(2, workplace.getName())
                .setParameter(3, workplace.getWorkplace_type())
                .executeUpdate();
    }
}
