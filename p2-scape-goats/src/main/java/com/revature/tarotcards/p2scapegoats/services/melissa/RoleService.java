package com.revature.tarotcards.p2scapegoats.services.melissa;

import com.revature.tarotcards.p2scapegoats.dtos.request.melissa.NewRoleRequest;
import com.revature.tarotcards.p2scapegoats.models.melissa.Roles;
import com.revature.tarotcards.p2scapegoats.repositories.melissa.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.management.relation.Role;
import java.util.List;

@Service  //bean that talks to other beans - beans are singleton design patterns
public class RoleService {
    @Autowired //for dependency injection
    private final RoleRepository roleRepo;

    public RoleService(RoleRepository roleRepo) {
        this.roleRepo = roleRepo;
    }

    public List<Roles> getAll(){
        return (List<Roles>) roleRepo.findAll();
    }

    public List<String> roles;

    public Roles addRole(NewRoleRequest request){
        Roles role = new Roles(request.getRole_id(), request.getTitle());
        roleRepo.save(role);
        return role;
    }
}
