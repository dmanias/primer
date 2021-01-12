package gr.primer.PrimerCRUD.dataLayer;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class SQLImplTest {


    @Test
    void userDatabaseIsEmptySQL() {
      //  SQLImpl tester = new SQLImpl();
    //    assertFalse(tester.userTableIsEmptySQL());
    }

    @Test
    void departmentDatabaseIsEmptySQL() {
    //    SQLImpl tester = new SQLImpl();
    //    assertFalse(tester.departmentTableIsEmptySQL());
    }

    @Test
    void selectUserDepartmentsSQL() {
        SQLImpl tester = new SQLImpl();
        ArrayList<Department> departmentsList= new ArrayList<>();
        assertEquals(null, tester.selectUserDepartmentsSQL(2));
       // for (Department department:departmentsList) {
       //     System.out.println(department.getDepartmentId());
        //}
    }

}