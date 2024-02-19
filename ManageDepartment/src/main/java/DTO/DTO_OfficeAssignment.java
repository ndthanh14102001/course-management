/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DTO;

import java.sql.Date;

/**
 *
 * @author Duc Anh
 */
public class DTO_OfficeAssignment {
    String INSTRUCTOR, LOCATION;
    Date TIMESTAMP;

    public DTO_OfficeAssignment() {
    }

    public DTO_OfficeAssignment(String INSTRUCTOR, String LOCATION, Date TIMESTAMP) {
        this.INSTRUCTOR = INSTRUCTOR;
        this.LOCATION = LOCATION;
        this.TIMESTAMP = TIMESTAMP;
    }

    public String getINSTRUCTOR() {
        return INSTRUCTOR;
    }

    public void setINSTRUCTOR(String INSTRUCTOR) {
        this.INSTRUCTOR = INSTRUCTOR;
    }

    public String getLOCATION() {
        return LOCATION;
    }

    public void setLOCATION(String LOCATION) {
        this.LOCATION = LOCATION;
    }

    public Date getTIMESTAMP() {
        return TIMESTAMP;
    }

    public void setTIMESTAMP(Date TIMESTAMP) {
        this.TIMESTAMP = TIMESTAMP;
    }
    
}
