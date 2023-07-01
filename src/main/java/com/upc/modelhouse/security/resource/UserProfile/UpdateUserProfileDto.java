package com.upc.modelhouse.security.resource.UserProfile;

import lombok.*;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.Date;
@Getter
@Setter
@With
@NoArgsConstructor
@AllArgsConstructor
public class UpdateUserProfileDto {
    private String firstName;
    private String image;
    private String lastName;
    private String gender;
    private String phoneNumber;
    private Date registrationDate;
    private Date lastLogin;
}
