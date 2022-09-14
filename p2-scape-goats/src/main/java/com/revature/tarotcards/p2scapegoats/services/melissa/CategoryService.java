package com.revature.tarotcards.p2scapegoats.services.melissa;

import com.revature.tarotcards.p2scapegoats.dtos.request.melissa.NewCategoryRequest;
import com.revature.tarotcards.p2scapegoats.models.melissa.Categories;
import com.revature.tarotcards.p2scapegoats.repositories.melissa.CategoryRepository;
import org.springframework.stereotype.Service;

import java.util.List;

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
        Categories cat = new Categories(request.getCategory_id(), request.getCategory());
        categoryRepo.save(cat);
        return cat;
    }

    public void delete(Categories category){
        categoryRepo.delete(category);
    }
}
