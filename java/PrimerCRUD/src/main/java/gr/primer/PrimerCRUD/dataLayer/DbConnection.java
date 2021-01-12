package gr.primer.PrimerCRUD.dataLayer;

import com.mysql.cj.jdbc.Driver;
import java.sql.*;


public class DbConnection {

    private String dbURL;
    private String dbUsername;
    private String dbPassword;

    public DbConnection(String dbURL, String dbUsername, String dbPassword) {

        this.dbURL=dbURL;
        this.dbUsername=dbUsername;
        this.dbPassword=dbPassword;

        try {
            DriverManager.registerDriver(new Driver());
        } catch (
                SQLException ex) {
            ex.printStackTrace();
        }

    }

    public Connection openDbConnection(){
        Connection conn = null;
        try {

            conn = DriverManager.getConnection(this.dbURL, this. dbUsername, this.dbPassword);

            if (conn != null) {
                System.out.println("Connected");
            }

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return conn;
    }

    public void closeDbConnection(Connection conn){
        try {
            conn.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

}


