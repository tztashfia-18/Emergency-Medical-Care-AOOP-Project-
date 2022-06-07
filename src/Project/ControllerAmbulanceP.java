package Project;
//UPDATE abinfo
//SET charges = '200'
//WHERE name = 'Shovon';

//DELETE FROM abinfo WHERE phone='027862346';
import static Project.Controller2Customer.DB_URL;
import static Project.Controller2Customer.PASS;
import static Project.Controller2Customer.USER;
import static Project.Controller2Customer.s1;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Random;
import java.util.ResourceBundle;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.stage.Window;

public class ControllerAmbulanceP implements Initializable{
    static final String DB_URL = "jdbc:mysql://localhost:3306/E-Health & Medicare";
   static final String USER = "root";
   static final String PASS = "";
    public static String s1;
    public static String s2;
    public static String s3;
    public static String s4;
    public static String s5;
    public static String s7;
    public static String s8;
    public static int s6;
    
     @FXML
    private Label Terms;
    @FXML
    private TextField address;

    @FXML
    private TextField ambulance_no;

    @FXML
    private Button button;

    @FXML
    private Button button1;

    @FXML
    private PasswordField logpass;

    @FXML
    private TextField logphone;

    @FXML
    private TextField name;

    @FXML
    private PasswordField password;

    @FXML
    private PasswordField password1;

    @FXML
    private TextField phone;

    @FXML
    private TextField time;
    public void Previous(ActionEvent event) throws IOException {
        Parent parent = FXMLLoader.load(getClass().getResource("sample3provider.fxml"));
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        Scene scene = new Scene(parent);
        window.setScene(scene);
        window.setTitle("E-Health & Medicare");
        //window.setScene(new Scene(parent, 800, 650));
        window.show();
    }

    public void signup(ActionEvent event) throws IOException, ClassNotFoundException, SQLException {
        
        
        String name1 = name.getText();
        String avtime1 = time.getText();
        String address1 = address.getText();
        String phone1 = phone.getText();
        String password12 = password.getText();
        String password22 = password1.getText();
        String abNumber = ambulance_no.getText();
        
        
        
     Window owner = button.getScene().getWindow(); 
        
        if (name.getText().isEmpty()) {
            showAlert(Alert.AlertType.ERROR, owner, "Form Error!",
                "Please Enter Your Name");
            return;
        }
        
        
        if (time.getText().isEmpty()) {
            showAlert(Alert.AlertType.ERROR, owner, "Form Error!",
                "Please Enter Your Available Time In This Field");
            return;
        }
        if (phone.getText().isEmpty()) {
            showAlert(Alert.AlertType.ERROR, owner, "Form Error!",
                "Please Enter Your Phone Number");
            return;
        }
        if (address.getText().isEmpty()) {
            showAlert(Alert.AlertType.ERROR, owner, "Form Error!",
                "Please Enter Your Address");
            return;
        }
        if (password.getText().isEmpty()) {
            showAlert(Alert.AlertType.ERROR, owner, "Form Error!",
                "Please Enter Your Password In This Fiels");
            return;
        }
        if (password1.getText().isEmpty()) {
            showAlert(Alert.AlertType.ERROR, owner, "Form Error!",
                "Please Confirm Your Password In This Field");
            return;
        }
        if (ambulance_no.getText().isEmpty()) {
            showAlert(Alert.AlertType.ERROR, owner, "Form Error!",
                "Please Add Your Vehicle(Ambulance) Number In This Field");
            return;
        }
        if(!password12.equals(password22)){
            showAlert(Alert.AlertType.ERROR, owner, "Form Error!",
                "Password Not Same");
            return;
        }
         Connection conn = null;
  
    Class.forName("com.mysql.jdbc.Driver");
    
    
    
    
      conn = DriverManager.getConnection(DB_URL,USER,PASS);
         
      String query = "Select * from abinfo where abnumber= ?";
      PreparedStatement pst = conn.prepareStatement(query);
      //pst.setString(1, phone.getText());
      pst.setString(1, ambulance_no.getText());
     
      ResultSet rs = pst.executeQuery(); 
      if(rs.next()){
          showAlert(Alert.AlertType.ERROR, owner, "Form Error!",
                "This Ambulance Number Already Used");
           return;
      }
      
      
   
      
      
      
      
      
      
      
      
      
      
      
      
      
      
       Random rand=new Random();
        int randomcode = rand.nextInt(999999);
        
         Connection con=null;
        Class.forName("com.mysql.jdbc.Driver");
        con=DriverManager.getConnection(DB_URL,USER,PASS);
        
        
        String INSERT_QUERY = "INSERT INTO abinfo (name, avtime, phone, address, password, abnumber, accountnumber) VALUES (?, ?, ?, ?, ?, ?, ?)";
         
       
         PreparedStatement pz = con.prepareStatement(INSERT_QUERY);
            pz.setString(1, name.getText());
            pz.setString(2, time.getText());
            pz.setString(3, phone.getText());
            pz.setString(4, address.getText());
            pz.setString(5, password.getText());  
            pz.setString(6, ambulance_no.getText());
            pz.setInt(7, randomcode);
       
pz.executeUpdate();
pz.close(); 
con.close();
name.setText("");
time.setText("");
phone.setText("");
address.setText("");
password.setText("");
ambulance_no.setText("");
password1.setText("");
showAlert(Alert.AlertType.CONFIRMATION, owner, "Done",
                "Your Account Is Created, Thanks For Joining Us !!");
          
        
        
        
        
        
        
        
        
        
        

    }
    
   


    public void signIn(ActionEvent event) throws IOException, ClassNotFoundException, SQLException {
        
        
          Window owner = button1.getScene().getWindow();
       
      if (logphone.getText().isEmpty()) {
            showAlert(Alert.AlertType.ERROR, owner, "Form Error!",
                "Please Enter Your Phone Number");
            return;
        }
      if (logpass.getText().isEmpty()) {
            showAlert(Alert.AlertType.ERROR, owner, "Form Error!",
                "Please Enter Correct Password");
            return;
        }
     
      
      Connection con = null;
  
    Class.forName("com.mysql.jdbc.Driver");
    
      con = DriverManager.getConnection(DB_URL,USER,PASS);
       String query = "Select * from abinfo where phone=? and password=?";
      PreparedStatement pst = con.prepareStatement(query);
       pst.setString(1, logphone.getText());
      pst.setString(2, logpass.getText());
      ResultSet rs = pst.executeQuery(); 
      if(rs.next()){
         
          
          
          
          
           s1=rs.getString(1);
        s2=rs.getString(2);
        s3=rs.getString(3);
        s4=rs.getString(4);
        s5=rs.getString(5);
        s7=rs.getString(6);
        s8=rs.getString(7);
        s6=rs.getInt(6);
        
          Parent parent = FXMLLoader.load(getClass().getResource("sample9ambulanceT.fxml"));
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        Scene scene = new Scene(parent);
        window.setScene(scene);
        window.setTitle("E-Health & Medicare");
       
        window.show();
        
        
        
        
     
    }
       else{
           showAlert(Alert.AlertType.ERROR, owner, "Form Error!",
                "Please Enter Phone Number & Password");
      }
      
        
        
        
        
            
            }



    public void AcontactUs(ActionEvent event) throws IOException {
        Parent parent = FXMLLoader.load(getClass().getResource("sample20AmbulanceContact.fxml"));
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        Scene scene = new Scene(parent);
        window.setScene(scene);
        window.setTitle("E-Health & Medicare");
        //window.setScene(new Scene(parent, 800, 650));
        window.show();
    }
     private static void showAlert(Alert.AlertType alertType, Window owner, String title, String message) {
        Alert alert = new Alert(alertType);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.initOwner(owner);
        alert.show();
    



    }
     @Override
    public void initialize(URL url, ResourceBundle rb) {
       Terms.setText("Hello!!\n\n\n#Always be ready for service in\n  your mentioned time.\n\n#You have to follow min & max\n  charges.\n\n#Any misconception will be\n  punished!");
    }


}
