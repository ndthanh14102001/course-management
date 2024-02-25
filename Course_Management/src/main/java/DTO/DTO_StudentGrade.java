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
public class DTO_StudentGrade extends DTO_Person {

    int ENROLLMENTID, STUDENTID, GRADE, COURSEID;

    public DTO_StudentGrade(int ENROLLMENTID, int STUDENTID, int GRADE, int id, String last_name, String first_name, Date hire_date, Date enrollment_date) {
        super(id, last_name, first_name, hire_date, enrollment_date);
        this.ENROLLMENTID = ENROLLMENTID;
        this.STUDENTID = STUDENTID;
        this.GRADE = GRADE;
    }

    public DTO_StudentGrade(int ENROLLMENTID, int STUDENTID, int GRADE, String last_name, String first_name, Date hire_date, Date enrollment_date) {
        super(last_name, first_name, hire_date, enrollment_date);
        this.ENROLLMENTID = ENROLLMENTID;
        this.STUDENTID = STUDENTID;
        this.GRADE = GRADE;
    }

    public DTO_StudentGrade() {
        super(null, null, null, null);
    }

    public int getENROLLMENTID() {
        return ENROLLMENTID;
    }

    public int getSTUDENTID() {
        return STUDENTID;
    }

    public int getGRADE() {
        return GRADE;
    }

    public int getCOURSEID() {
        return COURSEID;
    }

    public void setCOURSEID(int COURSEID) {
        this.COURSEID = COURSEID;
    }

    public void setENROLLMENTID(int ENROLLMENTID) {
        this.ENROLLMENTID = ENROLLMENTID;
    }

    public void setSTUDENTID(int STUDENTID) {
        this.STUDENTID = STUDENTID;
    }

    public void setGRADE(int GRADE) {
        this.GRADE = GRADE;
    }


}
