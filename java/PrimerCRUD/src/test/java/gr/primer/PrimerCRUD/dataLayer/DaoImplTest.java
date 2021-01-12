package gr.primer.PrimerCRUD.dataLayer;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DaoImplTest {

    @Test
    void saveUser() {
    }

    @Test
    void getUser() {
    }

    @Test
    void getAllUsers() {
    }

    @Test
    void deleteUser() {
    }

    @Test
    void saveDepartment() {
    }

    @Test
    void getDepartment() {
        DaoImpl tester = new DaoImpl();
        Department department = null;
        assertEquals(department, tester.getDepartment(1));

        System.out.println(tester.getDepartment(1));
    }
}