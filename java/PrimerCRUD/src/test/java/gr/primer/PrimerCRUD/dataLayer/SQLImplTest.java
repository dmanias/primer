package gr.primer.PrimerCRUD.dataLayer;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SQLImplTest {

    @Test
    void insertSQL() {
    }

    @Test
    void deleteSQL() {
    }

    @Test
    void userDatabaseIsEmptySQL() {
        SQLImpl tester = new SQLImpl();
        assertFalse(tester.userTableIsEmptySQL());
    }

    @Test
    void departmentDatabaseIsEmptySQL() {
        SQLImpl tester = new SQLImpl();
        assertFalse(tester.departmentTableIsEmptySQL());
    }

    @Test
    void selectSQL() {

    }

    @Test
    void selectAllSQL() {
    }
}