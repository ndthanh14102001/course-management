/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import DTO.DTO_Course;
import DTO.DTO_OnlineCourse;
import Services.ConnectDB;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Duc Anh
 */
public class DAO_Course {

    public DAO_Course() {
        ConnectDB.connectDB();
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
}
