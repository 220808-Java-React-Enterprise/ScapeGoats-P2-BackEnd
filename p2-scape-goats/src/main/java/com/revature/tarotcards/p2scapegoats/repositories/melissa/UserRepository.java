package com.revature.tarotcards.p2scapegoats.repositories.melissa;

import com.revature.tarotcards.p2scapegoats.models.melissa.Users;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends CrudRepository<Users, String> {
}
