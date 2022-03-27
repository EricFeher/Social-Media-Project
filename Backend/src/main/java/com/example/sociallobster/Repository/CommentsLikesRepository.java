package com.example.sociallobster.Repository;

import com.example.sociallobster.Model.CommentsLikes;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CommentsLikesRepository extends JpaRepository<CommentsLikes, Integer> {
}
