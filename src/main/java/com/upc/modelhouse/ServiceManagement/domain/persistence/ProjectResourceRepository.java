package com.upc.modelhouse.ServiceManagement.domain.persistence;

import com.upc.modelhouse.ServiceManagement.domain.model.entity.ProjectResource;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProjectResourceRepository extends JpaRepository<ProjectResource, Long> {
    ProjectResource findProjectResourceById(Long id);
    List<ProjectResource> findAll();
    List<ProjectResource> findAllByProposalId(Long id);
}
