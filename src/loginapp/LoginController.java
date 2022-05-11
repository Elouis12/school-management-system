package loginapp;

import admin.AdminController;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import students.StudentsController;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;

//
public class LoginController implements Initializable {

    LoginModel loginModel = new LoginModel();

    @FXML
    private Label dbStatus; // to access by ID

    @FXML
    private TextField username; // to access by ID

    @FXML
    private TextField password; // to access by ID

    @FXML
    private ComboBox<option> comboBox; // to access by ID

    @FXML
    private Button loginButton; // to access by ID

    @FXML
    private Label loginStatus; // to access by ID

    public LoginController() throws SQLException {
    }


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) { // allows us to set text and operate of the javafx items?

        if( this.loginModel.isDatabaseConnected() ){

            this.dbStatus.setText( "Connected" );

        }else{

            this.dbStatus.setText( "NOT connected" );
        }

        this.comboBox.setItems( FXCollections.observableArrayList( option.values() ) ); // set the items to the
    }

    @FXML
    public void Login(ActionEvent event){

        try{

            if( this.loginModel.isLoggedIn( this.username.getText(), this.password.getText(), ( (option) this.comboBox.getValue() ).toString() ) ){

                Stage loginStage = (Stage) this.loginButton.getScene().getWindow();
                loginStage.close(); // close the login stage so we can let then display the student stage / scene

                switch (this.comboBox.getValue().toString()) {
                    case "Student" -> studentLogin(); // to display the student screen
                    case "Admin" -> adminLogin(); // to display the admin screen
                }

            }else{

                this.loginStatus.setText( "Invalid Credentials" );

            }

        }catch (Exception e){

            e.printStackTrace();
        }

    }

    public void studentLogin(){ // for student login

        try{

            Stage studentStage = new Stage();
            FXMLLoader loader = new FXMLLoader();
            Pane studentRoot = (Pane) loader.load( getClass().getClassLoader().getResource( "./students/student.fxml" )/*.openStream()*/ );
//            Pane studentRoot = (Pane) loader.load( getClass().getResource( "./students/student.fxml" )/*.openStream()*/ );

            StudentsController studentsController = /*new StudentsController()*/ (StudentsController) loader.getController();  // since the Controller file is attached to the FXML file or since we'll be adding the StudentController to the FXML, we can grab it instead of doing "new StudentController"

            Scene scene = new Scene( studentRoot );
            studentStage.setTitle( "Student Dashboard" );
            studentStage.setScene( scene );
            studentStage.setResizable( false ); // so users cannot reset the size of the window
            studentStage.show();

        }catch (IOException e){

            e.printStackTrace();
        }
    }

    public void adminLogin(){

        try{
            Stage adminStage = new Stage();
            FXMLLoader loader = new FXMLLoader();
            Pane adminRoot = (Pane) loader.load( getClass().getClassLoader().getResource( "./admin/admin.fxml" )/*.openStream()*/ );
//            Parent adminRoot = (Parent) loader.load( getClass().getResource( "./admin/admin.fxml" )/*.openStream()*/ );

            AdminController adminController = /*new AdminController()*/ (AdminController) loader.getController();  // since the Controller file is attached to the FXML file or since we'll be adding the AdminController to the FXML, we can grab it instead of doing "new AdminController"

            Scene scene = new Scene( adminRoot );
            adminStage.setTitle( "Admin Dashboard" );
            adminStage.setScene( scene );
            adminStage.setResizable( false ); // so users cannot reset the size of the window
            adminStage.show();

        }catch (IOException e){

            e.printStackTrace();
        }
    }
}
