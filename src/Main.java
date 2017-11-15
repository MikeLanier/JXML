import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

import java.util.prefs.Preferences;

public class Main extends Application {

    private Stage primaryStage;

    @Override
    public void start(Stage _primaryStage) throws Exception{
//        System.out.println("start");
        primaryStage = _primaryStage;

//        GridPane root = new MainFrm.MainFrm();
        GridPane root = new GridPane();
        primaryStage.setTitle("JXML");

        Scene scene = new Scene(root, 800, 600);

        // Get frame size and location from the users preferences
        Preferences userPrefs = Preferences.userNodeForPackage(getClass());
        double x = userPrefs.getDouble("stage.x", 100);
        double y = userPrefs.getDouble("stage.y", 100);
        double w = userPrefs.getDouble("stage.width", 800);
        double h = userPrefs.getDouble("stage.height", 600);

        primaryStage.setScene(scene);
        primaryStage.setX(x);
        primaryStage.setY(y);
        primaryStage.setWidth(w);
        primaryStage.setHeight(h);
        primaryStage.show();
    }

    @Override
    public void stop()
    {
//        System.out.println("stop: enter");
        // when the app closes, save the frame size and location
        Preferences userPrefs = Preferences.userNodeForPackage(getClass());
        userPrefs.putDouble("stage.x", primaryStage.getX());
        userPrefs.putDouble("stage.y", primaryStage.getY());
        userPrefs.putDouble("stage.width", primaryStage.getWidth());
        userPrefs.putDouble("stage.height", primaryStage.getHeight());
//        System.out.println("stop: exit");
    }

    public static void main(String[] args) {
        launch(args);
    }
}