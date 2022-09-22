package com.revature.tarotcards.p2scapegoats.controllers.john;

import com.fasterxml.jackson.databind.ObjectMapper;

import com.revature.tarotcards.p2scapegoats.dtos.john.request.JohnLoginRequest;
import com.revature.tarotcards.p2scapegoats.dtos.john.response.JohnPrincipal;
import com.revature.tarotcards.p2scapegoats.services.john.JohnUserService;
import com.revature.tarotcards.p2scapegoats.services.melissa.TokenService;
import com.revature.tarotcards.p2scapegoats.services.melissa.UserService;
import com.revature.tarotcards.p2scapegoats.utils.melissa.custom_exceptions.AuthenticationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
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
    }

    @ExceptionHandler
    @ResponseStatus(HttpStatus.UNAUTHORIZED)
    public @ResponseBody AuthenticationException handleAuthenticationException(AuthenticationException e) {
        return e;
    }
}
