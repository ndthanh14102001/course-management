/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BUS;

import DAO.DAO_Course;
import DTO.DTO_Course;
import java.util.List;

/**
 *
 * @author Duc Anh
 */
public class BUS_Course {

    public List<DTO_Course> getAll() {
        return new DAO_Course().getAll();
    }
}
