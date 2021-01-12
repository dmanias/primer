package gr.primer.PrimerCRUD.logicLayer;

import gr.primer.PrimerCRUD.dataLayer.User;
import gr.primer.PrimerCRUD.dataLayer.Department;
import gr.primer.PrimerCRUD.dataLayer.DaoImpl;
import gr.primer.PrimerCRUD.viewLayer.FormValidation;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;


//Servlet file that makes the logic of the app. It belongs to the middle (logic) layer.
// It takes input from the jsp (form) and it calls the data layer.
@WebServlet(name = "ViewLogic")
public class ViewLogic extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        boolean formCorrect = false;
        boolean inserted = false;

        //Form inputs for User
        String firstName = request.getParameter("firstName");
        String lastName = request.getParameter("lastName");
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        int departmentId=0;
        if(request.getParameter("departmentId")!=null) {
            departmentId = Integer.parseInt(request.getParameter("departmentId"));
        }
        //Form inputs for Department
        String departmentName = request.getParameter("departmentName");
        int userId = 0;
        if(request.getParameter("userId")!=null) {
            userId = Integer.parseInt(request.getParameter("userId"));
        }
        //Form input for action decision
        String action = request.getParameter("action");

        //SECTION FOR USER LOGIC
        if (action.equals("addUser")) {

            //Calls validation method and if everything is fine formCorrect=true
            formCorrect = new FormValidation(firstName, lastName, email, password).validation(response);

            //if validation is true calls User from data layer (User.class) and makes user.insert
            if (formCorrect) {
                DaoImpl userDao = new DaoImpl();
                inserted = userDao.saveUser(firstName, lastName, email, password, departmentId);
            }

            //If user is inserted correctly then print message in the screen
            if (inserted) {
                String htmlRespone = "<html>";
                htmlRespone += "<h2>The User '" + firstName + " " + lastName + "' is added.</h2>";
                htmlRespone += "</html>";
                try (PrintWriter writer = response.getWriter()) {
                    writer.println(htmlRespone);
                }
            } else {
                String htmlRespone = "<html>";
                htmlRespone += "<h2>The User '" + firstName + " " + lastName + "' is not added.</h2>";
                htmlRespone += "</html>";
                try (PrintWriter writer = response.getWriter()) {
                    writer.println(htmlRespone);
                }
            }
        }

        //Get user logic
        if (action.equals("getUser")) {
            DaoImpl userDao = new DaoImpl();

            User user = userDao.getUser(email);

            if (user == null) {
                String htmlRespone = "<html>";
                htmlRespone += "<h2>There are no users!</h2>";
                htmlRespone += "</html>";
                try (PrintWriter writer = response.getWriter()) {
                    writer.println(htmlRespone);
                }
            } else {
                request.setAttribute("user", user);
                RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/index.jsp");
                dispatcher.forward(request, response);
            }
        }

        //Get all users logic
        if (action.equals("getAllUsers")) {
            DaoImpl userDao = new DaoImpl();
            ArrayList<User> usersList = userDao.getAllUsers();

            if (usersList == null) {
                String htmlRespone = "<html>";
                htmlRespone += "<h2>There are no users!</h2>";
                htmlRespone += "</html>";
                try (PrintWriter writer = response.getWriter()) {
                    writer.println(htmlRespone);
                }
            } else {
                request.setAttribute("usersList", usersList);
                RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/index.jsp");
                dispatcher.forward(request, response);
            }

        }
        //Action that asks for user deletion. Since email is unique it uses email
        if (action.equals("deleteUser")) {

            DaoImpl userDao = new DaoImpl();
            boolean deleted = userDao.deleteUser(email);

            //If user is deleted correctly then print message in the screen
            if (deleted) {
                String htmlRespone = "<html>";
                htmlRespone += "<h2>The user is deleted.</h2>";
                htmlRespone += "</html>";
                try (PrintWriter writer = response.getWriter()) {
                    writer.println(htmlRespone);
                }
            }
        }

        //Get user departments logic
        if (action.equals("showUserDepartments")) {
            DaoImpl userDao = new DaoImpl();
            User user = userDao.getUser(email);

            DaoImpl departmentDao = new DaoImpl();
            ArrayList<Department> departmentsList = departmentDao.getUserDepartments(user.getUserId());

            String htmlResponse = "<html>";
            if (departmentsList == null) {
                htmlResponse += "<h2>There are no departments!</h2>";
                htmlResponse += "</html>";
                try (PrintWriter writer = response.getWriter()) {
                    writer.println(htmlResponse);
                }
                } else {
                    htmlResponse += "<h2>User's "+ user.getFirstName()+" "+ user.getLastName()+" departments:</h2>";
                    int i=0;
                    for (Department department:departmentsList) {
                        htmlResponse += "<h3>" + ++i + ". " + department.getDepartmentName() + " </h3><br>";
                    }
                    htmlResponse += "</html>";
                    try (PrintWriter writer = response.getWriter()) {
                        writer.println(htmlResponse);
                    }
                }

            }

        //SECTION FOR DEPARTMENTS LOGIC
        //Add department
        if (action.equals("addDepartment")) {
            DaoImpl departmentDao = new DaoImpl();
            inserted = departmentDao.saveDepartment(departmentName, userId);

            if (inserted) {
                String htmlRespone = "<html>";
                htmlRespone += "<h2>The department '" + departmentName + "' is added.</h2>";
                htmlRespone += "</html>";
                try (PrintWriter writer = response.getWriter()) {
                    writer.println(htmlRespone);
                }
            } else {
                String htmlRespone = "<html>";
                htmlRespone += "<h2>The department '" + departmentName + "' is not added.</h2>";
                htmlRespone += "</html>";
                try (PrintWriter writer = response.getWriter()) {
                    writer.println(htmlRespone);
                }

            }
        }
        //Get department logic
        if (action.equals("getDepartment")) {
            DaoImpl departmentDao = new DaoImpl();

            Department department = departmentDao.getDepartment(departmentId);

            if (department == null) {
                String htmlRespone = "<html>";
                htmlRespone += "<h2>There are no departments!</h2>";
                htmlRespone += "</html>";
                try (PrintWriter writer = response.getWriter()) {
                    writer.println(htmlRespone);
                }
            } else {
                request.setAttribute("department", department);
                RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/index.jsp");
                dispatcher.forward(request, response);
            }
        }
        //Get all departments logic
        if (action.equals("getAllDepartments")) {
            DaoImpl departmentDao = new DaoImpl();
            ArrayList<Department> departmenstList = departmentDao.getAllDepartments();

            if (departmenstList == null) {
                String htmlRespone = "<html>";
                htmlRespone += "<h2>There are no departments!</h2>";
                htmlRespone += "</html>";
                try (PrintWriter writer = response.getWriter()) {
                    writer.println(htmlRespone);
                }
            } else {
                request.setAttribute("departmenstList", departmenstList);
                RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/index.jsp");
                dispatcher.forward(request, response);
            }

        }

        //Action that asks for user deletion. Since email is unique it uses email
        if (action.equals("deleteDepartment")) {

            DaoImpl departmentDao = new DaoImpl();
            boolean deleted = departmentDao.deleteDepartment(departmentId);

            //If user is deleted correctly then print message in the screen
            if (deleted) {
                String htmlRespone = "<html>";
                htmlRespone += "<h2>The department is deleted.</h2>";
                htmlRespone += "</html>";
                try (PrintWriter writer = response.getWriter()) {
                    writer.println(htmlRespone);
                }
            }
        }

        //Get user departments logic
        if (action.equals("showDepartmentUsers")) {

            DaoImpl departmentDao = new DaoImpl();
            Department department = departmentDao.getDepartment(departmentId);

            DaoImpl userDao = new DaoImpl();
            ArrayList<User> usersList = userDao.getDepartmentUsers(department.getDepartmentId());

            String htmlResponse = "<html>";
            if (usersList == null) {
                htmlResponse += "<h2>There are no users!</h2>";
                htmlResponse += "</html>";
                try (PrintWriter writer = response.getWriter()) {
                    writer.println(htmlResponse);
                }
            } else {
                htmlResponse += "<h2>Department's "+ department.getDepartmentName()+" users:</h2>";
                int i=0;
                for (User user:usersList) {
                    htmlResponse += "<h3>" + ++i + ". " + user.getFirstName() + " " + user.getLastName() + " </h3><br>";
                }
                htmlResponse += "</html>";
                try (PrintWriter writer = response.getWriter()) {
                    writer.println(htmlResponse);
                }
            }

        }

    }
}

