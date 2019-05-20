/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package manualsqlite;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author cromerofajar
 */
public class Consultas {


    
    /**
     * select all rows in the warehouses table
     */
    public static ArrayList<Object[]> selectAll(){
        ArrayList <Object[]>presi=new ArrayList<>();
        String nombre=JOptionPane.showInputDialog(null,"De que tabla desea mostrar los datos");
        String url = "jdbc:sqlite:/home/local/DANIELCASTELAO/cromerofajar/Actividades Programación/Manual/test.db";
        Connection conne = null;
        try {
            conne = DriverManager.getConnection(url);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

        String sql = "SELECT ano, presidente,partido FROM \""+nombre+"\"";

        
        try (Connection conn=conne;
             Statement stmt  = conn.createStatement();
             ResultSet rs    = stmt.executeQuery(sql)){
            
            // loop through the result set
            while (rs.next()) {
                Object[] base=new Object[3];
                base[0]=rs.getInt("ano");
                base[1]=rs.getString("presidente");
                base[2]=rs.getString("partido");
                presi.add(base);
                
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        finally{
            try {
                conne.close();
            } catch (SQLException ex) {
                Logger.getLogger(Consultas.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return presi;
    }
    public static DefaultTableModel blanco(){
        Navegar obx=new Navegar();
        DefaultTableModel blancos=(DefaultTableModel) obx.TablaDatos.getModel();
        blancos.setRowCount(0);
        return blancos;
    }
    
    public static ArrayList<Object[]> select(String consulta){
        ArrayList <Object[]>presi=new ArrayList<>();
        String url = "jdbc:sqlite:/home/local/DANIELCASTELAO/cromerofajar/Actividades Programación/Manual/test.db";
        String sql= consulta;
        Connection conne = null;
        
        try {
            conne = DriverManager.getConnection(url);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        
        try (Connection conn=conne;
             Statement stmt  = conn.createStatement();
             ResultSet rs    = stmt.executeQuery(sql)){
            
        while (rs.next()) {
                Object[] base=new Object[3];
                base[0]=rs.getInt("ano");
                base[1]=rs.getString("presidente");
                base[2]=rs.getString("partido");
                presi.add(base);
                
        }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        finally{
            try {
                conne.close();
            } catch (SQLException ex) {
                Logger.getLogger(Consultas.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return presi;
    }
}

