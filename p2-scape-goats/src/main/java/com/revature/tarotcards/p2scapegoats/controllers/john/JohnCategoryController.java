package com.revature.tarotcards.p2scapegoats.controllers.john;


import com.revature.tarotcards.p2scapegoats.dtos.john.request.JohnNewCategoryRequest;
import com.revature.tarotcards.p2scapegoats.dtos.john.response.JohnPrincipal;
import com.revature.tarotcards.p2scapegoats.models.melissa.Categories;
import com.revature.tarotcards.p2scapegoats.models.melissa.Roles;
import com.revature.tarotcards.p2scapegoats.models.melissa.Users;
import com.revature.tarotcards.p2scapegoats.services.john.JohnCategoryService;
import com.revature.tarotcards.p2scapegoats.services.melissa.RoleService;
import com.revature.tarotcards.p2scapegoats.services.melissa.TokenService;
import com.revature.tarotcards.p2scapegoats.utils.melissa.custom_exceptions.AuthenticationException;
import com.revature.tarotcards.p2scapegoats.utils.melissa.custom_exceptions.InvalidRequestException;
import com.revature.tarotcards.p2scapegoats.utils.melissa.custom_exceptions.ResourceConflictException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/john/categories")
public class JohnCategoryController {

    @Autowired
    private JohnCategoryService categoryService;
    @Autowired
    private TokenService tokenService;

    @Autowired
    private RoleService roleService;

    @CrossOrigin(exposedHeaders = "authorization")
    @ExceptionHandler(value = {ResourceConflictException.class, InvalidRequestException.class})
    @ResponseStatus(value = HttpStatus.BAD_REQUEST)
    @PostMapping(value = "", consumes = "application/json", produces = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody Categories createCategory(
            @RequestHeader(value = "authorization") String token,
            @RequestBody JohnNewCategoryRequest request) {
        if (token == null) {
            throw new AuthenticationException("Sorry, you are not authorized to make this request");
        }
        //String sessionToken = (String) session.getAttribute("token");
        JohnPrincipal principal = tokenService.extractRequesterDetails(token);
        Roles role = roleService.findByRole_id(principal.getRole());
        if (role.getTitle().equalsIgnoreCase("USERS"));
        {
            return categoryService.save(request);
        }
    }

    @CrossOrigin(exposedHeaders = "authorization")
    @ExceptionHandler(value = {ResourceConflictException.class, InvalidRequestException.class})
    @ResponseStatus(value = HttpStatus.BAD_REQUEST)
    @PutMapping(value = "", consumes = "application/json", produces = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody Categories updateCategory(@RequestBody JohnNewCategoryRequest request) {
        return categoryService.update(request);
    }
    @CrossOrigin(exposedHeaders = "authorization")
    @ExceptionHandler(value = {
            AuthenticationException.class, ResourceConflictException.class,
            InvalidRequestException.class})
    @ResponseStatus(value = HttpStatus.BAD_REQUEST)
    @GetMapping(value = "", produces = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody List<Categories> getAll(@RequestHeader(value = "authorization") String token, HttpSession session){
        if (token == null) {
            throw new AuthenticationException("Sorry, you are not authorized to make this request");
        }

        JohnPrincipal principal = tokenService.extractRequesterDetails(token);
        Roles role = roleService.findByRole_id(principal.getRole());
        if (role.getTitle().equalsIgnoreCase("USERS") || role.getTitle().equalsIgnoreCase("ADMIN"));
        {
            return categoryService.getAllCategories();
        }
    }

    @CrossOrigin(exposedHeaders = "authorization")
    @ExceptionHandler(value = {ResourceConflictException.class, InvalidRequestException.class})
    @ResponseStatus(value = HttpStatus.BAD_REQUEST)
    @DeleteMapping(value = "", consumes = "application/json", produces = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody String deleteCategory(@RequestHeader(value = "authorization") String token, @RequestBody JohnNewCategoryRequest request) {
        if (token == null) {
            throw new AuthenticationException("Sorry, you are not authorized to make this request");
        }

        JohnPrincipal principal = tokenService.extractRequesterDetails(token);
        Roles role = roleService.findByRole_id(principal.getRole());
        if (role.getTitle().equalsIgnoreCase("USERS"));
        {
            //categoryService.deleteCategory(request);
            return "Deleted: " + request.getCategory();
        }

    }

    @ExceptionHandler
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public @ResponseBody InvalidRequestException handleInvalidRequestException(InvalidRequestException e) {
        return e;
    }

    @ExceptionHandler
    @ResponseStatus(HttpStatus.UNAUTHORIZED)
    public @ResponseBody AuthenticationException handleAuthenticationException(AuthenticationException e) {
        return e;
    }

}
