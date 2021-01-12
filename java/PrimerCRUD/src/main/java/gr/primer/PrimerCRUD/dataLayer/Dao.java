package gr.primer.PrimerCRUD.dataLayer;

import java.util.ArrayList;

//Dao Class: The Data Access Object (DAO) pattern is a structural pattern
// that allows us to isolate the application/business layer from the persistence layer (usually a relational database,
// but it could be any other persistence mechanism) using an abstract API.)
public interface Dao {
    //SQL for users table
    boolean saveUser(String firstName, String lastName, String email, String password, int departmentId);
    User getUser(String string);
    ArrayList<User> getAllUsers();
    //  void update(T t, String[] params);
    boolean deleteUser(String string);
    ArrayList<Department> getUserDepartments(int userId);
    //SQL for departments table
    boolean saveDepartment(String departmentName, int userId);
    Department getDepartment(int departmentId);
    ArrayList<Department> getAllDepartments();
    public boolean deleteDepartment(int departmentId);
    ArrayList<User> getDepartmentUsers(int departmentId);
}
