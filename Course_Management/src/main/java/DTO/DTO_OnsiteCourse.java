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
public class DTO_OnsiteCourse {
    String COURSEID, LOCATION;
    Date DATES;
    Time TIMES;
    
    public DTO_OnsiteCourse(String COURSEID, String LOCATION, Date DATES, Time TIMES) {
        this.COURSEID = COURSEID;
        this.LOCATION = LOCATION;
        this.DATES = DATES;
        this.TIMES = TIMES;
    }

    public DTO_OnsiteCourse() {
    }

    public String getCOURSEID() {
        return COURSEID;
    }

    public void setCOURSEID(String COURSEID) {
        this.COURSEID = COURSEID;
    }

    public String getLOCATION() {
        return LOCATION;
    }

    public void setLOCATION(String LOCATION) {
        this.LOCATION = LOCATION;
    }

    public Date getDATES() {
        return DATES;
    }

    public void setDATES(Date DATES) {
        this.DATES = DATES;
    }

    public Time getTIMES() {
        return TIMES;
    }

    public void setTIMES(Time TIMES) {
        this.TIMES = TIMES;
    }

}
