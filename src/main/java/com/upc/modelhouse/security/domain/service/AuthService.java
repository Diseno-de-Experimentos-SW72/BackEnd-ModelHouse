package com.upc.modelhouse.security.domain.service;

import com.upc.modelhouse.security.domain.model.entity.Account;
import com.upc.modelhouse.security.resource.AuthCredentialsResource;
import com.upc.modelhouse.security.resource.UserResource;

public interface AuthService {
    UserResource login (AuthCredentialsResource credentials);
    Account register(AuthCredentialsResource credentialsResource);
}
