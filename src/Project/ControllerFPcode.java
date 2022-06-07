package Project;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;
import javafx.scene.control.Alert;
import javafx.stage.Window;

public class ControllerFPcode  extends ControllerFPemail{

    @FXML
    private Button button;

    @FXML
    private TextField code;

    public void Submit(ActionEvent event) throws IOException {
        
        String pin=code.getText();
         int pin1=Integer.parseInt(pin);
        int s= randomcode;
        if(s==pin1){
           
            Parent parent = FXMLLoader.load(getClass().getResource("sample23FPset.fxml"));
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        Scene scene = new Scene(parent);
        window.setScene(scene);
        window.setTitle("E-Health & Medicare");
        //window.setScene(new Scene(parent, 800, 650));
        window.show();
        }
        else{
             Window owner = button.getScene().getWindow();
             showAlert(Alert.AlertType.ERROR, owner, "Form Error!",
                "Code not match");
            
        }
        
        
    }
    private static void showAlert(Alert.AlertType alertType, Window owner, String title, String message) {
        Alert alert = new Alert(alertType);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.initOwner(owner);
        alert.show();
    }
}
