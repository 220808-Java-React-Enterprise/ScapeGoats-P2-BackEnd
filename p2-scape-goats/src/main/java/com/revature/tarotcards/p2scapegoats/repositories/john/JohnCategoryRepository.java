package com.revature.tarotcards.p2scapegoats.repositories.john;


import com.revature.tarotcards.p2scapegoats.models.john.JohnCategory;
import com.revature.tarotcards.p2scapegoats.models.melissa.Categories;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface JohnCategoryRepository extends CrudRepository<Categories, String> {

    @Query(value = "select * from categories where category = ?1", nativeQuery = true)
    JohnCategory findCategoryByCategory(String title);

}
