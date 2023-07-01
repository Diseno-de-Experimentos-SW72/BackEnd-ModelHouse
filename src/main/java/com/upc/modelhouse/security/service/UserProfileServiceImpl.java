package com.upc.modelhouse.security.service;

import com.upc.modelhouse.security.domain.model.entity.Account;
import com.upc.modelhouse.security.domain.model.entity.UserProfile;
import com.upc.modelhouse.security.domain.persistence.UserProfileRepository;
import com.upc.modelhouse.security.domain.persistence.UserRepository;
import com.upc.modelhouse.security.domain.service.UserProfileService;
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
public class UserProfileServiceImpl implements UserProfileService {

    private final UserProfileRepository userProfileRepository;
    private final UserRepository accountRepository;
    private final Validator validator;
    private static final String ENTITY = "UserProfile";
    @Override
    public List<UserProfile> findAll() {
        return userProfileRepository.findAll();
    }

    @Override
    public UserProfile findByAccountId(Long accountId) {
        return userProfileRepository.findUserProfileByAccount_Id(accountId);
    }

    @Override
    public UserProfile create(Long accountId, UserProfile userProfile) {
        Set<ConstraintViolation<UserProfile>> violations = validator.validate(userProfile);
        if(!violations.isEmpty())
            throw new ResourceValidationException(ENTITY, violations);
        UserProfile userProfileExist = userProfileRepository.findUserProfileByAccount_Id(accountId);
        if(userProfileExist != null)
            throw new ResourceNotFoundException("User Profile is exist");
        return accountRepository.findById(accountId).map(account -> {
            userProfile.setAccount(account);
            return userProfileRepository.save(userProfile);
        }).orElseThrow(() -> new ResourceNotFoundException("Request", accountId));

    }

    @Override
    public UserProfile update(Long id, UserProfile userProfile) {
        Set<ConstraintViolation<UserProfile>> violations = validator.validate(userProfile);
        if(!violations.isEmpty())
            throw new ResourceValidationException(ENTITY, violations);
        return userProfileRepository.findById(id).map(profile ->
                        userProfileRepository.save(profile.withFirstName(userProfile.getFirstName())
                                .withImage(userProfile.getImage())
                                .withLastName(userProfile.getLastName())
                                .withGender(userProfile.getGender())
                                .withPhoneNumber(userProfile.getPhoneNumber())
                                .withLastLogin(new Date())))
                .orElseThrow(() -> new ResourceNotFoundException(ENTITY, id));
    }
}
