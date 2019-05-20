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
        String url = "jdbc:sqlite:/home/local/DANIELCASTELAO/cromerofajar/Actividades Programación/Manual/test.db";
        String nombre=JOptionPane.showInputDialog(null,"En que tabla desea introducir los datos?");
        Connection conne = null;
        try {
            conne = DriverManager.getConnection(url);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        int ano=Integer.parseInt(JOptionPane.showInputDialog(null,"Introduce el año en el que presidio"));
        String presidente=JOptionPane.showInputDialog(null,"Introduce el presidente");
        String partido=JOptionPane.showInputDialog(null,"Introduce el partido del presidente");
        String sql = "INSERT INTO \""+nombre+"\"(ano,presidente,partido) VALUES(?,?,?)";
 
        try (Connection conn = conne;
            
            PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, ano);
            pstmt.setString(2, presidente);
            pstmt.setString(3, partido);
            pstmt.executeUpdate();
            JOptionPane.showMessageDialog(null,"Insertado");
            conne.close();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            JOptionPane.showMessageDialog(null,"No insertado algun campo esta mal introducido o se repite el año");
        }

    }
}
