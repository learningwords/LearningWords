package es.jesus.learningwords.web;

import es.jesus.learningwords.domain.Word;
import es.jesus.learningwords.repository.WordRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by jesus on 19/07/15.
 */
@RestController
public class WordController {

    @Autowired
    private WordRepository wordRepository;


    @RequestMapping("/greeting")
    public List<Word> greeting(HttpSession session) {

        List<Word> wordList = new ArrayList<>();
        Iterable<Word> words = wordRepository.findAll();
        words.forEach(t -> wordList.add(t));

        return wordList;
    }

}
