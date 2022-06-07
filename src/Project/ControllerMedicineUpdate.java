package Project;

import static Project.Controller2Customer.DB_URL;
import static Project.Controller2Customer.PASS;
import static Project.Controller2Customer.USER;
import static Project.ControllerMedicine.DB_URL;
import static Project.ControllerMedicine.PASS;
import static Project.ControllerMedicine.USER;
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
import java.io.*;
import java.sql.Connection;
import java.sql.*;
import java.sql.DriverManager;
import java.sql.SQLException;
import javafx.scene.control.Alert;
import javafx.stage.Window;

public class ControllerMedicineUpdate {
    @FXML
    private TextField amount;

    @FXML
    private Button button;

    @FXML
    private Button button1;

    @FXML
    private TextField company;

    @FXML
    private TextField gen_name;

    @FXML
    private TextField med_name;

    @FXML
    private TextField mg;

    @FXML
    private TextField phone;
    static final String DB_URL = "jdbc:mysql://localhost:3306/E-Health & Medicare";
   static final String USER = "root";
   static final String PASS = "";

    public void Previous(ActionEvent event) throws IOException {
        Parent parent = FXMLLoader.load(getClass().getResource("sample15Admed.fxml"));
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        Scene scene = new Scene(parent);
        window.setScene(scene);
        window.setTitle("E-Health & Medicare");
        //window.setScene(new Scene(parent, 800, 650));
        window.show();
    }

    public void add(ActionEvent event) throws IOException, ClassNotFoundException, SQLException {
        
         Window owner = button.getScene().getWindow(); 
        
           if (med_name.getText().isEmpty()) {
            showAlert(Alert.AlertType.ERROR, owner, "Form Error!",
                "Please Insert Medicine Name");
            return;
        }
        
        
        if (gen_name.getText().isEmpty()) {
            showAlert(Alert.AlertType.ERROR, owner, "Form Error!",
                "Please Insert Generic Name");
            return;
        }
        if (phone.getText().isEmpty()) {
            showAlert(Alert.AlertType.ERROR, owner, "Form Error!",
                "Please Insert Price");
            return;
        }
        if (amount.getText().isEmpty()) {
            showAlert(Alert.AlertType.ERROR, owner, "Form Error!",
                "Please Insert The Available Amount Of Medicine");
            return;
        }
        if (mg.getText().isEmpty()) {
            showAlert(Alert.AlertType.ERROR, owner, "Form Error!",
                "Please Insert mg Of The Medicine");
            return;
        }
        if (company.getText().isEmpty()) {
            showAlert(Alert.AlertType.ERROR, owner, "Form Error!",
                "Please Insert The company Name");
            return;
       
     
            
            
    }
          Connection con=null;
  
    Class.forName("com.mysql.jdbc.Driver");
          con= DriverManager.getConnection(DB_URL,USER,PASS);
          String sql = "INSERT INTO admed (name, gen_name, mg, amount, company, price) VALUES (?, ?, ?, ?, ?, ?)";
          PreparedStatement pz = con.prepareStatement(sql);
            pz.setString(1, med_name.getText());
            pz.setString(2, gen_name.getText());
            pz.setString(3, mg.getText());
            pz.setString(4, amount.getText());
            
            pz.setString(5, company.getText());
            pz.setString(6, phone.getText());
       
pz.executeUpdate();
pz.close(); 
con.close();
showAlert(Alert.AlertType.CONFIRMATION, owner, "Data Information",
                "Data Added Succefully");
med_name.setText("");
gen_name.setText("");
mg.setText("");
amount.setText("");
company.setText("");
phone.setText("");


    }
    public void remove(ActionEvent event) throws IOException, ClassNotFoundException, SQLException {
         Window owner = button1.getScene().getWindow(); 
        Connection conn=null;
         Class.forName("com.mysql.jdbc.Driver");
         conn= DriverManager.getConnection(DB_URL,USER,PASS);
         String so="delete from admed where name= ? and mg= ? and company= ?";
          PreparedStatement po = conn.prepareStatement(so);
          po.setString(1, med_name.getText());
          po.setString(2, mg.getText());
          po.setString(3, company.getText());
          
          po.execute();
             showAlert(Alert.AlertType.CONFIRMATION, owner, "Data Information",
                "Data Remove Succefully"); 
          po.close();
          conn.close();
          
         
          
          
       
          
        
        med_name.setText("");
        mg.setText("");
        company.setText("");

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
