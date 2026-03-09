package com.ddi.controllers;

import com.ddi.models.Role;
import com.ddi.models.Usuario;
import com.ddi.requestObjects.AuthRequest;
import com.ddi.requestObjects.AuthResponse;
import com.ddi.services.JwtService;
import com.ddi.services.UsuarioService;
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

    @Autowired
    private UsuarioService usuarioService;

    /**
     * Pre: request contains a valid nombre, correoElectronico and password.
     * Post: creates a new user and returns a JWT token.
     */
    @PostMapping("/auth/register")
    public AuthResponse register(@RequestBody Usuario user) {
        // Set default role if not provided
        if (user.getRole() == null) {
            user.setRole(Role.USER);
        }
        usuarioService.newUsuario(user);
        final UserDetails userDetails = userDetailsService.loadUserByUsername(user.getCorreoElectronico());
        final String jwt = jwtService.generateToken(userDetails);
        return new AuthResponse(jwt);
    }

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