package com.upc.modelhouse.ServiceManagement.resource.ProjectActivity;

import com.upc.modelhouse.ServiceManagement.domain.model.entity.Proposal;
import com.upc.modelhouse.ServiceManagement.resource.Proposal.ProposalDto;
import lombok.*;

import java.util.Date;
@Getter
@Setter
@With
@NoArgsConstructor
@AllArgsConstructor
public class ProjectActivityDto {
    private Long id;
    private String status;
    private String name;
    private String description;
    private Date startedAt;
    private Date completedAt;
    private ProposalDto proposal;
}
