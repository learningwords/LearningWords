package es.jesus.learningwords.web;

import es.jesus.learningwords.rest.WordService;
import es.jesus.learningwords.shared.vo.WordTypeVO;
import es.jesus.learningwords.shared.vo.WordVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by jesus on 19/07/15.
 */
@RestController
@RequestMapping("/word")
public class WordController {

    @Autowired
    private WordService wordService;

    /**
     * Save a new word
     *
     * @param word
     * @return
     */
    @RequestMapping(value = "/save", consumes = MediaType.APPLICATION_JSON_VALUE)
    public boolean save(@RequestBody WordVO word) {
        wordService.saveWord(word);
        return true;
    }

    @RequestMapping(value = "/list", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<WordVO> list() {
        return wordService.listUserWords();
    }

    @RequestMapping(value = "/listTypes", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<WordTypeVO> listTypes() {
        return wordService.listWordTypes();
    }

}
