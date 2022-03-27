package com.example.sociallobster.Repository;

import com.example.sociallobster.Model.WorkplaceUserConnector;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WorkplaceUserConnectorReopisotry extends JpaRepository<WorkplaceUserConnector, Integer> {
}
