package com.upc.modelhouse.security.resource.Project;

import com.upc.modelhouse.security.resource.BusinessProfile.BusinessProfileDto;
import lombok.*;

import javax.persistence.Entity;

@Getter
@Setter
@With
@NoArgsConstructor
@AllArgsConstructor
public class ProjectDto {
    private Long id;
    private String title;
    private String description;
    private String image;
    private Long businessProfileId;
}
