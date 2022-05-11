package admin;

import dbUtil.dbConnection;
import javafx.collections.ObservableArray;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;

import java.net.URL;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class AdminController implements Initializable {

    @FXML
    private TextField id;

    @FXML
    private TextField firstName;

    @FXML
    private TextField lastName;

    @FXML
    private TextField email;

    @FXML
    private DatePicker dateOfBirth;

    @FXML
    private TableView<StudentData> studentTable;

    @FXML
    private TableColumn<StudentData, String> idColumn;

    @FXML
    private TableColumn<StudentData, String> firstNameColumn;

    @FXML
    private TableColumn<StudentData, String> lastNameColumn;

    @FXML
    private TableColumn<StudentData, String> emailColumn;

    @FXML
    private TableColumn<StudentData, String> dateOfBirthColumn;

    private dbConnection databaseConnection;

    private ObservableList<StudentData> data;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {  // allows us to set text and operate of the javafx items?

        this.databaseConnection = new dbConnection(); // allows us to use it, it's called implicitly
    }

    private void loadStudentData(ActionEvent event){

        try {

            Connection connection = dbConnection.getConnection();

        }catch (SQLException e){

            System.err.println("Error " + e);
        }
    }
}
