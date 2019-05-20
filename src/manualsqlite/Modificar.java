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
public class Modificar {
    public static void modificarDatos(){
        String nombre=JOptionPane.showInputDialog(null,"De que tabla desea modificar los datos");
        String url = "jdbc:sqlite:/home/local/DANIELCASTELAO/cromerofajar/Actividades Programación/Manual/test.db";
        Connection conne = null;
        try {
            conne = DriverManager.getConnection(url);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
            int ano=Integer.parseInt(JOptionPane.showInputDialog(null,"Introduce el año en el que presidio"));
            String presi=JOptionPane.showInputDialog(null,"Introduzca el nombre del presidente");
            String parti=JOptionPane.showInputDialog(null,"Introduzca el nombre del partido");
            String sql = "UPDATE \""+nombre+"\" SET ano= ? ,"
            + "presidente = ? , "
            + "partido = ?"
            + "WHERE ano = "+ano+"";
 
        try (Connection conn = conne;
                PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setInt(1, ano);
            pstmt.setString(2, presi);
            pstmt.setString(3,parti);

            pstmt.executeUpdate();
            System.out.println("Campo Modificado");
            
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            System.out.println("El año no esta en la base de datos");
        }finally{
            try {
                conne.close();
            } catch (SQLException ex) {
                Logger.getLogger(Modificar.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
}
