package com.upc.modelhouse.ServiceManagement.mapping;

import com.upc.modelhouse.ServiceManagement.domain.model.entity.ProjectResource;
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
public class ProjectResourceMapper implements Serializable {
    @Autowired
    EnhancedModelMapper mapper;
    public ProjectResourceDto toResource(ProjectResource model){
        return mapper.map(model, ProjectResourceDto.class);
    }
    public List<ProjectResourceDto> listToResource(List<ProjectResource> model){
        return mapper.mapList(model, ProjectResourceDto.class);
    }
    public ProjectResource toModel(ProjectResourceDto resource) {
        return mapper.map(resource, ProjectResource.class);
    }

    public ProjectResource toModel(CreateProjectResourceDto resource) {
        return mapper.map(resource, ProjectResource.class);
    }

    public ProjectResource toModel(UpdateProjectResourceDto resource) {
        return mapper.map(resource, ProjectResource.class);
    }
}
