/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DTO;

import java.sql.Date;
import java.sql.Time;
import java.text.SimpleDateFormat;

/**
 *
 * @author Duc Anh
 */
public class DTO_Course {
    int COURSEID, DEPARTMENTID;
    String TITLE, CREDITS;
    String URL, LOCATION;
    String days;
    Time time;
    DTO_Department department;

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

    public String getDays() {
        return days;
    }

    public Time getTime() {
        return time;
    }

    public String getTimeString() {
        try {
            SimpleDateFormat sdf = new SimpleDateFormat("HH:mm");
            return sdf.format(new Date(time.getTime()));
        } catch (Exception e) {
            return "";
        }
    }

    public void setURL(String URL) {
        this.URL = URL;
    }

    public void setLOCATION(String LOCATION) {
        this.LOCATION = LOCATION;
    }

    public void setTime(Time time) {
        this.time = time;
    }

    public DTO_Department getDepartment() {
        return department;
    }

    public void setDepartment(DTO_Department department) {
        this.department = department;
    }

    public void setDays(String days) {
        this.days = days;
    }
}
