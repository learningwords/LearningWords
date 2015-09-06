package es.jesus.learningwords.vo;

/**
 * Created by jesus on 24/07/15.
 */
public class Word {

    private long id;
    private String spanish;
    private String english;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getSpanish() {
        return spanish;
    }

    public void setSpanish(String spanish) {
        this.spanish = spanish;
    }

    public String getEnglish() {
        return english;
    }

    public void setEnglish(String english) {
        this.english = english;
    }
}
