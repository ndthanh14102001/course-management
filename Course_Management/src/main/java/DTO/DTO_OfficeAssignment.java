/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DTO;

import java.sql.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

/**
 *
 * @author Duc Anh
 */
public class DTO_OfficeAssignment extends DTO_Person {

    String LOCATION;
    Date TIMESTAMP;

    public DTO_OfficeAssignment() {
        super(null, null, null, null);
    }

    public DTO_OfficeAssignment(String LOCATION, Date TIMESTAMP, int id, String last_name, String first_name, String hire_date, String enrollment_date) {
        super(id, last_name, first_name, hire_date, enrollment_date);
        this.LOCATION = LOCATION;
        this.TIMESTAMP = TIMESTAMP;
    }

    public DTO_OfficeAssignment(String LOCATION, Date TIMESTAMP, String last_name, String first_name, String hire_date, String enrollment_date) {
        super(last_name, first_name, hire_date, enrollment_date);
        this.LOCATION = LOCATION;
        this.TIMESTAMP = TIMESTAMP;
    }

    public String getLOCATION() {
        return LOCATION;
    }

    public Date getTIMESTAMP() {
        return TIMESTAMP;
    }
    

    public void setLOCATION(String LOCATION) {
        this.LOCATION = LOCATION;
    }

    public void setTIMESTAMP(Date TIMESTAMP) {
        this.TIMESTAMP = TIMESTAMP;
    }
}
