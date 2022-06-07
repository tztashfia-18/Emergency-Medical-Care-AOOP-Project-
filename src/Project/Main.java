package Project;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;


public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("sample1.fxml"));
        Scene scene = new Scene(root);
        primaryStage.setScene(scene);
        primaryStage.setTitle("E-Health & Medicare");
        //primaryStage.setScene(new Scene(root));
        //primaryStage.sizeToScene();
        primaryStage.show();

    }


    public static void main(String[] args) {
        launch(args);
    }
}

