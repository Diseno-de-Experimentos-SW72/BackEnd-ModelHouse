package com.upc.modelhouse.ServiceManagement.domain.service;

import com.upc.modelhouse.ServiceManagement.domain.model.entity.Proposal;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface ProposalService {
    List<Proposal> getAll();
    Proposal findAllRequestId(Long id);
    Proposal create(Long requestId, Proposal request);
    ResponseEntity<?> delete(Long id);
    Proposal update(Long id, Proposal request);
}
