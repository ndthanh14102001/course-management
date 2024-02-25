/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DTO;

import java.sql.Date;
import java.sql.Time;

/**
 *
 * @author Duc Anh
 */
public class DTO_Course {

    int COURSEID, DEPARTMENTID;
    String TITLE, CREDITS;
    String URL,LOCATION;
    Date date;
    Time time;

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

    public String getURL() {
        return URL;
    }

    public String getLOCATION() {
        return LOCATION;
    }

    public Date getDate() {
        return date;
    }

    public Time getTime() {
        return time;
    }

    public void setURL(String URL) {
        this.URL = URL;
    }

    public void setLOCATION(String LOCATION) {
        this.LOCATION = LOCATION;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public void setTime(Time time) {
        this.time = time;
    }

}
