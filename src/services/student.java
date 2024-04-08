/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import jdbc.JDBCConnector;
import model.UserDAO;

/**
 *
 * @author User
 */
public class student {
    private Connection connection;
    private JDBCConnector jdbccon;
    private PreparedStatement ps;
    private String sql;
    private ResultSet rs;
    private ResultSetMetaData rm;
//    private JTable table;
//   private DefaultTableModel tableModel;
    
    public student(){
       
        this.jdbccon = new JDBCConnector();
        this.connection = new JDBCConnector().getConnection();
//        table = new JTable();
//        tableModel = new DefaultTableModel();
//        table.setModel(tableModel);
    }

public void addStudent (UserDAO userdao){

    try {

         sql = "INSERT into datas (Fname, Mname, Lname, Gender, Ranking, Address, Element, Level, Age, Number) values (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
            ps = connection.prepareStatement(sql);
            ps.setString(1, userdao.getFname());
            ps.setString(2, userdao.getMname());
            ps.setString(3, userdao.getLname());
            ps.setString(4, userdao.getGender());
            ps.setString(5, userdao.getRank());
            ps.setString(6, userdao.getAddress());
            ps.setString(7, userdao.getElement());
            ps.setString(8, userdao.getLevel());
            ps.setInt(9, userdao.getAge()); 
            ps.setInt(10, userdao.getNumber()); 
            
            int result = ps.executeUpdate();
            
            if (result > 0){
                JOptionPane.showMessageDialog(null, "Student Sucessfully Added");
                
            } else {
                JOptionPane.showMessageDialog(null, "Failed to Add Student");
            }  
        } catch (Exception e) {
            Logger.getLogger(student.class.getName()).log(Level.SEVERE, null, e);
            
        } finally {
        
        try {
            if (ps != null) {
                ps.close();
            }
        } catch (SQLException ex) {
            Logger.getLogger(student.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
   }

public void populatetable (DefaultTableModel model){
       
        try {
            model.setRowCount(0);
            sql = "SELECT * FROM datas";
            ps = connection.prepareStatement(sql);
            rs = ps.executeQuery();
            rm = rs.getMetaData();
            int columncount = rm.getColumnCount();
            
            while (rs.next()){
                
                Object[] row = new Object[columncount];
                
                for (int i = 1; i <= columncount; i++){
                    row [i-1] = rs.getObject(i);
                }
                model.addRow(row);    
            }
            
        } catch (Exception e){
            e.printStackTrace();
        }     
    }

public void refreshTable(DefaultTableModel model) {
     
    try {
            model.setRowCount(0);
            sql = "SELECT * FROM datas";
            ps = connection.prepareStatement(sql);
            rs = ps.executeQuery();
            
            while (rs.next()) {
            Object[] rowData = {
                rs.getInt("iddatas"),
                rs.getString("Fname"),
                rs.getString("Mname"),
                rs.getString("Lname"),
                rs.getString("Gender"),
                rs.getString("Ranking"),
                rs.getString("Address"),
                rs.getString("Element"),
                rs.getString("Level"),
                rs.getInt("Age"),
                rs.getInt("Number")
            };
            model.addRow(rowData);
        } 
        rs.close();
        ps.close(); 
        } catch (Exception e){
            e.printStackTrace();
   } 
}

public void delete  (int iddatas) throws SQLException{
    
        try {
            sql = "DELETE FROM datas WHERE iddatas=?";
            ps = connection.prepareStatement(sql);
            ps.setInt(1, iddatas);
            ps.execute();
            
            JOptionPane.showMessageDialog(null, "User successfully deleted");
        } catch (SQLException e) {
            
            Logger.getLogger(student.class.getName()).log(Level.SEVERE, null, e);
            
            JOptionPane.showMessageDialog(null, "Failed to delete User");
        }
}    

public void update ( UserDAO userdao, int iddatas){
     try {
        sql = "UPDATE datas SET Fname=?, Mname=?, Lname=?, Gender=?, Ranking=?, Address=?, Element=?, Level=?, Age=?, Number=? WHERE iddatas=?";
            ps = connection.prepareStatement(sql);
            ps.setString(1, userdao.getFname());
            ps.setString(2, userdao.getMname());
            ps.setString(3, userdao.getLname());
            ps.setString(4, userdao.getGender());
            ps.setString(5, userdao.getRank());
            ps.setString(6, userdao.getAddress());
            ps.setString(7, userdao.getElement());
            ps.setString(8, userdao.getLevel());
            ps.setInt(9, userdao.getAge()); 
            ps.setInt(10, userdao.getNumber()); 
            ps.setInt(11, iddatas);
            
            int result = ps.executeUpdate();
            
            if (result > 0) {
            JOptionPane.showMessageDialog(null, "Successfully Updated");
            
             } else {
            JOptionPane.showMessageDialog(null, "Failed to Update");
        }
     } catch (Exception e) {
         Logger.getLogger(student.class.getName()).log(Level.SEVERE, null, e);
     }
 }

public void search (UserDAO userdao, String searchtext) throws SQLException{
    try {
        
        sql = ("SELECT * FROM datas WHERE iddatas=?");
        ps = connection.prepareStatement (sql);
        
        ps.setInt(1,userdao.getiddtas());
        
        rs = ps.executeQuery();
        
        while (rs.next()) {
            
            int id = rs.getInt("iddatas");
            String name = rs.getString("Fname");
           
        }
        rs.close();
        ps.close();
    }catch (Exception e) {
         Logger.getLogger(student.class.getName()).log(Level.SEVERE, null, e);
     }
    }
}


