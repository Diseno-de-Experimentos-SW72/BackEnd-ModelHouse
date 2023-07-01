package com.upc.modelhouse.ServiceManagement.domain.service;

import com.upc.modelhouse.ServiceManagement.domain.model.entity.Request;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface RequestService {
    List<Request> getAll();
    List<Request> findAllBusinessProfileId(Long id);
    List<Request> findAllUserProfileId(Long id);
    Request create(Long userId, Long businessId, Request request);
    ResponseEntity<?> delete(Long id);
    Request changeStatus(Long id, Request request);
}
