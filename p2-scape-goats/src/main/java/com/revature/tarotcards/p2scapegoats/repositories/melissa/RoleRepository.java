package com.revature.tarotcards.p2scapegoats.repositories.melissa;

import com.revature.tarotcards.p2scapegoats.models.melissa.Roles;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RoleRepository extends CrudRepository<Roles, String> {
    @Query(value = "SELECT * FROM roles WHERE title = ?1", nativeQuery = true) //nativeQuery says run my query instead of thinking you know by my method name
    Roles findByTitle(String title);


    @Query(value = "SELECT * FROM roles WHERE role_id = ?1", nativeQuery = true) //nativeQuery says run my query instead of thinking you know by my method name
    Roles findByRole_id(String id);
}
