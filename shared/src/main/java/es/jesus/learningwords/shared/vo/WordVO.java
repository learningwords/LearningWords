package es.jesus.learningwords.shared.vo;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Calendar;

/**
 * Created by jesus on 19/07/15.
 */

public class WordVO {

    private static DateFormat sfd = new SimpleDateFormat("dd-MM-yyyy");


    private String textFrom;
    private String textTo;
    private Calendar learnedOn;
    private String learnedOnFmt;
    private WordTypeVO wordType;

    /**
     * Empty constructor needed by jackson
     */
    public WordVO() {
    }

    public WordVO(String textFrom, String textTo, Calendar learnedOn) {
        this.textFrom = textFrom;
        this.textTo = textTo;
        this.learnedOn = learnedOn;
        this.learnedOnFmt = sfd.format(learnedOn.getTime());
    }

     /*
     * Getters and Setters
     */

    public String getTextFrom() {
        return textFrom;
    }

    public void setTextFrom(String textFrom) {
        this.textFrom = textFrom;
    }

    public String getTextTo() {
        return textTo;
    }

    public void setTextTo(String textTo) {
        this.textTo = textTo;
    }

    public Calendar getLearnedOn() {
        return learnedOn;
    }

    public void setLearnedOn(Calendar learnedOn) {
        this.learnedOn = learnedOn;
    }

    public String getLearnedOnFmt() {
        return learnedOnFmt;
    }

    public WordTypeVO getWordType() {
        return wordType;
    }

    public void setWordType(WordTypeVO wordType) {
        this.wordType = wordType;
    }
}
