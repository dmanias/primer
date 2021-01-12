package gr.primer.PrimerCRUD.dataLayer;

import java.util.ArrayList;

public class DaoImpl implements Dao {

    public DaoImpl(){  }


    @Override
    public User getUser(String emailInput) {
        boolean isEmpty=true;
        User user = null;
        SQLImpl sqlQuestion=new SQLImpl();

        isEmpty = sqlQuestion.userTableIsEmptySQL();

        if (isEmpty){
            user = null;
        }else {
            user = sqlQuestion.selectUserSQL(emailInput);
        }
        return user;
    }

    @Override
    public ArrayList<User> getAllUsers() {
        ArrayList<User> usersList;
        boolean isEmpty=true;
        SQLImpl sqlQuestion=new SQLImpl();


        isEmpty = sqlQuestion.userTableIsEmptySQL();

        if (isEmpty){
            usersList=null;
        }else {
            usersList = sqlQuestion.selectAllUsersSQL();
        }
        return usersList;
    }
    @Override
    public boolean saveUser(User user) {
        SQLImpl sqlQuestion=new SQLImpl();

        boolean inserted = sqlQuestion.insertUserSQL(user);
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
    public boolean deleteUser(String emailInput) {
        SQLImpl sqlQuestion=new SQLImpl();
        boolean deleted = sqlQuestion.deleteUserSQL(emailInput);
        return deleted;

    }
    @Override
    public boolean saveOrder(Order order) {
        SQLImpl sqlQuestion=new SQLImpl();

        boolean inserted = sqlQuestion.insertOrderSQL(order);
        return inserted;
    }


}
