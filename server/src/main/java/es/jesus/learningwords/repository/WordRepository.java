package es.jesus.learningwords.repository;

import es.jesus.learningwords.domain.Word;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by jesus on 20/07/15.
 */
public interface WordRepository extends CrudRepository<Word, Long> {

}
