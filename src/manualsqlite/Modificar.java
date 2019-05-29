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
    public static int modificarDatosMV(String nombre,int ano){
        int compro=0;
        String url = "jdbc:sqlite:/home/local/DANIELCASTELAO/cromerofajar/Actividades Programación/Manual/campeonato.db";
        Connection conne = null;
        try {
            conne = DriverManager.getConnection(url);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        /*
        * Variables used to realiced the update
        */
            String jug=JOptionPane.showInputDialog(null,"Introduzca el nombre del mejor jugador");
            String camp=JOptionPane.showInputDialog(null,"Introduzca el nombre del campeon usado");
            String sql = "UPDATE \""+nombre+"datos\" SET ano= ? ,"
            + "mvp = ? , "
            + "usado = ?"
            + "WHERE ano = ";
            sql=sql+ano;
 
        try (Connection conn = conne;
                PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setInt(1, ano);
            pstmt.setString(2, jug);
            pstmt.setString(3,camp);

            pstmt.executeUpdate();
            compro=1;
            
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            compro=0;
        }finally{
            try {
                conne.close();
            } catch (SQLException ex) {
                Logger.getLogger(Modificar.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return compro;
    }
    public static int modificarDatosParti(String nombre,int ano){
        int compro=0;
        String url = "jdbc:sqlite:/home/local/DANIELCASTELAO/cromerofajar/Actividades Programación/Manual/campeonato.db";
        Connection conne = null;
        try {
            conne = DriverManager.getConnection(url);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        /*
        * Variables used to realiced the update
        */
            String f1=JOptionPane.showInputDialog(null,"Introduzca el nombre del primer finalista");
            String f2=JOptionPane.showInputDialog(null,"Introduzca el nombre del segundo finalista");
            String camp=JOptionPane.showInputDialog(null,"Introduce el nombre del equipo campeon");
            String sql = "UPDATE \""+nombre+"\" SET ano= ? ,"
            + "finalista1 = ? , "
            + "finalista2 = ?, "
            + "campeon = ? "
            + "WHERE ano = ";
            sql=sql+ano;
 
        try (Connection conn = conne;
                PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setInt(1, ano);
            pstmt.setString(2, f1);
            pstmt.setString(3,f2);
            pstmt.setString(4, camp);

            pstmt.executeUpdate();
            compro=1;
            
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            compro=0;
        }finally{
            try {
                conne.close();
            } catch (SQLException ex) {
                Logger.getLogger(Modificar.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return compro;
    }
}
