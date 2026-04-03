package Logic_servlet_JDBC;


import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.sql.SQLException;




@WebServlet("/logic")
public class Logic_Servlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String email = request.getParameter("email");
        String password = request.getParameter("password");

        if (email == null || email.isBlank() || password == null || password.isBlank()) {
            redirectWithMessage(response, request.getContextPath() + "/Logic.html",
                    "error", "Email and password are required.");
            return;
        }


        try {

            Logic_JDBC.createTable();

            String normalizedEmail = email.trim();
            String normalizedPassword = password.trim();

            boolean validUser = Logic_JDBC.isValidCustomer(normalizedEmail, normalizedPassword);

            if (validUser) {
                redirectWithMessage(response, request.getContextPath() + "/index.html",
                        "message", "Login successful.");
            } else {
                if (!Logic_JDBC.emailExists(normalizedEmail)) {
                    Admission admission = new Admission(0, normalizedEmail, normalizedPassword);
                    Logic_JDBC.insertCustomer(admission);
                    redirectWithMessage(response, request.getContextPath() + "/Logic.html",
                            "message", "Login details saved. Please log in again.");
                } else {
                    redirectWithMessage(response, request.getContextPath() + "/Logic.html",
                            "error", "Invalid email or password.");
                }
            }
        } catch (SQLException e) {
            throw new ServletException("Unable to process login.", e);
        }

    }

    private void redirectWithMessage(HttpServletResponse response, String path, String key, String value)
            throws IOException {
        String encodedValue = URLEncoder.encode(value, StandardCharsets.UTF_8);
        response.sendRedirect(path + "?" + key + "=" + encodedValue);
    }
}
