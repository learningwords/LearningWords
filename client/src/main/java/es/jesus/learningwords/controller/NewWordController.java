package es.jesus.learningwords.controller;

import es.jesus.learningwords.rest.RestClientFactory;
import es.jesus.learningwords.shared.vo.WordVO;
import javafx.fxml.FXML;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;

import javax.ws.rs.core.MediaType;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Calendar;
import java.util.Date;

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

    public void initialize(){
        learnedOn.setValue(LocalDate.now());
    }

    @FXML
    protected void onSave() {
        Date date = Date.from(learnedOn.getValue().atStartOfDay(ZoneId.systemDefault()).toInstant());
        Calendar learnedOnCal = Calendar.getInstance();
        learnedOnCal.setTime(date);

        WordVO word = new WordVO(
                textFrom.getText(),
                textTo.getText(),
                learnedOnCal
        );
        RestClientFactory.create().put(new RestClientFactory.RestRequest<>(
                "save",
                MediaType.WILDCARD_TYPE,
                word
        ));
        // Clear from/to texts
        textFrom.setText("");
        textTo.setText("");
    }
}
