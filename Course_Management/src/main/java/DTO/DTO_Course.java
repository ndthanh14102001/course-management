/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DTO;

/**
 *
 * @author Duc Anh
 */
public class DTO_Course {
    int COURSEID;
    String TITLE, CREDITS;
    int DEPARTMENTID;

    public DTO_Course() {
    }

    public DTO_Course(int COURSEID, String TITLE, String CREDITS, int DEPARTMENTID) {
        this.COURSEID = COURSEID;
        this.TITLE = TITLE;
        this.CREDITS = CREDITS;
        this.DEPARTMENTID = DEPARTMENTID;
    }

    public int getCOURSEID() {
        return COURSEID;
    }

    public void setCOURSEID(int COURSEID) {
        this.COURSEID = COURSEID;
    }

    public String getTITLE() {
        return TITLE;
    }

    public void setTITLE(String TITLE) {
        this.TITLE = TITLE;
    }

    public String getCREDITS() {
        return CREDITS;
    }

    public void setCREDITS(String CREDITS) {
        this.CREDITS = CREDITS;
    }

    public int getDEPARTMENTID() {
        return DEPARTMENTID;
    }

    public void setDEPARTMENTID(int DEPARTMENTID) {
        this.DEPARTMENTID = DEPARTMENTID;
    }
    
}
