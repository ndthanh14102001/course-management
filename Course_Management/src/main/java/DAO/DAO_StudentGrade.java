/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import DTO.DTO_Course;
import DTO.DTO_Person;
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

    public DAO_StudentGrade() {
        DAO_StudentGrade.connectDB();
    }

    public ArrayList ReadStudentGrade() throws SQLException {
        String query = "SELECT * FROM `studentgrade`,`person` WHERE `studentgrade`.`STUDENTID` = `person`.`PERSONID`;";
        ResultSet rs = DAO_StudentGrade.doReadQuery(query);
        ArrayList list = new ArrayList();

        if (rs != null) {
            while (rs.next()) {
                DTO_StudentGrade dtoStudentGrade = new DTO_StudentGrade();
                dtoStudentGrade.setENROLLMENTID(rs.getInt("ENROLLMENTID"));
                dtoStudentGrade.setCOURSEID(rs.getInt("COURSEID"));
                dtoStudentGrade.setSTUDENTID(rs.getInt("STUDENTID"));
                dtoStudentGrade.setGRADE(rs.getInt("GRADE"));
                dtoStudentGrade.setFirst_name(rs.getString("FIRSTNAME"));
                dtoStudentGrade.setLast_name(rs.getString("LASTNAME"));
                list.add(dtoStudentGrade);
            }
        }
        return list;
    }

    public ArrayList ReadPERSONID_person() throws SQLException {
        String query = "SELECT PERSONID FROM Person";
        ResultSet rs = DAO_StudentGrade.doReadQuery(query);
        ArrayList listpersonID_person = new ArrayList();
        if (rs != null) {
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

    public List<DTO_StudentGrade> getRegistedStudents(int courseId) {
        List<DTO_StudentGrade> list = new ArrayList();
        String query = "SELECT * FROM STUDENTGRADE,PERSON"
                + " WHERE COURSEID = ?"
                + " AND PERSON.ENROLLMENTDATE IS NOT NULL \n"
                + " AND PERSON.PERSONID = STUDENTGRADE.STUDENTID";
        try {
            PreparedStatement p = DAO_StudentGrade.getConnection().prepareStatement(query);
            p.setInt(1, courseId);
            ResultSet rs = p.executeQuery();

            if (rs != null) {

                while (rs.next()) {
                    DTO_StudentGrade dtoStudentGrade = new DTO_StudentGrade();
                    dtoStudentGrade.setENROLLMENTID(rs.getInt("ENROLLMENTID"));
                    dtoStudentGrade.setCOURSEID(rs.getInt("COURSEID"));
                    dtoStudentGrade.setId(rs.getInt("STUDENTID"));
                    dtoStudentGrade.setGRADE(rs.getInt("GRADE"));
                    dtoStudentGrade.setFirst_name(rs.getString("FIRSTNAME"));
                    dtoStudentGrade.setLast_name(rs.getString("LASTNAME"));
                    list.add(dtoStudentGrade);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    public List<DTO_Person> getUnregistedStudents(int courseId) {
        List<DTO_Person> list = new ArrayList();
        String query = "SELECT * FROM PERSON \n"
                + "WHERE PERSON.ENROLLMENTDATE IS NOT NULL \n"
                + "AND PERSON.PERSONID NOT IN (SELECT STUDENTID FROM STUDENTGRADE WHERE STUDENTGRADE.COURSEID = ? );";
        try {
            PreparedStatement p = DAO_StudentGrade.getConnection().prepareStatement(query);
            p.setInt(1, courseId);
            ResultSet rs = p.executeQuery();

            if (rs != null) {
                while (rs.next()) {
                    DTO_Person person = new DTO_Person();
                    person.setId(rs.getInt("PERSONID"));
                    person.setFirst_name(rs.getString("FIRSTNAME"));
                    person.setLast_name(rs.getString("LASTNAME"));

                    list.add(person);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    public int add(int COURSEID, int STUDENTID) throws SQLException {
        String query = "Insert `studentgrade` (COURSEID , STUDENTID ) VALUES (?, ?)";
        PreparedStatement p = ConnectDB.getConnection().prepareStatement(query);
        p.setInt(1, COURSEID);
        p.setInt(2, STUDENTID);
        int result = p.executeUpdate();
        return result;
    }

    public int delete(int ENROLLMENTID, int COURSEID) throws SQLException {
        String query = "DELETE FROM `studentgrade` WHERE `studentgrade`.`ENROLLMENTID` = ? AND `studentgrade`.`COURSEID` = ? ;";
        PreparedStatement p = ConnectDB.getConnection().prepareStatement(query);
        p.setInt(1, ENROLLMENTID);
        p.setInt(2, COURSEID);
        int result = p.executeUpdate();
        return result;
    }

    public int updateGrade(int ENROLLMENTID, int GRADE) throws SQLException {
        String query = "Update `studentgrade` SET GRADE = ? WHERE ENROLLMENTID = ?";
        PreparedStatement p = ConnectDB.getConnection().prepareStatement(query);
        p.setInt(1, GRADE);
        p.setInt(2, ENROLLMENTID);
        int result = p.executeUpdate();
        return result;
    }
}
