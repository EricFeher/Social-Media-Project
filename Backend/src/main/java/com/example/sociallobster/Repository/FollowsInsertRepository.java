package com.example.sociallobster.Repository;

import com.example.sociallobster.Model.Comments;
import com.example.sociallobster.Model.Follows;
import com.example.sociallobster.Model.UserData;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public class FollowsInsertRepository {
    @PersistenceContext
    private EntityManager entityManager;

    @Transactional
    public void insertWithQuery(Follows follows) {
        entityManager.createNativeQuery("INSERT INTO COMMENTS (user_id1, user_id2) VALUES (?,?)")
                .setParameter(1, follows.getUser_id1())
                .setParameter(2, follows.getUser_id2() )
                .executeUpdate();
    }

    public List getFollowsByUserId1(int id){
        return entityManager.createNativeQuery("SELECT COUNT(*) FROM FOLLOWS WHERE user_id1=? GROUP BY user_id1")
                .setParameter(1, id)
                .getResultList();
    }

    public List getFollowsByUserId2(int id){
        return entityManager.createNativeQuery("SELECT COUNT(*) FROM FOLLOWS WHERE user_id2=? GROUP BY user_id2")
                .setParameter(1, id)
                .getResultList();
    }
}
