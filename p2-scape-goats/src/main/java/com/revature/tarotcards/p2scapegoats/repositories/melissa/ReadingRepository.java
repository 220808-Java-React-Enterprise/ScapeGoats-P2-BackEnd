package com.revature.tarotcards.p2scapegoats.repositories.melissa;

import com.revature.tarotcards.p2scapegoats.models.melissa.Readings;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ReadingRepository extends CrudRepository<Readings, String> {

    @Query(value = "SELECT * FROM readings WHERE id = ?1", nativeQuery = true) //nativeQuery says run my query instead of thinking you know by my method name
    List<Readings> getAllByUserId(String id);
}
