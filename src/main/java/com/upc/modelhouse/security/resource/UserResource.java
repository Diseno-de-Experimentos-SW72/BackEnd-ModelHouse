package com.upc.modelhouse.security.resource;

import com.upc.modelhouse.security.resource.BusinessProfile.BusinessProfileDto;
import com.upc.modelhouse.security.resource.UserProfile.UserProfileDto;
import lombok.*;

@Getter
@Setter
@With
@NoArgsConstructor
@AllArgsConstructor
public class UserResource {

    private Long id;
    private String emailAddress;
    private Boolean isActive;
    private String role;
    private String token;
}