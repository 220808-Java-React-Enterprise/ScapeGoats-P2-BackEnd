package com.revature.tarotcards.p2scapegoats.services.john;
import com.revature.tarotcards.p2scapegoats.dtos.john.request.JohnNewReadingRequest;
import com.revature.tarotcards.p2scapegoats.models.melissa.Categories;
import com.revature.tarotcards.p2scapegoats.models.melissa.Readings;
import com.revature.tarotcards.p2scapegoats.models.melissa.Users;
import com.revature.tarotcards.p2scapegoats.repositories.john.JohnReadingRepository;
import com.revature.tarotcards.p2scapegoats.repositories.john.JohnUserRepository;
<<<<<<< HEAD
=======
import com.revature.tarotcards.p2scapegoats.repositories.melissa.ReadingRepository;
import com.revature.tarotcards.p2scapegoats.services.melissa.ReadingService;
import com.sun.scenario.effect.impl.sw.sse.SSEBlend_SRC_OUTPeer;
>>>>>>> chuong-branch
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Locale;
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

        List<Users> users = (List<Users>) johnUserRepository.findAll();

        Users user = null;

        for(Users u : users) {
            if(u.getUser_id().equals(request.getUser_id())) {
                user = u;
                break;
            }
        }
        Readings reading = new Readings(
                UUID.randomUUID().toString(),
                request.getCard1(),
                request.getCard2(),
                request.getCard3());
        reading.setDescription(request.getDescription());
        reading.setDate(Timestamp.valueOf(LocalDateTime.now()));
        reading.setCategory(new Categories());
        reading.getCategory().setCategory_id(request.getCategory_id());
        reading.setUser(user);

        return readingRepository.save(reading);

    }

    public Readings update(JohnNewReadingRequest request) {
        Categories category = categoryService.findCategoryByCategory(request.getCategory());
        List<Users> users = (List<Users>) johnUserRepository.findAll();
        Users user = null;

        for(Users u : users) {
            if(u.getUser_id().equals(request.getUser_id())) {
                user = u;
                break;
            }
        }

        Readings reading = new Readings();
        reading.setId(request.getReading_id());
        reading.setCard1(request.getCard1());
        reading.setCard2(request.getCard2());
        reading.setCard3(request.getCard3());
        reading.setDescription(request.getDescription());
        reading.setDate(Timestamp.valueOf(LocalDateTime.now()));
        reading.setCategory(category);
        reading.setUser(user);

        return readingRepository.save(reading);
    }

    public void deleteReading(JohnNewReadingRequest request) {
        Readings reading = new Readings();
        reading.setId(request.getReading_id());
        System.out.println(reading.getId());
        readingRepository.deleteReadingById(reading.getId());
    }

    public List<Readings> getAllReadings() {
        return (List<Readings>) readingRepository.findAll();
    }



    public Readings getReadingById(String readingId) {
        return readingRepository.findReadingById(readingId);
    }

    public List<Readings> getAllReadingByUserId(String userId) {
        return readingRepository.getAllReadingByUserId(userId);
    }
}
