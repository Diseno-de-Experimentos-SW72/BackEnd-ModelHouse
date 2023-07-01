package com.upc.modelhouse.security.resource.BusinessProfile;

import com.upc.modelhouse.security.domain.model.entity.Account;
import com.upc.modelhouse.security.resource.UserResource;
import lombok.*;

@Getter
@Setter
@With
@NoArgsConstructor
@AllArgsConstructor
public class BusinessProfileDto {
    private Long id;
    private String name;
    private String description;
    private String image;
    private String address;
    private String webSite;
    private String phoneBusiness;
    private String foundationDate;
    private UserResource account;
}
