/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Services;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Duc Anh
 */
public class ConnectDB {

    private static Connection c;
    private static Statement s;

    private static String host, port, dbName, dbUser, dbPassword;
//    private String host = "localhost";
//    private String port = "3306";
//    private String dbUser = "root";
//    private String dbName = "coursemanagement";
//    private String dbPassword = "";
//    private String dbPath = "jdbc:mysql://" + host + ":" + port + "/"
//            + dbName + "?useUnicode=yes&characterEncoding=UTF-8";

    public static void connectDB() {
        host = "localhost";
        port = "3306";
        dbUser = "root";
        dbName = "coursemanagement";
        dbPassword = "";
        String dbPath = "jdbc:mysql://" + host + ":" + port + "/"
                + dbName + "?useUnicode=yes&characterEncoding=UTF-8";
        try {
            c = (Connection) DriverManager.getConnection(dbPath, dbUser, dbPassword);
            s = c.createStatement();

            System.out.println("Successfully!");
        } catch (SQLException ex) {
            System.out.print(ex.getMessage());
        }
    }

    public static Connection getConnection() {
        return c;
    }
    //run sql
    public static ResultSet doReadQuery(String sql) {
        ResultSet rs = null;

        try {
            rs = s.executeQuery(sql);
        } catch (SQLException ex) {
            Logger.getLogger(ConnectDB.class.getName())
                    .log(Level.SEVERE, null, ex);
        }
        return rs;
    }

    //test connection
    public static void Test() {
        String url = "jdbc:mysql://localhost:3306/coursemanagement";
        var user = "root";
        var password = "";
        try (Connection conn = DriverManager.getConnection(url, user, password)) {
            System.out.println("Connect Successfully!");
            String sql = "select * from department";
            PreparedStatement pre = conn.prepareStatement(sql);
            ResultSet res = pre.executeQuery();
            while (res.next()) {
                System.out.print(res.getString("DEPARTMENTID") + " - ");
                System.out.print(res.getString("NAME") + " - ");
                System.out.print(res.getDouble("BUDGET") + " - ");
                System.out.print(res.getString("STARTDATE") + " - ");
                System.out.print(res.getString("ADMINISTRATOR") + "\n");
            }
        } catch (SQLException ex) {
            Logger.getLogger(Connection.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

//    public Connection getConnection() {
//        Connection conn = null;
//        try {
//            Class.forName("com.mysql.jdbc.Driver");
//            conn = DriverManager.getConnection(dbPath, dbUser, dbPassword);
//            System.out.println("connect successfully!");
//        } catch (Exception ex) {
//            System.out.println("connect failure!");
//            ex.printStackTrace();
//        }
//        return conn;
//    }

    public static void main(String[] args) {
        ConnectDB.Test();
    }
}
