package com.upc.modelhouse.security.service;

import com.upc.modelhouse.security.domain.model.entity.Account;
import com.upc.modelhouse.security.domain.persistence.UserRepository;
import com.upc.modelhouse.security.domain.service.AuthService;
import com.upc.modelhouse.security.mapping.UserMapper;
import com.upc.modelhouse.security.resource.AuthCredentialsResource;
import com.upc.modelhouse.security.resource.UserResource;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class AuthServiceImpl implements AuthService {
    @Autowired
    UserRepository userRepository;
    @Autowired
    private PasswordEncoder encoder;
    private UserMapper mapper;

    public UserResource login(AuthCredentialsResource credentials) {
        Account account = userRepository.findByEmailAddress(credentials.getEmailAddress());
        if (account == null)
            throw new IllegalArgumentException("User not found");
        if (!encoder.matches(credentials.getPassword(), account.getPassword()))
            throw new IllegalArgumentException("Wrong password");

        return mapper.toResource(account);
    }

    @Override
    public Account register(AuthCredentialsResource credentialsResource) {
        Account registeredAccount = new Account();
        registeredAccount.setEmailAddress(credentialsResource.getEmailAddress());
        registeredAccount.setPassword(encoder.encode(credentialsResource.getPassword()));
        registeredAccount.setIsActive(true);
        registeredAccount.setRole("user");
        registeredAccount = userRepository.save(registeredAccount);

        return registeredAccount;
    }
}
