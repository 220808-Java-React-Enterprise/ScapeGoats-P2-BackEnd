package com.revature.tarotcards.p2scapegoats.repositories.john;
import com.revature.tarotcards.p2scapegoats.models.melissa.Questions;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface JohnQuestionRepository extends CrudRepository<Questions, String> {

    @Query(value = "SELECT * FROM questions WHERE id = ?1", nativeQuery = true)
    Questions findQuestionById(String id);

    @Query(value = "DELETE FROM questions WHERE id = ?1", nativeQuery = true)
    void deleteQuestionByID(String id);




}
