package controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

import java.io.File;
import java.io.IOException;

public class MapsSceneController {
    @FXML
    public TextField input;
    @FXML
    public ImageView view;

    public void goBack(ActionEvent actionEvent) throws IOException {
        Parent multimediaParent = FXMLLoader.load(getClass().getResource("../resources/MultimediaWindow.fxml"));
        Scene multimediaScene = new Scene(multimediaParent);

        Stage window = (Stage)((Node)actionEvent.getSource()).getScene().getWindow();
        window.setScene(multimediaScene);
        window.show();
    }
    @FXML
    public void buttonPressed(ActionEvent actionEvent) {
        input.clear();
        File map = new File("/Users/monikaciezka/Dashboard project/src/resources/nawigation.jpeg");
        Image mapImage = new Image(map.toURI().toString());
        view.setImage(mapImage);
        view.setY(view.getY() - 3);
    }
}
