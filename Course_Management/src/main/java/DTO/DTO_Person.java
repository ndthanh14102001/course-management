/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DTO;

import java.sql.Date;
import java.text.SimpleDateFormat;

/**
 *
 * @author Paul
 */
public class DTO_Person {

    private int id;
    private String last_name, first_name;
    private Date hire_date, enrollment_date;
    private int courseCount;

    public DTO_Person() {
    }

    public DTO_Person(int id, String last_name, String first_name, Date hire_date, Date enrollment_date) {
        this.id = id;
        this.last_name = last_name;
        this.first_name = first_name;
        this.hire_date = hire_date;
        this.enrollment_date = enrollment_date;

    }

    public DTO_Person(String last_name, String first_name, Date hire_date, Date enrollment_date) {
        this.last_name = last_name;
        this.first_name = first_name;
        this.hire_date = hire_date;
        this.enrollment_date = enrollment_date;

    }

    public int getId() {
        return id;
    }

    public String getLast_name() {
        return last_name;
    }

    public String getFirst_name() {
        return first_name;
    }

    public Date getHire_date() {
        return hire_date;
    }

    public Date getEnrollment_date() {
        return enrollment_date;
    }

    public String getHireDateString() {
        SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyy");
        return sdf.format(hire_date);
    }

    public String getEnrollmentString() {
        SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyy");
        return sdf.format(enrollment_date);
    }

    public void setCourseCount(int courseCount) {
        this.courseCount = courseCount;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public void setHire_date(Date hire_date) {
        this.hire_date = hire_date;
    }

    public void setEnrollment_date(Date enrollment_date) {
        this.enrollment_date = enrollment_date;
    }

    public String getName() {
        return this.last_name + " " + this.first_name;
    }

    public int getCourseCount() {
        return courseCount;
    }
}
