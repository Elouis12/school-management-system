package loginapp;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import dbUtil.dbConnection;

public class LoginModel {

    Connection connection;

    public LoginModel() throws SQLException {

        try{

            this.connection = dbConnection.getConnection();

        }catch (SQLException e){

            e.printStackTrace();
        }

        if( this.connection == null ){ // not connected

            System.exit( 1 );
        }

    }

    public boolean isDatabaseConnected(){

        return this.connection != null;
    }

    public boolean isLoggedIn(String user, String password, String option) throws Exception {

        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;

        String sql = "SELECT * FROM login WHERE username = ? AND password = ? AND division = ?;" ;

        /*  QUESTION MARKS ARE PLACEHOLDERS?

            WE GIVE THEM NUMBERS 1,2,3 OR 0,1,2 OR 4,5,6
            THAT WAY IT KNOWS WHAT ORDER TO PLACE THEM?

            WE COULD'VE ALSO DONE
            "SELECT * FROM login WHERE username = " + username + " AND password = " + password + " AND division = " + option + ";" ;

        */

        try{

            preparedStatement = this.connection.prepareStatement( sql );
            preparedStatement.setString( 1, user ); //
            preparedStatement.setString( 2, password ); //
            preparedStatement.setString( 3, option ); //

            resultSet = preparedStatement.executeQuery();

            boolean bool;

            if( resultSet.next() ){

                return true;
            }

//            return false;

        }catch (SQLException e){

            e.printStackTrace();

        }finally {

            {
                preparedStatement.close();
                resultSet.close();
            }
        }

        return false;
    }
}
