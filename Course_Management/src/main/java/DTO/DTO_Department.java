/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DTO;

//import java.sql.Date;
import java.util.Date;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;

/**
 *
 * @author Duc Anh
 */
public class DTO_Department {

    int DEPARTMENTID;
    String NAME, ADMINISTRATOR;
    Double BUDGET;
    Date STARTDATE;

    public DTO_Department() {
    }

    public DTO_Department(int DEPARTMENTID, String NAME, String ADMINISTRATOR, Double BUDGET, Date STARTDATE) {
        this.DEPARTMENTID = DEPARTMENTID;
        this.NAME = NAME;
        this.ADMINISTRATOR = ADMINISTRATOR;
        this.BUDGET = BUDGET;
        this.STARTDATE = STARTDATE;
    }

    public int getID() {
        return DEPARTMENTID;
    }

    public void setID(int DEPARTMENTID) {
        this.DEPARTMENTID = DEPARTMENTID;
    }

    public String getNAME() {
        return NAME;
    }

    public void setNAME(String NAME) {
        this.NAME = NAME;
    }

    public String getADMINISTRATOR() {
        return ADMINISTRATOR;
    }

    public void setADMINISTRATOR(String ADMINISTRATOR) {
        this.ADMINISTRATOR = ADMINISTRATOR;
    }

    public Double getBUDGET() {
        return BUDGET;
    }

    public void setBUDGET(Double BUDGET) {
        this.BUDGET = BUDGET;
    }

    public Date getSTARTDATE() {
        return STARTDATE;
    }

    public String getSTARTDATEString() {
        try {
            SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyy");
            return sdf.format(STARTDATE);
        } catch (Exception e) {
            return "";
        }
    }

    public void setSTARTDATE(Date STARTDATE) {
        this.STARTDATE = STARTDATE;
    }

}
