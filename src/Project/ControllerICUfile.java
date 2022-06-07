package Project;

import static Project.ControllerMedicine.DB_URL;
import static Project.ControllerMedicine.PASS;
import static Project.ControllerMedicine.USER;
import com.mysql.jdbc.PreparedStatement;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Window;

public class ControllerICUfile implements Initializable {

    @FXML
    private Button button;

    @FXML
    private TableColumn<adicu, String> contact;

    @FXML
    private TableColumn<adicu, String> hospital;

    @FXML
    private TableView<adicu> icu_tab;

    @FXML
    private TextField search;

    @FXML
    private TableColumn<adicu,String> seats;
    
    
    
    
    public  ObservableList<adicu>geticu() throws ClassNotFoundException, SQLException{
        ObservableList<adicu> list6 =FXCollections.observableArrayList();
        
        Connection conn=null;
         Class.forName("com.mysql.jdbc.Driver");
         conn= DriverManager.getConnection(DB_URL,USER,PASS);
         String qu = "Select * from adminicu";
          PreparedStatement oa=(PreparedStatement) conn.prepareStatement(qu);
          ResultSet rs =oa.executeQuery();
          while(rs.next()){
              list6.add(new adicu(rs.getString("Hospital_Name"),rs.getString("Contact_No"), rs.getString("Available_Seats")) );
          }
         
        conn.close();
     return list6;

    }

    public void Previous(ActionEvent event) throws IOException {
        Parent parent = FXMLLoader.load(getClass().getResource("sample4customerview.fxml"));
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        Scene scene = new Scene(parent);
        window.setScene(scene);
        window.setTitle("E-Health & Medicare");
        //window.setScene(new Scene(parent, 800, 650));
        window.show();
    }

    public void sgnout(ActionEvent event) throws IOException {
        Parent parent = FXMLLoader.load(getClass().getResource("sample1.fxml"));
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        Scene scene = new Scene(parent);
        window.setScene(scene);
        window.setTitle("E-Health & Medicare");
        //window.setScene(new Scene(parent, 800, 650));
        window.show();
    }

    public void contactUs(ActionEvent event) throws IOException {
        Parent parent = FXMLLoader.load(getClass().getResource("sample19ContactUs.fxml"));
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        Scene scene = new Scene(parent);
        window.setScene(scene);
        window.setTitle("E-Health & Medicare");
        //window.setScene(new Scene(parent, 800, 650));
        window.show();
    }
    public void Search(ActionEvent event) throws IOException, ClassNotFoundException, SQLException {
         Window owner = button.getScene().getWindow(); 
         Connection conn=null;
         Class.forName("com.mysql.jdbc.Driver");
         conn= DriverManager.getConnection(DB_URL,USER,PASS);
         String query = "Select * from adminicu where Hospital_Name=?";
      java.sql.PreparedStatement pst = conn.prepareStatement(query);
       pst.setString(1, search.getText());
     
      ResultSet rs = pst.executeQuery(); 
      if(rs.next()){
          String s1=rs.getString(1);
          String s2=rs.getString(2);
          String s3=rs.getString(3);
          
          showAlert(Alert.AlertType.INFORMATION, owner, "Found","Hospital Name:v"+s1+", Contact: "+s2+", Seats: "+s3+"");
          
      }
      else{
          showAlert(Alert.AlertType.ERROR, owner, "Form Error!",
                "Not found");
      }

    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
          hospital.setCellValueFactory(new PropertyValueFactory<adicu,String>("hospitalname"));
        contact.setCellValueFactory(new PropertyValueFactory<adicu,String>("contactnum"));
        seats.setCellValueFactory(new PropertyValueFactory<adicu,String>("seat"));
       

        
        try {
            icu_tab.setItems(geticu());
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ControllerMedicine.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(ControllerMedicine.class.getName()).log(Level.SEVERE, null, ex);
        }
        icu_tab.getColumns().addAll(hospital,contact,seats);


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

