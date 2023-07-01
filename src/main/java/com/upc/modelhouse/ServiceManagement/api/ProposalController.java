package com.upc.modelhouse.ServiceManagement.api;

import com.upc.modelhouse.ServiceManagement.domain.service.ProposalService;
import com.upc.modelhouse.ServiceManagement.mapping.ProposalMapper;
import com.upc.modelhouse.ServiceManagement.resource.Proposal.CreateProposalDto;
import com.upc.modelhouse.ServiceManagement.resource.Proposal.ProposalDto;
import com.upc.modelhouse.ServiceManagement.resource.Proposal.UpdateProposalDto;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@SecurityRequirement(name = "acme")
@RestController
@CrossOrigin
@RequestMapping("/api/v1/proposal")
public class ProposalController {
    private final ProposalService proposalService;
    private final ProposalMapper mapper;

    public ProposalController(ProposalService proposalService, ProposalMapper mapper) {
        this.proposalService = proposalService;
        this.mapper = mapper;
    }
    @GetMapping
    @PreAuthorize("hasRole('ADMIN')or hasRole('USER')")
    public List<ProposalDto> getAll(){
        return mapper.listToResource(proposalService.getAll());
    }
    @GetMapping("request/{requestId}")
    @PreAuthorize("hasRole('ADMIN')or hasRole('USER')")
    public ProposalDto getAllByRequestId(@PathVariable("requestId") Long id){
        return mapper.toResource(proposalService.findAllRequestId(id));
    }
    @PostMapping("request/{requestId}")
    @PreAuthorize("hasRole('ADMIN')or hasRole('USER')")
    public ProposalDto createProject(@PathVariable("requestId") Long requestId,
                                    @RequestBody CreateProposalDto createProposalDto){
        return mapper.toResource(proposalService.create(requestId, mapper.toModel(createProposalDto)));
    }
    @PutMapping("{id}")
    @PreAuthorize("hasRole('ADMIN')or hasRole('USER')")
    public ProposalDto updateProposal(@PathVariable("id") Long id, @RequestBody UpdateProposalDto updateProposalDto){
        return mapper.toResource(proposalService.update(id, mapper.toModel(updateProposalDto)));
    }
    @DeleteMapping("{id}")
    @PreAuthorize("hasRole('ADMIN')or hasRole('USER')")
    public ResponseEntity<?> deleteProject(@PathVariable("id") Long id){
        return  proposalService.delete(id);
    }
}
