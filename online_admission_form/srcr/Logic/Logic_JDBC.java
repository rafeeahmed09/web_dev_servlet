package Logic_servlet_JDBC;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

public class Logic_JDBC {
    static final String URL = "jdbc:mysql://localhost:3306/medicalStoreDB";
    static final String USER = "root";
    static final String PASSWORD = "1234567890";

    public static void createTable(){
        try(Connection con = DriverManager.getConnection(URL, USER, PASSWORD);
          Statement stmt = con.createStatement()){
            String sql = "CREATE TABLE IF NOT EXISTS Customers ("
                    + "id INT PRIMARY KEY AUTO_INCREMENT, "
                    + "email VARCHAR(100) NOT NULL, "
                    + "password VARCHAR(15) UNIQUE"
                    + ");";

            stmt.executeUpdate(sql);
            System.out.println("Table Created successFully");
        }catch (SQLException e){
            e.getMessage();
        }
    }
    public static void insertCustomer(Admission ad) throws SQLException {
        try (Connection con = DriverManager.getConnection(URL, USER, PASSWORD)) {
            try (PreparedStatement pstmt = con.prepareStatement("INSERT INTO Customers(id,email,password)VALUES (?,?,?)")) {
                pstmt.setInt(1,ad.getId());
                pstmt.setString(2,ad.getEmail());
                pstmt.setString(3,ad.getPassword());

            }
        }
    }


}
