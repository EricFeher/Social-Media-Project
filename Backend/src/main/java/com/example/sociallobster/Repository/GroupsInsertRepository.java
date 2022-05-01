package com.example.sociallobster.Repository;

import com.example.sociallobster.Model.Groups;
import com.example.sociallobster.Model.User;
import com.example.sociallobster.Model.UserData;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public class GroupsInsertRepository {

    @PersistenceContext
    private EntityManager entityManager;

    @Transactional
    public void insertWithQuery(Groups groups) {
        entityManager.createNativeQuery("INSERT INTO ENDUSER (name, description) VALUES (?,?)")
                .setParameter(1, groups.getName())
                .setParameter(2, groups.getDescription())
                .executeUpdate();
    }


    public List getGroupMembersCount(int id){
        return entityManager.createNativeQuery("SELECT COUNT(*) FROM GROUPS_MEMBERS INNER JOIN GROUPS ON GROUPS_MEMBERS.group_id=GROUPS.id WHERE GROUPS.id=? GROUP BY GROUPS.id")
                .setParameter(1, id)
                .getResultList();
    }

    public List<User> getGroupAdminUser(int id){
        return entityManager.createNativeQuery("SELECT * FROM ENDUSER WHERE id IN (SELECT USER_ID FROM GROUPS_ADMINS WHERE GROUP_ID=?)", User.class)
                .setParameter(1, id)
                .getResultList();
    }
}
