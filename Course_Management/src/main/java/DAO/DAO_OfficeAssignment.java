/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import DTO.DTO_OfficeAssignment;
import DTO.DTO_OnlineCourse;
import DTO.DTO_Person;
import Services.ConnectDB;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Duc Anh
 */
public class DAO_OfficeAssignment {

    public DAO_OfficeAssignment() {
        ConnectDB.connectDB();
    }

    public List<DTO_OfficeAssignment> getAll() {
        List<DTO_OfficeAssignment> officeAssignments = new ArrayList<>();
        try {
            Statement stmt = ConnectDB.getConnection().createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM `person`,`officeassignment` WHERE `person`.`PERSONID` = `officeassignment`.`INSTRUCTOR`;");
            while (rs.next()) {
                DTO_OfficeAssignment officeAssignment = new DTO_OfficeAssignment();
                officeAssignment.setId(rs.getInt("PERSONID"));
                officeAssignment.setFirst_name(rs.getString("FIRSTNAME"));
                officeAssignment.setLast_name(rs.getString("LASTNAME"));
                officeAssignment.setLOCATION(rs.getString("LOCATION"));
                officeAssignment.setTIMESTAMP(rs.getDate("TIMESTAMP"));
                officeAssignments.add(officeAssignment);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return officeAssignments;
    }

    public int add(DTO_OfficeAssignment officeAssignment) throws SQLException {
        LocalDateTime now = LocalDateTime.now();
        String query = "Insert officeassignment (INSTRUCTOR , LOCATION, TIMESTAMP) VALUES (?, ?, ?)";
        PreparedStatement p = ConnectDB.getConnection().prepareStatement(query);
        p.setInt(1, officeAssignment.getId());
        p.setString(2, officeAssignment.getLOCATION());
        p.setObject(3, now);
        int result = p.executeUpdate();
        return result;
    }

    public int update(DTO_OfficeAssignment officeAssignment) throws SQLException {
        String query = "UPDATE `officeassignment` SET `LOCATION` = ? WHERE `officeassignment`.`INSTRUCTOR` = ? ;";
        PreparedStatement p = ConnectDB.getConnection().prepareStatement(query);
        p.setString(1, officeAssignment.getLOCATION());
        p.setInt(2, officeAssignment.getId());
        int result = p.executeUpdate();
        return result;
    }

    public int delete(int instructorId) throws SQLException {
        String query = "DELETE FROM `officeassignment` WHERE `officeassignment`.`INSTRUCTOR` = ? ";
        PreparedStatement p = ConnectDB.getConnection().prepareStatement(query);
        p.setInt(1, instructorId);
        int result = p.executeUpdate();
        return result;
    }

    public List<DTO_Person> getAllInstructorsWithoutOffice() {
        List<DTO_Person> persons = new ArrayList<>();
        try {
            Statement stmt = ConnectDB.getConnection().createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM `person`"
                    + " WHERE `person`.`HIREDATE` IS NOT NULL"
                    + " AND `person`.`PERSONID` NOT IN "
                    + "(SELECT `officeassignment`.`INSTRUCTOR` FROM `officeassignment`)");
            while (rs.next()) {
                DTO_Person p = new DTO_Person(rs.getInt("PERSONID"), rs.getString("LASTNAME"), rs.getString("FIRSTNAME"), rs.getString("HIREDATE"), rs.getString("ENROLLMENTDATE"));
                persons.add(p);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return persons;
    }
}
