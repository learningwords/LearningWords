package es.jesus.learningwords.service;


import es.jesus.learningwords.shared.vo.WordVO;

import java.util.Calendar;

/**
 * Created by jesus on 23/07/15.
 */
public class WordsService {

    private static WordsService INSTANCE;

    private WordsService() {
    }


    public static WordsService getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new WordsService();
        }
        return INSTANCE;
    }

    public static void save() {
        WordVO word = new WordVO();
        word.setTextFrom("hello");
        word.setTextTo("hola");
        word.setLearnedOn(Calendar.getInstance());
        RestService.getInstance().save("jesus", "jesus", word);

    }

}
