package com.upc.modelhouse.ServiceManagement.resource.Request;

import com.upc.modelhouse.security.resource.BusinessProfile.BusinessProfileDto;
import com.upc.modelhouse.security.resource.UserProfile.UserProfileDto;
import lombok.*;

import java.util.Date;

@Getter
@Setter
@With
@NoArgsConstructor
@AllArgsConstructor
public class RequestDto {
    private Long id;
    private Date requestAt;
    private String status;
    private String description;
    private Boolean accepted;
    private Date acceptedAt;
    private Date updateAt;
    private UserProfileDto userProfile;
    private BusinessProfileDto businessProfile;
}
