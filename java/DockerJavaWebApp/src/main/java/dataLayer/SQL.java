package dataLayer;

import java.sql.ResultSet;
import java.util.ArrayList;

public interface SQL {
    public boolean insertSQL(User user);
    //    public void updateSQL(Object object);
    public boolean deleteSQL(String email);
    public User selectSQL(String email);
    public ArrayList<User> selectAllSQL();
}
