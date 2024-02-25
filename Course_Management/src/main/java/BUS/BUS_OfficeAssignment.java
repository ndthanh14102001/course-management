/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BUS;

import DAO.DAO_OfficeAssignment;
import DTO.DTO_OfficeAssignment;
import DTO.DTO_Person;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author Duc Anh
 */
public class BUS_OfficeAssignment {

    public List<DTO_OfficeAssignment> getAll() {
        return new DAO_OfficeAssignment().getAll();
    }

    public int add(DTO_OfficeAssignment officeAssignment) throws SQLException {
        return new DAO_OfficeAssignment().add(officeAssignment);
    }

    public int update(DTO_OfficeAssignment officeAssignment) throws SQLException {
        return new DAO_OfficeAssignment().update(officeAssignment);
    }

    public int delete(int instructorId) throws SQLException {
        return new DAO_OfficeAssignment().delete(instructorId);
    }

    public List<DTO_Person> getAllInstructorsWithoutOffice() {
        return new DAO_OfficeAssignment().getAllInstructorsWithoutOffice();
    }

}
