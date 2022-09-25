package com.revature.tarotcards.p2scapegoats.repositories.john;

import com.revature.tarotcards.p2scapegoats.models.melissa.Categories;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface JohnCategoryRepository extends CrudRepository<Categories, String> {

    @Modifying(clearAutomatically = true)
    @Query(value = "select * from categories where category = ?1", nativeQuery = true)
    Categories findCategoryByCategory(String title);

    @Query(value = "select * from categories where category_id = ?1", nativeQuery = true)
    Categories findCategoryByCategory_id(String id);


}
