package es.jesus.learningwords.domain;

import javax.persistence.*;
import java.util.Calendar;

/**
 *
 * Created by jesus on 12/09/15.
 */
@Entity
@Table(name = "word_type")
public class WordType {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String code;
    private String name;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
