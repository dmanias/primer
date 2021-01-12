package gr.primer.PrimerCRUD.dataLayer;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

//Department class: it deploys Department data model
public class Department {
    //orderId is a unique number that assigns to every department at creation and increases with each one
    private String departmentId;
    private String departmentName;
    private String departmentCreationDate;
    private int[] userId;

    public Department(String departmentName, int[] userId) {
        this.departmentName = departmentName;
        //Create date and cast it to string
        Date date = Calendar.getInstance().getTime();
        DateFormat dateFormat = new SimpleDateFormat("yyyy-mm-dd hh:mm:ss");
        this.departmentCreationDate = dateFormat.format(date);
        this.userId = userId;
    }

    public String getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(String departmentId) {
        this.departmentId = departmentId;
    }

    public String getDepartmentName() {
        return departmentName;
    }

    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
    }

    public String getDepartmentCreationDate() {
        return departmentCreationDate;
    }

    public void setDepartmentCreationDate(String departmentCreationDate) {
        this.departmentCreationDate = departmentCreationDate;
    }

    public int[] getUserId() {
        return userId;
    }

    public void setUserId(int[] userId) {
        this.userId = userId;
    }
}
