package com.upc.modelhouse.ServiceManagement.mapping;

import com.upc.modelhouse.ServiceManagement.domain.model.entity.ProjectActivity;
import com.upc.modelhouse.ServiceManagement.domain.model.entity.ProjectResource;
import com.upc.modelhouse.ServiceManagement.resource.ProjectActivity.CreateProjectActivityDto;
import com.upc.modelhouse.ServiceManagement.resource.ProjectActivity.ProjectActivityDto;
import com.upc.modelhouse.ServiceManagement.resource.ProjectActivity.UpdateProjectActivityDto;
import com.upc.modelhouse.ServiceManagement.resource.ProjectResource.CreateProjectResourceDto;
import com.upc.modelhouse.ServiceManagement.resource.ProjectResource.ProjectResourceDto;
import com.upc.modelhouse.ServiceManagement.resource.ProjectResource.UpdateProjectResourceDto;
import com.upc.modelhouse.shared.mapping.EnhancedModelMapper;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.Serializable;
import java.util.List;

@Component
@AllArgsConstructor
public class ProjectActivityMapper implements Serializable {
    @Autowired
    EnhancedModelMapper mapper;
    public ProjectActivityDto toResource(ProjectActivity model){
        return mapper.map(model, ProjectActivityDto.class);
    }
    public List<ProjectActivityDto> listToResource(List<ProjectActivity> model){
        return mapper.mapList(model, ProjectActivityDto.class);
    }
    public ProjectActivity toModel(ProjectActivityDto resource) {
        return mapper.map(resource, ProjectActivity.class);
    }

    public ProjectActivity toModel(CreateProjectActivityDto resource) {
        return mapper.map(resource, ProjectActivity.class);
    }

    public ProjectActivity toModel(UpdateProjectActivityDto resource) {
        return mapper.map(resource, ProjectActivity.class);
    }
}
