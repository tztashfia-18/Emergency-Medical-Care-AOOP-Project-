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

public class ControllerAdDoctorUpdate {

    @FXML
    private Button button;
    
     @FXML
    private TextField catagory;

    @FXML
    private Button button1;
    @FXML
    private Button button3;

    @FXML
    private TextField charges;

    @FXML
    private TextField contact;

    @FXML
    private TextField doc_name;

    @FXML
    private TextField hospital;

    @FXML
    private TextField time;

    public void Previous(ActionEvent event) throws IOException {
        Parent parent = FXMLLoader.load(getClass().getResource("sample16Addoc.fxml"));
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        Scene scene = new Scene(parent);
        window.setScene(scene);
        window.setTitle("E-Health & Medicare");
        //window.setScene(new Scene(parent, 800, 650));
        window.show();
    }

    public void add(ActionEvent event) throws IOException, ClassNotFoundException, SQLException {
         Window owner = button.getScene().getWindow(); 
        
          if (doc_name.getText().isEmpty()) {
            showAlert(Alert.AlertType.ERROR, owner, "Form Error!",
                "Please Insert Doctor Details");
            return;
        }
        if (contact.getText().isEmpty()) {
            showAlert(Alert.AlertType.ERROR, owner, "Form Error!",
                "Please Insert Contact Number");
            return;
        }
        if (hospital.getText().isEmpty()) {
            showAlert(Alert.AlertType.ERROR, owner, "Form Error!",
                "Please Insert Hospital Address");
            return;
    }
            if (time.getText().isEmpty()) {
            showAlert(Alert.AlertType.ERROR, owner, "Form Error!",
                "Please Insert Time");
            return;
        }
        if (charges.getText().isEmpty()) {
            showAlert(Alert.AlertType.ERROR, owner, "Form Error!",
                "Please Insert Charges");
            return;
        }
          Connection con=null;
  
    Class.forName("com.mysql.jdbc.Driver");
          con= DriverManager.getConnection(DB_URL,USER,PASS);
          String sql = "INSERT INTO addoc (DoctorName, Contact_No, Time, Hospital, Charges,Catagory) VALUES (?, ?, ?, ?, ?,?)";
          PreparedStatement pz = con.prepareStatement(sql);
            pz.setString(1, doc_name.getText());
            pz.setString(2, contact.getText());
            pz.setString(3, time.getText());
            pz.setString(4, hospital.getText());
            
            pz.setString(5, charges.getText());
            pz.setString(6, catagory.getText());
       
pz.executeUpdate();
pz.close(); 
con.close();
showAlert(Alert.AlertType.CONFIRMATION, owner, "Data Information",
                "Data Added Succefully");
doc_name.setText("");
contact.setText("");
time.setText("");
hospital.setText("");
charges.setText("");
catagory.setText("");
//phone.setText("");
       

    }
    public void remove(ActionEvent event) throws IOException, ClassNotFoundException, SQLException {
        Window owner = button1.getScene().getWindow(); 
        Connection conn=null;
         Class.forName("com.mysql.jdbc.Driver");
         conn= DriverManager.getConnection(DB_URL,USER,PASS);
         String so="delete from addoc where DoctorName= ? and Catagory= ?";
          PreparedStatement po = conn.prepareStatement(so);
          po.setString(1, doc_name.getText());
          po.setString(2, catagory.getText());
         
         po.execute();
              showAlert(Alert.AlertType.CONFIRMATION, owner, "Data Information",
                "Data Remove Succefully");
              po.close();
          conn.close();
         
         
          
          
        
        doc_name.setText("");
        catagory.setText("");
        
        
        
       
        
        
        
        
        
        
       

        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        

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
