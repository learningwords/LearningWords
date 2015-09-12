package es.jesus.learningwords.shared.vo;

/**
 * Created by jesus on 12/09/15.
 */
public class WordTypeVO {
    private String code;
    private String name;


    public WordTypeVO() {
    }

    public WordTypeVO(String code, String name) {
        this.code = code;
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCode() {

        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }
}
