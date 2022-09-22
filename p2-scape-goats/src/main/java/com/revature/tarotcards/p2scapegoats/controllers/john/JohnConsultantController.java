package com.revature.tarotcards.p2scapegoats.controllers.john;


import com.revature.tarotcards.p2scapegoats.dtos.john.request.JohnNewConsultantRequest;
import com.revature.tarotcards.p2scapegoats.dtos.request.melissa.NewConsultantRequest;
import com.revature.tarotcards.p2scapegoats.models.melissa.Consultants;
import com.revature.tarotcards.p2scapegoats.services.john.JohnConsultantService;
import com.revature.tarotcards.p2scapegoats.utils.melissa.custom_exceptions.InvalidRequestException;
import com.revature.tarotcards.p2scapegoats.utils.melissa.custom_exceptions.ResourceConflictException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/consultants")
public class JohnConsultantController {
    @Autowired
    private JohnConsultantService consultantService;


    @CrossOrigin
    @ExceptionHandler(value = {ResourceConflictException.class, InvalidRequestException.class})
    @ResponseStatus(value = HttpStatus.BAD_REQUEST)
    @PostMapping(value = "", consumes = "application/json", produces = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody Consultants createConsultant(@RequestBody JohnNewConsultantRequest request) {

        return consultantService.save(request);
    }


    @CrossOrigin
    @ExceptionHandler(value = {ResourceConflictException.class, InvalidRequestException.class})
    @ResponseStatus(value = HttpStatus.BAD_REQUEST)
    @PutMapping(value = "", consumes = "application/json", produces = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody Consultants updateConsultant(@RequestBody JohnNewConsultantRequest request) {
        return consultantService.update(request);
    }



    @CrossOrigin
    @ExceptionHandler(value = {ResourceConflictException.class, InvalidRequestException.class})
    @ResponseStatus(value = HttpStatus.BAD_REQUEST)
    @GetMapping(value="", produces = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody List<Consultants> getAll() {
        return consultantService.getAllConsultants();
    }

    @CrossOrigin
    @ExceptionHandler(value = {ResourceConflictException.class, InvalidRequestException.class})
    @ResponseStatus(value = HttpStatus.BAD_REQUEST)
    @DeleteMapping(value = "", consumes = "application/json", produces = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody String deleteCategory(@RequestBody JohnNewConsultantRequest request) {
        consultantService.deleteConsultant(request);
        return "Deleted : " +  request.getId();
    }

}
