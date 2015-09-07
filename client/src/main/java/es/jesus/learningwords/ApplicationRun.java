package es.jesus.learningwords;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

/**
 * Created by jesus on 29/07/15.
 */
public class ApplicationRun extends Application {

    private static Stage stage;

    @Override
    public void start(Stage primaryStage) throws Exception {
        ApplicationRun.stage = primaryStage;
        primaryStage.setTitle("LearningWords");
        ApplicationRun.goTo("/fxml/login.fxml");
        primaryStage.show();

    }

    public static void main(String[] args) {
        launch(args);
    }

    public static void goTo(String fxml) {
        // Review the how to switch between different fxml pages
        Parent myPane = null;
        try {
            myPane = FXMLLoader.load(ApplicationRun.class.getResource(fxml));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        Scene myScene = new Scene(myPane);

        ApplicationRun.stage.setScene(myScene);
        ApplicationRun.stage.sizeToScene();
        ApplicationRun.stage.setMinHeight(stage.getHeight());
        ApplicationRun.stage.setMinWidth(stage.getWidth());

    }
}

