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
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.io.IOException;
import java.time.LocalTime;


public class MusicSceneController {

    @FXML
    ImageView playButton;
    @FXML
    ImageView musicCover;
    @FXML
    Label timeLabel;
    @FXML
    Slider slider;
    @FXML
    Label timeRemaining;
    @FXML
    Label timePassed;


    int iterator = 0;
    String[] songsArray = {"https://upload.wikimedia.org/wikipedia/en/0/0a/Taylor_Swift_-_Evermore.png", "https://mediamarkt.pl/media/cache/resolve/gallery/images/20/20453988/evolve-0.jpg", "https://ecsmedia.pl/c/bad-blood-pl-b-iext43764596.jpg"};
    int minutes;
    int seconds;
    boolean isPlaying = true;

    @FXML
    public void initialize(){

        slider.setMax(210);
        slider.setMin(0);
        slider.setBlockIncrement(1);
        Timeline clock = new Timeline(new KeyFrame(Duration.ZERO, e -> {
            LocalTime currentTime = LocalTime.now();
            if(currentTime.getMinute() < 10){
                timeLabel.setText(currentTime.getHour() + ":0" + currentTime.getMinute());
            } else {
                timeLabel.setText(currentTime.getHour() + ":" + currentTime.getMinute());
            }
            if(isPlaying) {
                slider.increment();
                if (slider.getValue() == slider.getMax()) {
                    slider.setValue(0);
                }
                minutes = (int) slider.getValue() / 60;
                seconds = (int) slider.getValue() % 60;
                if (seconds < 10) {
                    timePassed.setText(minutes + ":0" + seconds);
                } else {
                    timePassed.setText(minutes + ":" + seconds);
                }
                minutes = (int) (slider.getMax() - slider.getValue()) / 60;
                seconds = (int) (slider.getMax() - slider.getValue()) % 60;
                if (seconds < 10) {
                    timeRemaining.setText("-" + minutes + ":0" + seconds);
                } else {
                    timeRemaining.setText("-" + minutes + ":" + seconds);
                }
            }
        }),
                new KeyFrame(Duration.seconds(1))
        );
        clock.setCycleCount(Animation.INDEFINITE);
        clock.play();

    }

    public void goBack(ActionEvent actionEvent) throws IOException {
        Parent multimediaParent = FXMLLoader.load(getClass().getResource("../resources/MultimediaWindow.fxml"));
        Scene multimediaScene = new Scene(multimediaParent);

        Stage window = (Stage)((Node)actionEvent.getSource()).getScene().getWindow();
        window.setScene(multimediaScene);
        window.show();
    }

    public void nextSong(ActionEvent actionEvent) {
        iterator++;
        musicCover.setImage(new Image(songsArray[iterator%3]));
        slider.setValue(0);
        isPlaying = true;
        playButton.setImage(new Image("https://cdn3.iconfinder.com/data/icons/music-player-controls/100/music_pause_stop_control_play-512.png"));
    }

    public void stopMusic(ActionEvent actionEvent) {
        if(isPlaying) {
            isPlaying = false;
            playButton.setImage(new Image("https://cdn.iconscout.com/icon/free/png-512/play-377-558648.png"));
        } else {
            isPlaying = true;
            playButton.setImage(new Image("https://cdn3.iconfinder.com/data/icons/music-player-controls/100/music_pause_stop_control_play-512.png"));
        }

    }
}
