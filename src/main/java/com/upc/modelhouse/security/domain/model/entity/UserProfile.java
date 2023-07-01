package com.upc.modelhouse.security.domain.model.entity;

import lombok.*;

import javax.persistence.*;
import java.util.Date;

@Getter
@Setter
@With
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class UserProfile {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "first_name")
    private String firstName;
    private String image;
    @Column(name = "last_name")
    private String lastName;
    private String gender;
    @Column(name = "phone_number")
    private String phoneNumber;
    @Column(name = "registration_date")
    private Date registrationDate;
    @Column(name = "last_login")
    private Date lastLogin;

    @OneToOne
    @JoinColumn(name = "account_id")
    private Account account;
}
