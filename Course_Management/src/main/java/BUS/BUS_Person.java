/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BUS;
import DAO.DAO_Person;
import DTO.DTO_Person;
import java.util.List;
/**
 *
 * @author Paul
 */
public class BUS_Person {
    private DAO_Person persondal;
    public BUS_Person(){};
    public void Add(DTO_Person p){
        persondal = new DAO_Person();
        persondal.Add(p);
    } 
    public void Update(DTO_Person p, String id){
        persondal = new DAO_Person();
        persondal.Update(p, id);
    } 
    public void Delete(String id){
        persondal = new DAO_Person();
        persondal.Delete(id);
    } 
    public List<DTO_Person> Show(){
        persondal = new DAO_Person();
        return persondal.Show();
    }
    public List<DTO_Person> Search(String id){
        persondal = new DAO_Person();
        return persondal.Search(id);
    }
}
