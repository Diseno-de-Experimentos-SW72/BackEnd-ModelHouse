package com.upc.modelhouse.security.resource;

import lombok.*;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Getter
@Setter
@With
@NoArgsConstructor
@AllArgsConstructor
public class AuthCredentialsResource {
    @NotNull
    @NotBlank
    @Email
    private String emailAddress;
    @NotNull
    @NotBlank
    @Size(min = 8, max = 16)
    private String password;
}
