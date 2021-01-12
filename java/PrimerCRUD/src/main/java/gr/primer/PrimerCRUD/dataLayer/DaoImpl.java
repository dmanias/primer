package gr.primer.PrimerCRUD.dataLayer;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;


// It implements the DAO class
//It is called from from the ViewLogic.java and it calls the SQLImpl.java that does the SQL queries
public class DaoImpl implements Dao {

    public DaoImpl(){  }

    //DAO USER LOGIC
    //It asks SQLimpl to save the user in the Db
    @Override
    public boolean saveUser(String firstName, String lastName, String email, String password, int departmentId) {

        SQLImpl sqlQuestion=new SQLImpl();

        boolean inserted = sqlQuestion.insertUserSQL(firstName, lastName, email, password, departmentId, this.createDate());
        return inserted;
    }

    //Is brings the selected user to the view by asking SQLimpl to Select from the user table
    @Override
    public User getUser(String userEmail) {
        boolean isEmpty=true;
        User user = null;

        SQLImpl sqlQuestion=new SQLImpl();

        //It check if there are any users by asking the SQLImpl to check if the user table is emptyn
        isEmpty = sqlQuestion.userTableIsEmptySQL();

        if (isEmpty){
            user = null;
        }else {
            //If there are users then bring a user to ViewLogic
            user = sqlQuestion.selectUserSQL(userEmail);
        }
        return user;
    }
    //It asks SQLImpl to gring all users and it gives a list of them to ViewLogic
    @Override
    public ArrayList<User> getAllUsers() {
        ArrayList<User> usersList;
        boolean isEmpty=true;
        SQLImpl sqlQuestion=new SQLImpl();

        //Checks if there are any users
        isEmpty = sqlQuestion.userTableIsEmptySQL();

        if (isEmpty){
            usersList=null;
        }else {
            //if there are users it returns an array list of users
            usersList = sqlQuestion.selectAllUsersSQL();
        }
        return usersList;
    }
    /*
        @Override
        public void update(User user, String[] params) {
            user.setName(Objects.requireNonNull(
              params[0], "Name cannot be null"));
            user.setEmail(Objects.requireNonNull(
              params[1], "Email cannot be null"));

            users.add(user);
        }
    */
    //It asks SQLImpl to delete user from the users table and if it is done it returns true to ViewLogic
    @Override
    public boolean deleteUser(String userEmail) {
        SQLImpl sqlQuestion=new SQLImpl();
        boolean deleted = sqlQuestion.deleteUserSQL(userEmail);
        return deleted;
    }

    //It asks SQLImpl to bring all departments that a user belongs to and it gives a list of them to ViewLogic
    @Override
    public ArrayList<Department> getUserDepartments(int userId) {
        ArrayList<Department> departmentsList;
        SQLImpl sqlQuestion=new SQLImpl();
        departmentsList = sqlQuestion.selectUserDepartmentsSQL(userId);
        return departmentsList;
    }


    //DAO DEPARTMENTS LOGIC
    //Is asks SQLImpl to save the department into the departments table and returns true if it is added succesfully
    @Override
    public boolean saveDepartment(String departmentName, int userId) {
        SQLImpl sqlQuestion=new SQLImpl();
        boolean inserted = sqlQuestion.insertDepartmentSQL(departmentName, userId, this.createDate());
        return inserted;
    }

    //Is brings the selected user to the view by asking SQLimpl to Select from the user table
    @Override
    public Department getDepartment(int departmentId) {
        boolean isEmpty=true;
        Department department = null;
        SQLImpl sqlQuestion=new SQLImpl();
        //It check if there are any users by asking the SQLImpl to check if the user table is empty
        isEmpty = sqlQuestion.departmentTableIsEmptySQL();

        if (isEmpty){
            department = null;
        }else {
            //If there are users then bring a user to ViewLogic
            department = sqlQuestion.selectDepartmentSQL(departmentId);
        }
        return department;
    }

    //It asks SQLImpl to gring all users and it gives a list of them to ViewLogic
    @Override
    public ArrayList<Department> getAllDepartments() {
        ArrayList<Department> departmentsList;
        boolean isEmpty=true;
        SQLImpl sqlQuestion=new SQLImpl();

        //Checks if there are any users
        isEmpty = sqlQuestion.departmentTableIsEmptySQL();

        if (isEmpty){
            departmentsList=null;
        }else {
            //if there are users it returns an array list of users
            departmentsList = sqlQuestion.selectAllDepartmentsSQL();
        }
        return departmentsList;
    }
    //It asks SQLImpl to delete department from the departments table and if it is done it returns true to ViewLogic
    @Override
    public boolean deleteDepartment(int departmentId) {
        SQLImpl sqlQuestion = new SQLImpl();
        boolean deleted = sqlQuestion.deleteDepartmentSQL(departmentId);
        return deleted;
    }
    //It asks SQLImpl to bring all users for a specific department and it gives a list of them to ViewLogic
    @Override
    public ArrayList<User> getDepartmentUsers(int departmentId) {
        ArrayList<User> usersList;
        SQLImpl sqlQuestion=new SQLImpl();
        usersList = sqlQuestion.selectDepartmentUsersSQL(departmentId);
        return usersList;
    }

    //Create date and cast it to string
    private String createDate() {
        Date date = Calendar.getInstance().getTime();
        DateFormat dateFormat = new SimpleDateFormat("yyyy-mm-dd hh:mm:ss");
        return dateFormat.format(date);
    }
}
