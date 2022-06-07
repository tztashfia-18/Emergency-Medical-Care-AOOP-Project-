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

public class ControllerAmbulance implements Initializable  {
    @FXML
    private TableColumn<Cuambulance ,  String> Charges;

    @FXML
    private TableColumn<Cuambulance ,  String> ab_n0;

    @FXML
    private TableColumn<Cuambulance ,  String> address;

    @FXML
    private Button button;
    
     @FXML
    private TableColumn<Cuambulance, String> status;

    @FXML
    private TableColumn<Cuambulance ,  String> name;

    @FXML
    private TableColumn<Cuambulance ,  String> phone;

    @FXML
    private TextField search;

    @FXML
    private TableColumn<Cuambulance , String> time;

    @FXML
    private TableView<Cuambulance > ab_tab;

    
    public  ObservableList<Cuambulance>getamb() throws ClassNotFoundException, SQLException{
        ObservableList<Cuambulance> list4 =FXCollections.observableArrayList();
        
        Connection con=null;
         Class.forName("com.mysql.jdbc.Driver");
         con= DriverManager.getConnection(DB_URL,USER,PASS);
         String qu = "Select * from abinfo";
          PreparedStatement oa=(PreparedStatement) con.prepareStatement(qu);
          ResultSet rs =oa.executeQuery();
          while(rs.next()){
              list4.add(new Cuambulance(rs.getString("name"),rs.getString("phone"), rs.getString("address"),rs.getString("avtime"),rs.getString("abnumber"),rs.getString("charges"),rs.getString("status")) );
          }
         
        con.close();
     return list4;

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
        Parent parent = FXMLLoader.load(getClass().getResource("sample20AmbulanceContact"));
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
         String query = "Select * from abinfo where address= ?";
      java.sql.PreparedStatement pst = conn.prepareStatement(query);
       pst.setString(1, search.getText());
     
      ResultSet rs = pst.executeQuery(); 
      if(rs.next()){
          String s1=rs.getString(4);
          String s2=rs.getString(1);
          String s3=rs.getString(2);
          String s4=rs.getString(3);
          String s5=rs.getString(8);
          String s6=rs.getString(9);
          
          
          showAlert(Alert.AlertType.INFORMATION, owner, "Found","Name: "+s2+", Contact No: "+s4+", Address: "+s1+", Time: "+s3+", charges: "+s5+", Status: "+s6+
                "");
          
      }
      else{
          showAlert(Alert.AlertType.ERROR, owner, "Form Error!",
                "Not found");
      }
        
        
        
        
        
        
        
        
        
        

    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
         name.setCellValueFactory(new PropertyValueFactory<Cuambulance,String>("name"));
        time.setCellValueFactory(new PropertyValueFactory<Cuambulance,String>("time"));
        address.setCellValueFactory(new PropertyValueFactory<Cuambulance,String>("address"));
        //amt.setCellValueFactory(new PropertyValueFactory<medicinelist,String>("amount"));

        phone.setCellValueFactory(new PropertyValueFactory<Cuambulance,String>("phone"));
        ab_n0.setCellValueFactory(new PropertyValueFactory<Cuambulance,String>("ab_no"));
         Charges.setCellValueFactory(new PropertyValueFactory<Cuambulance,String>("charges"));
         status.setCellValueFactory(new PropertyValueFactory<Cuambulance,String>("star"));
        try {
            ab_tab.setItems(getamb());
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ControllerMedicine.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(ControllerMedicine.class.getName()).log(Level.SEVERE, null, ex);
        }
        ab_tab.getColumns().addAll(  name, phone,address,time, ab_n0,Charges,status);



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
