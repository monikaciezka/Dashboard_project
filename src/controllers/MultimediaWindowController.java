package controllers;

import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.io.IOException;
import java.time.LocalTime;

public class MultimediaWindowController {

    @FXML
    Button mapsButton;
    @FXML
    Label timeLabel;


    @FXML
    public void initialize(){

        Timeline clock = new Timeline(new KeyFrame(Duration.ZERO, e -> {
            LocalTime currentTime = LocalTime.now();
            if(currentTime.getMinute() < 10){
                timeLabel.setText(currentTime.getHour() + ":0" + currentTime.getMinute());
            } else {
                timeLabel.setText(currentTime.getHour() + ":" + currentTime.getMinute());
            }

        }),
                new KeyFrame(Duration.seconds(1))
        );
        clock.setCycleCount(Animation.INDEFINITE);
        clock.play();
    }

    public void goToMusicScene(ActionEvent event) throws IOException {
        Parent musicParent = FXMLLoader.load(getClass().getResource("../resources/MusicScene.fxml"));
        Scene musicScene = new Scene(musicParent);

        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        window.setScene(musicScene);
        window.show();
    }

    public void goToSettingsScene(ActionEvent event) throws IOException {
        Parent musicParent = FXMLLoader.load(getClass().getResource("../resources/SettingsScene.fxml"));
        Scene musicScene = new Scene(musicParent);

        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        window.setScene(musicScene);
        window.show();
    }

    public void goToYoutubeScene(ActionEvent event) throws IOException {
        Parent musicParent = FXMLLoader.load(getClass().getResource("../resources/YouTubeScene.fxml"));
        Scene musicScene = new Scene(musicParent);

        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        window.setScene(musicScene);
        window.show();
    }

    public void goToMapsScene(ActionEvent event) throws IOException {
        Parent musicParent = FXMLLoader.load(getClass().getResource("../resources/MapsScene.fxml"));
        Scene musicScene = new Scene(musicParent);

        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        window.setScene(musicScene);
        window.show();
    }
}
