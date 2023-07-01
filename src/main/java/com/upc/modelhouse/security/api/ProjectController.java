package com.upc.modelhouse.security.api;

import com.upc.modelhouse.security.domain.service.ProjectService;
import com.upc.modelhouse.security.mapping.ProjectMapper;
import com.upc.modelhouse.security.resource.Project.CreateProjectDto;
import com.upc.modelhouse.security.resource.Project.ProjectDto;
import com.upc.modelhouse.security.resource.Project.UpdateProjectDto;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@SecurityRequirement(name = "acme")
@RestController
@CrossOrigin
@RequestMapping("/api/v1/project")
public class ProjectController {
    private final ProjectService projectService;
    private final ProjectMapper mapper;

    public ProjectController(ProjectService projectService, ProjectMapper mapper) {
        this.projectService = projectService;
        this.mapper = mapper;
    }

    @GetMapping
    public List<ProjectDto> getAll(){
        return mapper.listToResource(projectService.getAll());
    }
    @GetMapping("business/{businessId}")
    public List<ProjectDto> getAllByBusinessId(@PathVariable("businessId") Long id){
        return mapper.listToResource(projectService.findAllByBusinessProfileId(id));
    }
    @GetMapping("profile/{id}")
    public ProjectDto getById(@PathVariable("id") Long id){
        return mapper.toResource(projectService.findById(id));
    }
    @PostMapping("businessProfile/{businessId}")
    @PreAuthorize("hasRole('ADMIN')or hasRole('USER')")
    public ProjectDto createProject(@PathVariable("businessId") Long businessId, @RequestBody CreateProjectDto createProjectDto){
        return mapper.toResource(projectService.createProject(businessId, mapper.toModel(createProjectDto)));
    }
    @PutMapping("{id}")
    @PreAuthorize("hasRole('ADMIN')or hasRole('USER')")
    public ProjectDto updateProject(@PathVariable("id") Long id, @RequestBody UpdateProjectDto updateBusinessProfileDto){
        return mapper.toResource(projectService.updateProject(id, mapper.toModel(updateBusinessProfileDto)));
    }
    @DeleteMapping("{id}")
    @PreAuthorize("hasRole('ADMIN')or hasRole('USER')")
    public ResponseEntity<?> deleteProject(@PathVariable("id") Long id){
        return  projectService.deleteProject(id);
    }
}
