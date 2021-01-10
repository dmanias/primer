import java.sql.ResultSet;
import java.util.ArrayList;

public interface SQL {
    public boolean insertSQL(User user);
    //    public void updateSQL(Object object);
    //    public void deleteSQL(Object object);
    public ResultSet selectSQL(String email);
    public ResultSet selectAllSQL();
}
