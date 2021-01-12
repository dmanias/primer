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
        public boolean insertUserSQL(User user){
            boolean inserted = false;
            conn=dbConn.openDbConnection();

            try {
                sql = "INSERT INTO Users (firstName, lastName, username, password, email) VALUES (?, ?, ?, ?, ?)";

                statement = conn.prepareStatement(sql);
                statement.setString(1, user.getFirstName());
                statement.setString(2, user.getLastName());
                statement.setString(3, user.getUsername());
                statement.setString(4, user.getPassword());
                statement.setString(5, user.getEmail());

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
        public User selectUserSQL(String emailInput){
           User user = null;
           conn = dbConn.openDbConnection();

           try{
               sql = "SELECT * FROM Users WHERE email=?";

               statement = conn.prepareStatement(sql);
               statement.setString(1, emailInput);
               result = statement.executeQuery();
           } catch (SQLException ex) {
               ex.printStackTrace();
           }

            try{
                while(result.next()){
                    String firstName = result.getString(2);
                    String lastName = result.getString(3);
                    String username = result.getString(4);
                    String password = result.getString(5);
                    String email = result.getString(6);

                    user = new User(firstName, lastName, username, password, email);
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
                    String firstName = result.getString(2);
                    String lastName = result.getString(3);
                    String username = result.getString(4);
                    String password = result.getString(5);
                    String email = result.getString(6);

                    usersList.add(new User(firstName, lastName, username, password, email));
                }
            }catch (SQLException ex) {
                ex.printStackTrace();
            }
            dbConn.closeDbConnection(conn);
            return usersList;
        }

    @Override
    public boolean insertOrderSQL(Order order) {
        boolean inserted = false;
        conn=dbConn.openDbConnection();

        try {
            sql = "INSERT INTO Orders (orderId, creationDate, userEmail) VALUES (?, ?, ?)";

            statement = conn.prepareStatement(sql);
            statement.setString(1, order.getOrderId());
            statement.setString(2, order.getCreationDate());
            statement.setString(3, order.getUserEmail());

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
