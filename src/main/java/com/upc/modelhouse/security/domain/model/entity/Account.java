package com.upc.modelhouse.security.domain.model.entity;

import com.upc.modelhouse.shared.domain.model.AuditModel;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.Email;

@Getter
@Setter
@With
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Account extends AuditModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Email
    @Column(name = "email_address")
    private String emailAddress;
    @Column(name = "is_active")
    private Boolean isActive;
    private String role;
    private String password;
    @OneToOne(mappedBy = "account", cascade = CascadeType.ALL)
    private UserProfile userProfile;

    @OneToOne(mappedBy = "account", cascade = CascadeType.ALL)
    private BusinessProfile businessProfile;
}