package dataLayer;

import gr.primer.PrimerCRUD.dataLayer.DaoImpl;
import gr.primer.PrimerCRUD.dataLayer.Order;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DaoImplTest {


    private int id;

    @Test
    void get() {
        //DaoImpl tester = new DaoImpl();
        //assertEquals(null, tester.getUser("dmanias@eap.gr"));
        //System.out.println(tester.getUser("dmanias@eap.gr"));
    }

    @Test
    void getAll() {
    }

    @Test
    void save() {
        DaoImpl tester = new DaoImpl();
        Order testOrder = new Order("r", "f");
        assertFalse(tester.saveOrder(testOrder));

    }

    @Test
    void delete() {
    }
}