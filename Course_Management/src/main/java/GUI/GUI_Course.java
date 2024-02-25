/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package GUI;

import DAO.DAO_Course;
import DTO.DTO_Course;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author Đức Anh
 */
public class GUI_Course {

    public static void main(String[] args) {
        GUI_ManageCourse Course = new GUI_ManageCourse();
        Course.setLocationRelativeTo(null);
        Course.setVisible(true);
    }

    public static void listCourse() throws SQLException {
        DAO_Course dao__course = new DAO_Course();
        ArrayList list_course = dao__course.ReadCourse();
        for (int i = 0; i < list_course.size(); i++) {
            DTO_Course dto__course = (DTO_Course) list_course.get(i);
            System.out.println(dto__course.getCOURSEID() + " " + dto__course.getTITLE() + " " + dto__course.getCREDITS() + " " + dto__course.getDEPARTMENTID());
        }
    }
}
