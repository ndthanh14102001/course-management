/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import DTO.DTO_Course;

import Services.ConnectDB;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import DTO.DTO_OnlineCourse;
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
public class DAO_Course extends ConnectDB {

    public DAO_Course() {
        ConnectDB.connectDB();
    }

    public ArrayList ReadCourse() throws SQLException {
        String query_course = "SELECT * FrOM COURSE";
        ResultSet rs_course = ConnectDB.doReadQuery(query_course);
        ArrayList list_course = new ArrayList();
        if (rs_course != null) {
            int i = 1;
            while (rs_course.next()) {
                DTO_Course dto__course = new DTO_Course();
                dto__course.setCOURSEID(rs_course.getInt("COURSEID"));
                dto__course.setTITLE(rs_course.getString("TITLE"));
                dto__course.setCREDITS(rs_course.getString("CREDITS"));
                dto__course.setDEPARTMENTID(rs_course.getInt("DEPARTMENTID"));
                list_course.add(dto__course);
            }
        }
        return list_course;
    }

    public ArrayList ReadDEPARTMENTID_course() throws SQLException {
        String query_course = "SELECT DEPARTMENTID FROM Department";
        ResultSet rs_course = ConnectDB.doReadQuery(query_course);
        ArrayList listdepartmentID_course = new ArrayList();
        if (rs_course != null) {
            int i = 1;
            while (rs_course.next()) {
                int departmentID_course = rs_course.getInt("DEPARTMENTID");
                listdepartmentID_course.add(departmentID_course);
            }
        }
        return listdepartmentID_course;
    }

    public int Add_Course(DTO_Course dto__course) throws SQLException {
        String query_course = "Insert COURSE ( TITLE,CREDITS,DEPARTMENTID ) VALUES (?, ?, ?)";
        PreparedStatement p_course = ConnectDB.getConnection().prepareStatement(query_course);
        p_course.setString(1, dto__course.getTITLE());
        p_course.setString(2, dto__course.getCREDITS());
        p_course.setInt(3, dto__course.getDEPARTMENTID());

        int result = p_course.executeUpdate();
        return result;
    }

    public int Edit_Course(DTO_Course dto__Course) throws SQLException {
        String query_course = "UPDATE COURSE SET TITLE = ? ,CREDITS = ? , DEPARTMENTID = ? WHERE COURSEID = ?";
        PreparedStatement p_course = ConnectDB.getConnection().prepareStatement(query_course);
        p_course.setString(1, dto__Course.getTITLE());
        p_course.setString(2, dto__Course.getCREDITS());
        p_course.setInt(3, dto__Course.getDEPARTMENTID());
        p_course.setInt(4, dto__Course.getCOURSEID());
        int result_course = p_course.executeUpdate();
        return result_course;
    }

    public int Delete_Course(String course_id) throws SQLException {
        String query_course = "DELETE FROM COURSE WHERE COURSEID = ?";
        PreparedStatement p_course = ConnectDB.getConnection().prepareStatement(query_course);
        p_course.setString(1, course_id);
        int result = p_course.executeUpdate();
        return result;
    }

    public List<DTO_Course> getAll() {
        String query = "SELECT * FROM `course`";
        ResultSet rs = DAO_Department.doReadQuery(query);
        ArrayList<DTO_Course> courses = new ArrayList<DTO_Course>();

        try {
            if (rs != null) {

                while (rs.next()) {
                    DTO_Course course = new DTO_Course();
                    course.setCOURSEID(rs.getInt("COURSEID"));
                    course.setTITLE(rs.getString("TITLE"));
                    course.setCREDITS(rs.getString("CREDITS"));
                    course.setDEPARTMENTID(rs.getInt("DEPARTMENTID"));
                    courses.add(course);
                }
            }
        } catch (Exception e) {
        }
        return courses;
    }

    public List<DTO_Course> getCoursesByStudentId(int studentId) {
        String query = "SELECT * FROM `studentgrade`,`course`,`onlinecourse`,`onsitecourse`\n"
                + "WHERE `studentgrade`.`STUDENTID` = ? \n"
                + "GROUP BY `studentgrade`.`COURSEID`;";

        ArrayList<DTO_Course> courses = new ArrayList<DTO_Course>();

        try {
            PreparedStatement p = ConnectDB.getConnection().prepareStatement(query);
            p.setInt(1, studentId);
            ResultSet rs = p.executeQuery();
            if (rs != null) {

                while (rs.next()) {
                    DTO_Course course = new DTO_Course();
                    course.setCOURSEID(rs.getInt("COURSEID"));
                    course.setTITLE(rs.getString("TITLE"));
                    course.setCREDITS(rs.getString("CREDITS"));
                    course.setDEPARTMENTID(rs.getInt("DEPARTMENTID"));
                    course.setLOCATION(rs.getString("LOCATION"));
                    course.setURL(rs.getString("URL"));
                    course.setTime(rs.getTime("TIMES"));
                    course.setDate(rs.getDate("DATES"));
                    courses.add(course);
                }
            }
        } catch (Exception e) {
        }
        return courses;
    }
    public List<DTO_Course> getCoursesOfInstructor(int instructorId) {
        String query = "SELECT * FROM `courseinstructor`,`course`,`onlinecourse`,`onsitecourse`\n"
                + "WHERE `courseinstructor`.`PERSONID` = ? \n"
                + "GROUP BY `courseinstructor`.`COURSEID`;";

        ArrayList<DTO_Course> courses = new ArrayList<DTO_Course>();

        try {
            PreparedStatement p = ConnectDB.getConnection().prepareStatement(query);
            p.setInt(1, instructorId);
            ResultSet rs = p.executeQuery();
            if (rs != null) {

                while (rs.next()) {
                    DTO_Course course = new DTO_Course();
                    course.setCOURSEID(rs.getInt("COURSEID"));
                    course.setTITLE(rs.getString("TITLE"));
                    course.setCREDITS(rs.getString("CREDITS"));
                    course.setDEPARTMENTID(rs.getInt("DEPARTMENTID"));
                    course.setLOCATION(rs.getString("LOCATION"));
                    course.setURL(rs.getString("URL"));
                    course.setTime(rs.getTime("TIMES"));
                    course.setDate(rs.getDate("DATES"));
                    courses.add(course);
                }
            }
        } catch (Exception e) {
        }
        return courses;
    }
}
