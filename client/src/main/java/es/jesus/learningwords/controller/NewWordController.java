package es.jesus.learningwords.controller;

import es.jesus.learningwords.service.RestClientFactory;
import es.jesus.learningwords.service.RestRequest;
import es.jesus.learningwords.shared.vo.WordTypeVO;
import es.jesus.learningwords.shared.vo.WordVO;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;

import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.MediaType;
import java.time.LocalDate;
import java.util.List;

/**
 * Created by jesus on 8/09/15.
 */
public class NewWordController {
    @FXML
    protected TextField textFrom;
    @FXML
    protected TextField textTo;
    @FXML
    protected DatePicker learnedOn;
    @FXML
    protected ComboBox<WordTypeVO> wordType;

    public void initialize() {

        learnedOn.setValue(LocalDate.now());

        List<WordTypeVO> wordTypes = RestClientFactory.create().get(new RestRequest<List<WordTypeVO>>(
                "word/listTypes",
                MediaType.APPLICATION_JSON_TYPE,
                new GenericType<List<WordTypeVO>>() {
                }
        ));
        wordType.setItems(FXCollections.observableArrayList(wordTypes));
        wordType.getSelectionModel().selectFirst();
    }

    @FXML
    protected void onSave() {

        WordVO word = new WordVO(
                textFrom.getText(),
                textTo.getText(),
                learnedOn.getValue(),
                wordType.getValue()
        );
        RestClientFactory.create().put(new RestRequest<>(
                "word/save",
                MediaType.WILDCARD_TYPE,
                word
        ));
        // Clear from/to texts
        textFrom.setText("");
        textTo.setText("");
    }
}
