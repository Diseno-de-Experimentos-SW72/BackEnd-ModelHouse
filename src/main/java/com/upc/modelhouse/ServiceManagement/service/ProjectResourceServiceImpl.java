package com.upc.modelhouse.ServiceManagement.service;

import com.upc.modelhouse.ServiceManagement.domain.model.entity.ProjectResource;
import com.upc.modelhouse.ServiceManagement.domain.model.entity.Proposal;
import com.upc.modelhouse.ServiceManagement.domain.model.entity.Request;
import com.upc.modelhouse.ServiceManagement.domain.persistence.ProjectResourceRepository;
import com.upc.modelhouse.ServiceManagement.domain.persistence.ProposalRepository;
import com.upc.modelhouse.ServiceManagement.domain.service.ProjectResourceService;
import com.upc.modelhouse.shared.exception.ResourceNotFoundException;
import com.upc.modelhouse.shared.exception.ResourceValidationException;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import javax.validation.ConstraintViolation;
import javax.validation.Validator;
import java.util.Date;
import java.util.List;
import java.util.Set;

@Service
@AllArgsConstructor
public class ProjectResourceServiceImpl implements ProjectResourceService {
    private final ProposalRepository proposalRepository;
    private final ProjectResourceRepository projectResourceRepository;
    private final Validator validator;
    private static final String ENTITY = "Request";

    @Override
    public List<ProjectResource> findAllProposalId(Long id) {
        return projectResourceRepository.findAllByProposalId(id);
    }

    @Override
    public ProjectResource create(Long proposalId, ProjectResource projectResource) {
        Set<ConstraintViolation<ProjectResource>> violations = validator.validate(projectResource);
        if(!violations.isEmpty())
            throw new ResourceValidationException(ENTITY, violations);
        return proposalRepository.findById(proposalId).map(proposal -> {
            projectResource.setProposal(proposal);
            return projectResourceRepository.save(projectResource);
        }).orElseThrow(() -> new ResourceNotFoundException("Proposal", proposalId));
    }

    @Override
    public ResponseEntity<?> delete(Long id) {
        return projectResourceRepository.findById(id).map(projectResource -> {
            projectResourceRepository.delete(projectResource);
            return ResponseEntity.ok().build();
        }).orElseThrow(()->new ResourceNotFoundException(ENTITY, id));

    }

    @Override
    public ProjectResource update(Long id, ProjectResource projectResource) {
        Set<ConstraintViolation<ProjectResource>> violations = validator.validate(projectResource);
        if(!violations.isEmpty())
            throw new ResourceValidationException(ENTITY, violations);
        return projectResourceRepository.findById(id).map(project ->
                        projectResourceRepository.save(project.withDescription(projectResource.getDescription())
                                .withQuantity(projectResource.getQuantity())
                                .withState(projectResource.getState())))
                .orElseThrow(()-> new ResourceNotFoundException(ENTITY , id));
    }
}
