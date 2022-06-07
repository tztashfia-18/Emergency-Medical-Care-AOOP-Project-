package Project;
import java.io.*;
import java.sql.Connection;
import java.sql.*;
import java.sql.DriverManager;


import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;
import javafx.stage.Window;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Properties;
import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class Controller2Customer  {
    @FXML
    private TextField name;
    @FXML
    private TextField email;
    @FXML
    private TextField phone;
    @FXML
    private TextField address;
    @FXML
    private PasswordField password;
    @FXML
    private PasswordField  password2;
    @FXML
    private Label error_signup;
    @FXML
    private Button button;

    @FXML
    private Button button1;
      @FXML
    private Button button2;

      @FXML
    private TextField Logemail;
 @FXML
    private PasswordField password3;
 
 public static String s1;
 public static String s2;
 public static String s3;
 public static String s4;

    public Controller2Customer() throws IOException {
    }


    public void Previous(ActionEvent event) throws IOException {
        Parent parent = FXMLLoader.load(getClass().getResource("sample1.fxml"));
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        Scene scene = new Scene(parent);
        window.setScene(scene);
        window.setTitle("E-Health & Medicare");
        //window.setScene(new Scene(parent, 800, 650));
        window.show();
    }





static final String DB_URL = "jdbc:mysql://localhost:3306/E-Health & Medicare";
   static final String USER = "root";
   static final String PASS = "";

    public void SignupC(ActionEvent event) throws IOException, ClassNotFoundException, SQLException {
        String name1 = name.getText();
        String email1 = email.getText();
        String address1 = address.getText();
        String phone1 = phone.getText();
        String password12 = password.getText();
        
        String password22 = password2.getText();
     Window owner = button.getScene().getWindow(); 
        
        if (name.getText().isEmpty()) {
            showAlert(Alert.AlertType.ERROR, owner, "Form Error!",
                "Please Enter Your Name");
            return;
        }
        
        
        if (password.getText().isEmpty()) {
            showAlert(Alert.AlertType.ERROR, owner, "Form Error!",
                "Please Enter Your Password In This Field");
            return;
        }
        if (phone.getText().isEmpty()) {
            showAlert(Alert.AlertType.ERROR, owner, "Form Error!",
                "Please Enter Your Phone Number");
            return;
        }
        if (email.getText().isEmpty()) {
            showAlert(Alert.AlertType.ERROR, owner, "Form Error!",
                "Please Enter Your E-mail");
            return;
        }
        if (address.getText().isEmpty()) {
            showAlert(Alert.AlertType.ERROR, owner, "Form Error!",
                "Please Enter Your Address");
            return;
        }
        if (password2.getText().isEmpty()) {
            showAlert(Alert.AlertType.ERROR, owner, "Form Error!",
                "Please Confirm Your Password In This Field");
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
        String query = "Select * from save where email= ?";
      PreparedStatement pst = conn.prepareStatement(query);
      pst.setString(1, email.getText());
     
      ResultSet rs = pst.executeQuery(); 
      if(rs.next()){
          showAlert(Alert.AlertType.ERROR, owner, "Form Error!",
                "This email is already used");
           return;
      }
        
        
        
        
      
        
        
        
       
       
        
        Connection con=null;
        Class.forName("com.mysql.jdbc.Driver");
        con=DriverManager.getConnection(DB_URL,USER,PASS);
        
        
        String INSERT_QUERY = "INSERT INTO save (name, email, phone, address, password) VALUES (?, ?, ?, ?, ?)";
         
       
         PreparedStatement pz = con.prepareStatement(INSERT_QUERY);
            pz.setString(1, name.getText());
            pz.setString(2, email.getText());
            pz.setString(3, phone.getText());
            pz.setString(4, address.getText());
            
            pz.setString(5, password.getText());
       
pz.executeUpdate();
pz.close(); 
con.close();

showAlert(Alert.AlertType.CONFIRMATION, owner, "Done",
                "Your Account Is Created, Welcome To Our Community !!");



        String f="ehealthandmedicare@gmail.com";
        String to= email.getText();
        String host="localhost";
        String subject="Welcome "+name.getText();
        String massage="Congratulations!! Your Account Is Created. Welcome To Our E-Health & Medicare Service.\n\n"+name.getText()+"\n"+email.getText()+"\n"+phone.getText()+"\n"+address.getText();
        boolean so=false;
        Properties p= new Properties();
        p.put("mail.smtp.auth","true");
        p.put("mail.smtp.starttls.enable","true");
        p.put("mail.smtp.host","smtp.gmail.com");
        p.put("mail.smtp.port","587");

        Session sak= Session.getDefaultInstance(p,new javax.mail.Authenticator(){

            protected PasswordAuthentication getPasswordAuthentication(){
                return new PasswordAuthentication("ehealthandmedicare@gmail.com","annetashehealth");


            }

        });
        try{
            MimeMessage m= new MimeMessage(sak);
            m.setFrom(new InternetAddress(f));
            m.addRecipient(Message.RecipientType.TO,new InternetAddress(to));
            m.setSubject(subject);
            m.setText(massage);
            Transport.send(m);

          

        }catch(Exception e){
            e.printStackTrace();

        }
        name.setText("");
email.setText("");
address.setText("");
password.setText("");
password2.setText("");
phone.setText("");
          

}



    public void SigninC(ActionEvent event) throws IOException, ClassNotFoundException, SQLException {
        
         Window owner = button1.getScene().getWindow();
       
      if (Logemail.getText().isEmpty()) {
            showAlert(Alert.AlertType.ERROR, owner, "Form Error!",
                "Please enter your email id");
            return;
        }
      if (password3.getText().isEmpty()) {
            showAlert(Alert.AlertType.ERROR, owner, "Form Error!",
                "Please enter a password");
            return;
        }
        
        
        
        
        
        
        
       Connection conn = null;
  
    Class.forName("com.mysql.jdbc.Driver");
    
      conn = DriverManager.getConnection(DB_URL,USER,PASS);
      String query = "Select * from save where email=? and password=?";
      PreparedStatement pst = conn.prepareStatement(query);
      pst.setString(1, Logemail.getText());
      pst.setString(2, password3.getText());
      ResultSet rs = pst.executeQuery(); 
      if(rs.next()){
          
          s1=rs.getString(1);
          s2=rs.getString(2);
          s3=rs.getString(3);
          s4=rs.getString(4);
          
        Parent parent = FXMLLoader.load(getClass().getResource( "sample4customerview.fxml"));
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        Scene scene = new Scene(parent);
        window.setScene(scene);
        window.setTitle("E-Health & Medicare");
        //window.setScene(new Scene(parent, 800, 650));
        window.show();
          
          
      }
      else{
           showAlert(Alert.AlertType.ERROR, owner, "Form Error!",
                "Please Enter Email & Password Correctly");
      }
      
        
        
        
        
        
        
        
        
        
        

        
    }
    
    public void Forget(ActionEvent event) throws IOException, ClassNotFoundException, SQLException{
        
          
        Parent parent = FXMLLoader.load(getClass().getResource( "sample21FPemail.fxml"));
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
}



