package dataLayer;

import java.util.ArrayList;

public class UserDao implements Dao
{

    //list is working as a database
    private ArrayList<User> usersList = new ArrayList<User>();

    public UserDao(){ }


    @Override
    public User get(String emailInput) {
        User user = null;
        SQLImpl sqlQuestion=new SQLImpl();

        user = sqlQuestion.selectSQL(emailInput);

        return user;
    }

    @Override
    public ArrayList<User> getAll() {

        SQLImpl sqlQuestion=new SQLImpl();

        ArrayList<User> usersList =  sqlQuestion.selectAllSQL();

        return usersList;
    }

    @Override
    public boolean save(User user) {
        SQLImpl sqlQuestion=new SQLImpl();

        boolean inserted = sqlQuestion.insertSQL(user);
        return inserted;
    }

/*
    @Override
    public void update(User user, String[] params) {
        user.setName(Objects.requireNonNull(
          params[0], "Name cannot be null"));
        user.setEmail(Objects.requireNonNull(
          params[1], "Email cannot be null"));
        
        users.add(user);
    }
*/
    @Override
    public boolean delete(String emailInput) {
        SQLImpl sqlQuestion=new SQLImpl();
        boolean deleted = sqlQuestion.deleteSQL(emailInput);
        return deleted;

    }


}
