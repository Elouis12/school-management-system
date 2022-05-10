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

        try{

            preparedStatement = this.connection.prepareStatement( sql );
            preparedStatement.setString( 1, user ); //
            preparedStatement.setString( 1, password ); //
            preparedStatement.setString( 1, option ); //

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
