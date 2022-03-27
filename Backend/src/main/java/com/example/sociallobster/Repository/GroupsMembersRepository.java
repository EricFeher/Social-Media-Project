package com.example.sociallobster.Repository;

import com.example.sociallobster.Model.GroupsMembers;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GroupsMembersRepository extends JpaRepository<GroupsMembers, Integer> {
}
