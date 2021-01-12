package gr.primer.PrimerCRUD.dataLayer;

import gr.primer.PrimerCRUD.configuration.Configuration;

import java.sql.*;
import java.util.ArrayList;

public class SQLImpl implements SQL {

    String sql;
    PreparedStatement statement;
    ResultSet result;
    DbConnection dbConn;
    Connection conn;

    public SQLImpl() {
        dbConn = new DbConnection(Configuration.dbURL, Configuration.dbUsername, Configuration.dbPassword);
    }


        @Override
        public boolean insertUserSQL(String firstName, String lastName, String email, String password, int departmentId, String userCreationDate){
            boolean inserted = false;
            conn=dbConn.openDbConnection();

            try {
                sql = "INSERT INTO Users (firstName, lastName, email, password, departmentId, userCreationDate ) VALUES (?, ?, ?, ?, ?, ?)";

                statement = conn.prepareStatement(sql);
                statement.setString(1, firstName);
                statement.setString(2, lastName);
                statement.setString(3, email);
                statement.setString(4, password);
                statement.setInt(5, departmentId);
                statement.setString(6, userCreationDate);


                int rowsInserted = statement.executeUpdate();
                if (rowsInserted > 0) {
                    inserted = true;
                }
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
            dbConn.closeDbConnection(conn);
            return inserted;
        }

        /*
        @Override
        public void updateSQL(Object object){

        }
*/
        @Override
        public boolean userTableIsEmptySQL() {
            boolean isEmpty=true;
            int resultsCounter = 0;
            conn = dbConn.openDbConnection();

            try {
                sql = "SELECT * From Users";
                statement = conn.prepareStatement(sql);
                result = statement.executeQuery();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }

            try {
                while (result.next()){
                    ++resultsCounter;
                }
                if (resultsCounter>0){
                    isEmpty=false;
                }
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
            dbConn.closeDbConnection(conn);
            return isEmpty;
        }

        @Override
        public User selectUserSQL(String userEmail){
           User user = null;
           conn = dbConn.openDbConnection();

           try{
               sql = "SELECT * FROM Users WHERE email=?";

               statement = conn.prepareStatement(sql);
               statement.setString(1, userEmail);
               result = statement.executeQuery();
           } catch (SQLException ex) {
               ex.printStackTrace();
           }

            try{
                while(result.next()){
                    int    userId = (Integer) result.getObject(1);
                    String firstName = result.getString(2);
                    String lastName = result.getString(3);
                    String email = result.getString(4);
                    String password = result.getString(5);
                    int    departmentId = (Integer) result.getObject(6);
                    String userCreationDate = result.getString(7);

                    user = new User(userId, firstName, lastName, email, password, departmentId, userCreationDate);
                    break; //It gives only the first user
                }
            }catch (SQLException ex) {
                ex.printStackTrace();
            }
           dbConn.closeDbConnection(conn);
           return user;
        }

        //SQL SELECT ALL
        @Override
        public ArrayList<User> selectAllUsersSQL(){
            ArrayList<User> usersList= new ArrayList<>();
            conn=dbConn.openDbConnection();

            try {
                sql = "SELECT * FROM Users";

                Statement statement = conn.createStatement();
                result = statement.executeQuery(sql);

            } catch (SQLException ex) {
                ex.printStackTrace();
            }

            try{
                while(result.next()){
                    int    userId = (Integer) result.getObject(1);
                    String firstName = result.getString(2);
                    String lastName = result.getString(3);
                    String email = result.getString(4);
                    String password = result.getString(5);
                    int    departmentId = (Integer) result.getObject(6);
                    String userCreationDate = result.getString(7);

                    usersList.add(new User(userId, firstName, lastName, email, password, departmentId, userCreationDate));
                }
            }catch (SQLException ex) {
                ex.printStackTrace();
            }
            dbConn.closeDbConnection(conn);
            return usersList;
        }

    @Override
    public boolean deleteUserSQL(String emailInput){
        boolean deleted = false;
        conn=dbConn.openDbConnection();
        try{
            sql = "DELETE FROM Users WHERE email=?";

            statement = conn.prepareStatement(sql);
            statement.setString(1, emailInput);
            int rowsDeleted = statement.executeUpdate();
            if (rowsDeleted > 0) {
                deleted = true;
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        dbConn.closeDbConnection(conn);
        return deleted;

    }

    @Override
    public boolean insertDepartmentSQL(String departmentName, int userId, String departmentCreationDate) {
        boolean inserted = false;
        conn=dbConn.openDbConnection();

        try {
            sql = "INSERT INTO Departments (departmentName, userId, departmentCreationDate) VALUES (?, ?, ?)";

            statement = conn.prepareStatement(sql);
            statement.setString(1, departmentName);
            statement.setInt(2, userId);
            statement.setString(3, departmentCreationDate);

            int rowsInserted = statement.executeUpdate();
            if (rowsInserted > 0) {
                inserted = true;
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        dbConn.closeDbConnection(conn);
        return inserted;
    }
}
