/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package manualsqlite;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author cromerofajar
 */
public class Insertar {
     
    public static int insert() {
        /*
        * if contador=0 dont add nothing
        * else contador=1 only add the first table
        * else contador=2 add all
        */
        int contador=0;
        String url = "jdbc:sqlite:/home/local/DANIELCASTELAO/cromerofajar/Actividades Programación/Manual/campeonato.db";
        String nombre=JOptionPane.showInputDialog(null,"En que tabla desea introducir los datos?");
        Connection conne = null;
        try {
            conne = DriverManager.getConnection(url);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        /*
        * All this values are used to add the parameters to the insert and create the insert
        */
        int ano=Integer.parseInt(JOptionPane.showInputDialog(null,"Introduce el año del campeonato"));
        String finalista1=JOptionPane.showInputDialog(null,"Introduce un finalista");
        String finalista2=JOptionPane.showInputDialog(null,"Introduce el otro finalista");
        String campeon=JOptionPane.showInputDialog(null,"Introduce el campeon");
        String mvp=JOptionPane.showInputDialog(null,"Introduce el nombre del mejor jugador");
        String usado=JOptionPane.showInputDialog(null,"Introduce el campeon usado por "+mvp);
        String sql = "INSERT INTO \""+nombre+"\"(ano, finalista1,finalista2,campeon) VALUES(?,?,?,?)";
        String sql2 = "INSERT INTO \""+nombre+"datos\"(ano, mvp,usado) VALUES(?,?,?)";
 
        try (Connection conn = conne;
            PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, ano);
            pstmt.setString(2, finalista1);
            pstmt.setString(3, finalista2);
            pstmt.setString(4, campeon);
            pstmt.executeUpdate();
            contador=1;
        try(Connection conn2=conne;
           PreparedStatement pstmt2 =conn2.prepareStatement(sql2)){
           pstmt2.setInt(1, ano);
           pstmt2.setString(2, mvp);
           pstmt2.setString(3, usado);
           pstmt2.execute();
           contador=2;
        } catch (SQLException e){
            System.out.println(e.getMessage());
        }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        finally{
            return contador;
        }

    }
}
