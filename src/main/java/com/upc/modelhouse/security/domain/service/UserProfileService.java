package com.upc.modelhouse.security.domain.service;


import com.upc.modelhouse.security.domain.model.entity.UserProfile;

import java.util.List;

public interface UserProfileService {
    List<UserProfile> findAll();
    UserProfile findByAccountId(Long accountId);
    UserProfile create(Long accountId, UserProfile userProfile);
    UserProfile update(Long id, UserProfile userProfile);

}
