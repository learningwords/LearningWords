package es.jesus.learningwords.service;


import es.jesus.learningwords.shared.vo.WordVO;

import javax.ws.rs.core.MediaType;
import java.util.Calendar;

/**
 *
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
        word.setTextFrom("test");
        word.setTextTo("test");
        word.setLearnedOn(Calendar.getInstance());
        RestClientFactory.create().put(new RestClientFactory.RestRequest() {
            {
                path = "save";
                parameter = word;
                mediaType = MediaType.WILDCARD_TYPE;

            }
        });
    }

}
