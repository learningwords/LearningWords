package es.jesus.learningwords.web;

import es.jesus.learningwords.rest.WordService;
import es.jesus.learningwords.shared.vo.WordVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by jesus on 19/07/15.
 */
@RestController
public class WordController {

    @Autowired
    private WordService wordService;

    @RequestMapping(value = "/save", consumes = MediaType.APPLICATION_JSON_VALUE)
    public boolean save(@RequestBody WordVO word) {
        wordService.saveWord(word);
        return true;
    }


}
