package com.revature.tarotcards.p2scapegoats.services.john;


import com.revature.tarotcards.p2scapegoats.dtos.john.request.JohnNewQuestionRequest;
import com.revature.tarotcards.p2scapegoats.dtos.request.melissa.NewQuestionRequest;
import com.revature.tarotcards.p2scapegoats.models.melissa.Categories;
import com.revature.tarotcards.p2scapegoats.models.melissa.Questions;
import com.revature.tarotcards.p2scapegoats.repositories.john.JohnQuestionRepository;
import com.revature.tarotcards.p2scapegoats.repositories.melissa.QuestionRepository;
import com.revature.tarotcards.p2scapegoats.services.melissa.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class JohnQuestionService {
    
    @Autowired
    private JohnQuestionRepository questionRepository;

    @Autowired
    private JohnCategoryService categoryService;


    public Questions save(JohnNewQuestionRequest request) {
        Categories category = categoryService.findCategoryByCategory(request.getCategory());
        Questions question = new Questions(UUID.randomUUID().toString(), request.getQuestion(), category);
        question.setCategories(category);

        return questionRepository.save(question);
    }

    public Questions update(JohnNewQuestionRequest request) {
        Questions question = new Questions();
        List<Categories> categories = categoryService.getAllCategories();
        for(Categories c : categories) {
            if(c.getCategory_id().equalsIgnoreCase(request.getCategory_id())) {
                question.setId(request.getId());
                question.setQuestion(request.getQuestion());
                question.setCategories(c);
                questionRepository.save(question);
            }
        }
        return question;
    }

    public List<Questions> getAllQuestions() {
        return (List<Questions>) questionRepository.findAll();
    }

    public void deleteQuestion(JohnNewQuestionRequest request) {
        List<Questions> list = (List<Questions>) questionRepository.findAll();

        for(Questions q : list) {
            if(q.getId().equalsIgnoreCase(request.getId())) {
                System.out.println("FOUND: " + q.getId());
                questionRepository.delete(q);
            }
        }

        //questionRepository.delete();
    }
}
