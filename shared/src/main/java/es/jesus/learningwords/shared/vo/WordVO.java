package es.jesus.learningwords.shared.vo;

import java.util.Calendar;

/**
 * Created by jesus on 19/07/15.
 */

public class WordVO {


    private String textFrom;
    private String textTo;
    private Calendar learnedOn;



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
}
