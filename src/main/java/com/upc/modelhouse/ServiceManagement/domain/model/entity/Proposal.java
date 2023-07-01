package com.upc.modelhouse.ServiceManagement.domain.model.entity;
import lombok.*;

import javax.persistence.*;
import java.util.Date;

@Getter
@Setter
@With
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Proposal {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "proposal_date")
    private Date proposalDate;
    private String description;
    private Float price;
    private String status;
    @Column(name = "is_response")
    private Boolean isResponse;
    @Column(name = "response_date")
    private Date responseDate;

    @OneToOne
    @JoinColumn(name = "request_id")
    private Request request;
}
