
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
public class BorrarCampo {
    public static void borrar(){
        String nombre=JOptionPane.showInputDialog(null,"Introduce el nombre de la tabla de la que deseas borrar un dato");
        String url= "jdbc:sqlite:/home/local/DANIELCASTELAO/cromerofajar/Actividades Programación/Manual/test.db";
        Connection conne = null;
        try {
            conne = DriverManager.getConnection(url);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        int año=Integer.parseInt(JOptionPane.showInputDialog(null,"Introduce el año del campo que desea borrar"));
        String sql="DELETE FROM "+nombre+" WHERE ano= ?";
        try (Connection conn = conne;
                PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setInt(1, año);
            pstmt.executeUpdate();
            JOptionPane.showMessageDialog(null,"Datos borrados");
 
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        
    }
}
