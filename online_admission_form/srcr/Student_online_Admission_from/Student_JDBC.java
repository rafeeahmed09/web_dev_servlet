package Student_online_Admission_from;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

public class Student_JDBC {
    private static final String DRIVER = "com.mysql.cj.jdbc.Driver";
    private static final String ROOT_URL = "jdbc:mysql://localhost:3306/";
    private static final String DATABASE_NAME = "oilne_Admission_from";
    private static final String TABLE_NAME = "Student_From";
    static final String URL = "jdbc:mysql://localhost:3306/" + DATABASE_NAME;
    static final String USER = "root";
    static final String PASSWORD = "1234567890";
    private static final String CREATE_TABLE_SQL =
            "CREATE TABLE IF NOT EXISTS " + TABLE_NAME + " ("
                    + "id INT PRIMARY KEY AUTO_INCREMENT, "
                    + "candidate_name VARCHAR(100) NOT NULL, "
                    + "mother_name VARCHAR(100) NOT NULL, "
                    + "subject_name VARCHAR(50) NOT NULL, "
                    + "subject_fee DOUBLE NOT NULL, "
                    + "registered_earlier VARCHAR(10) NOT NULL, "
                    + "educational_background TEXT NOT NULL"
                    + ")";

    public static void createTable() throws SQLException {
        initializeDatabase();
    }

    public static void insertStudent(Student_OOPSs student) throws SQLException {
        String sql = "INSERT INTO " + TABLE_NAME
                + " (candidate_name, mother_name, subject_name, subject_fee, registered_earlier, educational_background)"
                + " VALUES (?, ?, ?, ?, ?, ?)";

        initializeDatabase();
        try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, student.getCandidateName());
            pstmt.setString(2, student.getMotherName());
            pstmt.setString(3, student.getSubject());
            pstmt.setDouble(4, student.getSubjectFee());
            pstmt.setString(5, student.getRegisteredEarlier());
            pstmt.setString(6, student.getEducationalBackground());
            pstmt.executeUpdate();
        }
    }

    private static void ensureDatabase() throws SQLException {
        loadDriver();
        try (Connection conn = DriverManager.getConnection(ROOT_URL, USER, PASSWORD);
             Statement stmt = conn.createStatement()) {
            stmt.executeUpdate("CREATE DATABASE IF NOT EXISTS " + DATABASE_NAME);
        }
    }

    private static void initializeDatabase() throws SQLException {
        loadDriver();
        ensureDatabase();

        try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
             Statement stmt = conn.createStatement()) {
            stmt.executeUpdate(CREATE_TABLE_SQL);
        }
    }

    private static void loadDriver() throws SQLException {
        try {
            Class.forName(DRIVER);
        } catch (ClassNotFoundException e) {
            throw new SQLException("MySQL JDBC driver is not available in the runtime classpath.", e);
        }
    }
}
