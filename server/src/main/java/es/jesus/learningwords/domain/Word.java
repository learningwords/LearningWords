package es.jesus.learningwords.domain;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;

/**
 * Created by jesus on 19/07/15.
 */
@Entity
@Table(name = "word")
public class Word {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @ManyToOne
    @JoinColumn(name="language_from_id")
    private Language languageFrom;
    @ManyToOne
    @JoinColumn(name="language_to_id")
    private Language languageTo;

    @ManyToOne
    @JoinColumn(name="word_type_id")
    private WordType wordType;

    @Column(name="text_from")
    private String textFrom;
    @Column(name="text_to")
    private String textTo;
    @Column(name="learned_on")
    private LocalDate learnedOn;
    @Column(name="created_on")
    private LocalDateTime createdOn;

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

    public LocalDate getLearnedOn() {
        return learnedOn;
    }

    public void setLearnedOn(LocalDate learnedOn) {
        this.learnedOn = learnedOn;
    }

    public LocalDateTime getCreatedOn() {
        return createdOn;
    }

    public void setCreatedOn(LocalDateTime createdOn) {
        this.createdOn = createdOn;
    }

    public WordType getWordType() {
        return wordType;
    }

    public void setWordType(WordType wordType) {
        this.wordType = wordType;
    }
}
