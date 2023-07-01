package com.upc.modelhouse.security.domain.persistence;

import com.upc.modelhouse.security.domain.model.entity.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<Account, Long> {

    Account findByEmailAddress(String emailAddress);
}