package com.upc.modelhouse.ServiceManagement.api;

import com.upc.modelhouse.ServiceManagement.domain.service.ProjectActivityService;
import com.upc.modelhouse.ServiceManagement.mapping.ProjectActivityMapper;
import com.upc.modelhouse.ServiceManagement.resource.ProjectActivity.CreateProjectActivityDto;
import com.upc.modelhouse.ServiceManagement.resource.ProjectActivity.ProjectActivityDto;
import com.upc.modelhouse.ServiceManagement.resource.ProjectActivity.UpdateProjectActivityDto;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@SecurityRequirement(name = "acme")
@RestController
@CrossOrigin
@RequestMapping("/api/v1/project_activity")
public class ProjectActivityController {
    private final ProjectActivityService projectActivityService;
    private final ProjectActivityMapper mapper;

    public ProjectActivityController(ProjectActivityService projectActivityService, ProjectActivityMapper mapper) {
        this.projectActivityService = projectActivityService;
        this.mapper = mapper;
    }
    @GetMapping("proposal/{proposalId}")
    @PreAuthorize("hasRole('ADMIN')or hasRole('USER')")
    public List<ProjectActivityDto> getAllByProposalId(@PathVariable("proposalId") Long proposalId){
        return mapper.listToResource(projectActivityService.findAllProposalId(proposalId));
    }
    @PostMapping("proposal/{proposalId}")
    @PreAuthorize("hasRole('ADMIN')or hasRole('USER')")
    public ProjectActivityDto create(@PathVariable("proposalId") Long proposalId,
                                            @RequestBody CreateProjectActivityDto createProjectActivityDto){
        return mapper.toResource(projectActivityService.create(proposalId, mapper.toModel(createProjectActivityDto)));
    }
    @PutMapping("{id}")
    @PreAuthorize("hasRole('ADMIN')or hasRole('USER')")
    public ProjectActivityDto update(@PathVariable("id") Long id, @RequestBody UpdateProjectActivityDto updateProjectActivityDto){
        return mapper.toResource(projectActivityService.update(id, mapper.toModel(updateProjectActivityDto)));
    }
    @DeleteMapping("{id}")
    @PreAuthorize("hasRole('ADMIN')or hasRole('USER')")
    public ResponseEntity<?> delete(@PathVariable("id") Long id){
        return  projectActivityService.delete(id);
    }
}
