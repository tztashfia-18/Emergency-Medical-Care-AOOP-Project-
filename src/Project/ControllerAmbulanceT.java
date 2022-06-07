package Project;

import com.mysql.jdbc.Connection;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.Initializable;
import java.io.IOException;
import java.net.URL;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.scene.control.Alert;
import javafx.stage.Window;

public class ControllerAmbulanceT extends ControllerAmbulanceP  implements Initializable  {
    @FXML 
    private TextField abacc;

    @FXML
    private Label abname;

    @FXML
    private TextField anos;

    @FXML
    private Button button100;

    @FXML
    private TextField doller;

    @FXML
    private TextField loc;

    @FXML
    private TextField num;

    @FXML
    private TextField number;

    @FXML
    private TextField times;

    @FXML
    private ComboBox usez;
     public static  String s;
    @FXML
    void avvv(ActionEvent event) throws ClassNotFoundException, SQLException {
        
              s=usez.getSelectionModel().getSelectedItem().toString();
              Connection connn=null;
        Class.forName("com.mysql.jdbc.Driver");
        connn=(Connection) DriverManager.getConnection(DB_URL,USER,PASS);
        
        String spz = "update abinfo set status= ? where name= ?";
       
        PreparedStatement pzq = connn.prepareStatement(spz);
        pzq.setString(1,s);
        pzq.setString(2,s1);
         pzq.executeUpdate();
              
    pzq.close(); 
    
    connn.close();
        
    }

    @FXML
    void okaz(ActionEvent event) throws ClassNotFoundException, SQLException {

 Connection con=null;
        Class.forName("com.mysql.jdbc.Driver");
        con=(Connection) DriverManager.getConnection(DB_URL,USER,PASS);
        
        String sp = "update abinfo set charges= ? where name= ?";
       
        PreparedStatement pz = con.prepareStatement(sp);
        pz.setString(1,doller.getText());
        pz.setString(2,s1);
         pz.executeUpdate();
              
    pz.close(); 
    
    con.close();
     Window owner = button100.getScene().getWindow();
    showAlert(Alert.AlertType.CONFIRMATION, owner, "Upate",
                "Update your Charges");
    doller.setText("");
        
    }

    @FXML
    void out(ActionEvent event) throws IOException {

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
          abname.setText("Hello!! "+s1+" All Info");
        num.setText(s1);
       
         num.setEditable(false);
         number.setText(s3);
         number.setEditable(false);
         loc.setText(s4);
         loc.setEditable(false);
         times.setText(s2);
         times.setEditable(false);
         anos.setText(s7);
         anos.setEditable(false);
         abacc.setText(s8);
         abacc.setEditable(false);
         ObservableList<String> list=FXCollections.observableArrayList("ON","OFF");
    usez.setItems(list);
    
   

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
