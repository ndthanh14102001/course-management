/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;
import Helper.ConnectDB;
import DTO.DTO_Department;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.sql.Date;
import java.util.List;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Duc Anh
 */
public class DAO_Department extends ConnectDB{
    
    public DAO_Department()
    {
        DAO_Department.connectDB();
    }
    
    public ArrayList ReadDepartment() throws SQLException {
        String query = "SELECT * FROM DEPARTMENT";
        ResultSet rs = DAO_Department.doReadQuery(query);
        ArrayList list = new ArrayList();

        if (rs != null) {
            int i = 1;

            while (rs.next()) {
                DTO_Department dtoDepartment = new DTO_Department();
                dtoDepartment.setID(rs.getInt("DEPARTMENTID"));
                dtoDepartment.setNAME(rs.getString("NAME"));
                dtoDepartment.setBUDGET(rs.getDouble("BUDGET"));
                dtoDepartment.setSTARTDATE(rs.getDate("STARTDATE"));
                dtoDepartment.setADMINISTRATOR(rs.getString("ADMINISTRATOR"));
                list.add(dtoDepartment);
            }
        }
        return list;
    }
    
    public int AddDepartment(DTO_Department dtoDepartment) throws SQLException {
        String query = "Insert Department (NAME, BUDGET, STARTDATE, ADMINISTRATOR) VALUES (?, ?, ?, ?)";
        PreparedStatement p = DAO_Department.getConnection().prepareStatement(query);
        p.setString(1, dtoDepartment.getNAME());
        p.setDouble(2, dtoDepartment.getBUDGET());
        p.setDate(3, new java.sql.Date(dtoDepartment.getSTARTDATE().getTime()));
        p.setString(4, dtoDepartment.getADMINISTRATOR());
        int result = p.executeUpdate();
        return result;
    }
    
    public int EditDepartment(DTO_Department dtoDepartment) throws SQLException {
        String query = "Update DEPARTMENT SET NAME = ? "
                + ", BUDGET = ?, STARTDATE = ?, ADMINISTRATOR = ? WHERE DEPARTMENTID = ?";
        PreparedStatement p = DAO_Department.getConnection().prepareStatement(query);
        p.setString(1, dtoDepartment.getNAME());
        p.setDouble(2, dtoDepartment.getBUDGET());
        p.setDate(3, new java.sql.Date(dtoDepartment.getSTARTDATE().getTime()));
        p.setString(4, dtoDepartment.getADMINISTRATOR());
        p.setInt(5, dtoDepartment.getID());
        int result = p.executeUpdate();
        return result;
    }
    
    public int DeleteDepartment(String departmentId) throws SQLException {
        String query = "DELETE FROM DEPARTMENT WHERE DEPARTMENTID = ?";
        PreparedStatement p = DAO_Department.getConnection().prepareStatement(query);
        p.setString(1, departmentId);
        int result = p.executeUpdate();

        return result;
    }
    
    public List FindDepartment(String searchInput) throws SQLException {
        String query = "SELECT * FROM DEPARTMENT WHERE DEPARTMENTID LIKE ? OR NAME LIKE ? OR ADMINISTRATOR LIKE ? "
                + "OR BUDGET LIKE ? OR STARTDATE LIKE ?";
        PreparedStatement p = DAO_Department.getConnection().prepareStatement(query);
        p.setString(1, "%" + searchInput + "%");
        p.setString(2, "%" + searchInput + "%");
        p.setString(3, "%" + searchInput + "%");
        p.setString(4, ("%" + searchInput + "%").toString());
        p.setString(5, ("%" + searchInput + "%").toString());
        ResultSet rs = p.executeQuery();
        List list = new ArrayList();

        if (rs != null) {
            int i = 1;

            while (rs.next()) {
                DTO_Department dtoDepartment = new DTO_Department();
                dtoDepartment.setID(rs.getInt("DEPARTMENTID"));
                dtoDepartment.setNAME(rs.getString("NAME"));
                dtoDepartment.setBUDGET(rs.getDouble("BUDGET"));
                dtoDepartment.setSTARTDATE(rs.getDate("STARTDATE"));
                dtoDepartment.setADMINISTRATOR(rs.getString("ADMINISTRATOR"));
                list.add(dtoDepartment);
            }
        }
        return list;
    }
    
}
