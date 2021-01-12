package gr.primer.PrimerCRUD.dataLayer;

import java.util.ArrayList;

public interface Dao {
	User getUser(String string);
    ArrayList<User> getAllUsers();
    boolean saveUser(User user);
    //  void update(T t, String[] params);
    boolean deleteUser(String string);
    public boolean saveOrder(Order order);
}
