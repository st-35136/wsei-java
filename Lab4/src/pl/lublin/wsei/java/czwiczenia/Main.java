package pl.lublin.wsei.java.czwiczenia;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import pl.lublin.wsei.java.czwiczenia.test.TestFileRead;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("gusInfoGraphic.fxml"));
        primaryStage.setTitle("Hello World");
        primaryStage.setScene(new Scene(root, 300, 275));
        primaryStage.show();

        TestFileRead t = new TestFileRead();
    }


    public static void main(String[] args) {
        launch(args);
    }
}
