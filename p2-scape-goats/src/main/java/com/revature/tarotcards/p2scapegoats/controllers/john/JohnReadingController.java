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
    @ExceptionHandler(value = {ResourceConflictException.class, InvalidRequestException.class, InvalidSQLException.class})
    @ResponseStatus(value = HttpStatus.BAD_REQUEST)
    @PostMapping(value = "", consumes = "application/json", produces = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody Readings createReading(@RequestBody JohnNewReadingRequest request) {

        return readingService.save(request);

    }


    @CrossOrigin
    @ExceptionHandler(value = {ResourceConflictException.class, InvalidRequestException.class})
    @ResponseStatus(value = HttpStatus.BAD_REQUEST)
    @PutMapping(value = "", consumes = "application/json", produces = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody Readings updateReading(@RequestBody JohnNewReadingRequest request) {

        return readingService.update(request);
    }
    @CrossOrigin(exposedHeaders = "authorization")
    @ExceptionHandler(value = {ResourceConflictException.class, InvalidRequestException.class})
    @ResponseStatus(value = HttpStatus.BAD_REQUEST)
    @GetMapping(value="", produces = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody List<Readings> getAll() {
        return readingService.getAllReadings();
    }


    @CrossOrigin
    @ExceptionHandler(value = {ResourceConflictException.class, InvalidRequestException.class})
    @ResponseStatus(value = HttpStatus.BAD_REQUEST)
    @DeleteMapping(value = "", consumes = "application/json", produces = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody String deleteReading(@RequestBody JohnNewReadingRequest request) {
        readingService.deleteReading(request);
        return "Reading deleted....";
    }
}
