package com.revature.tarotcards.p2scapegoats.services.john;

import com.revature.tarotcards.p2scapegoats.dtos.john.request.JohnLoginRequest;
import com.revature.tarotcards.p2scapegoats.dtos.john.response.JohnPrincipal;
import com.revature.tarotcards.p2scapegoats.dtos.request.melissa.NewUserRequest;
import com.revature.tarotcards.p2scapegoats.models.melissa.Roles;
import com.revature.tarotcards.p2scapegoats.models.melissa.Users;
import com.revature.tarotcards.p2scapegoats.repositories.john.JohnRoleRepository;
import com.revature.tarotcards.p2scapegoats.repositories.john.JohnUserRepository;
import com.revature.tarotcards.p2scapegoats.utils.melissa.custom_exceptions.AuthenticationException;
import com.revature.tarotcards.p2scapegoats.utils.melissa.custom_exceptions.InvalidRequestException;
import com.revature.tarotcards.p2scapegoats.utils.melissa.custom_exceptions.ResourceConflictException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class JohnUserService {
    //@Autowired
    private final JohnUserRepository userRepo;

    @Autowired
    private JohnRoleRepository roleRepository;

    public JohnUserService(JohnUserRepository userRepo) {
        this.userRepo = userRepo;
    }

    public Users register(NewUserRequest request) {
        Users user = null;

        if (isValidUsername(request.getUsername())) {
            if (!isDuplicateUsername(request.getUsername())) {
                if (isValidPassword(request.getPassword())) {

//                    Category category = categoryService.findCategoryByCategory(request.getCategory());
//                    Question question = new Question(UUID.randomUUID().toString(), request.getQuestion(), category);
//                    question.setCategory(category);


                    Roles role = roleRepository.findRoleByTitle("USERS");
                    user = new Users(UUID.randomUUID().toString(), request.getUsername(), request.getPassword(), role);
                    user.setRole(role);
                    userRepo.save(user);
                }
            }
        }
        return user;
    }

    public JohnUserRepository getUserRepo() {
        return userRepo;
    }

    public JohnPrincipal login(JohnLoginRequest request) {
        Users user = userRepo.findUserByUsernameAndPassword(request.getUsername(), request.getPassword());
        if (user == null) throw new AuthenticationException("\nIncorrect username or password :(");
        return new JohnPrincipal(user.getUser_id(), user.getUsername(), user.getRole().getTitle());
    }

    public Optional<Users> getUserById(String id) {
        return userRepo.findById(id);
    }

    public Users getUserByUsername(String username) {
        if (userRepo.findUserByUsername(username) == null) throw new InvalidRequestException("Invalid request! There is no user by that username");
        return userRepo.findUserByUsername(username);
    }

    public List<Users> getAllUsers() {
        return (List<Users>) userRepo.findAll();
    }

    public boolean isValidUsername(String username) {
        if (!username.matches("^(?=[a-zA-Z0-9._]{8,20}$)(?!.*[_.]{2})[^_.].*[^_.]$")) throw new InvalidRequestException("Invalid username! username is 8-20 characters long. no _ or . at the beginning. no __ or _. or ._ or .. inside");
        return true;
    }

    public boolean isValidPassword(String password) {
        if (!password.matches("^(?=.*[A-Za-z])(?=.*\\d)[A-Za-z\\d]{8,}$")) throw new InvalidRequestException("Invalid password! Minimum eight characters, at least one letter and one number");
        return true;
    }

    public boolean isDuplicateUsername(String username) {
        if (userRepo.findUsernameByUsername(username) != null) throw new ResourceConflictException("Sorry, " + username + " already been taken :(");
        return false;
    }

    public boolean isSamePassword(String password, String password2) {
        if (!password.equals(password2)) throw new InvalidRequestException("Password do not match :(");
        return true;
    }

    public Users findUsersByUser_id(String id) {
        return userRepo.findUsersByUser_id(id);
    }
}