package com.upc.modelhouse.ServiceManagement.service;

import com.upc.modelhouse.ServiceManagement.domain.model.entity.Proposal;
import com.upc.modelhouse.ServiceManagement.domain.model.entity.Request;
import com.upc.modelhouse.ServiceManagement.domain.persistence.ProposalRepository;
import com.upc.modelhouse.ServiceManagement.domain.persistence.RequestRepository;
import com.upc.modelhouse.ServiceManagement.domain.service.ProposalService;
import com.upc.modelhouse.security.domain.persistence.BusinessProfileRepository;
import com.upc.modelhouse.security.domain.persistence.UserProfileRepository;
import com.upc.modelhouse.shared.exception.ResourceNotFoundException;
import com.upc.modelhouse.shared.exception.ResourceValidationException;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import javax.validation.ConstraintViolation;
import javax.validation.Validator;
import java.util.Date;
import java.util.List;
import java.util.Set;

@Service
@AllArgsConstructor
public class ProposalServiceImpl implements ProposalService {
    private final ProposalRepository proposalRepository;
    private final RequestRepository requestRepository;
    private final Validator validator;
    private static final String ENTITY = "Proposal";

    @Override
    public List<Proposal> getAll() {
        return proposalRepository.findAll();
    }

    @Override
    public Proposal findAllRequestId(Long id) {
        return proposalRepository.findByRequestId(id);
    }

    @Override
    public Proposal create(Long requestId, Proposal proposal) {
        Set<ConstraintViolation<Proposal>> violations = validator.validate(proposal);
        if(!violations.isEmpty())
            throw new ResourceValidationException(ENTITY, violations);
        proposal.setProposalDate(new Date());
        Proposal proposalExist = proposalRepository.findByRequestId(requestId);
        if(proposalExist != null)
            throw new ResourceNotFoundException("Proposal is exist");
        return requestRepository.findById(requestId).map(request -> {
            proposal.setRequest(request);
            return proposalRepository.save(proposal);
        }).orElseThrow(() -> new ResourceNotFoundException("Request", requestId));
    }

    @Override
    public ResponseEntity<?> delete(Long id) {
        return proposalRepository.findById(id).map(proposal -> {
            proposalRepository.delete(proposal);
            return ResponseEntity.ok().build();
        }).orElseThrow(()->new ResourceNotFoundException(ENTITY, id));
    }

    @Override
    public Proposal update(Long id, Proposal request) {
        return null;
    }
}
