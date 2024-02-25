/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import DTO.DTO_Course;
import DTO.DTO_Department;

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

    public void Add_OnsiteCourse(DTO_Course dto__course) throws SQLException {
        String query_course = "Insert into ONSITECOURSE ( COURSEID,LOCATION,DATES,TIMES ) VALUES (LAST_INSERT_ID(),?, ?, ?)";
        PreparedStatement p_course = ConnectDB.getConnection().prepareStatement(query_course);
        p_course.setString(1, dto__course.getLOCATION());
        p_course.setDate(2, dto__course.getDate());
        p_course.setTime(3, dto__course.getTime());

        p_course.execute();
    }

    public void Update_OnsiteCourse(DTO_Course dto__course) throws SQLException {
        String query_course = "Update ONSITECOURSE SET LOCATION = ? , DATES = ?, TIMES = ? WHERE COURSEID = ?";
        PreparedStatement p_course = ConnectDB.getConnection().prepareStatement(query_course);
        p_course.setString(1, dto__course.getLOCATION());
        p_course.setDate(2, dto__course.getDate());
        p_course.setTime(3, dto__course.getTime());
        p_course.setInt(4, dto__course.getCOURSEID());
        
        p_course.execute();
    }

    public int Add_OnlineCourse(DTO_Course dto__course) throws SQLException {
        String query_course = "Insert ONLINECOURSE ( URL ) VALUES (?)";
        PreparedStatement p_course = ConnectDB.getConnection().prepareStatement(query_course);
        p_course.setString(1, dto__course.getURL());

        int result = p_course.executeUpdate();
        return result;
    }
    
     public void Update_OnlineCourse(DTO_Course dto__course) throws SQLException {
        String query_course = "Update ONLINECOURSE SET URL = ?  WHERE COURSEID = ?";
        PreparedStatement p_course = ConnectDB.getConnection().prepareStatement(query_course);
        p_course.setString(1, dto__course.getURL());
        p_course.setInt(2, dto__course.getCOURSEID());
        
        p_course.execute();
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
        String query = "SELECT course.COURSEID, \n"
                + "course.TITLE, \n"
                + "course.CREDITS,\n"
                + "department.NAME as DEPARTMENTNAME,\n"
                + "department.DEPARTMENTID,\n"
                + "NULL as URL,\n"
                + "onsitecourse.LOCATION,\n"
                + "onsitecourse.DATES,\n"
                + "onsitecourse.TIMES \n"
                + "FROM course,onsitecourse, department\n"
                + "WHERE course.COURSEID = `onsitecourse`.`COURSEID`\n"
                + "AND course.DEPARTMENTID = department.DEPARTMENTID\n"
                + "UNION ALL\n"
                + "SELECT course.COURSEID, \n"
                + "course.TITLE, \n"
                + "course.CREDITS,\n"
                + "department.NAME,\n"
                + "department.DEPARTMENTID,\n"
                + "onlinecourse.URL as URL,\n"
                + "NULL,\n"
                + "NULL,\n"
                + "NULL\n"
                + "FROM course, onlinecourse,department\n"
                + "WHERE course.COURSEID = onlinecourse.COURSEID\n"
                + "AND course.DEPARTMENTID = department.DEPARTMENTID;";
        ResultSet rs = DAO_Department.doReadQuery(query);
        ArrayList<DTO_Course> courses = new ArrayList<DTO_Course>();

        try {
            if (rs != null) {

                while (rs.next()) {
                    DTO_Course course = new DTO_Course();
                    DTO_Department department = new DTO_Department();
                    department.setNAME(rs.getString("DEPARTMENTNAME"));
                    department.setID(rs.getInt("DEPARTMENTID"));
                    course.setDepartment(department);
                    course.setCOURSEID(rs.getInt("COURSEID"));
                    course.setTITLE(rs.getString("TITLE"));
                    course.setCREDITS(rs.getString("CREDITS"));
                    course.setURL(rs.getString("URL"));
                    course.setLOCATION(rs.getString("LOCATION"));
                    course.setTime(rs.getTime("TIMES"));
                    course.setDate(rs.getDate("DATES"));
                    courses.add(course);
                }
            }
        } catch (Exception e) {
        }
        return courses;
    }

    public List<DTO_Course> getOnlineCoursesByStudentId(int studentId) {
        String query = "SELECT * FROM `studentgrade`,`course`,`onlinecourse`\n"
                + "WHERE `studentgrade`.`STUDENTID` = ? \n"
                + "AND `course`.COURSEID = `onlinecourse`.COURSEID \n"
                + "AND `studentgrade`.COURSEID = `course`.COURSEID";

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
                    course.setURL(rs.getString("URL"));
                    courses.add(course);
                }
            }
        } catch (Exception e) {
        }
        return courses;
    }

    public List<DTO_Course> getOnsiteCoursesByStudentId(int studentId) {
        String query = "SELECT * FROM `studentgrade`,`course`,`onsitecourse`\n"
                + "WHERE `studentgrade`.`STUDENTID` = ? \n"
                + "AND `course`.COURSEID = `onsitecourse`.COURSEID \n"
                + "AND `studentgrade`.COURSEID = `course`.COURSEID";

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
                    course.setTime(rs.getTime("TIMES"));
                    course.setDate(rs.getDate("DATES"));
                    courses.add(course);
                }
            }
        } catch (Exception e) {
        }
        return courses;
    }

    public List<DTO_Course> getOnlineCoursesCoursesOfInstructor(int instructorId) {
        String query = "SELECT * FROM `courseinstructor`,`course`,`onlinecourse`\n"
                + "WHERE `courseinstructor`.`PERSONID` = ? \n"
                + "AND onlinecourse.COURSEID = course.COURSEID\n"
                + "AND courseinstructor.COURSEID = course.COURSEID;";

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
                    course.setURL(rs.getString("URL"));
                    courses.add(course);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return courses;
    }

    public List<DTO_Course> getOnsiteCoursesCoursesOfInstructor(int instructorId) {
        String query = "SELECT * FROM `courseinstructor`,`course`,`onsitecourse`\n"
                + "WHERE `courseinstructor`.`PERSONID` = ? \n"
                + "AND onsitecourse.COURSEID = course.COURSEID\n"
                + "AND courseinstructor.COURSEID = course.COURSEID;";

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
                    course.setTime(rs.getTime("TIMES"));
                    course.setDate(rs.getDate("DATES"));
                    courses.add(course);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return courses;
    }
}
