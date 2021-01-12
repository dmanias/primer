package gr.primer.PrimerCRUD.viewLayer;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class FormValidation {

    String firstName;
    String lastName;
    String username;
    String password;
    String email;


    public FormValidation(String firstName, String lastName, String username, String password, String email) {
       this.firstName = firstName;
       this.lastName = lastName;
       this.username = username;
       this.password = password;
       this.email = email;
    }

    public boolean validation(HttpServletResponse response) throws ServletException, IOException {
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
