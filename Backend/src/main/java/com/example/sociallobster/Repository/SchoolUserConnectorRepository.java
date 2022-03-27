package com.example.sociallobster.Repository;

import com.example.sociallobster.Model.SchoolUserConnector;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SchoolUserConnectorRepository extends JpaRepository<SchoolUserConnector, Integer> {
}
