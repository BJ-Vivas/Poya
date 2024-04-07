/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author User
 */
public class UserDAO {
    
   public String Fname, Mname, Lname, Gender, Rank, Address, Element, Level;
   int Age, Number, iddatas;
   
   public String getFname(){
       return Fname;
   }
   public void setFname(String Fname){
       this.Fname = Fname;
   }
   
   public String getMname(){
       return Mname;
   }
   public void setMname(String Mname){
       this.Mname = Mname;
   }
   
   public String getLname(){
       return Lname;
   }
   public void setLname(String Lname){
       this.Lname = Lname;
   }
   
   public String getGender(){
       return Gender;
   }
   public void setGender(String Gender){
       this.Gender = Gender;
   }
   
   public String getRank(){
       return Rank;
   }
   public void setRank(String Rank){
       this.Rank = Rank;
   }
   
   public String getAddress(){
       return Address;
   }
   public void setAddress(String Address){
       this.Address = Address;
   }
   
   public String getElement(){
       return Element;
   }
   public void setElement(String Element){
       this.Element = Element;
   }
   
   public String getLevel(){
       return Level;
   }
   public void setLevel(String Level){
       this.Level = Level;
   }
   
   public int getAge(){
       return Age;
   }
   public void setAge(int Age){
       this.Age = Age;
   }
   
   public int getNumber(){
       return Number;
   }
   public void setNumber(int Number){
       this.Number = Number;
   }
   
   public int getiddtas(){
       return iddatas;
   }
   public void setiddatas(int iddatas){
       this.iddatas = iddatas;
   }
}
