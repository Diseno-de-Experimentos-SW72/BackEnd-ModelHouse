package com.upc.modelhouse.ServiceManagement.domain.service;

import com.upc.modelhouse.ServiceManagement.domain.model.entity.ProjectActivity;
import com.upc.modelhouse.ServiceManagement.domain.model.entity.ProjectResource;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;

import java.util.List;

public interface ProjectActivityService {
    List<ProjectActivity> findAllProposalId(Long id);
    ProjectActivity create(Long proposalId, ProjectActivity projectActivity);
    ResponseEntity<?> delete(Long id);
    ProjectActivity update(Long id, ProjectActivity proposal);
}
