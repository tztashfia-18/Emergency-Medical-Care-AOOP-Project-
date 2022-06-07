package Project;

import static Project.ControllerMedicine.DB_URL;
import static Project.ControllerMedicine.PASS;
import static Project.ControllerMedicine.USER;
import com.mysql.jdbc.PreparedStatement;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
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
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

public class ControllerAdICU implements Initializable   {
    
      @FXML
    private TableColumn<adicu, String> contact;

    @FXML
    private TableColumn<adicu, String> hospital_name;

    @FXML
    private TableView<adicu> icu_tab;

    @FXML
    private TableColumn<adicu, String> seats;
    
    
    
    
     public  ObservableList<adicu>geticu() throws ClassNotFoundException, SQLException{
        ObservableList<adicu> list5 =FXCollections.observableArrayList();
        
        Connection conn=null;
         Class.forName("com.mysql.jdbc.Driver");
         conn= DriverManager.getConnection(DB_URL,USER,PASS);
         String qu = "Select * from adminicu";
          PreparedStatement oa=(PreparedStatement) conn.prepareStatement(qu);
          ResultSet rs =oa.executeQuery();
          while(rs.next()){
              list5.add(new adicu(rs.getString("Hospital_Name"),rs.getString("Contact_No"), rs.getString("Available_Seats")) );
          }
         
        conn.close();
     return list5;

    }
    
    
    
    
    
    
    
    

    public void Previous(ActionEvent event) throws IOException {
        Parent parent = FXMLLoader.load(getClass().getResource("sample7adminfilelist.fxml"));
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
    public void Update(ActionEvent event) throws IOException {
        Parent parent = FXMLLoader.load(getClass().getResource("ICUupdate.fxml"));
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        Scene scene = new Scene(parent);
        window.setScene(scene);
        window.setTitle("E-Health & Medicare");
        //window.setScene(new Scene(parent, 800, 650));
        window.show();
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
         hospital_name.setCellValueFactory(new PropertyValueFactory<adicu,String>("hospitalname"));
        contact.setCellValueFactory(new PropertyValueFactory<adicu,String>("contactnum"));
        seats.setCellValueFactory(new PropertyValueFactory<adicu,String>("seat"));
       

        
        try {
            icu_tab.setItems(geticu());
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ControllerMedicine.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(ControllerMedicine.class.getName()).log(Level.SEVERE, null, ex);
        }
        icu_tab.getColumns().addAll(hospital_name,contact,seats);


    }
}
