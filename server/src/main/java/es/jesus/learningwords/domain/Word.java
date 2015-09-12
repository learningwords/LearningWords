package es.jesus.learningwords.domain;

import javax.persistence.*;
import java.util.Calendar;

/**
 *
 * Created by jesus on 19/07/15.
 */
@Entity
public class Word {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @ManyToOne
    private Language languageFrom;
    @ManyToOne
    private Language languageTo;

    @ManyToOne
    private WordType wordType;

    private String textFrom;
    private String textTo;

    //TODO use LocalDate/LocalDateTime java 8 (failing with hibernate atm)
    //Data truncation: Incorrect datetime value
    private Calendar learnedOn;
    private Calendar createdOn;

    @ManyToOne
    private User user;

     /*
     * Getters and Setters
     */

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Language getLanguageFrom() {
        return languageFrom;
    }

    public void setLanguageFrom(Language languageFrom) {
        this.languageFrom = languageFrom;
    }

    public Language getLanguageTo() {
        return languageTo;
    }

    public void setLanguageTo(Language languageTo) {
        this.languageTo = languageTo;
    }

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


    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Calendar getLearnedOn() {
        return learnedOn;
    }

    public void setLearnedOn(Calendar learnedOn) {
        this.learnedOn = learnedOn;
    }

    public Calendar getCreatedOn() {
        return createdOn;
    }

    public void setCreatedOn(Calendar createdOn) {
        this.createdOn = createdOn;
    }

    public WordType getWordType() {
        return wordType;
    }

    public void setWordType(WordType wordType) {
        this.wordType = wordType;
    }
}
