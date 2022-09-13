package com.revature.tarotcards.p2scapegoats.controllers.melissa;


import com.revature.tarotcards.p2scapegoats.dtos.request.melissa.NewRoleRequest;
import com.revature.tarotcards.p2scapegoats.models.melissa.Roles;
import com.revature.tarotcards.p2scapegoats.services.melissa.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/roles")

public class RolesController {

    //@Autowired
    private final RoleService rolesService;

    public RolesController(RoleService rolesService) {
        this.rolesService = rolesService;
    }



    /*
     * @PostMapping = making a post request
     * @ResponseBody annotation tells a controller that the object returned a JSON.
     * @RequestBody annotation maps the HttpRequest body to a DTO.
     */


    @PostMapping(value = "/roles", consumes = "application/json", produces = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody String roles(@RequestBody NewRoleRequest request){

        return rolesService.addRole(request).getRole_id();
    }

    @GetMapping(value = "/getall", produces = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody List<Roles> getAll(){
       return rolesService.getAll();
    }

}
