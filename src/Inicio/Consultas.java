/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Inicio;

import java.io.InputStream;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author Valdez
 */
public class Consultas {
      public static InputStream Imagen() {
        String bd = "prestige";
        String url = "jdbc:mysql://localhost/" + bd+"?serverTimezone=UTC";
        Conectar db = new Conectar(url);
        PreparedStatement ps = null;
        ResultSet rs = null;
        String query = "SELECT * FROM fotografia WHERE id = 1;";
        InputStream inp = null;
        try {
            ps = db.getConnection().prepareStatement(query);
            rs = ps.executeQuery();
            while (rs.next()) {

                inp = rs.getBinaryStream(2);
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        } finally {
            try {
                rs.close();
                ps.close();
                db.desconectar();
            } catch (SQLException ex) {
                  JOptionPane.showMessageDialog(null,"Error al acceder a la base de datos"+ex);
            }
        }
        return inp;
    }

}
