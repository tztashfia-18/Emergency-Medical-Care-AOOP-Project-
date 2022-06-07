package Project;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Window;


public class ControllerAdminlg {
    
     @FXML
    private PasswordField AdminPass;

    @FXML
    private TextField UserID;

    @FXML
    private Button button;
    public void Previous(ActionEvent event) throws IOException {
        Parent parent = FXMLLoader.load(getClass().getResource("sample3provider.fxml"));
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        Scene scene = new Scene(parent);
        window.setScene(scene);
        window.setTitle("E-Health & Medicare");
        //window.setScene(new Scene(parent, 800, 650));
        window.show();
    }

    public void sgn(ActionEvent event) throws IOException {
        
        if(AdminPass.getText().equals("antash!")&&UserID.getText().equals("TAAdmin2")){
            
            Parent parent = FXMLLoader.load(getClass().getResource("sample7adminfilelist.fxml"));
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
                "Please Enter Your Correct User ID & Password");
            
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
