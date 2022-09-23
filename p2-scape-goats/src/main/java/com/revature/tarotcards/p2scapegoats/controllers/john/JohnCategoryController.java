package com.revature.tarotcards.p2scapegoats.controllers.john;


import com.revature.tarotcards.p2scapegoats.dtos.john.request.JohnNewCategoryRequest;
import com.revature.tarotcards.p2scapegoats.models.melissa.Categories;
import com.revature.tarotcards.p2scapegoats.services.john.JohnCategoryService;
import com.revature.tarotcards.p2scapegoats.utils.melissa.custom_exceptions.InvalidRequestException;
import com.revature.tarotcards.p2scapegoats.utils.melissa.custom_exceptions.ResourceConflictException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/categories")
public class JohnCategoryController {

    @Autowired
    private JohnCategoryService categoryService;


    // To POST(CREATE) a catagory use POSTMAN and enter url: http://localhost:8080/p2-scape-goats/categories
    // Use POSTMAN body for application/text below:
    /*
        {
            "category" : "NAME OF CATEGORY HERE"
        }
    */
    @CrossOrigin
    //@ExceptionHandler(value = {ResourceConflictException.class, InvalidRequestException.class})
    @ResponseStatus(value = HttpStatus.CREATED)
    @PostMapping(value = "", consumes = "application/json", produces = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody Categories createCategory(@RequestBody JohnNewCategoryRequest request) {

        return categoryService.save(request);
    }


    // To PUT(UPDATE) a catagory use POSTMAN and enter url: http://localhost:8080/p2-scape-goats/categories
    // Use POSTMAN body for application.text below
    /*
        {
            {
                "id": "8e00c11e-03bf-4e49-9f0a-8655d9bd82a5",
                "category": "FINANCE"
             }
        }
    */
    @CrossOrigin
    //@ExceptionHandler(value = {ResourceConflictException.class, InvalidRequestException.class})
    @ResponseStatus(value = HttpStatus.CREATED)
    @PutMapping(value = "", consumes = "application/json", produces = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody Categories updateCategory(@RequestBody JohnNewCategoryRequest request) {
        return categoryService.update(request);
    }



    // To GET aLL catagories use POSTMAN and enter url: http://localhost:8080/p2-scape-goats/categories
    @CrossOrigin
    //@ExceptionHandler(value = {ResourceConflictException.class, InvalidRequestException.class})
    @ResponseStatus(value = HttpStatus.CREATED)
    @GetMapping(value="", produces = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody List<Categories> getAll() {
        return categoryService.getAllCategories();
    }

    // To DELETE a Category use POSTMAN and enter url: http://localhost:8080/p2-scape-goats/categories
    // Use POSTMAN body for application.text below
    /*
        "category": "LOVE"
    */
    @CrossOrigin
    //@ExceptionHandler(value = {ResourceConflictException.class, InvalidRequestException.class})
    @ResponseStatus(value = HttpStatus.CREATED)
    @DeleteMapping(value = "", consumes = "application/json", produces = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody String deleteCategory(@RequestBody JohnNewCategoryRequest request) {
        categoryService.deleteCategory(request);
        return request.getCategory();
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
