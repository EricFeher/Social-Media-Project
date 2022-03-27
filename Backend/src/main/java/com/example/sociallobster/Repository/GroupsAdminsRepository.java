package com.example.sociallobster.Repository;

import com.example.sociallobster.Model.GroupsAdmins;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GroupsAdminsRepository extends JpaRepository<GroupsAdmins, Integer> {
}
