package gr.primer.PrimerCRUD.dataLayer;

import java.util.ArrayList;


//SQL interface shows the methods that implement the sql queries. These are protected by the prepareStatement interface
public interface SQL {
    //SQL QUERIES FOR USERS TABLE
    boolean insertUserSQL(String firstName, String lastName, String email, String password, int departmentId, String userCreationDate);
    //    public void updateSQL(Object object);
    boolean deleteUserSQL(String email);
    User selectUserSQL(String email);
    ArrayList<User> selectAllUsersSQL();
    boolean userTableIsEmptySQL();
    ArrayList<Department> selectUserDepartmentsSQL(int userId);
    //SQL QUERIES FOR DEPARTMENTS TABLE
    boolean insertDepartmentSQL(String departmentName, int userId, String departmentCreationDate);
    boolean departmentTableIsEmptySQL();
    Department selectDepartmentSQL(int departmentId);
    ArrayList<Department> selectAllDepartmentsSQL();
    boolean deleteDepartmentSQL(int departmentId);
    ArrayList<User> selectDepartmentUsersSQL(int departmentId);
}
