package com.upc.modelhouse.ServiceManagement.resource.Proposal;

import lombok.*;

import java.util.Date;
@Getter
@Setter
@With
@NoArgsConstructor
@AllArgsConstructor
public class UpdateProposalDto {
    private Date proposalDate;
    private String description;
    private Float price;
    private String status;
    private Boolean isResponse;
    private Date responseDate;
}
