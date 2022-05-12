package admin;

/*public enum StudentSearchComboBoxOption { // to populate in combo box (dropdown list)

    Id, FirstName, LastName, Email, DateOfBirth;

    private StudentSearchComboBoxOption(){}

    public String value(){

        return name();
    }

    public static StudentSearchComboBoxOption fromValue(String value){

        return valueOf(value);
    }
}*/


import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class StudentSearchComboBoxOption{

    private static final ObservableList<String> observableList = FXCollections.observableArrayList("Id", "First Name", "Last Name", "Email", "Date of Birth");

    public static ObservableList<String> getSearchByObservableList() {

        return observableList;
    }
}
