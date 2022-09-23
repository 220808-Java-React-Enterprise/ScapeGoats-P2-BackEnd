package com.revature.tarotcards.p2scapegoats.repositories.john;

import com.revature.tarotcards.p2scapegoats.models.melissa.Users;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JohnUserRepository extends CrudRepository<Users, String> {

    @Query(value = "select username from users where username = ?1", nativeQuery = true)
    String findUsernameByUsername(String username);


    @Query(value = "select * from users where username = ?1", nativeQuery = true)
    Users findUserByUsername(String username);


    @Query(value = "select * from users where username = ?1 and password = ?2", nativeQuery = true)
    Users findUserByUsernameAndPassword(String username, String password);

    @Query(value = "SELECT * FROM users WHERE user_id = ?1", nativeQuery = true) //nativeQuery says run my query instead of thinking you know by my method name
    Users findUsersByUser_id(String username);
}
