package com.revature.tarotcards.p2scapegoats.services.john;
import com.revature.tarotcards.p2scapegoats.dtos.john.request.JohnNewCategoryRequest;
import com.revature.tarotcards.p2scapegoats.models.melissa.Categories;
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

    public JohnCategoryService(JohnCategoryRepository johnCategoryRepository) {
        this.johnCategoryRepository = johnCategoryRepository;
    }

    public List<Categories> getAllCategories() {
        return (List<Categories>) johnCategoryRepository.findAll();
    }

    public Categories findById(String id) {
        Categories category = johnCategoryRepository.findCategoryByCategory_id(id);
        return category;
    }

    public Categories save(JohnNewCategoryRequest request) {
        Categories category = new Categories(UUID.randomUUID().toString(), request.getCategory());
        return johnCategoryRepository.save(category);
    }

    public Categories findCategoryByCategory(String categoryName) {
        return johnCategoryRepository.findCategoryByCategory(categoryName);
    }

    public Categories update(JohnNewCategoryRequest request) {
        Categories category = new Categories(request.getId(), request.getCategory());
        Categories returnCategory = johnCategoryRepository.save(category);
        return returnCategory;
    }

    public void deleteCategory(JohnNewCategoryRequest request) {
        Categories category = johnCategoryRepository.findCategoryByCategory(request.getCategory());
        johnCategoryRepository.delete(category);
    }

}
