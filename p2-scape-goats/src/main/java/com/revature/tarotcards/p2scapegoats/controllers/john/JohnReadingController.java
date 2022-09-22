package com.revature.tarotcards.p2scapegoats.controllers.john;

import com.revature.tarotcards.p2scapegoats.dtos.john.request.JohnNewReadingRequest;
import com.revature.tarotcards.p2scapegoats.dtos.john.response.JohnPrincipal;
import com.revature.tarotcards.p2scapegoats.models.melissa.Readings;
import com.revature.tarotcards.p2scapegoats.models.melissa.Roles;
import com.revature.tarotcards.p2scapegoats.services.john.JohnReadingService;
import com.revature.tarotcards.p2scapegoats.services.melissa.RoleService;
import com.revature.tarotcards.p2scapegoats.services.melissa.TokenService;
import com.revature.tarotcards.p2scapegoats.utils.melissa.custom_exceptions.AuthenticationException;
import com.revature.tarotcards.p2scapegoats.utils.melissa.custom_exceptions.InvalidRequestException;
import com.revature.tarotcards.p2scapegoats.utils.melissa.custom_exceptions.InvalidSQLException;
import com.revature.tarotcards.p2scapegoats.utils.melissa.custom_exceptions.ResourceConflictException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/readings")
public class JohnReadingController {
    @Autowired
    private JohnReadingService readingService;

    @Autowired
    private TokenService tokenService;

    @Autowired
    private RoleService roleService;

    @CrossOrigin(exposedHeaders = "authorization")
    @ExceptionHandler(value = {ResourceConflictException.class, InvalidRequestException.class, InvalidSQLException.class})
    @ResponseStatus(value = HttpStatus.BAD_REQUEST)
    @PostMapping(value = "", consumes = "application/json", produces = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody JohnNewReadingRequest createReading(@RequestHeader(value = "authorization") String token, @RequestBody JohnNewReadingRequest request) {
        if (token == null) {
            throw new AuthenticationException("Sorry, you are not authorized to make this request");
        }

        JohnPrincipal principal = tokenService.extractRequesterDetails(token);
        request.setUser_id(principal.getId());
        Roles role = roleService.findByRole_id(principal.getRole());
        if (role.getTitle().equalsIgnoreCase("USERS") || role.getTitle().equalsIgnoreCase("ADMIN"));
        {
            readingService.save(request);
            return request;
        }
    }


    @CrossOrigin(exposedHeaders = "authorization")
    @ExceptionHandler(value = {ResourceConflictException.class, InvalidRequestException.class})
    @ResponseStatus(value = HttpStatus.BAD_REQUEST)
    @PutMapping(value = "", consumes = "application/json", produces = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody Readings updateReading(@RequestHeader(value = "authorization") String token, @RequestBody JohnNewReadingRequest request) {
        if (token == null) {
            throw new AuthenticationException("Sorry, you are not authorized to make this request");
        }

        JohnPrincipal principal = tokenService.extractRequesterDetails(token);
        Roles role = roleService.findByRole_id(principal.getRole());
        if (role.getTitle().equalsIgnoreCase("USERS") || role.getTitle().equalsIgnoreCase("ADMIN"));
        {
            return readingService.update(request);
        }

    }
    @CrossOrigin(exposedHeaders = "authorization")
    @ExceptionHandler(value = {ResourceConflictException.class, InvalidRequestException.class})
    @ResponseStatus(value = HttpStatus.BAD_REQUEST)
    @GetMapping(value="", produces = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody List<Readings> getAll(@RequestHeader(value = "authorization") String token) {

        if (token == null) {
            throw new AuthenticationException("Sorry, you are not authorized to make this request");
        }

        JohnPrincipal principal = tokenService.extractRequesterDetails(token);
        Roles role = roleService.findByRole_id(principal.getRole());
        if (role.getTitle().equalsIgnoreCase("USERS") || role.getTitle().equalsIgnoreCase("ADMIN"));
        {
            return readingService.getAllReadings();
        }

    }

    @CrossOrigin(exposedHeaders = "authorization")
    @ExceptionHandler(value = {ResourceConflictException.class, InvalidRequestException.class})
    @ResponseStatus(value = HttpStatus.BAD_REQUEST)
    @DeleteMapping(value = "", consumes = "application/json", produces = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody String deleteReading(@RequestHeader(value = "authorization") String token, @RequestBody JohnNewReadingRequest request) {

        if (token == null) {
            throw new AuthenticationException("Sorry, you are not authorized to make this request");
        }

        JohnPrincipal principal = tokenService.extractRequesterDetails(token);
        Roles role = roleService.findByRole_id(principal.getRole());
        if (role.getTitle().equalsIgnoreCase("USERS") || role.getTitle().equalsIgnoreCase("ADMIN"));
        {
            try {
                readingService.deleteReading(request);
            }catch (Exception e) {

            }finally {
                return "Reading deleted....";
            }
        }
    }
}
