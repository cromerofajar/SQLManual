
package manualsqlite;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author cromerofajar
 */
public class BorrarCampo {
    public static int borrar(){
        int compro=0;
        String nombre=JOptionPane.showInputDialog(null,"Introduce el nombre de la tabla de la que deseas borrar un dato");
        String url= "jdbc:sqlite:/home/local/DANIELCASTELAO/cromerofajar/Actividades Programación/Manual/campeonato.db";
        Connection conne = null;
        try {
            conne = DriverManager.getConnection(url);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        int año=Integer.parseInt(JOptionPane.showInputDialog(null,"Introduce el año del campo que desea borrar"));
        String sql="DELETE FROM "+nombre+" WHERE ano= ?";
        String sql2="DELETE FROM "+nombre+"datos WHERE ano= ?";
        try (Connection conn = conne;
                PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setInt(1, año);
            pstmt.executeUpdate();
            JOptionPane.showMessageDialog(null,"Datos borrados partida");
            compro=1;
        try (Connection conn2 = conne;
                PreparedStatement pstmt2 = conn.prepareStatement(sql2)) {

            pstmt2.setInt(1, año);
            pstmt2.executeUpdate();
            JOptionPane.showMessageDialog(null,"Datos borrados de jugador");
            compro=2;
            conn2.close();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            
        }finally{
            try {
                conne.close();

            } catch (SQLException ex) {
                Logger.getLogger(BorrarCampo.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return compro;
    }
}
