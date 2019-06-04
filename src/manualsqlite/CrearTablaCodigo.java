/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package manualsqlite;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;

/**
 *
 * @author cromerofajar
 */
public class CrearTablaCodigo {
    public static int crearPara(String nombreTabla){
        int contador=0;
        String url = "jdbc:sqlite:/home/local/DANIELCASTELAO/cromerofajar/Actividades Programación/Manual/campeonato.db";
        String sql = "CREATE TABLE IF NOT EXISTS "+ nombreTabla+ "(\n"
                + "ano integer PRIMARY KEY,\n"
                + "finalista1 text NOT NULL,\n"
                + "finalista2 text NOT NULL,\n"
                + "campeon text"
                + ");";
        String sql2 = "CREATE TABLE IF NOT EXISTS "+ nombreTabla+"datos "+ "(\n"
                + "ano integer PRIMARY KEY,\n"
                + "mvp text NOT NULL,\n"
                + "usado text NOT NULL\n"
                + ");";
        try (Connection conn = DriverManager.getConnection(url);
                Statement stmt = conn.createStatement()) {
            // create a new table
            stmt.execute(sql);
            stmt.execute(sql2);
            contador=1;

            conn.close();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            contador=0;
        }
        return contador;
    }
    public static int crearDefecto(){
        int contador=0;
        String url = "jdbc:sqlite:/home/local/DANIELCASTELAO/cromerofajar/Actividades Programación/Manual/campeonato.db";
        String sql = "CREATE TABLE IF NOT EXISTS torneo (\n"
                + "ano integer PRIMARY KEY,\n"
                + "finalista1 text NOT NULL,\n"
                + "finalista2 text NOT NULL,\n"
                + "campeon text"
                + ");";
        String sql2 = "CREATE TABLE IF NOT EXISTS torneodatos "+ "(\n"
                + "ano integer PRIMARY KEY,\n"
                + "mvp text NOT NULL,\n"
                + "usado text NOT NULL\n"
                + ");";
        try (Connection conn = DriverManager.getConnection(url);
                Statement stmt = conn.createStatement()) {
            // create a new table
            stmt.execute(sql);
            stmt.execute(sql2);
            contador=1;

            conn.close();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            contador=0;
        }
        return contador;
    }
}
