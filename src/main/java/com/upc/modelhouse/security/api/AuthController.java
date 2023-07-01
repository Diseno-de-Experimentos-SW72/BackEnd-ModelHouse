package com.upc.modelhouse.security.api;

import com.upc.modelhouse.security.domain.persistence.UserRepository;
import com.upc.modelhouse.security.domain.service.AuthService;
import com.upc.modelhouse.security.resource.AuthCredentialsResource;
import com.upc.modelhouse.security.resource.ResponseErrorResource;
import com.upc.modelhouse.security.resource.UserResource;
import com.upc.modelhouse.security.util.JwtUtil;
import io.swagger.v3.oas.annotations.Operation;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.web.bind.annotation.*;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

import javax.validation.Valid;

@RestController
@AllArgsConstructor
@CrossOrigin
@RequestMapping("/api/v1/auth")
public class AuthController {

    private final AuthService authService;

    @Autowired
    private JwtUtil jwtUtil;

    private AuthenticationManager manager;
    @Autowired
    private UserRepository userRepository;
    private static final String statusBody = "User already exists";

    @PostMapping("/login")
    @Operation(summary = "Login", tags = { "Auth" })
    public ResponseEntity<?> login(@Valid @RequestBody AuthCredentialsResource account) {
        ResponseErrorResource errorResource = new ResponseErrorResource();
        errorResource.setMessage(statusBody);
        UserResource response = authService.login(account);
        Authentication authentication = manager.authenticate(
                new UsernamePasswordAuthenticationToken(account.getEmailAddress(), account.getPassword()));
        SecurityContextHolder.getContext().setAuthentication(authentication);
        String jwt = jwtUtil.generateJwtToken(authentication);
        if (response == null) {
            return ResponseEntity.badRequest().body(errorResource);
        }
        response.setToken(jwt);
        return ResponseEntity.ok(response);
    }

    @PostMapping("/register")
    @Operation(summary = "Register", tags = { "Auth" })
    public ResponseEntity<?> register(@Valid @RequestBody AuthCredentialsResource credentials) {

        ResponseErrorResource errorResource = new ResponseErrorResource();
        errorResource.setMessage(statusBody);

        if (userRepository.findByEmailAddress(credentials.getEmailAddress()) != null) {
            return ResponseEntity.badRequest().body(errorResource);
        }

        return ResponseEntity.ok(authService.register(credentials));
    }
}
