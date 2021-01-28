package controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Slider;
import javafx.stage.Stage;

import java.io.IOException;

public class SettingsSceneController {

    @FXML
    Slider volumeSlider;
    @FXML
    Slider brightnessSlider;


    public void goBack(ActionEvent actionEvent) throws IOException {
        Parent multimediaParent = FXMLLoader.load(getClass().getResource("../resources/MultimediaWindow.fxml"));
        Scene multimediaScene = new Scene(multimediaParent);

        Stage window = (Stage)((Node)actionEvent.getSource()).getScene().getWindow();
        window.setScene(multimediaScene);
        window.show();
    }

}
