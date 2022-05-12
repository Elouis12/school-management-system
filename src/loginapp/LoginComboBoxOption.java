package loginapp;

public enum LoginComboBoxOption { // to populate in combo box (dropdown list)

    Admin, Student;

    private LoginComboBoxOption(){}

    public String value(){

        return name();
    }

    public static LoginComboBoxOption fromValue(String value){

        return valueOf(value);
    }
}
