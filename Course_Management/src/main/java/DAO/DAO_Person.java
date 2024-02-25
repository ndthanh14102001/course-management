/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import DTO.DTO_Person;
import Services.ConnectDB;
import java.sql.Connection;
import java.sql.PreparedStatement;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Paul
 */
public class DAO_Person {

    private Connection conn;
    private List persons;

    public DAO_Person() {
        ConnectDB.connectDB();
        //ConnectDB ms = new ConnectDB();
        conn = ConnectDB.getConnection();
    }

    public List<DTO_Person> GetAllInstructorsWithCourseCount() {
        persons = new ArrayList<DTO_Person>();
        try {
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT *,COUNT(*) AS NUMBER_OF_COURSES FROM `courseinstructor`,`person` \n"
                    + "WHERE `person`.`HIREDATE` IS NOT NULL "
                    + "AND `person`.`PERSONID` = `courseinstructor`.`PERSONID` "
                    + "GROUP BY `person`.`PERSONID`;");
            while (rs.next()) {
                DTO_Person p = new DTO_Person(rs.getInt("PERSONID"), rs.getString("LASTNAME"), rs.getString("FIRSTNAME"), rs.getDate("HIREDATE"), rs.getDate("ENROLLMENTDATE"));
                p.setCourseCount(rs.getInt("NUMBER_OF_COURSES"));
                persons.add(p);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return persons;
    }

    public List<DTO_Person> GetAllInstructorsWithoutCourse() {
        persons = new ArrayList<DTO_Person>();
        try {
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM `person` \n"
                    + "WHERE `person`.HIREDATE IS NOT NULL "
                    + "AND PERSONID NOT IN (SELECT PERSONID FROM `courseinstructor`)");
            while (rs.next()) {
                DTO_Person person = new DTO_Person(rs.getInt("PERSONID"), rs.getString("LASTNAME"), rs.getString("FIRSTNAME"), rs.getDate("HIREDATE"), rs.getDate("ENROLLMENTDATE"));
                person.setCourseCount(0);
                persons.add(person);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return persons;
    }

    public List<DTO_Person> GetAllStudentWithCourseCount() {
        persons = new ArrayList<DTO_Person>();
        try {
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT *,COUNT(*) AS NUMBER_OF_COURSES FROM `studentgrade`,`person` \n"
                    + "WHERE `person`.`ENROLLMENTDATE` IS NOT NULL "
                    + "AND `person`.`PERSONID` = `studentgrade`.`STUDENTID` "
                    + "GROUP BY `person`.`PERSONID`;");
            while (rs.next()) {
                DTO_Person p = new DTO_Person(rs.getInt("PERSONID"), rs.getString("LASTNAME"), rs.getString("FIRSTNAME"), rs.getDate("HIREDATE"), rs.getDate("ENROLLMENTDATE"));
                p.setCourseCount(rs.getInt("NUMBER_OF_COURSES"));
                persons.add(p);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return persons;
    }

    public List<DTO_Person> GetAllStudentWithoutCourse() {
        persons = new ArrayList<DTO_Person>();
        try {
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM `person` \n"
                    + "WHERE `person`.ENROLLMENTDATE IS NOT NULL "
                    + "AND PERSONID NOT IN (SELECT STUDENTID FROM `studentgrade`)");
            while (rs.next()) {
                DTO_Person person = new DTO_Person(rs.getInt("PERSONID"), rs.getString("LASTNAME"), rs.getString("FIRSTNAME"), rs.getDate("HIREDATE"), rs.getDate("ENROLLMENTDATE"));
                person.setCourseCount(0);
                persons.add(person);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return persons;
    }

    public void Add(DTO_Person person) {
        try {
            String sql = "INSERT PERSON (LASTNAME, FIRSTNAME, HIREDATE, ENROLLMENTDATE) VALUES (? , ?, ?, ?)";
            PreparedStatement p = conn.prepareStatement(sql);
            p.setString(1, person.getLast_name());
            p.setString(2, person.getFirst_name());
            p.setDate(3, person.getHire_date());
            p.setDate(4, person.getEnrollment_date());
            p.execute();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void Update(DTO_Person person, int id) throws SQLException {
        String sql = "UPDATE `person` SET LASTNAME= ? , FIRSTNAME= ? , HIREDATE= ? , ENROLLMENTDATE= ? WHERE `person`.PERSONID= ? ";
        PreparedStatement p = ConnectDB.getConnection().prepareStatement(sql);
        p.setString(1, person.getLast_name());
        p.setString(2, person.getFirst_name());
        p.setDate(3, person.getHire_date());
        p.setDate(4, person.getEnrollment_date());
        p.setInt(5, id);
        p.execute();
    }

    public void Delete(String id) throws SQLException {
        Statement stmt = conn.createStatement();
        String sql = "DELETE FROM PERSON WHERE PERSONID = '" + id + "'";
        stmt.executeUpdate(sql);
    }

    public List<DTO_Person> Show() {
        persons = new ArrayList<DTO_Person>();
        try {
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("Select * From Person");
            while (rs.next()) {
                DTO_Person p = new DTO_Person(rs.getInt("PERSONID"), rs.getString("LASTNAME"), rs.getString("FIRSTNAME"), rs.getDate("HIREDATE"), rs.getDate("ENROLLMENTDATE"));
                persons.add(p);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return persons;
    }

    public List<DTO_Person> Search(String id) {
        persons = new ArrayList<DTO_Person>();
        try {
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("Select * From Person Where PERSONID='" + id + "'");
            while (rs.next()) {
                DTO_Person p = new DTO_Person(rs.getInt("PERSONID"), rs.getString("LASTNAME"), rs.getString("FIRSTNAME"), rs.getDate("HIREDATE"), rs.getDate("ENROLLMENTDATE"));
                persons.add(p);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return persons;
    }
}
