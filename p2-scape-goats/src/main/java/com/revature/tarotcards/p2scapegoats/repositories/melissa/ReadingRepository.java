package com.revature.tarotcards.p2scapegoats.repositories.melissa;

import com.revature.tarotcards.p2scapegoats.models.melissa.Readings;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReadingRepository extends CrudRepository<Readings, String> {
}
