package com.upc.modelhouse.security.resource.BusinessProfile;

import lombok.*;

@Getter
@Setter
@With
@NoArgsConstructor
@AllArgsConstructor
public class UpdateBusinessProfileDto {
    private String name;
    private String description;
    private String image;
    private String address;
    private String webSite;
    private String phoneBusiness;
    private String foundationDate;
}
