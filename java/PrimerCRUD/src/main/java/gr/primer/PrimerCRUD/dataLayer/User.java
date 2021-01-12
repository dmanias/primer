package gr.primer.PrimerCRUD.dataLayer;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

//User class: it deploys User data model
public class User {
    //UserId is a random number assigned to each employ and increases for every employ
    private String userID;
    private String firstName;
    private String lastName;
    private String email;
    private String password;
    private int[] departmentID;
    private String userCreationDate;

    public User(String firstName, String lastName, String email, String password, int[] departmentID) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.password = password;
        this.departmentID = departmentID;
        //Create date and cast it to string
        Date date = Calendar.getInstance().getTime();
        DateFormat dateFormat = new SimpleDateFormat("yyyy-mm-dd hh:mm:ss");
        this.userCreationDate = dateFormat.format(date);
    }

    public String getUserID() {
        return userID;
    }

    public void setUserID(String userID) {
        this.userID = userID;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int[] getDepartmentID() {
        return departmentID;
    }

    public void setDepartmentID(int[] departmentID) {
        this.departmentID = departmentID;
    }

    public String getUserCreationDate() {
        return userCreationDate;
    }

    public void setUserCreationDate(String userCreationDate) {
        this.userCreationDate = userCreationDate;
    }
}
