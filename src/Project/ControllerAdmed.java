package Project;


import static Project.ControllerMedicine.DB_URL;
import static Project.ControllerMedicine.PASS;
import static Project.ControllerMedicine.USER;
import com.mysql.jdbc.PreparedStatement;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;

import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;

import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;


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

public class ControllerAdmed implements Initializable{
    @FXML
    private TableView<NewClass> tab_med;
    @FXML
    private TableColumn<NewClass, String> amt;

    @FXML
    private TableColumn<NewClass, String> cmp;

    @FXML
    private TableColumn<NewClass, String> gname;

    @FXML
    private TableColumn<NewClass, String> mgs;

    @FXML
    private TableColumn<NewClass, String> num;

    @FXML
    private TableColumn<NewClass, String> prc;









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
        Parent parent = FXMLLoader.load(getClass().getResource("adminmedicineupdate.fxml"));
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        Scene scene = new Scene(parent);
        window.setScene(scene);
        window.setTitle("E-Health & Medicare");
        //window.setScene(new Scene(parent, 800, 650));
        window.show();
    }
    public  ObservableList<NewClass>setmed() throws ClassNotFoundException, SQLException{
        ObservableList<NewClass> list1 =FXCollections.observableArrayList();
        Connection con=null;
         Class.forName("com.mysql.jdbc.Driver");
         con= DriverManager.getConnection(DB_URL,USER,PASS);
         String qz = "Select * from admed";
         PreparedStatement oa=(PreparedStatement) con.prepareStatement(qz);
          ResultSet rs =oa.executeQuery();
          while(rs.next()){
              list1.add(new  NewClass(rs.getString("name"),rs.getString("gen_name"), rs.getString("mg"),rs.getString("amount"),rs.getString("company"),rs.getString("price")) );
          }
         
        con.close();
        return list1;

    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {



        num.setCellValueFactory(new PropertyValueFactory<>("name"));
        gname.setCellValueFactory(new PropertyValueFactory<>("gen_name"));
        mgs.setCellValueFactory(new PropertyValueFactory<>("mg"));
        amt.setCellValueFactory(new PropertyValueFactory<>("amount"));
        cmp.setCellValueFactory(new PropertyValueFactory<>("company"));
        prc.setCellValueFactory(new PropertyValueFactory<>("price"));
        try {
            tab_med.setItems(setmed());
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ControllerAdmed.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(ControllerAdmed.class.getName()).log(Level.SEVERE, null, ex);
        }
        tab_med.getColumns().addAll(num,gname,mgs,amt,cmp,prc);


    }
}



