package com.upc.modelhouse.security.resource.Project;

import lombok.*;

@Getter
@Setter
@With
@NoArgsConstructor
@AllArgsConstructor
public class UpdateProjectDto {
    private String title;
    private String description;
    private String image;
}
