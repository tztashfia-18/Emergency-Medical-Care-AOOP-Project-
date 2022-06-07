package Project;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.*;
import java.util.*;
import javafx.scene.control.Alert;
import javafx.stage.Window;
import javax.mail.*;
import javax.activation.*;
import javax.mail.internet.*;


public class ControllerAmbulanceContact {
    @FXML
    private Button button;
    
    @FXML
    private TextField nameContact;

    @FXML
    private TextField queries;

    public void Previous(ActionEvent event) throws IOException {
        
        
        
        
        
        
        Parent parent = FXMLLoader.load(getClass().getResource("sample1.fxml"));
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        Scene scene = new Scene(parent);
        window.setScene(scene);
        window.setTitle("E-Health & Medicare");
        //window.setScene(new Scene(parent, 800, 650));
        window.show();
    }
    public void send(ActionEvent event) throws IOException {
         Window owner = button.getScene().getWindow();
        
        
         if (nameContact.getText().isEmpty()) {
            showAlert(Alert.AlertType.ERROR, owner, "Form Error!",
                "Please Enter Your Name & Valid Contact Number");
            return;
        }
      if (queries.getText().isEmpty()) {
            showAlert(Alert.AlertType.ERROR, owner, "Form Error!",
                "Please Write Your Queries In This Field");
            return;
        }
       
        String from="ehealthandmedicare@gmail.com";
         String to="ehealthandmedicare@gmail.com";
        String host="localhost";
        
         String subject="Queries From Ambulance Provider";
         String massage="Name And Number is "+nameContact.getText()+"\n "+queries.getText();
         
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
                "Message is sent");
           
             
         }
         catch(Exception e){
             e.printStackTrace();
             
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
