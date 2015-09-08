package es.jesus.learningwords.controller;

import es.jesus.learningwords.service.WordsService;
import javafx.fxml.FXML;

/**
 * Created by jesus on 8/09/15.
 */
public class NewWordController {

    @FXML
    protected void onSave(){
        WordsService.getInstance().save();
    }
}
