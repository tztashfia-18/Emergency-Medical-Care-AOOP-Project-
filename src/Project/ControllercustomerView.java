package Project;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;

public class ControllercustomerView extends Controller2Customer implements Initializable {
     @FXML
    private Label cuname;
    @FXML
    public void Medicine(ActionEvent event) throws IOException {
        Parent parent = FXMLLoader.load(getClass().getResource("sample10Medicine.fxml"));
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        Scene scene = new Scene(parent);
        window.setScene(scene);
        window.setTitle("E-Health & Medicare");
        //window.setScene(new Scene(parent, 800, 650));
        window.show();
    }



    public void  Ambulance(ActionEvent event) throws IOException {
        Parent parent = FXMLLoader.load(getClass().getResource("sample11ambulancefile.fxml"));
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        Scene scene = new Scene(parent);
        window.setScene(scene);
        window.setTitle("E-Health & Medicare");
        //window.setScene(new Scene(parent, 800, 650));
        window.show();
    }

    public void  Doctor(ActionEvent event) throws IOException {
        Parent parent = FXMLLoader.load(getClass().getResource("sample12doctocfile.fxml"));
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        Scene scene = new Scene(parent);
        window.setScene(scene);
        window.setTitle("E-Health & Medicare");
        //window.setScene(new Scene(parent, 800, 650));
        window.show();
    }


    public void ICU(ActionEvent event) throws IOException {
        Parent parent = FXMLLoader.load(getClass().getResource("sample13ICUfile.fxml"));
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        Scene scene = new Scene(parent);
        window.setScene(scene);
        window.setTitle("E-Health & Medicare");
        //window.setScene(new Scene(parent, 800, 650));
        window.show();
    }




//    public void Accessories(ActionEvent event) throws IOException {
//        Parent parent = FXMLLoader.load(getClass().getResource("sample14Accessories.fxml"));
//        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
//        Scene scene = new Scene(parent);
//        window.setScene(scene);
//        window.setTitle("E-Health & Medicare");
//        //window.setScene(new Scene(parent, 800, 650));
//        window.show();
//    }
    public void Previous(ActionEvent event) throws IOException {
        Parent parent = FXMLLoader.load(getClass().getResource("sample1.fxml"));
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        Scene scene = new Scene(parent);
        window.setScene(scene);
        window.setTitle("E-Health & Medicare");
        //window.setScene(new Scene(parent, 800, 650));
        window.show();
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
       cuname.setText("Hello!! "+s1);
    }
}
