package loginapp;

import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

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

    public LoginController() throws SQLException {
    }


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        if( this.loginModel.isDatabaseConnected() ){

            this.dbStatus.setText( "Connected" );

        }else{

            this.dbStatus.setText( "NOT connected" );
        }

        this.comboBox.setItems( FXCollections.observableArrayList( option.values() ) );
    }
}
