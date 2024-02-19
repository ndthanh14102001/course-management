/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DTO;

/**
 *
 * @author Paul
 */
public class DTO_Person {
    private String id, last_name, first_name, hire_date, enrollment_date;

    public DTO_Person(String id, String last_name, String first_name, String hire_date, String enrollment_date) {
        this.id = id;
        this.last_name = last_name;
        this.first_name = first_name;
        this.hire_date = hire_date;
        this.enrollment_date = enrollment_date;
    }
    
    public DTO_Person(String last_name, String first_name, String hire_date, String enrollment_date) {
        this.last_name = last_name;
        this.first_name = first_name;
        this.hire_date = hire_date;
        this.enrollment_date = enrollment_date;
    }

    public String getId() {
        return id;
    }

    public String getLast_name() {
        return last_name;
    }

    public String getFirst_name() {
        return first_name;
    }

    public String getHire_date() {
        String[] hire = hire_date.split("-", 0);
        String res = hire[2]+"-"+hire[1]+"-"+hire[0];   //Chuyển về đúng định dạng
        return res;
    }

    public String getEnrollment_date() {
        String[] enrollment = enrollment_date.split("-", 0);
        String res = enrollment[2]+"-"+enrollment[1]+"-"+enrollment[0];
        return res;
    }
    
}
