package es.jesus.learningwords.repository;

import es.jesus.learningwords.domain.User;
import es.jesus.learningwords.domain.Word;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

/**
 * Created by jesus on 20/07/15.
 */
public interface WordRepository extends CrudRepository<Word, Long> {

    List<Word> findByUser(User user);
    
}
