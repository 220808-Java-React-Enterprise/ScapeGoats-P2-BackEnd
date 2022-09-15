package com.revature.tarotcards.p2scapegoats.services.melissa;

import com.revature.tarotcards.p2scapegoats.dtos.request.melissa.NewQuestionRequest;
import com.revature.tarotcards.p2scapegoats.dtos.request.melissa.NewReadingRequest;
import com.revature.tarotcards.p2scapegoats.models.melissa.Categories;
import com.revature.tarotcards.p2scapegoats.models.melissa.Questions;
import com.revature.tarotcards.p2scapegoats.models.melissa.Readings;
import com.revature.tarotcards.p2scapegoats.models.melissa.Users;
import com.revature.tarotcards.p2scapegoats.repositories.melissa.QuestionRepository;
import org.aspectj.weaver.patterns.TypePatternQuestions;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Locale;
import java.util.UUID;

@Service
public class QuestionService {

    QuestionRepository questRepo;

    public QuestionService(QuestionRepository questRepo) {
        this.questRepo = questRepo;
    }

    public List<Questions> getAll(){
        return (List<Questions>) questRepo.findAll();
    }

    public String addQuestion(NewQuestionRequest request){
        Questions question = new Questions(UUID.randomUUID().toString(), request.getQuestion(), new Categories());
        questRepo.save(question);
        return request.getQuestion() + " has been added";
    }

    public void delete(Questions quest){
        questRepo.delete(quest);
    }
}
