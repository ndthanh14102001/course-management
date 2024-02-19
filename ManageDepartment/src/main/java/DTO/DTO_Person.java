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
public class DTO_Person {
    String PERSONID, FIRSTNAME, LASTNAME;
    Date HIREDATE, ENROLLMENTDATE;

    public DTO_Person() {
    }

    public DTO_Person(String PERSONID, String FIRSTNAME, String LASTNAME, Date HIREDATE, Date ENROLLMENTDATE) {
        this.PERSONID = PERSONID;
        this.FIRSTNAME = FIRSTNAME;
        this.LASTNAME = LASTNAME;
        this.HIREDATE = HIREDATE;
        this.ENROLLMENTDATE = ENROLLMENTDATE;
    }

    public String getPERSONID() {
        return PERSONID;
    }

    public void setPERSONID(String PERSONID) {
        this.PERSONID = PERSONID;
    }

    public String getFIRSTNAME() {
        return FIRSTNAME;
    }

    public void setFIRSTNAME(String FIRSTNAME) {
        this.FIRSTNAME = FIRSTNAME;
    }

    public String getLASTNAME() {
        return LASTNAME;
    }

    public void setLASTNAME(String LASTNAME) {
        this.LASTNAME = LASTNAME;
    }

    public Date getHIREDATE() {
        return HIREDATE;
    }

    public void setHIREDATE(Date HIREDATE) {
        this.HIREDATE = HIREDATE;
    }

    public Date getENROLLMENTDATE() {
        return ENROLLMENTDATE;
    }

    public void setENROLLMENTDATE(Date ENROLLMENTDATE) {
        this.ENROLLMENTDATE = ENROLLMENTDATE;
    }
    
}
