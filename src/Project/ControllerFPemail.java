package Project;


import com.mysql.jdbc.Connection;
import java.io.IOException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import java.sql.*;
import java.sql.DriverManager;
import java.io.IOException;
import java.net.URL;
import java.security.Security;
import java.sql.SQLException;
import java.util.Properties;
import java.util.Random;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.scene.control.Alert;
import javafx.stage.Window;
import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;




public class ControllerFPemail {
    static final String DB_URL = "jdbc:mysql://localhost:3306/E-Health & Medicare";
   static final String USER = "root";
   static final String PASS = "";
   static String to;
     static String azw;
    @FXML
    private Button button;

    @FXML
    private TextField email;
    public static int randomcode; 


    public void Send(ActionEvent event) throws IOException, ClassNotFoundException, SQLException {
       azw=email.getText();
        Window owner = button.getScene().getWindow();
        
        
      Connection coz=null;
      
       Class.forName("com.mysql.jdbc.Driver");
       coz=(Connection) DriverManager.getConnection(DB_URL,USER,PASS);
       String app="Select * from save where email= ?";
        PreparedStatement ps=coz.prepareStatement(app);
        ps.setString(1, email.getText());
         ResultSet rz=ps.executeQuery();
         if(rz.next())
         {
               Parent parent = FXMLLoader.load(getClass().getResource("sample22FPcode.fxml"));
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        Scene scene = new Scene(parent);
        window.setScene(scene);
        window.setTitle("E-Health & Medicare");
        //window.setScene(new Scene(parent, 800, 650));
        window.show();
        
        
        
        
          Random rand=new Random();
         randomcode=rand.nextInt(999999);
        String from="ehealthandmedicare@gmail.com";
         String to=email.getText();
        String host="localhost";
        
         String subject="Reset Code";
         String massage="Your reset code is "+randomcode;
         
         boolean so=false;
         Properties p= new Properties();
         p.put("mail.smtp.auth","true");
         p.put("mail.smtp.starttls.enable","true");
         p.put("mail.smtp.host","smtp.gmail.com");
         p.put("mail.smtp.port","587");
         Session s= Session.getDefaultInstance(p,new javax.mail.Authenticator(){
             
             protected PasswordAuthentication getPasswordAuthentication(){
                 return new PasswordAuthentication("ehealthandmedicare@gmail.com","annetashehealth");
                 
             }
             
         });
         try{
             MimeMessage m= new MimeMessage(s);
             m.setFrom(from);
             m.addRecipient(Message.RecipientType.TO,new InternetAddress(to));
             m.setSubject(subject);
           m.setText(massage);
           Transport.send(m);
             showAlert(Alert.AlertType.CONFIRMATION, owner, "Email",
                "Mail is sent");
           
             
         }
         catch(Exception e){
             e.printStackTrace();
             
         }
        
        
        
        
        
        
        
        
        
        
        
        
         }
         else{
             showAlert(Alert.AlertType.CONFIRMATION, owner, "Email",
                "Mail is not sent enter the correct email");
         }
          
          
          
          
          
            
         
          
         
         
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
    

