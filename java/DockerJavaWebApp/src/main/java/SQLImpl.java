
import java.sql.*;

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
        public boolean insertSQL(User user){
            boolean inserted = false;
            conn=dbConn.openDbConnection();

            try {
 /*               sql = "INSERT INTO Users (firstName, lastName, username, password, email) VALUES (?, ?, ?, ?, ?)";

                Statement statement = conn.prepareStatement(sql);
                statement.setString(1, this.firstName);
                statement.setString(2, this.lastName);
                statement.setString(3, this.username);
                statement.setString(4, this.password);
                statement.setString(5, this.email);
*/
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

        @Override
        public void deleteSQL(Object object){

        }

        */

        @Override
        public ResultSet selectSQL(String email){
           conn=dbConn.openDbConnection();
           try{
           sql = "SELECT * FROM Users WHERE email LIKE 'dmanias@eap.gr'";

           statement = conn.prepareStatement(sql);
           //statement.setString(1, email);
           result = statement.executeQuery(sql);
           } catch (SQLException ex) {
               ex.printStackTrace();
           }
           dbConn.closeDbConnection(conn);
           return result;
        }

        //SQL SELECT ALL
        @Override
        public ResultSet selectAllSQL(){
            conn=dbConn.openDbConnection();

            try {
                sql = "SELECT * FROM Users";

                Statement statement = conn.createStatement();
                result = statement.executeQuery(sql);

            } catch (SQLException ex) {
                ex.printStackTrace();
            }
            dbConn.closeDbConnection(conn);
            return result;
        }
}
