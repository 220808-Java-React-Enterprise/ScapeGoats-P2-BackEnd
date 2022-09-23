package com.revature.tarotcards.p2scapegoats.controllers.john;


import com.revature.tarotcards.p2scapegoats.dtos.john.request.JohnNewConsultantRequest;
import com.revature.tarotcards.p2scapegoats.dtos.john.response.JohnPrincipal;
import com.revature.tarotcards.p2scapegoats.dtos.request.melissa.NewConsultantRequest;
import com.revature.tarotcards.p2scapegoats.models.melissa.Consultants;
import com.revature.tarotcards.p2scapegoats.models.melissa.Roles;
import com.revature.tarotcards.p2scapegoats.services.john.JohnConsultantService;
import com.revature.tarotcards.p2scapegoats.services.melissa.RoleService;
import com.revature.tarotcards.p2scapegoats.services.melissa.TokenService;
import com.revature.tarotcards.p2scapegoats.utils.melissa.custom_exceptions.AuthenticationException;
import com.revature.tarotcards.p2scapegoats.utils.melissa.custom_exceptions.InvalidRequestException;
import com.revature.tarotcards.p2scapegoats.utils.melissa.custom_exceptions.ResourceConflictException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/consultants")
public class JohnConsultantController {
    @Autowired
    private JohnConsultantService consultantService;

    @Autowired
    private TokenService tokenService;

    @Autowired
    private RoleService roleService;


    @CrossOrigin(exposedHeaders = "authorization")
    @ResponseStatus(value = HttpStatus.CREATED)
    @PostMapping(value = "", consumes = "application/json", produces = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody Consultants createConsultant(@RequestHeader(value = "authorization") String token, @RequestBody JohnNewConsultantRequest request) {
        if (token == null) {
            throw new AuthenticationException("Sorry, you are not authorized to make this request");
        }

        JohnPrincipal principal = tokenService.extractRequesterDetails(token);
        Roles role = roleService.findByRole_id(principal.getRole());
        if (role.getTitle().equalsIgnoreCase("USERS") || role.getTitle().equalsIgnoreCase("ADMIN"));
        {
            return consultantService.save(request);
        }

    }


    @CrossOrigin(exposedHeaders = "authorization")
    @ResponseStatus(value = HttpStatus.CREATED)
    @PutMapping(value = "", consumes = "application/json", produces = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody Consultants updateConsultant(@RequestHeader(value = "authorization") String token, @RequestBody JohnNewConsultantRequest request) {

        if (token == null) {
            throw new AuthenticationException("Sorry, you are not authorized to make this request");
        }

        JohnPrincipal principal = tokenService.extractRequesterDetails(token);
        Roles role = roleService.findByRole_id(principal.getRole());
        if (role.getTitle().equalsIgnoreCase("USERS") || role.getTitle().equalsIgnoreCase("ADMIN"));
        {
            return consultantService.update(request);
        }

    }



    @CrossOrigin(exposedHeaders = "authorization")
    @ResponseStatus(value = HttpStatus.CREATED)
    @GetMapping(value="", produces = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody List<Consultants> getAll(@RequestHeader(value = "authorization") String token) {
        if (token == null) {
            throw new AuthenticationException("Sorry, you are not authorized to make this request");
        }

        JohnPrincipal principal = tokenService.extractRequesterDetails(token);
        Roles role = roleService.findByRole_id(principal.getRole());
        if (role.getTitle().equalsIgnoreCase("USERS") || role.getTitle().equalsIgnoreCase("ADMIN"));
        {
            return consultantService.getAllConsultants();
        }

    }

    @CrossOrigin(exposedHeaders = "authorization")
    @ResponseStatus(value = HttpStatus.CREATED)
    @DeleteMapping(value = "", consumes = "application/json", produces = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody String deleteConsultant(@RequestHeader(value = "authorization") String token, @RequestBody JohnNewConsultantRequest request) {
        if (token == null) {
            throw new AuthenticationException("Sorry, you are not authorized to make this request");
        }

        JohnPrincipal principal = tokenService.extractRequesterDetails(token);
        Roles role = roleService.findByRole_id(principal.getRole());
        if (role.getTitle().equalsIgnoreCase("USERS") || role.getTitle().equalsIgnoreCase("ADMIN"));
        {
            consultantService.deleteConsultant(request);
        }
        return "Deleted : " +  request.getId();
    }

    @ExceptionHandler
    @ResponseStatus(HttpStatus.CONFLICT)
    public @ResponseBody ResourceConflictException handleResourceConflictException(ResourceConflictException e){
        return e;
    }
    @ExceptionHandler
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public @ResponseBody InvalidRequestException handleInvalidRequestException(InvalidRequestException e){
        return e;
    }

}
