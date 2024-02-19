/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package GUI;

import java.sql.SQLException;
import java.util.ArrayList;
import DAO.DAO_Department;
import DTO.DTO_Department;
/**
 *
 * @author Đức Anh
 */
public class GUI_Department {

    public static void main(String[] args) {
        GUI_ManageDepartment Department = new GUI_ManageDepartment();
        Department.setLocationRelativeTo(null);
        Department.setVisible(true);
    }
    
    public static void listDepartment() throws SQLException
    {
        DAO_Department department = new DAO_Department();
        ArrayList list = department.ReadDepartment();
        for(int i=0; i< list.size(); i++)
        {
            DTO_Department dtoDepartment = (DTO_Department)list.get(i);
            System.out.println(dtoDepartment.getID() + " " + dtoDepartment.getNAME() + " " + dtoDepartment.getBUDGET() + " " + dtoDepartment.getSTARTDATE() + " " + dtoDepartment.getADMINISTRATOR());
        }
    }
}
