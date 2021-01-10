package dataLayer;

import java.util.ArrayList;

public interface Dao {
	User get(String email);
    ArrayList<User> getAll();
    boolean save(User user);
    //  void update(T t, String[] params);
    boolean delete(String email);
}
