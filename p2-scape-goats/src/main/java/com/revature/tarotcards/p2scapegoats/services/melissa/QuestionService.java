package com.revature.tarotcards.p2scapegoats.services.melissa;

import com.revature.tarotcards.p2scapegoats.dtos.request.melissa.NewQuestionRequest;
import com.revature.tarotcards.p2scapegoats.dtos.request.melissa.NewReadingRequest;
import com.revature.tarotcards.p2scapegoats.models.melissa.Categories;
import com.revature.tarotcards.p2scapegoats.models.melissa.Questions;
import com.revature.tarotcards.p2scapegoats.models.melissa.Readings;
import com.revature.tarotcards.p2scapegoats.models.melissa.Users;
import com.revature.tarotcards.p2scapegoats.repositories.melissa.QuestionRepository;
import com.revature.tarotcards.p2scapegoats.utils.melissa.custom_exceptions.InvalidRequestException;
import org.aspectj.weaver.patterns.TypePatternQuestions;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Locale;
import java.util.UUID;

@Service
@Transactional
public class QuestionService {

    private final QuestionRepository questRepo;

    public QuestionService(QuestionRepository questRepo) {
        this.questRepo = questRepo;
    }

    public List<Questions> getAll(){
        List<Questions> questions = (List<Questions>)questRepo.findAll();
        if(questions.size() == 0) throw new InvalidRequestException("No questions found");
        return questions;
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
