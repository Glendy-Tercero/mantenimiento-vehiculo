/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mantenimientovehiculos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Conexion {
    String bd = "mantenimiento_vehiculo";
    String url = "jdbc:mysql://localhost:3306/" + bd;
    String user = "root";
    String password = "";
    String driver = "com.mysql.cj.jdbc.Driver";
    Connection cx;
    
public Conexion() {}
    
public Connection conectar() {
    try {
        Class.forName(driver);
        cx = DriverManager.getConnection(url, user, password);
        System.out.println("Se conecto correctamente a la base de datos: " + bd);
    }
    catch(ClassNotFoundException | SQLException ex) {
        System.out.println("No se puedo establecer conexion con la base de datos: " + bd);
        Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
    }
    return cx;
}

public void desconectar() {
    try {
        cx.close();    
    }
    catch (SQLException ex) {
        Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
    }
}

public static void main (String [] args) {
    Conexion conexion = new Conexion();
    conexion.conectar();
}
    
}
