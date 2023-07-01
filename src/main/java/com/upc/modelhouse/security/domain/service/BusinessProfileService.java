package com.upc.modelhouse.security.domain.service;

import com.upc.modelhouse.security.domain.model.entity.BusinessProfile;

import java.util.List;

public interface BusinessProfileService {
    List<BusinessProfile> findAll();
    BusinessProfile findByAccountId(Long accountId);
    BusinessProfile findById(Long id);
    BusinessProfile create(Long accountId, BusinessProfile businessProfile);
    BusinessProfile update(Long id, BusinessProfile businessProfile);
}
