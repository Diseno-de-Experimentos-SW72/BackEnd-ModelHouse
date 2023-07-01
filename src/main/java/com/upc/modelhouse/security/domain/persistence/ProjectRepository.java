package com.upc.modelhouse.security.domain.persistence;

import com.upc.modelhouse.security.domain.model.entity.Project;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface ProjectRepository extends JpaRepository<Project, Long> {
    Project findProjectById(Long id);
    List<Project> findAll();
    List<Project> findAllByBusinessProfileId(Long id);
}
