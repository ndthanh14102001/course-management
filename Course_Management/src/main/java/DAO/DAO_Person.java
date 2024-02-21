/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;
import DTO.DTO_Person;
import Services.ConnectDB;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
/**
 *
 * @author Paul
 */
public class DAO_Person {
    private Connection conn;
    private List persons;
    public DAO_Person(){
        ConnectDB.connectDB();
        //ConnectDB ms = new ConnectDB();
        conn = ConnectDB.getConnection();
    }
    public void Add(DTO_Person p){
        try{
            Statement stmt = conn.createStatement();
            String sql = "INSERT INTO PERSON (LASTNAME, FIRSTNAME, HIREDATE, ENROLLMENTDATE) VALUES ('"+p.getLast_name()+"', '"+p.getFirst_name()+"', '"+p.getHire_date()+"','"+p.getEnrollment_date()+"')";
            stmt.executeUpdate(sql);
            
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    
    public void Update(DTO_Person p, String id){
        try{
            Statement stmt = conn.createStatement();
            String sql = "UPDATE PERSON SET LASTNAME='"+p.getLast_name()+"', FIRSTNAME='"+p.getFirst_name()+"', HIREDATE='"+p.getHire_date()+"', ENROLLMENTDATE='"+p.getEnrollment_date()+"' WHERE PERSONID='"+id+"'";
            stmt.executeUpdate(sql);
            
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    
    public void Delete(String id){
        try{
            Statement stmt = conn.createStatement();
            String sql = "DELETE FROM PERSON WHERE PERSONID = '"+id+"'";
            stmt.executeUpdate(sql);
            
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    
    public List<DTO_Person>Show(){
        persons = new ArrayList<DTO_Person>();
        try{	
         Statement stmt = conn.createStatement();
         ResultSet rs = stmt.executeQuery("Select * From Person");   
         while(rs.next()){
            DTO_Person p = new DTO_Person(rs.getInt("PERSONID"),rs.getString("LASTNAME"),rs.getString("FIRSTNAME"), rs.getString("HIREDATE"), rs.getString("ENROLLMENTDATE") );
            persons.add(p);
         }
      } catch (Exception e) {
         e.printStackTrace();
      } 
      return persons;  
    }
    
    public List<DTO_Person> Search(String id){
        persons = new ArrayList<DTO_Person>();
        try{	
         Statement stmt = conn.createStatement();
         ResultSet rs = stmt.executeQuery("Select * From Person Where PERSONID='"+id+"'");
         while(rs.next()){
            DTO_Person p = new DTO_Person(rs.getInt("PERSONID"),rs.getString("LASTNAME"),rs.getString("FIRSTNAME"), rs.getString("HIREDATE"), rs.getString("ENROLLMENTDATE") );
            persons.add(p);
         }
        }catch (Exception e) {
            e.printStackTrace();
        } 
        return persons;
    }
}
