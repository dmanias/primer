package gr.primer.PrimerCRUD.dataLayer;

import java.util.ArrayList;

public interface SQL {
    public boolean insertUserSQL(User user);
    //    public void updateSQL(Object object);
    public boolean deleteUserSQL(String email);
    public User selectUserSQL(String email);
    public ArrayList<User> selectAllUsersSQL();
    public boolean userTableIsEmptySQL();

    public boolean insertOrderSQL(Order order);
}
