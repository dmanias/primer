//The configuration of the application. Here we store the parameters.
package configuration;

public final class Configuration {

    //Database connection (with time correction)
    public static final String dbURL = "jdbc:mysql://192.168.2.2:3306/database?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
    public final static String dbUsername = "root";
    public final static String dbPassword = "";

}
