package es.jesus.learningwords.repository;

import es.jesus.learningwords.domain.User;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by jesus on 24/07/15.
 */
public interface UserRepository extends CrudRepository<User, Long> {

    User findByUserName(String userName);
}
