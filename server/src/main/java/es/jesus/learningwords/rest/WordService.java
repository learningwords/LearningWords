package es.jesus.learningwords.rest;

import es.jesus.learningwords.domain.User;
import es.jesus.learningwords.domain.Word;
import es.jesus.learningwords.repository.LanguageRepository;
import es.jesus.learningwords.repository.WordRepository;
import es.jesus.learningwords.repository.WordTypeRepository;
import es.jesus.learningwords.shared.vo.WordTypeVO;
import es.jesus.learningwords.shared.vo.WordVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by jesus on 7/09/15.
 */
@Service
public class WordService {
    @Autowired
    private LanguageRepository languageRepository;
    @Autowired
    private WordRepository wordRepository;
    @Autowired
    private WordTypeRepository wordTypeRepository;

    public void saveWord(WordVO wordVO) {
        //initialize the database Word
        //TODO use dozer or similar
        //TODO Configure cache
        Word word = new Word();
        word.setLanguageFrom(languageRepository.findByCode("UK"));
        word.setLanguageTo(languageRepository.findByCode("ES"));
        word.setUser((User) SecurityContextHolder.getContext().getAuthentication().getPrincipal());
        word.setLearnedOn(wordVO.getLearnedOn());
        word.setCreatedOn(Calendar.getInstance());
        word.setTextFrom(wordVO.getTextFrom());
        word.setTextTo(wordVO.getTextTo());
        //Save
        wordRepository.save(word);
    }

    public List<WordVO> listUserWords() {
        return wordRepository
                .findByUser((User) SecurityContextHolder.getContext().getAuthentication().getPrincipal())
                .stream()
                .map(word -> new WordVO(word.getTextFrom(), word.getTextTo(), word.getLearnedOn()))
                .collect(Collectors.toList());
    }


    public List<WordTypeVO> listWordTypes() {
        List<WordTypeVO> result = new ArrayList<>();
        wordTypeRepository.findAll().forEach(wordType -> result.add(new WordTypeVO(wordType.getCode(), wordType.getName())));
        return result;
    }
}
