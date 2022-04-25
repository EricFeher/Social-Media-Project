package com.example.sociallobster.Repository;

import com.example.sociallobster.Model.Comments;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Repository
public interface CommentsRepository extends JpaRepository<Comments, Integer> {
}
