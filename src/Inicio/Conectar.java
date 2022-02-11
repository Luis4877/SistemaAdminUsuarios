/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Inicio;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author Valdez
 */



public class Conectar {
    
    static String bd = "prestige";
    static String login = "root";
    static String password = "prestige";
    Connection connection = null;
    static String url="jdbc:mysql://localhost:3306/"+bd+"?serverTimezone=UTC";
    
    
    
     public Conectar(String url) {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection(url, login, password);
            
            if (connection != null) {
             JOptionPane.showMessageDialog(null,"Generando Reporte");
             
            }
        } catch (SQLException | ClassNotFoundException ex) {
            System.out.println(ex.getMessage());
        }
    }

    public Connection getConnection() {
        return connection;
    }

    public void desconectar() {
        try {
            connection.close();
        } catch (SQLException ex) {
        }
    }
    
    
    
    
    
    
    
}
