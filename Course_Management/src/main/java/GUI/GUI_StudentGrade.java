/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package GUI;

import DAO.DAO_StudentGrade;
import DTO.DTO_StudentGrade;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author Đức Anh
 */
public class GUI_StudentGrade {

    public static void main(String[] args) {
        GUI_ManageStudentGrade StudentGrade = new GUI_ManageStudentGrade();
        StudentGrade.setLocationRelativeTo(null);
        StudentGrade.setVisible(true);
    }
    
    public static void listStudentGrade() throws SQLException {
        DAO_StudentGrade studentgrade = new DAO_StudentGrade();
        ArrayList list = studentgrade.ReadStudentGrade();
        for(int i=0; i< list.size(); i++)
        {
            DTO_StudentGrade dtoStudentGrade = (DTO_StudentGrade)list.get(i);
            System.out.println(dtoStudentGrade.getENROLLMENTID() + " " + dtoStudentGrade.getCOURSEID() + " " + dtoStudentGrade.getSTUDENTID() + " " + dtoStudentGrade.getGRADE() + " ");
        }
    }
}
