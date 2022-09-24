package com.revature.tarotcards.p2scapegoats.controllers.john;

import com.revature.tarotcards.p2scapegoats.dtos.john.request.JohnNewReadingRequest;
import com.revature.tarotcards.p2scapegoats.models.melissa.Readings;
import com.revature.tarotcards.p2scapegoats.services.john.JohnReadingService;
import com.revature.tarotcards.p2scapegoats.services.melissa.ReadingService;
import com.revature.tarotcards.p2scapegoats.utils.melissa.custom_exceptions.InvalidRequestException;
import com.revature.tarotcards.p2scapegoats.utils.melissa.custom_exceptions.InvalidSQLException;
import com.revature.tarotcards.p2scapegoats.utils.melissa.custom_exceptions.ResourceConflictException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/readings")
public class JohnReadingController {
    @Autowired
    private JohnReadingService readingService;

    @CrossOrigin
    //@ExceptionHandler(value = {ResourceConflictException.class, InvalidRequestException.class, InvalidSQLException.class})
    @ResponseStatus(value = HttpStatus.CREATED)
    @GetMapping(value = "/byid")//, consumes = "application/json", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public List<Readings> getAllById(@RequestParam(required = false)String userid){

    //public @ResponseBody List<Readings> getAllById(@RequestParam(required = false) String userid) {

        return readingService.getAllByUserId(userid);

    }

    @CrossOrigin
    //@ExceptionHandler(value = {ResourceConflictException.class, InvalidRequestException.class, InvalidSQLException.class})
    @ResponseStatus(value = HttpStatus.CREATED)
    @PostMapping(value = "", consumes = "application/json", produces = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody Readings createReading(@RequestBody JohnNewReadingRequest request) {

        return readingService.save(request);

    }


    @CrossOrigin
    //@ExceptionHandler(value = {ResourceConflictException.class, InvalidRequestException.class})
    @ResponseStatus(value = HttpStatus.CREATED)
    @PutMapping(value = "", consumes = "application/json", produces = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody Readings updateReading(@RequestBody JohnNewReadingRequest request) {

        return readingService.update(request);
    }

    @CrossOrigin
    //@ExceptionHandler(value = {ResourceConflictException.class, InvalidRequestException.class})
    @ResponseStatus(value = HttpStatus.CREATED)
    @GetMapping(value="", produces = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody List<Readings> getAll() {
        return readingService.getAllReadings();
    }


    @CrossOrigin
    //@ExceptionHandler(value = {ResourceConflictException.class, InvalidRequestException.class})
    @ResponseStatus(value = HttpStatus.CREATED)
    @DeleteMapping(value = "", consumes = "application/json", produces = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody String deleteReading(@RequestBody JohnNewReadingRequest request) {
        readingService.deleteReading(request);
        return request.getReading_id();
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
