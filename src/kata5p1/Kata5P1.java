/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kata5p1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author Juanma
 */
public class Kata5P1 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        SelectApp app = new SelectApp();
        app.selectAll();
        CrearTabla tabla_mail = new CrearTabla();
        tabla_mail.createNewTable();
    }
    private static class SelectApp {

        private Connection connect() {
            String url = "jdbc:sqlite:Kata5.db";
            Connection conn = null;
            try {
                conn = DriverManager.getConnection(url);
            } catch (SQLException e) {
                System.out.println(e.getMessage());
            }
            return conn;
        }

    
        public void selectAll(){
                String sql = "SELECT * FROM PEOPLE";
                try (Connection conn = this.connect();
                    Statement stmt = conn.createStatement();
                    ResultSet rs = stmt.executeQuery(sql)){
                    while (rs.next()) {
                        System.out.println(rs.getInt("id") + "\t" +
                                           rs.getString("Name") + "\t" +
                                           rs.getString("Apellidos") + "\t" +
                                           rs.getString("Departamento") + "\t");
                    }
                } catch (SQLException e) {
                    System.out.println(e.getMessage());
                }
        }
    }
    
    private static class CrearTabla {
        public static void createNewTable() {
            String url = "jdbc:sqlite:Kata5.db";
            String sql = "CREATE TABLE IF NOT EXISTS email (\n"
            + " id integer PRIMARY KEY AUTOINCREMENT,\n"
            + " mail text NOT NULL);";
            try (Connection conn = DriverManager.getConnection(url);
                Statement stmt = conn.createStatement()) {
                stmt.execute(sql);
                System.out.println("Tabla creada");
            } catch (SQLException e) {
                System.out.println(e.getMessage());
            }
        }
}

}
