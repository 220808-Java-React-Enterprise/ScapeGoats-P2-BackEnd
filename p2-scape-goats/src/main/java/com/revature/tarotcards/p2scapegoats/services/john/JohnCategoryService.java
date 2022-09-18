package com.revature.tarotcards.p2scapegoats.services.john;




import com.revature.tarotcards.p2scapegoats.dtos.request.melissa.NewCategoryRequest;
import com.revature.tarotcards.p2scapegoats.models.john.JohnCategory;
import com.revature.tarotcards.p2scapegoats.repositories.john.JohnCategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class JohnCategoryService {

    @Autowired
    private JohnCategoryRepository johnCategoryRepository;

    public List<JohnCategory> getAllCategories() {
        return (List<JohnCategory>) johnCategoryRepository.findAll();
    }

    public Optional<JohnCategory> findById(String id) {
        Optional<JohnCategory> category = johnCategoryRepository.findById(id);
        return category;
    }

    public JohnCategory save(NewCategoryRequest request) {
        JohnCategory category = new JohnCategory(UUID.randomUUID().toString(), request.getCategory());

        return johnCategoryRepository.save(category);
    }

    public JohnCategory findCategoryByCategory(String categoryName) {
        return johnCategoryRepository.findCategoryByCategory(categoryName);
    }

    public JohnCategory update(NewCategoryRequest request) {
        JohnCategory category = new JohnCategory(request.getId(), request.getCategory());
        return johnCategoryRepository.save(category);
    }

    public void deleteCategory(NewCategoryRequest request) {
        JohnCategory category = categoryRepository.findCategoryByCategory(request.getCategory());
        System.out.println(category);
        categoryRepository.delete(category);
    }

}
