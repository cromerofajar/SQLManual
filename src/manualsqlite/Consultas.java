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
    public static ArrayList<Object[]> selectAll(String nombre){
        ArrayList <Object[]>parti=new ArrayList<>();

        String url = "jdbc:sqlite:/home/local/DANIELCASTELAO/cromerofajar/Actividades Programación/Manual/campeonato.db";
        Connection conne = null;
        try {
            conne = DriverManager.getConnection(url);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

        String sql = "SELECT ano, finalista1,finalista2,campeon FROM \""+nombre+"\"";

        
        try (Connection conn=conne;
             Statement stmt  = conn.createStatement();
             ResultSet rs    = stmt.executeQuery(sql)){
            
            // loop through the result set
            while (rs.next()) {
                Object[] base=new Object[4];
                base[0]=rs.getInt("ano");
                base[1]=rs.getString("finalista1");
                base[2]=rs.getString("finalista2");
                base[3]=rs.getString("campeon");
                parti.add(base);
                
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
        return parti;
    }
    public static ArrayList<Object[]> selectAll2(String nombre){
                ArrayList <Object[]>parti=new ArrayList<>();
        
        String url = "jdbc:sqlite:/home/local/DANIELCASTELAO/cromerofajar/Actividades Programación/Manual/campeonato.db";
        Connection conne = null;
        try {
            conne = DriverManager.getConnection(url);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

        String sql = "SELECT ano,mvp,usado FROM \""+nombre+"datos\"";

        
        try (Connection conn=conne;
             Statement stmt  = conn.createStatement();
             ResultSet rs    = stmt.executeQuery(sql)){
            
            // loop through the result set
            while (rs.next()) {
                Object[] base=new Object[3];
                base[0]=rs.getInt("ano");
                base[1]=rs.getString("mvp");
                base[2]=rs.getString("usado");
                parti.add(base);
                
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
        return parti;
    }
    public static DefaultTableModel blanco(){
        Navegar obx=new Navegar();
        DefaultTableModel blancos=(DefaultTableModel) obx.TablaDatosParti.getModel();
        blancos.setRowCount(0);
        return blancos;
    }
    public static DefaultTableModel blanco2(){
        Navegar obx=new Navegar();
        DefaultTableModel blancos=(DefaultTableModel) obx.TablaMVP.getModel();
        blancos.setRowCount(0);
        return blancos;
    }
    
    public static ArrayList<Object[]> selectFinal(String consulta){
        ArrayList <Object[]>parti=new ArrayList<>();
        String url = "jdbc:sqlite:/home/local/DANIELCASTELAO/cromerofajar/Actividades Programación/Manual/campeonato.db";
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
                Object[] base=new Object[4];
                base[0]=rs.getInt("ano");
                base[1]=rs.getString("finalista1");
                base[2]=rs.getString("finalista2");
                base[3]=rs.getString("campeon");
                parti.add(base);
                
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
        return parti;
    }
    public static ArrayList<Object[]> selectMVP(String consulta){
        ArrayList <Object[]>parti=new ArrayList<>();
        String url = "jdbc:sqlite:/home/local/DANIELCASTELAO/cromerofajar/Actividades Programación/Manual/campeonato.db";
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
                base[1]=rs.getString("mvp");
                base[2]=rs.getString("usado");
                parti.add(base);
                
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
        return parti;
    }
    
    public static ArrayList<Object[]> selectAnoMV(int ano,String nombre){

        ArrayList <Object[]>mv=new ArrayList<>();
        String url = "jdbc:sqlite:/home/local/DANIELCASTELAO/cromerofajar/Actividades Programación/Manual/campeonato.db";
        String sql= "SELECT ano,mvp,usado FROM "+nombre+"datos WHERE ano=";
        sql=sql+ano;

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
                base[1]=rs.getString("mvp");
                base[2]=rs.getString("usado");
                mv.add(base);
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
        return mv;
    }
    public static ArrayList<Object[]> selectAnoParti(int ano,String nombre){
        ArrayList <Object[]>parti=new ArrayList<>();
        String url = "jdbc:sqlite:/home/local/DANIELCASTELAO/cromerofajar/Actividades Programación/Manual/campeonato.db";
        String sql= "SELECT ano,finalista1,finalista2,campeon FROM "+nombre+" WHERE ano=";
        sql=sql+ano;

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
                Object[] base=new Object[4];
                base[0]=rs.getInt("ano");
                base[1]=rs.getString("finalista1");
                base[2]=rs.getString("finalista2");
                base[3]=rs.getString("campeon");
                parti.add(base);
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
        return parti;
    }

}

