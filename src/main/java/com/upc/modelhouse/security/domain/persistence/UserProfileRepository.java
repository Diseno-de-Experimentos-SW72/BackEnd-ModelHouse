package com.upc.modelhouse.security.domain.persistence;

import com.upc.modelhouse.security.domain.model.entity.UserProfile;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface UserProfileRepository extends JpaRepository<UserProfile, Long> {
    @Override
    List<UserProfile> findAll();
    UserProfile findUserProfileById(Long id);
    UserProfile findUserProfileByAccount_Id(Long id);
}
