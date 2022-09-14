package com.revature.tarotcards.p2scapegoats.services.melissa;

import com.revature.tarotcards.p2scapegoats.dtos.request.melissa.NewUserRequest;
import com.revature.tarotcards.p2scapegoats.models.melissa.Users;
import com.revature.tarotcards.p2scapegoats.repositories.melissa.UserRepository;

import com.revature.tarotcards.p2scapegoats.utils.melissa.custom_exceptions.InvalidRequestException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class UserService {

    private final UserRepository userRepo;

    public UserService(UserRepository userRepo) {
        this.userRepo = userRepo;
    }

    public List<Users> getAll(){
        return (List<Users>) userRepo.findAll();
    }

    public String addUser(NewUserRequest request){
        Users users = null;
        if(!isDuplicateUsername(request.getUsername())) {
            if(isValidPassword(request.getPassword())) {
                if(isValidUsername(request.getUsername())) {
                    users = new Users(UUID.randomUUID().toString(), request.getUsername(), request.getFirstname(), request.getLastname(), request.getPassword(), request.getEmail(), "456", null);
                    userRepo.save(users);
                }
            }
        }
        return users.getFirstName() + "has been added";
    }
    public boolean isValidPassword(String password){
        if(!password.matches("^(?=.*?[A-Z])(?=.*?[a-z])(?=.*?[0-9])(?=.*?[#?!@$%^&*-]).{8,}$")){
            throw new InvalidRequestException("Password must contain at least 8 chars\nContain at least one digit\n" +
                    "Contain at least one lower alpha char and one upper alpha char\nContain at least one special char\n" +
                    "Does NOT contain spaces or tabs etc");
        }
        return true;
    }

    public boolean isDuplicateUsername(String username){
        if (userRepo.findById(username)==null) return false;
        return true;
    }
    public boolean isValidUsername(String username){
        if(!username.matches("^[a-zA-Z0-9]([._](?![._])|[a-zA-Z0-9]){4,19}")){
            throw new InvalidRequestException("\nUsername not valid.\nUsername can only contain alphanumerics" +
                    "\nMust Start with alphanumerics\nCan only contain _ and . and they can't be next to eachother\n" +
                    "Must have 5-20 characters");
        }
        return true;
    }

    public void deleteUser(Users user){
        userRepo.delete(user);
    }
}
