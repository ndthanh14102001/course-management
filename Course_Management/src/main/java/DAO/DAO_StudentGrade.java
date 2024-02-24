/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import DTO.DTO_StudentGrade;
import Services.ConnectDB;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Duc Anh
 */
public class DAO_StudentGrade extends ConnectDB {

    
    public DAO_StudentGrade()
    {
        DAO_StudentGrade.connectDB();
    }

    public ArrayList ReadStudentGrade() throws SQLException {
        String query = "SELECT * FROM STUDENTGRADE";
        ResultSet rs = DAO_StudentGrade.doReadQuery(query);
        ArrayList list = new ArrayList();
        
        if (rs != null) {
            int i = 1;
            
            while (rs.next()) {
                DTO_StudentGrade dtoStudentGrade = new DTO_StudentGrade();
                dtoStudentGrade.setENROLLMENTID(rs.getInt("ENROLLMENTID"));
                dtoStudentGrade.setCOURSEID(rs.getInt("COURSEID"));
                dtoStudentGrade.setSTUDENTID(rs.getInt("STUDENTID"));
                dtoStudentGrade.setGRADE(rs.getInt("GRADE"));
                list.add(dtoStudentGrade);
            }
        }
        return list;
    }
    
    public ArrayList ReadCOURSEID_course() throws SQLException {
        String query = "SELECT COURSEID FROM Course";
        ResultSet rs = DAO_StudentGrade.doReadQuery(query);
        ArrayList listcourseID_course = new ArrayList();
        if(rs != null) {
            int i = 1;
            while (rs.next()) {
                int courseID_course = rs.getInt("COURSEID");
                listcourseID_course.add(courseID_course);
            }
        }
        return listcourseID_course;
    }
    
    public ArrayList ReadPERSONID_person() throws SQLException {
        String query = "SELECT PERSONID FROM Person";
        ResultSet rs = DAO_StudentGrade.doReadQuery(query);
        ArrayList listpersonID_person = new ArrayList();
        if(rs != null) {
            int i = 1;
            while (rs.next()) {
                int personID_person = rs.getInt("PERSONID");
                listpersonID_person.add(personID_person);
            }
        }
        return listpersonID_person;
    }

    public int AddStudentGrade(DTO_StudentGrade dtoStudentGrade) throws SQLException {
        String query = "Insert StudentGrade (COURSEID, STUDENTID, GRADE) VALUES (?, ?, ?)";
        PreparedStatement p = DAO_StudentGrade.getConnection().prepareStatement(query);
        p.setInt(1, dtoStudentGrade.getCOURSEID());
        p.setInt(2, dtoStudentGrade.getSTUDENTID());
        p.setInt(3, dtoStudentGrade.getGRADE());
        int result = p.executeUpdate();
        return result;
    }

    public int EditStudentGrade(DTO_StudentGrade dtoStudentGrade) throws SQLException {
        String query = "UPDATE STUDENTGRADE SET COURSEID = ? ,STUDENTID = ? ,GRADE = ? ,WHERE ENROLLMENTID = ?";
        PreparedStatement p = DAO_StudentGrade.getConnection().prepareStatement(query);
        p.setInt(1, dtoStudentGrade.getCOURSEID());
        p.setInt(2, dtoStudentGrade.getSTUDENTID());
        p.setInt(3, dtoStudentGrade.getGRADE());
        int result = p.executeUpdate();
        return result;
    }

    public int DeleteStudentGrade(String EnrollmentId) throws SQLException {
        String query = "DELETE FROM STUDENTGRADE WHERE ENROLLMENTID = ?";
        PreparedStatement p = DAO_StudentGrade.getConnection().prepareStatement(query);
        p.setString(1, EnrollmentId);
        int result = p.executeUpdate();
        return result;
    }

    public List FindStudentGrade(String searchInput) throws SQLException {
        String query = "SELECT * FROM STUDENTGRADE WHERE ENROLLMENTID LIKE ? OR COURSEID LIKE ? OR STUDENTID LIKE ? OR GRADE LIKE ?";
        PreparedStatement p = DAO_StudentGrade.getConnection().prepareStatement(query);
        p.setString(1, "%" + searchInput + "%");
        p.setString(2, "%" + searchInput + "%");
        p.setString(3, "%" + searchInput + "%");
        p.setString(4, "%" + searchInput + "%");
        ResultSet rs = p.executeQuery();
        List list = new ArrayList();
        
        if (rs != null) {
            int i = 1;
            
            while (rs.next()) {
                DTO_StudentGrade dtoStudentGrade = new DTO_StudentGrade();
                dtoStudentGrade.setENROLLMENTID(rs.getInt("ENROLLMENTID"));
                dtoStudentGrade.setCOURSEID(rs.getInt("COURSEID"));
                dtoStudentGrade.setSTUDENTID(rs.getInt("STUDENTID"));
                dtoStudentGrade.setGRADE(rs.getInt("GRADE"));
                list.add(dtoStudentGrade);
            }
        }
        return list; 
    }

    public ArrayList ReadDepartment() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}