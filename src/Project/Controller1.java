package Project;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class Controller1 {


    @FXML

        public void customer(ActionEvent event) throws IOException {

           Parent parent = FXMLLoader.load(getClass().getResource("sample2customer.fxml"));
           Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
           Scene scene = new Scene(parent);
           window.setScene(scene);
           window.setTitle("E-Health & Medicare");
           //window.setScene(new Scene(parent, 800, 650));
           window.show();

    }

    public void Provider(ActionEvent event) throws IOException {
        Parent parent = FXMLLoader.load(getClass().getResource("sample3provider.fxml"));
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        Scene scene = new Scene(parent);
        window.setScene(scene);
        window.setTitle("E-Health & Medicare");
        //window.setScene(new Scene(parent, 800, 650));
        window.show();

    }



    public void Aboutus(ActionEvent event) throws IOException {
        Parent parent = FXMLLoader.load(getClass().getResource("sample5aboutUs.fxml"));
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        Scene scene = new Scene(parent);
        window.setScene(scene);
        window.setTitle("E-Health & Medicare");
        //window.setScene(new Scene(parent, 800, 650));
        window.show();

    }
}
