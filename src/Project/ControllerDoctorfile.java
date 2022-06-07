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
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Window;

public class ControllerDoctorfile implements Initializable {
      @FXML
    private Button button;
      
       @FXML
    private TableColumn<Cudoctor,String> catagory;

   @FXML
    private TableView<Cudoctor> doc_tab;
      @FXML
    private TableColumn<Cudoctor, String> charges;

    @FXML
    private TableColumn<Cudoctor, String> contact;

    @FXML
    private TableColumn<Cudoctor, String> doc_name;

    

    @FXML
    private TableColumn<Cudoctor, String> hospital;
      @FXML
    private TableColumn<Cudoctor, String> time;

    @FXML
    private TextField search;
    
    
    public  ObservableList<Cudoctor>setdoc() throws ClassNotFoundException, SQLException{
        ObservableList<Cudoctor> list3 =FXCollections.observableArrayList();
        
        Connection con=null;
         Class.forName("com.mysql.jdbc.Driver");
         con= DriverManager.getConnection(DB_URL,USER,PASS);
         String qu = "Select * from addoc";
          PreparedStatement oa=(PreparedStatement) con.prepareStatement(qu);
          ResultSet rs =oa.executeQuery();
          while(rs.next()){
              list3.add(new Cudoctor(rs.getString("DoctorName"),rs.getString("Contact_No"), rs.getString("Time"),rs.getString("Hospital"),rs.getString("Charges"),rs.getString("Catagory")) );
          }
         
        con.close();
     return list3;

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
         String query = "Select * from addoc where Catagory= ?";
      java.sql.PreparedStatement pst = conn.prepareStatement(query);
       pst.setString(1, search.getText());
     
      ResultSet rs = pst.executeQuery(); 
      if(rs.next()){
          String s1=rs.getString(1);
          String s2=rs.getString(2);
          String s3=rs.getString(5);
          
          showAlert(Alert.AlertType.INFORMATION, owner, "Found","Name: "+s1+", Contact No: "+s2+", charges: "+s3+
                "");
          
      }
      else{
          showAlert(Alert.AlertType.ERROR, owner, "Form Error!",
                "Not found");
      }
        
        
        

    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
         doc_name.setCellValueFactory(new PropertyValueFactory<Cudoctor,String>("doc_details"));
        contact.setCellValueFactory(new PropertyValueFactory<Cudoctor,String>("contact"));
        time.setCellValueFactory(new PropertyValueFactory<Cudoctor,String>("time"));
       

        hospital.setCellValueFactory(new PropertyValueFactory<Cudoctor,String>("hospital"));
        charges.setCellValueFactory(new PropertyValueFactory<Cudoctor,String>("charges"));
        catagory.setCellValueFactory(new PropertyValueFactory<Cudoctor,String>("catagorys"));

        
         try {
             doc_tab.setItems(setdoc());
         } catch (ClassNotFoundException ex) {
             Logger.getLogger(ControllerAddoc.class.getName()).log(Level.SEVERE, null, ex);
         } catch (SQLException ex) {
             Logger.getLogger(ControllerAddoc.class.getName()).log(Level.SEVERE, null, ex);
         }
                 
        doc_tab.getColumns().addAll(doc_name,contact ,hospital, time, charges,catagory);
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

