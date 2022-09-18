package com.revature.tarotcards.p2scapegoats.repositories.john;

import com.revature.tarotcards.p2scapegoats.models.melissa.Roles;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JohnRoleRepository extends CrudRepository<Roles, String> {

    @Query(value = "select * from roles where title = ?1", nativeQuery = true)
    Roles findRoleByTitle(String title);


    @Query(value = "select * from roles where role_id = ?1", nativeQuery = true)
    Roles findRoleByRole_id(String role_id);
}
