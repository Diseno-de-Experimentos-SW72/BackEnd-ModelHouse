package com.upc.modelhouse.ServiceManagement.domain.persistence;

import com.upc.modelhouse.ServiceManagement.domain.model.entity.ProjectActivity;
import com.upc.modelhouse.ServiceManagement.domain.model.entity.ProjectResource;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProjectActivityRepository extends JpaRepository<ProjectActivity, Long> {
    ProjectActivity findProjectActivityById(Long id);
    List<ProjectActivity> findAll();
    List<ProjectActivity> findAllByProposalId(Long id);
}
