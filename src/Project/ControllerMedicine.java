package Project;

import static Project.ControllerMedicineUpdate.DB_URL;
import static Project.ControllerMedicineUpdate.PASS;
import static Project.ControllerMedicineUpdate.USER;
import com.mysql.jdbc.PreparedStatement;
import javafx.beans.Observable;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import javafx.fxml.FXML;

import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.io.*;
import java.sql.Connection;
import java.sql.*;
import java.sql.DriverManager;
import java.sql.SQLException;
import static java.util.Collections.list;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.scene.control.Alert;
import javafx.stage.Window;

public class ControllerMedicine implements Initializable {


    @FXML
        private TableView<medicinelist> Cmedtable;


        @FXML
        private TableColumn<medicinelist , String> com=new TableColumn<>("Company") ;

        @FXML
        private TableColumn<medicinelist , String> gname=new TableColumn<>("Gen_name");

        @FXML
        private TableColumn<medicinelist , String> mg=new TableColumn<>("Mg");


        @FXML
        private TableColumn<medicinelist , String> name=new TableColumn<>("Name");

        @FXML
        private TableColumn<medicinelist , String> pr=new TableColumn<>("Price");

    @FXML
    private Button button;

    @FXML
    private TextField search;


 static final String DB_URL = "jdbc:mysql://localhost:3306/E-Health & Medicare";
   static final String USER = "root";
   static final String PASS = "";



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
         String query = "Select * from admed where name=?";
      java.sql.PreparedStatement pst = conn.prepareStatement(query);
       pst.setString(1, search.getText());
     
      ResultSet rs = pst.executeQuery(); 
      if(rs.next()){
          String s1=rs.getString(1);
          String s2=rs.getString(3);
          String s3=rs.getString(6);
          
          showAlert(Alert.AlertType.INFORMATION, owner, "Found","Name:"+s1+", Mg:"+s2+", Price:"+s3+
                "");
          
      }
      else{
          showAlert(Alert.AlertType.ERROR, owner, "Form Error!",
                "Not found");
      }
        

    }
   public  ObservableList<medicinelist>getmedicine() throws ClassNotFoundException, SQLException{
        ObservableList<medicinelist> list =FXCollections.observableArrayList();
        
        Connection con=null;
         Class.forName("com.mysql.jdbc.Driver");
         con= DriverManager.getConnection(DB_URL,USER,PASS);
         String qu = "Select * from admed";
          PreparedStatement oa=(PreparedStatement) con.prepareStatement(qu);
          ResultSet rs =oa.executeQuery();
          while(rs.next()){
              list.add(new medicinelist(rs.getString("name"),rs.getString("gen_name"), rs.getString("mg"),rs.getString("company"),rs.getString("price")) );
          }
         
        con.close();
     return list;

    }
   
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {


        name.setCellValueFactory(new PropertyValueFactory<medicinelist,String>("name"));
        gname.setCellValueFactory(new PropertyValueFactory<medicinelist,String>("gen_name"));
        mg.setCellValueFactory(new PropertyValueFactory<medicinelist,String>("mg"));
        //amt.setCellValueFactory(new PropertyValueFactory<medicinelist,String>("amount"));

        com.setCellValueFactory(new PropertyValueFactory<medicinelist,String>("company"));
        pr.setCellValueFactory(new PropertyValueFactory<medicinelist,String>("price"));

        try {
            Cmedtable.setItems(getmedicine());
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ControllerMedicine.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(ControllerMedicine.class.getName()).log(Level.SEVERE, null, ex);
        }
        Cmedtable.getColumns().addAll(  name, gname,mg,com, pr);






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






