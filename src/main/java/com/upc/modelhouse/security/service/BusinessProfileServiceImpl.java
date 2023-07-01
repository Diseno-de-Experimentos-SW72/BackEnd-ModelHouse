package com.upc.modelhouse.security.service;

import com.upc.modelhouse.security.domain.model.entity.BusinessProfile;
import com.upc.modelhouse.security.domain.model.entity.UserProfile;
import com.upc.modelhouse.security.domain.persistence.BusinessProfileRepository;
import com.upc.modelhouse.security.domain.persistence.UserRepository;
import com.upc.modelhouse.security.domain.service.BusinessProfileService;
import com.upc.modelhouse.shared.exception.ResourceNotFoundException;
import com.upc.modelhouse.shared.exception.ResourceValidationException;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import javax.validation.ConstraintViolation;
import javax.validation.Validator;
import java.util.Date;
import java.util.List;
import java.util.Set;

@Service
@AllArgsConstructor
public class BusinessProfileServiceImpl implements BusinessProfileService {
    private final BusinessProfileRepository businessProfileRepository;
    private final UserRepository accountRepository;
    private final Validator validator;
    private static final String ENTITY = "BusinessProfile";
    @Override
    public List<BusinessProfile> findAll() {
        return businessProfileRepository.findAll();
    }

    @Override
    public BusinessProfile findByAccountId(Long accountId) {
        return businessProfileRepository.findBusinessProfileByAccount_Id(accountId);
    }

    @Override
    public BusinessProfile findById(Long id) {
        return businessProfileRepository.findBusinessProfileById(id);
    }

    @Override
    public BusinessProfile create(Long accountId, BusinessProfile businessProfile) {
        Set<ConstraintViolation<BusinessProfile>> violations = validator.validate(businessProfile);
        if(!violations.isEmpty())
            throw new ResourceValidationException(ENTITY, violations);
        BusinessProfile businessProfileExist = businessProfileRepository.findBusinessProfileByAccount_Id(accountId);
        if(businessProfileExist != null)
            throw new ResourceNotFoundException("Business Profile is exist");
        return accountRepository.findById(accountId).map(account -> {
            businessProfile.setAccount(account);
            return businessProfileRepository.save(businessProfile);
        }).orElseThrow(() -> new ResourceNotFoundException("Request", accountId));
    }

    @Override
    public BusinessProfile update(Long id, BusinessProfile businessProfile) {
        Set<ConstraintViolation<BusinessProfile>> violations = validator.validate(businessProfile);
        if(!violations.isEmpty())
            throw new ResourceValidationException(ENTITY, violations);
        return businessProfileRepository.findById(id).map(profile ->
                        businessProfileRepository.save(profile.withName(businessProfile.getName())
                                .withDescription(businessProfile.getDescription())
                                .withImage(businessProfile.getImage())
                                .withAddress(businessProfile.getAddress())
                                .withWebSite(businessProfile.getWebSite())
                                .withRegistrationDate(new Date())
                                .withPhoneBusiness(businessProfile.getPhoneBusiness())))
                .orElseThrow(() -> new ResourceNotFoundException(ENTITY, id));
    }
}
