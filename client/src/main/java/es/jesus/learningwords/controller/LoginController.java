package es.jesus.learningwords.controller;

import es.jesus.learningwords.ApplicationRun;
import es.jesus.learningwords.service.RestClientFactory;
import javafx.animation.FadeTransition;
import javafx.fxml.FXML;
import javafx.geometry.Insets;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.util.Duration;

/**
 * Created by jesus on 29/07/15.
 */
public class LoginController {

    @FXML
    protected StackPane root;

    @FXML
    protected TextField username;
    @FXML
    protected PasswordField password;


    /**
     * Logging button has been pressed
     */
    @FXML
    protected void onLog() {
        if (RestClientFactory.authenticate(username.getText(), password.getText())) {
            ApplicationRun.goTo("/fxml/main.fxml");
        } else {

            StackPane errorPane = new StackPane();
            errorPane.setBackground(new Background(new BackgroundFill(Color.RED, CornerRadii.EMPTY, Insets.EMPTY)));

            root.getChildren().add(errorPane);

            FadeTransition ft = new FadeTransition(Duration.millis(2000), errorPane);
            ft.setFromValue(0.85);
            ft.setToValue(0.0);
            ft.setOnFinished(event -> {
                root.getChildren().remove(errorPane);
            });
            ft.play();

        }
    }


}
