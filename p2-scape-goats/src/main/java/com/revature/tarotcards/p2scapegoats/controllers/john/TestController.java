package com.revature.tarotcards.p2scapegoats.controllers.john;


import com.revature.tarotcards.p2scapegoats.models.melissa.Readings;
import com.revature.tarotcards.p2scapegoats.utils.melissa.custom_exceptions.InvalidRequestException;
import com.revature.tarotcards.p2scapegoats.utils.melissa.custom_exceptions.ResourceConflictException;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/quiz")
public class TestController {

    @CrossOrigin
    @ExceptionHandler(value = {ResourceConflictException.class, InvalidRequestException.class})
    @ResponseStatus(value = HttpStatus.BAD_REQUEST)
    @GetMapping(value="", produces = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody String getAll() {
        return "Hello World!";
    }
}
