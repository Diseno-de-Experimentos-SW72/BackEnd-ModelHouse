package com.upc.modelhouse.ServiceManagement.mapping;

import com.upc.modelhouse.ServiceManagement.domain.model.entity.Proposal;
import com.upc.modelhouse.ServiceManagement.resource.Proposal.CreateProposalDto;
import com.upc.modelhouse.ServiceManagement.resource.Proposal.ProposalDto;
import com.upc.modelhouse.ServiceManagement.resource.Proposal.UpdateProposalDto;
import com.upc.modelhouse.shared.mapping.EnhancedModelMapper;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.Serializable;
import java.util.List;

@Component
@AllArgsConstructor
public class ProposalMapper implements Serializable {
    @Autowired
    EnhancedModelMapper mapper;
    public ProposalDto toResource(Proposal model){
        return mapper.map(model, ProposalDto.class);
    }
    public List<ProposalDto> listToResource(List<Proposal> model){
        return mapper.mapList(model, ProposalDto.class);
    }
    public Proposal toModel(ProposalDto resource) {
        return mapper.map(resource, Proposal.class);
    }

    public Proposal toModel(CreateProposalDto resource) {
        return mapper.map(resource, Proposal.class);
    }

    public Proposal toModel(UpdateProposalDto resource) {
        return mapper.map(resource, Proposal.class);
    }
}
