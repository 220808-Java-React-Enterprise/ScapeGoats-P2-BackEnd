package com.revature.tarotcards.p2scapegoats.repositories.melissa;

import com.revature.tarotcards.p2scapegoats.models.melissa.Categories;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryRepository extends CrudRepository<Categories, String> {

    @Query(value = "SELECT * FROM categories WHERE category = ?1", nativeQuery = true)
    Categories findCategoryByCategory(String title);

    @Query(value = "SELECT * FROM categories WHERE category_id = ?1", nativeQuery = true)
    Categories findCategoryByCategory_id(String id);
}
