/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BUS;

import DAO.DAO_Department;
import DTO.DTO_Department;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Duc Anh
 */
public class BUS_Department {
    public DAO_Department daoDepartment = new DAO_Department();
    public DTO_Department dtoDepartment = new DTO_Department();
    public List LoadDepartment(int page) throws SQLException
    {
        int numOfRecords = 30;
        
        ArrayList list = daoDepartment.ReadDepartment();
        int size = list.size();
        int from, to;
        from = (page-1)*numOfRecords;
        to = page*numOfRecords;
        return list.subList(from, Math.min(to, size));
    }
    
    public int AddDepartment(DTO_Department dtoDepartment) throws SQLException {
        int result = daoDepartment.AddDepartment(dtoDepartment);
        return result;
    }
    
    public int EditDepartment(DTO_Department dtoDepartment) throws SQLException {
        int result = daoDepartment.EditDepartment(dtoDepartment);
        return result;
    }
    
    public int DeleteDepartment(String departmentId) throws SQLException {
        int result = daoDepartment.DeleteDepartment(departmentId);
        return result;
    }
    
    public List FindDepartment(String searchInput) throws SQLException {
        List list = new ArrayList();

        list = daoDepartment.FindDepartment(searchInput);

        return list;

    }
    
}
