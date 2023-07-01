package com.upc.modelhouse.security.domain.service;

import com.upc.modelhouse.security.domain.model.entity.Project;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface ProjectService {
    List<Project> getAll();
    List<Project> findAllByBusinessProfileId(Long id);
    Project findById(Long id);
    Project createProject(Long businessId, Project project);
    Project updateProject(Long id, Project project);
    ResponseEntity<?> deleteProject(Long id);

}
