package com.revature.tarotcards.p2scapegoats.controllers.john;

import com.fasterxml.jackson.databind.ObjectMapper;

import com.revature.tarotcards.p2scapegoats.dtos.john.request.JohnLoginRequest;
import com.revature.tarotcards.p2scapegoats.dtos.john.response.JohnPrincipal;
import com.revature.tarotcards.p2scapegoats.services.john.JohnUserService;
import com.revature.tarotcards.p2scapegoats.services.melissa.TokenService;
import com.revature.tarotcards.p2scapegoats.utils.melissa.custom_exceptions.AuthenticationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@RestController
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    private  ObjectMapper mapper;
    @Autowired
    private TokenService tokenService;
    @Autowired
    private JohnUserService userService;
<<<<<<< HEAD
    @CrossOrigin(exposedHeaders = "authorization")
    @ResponseStatus(HttpStatus.ACCEPTED)
    @PostMapping(value = "/login", consumes = "application/json", produces = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody JohnPrincipal login(@RequestBody JohnLoginRequest request, HttpSession session, HttpServletResponse response) throws IOException {

        JohnPrincipal principal = userService.login(request);
        String token = tokenService.generateToken(principal);

        // back up in-case token doesn't work
        session.setAttribute("token", token);

        // make sure letter 'a' of authorization is not capital A
        response.setHeader("authorization", token);

        return principal;
=======


    // POSTMAN url => http://localhost:8080/p2-scape-goats/auth/login
    // BODY OF POSTMAN
    /*
            {
                "username": "testing123",
                "password": "Passw0rd@"
            }
     */
    @CrossOrigin (exposedHeaders = "authorization") // CORS

    @PostMapping(value = "/login", consumes = "application/json")
    public void login(@RequestBody JohnLoginRequest request, HttpServletResponse response) throws IOException {
        //sg-06c920b7de7968f90
        //P2scapegoats-env.eba-rduyqz4i.us-west-1.elasticbeanstalk.com

        JohnPrincipal principal = userService.login(request);
        String token = tokenService.generateToken(principal);
        response.setStatus(200);
        response.setHeader("authorization", token);
        response.setContentType("application/json");
        response.getWriter().write(mapper.writeValueAsString(principal));
>>>>>>> b3455159aae3194953c09fb74dcce030fb930be1
    }

    @ExceptionHandler
    @ResponseStatus(HttpStatus.UNAUTHORIZED)
    public @ResponseBody AuthenticationException handleAuthenticationException(AuthenticationException e) {
        return e;
    }
}
