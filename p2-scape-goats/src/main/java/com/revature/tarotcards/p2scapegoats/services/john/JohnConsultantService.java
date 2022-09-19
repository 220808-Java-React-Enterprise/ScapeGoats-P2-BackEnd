package com.revature.tarotcards.p2scapegoats.services.john;

import com.revature.tarotcards.p2scapegoats.dtos.john.request.JohnNewConsultantRequest;
import com.revature.tarotcards.p2scapegoats.dtos.request.melissa.NewConsultantRequest;
import com.revature.tarotcards.p2scapegoats.models.melissa.Consultants;
import com.revature.tarotcards.p2scapegoats.repositories.john.JohnConsultantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class JohnConsultantService {

    @Autowired
    private JohnConsultantRepository consultantRepository;

    public Consultants save(JohnNewConsultantRequest request) {
        Consultants consultant = new Consultants(UUID.randomUUID().toString(), request.getFirstName(), request.getLastName());
        return consultantRepository.save(consultant);
    }

    public Consultants update(JohnNewConsultantRequest request) {
        Consultants consultant = new Consultants();
        consultant.setId(request.getId());
        consultant.setFirstname(request.getFirstName());
        consultant.setLastname(request.getLastName());
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
