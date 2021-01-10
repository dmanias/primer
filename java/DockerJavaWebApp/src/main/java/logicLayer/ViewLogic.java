package logicLayer;

import dataLayer.User;
import dataLayer.UserDao;
import viewLayer.FormValidation;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;


@WebServlet(name = "ViewLogic")
public class ViewLogic extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        boolean formCorrect = false;
        boolean inserted = false;

        String firstName = request.getParameter("firstName");
        String lastName = request.getParameter("lastName");
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String email = request.getParameter("email");
        String action = request.getParameter("action");

        if (action.equals("addUser")) {

            //Calls validation method and if everything is fine formCorrect=true
            formCorrect=new FormValidation(firstName, lastName, username, password, email).validation(response);

            //if validation is true calls User from data layer (User.class) and makes user.insert
            if (formCorrect) {
                User user = new User(firstName, lastName, username, password, email);
                UserDao userDao = new UserDao();
                inserted=userDao.save(user);
            }

            //If user is inserted correctly then print message in the screen
            if (inserted) {
                String htmlRespone = "<html>";
                htmlRespone += "<h2>User  " + firstName + " added to DB</h2>";
                htmlRespone += "</html>";
                try (PrintWriter writer = response.getWriter()) {
                    writer.println(htmlRespone);
                }
            }
        }

        if (action.equals("getAllUsers")) {
            UserDao userDao = new UserDao();
            ArrayList<User> usersList=userDao.getAll();
            request.setAttribute("usersList", usersList);

            RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/index.jsp");
            dispatcher.forward(request, response);

        }
        if (action.equals("getUser")) {

           UserDao userDao = new UserDao();
           User user=userDao.get(email);

          request.setAttribute("firstName", user.getFirstName());
          request.setAttribute("email", user.getEmail());
          RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/index.jsp");
          dispatcher.forward(request, response);
            }

        if (action.equals("deleteUser")) {

            UserDao userDao = new UserDao();
            boolean deleted = userDao.delete(email);

            //If user is deleted correctly then print message in the screen
            if (deleted) {
                String htmlRespone = "<html>";
                htmlRespone += "<h2>User  " + email + " deleted from DB</h2>";
                htmlRespone += "</html>";
                try (PrintWriter writer = response.getWriter()) {
                    writer.println(htmlRespone);
                }
            }
        }

    }

}

