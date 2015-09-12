package es.jesus.learningwords.repository;

import es.jesus.learningwords.domain.User;
import es.jesus.learningwords.domain.WordType;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by jesus on 12/09/15.
 */
public interface WordTypeRepository extends CrudRepository<WordType, Long> {


}
