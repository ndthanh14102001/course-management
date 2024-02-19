/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DTO;

/**
 *
 * @author Duc Anh
 */
public class DTO_CourseInstructor {
    String COURSEID, PERSONID;

    public DTO_CourseInstructor() {
    }

    public DTO_CourseInstructor(String COURSEID, String PERSONID) {
        this.COURSEID = COURSEID;
        this.PERSONID = PERSONID;
    }

    public String getCOURSEID() {
        return COURSEID;
    }

    public void setCOURSEID(String COURSEID) {
        this.COURSEID = COURSEID;
    }

    public String getPERSONID() {
        return PERSONID;
    }

    public void setPERSONID(String PERSONID) {
        this.PERSONID = PERSONID;
    }
    
}
