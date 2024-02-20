/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BUS;

import DAO.DAO_OnlineCourse;
import DTO.DTO_Course;
import DTO.DTO_OnlineCourse;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author Duc Anh
 */
public class BUS_OnlineCourse {

    public List<DTO_OnlineCourse> getAll() {
        return new DAO_OnlineCourse().getAll();
    }

    public int add(DTO_OnlineCourse onlineCourse) throws SQLException {
        return new DAO_OnlineCourse().add(onlineCourse);
    }

    public List<DTO_Course> getCoursesWithoutType() throws SQLException {
        return new DAO_OnlineCourse().getCoursesWithoutType();
    }
}
