import java.util.List;

public interface Dao {
	User get(String email);
    List<User> getAll();
    boolean save(User user);
    //  void update(T t, String[] params);
    //  void delete(T t);
}
