package com.upc.modelhouse.security.service;

import com.upc.modelhouse.security.domain.model.entity.Account;
import com.upc.modelhouse.security.domain.model.entity.UserDetailsImpl;
import com.upc.modelhouse.security.domain.persistence.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    public UserDetails findEmailById(String idString){
        Long id = Long.parseLong(idString);
        Account account = userRepository.findById(id).orElse(null);
        if (account == null)
        {
            return null;
        }
        return UserDetailsImpl.build(account);
    }
    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        Account account = userRepository.findByEmailAddress(email);
        return UserDetailsImpl.build(account);
    }
}