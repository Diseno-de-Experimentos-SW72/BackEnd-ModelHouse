package com.upc.modelhouse.security.resource.BusinessProfile;

import lombok.*;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Getter
@Setter
@With
@NoArgsConstructor
@AllArgsConstructor
public class CreateBusinessProfileDto {
    @NotNull
    @NotBlank
    private String name;
    @NotNull
    @NotBlank
    private String description;
    private String image;
    private String address;
    private String webSite;
    @NotNull
    @NotBlank
    private String phoneBusiness;
    @NotNull
    private Long accountId;

}
