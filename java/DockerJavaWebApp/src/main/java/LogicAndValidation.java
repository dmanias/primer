import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;


@WebServlet(name = "LogicAndValidation")
public class LogicAndValidation extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        boolean formCorrect = false;
        boolean inserted = false;

        String htmlResponse = null;
        String firstName = null;
        String lastName = null;
        String username = null;
        String password = null;
        String email = null;
        String action = null;

        firstName = request.getParameter("firstName");
        lastName = request.getParameter("lastName");
        username = request.getParameter("username");
        password = request.getParameter("password");
        email = request.getParameter("email");
        action = request.getParameter("action");

        /*
        if (action == "addUser") {

            //Calls validation method and if everything is fine formCorrect=true
            formCorrect = this.validation(firstName, lastName, username, password, email, response);

            //if validation is true calls User from data layer (User.class) and makes user.insert
            if (formCorrect) {
                //creates user from User()
                User user = new User(firstName, lastName, username, password, email);
                inserted = user.insert();
            }

            //If user is inserted correctly then print message in the screen
            if (inserted) {
                htmlRespone = "<html>";
                htmlRespone += "<h2>User  " + firstName + " added to DB</h2>";
                htmlRespone += "</html>";
                try (PrintWriter writer = response.getWriter()) {
                    writer.println(htmlRespone);
                }
            }
        }*/
            //if (action == "getUser") {

                UserDao userDao = new UserDao();
                User user=userDao.get(email);
                response.setContentType("text/html");
                response.setCharacterEncoding("UTF-8");
                htmlResponse = "<html>";
                htmlResponse += "user: "+ user.getFirstName();
                htmlResponse += "</html>";
                try (PrintWriter writer = response.getWriter()) {
                    writer.println(htmlResponse);
                }
                //request.setAttribute("getUser", user);
                //request.getRequestDispatcher("/login.jsp").forward(request, response);
            //}
        }

    private boolean validation(String firstName, String lastName, String username, String password, String email, HttpServletResponse response) throws ServletException, IOException {
        boolean formCorrect = true;
        response.setContentType("text/html");
        response.setCharacterEncoding("UTF-8");

        String htmlResponse = "<html>";

        if (firstName == "") {
            htmlResponse += "<h2>Your Firstname is empty</h2>";
            formCorrect = false;
        }

        if (lastName == "") {
            htmlResponse += "<h2>Your Lastname is empty</h2>";
            formCorrect = false;
        }

        if (username == "") {
            htmlResponse += "<h2>Your Username is empty</h2>";
            formCorrect = false;
        }

        if (password == "") {
            htmlResponse += "<h2>Your Password is empty</h2>";
            formCorrect = false;
        }

        if (email == "") {
            htmlResponse += "<h2>Your Email is empty</h2>";
            formCorrect = false;
        }

        htmlResponse += "</html>";

        if (!formCorrect) {
            try (PrintWriter writer = response.getWriter()) {
                writer.println(htmlResponse);
            }
        }
        return formCorrect;
    }

}

