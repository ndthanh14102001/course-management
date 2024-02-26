/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import DTO.DTO_Person;
import Helper.ConnectDB;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Duc Anh
 */
public class DAO_CourseInstructor {

    public DAO_CourseInstructor() {
        ConnectDB.connectDB();
    }

    public List<DTO_Person> GetInstructorByCourseId(int courseId) {
        ArrayList<DTO_Person> persons = new ArrayList<DTO_Person>();
        try {
            String query = "SELECT * FROM `courseinstructor`, `course`, `person`"
                    + " WHERE `courseinstructor`.`COURSEID` = ? "
                    + " AND `courseinstructor`.`COURSEID` = `course`.`COURSEID`"
                    + " AND `person`.`PERSONID` = `courseinstructor`.`PERSONID`;";

            PreparedStatement p = ConnectDB.getConnection().prepareStatement(query);
            p.setInt(1, courseId);

            ResultSet rs = p.executeQuery();
            while (rs.next()) {
                DTO_Person person = new DTO_Person(rs.getInt("PERSONID"), rs.getString("LASTNAME"), rs.getString("FIRSTNAME"), rs.getDate("HIREDATE"), rs.getDate("ENROLLMENTDATE"));
                persons.add(person);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return persons;
    }

    public List<DTO_Person> GetUnassignedInstructorsByCourseId(int courseId) {
        String query = "SELECT * FROM `person` "
                + "WHERE `person`.`PERSONID` NOT IN "
                + "(SELECT `courseinstructor`.`PERSONID` FROM `courseinstructor` WHERE `courseinstructor`.`COURSEID` = ? ) "
                + "AND HIREDATE IS NOT NULL ";
        ArrayList<DTO_Person> persons = new ArrayList<DTO_Person>();
        try {
            PreparedStatement p = ConnectDB.getConnection().prepareStatement(query);
            p.setInt(1, courseId);

            ResultSet rs = p.executeQuery();
            while (rs.next()) {
                DTO_Person person = new DTO_Person(rs.getInt("PERSONID"), rs.getString("LASTNAME"), rs.getString("FIRSTNAME"), rs.getDate("HIREDATE"), rs.getDate("ENROLLMENTDATE"));
                persons.add(person);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return persons;
    }

    public int add(int personalId, int courseId) throws SQLException{
        String query = "Insert `courseinstructor` (PERSONID, COURSEID) VALUES (?, ?)";
        PreparedStatement p = ConnectDB.getConnection().prepareStatement(query);
        p.setInt(1, personalId);
        p.setInt(2, courseId);
        int result = p.executeUpdate();
        return result;
    }
    
    public int delete(int personalId, int courseId) throws SQLException{
        String query = "DELETE FROM `courseinstructor` WHERE `courseinstructor`.`PERSONID` = ? AND `courseinstructor`.`COURSEID` = ? ;";
        PreparedStatement p = ConnectDB.getConnection().prepareStatement(query);
        p.setInt(1, personalId);
        p.setInt(2, courseId);
        int result = p.executeUpdate();
        return result;
    }
}
