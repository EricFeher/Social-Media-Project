package com.example.sociallobster.Repository;

import com.example.sociallobster.Model.PostLikes;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PostLikesRepository extends JpaRepository<PostLikes, Integer> {
}
