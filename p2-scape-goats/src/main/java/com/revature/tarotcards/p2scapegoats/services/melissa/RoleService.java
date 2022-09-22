package com.revature.tarotcards.p2scapegoats.services.melissa;

import com.revature.tarotcards.p2scapegoats.dtos.request.melissa.NewRoleRequest;
import com.revature.tarotcards.p2scapegoats.models.melissa.Roles;
import com.revature.tarotcards.p2scapegoats.repositories.melissa.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

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

    public Roles findByRole_id(String roleId) {
        return roleRepo.findByRole_id(roleId);


    }


    public Roles addRole(NewRoleRequest request){
        Roles role = new Roles(request.getRole_id(), request.getTitle());
        roleRepo.save(role);
        return role;
    }
}
