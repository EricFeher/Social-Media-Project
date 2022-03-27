package com.example.sociallobster.Repository;

import com.example.sociallobster.Model.Follows;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FollowsRepository extends JpaRepository<Follows, Integer> {
}
