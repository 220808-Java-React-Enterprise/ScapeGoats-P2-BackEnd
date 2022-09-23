package com.revature.tarotcards.p2scapegoats.services.melissa;

import com.revature.tarotcards.p2scapegoats.dtos.request.melissa.NewReadingRequest;
import com.revature.tarotcards.p2scapegoats.models.melissa.Categories;
import com.revature.tarotcards.p2scapegoats.models.melissa.Readings;
import com.revature.tarotcards.p2scapegoats.models.melissa.Users;
import com.revature.tarotcards.p2scapegoats.repositories.melissa.ReadingRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class ReadingService {

    ReadingRepository readingRep;

    public ReadingService(ReadingRepository readingRep) {
        this.readingRep = readingRep;
    }

    public List<Readings> getAll(){
        return (List<Readings>) readingRep.findAll();
    }

    public List<Readings> getAllByUserId(String userId){
        return readingRep.getAllByUserId(userId);
    }

    public String addReading(NewReadingRequest request){
        Readings reading = new Readings(UUID.randomUUID().toString(), request.getCard1(), request.getCard2(), request.getCard3(), request.getDescription(), request.getDate(), new Users(), new Categories());
        readingRep.save(reading);
        return request.getDescription() + " has been added";
    }

    public void delete(Readings read){
        readingRep.delete(read);
    }
}
