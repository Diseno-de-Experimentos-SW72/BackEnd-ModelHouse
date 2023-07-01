package com.upc.modelhouse.ServiceManagement.resource.ProjectResource;

import com.upc.modelhouse.ServiceManagement.resource.Proposal.ProposalDto;
import lombok.*;

@Getter
@Setter
@With
@NoArgsConstructor
@AllArgsConstructor
public class ProjectResourceDto {
    private Long Id;
    private String description;
    private Number quantity;
    private String state;
    private ProposalDto proposal;
}
