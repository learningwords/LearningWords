package es.jesus.learningwords.web;

import es.jesus.learningwords.domain.Word;
import es.jesus.learningwords.repository.WordRepository;
import es.jesus.learningwords.service.WordService;
import es.jesus.learningwords.shared.vo.WordVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.jws.WebMethod;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by jesus on 19/07/15.
 */
@RestController
public class WordController {

    @Autowired
    private WordService wordService;

    @RequestMapping(value = "/save" , method = RequestMethod.PUT)
    public boolean save(WordVO word) {
        wordService.saveWord(word);
        return true;
    }


}
