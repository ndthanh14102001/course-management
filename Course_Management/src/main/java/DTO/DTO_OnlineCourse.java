/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DTO;

/**
 *
 * @author Duc Anh
 */
public class DTO_OnlineCourse {
    String COURSEID, URL;

    public DTO_OnlineCourse() {
    }

    public DTO_OnlineCourse(String COURSEID, String URL) {
        this.COURSEID = COURSEID;
        this.URL = URL;
    }

    public String getCOURSEID() {
        return COURSEID;
    }

    public void setCOURSEID(String COURSEID) {
        this.COURSEID = COURSEID;
    }

    public String getURL() {
        return URL;
    }

    public void setURL(String URL) {
        this.URL = URL;
    }
    
}
