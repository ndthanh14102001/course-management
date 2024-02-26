/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BUS;

import DTO.DTO_Person;
import Helper.ConnectDB;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Duc Anh
 */
public class BUS_CourseInstructor {

    public List<DTO_Person> GetInstructorByCourseId(int courseId) {
        return new DAO.DAO_CourseInstructor().GetInstructorByCourseId(courseId);
    }

    public List<DTO_Person> GetUnassignedInstructorsByCourseId(int courseId) {
        return new DAO.DAO_CourseInstructor().GetUnassignedInstructorsByCourseId(courseId);
    }

    public int add(int personalId, int courseId) throws SQLException {
        return new DAO.DAO_CourseInstructor().add(personalId, courseId);
    }

    public int delete(int personalId, int courseId) throws SQLException {
        return new DAO.DAO_CourseInstructor().delete(personalId, courseId);
    }

}
