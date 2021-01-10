package com.primer;
import java.sql.*;
import java.sql.Connection;



public class Main {

    public static void main(String[] args) {
// Customer class: Create Customer, connest to database and do....

        //Database connection
        String dbURL=     "jdbc:mysql://localhost:3306/database?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";

        //     String dbURL = "jdbc:mysql://localhost:3306/database";
        String username = "root";
        String password = "";


        //Try with resources (https://www.codejava.net/java-core/the-java-language/using-try-with-resources-examples-java-7)
        try (Connection conn = DriverManager.getConnection(dbURL, username, password)) {

            // code to execute SQL queries goes here...
            if (conn != null) {
                System.out.println("Connected");
            }

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
}

