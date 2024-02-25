/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BUS;

import DAO.DAO_Course;
import DAO.DAO_Person;
import DTO.DTO_Course;
import DTO.DTO_Person;

import java.sql.SQLException;
import java.util.ArrayList;

import java.util.List;

/**
 *
 * @author Duc Anh
 */
public class BUS_Course {

    public DAO_Course dao__course = new DAO_Course();
    public DTO_Course dto__course = new DTO_Course();

    public int Add_course(DTO_Course dto__course) throws SQLException {
        int result = dao__course.Add_Course(dto__course);
        return result;
    }

    public int Edit_course(DTO_Course dto__course) throws SQLException {
        int result = dao__course.Edit_Course(dto__course);
        return result;
    }

    public int Delete_course(String course_id) throws SQLException {
        int result_course = dao__course.Delete_Course(course_id);
        return result_course;

    }

    public List<DTO_Course> getAll() {
        return new DAO_Course().getAll();
    }

    public List<DTO_Course> getCoursesByStudentId(int studentId) {
        DAO_Course courseDAO = new DAO_Course();
        List<DTO_Course> onlineCourses = courseDAO.getOnlineCoursesByStudentId(studentId);
        List<DTO_Course> siteCourses = courseDAO.getOnsiteCoursesByStudentId(studentId);

        onlineCourses.addAll(siteCourses);
        return onlineCourses;

    }

    public List<DTO_Course> getCoursesOfInstructor(int instructorId) {
        DAO_Course courseDAO = new DAO_Course();
        List<DTO_Course> onlineCourses = courseDAO.getOnlineCoursesCoursesOfInstructor(instructorId);
        List<DTO_Course> siteCourses = courseDAO.getOnsiteCoursesCoursesOfInstructor(instructorId);

        onlineCourses.addAll(siteCourses);
        return onlineCourses;
    }

    public void addOnsiteCourse(DTO_Course course) throws SQLException{
        DAO_Course courseDAO = new DAO_Course();
        courseDAO.Add_Course(course);
        courseDAO.Add_OnsiteCourse(course);
    }

    public void addOnlineCourse(DTO_Course course) {
        DAO_Course courseDAO = new DAO_Course();
        try {
            courseDAO.Add_Course(course);
            courseDAO.Add_OnlineCourse(course);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
