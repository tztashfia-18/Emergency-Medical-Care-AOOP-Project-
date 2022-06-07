package Project;

import static Project.ControllerMedicineUpdate.DB_URL;
import static Project.ControllerMedicineUpdate.PASS;
import static Project.ControllerMedicineUpdate.USER;
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
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javafx.scene.control.Alert;
import javafx.stage.Window;

public class ControllerAdICUupdate {
    @FXML
    private Button button;

    @FXML
    private Button button1;

    @FXML
    private TextField contact;

    @FXML
    private TextField hospital;

    @FXML
    private TextField seats;

    public void Previous(ActionEvent event) throws IOException {
        Parent parent = FXMLLoader.load(getClass().getResource("sample17AdICU.fxml"));
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        Scene scene = new Scene(parent);
        window.setScene(scene);
        window.setTitle("E-Health & Medicare");
        //window.setScene(new Scene(parent, 800, 650));
        window.show();
    }

    public void add(ActionEvent event) throws IOException, ClassNotFoundException, SQLException {
         Window owner = button.getScene().getWindow(); 
        
        
        
        if (hospital.getText().isEmpty()) {
            showAlert(Alert.AlertType.ERROR, owner, "Form Error!",
                "Please Insert Hospital Name");
            return;
        }
        if (contact.getText().isEmpty()) {
            showAlert(Alert.AlertType.ERROR, owner, "Form Error!",
                "Please Insert Contact Number");
            return;
        }
        if (seats.getText().isEmpty()) {
            showAlert(Alert.AlertType.ERROR, owner, "Form Error!",
                "Please Insert The Available Number Of Seats");
            return;
        }
       
          Connection con=null;
  
    Class.forName("com.mysql.jdbc.Driver");
          con= DriverManager.getConnection(DB_URL,USER,PASS);
          String sql = "INSERT INTO adminicu (Hospital_Name, Contact_No, Available_Seats) VALUES (?, ?, ?)";
          PreparedStatement pz = con.prepareStatement(sql);
            pz.setString(1, hospital.getText());
            pz.setString(2, contact.getText());
            pz.setString(3, seats.getText());
          
           
       
pz.executeUpdate();
pz.close(); 
con.close();
showAlert(Alert.AlertType.CONFIRMATION, owner, "Data Information",
                "Data Added Succefully");
hospital.setText("");
contact.setText("");
seats.setText("");
;
        
        

    }
    public void remove(ActionEvent event) throws IOException, ClassNotFoundException, SQLException {
        
        Window owner = button1.getScene().getWindow(); 
        
        
        
        
        
        Connection conn=null;
         Class.forName("com.mysql.jdbc.Driver");
         conn= DriverManager.getConnection(DB_URL,USER,PASS);
         String so="delete from adminicu where Hospital_Name= ?";
          PreparedStatement po = conn.prepareStatement(so);
          po.setString(1, hospital.getText());
         
         po.execute();
              showAlert(Alert.AlertType.CONFIRMATION, owner, "Data Information",
                "Data Remove Succefully");
              po.close();
          conn.close();
         
        
         
         
          
          
        
        hospital.setText("");

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
