package com.revature.tarotcards.p2scapegoats.services.melissa;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.tarotcards.p2scapegoats.controllers.john.AuthController;
import com.revature.tarotcards.p2scapegoats.dtos.john.request.JohnLoginRequest;
import com.revature.tarotcards.p2scapegoats.dtos.john.response.JohnPrincipal;
import com.revature.tarotcards.p2scapegoats.dtos.response.melissa.Principal;
import com.revature.tarotcards.p2scapegoats.models.melissa.Roles;
import com.revature.tarotcards.p2scapegoats.models.melissa.Users;
import com.revature.tarotcards.p2scapegoats.repositories.john.JohnUserRepository;
import com.revature.tarotcards.p2scapegoats.services.john.JohnUserService;
import com.revature.tarotcards.p2scapegoats.services.melissa.TokenService;
import org.hibernate.Session;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.IOException;


import static org.junit.Assert.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class AuthControllerTest {

    @Autowired
    private ObjectMapper mockMapper;
    @Autowired
    private TokenService mockTokenService;
    @Autowired
    private JohnUserService mockUserService;

    @Autowired
    private JohnUserRepository mockUserRepository;

    @Autowired
    private AuthController authController;

    @Before
    public void setUp() throws Exception {
        mockMapper = mock(ObjectMapper.class, Mockito.RETURNS_DEEP_STUBS);
        mockTokenService = mock(TokenService.class, Mockito.RETURNS_DEEP_STUBS);
        mockUserRepository = mock(JohnUserRepository.class, Mockito.RETURNS_DEEP_STUBS);
        mockUserService = new JohnUserService(mockUserRepository);
        authController = new AuthController(mockMapper, mockTokenService, mockUserService);

    }

    @Test
    public void login() throws IOException {
//        JohnLoginRequest loginRequest = new JohnLoginRequest();
//        loginRequest.setUsername("john8585");
//        loginRequest.setPassword("John8585!");
//
//        JohnPrincipal principal = new JohnPrincipal();
//        principal.setUsername("jnguyen85");
//        principal.setId("123");
//        principal.setRole("users");
//
//
//        Users user = new Users();
//        user.setUser_id("123");
//        user.setUsername("jnguyen8585");
//        user.setPassword("Jnguyen85!");
//        user.setRole(new Roles("123", "users"));
//
//        when(mockUserRepository.findUserByUsernameAndPassword("jnguyen85", "Jnguyen8585!")).thenReturn(user);
//        when(mockUserService.login(loginRequest)).thenReturn(new JohnPrincipal("123", "username", "users"));
//        when(mockUserService.login(loginRequest)).thenReturn(principal);
//        when(authController.login(loginRequest, any(), any())).thenReturn(principal);
//
//        JohnPrincipal returnPrincipal = authController.login(loginRequest, any(), any());
    }

    @After
    public void tearDown() throws Exception {
    }
}