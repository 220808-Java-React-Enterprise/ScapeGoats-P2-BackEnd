package com.revature.tarotcards.p2scapegoats.services.melissa;

import com.revature.tarotcards.p2scapegoats.dtos.request.melissa.NewUserRequest;
import com.revature.tarotcards.p2scapegoats.models.melissa.Consultants;
import com.revature.tarotcards.p2scapegoats.models.melissa.Users;
import com.revature.tarotcards.p2scapegoats.repositories.melissa.RoleRepository;
import com.revature.tarotcards.p2scapegoats.repositories.melissa.UserRepository;

import com.revature.tarotcards.p2scapegoats.utils.melissa.custom_exceptions.InvalidRequestException;
import com.revature.tarotcards.p2scapegoats.utils.melissa.custom_exceptions.ResourceConflictException;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.UUID;

@Service
@Transactional
public class UserService {

    private final UserRepository userRepo;
    private final RoleRepository roleRepo;

    public UserService(UserRepository userRepo, RoleRepository roleRepo) {
        this.userRepo = userRepo;
        this.roleRepo = roleRepo;
    }

    public List<Users> getAll(){
        List<Users> users = (List<Users>)userRepo.findAll();
        if(users.size() == 0) throw new InvalidRequestException("No users found");
        return users;
    }

    public List<Consultants> getConsultants(String user_id){
        Users user = userRepo.findUsersByUser_id(user_id);

        // return null for now. otherwise get infinite recursion call. figure this out later
        return null;
    }

    public Users addUser(NewUserRequest request){
        Users users = null;
        if (!isDuplicateUsername(request.getUsername())) {
            if (isValidPassword(request.getPassword())) {
                if (isValidUsername(request.getUsername())) {
                    users = new Users(UUID.randomUUID().toString(), request.getUsername(), request.getFirstname(), request.getLastname(), request.getPassword(), request.getEmail(), roleRepo.findByTitle("user"), false);
                    userRepo.save(users);
                }
            }
       }
        return users;
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
        if (userRepo.findUsernameByUsername(username)!=null) throw new ResourceConflictException("Sorry, " + username + " already taken");
        return false;
    }
    public boolean isValidUsername(String username){
        if(!username.matches("^[a-zA-Z0-9]([._](?![._])|[a-zA-Z0-9]){4,19}")){
            throw new InvalidRequestException("\nUsername not valid.\nUsername can only contain alphanumerics" +
                    "\nMust Start with alphanumerics\nCan only contain _ and . and they can't be next to eachother\n" +
                    "Must have 5-20 characters");
        }
        return true;
    }

    public void delete(Users user){
        userRepo.delete(user);
    }

}
