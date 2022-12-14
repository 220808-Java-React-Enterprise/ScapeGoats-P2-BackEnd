package com.revature.tarotcards.p2scapegoats.repositories.john;
import com.revature.tarotcards.p2scapegoats.models.melissa.Readings;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface JohnReadingRepository extends CrudRepository<Readings, String> {

    @Query(value = "SELECT * FROM readings WHERE user_id = ?1", nativeQuery = true)
    List<Readings> findReadingById(String userid);


    @Query(value = "DELETE FROM readings WHERE id = ?1", nativeQuery = true)
    void deleteReadingById(String userid);

    @Query(value = "SELECT * FROM readings WHERE user_id = ?1", nativeQuery = true)
    List<Readings> getAllReadingByUserId(String userId);


}
