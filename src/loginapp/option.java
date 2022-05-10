package loginapp;

public enum option { // to populate in combo box (dropdown list)

    Admin, Student;

    private option(){}

    public String value(){

        return name();
    }

    public static option fromValue(String value){

        return valueOf(value);
    }
}
