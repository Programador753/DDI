package com.ddi.controllers;

import com.ddi.requestObjects.AuthRequest;
import com.ddi.requestObjects.AuthResponse;
import com.ddi.services.JwtService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * Class that implements the Authentication Controller.
 *
 * @author Antonio
 */
@RestController
public class AuthController {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private UserDetailsService userDetailsService;

    @Autowired
    private JwtService jwtService;

    /**
     * Pre: request contains a valid email and password.
     * Post: returns a JWT token if the credentials are correct.
     */
    @PostMapping("/auth/login")
    public AuthResponse login(@RequestBody AuthRequest request) {
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(request.getCorreoElectronico(), request.getPassword())
        );
        final UserDetails userDetails = userDetailsService.loadUserByUsername(request.getCorreoElectronico());
        final String jwt = jwtService.generateToken(userDetails);
        return new AuthResponse(jwt);
    }
}