package com.upc.modelhouse.security.domain.persistence;

import com.upc.modelhouse.security.domain.model.entity.BusinessProfile;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface BusinessProfileRepository extends JpaRepository<BusinessProfile, Long> {
    @Override
    List<BusinessProfile> findAll();
    BusinessProfile findBusinessProfileById(Long id);
    BusinessProfile findBusinessProfileByAccount_Id(Long id);
}
