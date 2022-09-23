package com.revature.tarotcards.p2scapegoats.repositories.melissa;

import com.revature.tarotcards.p2scapegoats.models.melissa.Roles;
import com.revature.tarotcards.p2scapegoats.models.melissa.Users;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends CrudRepository<Users, String> {

    @Query(value = "SELECT username FROM users WHERE username = ?1", nativeQuery = true) //nativeQuery says run my query instead of thinking you know by my method name
    String findUsernameByUsername(String username);

    @Query(value = "SELECT * FROM users WHERE user_id = ?1", nativeQuery = true) //nativeQuery says run my query instead of thinking you know by my method name
    Users findUsersByUser_id(String username);


}
