package Student_online_Admission_from;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.sql.SQLException;

@WebServlet("/Student_From")
public class Student_servlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String candidateName = firstNonBlank(
                request.getParameter("candidateName"),
                request.getParameter("name"));
        String motherName = firstNonBlank(
                request.getParameter("motherName"),
                request.getParameter("Mother"));
        String subject = firstNonBlank(
                request.getParameter("subject"),
                request.getParameter("Subject"));
        String subjectFeeValue = firstNonBlank(
                request.getParameter("subjectFee"),
                request.getParameter("fee"));
        String registeredEarlier = firstNonBlank(
                request.getParameter("registeredEarlier"),
                request.getParameter("registersEarlier"),
                request.getParameter("registered"));
        String educationalBackground = firstNonBlank(
                request.getParameter("educationalBackground"),
                request.getParameter("eduction"));

        if (isBlank(candidateName)
                || isBlank(motherName)
                || isBlank(subject)
                || isBlank(subjectFeeValue)
                || isBlank(registeredEarlier)
                || isBlank(educationalBackground)) {
            redirectWithMessage(
                    response,
                    request.getContextPath() + "/index.html",
                    "error",
                    "All student fields are required.");
            return;
        }

        double subjectFee;
        try {
            subjectFee = Double.parseDouble(subjectFeeValue.trim());
        } catch (NumberFormatException exception) {
            redirectWithMessage(
                    response,
                    request.getContextPath() + "/index.html",
                    "error",
                    "Subject fee must be a valid number.");
            return;
        }

        Student_OOPSs student = new Student_OOPSs();
        student.setCandidateName(candidateName.trim());
        student.setMotherName(motherName.trim());
        student.setSubject(subject.trim());
        student.setSubjectFee(subjectFee);
        student.setRegisteredEarlier(registeredEarlier.trim());
        student.setEducationalBackground(educationalBackground.trim());

        try  {
            Student_JDBC.createTable();
            Student_JDBC.insertStudent(student);
            redirectWithMessage(
                    response,
                    request.getContextPath() + "/index.html",
                    "message",
                    "Student registered successfully.");
        } catch (SQLException exception) {
            throw new ServletException("Unable to save student admission form.", exception);
        }
    }

    private String firstNonBlank(String... values) {
        for (String value : values) {
            if (!isBlank(value)) {
                return value;
            }
        }
        return null;
    }

    private boolean isBlank(String value) {
        return value == null || value.isBlank();
    }

    private void redirectWithMessage(HttpServletResponse response, String path, String key, String value)
            throws IOException {
        String encodedValue = URLEncoder.encode(value, StandardCharsets.UTF_8);
        response.sendRedirect(path + "?" + key + "=" + encodedValue);
    }
}
