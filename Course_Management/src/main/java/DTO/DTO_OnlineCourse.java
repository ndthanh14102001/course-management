/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DTO;

/**
 *
 * @author Duc Anh
 */
public class DTO_OnlineCourse extends DTO_Course {

    String URL;

    public DTO_OnlineCourse() {
    }

    public DTO_OnlineCourse(int COURSEID, String TITLE, String CREDITS, int DEPARTMENTID, String URL) {
        super(COURSEID, TITLE, CREDITS, DEPARTMENTID);
        this.URL = URL;
    }

    public String getURL() {
        return URL;
    }

    public int getCOURSEID() {
        return COURSEID;
    }

    public String getTITLE() {
        return TITLE;
    }

    public String getCREDITS() {
        return CREDITS;
    }

    public int getDEPARTMENTID() {
        return DEPARTMENTID;
    }

    public void setURL(String URL) {
        this.URL = URL;
    }

    public void setCOURSEID(int COURSEID) {
        this.COURSEID = COURSEID;
    }

    public void setTITLE(String TITLE) {
        this.TITLE = TITLE;
    }

    public void setCREDITS(String CREDITS) {
        this.CREDITS = CREDITS;
    }

    public void setDEPARTMENTID(int DEPARTMENTID) {
        this.DEPARTMENTID = DEPARTMENTID;
    }

}
