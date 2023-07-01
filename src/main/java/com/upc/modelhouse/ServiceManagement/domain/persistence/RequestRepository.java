package com.upc.modelhouse.ServiceManagement.domain.persistence;

import com.upc.modelhouse.ServiceManagement.domain.model.entity.Request;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RequestRepository extends JpaRepository<Request, Long> {
    Request findRequestById(Long id);
    List<Request> findAll();
    List<Request> findAllByUserProfileId(Long id);
    List<Request> findAllByBusinessProfileId(Long id);
}
