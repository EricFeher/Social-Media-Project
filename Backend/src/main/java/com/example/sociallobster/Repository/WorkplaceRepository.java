package com.example.sociallobster.Repository;

import com.example.sociallobster.Model.Workplace;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WorkplaceRepository extends JpaRepository<Workplace, Integer> {
}
