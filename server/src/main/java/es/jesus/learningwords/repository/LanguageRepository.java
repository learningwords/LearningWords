package es.jesus.learningwords.repository;

import es.jesus.learningwords.domain.Language;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by jesus on 7/09/15.
 */
public interface LanguageRepository extends CrudRepository<Language, Long> {

    Language findByCode(String code);
}
