package gr.primer.PrimerCRUD.dataLayer;

import java.util.ArrayList;

//Dao Class: The Data Access Object (DAO) pattern is a structural pattern
// that allows us to isolate the application/business layer from the persistence layer (usually a relational database,
// but it could be any other persistence mechanism) using an abstract API.)
public interface Dao {
    boolean saveUser(String firstName, String lastName, String email, String password, int departmentId);
    User getUser(String string);
    ArrayList<User> getAllUsers();
    //  void update(T t, String[] params);
    boolean deleteUser(String string);
    boolean saveDepartment(String departmentName, int userId);
}
