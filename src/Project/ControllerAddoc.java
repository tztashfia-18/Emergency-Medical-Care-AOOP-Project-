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

public class ControllerAddoc implements Initializable{
    
     @FXML
    private TableColumn<AdDoctor, String> catagory;

    
     @FXML
    private TableColumn<AdDoctor, String> charges;
    @FXML
    private TableColumn<AdDoctor, String> contact;

    @FXML
    private TableView<AdDoctor> doc_tab;

    @FXML
    private TableColumn<AdDoctor, String> docname;

    @FXML
    private TableColumn<AdDoctor, String> hospital;

    @FXML
    private TableColumn<AdDoctor, String> time;
     public  ObservableList<AdDoctor>getdoc() throws ClassNotFoundException, SQLException{
        ObservableList<AdDoctor> list2 =FXCollections.observableArrayList();
        
        Connection con=null;
         Class.forName("com.mysql.jdbc.Driver");
         con= DriverManager.getConnection(DB_URL,USER,PASS);
         String qu = "Select * from addoc";
          PreparedStatement oa=(PreparedStatement) con.prepareStatement(qu);
          ResultSet rs =oa.executeQuery();
          while(rs.next()){
              list2.add(new AdDoctor(rs.getString("DoctorName"),rs.getString("Contact_No"), rs.getString("Time"),rs.getString("Hospital"),rs.getString("Charges"),rs.getString("Catagory")) );
          }
         
        con.close();
     return list2;

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
        Parent parent = FXMLLoader.load(getClass().getResource("Doctorupdate.fxml"));
        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Scene scene = new Scene(parent);
        window.setScene(scene);
        window.setTitle("E-Health & Medicare");
        //window.setScene(new Scene(parent, 800, 650));
        window.show();
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        docname.setCellValueFactory(new PropertyValueFactory<AdDoctor,String>("doc_name"));
        contact.setCellValueFactory(new PropertyValueFactory<AdDoctor,String>("contact"));
        time.setCellValueFactory(new PropertyValueFactory<AdDoctor,String>("time"));
        //amt.setCellValueFactory(new PropertyValueFactory<medicinelist,String>("amount"));

        hospital.setCellValueFactory(new PropertyValueFactory<AdDoctor,String>("hospital"));
        charges.setCellValueFactory(new PropertyValueFactory<AdDoctor,String>("charges"));
         catagory.setCellValueFactory(new PropertyValueFactory<AdDoctor,String>("catagory"));

        
         try {
             doc_tab.setItems(getdoc());
         } catch (ClassNotFoundException ex) {
             Logger.getLogger(ControllerAddoc.class.getName()).log(Level.SEVERE, null, ex);
         } catch (SQLException ex) {
             Logger.getLogger(ControllerAddoc.class.getName()).log(Level.SEVERE, null, ex);
         }
                 
        doc_tab.getColumns().addAll(docname,contact , time, hospital, charges,catagory);
    }
}
