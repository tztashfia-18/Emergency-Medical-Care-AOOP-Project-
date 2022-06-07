package Project;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import java.net.URL;
//import javax.mail.Message;
//import javax.mail.PasswordAuthentication;
//import javax.mail.Session;
//import javax.mail.Transport;
//import javax.mail.internet.InternetAddress;
//import javax.mail.internet.MimeMessage;
import java.io.*;
import java.util.*;
import javax.mail.*;
import javax.activation.*;
import javax.mail.internet.*;

import java.io.IOException;
import java.util.Properties;
import java.util.ResourceBundle;
import javafx.scene.control.Alert;
import javafx.scene.control.TextArea;
import javafx.stage.Window;

public class ControllerContactUs extends Controller2Customer  implements Initializable {


    @FXML
    private TextArea Info;

    @FXML
    private TextField Item;

    @FXML
    private TextField Time;

    @FXML
    private Button button;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        Info.setText("Name: "+s1+"\nE-mail: "+s2+"\nPhone: "+s3+"\nAddress: "+s4);
      Info.setEditable(false);
        
    }

    public void confirm(ActionEvent event) throws IOException {
         Window owner = button.getScene().getWindow();

         if (Item.getText().isEmpty()) {
            showAlert(Alert.AlertType.ERROR, owner, "Form Error!",
                "Please Insert About The Service You Need");
            return;
        }
        if (Time.getText().isEmpty()) {
            showAlert(Alert.AlertType.ERROR, owner, "Form Error!",
                "Please Insert The Time Field");
            return;
        }
        
     
        String S1 = Item.getText();
        String S2 = Time.getText();
      
       
        String f="ehealthandmedicare@gmail.com";
        String to= "ehealthandmedicare@gmail.com";
        String host="localhost";
        String subject="Confirmation Mail";
        String massage="Item: " + S1 + "\n\nTime: " + S2 +"\n\nName: "+s1+"\nE-mail: "+s2+"\nPhone: "+s3+"\nAddress: "+s4 ;
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

          showAlert(Alert.AlertType.CONFIRMATION, owner, "Email",
                "Confirm Service!!");

        }catch(Exception e){
            e.printStackTrace();

        }


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
    private static void showAlert(Alert.AlertType alertType, Window owner, String title, String message) {
        Alert alert = new Alert(alertType);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.initOwner(owner);
        alert.show();
}

}
