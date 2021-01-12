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
    void databaseIsEmptySQL() {
        SQLImpl tester = new SQLImpl();
        assertFalse(tester.userTableIsEmptySQL());
    }

    @Test
    void selectSQL() {

    }

    @Test
    void selectAllSQL() {
    }
}