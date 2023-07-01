package com.upc.modelhouse.security.domain.model.entity;

import lombok.*;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Getter
@Setter
@With
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class BusinessProfile {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String description;
    private String image;
    private String address;
    @Column(name = "web_site")
    private String webSite;
    @Column(name = "phone_business")
    private String phoneBusiness;
    @Column(name = "registration_date")
    private Date registrationDate;
    @Column(name = "last_login")
    private Date lastLogin;

    @OneToOne
    @JoinColumn(name = "account_id")
    private Account account;
}
