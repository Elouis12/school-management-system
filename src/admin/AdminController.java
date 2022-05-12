package admin;

import dbUtil.dbConnection;
import javafx.collections.FXCollections;
import javafx.collections.ObservableArray;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

import javax.xml.transform.Result;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class AdminController implements Initializable {

    @FXML
    private TextField idTextField;

    @FXML
    private TextField firstNameTextField;

    @FXML
    private TextField lastNameTextField;

    @FXML
    private TextField emailTextField;

    @FXML
    private DatePicker dateOfBirthPicker;

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

    private String sql = "SELECT * FROM students";

    @FXML
    private void loadStudentData(ActionEvent event){

        try {

            Connection connection = dbConnection.getConnection();
            this.data = FXCollections.observableArrayList();

            ResultSet resultSet = connection.createStatement().executeQuery(sql); // gets the data

            while( resultSet.next() ){ // has anything .. going through each row

                this.data.add( new StudentData( resultSet.getString(1), // id
                                                resultSet.getString(2), // first name
                                                resultSet.getString(3), // last name
                                                resultSet.getString(4), // email
                                                resultSet.getString(5) // Date of Birth
                                                ) );

            }

            connection.close();
            resultSet.close();

        }catch (SQLException e){

            System.err.println("Error " + e);
        }

        this.idColumn.setCellValueFactory( new PropertyValueFactory<StudentData, String>("ID"));
        this.firstNameColumn.setCellValueFactory( new PropertyValueFactory<StudentData, String>("FIST_NAME"));
        this.lastNameColumn.setCellValueFactory( new PropertyValueFactory<StudentData, String>("LAST_NAME"));
        this.emailColumn.setCellValueFactory( new PropertyValueFactory<StudentData, String>("EMAIL"));
        this.dateOfBirthColumn.setCellValueFactory( new PropertyValueFactory<StudentData, String>("DATE_OF_BIRTH"));

        this.studentTable.setItems(null);
        this.studentTable.setItems(this.data);

    }


    @FXML
    private void addStudent(ActionEvent event){

        String sqlInsert = "INSERT INTO students(id, first_name, last_name, email, date_of_birth) VALUES(?,?,?,?,?)";

        try{

            Connection connection = dbConnection.getConnection();

            PreparedStatement preparedStatement = connection.prepareStatement(sqlInsert);

            preparedStatement.setString(1, this.idTextField.getText() ); // get it from the text field
            preparedStatement.setString(2, this.firstNameTextField.getText() );
            preparedStatement.setString(3, this.lastNameTextField.getText() );
            preparedStatement.setString(4, this.emailTextField.getText() );
            preparedStatement.setString(5, this.dateOfBirthPicker.getEditor().getText()/*toString()*/ );

            preparedStatement.execute();

            connection.close();
            preparedStatement.close();


        }catch (SQLException e){

            System.err.println(e);
        }

    }

    @FXML
    private void clearForm(ActionEvent event){

        this.idTextField.setText(""); // get it from the text field
        this.firstNameTextField.setText("");
        this.lastNameTextField.setText("");
        this.emailTextField.setText("");
        this.dateOfBirthPicker.setValue(null);
    }
}
