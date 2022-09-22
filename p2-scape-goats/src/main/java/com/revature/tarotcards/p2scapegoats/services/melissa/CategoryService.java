package com.revature.tarotcards.p2scapegoats.services.melissa;

import com.revature.tarotcards.p2scapegoats.dtos.john.request.JohnNewCategoryRequest;
import com.revature.tarotcards.p2scapegoats.dtos.request.melissa.NewCategoryRequest;
import com.revature.tarotcards.p2scapegoats.models.melissa.Categories;
import com.revature.tarotcards.p2scapegoats.repositories.melissa.CategoryRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class CategoryService {

    private final CategoryRepository categoryRepo;

    public CategoryService(CategoryRepository categoryRepo) {
        this.categoryRepo = categoryRepo;
    }

    public List<Categories> getAll(){
        return (List<Categories>) categoryRepo.findAll();
    }

    public Categories addCategory(NewCategoryRequest request){
        Categories cat = new Categories(UUID.randomUUID().toString(), request.getCategory());

        return categoryRepo.save(cat);
    }
    /*public Categories save(JohnNewCategoryRequest request) { JOHN
        Categories category = new Categories(UUID.randomUUID().toString(), request.getCategory());

        return johnCategoryRepository.save(category);
    }*/

    public void delete(Categories category){
        categoryRepo.delete(category);
    }
}
