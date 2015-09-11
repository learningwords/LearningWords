package es.jesus.learningwords.controller;

import es.jesus.learningwords.rest.RestClientFactory;
import es.jesus.learningwords.rest.RestRequest;
import es.jesus.learningwords.shared.vo.WordVO;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.scene.control.TableView;

import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.MediaType;
import java.util.List;

/**
 * Created by jesus on 11/09/15.
 */
public class DictionaryController {

    @FXML
    private TableView<WordVO> wordsTable;

    public void initialize(){
        List<WordVO> words = RestClientFactory.create().get(new RestRequest<List<WordVO>>(
                "word/list",
                MediaType.APPLICATION_JSON_TYPE,
                new GenericType<List<WordVO>>() {
                }
        ));
        wordsTable.setItems( FXCollections.observableList(words));
    }
}
