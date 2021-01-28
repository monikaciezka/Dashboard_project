package controllers;

import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.shape.Line;
import javafx.util.Duration;

import java.io.File;
import static com.sun.org.apache.xalan.internal.lib.ExsltMath.power;
import static com.sun.org.apache.xalan.internal.lib.ExsltMath.sqrt;
import static java.lang.StrictMath.*;

public class MeterWindow {
    @FXML
    public Line tachometer;
    @FXML
    public Line accelerometer;
    @FXML
    public Button leftBlinker;
    @FXML
    public Button rightBlinker;
    public ImageView leftView;
    public ImageView rightView;
    @FXML
    public Button startButton;
    boolean flag = false;
    boolean leftOn = false;
    boolean rightOn = false;
    double x = 0;
    double y = 0;
    int numberOfBlinks = 0;
    double tachAngle = 2.355;
    double accAngle = 2.355;
    int counter = 0;
    double tachChange = 0.01;
    double accChange = 0.005;
    public void drive(KeyEvent keyEvent) {
        if(keyEvent.getCode() == KeyCode.UP){
            System.out.println("Up key was pressed");
        }
    }

    @FXML
    public void initialize(){ }

    @FXML
    public void turnOnLeft(ActionEvent actionEvent) {
        flag = true;
        leftOn = true;
    }

    @FXML
    public void turnOnRight(ActionEvent actionEvent) {
        flag = true;
        rightOn = true;
    }
    @FXML
    public void startEngine(ActionEvent actionEvent) {
        startButton.setVisible(false);

        Timeline clock = new Timeline(new KeyFrame(Duration.ZERO, e -> {

            counter += 1;
            tachometerAnimation(tachometer.getStartX(), tachometer.getStartY(), sqrt(power(tachometer.getEndX() - tachometer.getStartX(), 2) + power(tachometer.getEndY() - tachometer.getStartY(), 2)));
            if(counter%5 == 0) {
                accelerometerAnimation(accelerometer.getStartX(), accelerometer.getStartY(), sqrt(power(accelerometer.getEndX() - accelerometer.getStartX(), 2) + power(accelerometer.getEndY() - accelerometer.getStartY(), 2)));
            }

            if(flag && counter%50 == 0){
                if(leftOn){
                    File file;
                    if(numberOfBlinks%2 == 1) {
                         file = new File("/Users/monikaciezka/Dashboard project/src/resources/left_arrow_on.png");
                         System.out.println("on");
                    } else {
                        file = new File("/Users/monikaciezka/Dashboard project/src/resources/left_arrow_off.png");
                        System.out.println("off");
                    }
                    Image left_arrow = new Image(file.toURI().toString());
                    leftView.setImage(left_arrow); //here we set the new graphic
                    numberOfBlinks += 1;
                } else if (rightOn){
                    File file;
                    if(numberOfBlinks%2 == 1) {
                        file = new File("/Users/monikaciezka/Dashboard project/src/resources/right_arrow_on.png");
                        System.out.println("on");
                    } else {
                        file = new File("/Users/monikaciezka/Dashboard project/src/resources/right_arrow_off.png");
                        System.out.println("off");
                    }
                    Image right_arrow = new Image(file.toURI().toString());
                    rightView.setImage(right_arrow); //here we set the new graphic
                    numberOfBlinks += 1;
                }

                if(numberOfBlinks > 10) {
                    flag = false;
                    rightOn = false;
                    leftOn = false;
                    numberOfBlinks = 0;
                }
            }


        }),
                new KeyFrame(Duration.seconds(0.01))
        );
        clock.setCycleCount(Animation.INDEFINITE);
        clock.play();
    }

    private void tachometerAnimation(double x_start, double y_start, double radius) {

        if(tachAngle >= 5){
            tachChange = -0.05;
        } else if (tachAngle < 2.3){
            tachChange = 0.01;
        }
        tachAngle += tachChange;
        x = radius*cos(tachAngle) + x_start;
        y = radius*sin(tachAngle) + y_start;

        tachometer.setEndX(x);
        tachometer.setEndY(y);
    }

    private void accelerometerAnimation(double x_start, double y_start, double radius){

        if (accAngle >= 5) {
            accChange = -0.02;
        } else if (accAngle < 2.3) {
            accChange = 0.005;
        }
        accAngle += accChange;
        x = radius*cos(accAngle) + x_start;
        y = radius*sin(accAngle) + y_start;

        accelerometer.setEndX(x);
        accelerometer.setEndY(y);
    }
}
