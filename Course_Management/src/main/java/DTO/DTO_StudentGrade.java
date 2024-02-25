/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DTO;

/**
 *
 * @author Duc Anh
 */
public class DTO_StudentGrade {
    String ENROLLMENTID, COURSEID, STUDENTID;
    int GRADE;

    public DTO_StudentGrade() {
    }

    public DTO_StudentGrade(String ENROLLMENTID, String COURSEID, String STUDENTID, int GRADE) {
        this.ENROLLMENTID = ENROLLMENTID;
        this.COURSEID = COURSEID;
        this.STUDENTID = STUDENTID;
        this.GRADE = GRADE;
    }

    public String getENROLLMENTID() {
        return ENROLLMENTID;
    }

    public void setENROLLMENTID(String ENROLLMENTID) {
        this.ENROLLMENTID = ENROLLMENTID;
    }

    public String getCOURSEID() {
        return COURSEID;
    }

    public void setCOURSEID(String COURSEID) {
        this.COURSEID = COURSEID;
    }

    public String getSTUDENTID() {
        return STUDENTID;
    }

    public void setSTUDENTID(String STUDENTID) {
        this.STUDENTID = STUDENTID;
    }

    public int getGRADE() {
        return GRADE;
    }

    public void setGRADE(int GRADE) {
        this.GRADE = GRADE;
    }
    
}
