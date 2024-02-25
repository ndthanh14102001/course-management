/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import DTO.DTO_Course;
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
public class DAO_OnlineCourse {

    public DAO_OnlineCourse() {
        ConnectDB.connectDB();
    }

    public List<DTO_OnlineCourse> getAll() {
        String query = "SELECT * \n"
                + "FROM `onlinecourse`\n"
                + "INNER JOIN `course` ON `course`.`COURSEID` = `onlinecourse`.`COURSEID`;";
        ResultSet rs = DAO_Department.doReadQuery(query);
        ArrayList<DTO_OnlineCourse> courses = new ArrayList<DTO_OnlineCourse>();

        try {
            if (rs != null) {

                while (rs.next()) {
                    DTO_OnlineCourse course = new DTO_OnlineCourse();
                    course.setCOURSEID(rs.getInt("COURSEID"));
                    course.setTITLE(rs.getString("TITLE"));
                    course.setCREDITS(rs.getString("CREDITS"));
                    course.setURL(rs.getString("URL"));
                    courses.add(course);
                }
            }
        } catch (Exception e) {
        }
        return courses;
    }

    public List<DTO_OnlineCourse> getByTitle(String title) {
        String query = "SELECT * \n"
                + "FROM `onlinecourse` \n"
                + "INNER JOIN `course` ON `course`.`COURSEID` = `onlinecourse`.`COURSEID` \n"
                + "WHERE `course`.`TITLE` LIKE '%" + title + "%';";
        ArrayList<DTO_OnlineCourse> courses = new ArrayList<DTO_OnlineCourse>();
        try {
            ResultSet rs = ConnectDB.doReadQuery(query);
            if (rs != null) {

                while (rs.next()) {
                    DTO_OnlineCourse course = new DTO_OnlineCourse();
                    course.setCOURSEID(rs.getInt("COURSEID"));
                    course.setTITLE(rs.getString("TITLE"));
                    course.setCREDITS(rs.getString("CREDITS"));
                    course.setURL(rs.getString("URL"));
                    courses.add(course);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return courses;
    }

    public int add(DTO_OnlineCourse onlineCourse) throws SQLException {
        String query = "Insert onlinecourse (COURSEID, URL) VALUES (?, ?)";
        PreparedStatement p = ConnectDB.getConnection().prepareStatement(query);
        p.setInt(1, onlineCourse.getCOURSEID());
        p.setString(2, onlineCourse.getURL());
        int result = p.executeUpdate();
        return result;
    }

    public int update(DTO_OnlineCourse onlineCourse) throws SQLException {
        String query = "Update onlinecourse set URL = ? Where COURSEID = ?";
        PreparedStatement p = ConnectDB.getConnection().prepareStatement(query);
        p.setString(1, onlineCourse.getURL());
        p.setInt(2, onlineCourse.getCOURSEID());
        int result = p.executeUpdate();
        return result;
    }

    public List<DTO_Course> getCoursesWithoutType() {
        String query = "SELECT * FROM `course` WHERE `course`.`COURSEID` NOT IN (SELECT COURSEID FROM `onsitecourse`) and `course`.`COURSEID` NOT IN (SELECT COURSEID FROM `onlinecourse`);";
        ResultSet rs = DAO_Department.doReadQuery(query);
        ArrayList<DTO_Course> courses = new ArrayList<DTO_Course>();

        try {
            if (rs != null) {

                while (rs.next()) {
                    DTO_Course course = new DTO_Course();
                    course.setCOURSEID(rs.getInt("COURSEID"));
                    course.setTITLE(rs.getString("TITLE"));
                    course.setCREDITS(rs.getString("CREDITS"));
                    courses.add(course);
                }
            }
        } catch (Exception e) {
        }
        return courses;
    }

    public int delete(int onlineCourseId) throws SQLException {
        String query = "DELETE FROM `onlinecourse` WHERE `onlinecourse`.`COURSEID` = ?;";
        PreparedStatement p = ConnectDB.getConnection().prepareStatement(query);
        p.setInt(1, onlineCourseId);
        int result = p.executeUpdate();
        return result;
    }
}
