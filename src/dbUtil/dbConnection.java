package dbUtil;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.SQLException;

// MYSQL connection
public class dbConnection {

    private static final String USERNAME = privateDatabaseConnection.USERNAME; // username
    private static final String PASSWORD = privateDatabaseConnection.PASSWORD; // password
    private static final String CONN = privateDatabaseConnection.CONNECTION; // database to connect to


    public static Connection getConnection() throws SQLException {

        try{

            Class.forName( /*"org.sqlite.JDBC"*/ "com.mysql.cj.jdbc.Driver"); // setup the connection
            return DriverManager.getConnection( CONN, USERNAME, PASSWORD); // connection string, username, password

        }catch (ClassNotFoundException | SQLException e){

            e.printStackTrace();
        }

        return null;
    }
}
