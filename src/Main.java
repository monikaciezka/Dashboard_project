import javafx.application.Application;
import javafx.application.Platform;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;



public class Main extends Application {

    Stage multimediaStage = new Stage();

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception {

        Parent multimediaScreen = FXMLLoader.load(getClass().getResource("resources/MultimediaWindow.fxml"));
        Scene homeScene = new Scene(multimediaScreen);
        multimediaStage.setScene(homeScene);
        multimediaStage.show();

        Parent meterScreen = FXMLLoader.load(getClass().getResource("resources/MeterWindow.fxml"));
        Scene meterScene = new Scene(meterScreen);
        stage.setScene(meterScene);
        stage.setTitle("meter window");

        stage.show();
        stage.setOnCloseRequest(e -> {
            Platform.exit();
        });
    }
}



