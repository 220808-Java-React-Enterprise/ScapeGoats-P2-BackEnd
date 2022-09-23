package com.revature.tarotcards.p2scapegoats.services.john;
import com.revature.tarotcards.p2scapegoats.dtos.john.request.JohnNewReadingRequest;
import com.revature.tarotcards.p2scapegoats.models.melissa.Categories;
import com.revature.tarotcards.p2scapegoats.models.melissa.Readings;
import com.revature.tarotcards.p2scapegoats.models.melissa.Users;
import com.revature.tarotcards.p2scapegoats.repositories.john.JohnReadingRepository;
import com.revature.tarotcards.p2scapegoats.repositories.john.JohnUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class JohnReadingService {

    @Autowired
    private JohnReadingRepository readingRepository;

    @Autowired
    private JohnUserRepository johnUserRepository;
    @Autowired
    private JohnCategoryService categoryService;

    public Readings save(JohnNewReadingRequest request) {

        Categories category = categoryService.findCategoryByCategory(request.getCategory());
        List<Users> users = (List<Users>) johnUserRepository.findAll();
        Users user = null;

        for(Users u : users) {
            if(u.getUser_id().equals(request.getUser_id())) {
                user = u;
                break;
            }
        }
        System.out.println("Category : " + category);
        Readings reading = new Readings(
                UUID.randomUUID().toString(),
                request.getCard1(),
                request.getCard2(),
                request.getCard3());
        reading.setDescription(request.getDescription());
        reading.setDate(Timestamp.valueOf(LocalDateTime.now()));
        reading.setCategory(category);
        reading.setUser(user);
        System.out.println(reading);

        //return reading;
        return readingRepository.save(reading);

    }

    public Readings update(JohnNewReadingRequest request) {
        Categories category = categoryService.findCategoryByCategory(request.getCategory());
        Readings reading = new Readings();
        reading.setId(request.getReading_id());
        reading.setCard1(request.getCard1());
        reading.setCard2(request.getCard2());
        reading.setCard3(request.getCard3());
        reading.setDescription(request.getDescription());
        reading.setDate(Timestamp.valueOf(LocalDateTime.now()));
        reading.setCategory(category);

        return readingRepository.save(reading);
    }

    public void deleteReading(JohnNewReadingRequest request) {
        Readings reading = new Readings();
        reading.setId(request.getReading_id());
        readingRepository.delete(reading);
    }

    public List<Readings> getAllReadings() {
        return (List<Readings>) readingRepository.findAll();
    }

    public List<Readings> getAllByUserId(String userId){
        return readingRepository.findReadingById(userId);
    }
}
