package com.revature.tarotcards.p2scapegoats.services.melissa;

import com.revature.tarotcards.p2scapegoats.dtos.john.request.JohnNewCategoryRequest;
import com.revature.tarotcards.p2scapegoats.dtos.request.melissa.NewCategoryRequest;
import com.revature.tarotcards.p2scapegoats.models.melissa.Categories;
import com.revature.tarotcards.p2scapegoats.repositories.melissa.CategoryRepository;
import com.revature.tarotcards.p2scapegoats.utils.melissa.custom_exceptions.InvalidRequestException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class CategoryService {

    private final CategoryRepository categoryRepo;

    public CategoryService(CategoryRepository categoryRepo) {
        this.categoryRepo = categoryRepo;
    }

    public List<Categories> getAllCategories(){
        return (List<Categories>) categoryRepo.findAll();
    }

    public List<Categories> getAll(){
        List<Categories> category = (List<Categories>) categoryRepo.findAll();
        if (category.size()==0) throw new InvalidRequestException("No categories found");
        return category;
    }

    public Categories addCategory(NewCategoryRequest request){
        Categories cat = new Categories(UUID.randomUUID().toString(), request.getCategory());

        return categoryRepo.save(cat);
    }

    public Categories findById(String id) {
        Categories category = categoryRepo.findCategoryByCategory_id(id);
        return category;
    }

    public Categories findCategoryByCategory(String categoryName) {
        return categoryRepo.findCategoryByCategory(categoryName);
    }

    /*public Categories save(JohnNewCategoryRequest request) { JOHN
        Categories category = new Categories(UUID.randomUUID().toString(), request.getCategory());

        return johnCategoryRepository.save(category);
    }*/

    public void delete(Categories category){
        categoryRepo.delete(category);
    }

}
