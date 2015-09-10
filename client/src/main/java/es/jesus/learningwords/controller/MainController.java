package es.jesus.learningwords.controller;

import es.jesus.learningwords.ApplicationRun;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Alert;
import javafx.scene.layout.BorderPane;

import java.io.IOException;

/**
 * Created by jesus on 26/08/15.
 */
public class MainController {

    @FXML
    protected BorderPane mainPanel;

    @FXML
    protected void onNew() throws IOException {
        mainPanel.setCenter(FXMLLoader.load(ApplicationRun.class.getResource("/fxml/newWord.fxml")));
    }


    @FXML
    protected void onViewDictionary() throws IOException {
        mainPanel.setCenter(FXMLLoader.load(ApplicationRun.class.getResource("/fxml/dictionary.fxml")));
    }

    /*
     * MENU ACTIONS
     */
    @FXML
    protected void onClose() {
        Platform.exit();
    }

    @FXML
    protected void onAbout() throws IOException {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("About LearningWords");

        alert.getDialogPane().setContent(FXMLLoader.load(ApplicationRun.class.getResource("/fxml/about.fxml")));

        alert.setHeaderText("Learning Words");
        alert.setContentText("Jesus Hernandez Morant \nCopyright 2015!!!");
        alert.show();
    }


}
