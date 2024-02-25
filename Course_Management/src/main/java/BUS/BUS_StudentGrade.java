/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BUS;

import DAO.DAO_StudentGrade;
import DTO.DTO_Person;
import DTO.DTO_StudentGrade;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Duc Anh
 */
public class BUS_StudentGrade {

    public DAO_StudentGrade daoStudentGrade = new DAO_StudentGrade();
    public DTO_StudentGrade dtoStudentGrade = new DTO_StudentGrade();

    public List LoadStudentGrade(int page) throws SQLException {
        int numOfRecords = 30;

        ArrayList list = daoStudentGrade.ReadStudentGrade();
        int size = list.size();
        int from, to;
        from = (page - 1) * numOfRecords;
        to = page * numOfRecords;
        return list.subList(from, Math.min(to, size));
    }

    public int AddStudentGrade(DTO_StudentGrade dtoStudentGrade) throws SQLException {
        int result = daoStudentGrade.AddStudentGrade(dtoStudentGrade);
        return result;
    }

    public int EditStudentGrade(DTO_StudentGrade dtoStudentGrade) throws SQLException {
        int result = daoStudentGrade.EditStudentGrade(dtoStudentGrade);
        return result;
    }

    public int DeleteStudentGrade(String CourseId) throws SQLException {
        int result = daoStudentGrade.DeleteStudentGrade(CourseId);
        return result;
    }

    public List FindStudentGrade(String searchInput) throws SQLException {
        List list = new ArrayList();

        list = daoStudentGrade.FindStudentGrade(searchInput);

        return list;

    }

    public List<DTO_StudentGrade> getRegistedStudents(int courseId) {
        return daoStudentGrade.getRegistedStudents(courseId);
    }

    public List<DTO_Person> getUnregistedStudents(int courseId) {
        return daoStudentGrade.getUnregistedStudents(courseId);
    }

    public int add(int COURSEID, int STUDENTID) throws SQLException {
        return daoStudentGrade.add(COURSEID, STUDENTID);
    }

    public int delete(int ENROLLMENTID, int COURSEID) throws SQLException {
        return daoStudentGrade.delete(ENROLLMENTID, COURSEID);
    }

    public int updateGrade(int ENROLLMENTID, int GRADE) throws SQLException {
        return daoStudentGrade.updateGrade(ENROLLMENTID, GRADE);
    }
}
