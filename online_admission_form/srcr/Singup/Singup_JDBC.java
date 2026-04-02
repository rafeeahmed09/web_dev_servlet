package Singnup_Servlet_JDCB;

import java.sql.*;

public class Singup_JDBC {

    static final String URL = "jdbc:mysql://localhost:3306/";
    static final String USER = "root";
    static final String PASSWORD = "1234567890";

    public static void createTable(){
        try(Connection con = DriverManager.getConnection(URL,USER,PASSWORD);
            Statement stmt = con.createStatement()){
            String sql = "CREATE TABLE IF NOT EXISTS Customers ("
                    + "id INT PRIMARY KEY AUTO_INCREMENT, "
                    + "FullName VARCHAR(100) NOT NULL, "
                    + "phone VARCHAR(15) UNIQUE, "
                    + "email VARCHAR(20) NOT NULL UNIQUE, "
                    + "password VARCHAR(20) NOT NULL"
                    + ");";
            stmt.executeUpdate(sql);
            System.out.println("Table created successfully");
        }catch (SQLException e){
            e.getMessage();
        }
    }

    public static void insertCustomer(Singnup Si ){
        try(Connection con = DriverManager.getConnection(URL,USER,PASSWORD);
            PreparedStatement pstmt = con.prepareStatement("insert into SingupCustmera(id,FullName, phone, email,passwors)values (?,?,?,?,?)") ){
            pstmt.setInt(1,Si.getId());
            pstmt.setString(2,Si.getFullName());
            pstmt.setString(3,Si.getPhone());
            pstmt.setString(4,Si.getEmail());
            pstmt.setString(5,Si.getPassword());

        }catch (SQLException e){
            e.getMessage();
        }

    }
}
