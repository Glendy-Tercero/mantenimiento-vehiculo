/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import mantenimientovehiculos.Conexion;

public class MantenimientoModel {
    
    int idMantenimiento, idVehiculo;
    String fecha, tipo;
    double costo;
    private Conexion conexion;
    
    public MantenimientoModel() {
        conexion = new Conexion();
    }
    
    public int getIdMantenimiento() {
        return this.idMantenimiento;
    }
    public int getIdVehiculo() {
        return this.idVehiculo;
    }
    public String getFecha() {
        return this.fecha;
    }
    public String getTipo() {
        return this.tipo;
    }
    public double getCosto() {
        return this.costo;
    }
    
    public void setIdMantenimiento(int idMantenimiento) {
        this.idMantenimiento = idMantenimiento;
    }
    public void setIdVehiculo(int idVehiculo) {
        this.idVehiculo = idVehiculo;
    }
    public void setFecha(String fecha) {
        this.fecha = fecha;
    }
    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
    public void setCosto(double costo) {
        this.costo = costo;
    }
    
    public List<MantenimientoModel> obtenerMantenimiento() {
    List<MantenimientoModel> mantenimientos = new ArrayList<>();
    String query = "{call obtenerMantenimiento()}"; 
    try (Connection cx = conexion.conectar();
         CallableStatement statement = cx.prepareCall(query)) {
        try (ResultSet resultSet = statement.executeQuery()) {
            while (resultSet.next()) {
                MantenimientoModel mantenimiento = new MantenimientoModel();
                mantenimiento.setIdMantenimiento(resultSet.getInt("idMantenimiento"));
                mantenimiento.setIdVehiculo(resultSet.getInt("idVehiculo"));
                mantenimiento.setFecha(resultSet.getString("fecha"));
                mantenimiento.setTipo(resultSet.getString("tipoMantenimiento"));
                mantenimiento.setCosto(resultSet.getDouble("costo"));
                mantenimientos.add(mantenimiento);
            }
        }
    } catch (SQLException ex) {
        ex.printStackTrace();
    }
    return mantenimientos;
}
    
    public String insertarMantenimiento(MantenimientoModel modelMantenimiento) {
    Connection cx = conexion.conectar();
    if (cx != null) {
        try {
            String spInsertarMantenimiento = "{call insertarMantenimiento(?, ?, ?, ?)}";
            CallableStatement statement = cx.prepareCall(spInsertarMantenimiento);
            statement.setInt(1, modelMantenimiento.getIdVehiculo());
            statement.setString(2, modelMantenimiento.getFecha());
            statement.setString(3, modelMantenimiento.getTipo());
            statement.setDouble(4, modelMantenimiento.getCosto());
            statement.execute();
            return "Guardado exitosamente";
        } catch (SQLException ex) {
            return ex.getMessage();
        } finally {
            conexion.desconectar();
        }
    } else {
        return "Algo salió mal";
    }
} 
    
    public String modificarMantenimiento(MantenimientoModel modelMantenimiento) {
    Connection cx = conexion.conectar();
    if (cx != null) {
        try {
            String spModificarMantenimiento = "{call modificarMantenimiento(?, ?, ?, ?, ?)}";
            CallableStatement statement = cx.prepareCall(spModificarMantenimiento);
            statement.setInt(1, modelMantenimiento.getIdMantenimiento());
            statement.setInt(2, modelMantenimiento.getIdVehiculo());
            statement.setString(3, modelMantenimiento.getFecha());
            statement.setString(4, modelMantenimiento.getTipo());
            statement.setDouble(5, modelMantenimiento.getCosto());
            statement.execute();
            return "Modificado exitosamente";
        } catch (SQLException ex) {
            return ex.getMessage();
        } finally {
            conexion.desconectar();
        }
    } else {
        return "Algo salió mal";
    }
}   
    
    public String eliminarMantenimiento(int idMantenimiento) {
    Connection cx = conexion.conectar();
    if (cx != null) {
        try {
            String spEliminarMantenimiento = "{call eliminarMantenimiento(?)}";
            CallableStatement statement = cx.prepareCall(spEliminarMantenimiento);
            statement.setInt(1, idMantenimiento);
            statement.execute();
            return "Eliminado exitosamente";
        } catch (SQLException ex) {
            return ex.getMessage();
        } finally {
            conexion.desconectar();
        }
    } else {
        return "Algo salió mal";
    }
}
    
}
