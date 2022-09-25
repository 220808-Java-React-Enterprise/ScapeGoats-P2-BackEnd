package com.revature.tarotcards.p2scapegoats.services.john;

import com.revature.tarotcards.p2scapegoats.dtos.john.request.JohnNewConsultantRequest;
import com.revature.tarotcards.p2scapegoats.models.melissa.Consultants;
import com.revature.tarotcards.p2scapegoats.models.melissa.Users;
import com.revature.tarotcards.p2scapegoats.repositories.john.JohnConsultantRepository;
import com.revature.tarotcards.p2scapegoats.services.melissa.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class JohnConsultantService {
    @Autowired
    private JohnConsultantRepository consultantRepository;

    @Autowired
    private JohnUserService userService;

    public JohnConsultantService(JohnConsultantRepository consultantRepository, JohnUserService userService) {
        this.consultantRepository = consultantRepository;
        this.userService = userService;
    }

    public Consultants save(JohnNewConsultantRequest request) {

        Consultants consultant = new Consultants(UUID.randomUUID().toString(), request.getFirstName(), request.getLastName());
        Consultants returnConsultant = consultantRepository.save(consultant);
        return returnConsultant;
    }

    public Consultants update(JohnNewConsultantRequest request) {
        Users user = null;
        if(request.getUser_id() != null) {
            user = userService.findUsersByUser_id(request.getUser_id());
        }
        Consultants consultant = new Consultants();
        consultant.setId(request.getId());
        consultant.setFirstname(request.getFirstName());
        consultant.setLastname(request.getLastName());
        if(user != null) {
            consultant.addUser(user);
        }
        return consultantRepository.save(consultant);
    }

    public List<Consultants> getAllConsultants() {
        return (List<Consultants>) consultantRepository.findAll();
    }

    public void deleteConsultant(JohnNewConsultantRequest request) {
        Consultants consultant = new Consultants();
        consultant.setId(request.getId());
        consultantRepository.delete(consultant);
    }
}
