package com.revature.tarotcards.p2scapegoats.services.melissa;

import com.revature.tarotcards.p2scapegoats.dtos.request.melissa.NewConsultantRequest;
import com.revature.tarotcards.p2scapegoats.dtos.request.melissa.NewQuestionRequest;
import com.revature.tarotcards.p2scapegoats.models.melissa.Categories;
import com.revature.tarotcards.p2scapegoats.models.melissa.Consultants;
import com.revature.tarotcards.p2scapegoats.models.melissa.Questions;
import com.revature.tarotcards.p2scapegoats.repositories.melissa.ConsultantRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class ConsultantService {

    private final ConsultantRepository consRepo;

    public ConsultantService(ConsultantRepository consRepo) {
        this.consRepo = consRepo;
    }

    public List<Consultants> getAll(){
        return (List<Consultants>) consRepo.findAll();
    }

    public String addConsultant(NewConsultantRequest request){
        Consultants cons = new Consultants(UUID.randomUUID().toString(), request.getFirstname(), request.getLastname());
        consRepo.save(cons);
        return request.getFirstname() + " has been added";
    }

    public void delete(Consultants cons){
        consRepo.delete(cons);
    }
}