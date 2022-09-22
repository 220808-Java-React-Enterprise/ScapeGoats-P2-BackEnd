package com.revature.tarotcards.p2scapegoats.repositories.john;


import com.revature.tarotcards.p2scapegoats.models.melissa.Readings;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface JohnReadingRepository extends CrudRepository<Readings, String> {

    @Query(value = "SELECT * FROM readings WHERE id = ?1", nativeQuery = true)
    List<Readings> findReadingById(String id);


    @Query(value = "DELETE FROM readings WHERE id = ?1", nativeQuery = true)
    void deleteReadingById(String id);

//FKrwj5v69sohlqxpioou1871h4v
}
