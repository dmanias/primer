package gr.primer.PrimerCRUD.dataLayer;

//Department class: it deploys Department data model
public class Department {
    //orderId is a unique number that assigns to every department at creation and increases with each one
    private int departmentId;
    private String departmentName;
    private String departmentCreationDate;
    private int userId;

    public Department(int departmentId, String departmentName, int userId, String departmentCreationDate) {
        this.departmentId=departmentId;
        this.departmentName = departmentName;
        this.departmentCreationDate = departmentCreationDate;
        this.userId = userId;
    }

    public int getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(int departmentId) {
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

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }
}
