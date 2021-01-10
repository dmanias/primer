import com.mysql.cj.xdevapi.SqlResult;

import java.util.ArrayList;
import java.util.List;

import java.sql.*;

public class UserDao implements Dao
{

    //list is working as a database
    private List<User> usersList = new ArrayList<User>();

    public UserDao(){

    }


    @Override
    public User get(String emailInput) {
        User user = null;
        SQLImpl sqlQuestion=new SQLImpl();

        ResultSet dbResult = sqlQuestion.selectSQL(emailInput);

        try{
            while(dbResult.next()){
                String firstName = dbResult.getString(1);
                String lastName = dbResult.getString(2);
                String username = dbResult.getString(3);
                String password = dbResult.getString(4);
                String email = dbResult.getString(5);

                user = new User(firstName, lastName, username, password, email);
                break; //It gives only the first user
            }
        }catch (SQLException ex) {
            ex.printStackTrace();
        }
        return user;
    }

    @Override
    public List<User> getAll() {

        SQLImpl sqlQuestion=new SQLImpl();

        ResultSet dbResult = sqlQuestion.selectAllSQL();

        try{
            while(dbResult.next()){
                String firstName = dbResult.getString(2);
                String lastName = dbResult.getString(3);
                String username = dbResult.getString(4);
                String password = dbResult.getString(5);
                String email = dbResult.getString(6);
                usersList.add(new User(firstName, lastName, username, password, email));
            }
        }catch (SQLException ex) {
            ex.printStackTrace();
        }
        return usersList;
    }

    @Override
    public boolean save(User user) {
        SQLImpl sqlQuestion=new SQLImpl();

        boolean dbResult = sqlQuestion.insertSQL(user);
        return dbResult;
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
    
    @Override
    public void delete(User user) {
        users.remove(user);
    }
*/

}
