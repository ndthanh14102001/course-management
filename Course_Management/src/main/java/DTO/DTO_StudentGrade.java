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
    int ENROLLMENTID, COURSEID, STUDENTID, GRADE;

    public DTO_StudentGrade() {
    }

    public DTO_StudentGrade(int ENROLLMENTID, int COURSEID, int STUDENTID, int GRADE) {
        this.ENROLLMENTID = ENROLLMENTID;
        this.COURSEID = COURSEID;
        this.STUDENTID = STUDENTID;
        this.GRADE = GRADE;
    }

    public int getENROLLMENTID() {
        return ENROLLMENTID;
    }

    public void setENROLLMENTID(int ENROLLMENTID) {
        this.ENROLLMENTID = ENROLLMENTID;
    }

    public int getCOURSEID() {
        return COURSEID;
    }

    public void setCOURSEID(int COURSEID) {
        this.COURSEID = COURSEID;
    }

    public int getSTUDENTID() {
        return STUDENTID;
    }

    public void setSTUDENTID(int STUDENTID) {
        this.STUDENTID = STUDENTID;
    }

    public int getGRADE() {
        return GRADE;
    }

    public void setGRADE(int GRADE) {
        this.GRADE = GRADE;
    }

    public void setID(int aInt) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
}
