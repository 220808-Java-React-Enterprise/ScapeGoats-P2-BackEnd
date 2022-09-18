package com.revature.tarotcards.p2scapegoats.controllers.john;


import com.revature.tarotcards.p2scapegoats.dtos.john.request.JohnNewQuestionRequest;
import com.revature.tarotcards.p2scapegoats.dtos.request.melissa.NewQuestionRequest;
import com.revature.tarotcards.p2scapegoats.models.melissa.Categories;
import com.revature.tarotcards.p2scapegoats.models.melissa.Questions;
import com.revature.tarotcards.p2scapegoats.services.john.JohnCategoryService;
import com.revature.tarotcards.p2scapegoats.services.john.JohnQuestionService;
import com.revature.tarotcards.p2scapegoats.utils.melissa.custom_exceptions.InvalidRequestException;
import com.revature.tarotcards.p2scapegoats.utils.melissa.custom_exceptions.InvalidSQLException;
import com.revature.tarotcards.p2scapegoats.utils.melissa.custom_exceptions.ResourceConflictException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/questions")
public class JohnQuestionController {

    @Autowired
    private JohnQuestionService questionService;

    @Autowired
    private JohnCategoryService categoryService;

    // POSTMAN url => http://localhost:8080/p2-scape-goats/questions
    // BODY OF POSTMAN
    /*
            {
                "question": "Will I be married?",
                "category": "LOVE"
            }
     */

    @CrossOrigin
    @ExceptionHandler(value = {ResourceConflictException.class, InvalidRequestException.class, InvalidSQLException.class})
    @ResponseStatus(value = HttpStatus.BAD_REQUEST)
    @PostMapping(value = "", consumes = "application/json", produces = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody Questions createQuestion(@RequestBody JohnNewQuestionRequest request) {

        return questionService.save(request);
    }

    // POSTMAN url => http://localhost:8080/p2-scape-goats/questions
    // BODY OF POSTMAN
    /*
            {
                "id": "a4001f08-8bd1-475c-98f0-6acda16bf7e0",
                "question": "Will I get a divorce UPDATED UPDATED?",
                "category_id": "b1fcb4f1-7e59-45c7-9ad4-fe7e7935a096"
            }
     */
    @CrossOrigin
    @ExceptionHandler(value = {ResourceConflictException.class, InvalidRequestException.class})
    @ResponseStatus(value = HttpStatus.BAD_REQUEST)
    @PutMapping(value = "", consumes = "application/json", produces = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody Questions updateQuestion(@RequestBody JohnNewQuestionRequest request) {

        return questionService.update(request);

    }

    // POSTMAN url => http://localhost:8080/p2-scape-goats/questions
    @CrossOrigin
    @ExceptionHandler(value = {ResourceConflictException.class, InvalidRequestException.class})
    @ResponseStatus(value = HttpStatus.BAD_REQUEST)
    @GetMapping(value="", produces = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody List<Questions> getAll() {
        return questionService.getAllQuestions();
    }


    // POSTMAN url => http://localhost:8080/p2-scape-goats/questions
    // BODY OF POSTMAN
    /*
            {
                "id": "a4001f08-8bd1-475c-98f0-6acda16bf7e0"
            }
     */

    @CrossOrigin
    @ExceptionHandler(value = {ResourceConflictException.class, InvalidRequestException.class})
    @ResponseStatus(value = HttpStatus.BAD_REQUEST)
    @DeleteMapping(value = "", consumes = "application/json", produces = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody String deleteQuestion(@RequestBody JohnNewQuestionRequest request) {
        questionService.deleteQuestion(request);
        return request.getId();
    }


}
