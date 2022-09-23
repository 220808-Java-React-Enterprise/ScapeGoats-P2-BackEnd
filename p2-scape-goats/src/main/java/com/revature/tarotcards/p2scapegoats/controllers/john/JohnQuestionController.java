package com.revature.tarotcards.p2scapegoats.controllers.john;
import com.revature.tarotcards.p2scapegoats.dtos.john.request.JohnNewQuestionRequest;
import com.revature.tarotcards.p2scapegoats.dtos.john.response.JohnPrincipal;
import com.revature.tarotcards.p2scapegoats.models.melissa.Questions;
import com.revature.tarotcards.p2scapegoats.models.melissa.Roles;
import com.revature.tarotcards.p2scapegoats.services.john.JohnCategoryService;
import com.revature.tarotcards.p2scapegoats.services.john.JohnQuestionService;
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
@RequestMapping("/questions")
public class JohnQuestionController {
    @Autowired
    private JohnQuestionService questionService;

    @Autowired
    private TokenService tokenService;

    @Autowired
    private RoleService roleService;
    
    @Autowired
    private JohnCategoryService categoryService;
    
    @CrossOrigin(exposedHeaders = "authorization")
    @ExceptionHandler(value = {ResourceConflictException.class, InvalidRequestException.class, InvalidSQLException.class})
    @ResponseStatus(value = HttpStatus.CREATED)
    @PostMapping(value = "", consumes = "application/json", produces = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody Questions createQuestion(@RequestHeader(value = "authorization") String token, @RequestBody JohnNewQuestionRequest request) {
        if (token == null) {
            throw new AuthenticationException("Sorry, you are not authorized to make this request");
        }

        JohnPrincipal principal = tokenService.extractRequesterDetails(token);
        Roles role = roleService.findByRole_id(principal.getRole());
        if (role.getTitle().equalsIgnoreCase("USERS") || role.getTitle().equalsIgnoreCase("ADMIN"));
        {
            return questionService.save(request);
        }
    }

    @CrossOrigin(exposedHeaders = "authorization")
    @ExceptionHandler(value = {ResourceConflictException.class, InvalidRequestException.class})
    @ResponseStatus(value = HttpStatus.ACCEPTED)

    // POSTMAN url => http://localhost:8080/p2-scape-goats/questions
    // BODY OF POSTMAN
    /*
            {
                "id": "a4001f08-8bd1-475c-98f0-6acda16bf7e0",
                "question": "Will I get a divorce UPDATED UPDATED?",
                "category_id": "b1fcb4f1-7e59-45c7-9ad4-fe7e7935a096"
            }
     */
    

    @PutMapping(value = "", consumes = "application/json", produces = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody Questions updateQuestion(@RequestHeader(value = "authorization") String token, @RequestBody JohnNewQuestionRequest request) {
        if (token == null) {
            throw new AuthenticationException("Sorry, you are not authorized to make this request");
        }

        JohnPrincipal principal = tokenService.extractRequesterDetails(token);
        Roles role = roleService.findByRole_id(principal.getRole());
        if (role.getTitle().equalsIgnoreCase("USERS") || role.getTitle().equalsIgnoreCase("ADMIN"));
        {
            return questionService.update(request);
        }
    }

    @CrossOrigin(exposedHeaders = "authorization")
    @ExceptionHandler(value = {ResourceConflictException.class, InvalidRequestException.class})
    @ResponseStatus(value = HttpStatus.ACCEPTED)
    
    // POSTMAN url => http://localhost:8080/p2-scape-goats/questions

    @GetMapping(value="", produces = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody List<Questions> getAll(@RequestHeader(value = "authorization") String token) {

        if (token == null) {
            throw new AuthenticationException("Sorry, you are not authorized to make this request");
        }

        JohnPrincipal principal = tokenService.extractRequesterDetails(token);
        Roles role = roleService.findByRole_id(principal.getRole());
        if (role.getTitle().equalsIgnoreCase("USERS") || role.getTitle().equalsIgnoreCase("ADMIN"));
        {
            return questionService.getAllQuestions();
        }


    }
    @CrossOrigin(exposedHeaders = "authorization")
    @ExceptionHandler(value = {ResourceConflictException.class, InvalidRequestException.class})
    @ResponseStatus(value = HttpStatus.ACCEPTED)
    @DeleteMapping(value = "", consumes = "application/json", produces = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody String deleteQuestion(@RequestHeader(value = "authorization") String token, @RequestBody JohnNewQuestionRequest request) {
        if (token == null) {
            throw new AuthenticationException("Sorry, you are not authorized to make this request");
        }

        JohnPrincipal principal = tokenService.extractRequesterDetails(token);
        Roles role = roleService.findByRole_id(principal.getRole());
        if (role.getTitle().equalsIgnoreCase("USERS") || role.getTitle().equalsIgnoreCase("ADMIN"));
        {
            questionService.deleteQuestion(request);
            return request.getId();
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
}
