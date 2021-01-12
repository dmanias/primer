package gr.primer.PrimerCRUD.dataLayer;

import java.util.ArrayList;

public interface SQL {
    public boolean insertUserSQL(String firstName, String lastName, String email, String password, int departmentId, String userCreationDate);
    //    public void updateSQL(Object object);
    public boolean deleteUserSQL(String email);
    public User selectUserSQL(String email);
    public ArrayList<User> selectAllUsersSQL();
    public boolean userTableIsEmptySQL();

    public boolean insertDepartmentSQL(String departmentName, int userId, String departmentCreationDate);
}
