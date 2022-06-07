package Project;


import static Project.ControllerFPemail.DB_URL;
import static Project.ControllerFPemail.PASS;
import static Project.ControllerFPemail.USER;
import com.mysql.jdbc.Connection;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;

import javafx.stage.Stage;

import java.io.IOException;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import javafx.scene.control.Alert;
import javafx.stage.Window;

import java.sql.SQLException;
import javafx.scene.control.PasswordField;

public class ControllerFPset  extends ControllerFPemail{

    @FXML
    private Button button;

     @FXML
    private PasswordField confirmpass;

    @FXML
    private PasswordField newpass;
 static final String DB_URL = "jdbc:mysql://localhost:3306/E-Health & Medicare";
   static final String USER = "root";
   static final String PASS = "";
   
   
    public void Set(ActionEvent event) throws IOException, ClassNotFoundException, SQLException {
        
       
    Window owner = button.getScene().getWindow();
    String a=newpass.getText();
        String b=confirmpass.getText();
        if(a.equals(b)){
            Connection cox=null;
     Class.forName("com.mysql.jdbc.Driver");
     cox= (Connection) DriverManager.getConnection(DB_URL,USER,PASS);
     String asi= "update save set password= ? where email= ?";
      PreparedStatement abc =cox.prepareStatement(asi);
      abc.setString(1, a);
               abc.setString(2,azw);
             abc.executeUpdate();
             abc.close();
            cox.close();
             showAlert(Alert.AlertType.CONFIRMATION, owner, "Done",
                "Password is changed");
              Parent parent = FXMLLoader.load(getClass().getResource("sample2customer.fxml"));
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        Scene scene = new Scene(parent);
        window.setScene(scene);
        window.setTitle("E-Health & Medicare");
        //window.setScene(new Scene(parent, 800, 650));
        window.show(); 
             
        }
        else{
            showAlert(Alert.AlertType.CONFIRMATION, owner, "Done",
                "Enter the same password");
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
