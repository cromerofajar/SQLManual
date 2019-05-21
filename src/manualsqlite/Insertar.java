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
     
    public static void insert() {
        String url = "jdbc:sqlite:/home/local/DANIELCASTELAO/cromerofajar/Actividades Programación/Manual/campeonato.db";
        String nombre=JOptionPane.showInputDialog(null,"En que tabla desea introducir los datos?");
        Connection conne = null;
        try {
            conne = DriverManager.getConnection(url);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
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
            JOptionPane.showMessageDialog(null,"Insertados datos de la final");
        try(Connection conn2=conne;
           PreparedStatement pstmt2 =conn2.prepareStatement(sql2)){
           pstmt2.setInt(1, ano);
           pstmt2.setString(2, mvp);
           pstmt2.setString(3, usado);
           pstmt2.execute();
           JOptionPane.showMessageDialog(null,"Insertados datos del mejor jugador");
        } catch (SQLException e){
            System.out.println(e.getMessage());
            JOptionPane.showMessageDialog(null,"No insertado algun campo esta mal introducido o se repite el año");
        }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            JOptionPane.showMessageDialog(null,"No insertado algun campo esta mal introducido o se repite el año");
        }
        

    }
}
