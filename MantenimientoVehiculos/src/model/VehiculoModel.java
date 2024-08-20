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

public class VehiculoModel {
    
    int idVehiculo, año;
    String marca, modelo, placa;
    private Conexion conexion;
    
    public VehiculoModel() {
        conexion = new Conexion();
    }
    
    public int getIdVehiculo() {
        return this.idVehiculo;
    }
    public String getMarca() {
        return this.marca;
    }
    public String getModelo() {
        return this.modelo;
    }
    public int getAño() {
        return this.año;
    }
    public String getPlaca() {
        return this.placa;
    }
    
    public void setIdVehiculo(int idVehiculo) {
        this.idVehiculo = idVehiculo;
    }
    public void setMarca(String marca) {
        this.marca = marca;
    }
    public void setModelo(String modelo) {
        this.modelo = modelo;
    }
    public void setAño(int año) {
        this.año = año;
    }
    public void setPlaca(String placa) {
        this.placa = placa;
    }
    
    public List<VehiculoModel> obtenerVehiculo() {
    List<VehiculoModel> vehiculos = new ArrayList<>();
    String query = "{call obtenerVehiculo()}"; 
    try (Connection cx = conexion.conectar();
         CallableStatement statement = cx.prepareCall(query)) {
        try (ResultSet resultSet = statement.executeQuery()) {
            while (resultSet.next()) {
                VehiculoModel vehiculo = new VehiculoModel();
                vehiculo.setIdVehiculo(resultSet.getInt("idVehiculo"));
                vehiculo.setMarca(resultSet.getString("marca"));
                vehiculo.setModelo(resultSet.getString("modelo"));
                vehiculo.setAño(resultSet.getInt("año"));
                vehiculo.setPlaca(resultSet.getString("placa"));
                vehiculos.add(vehiculo);
            }
        }
    } catch (SQLException ex) {
        ex.printStackTrace();
    }
    return vehiculos;
}
    
    public String insertarVehiculo(VehiculoModel modelVehiculo) {
    Connection cx = conexion.conectar();
    if (cx != null) {
        try {
            String spInsertarVehiculo = "{call insertarVehiculo(?, ?, ?, ?)}";
            CallableStatement statement = cx.prepareCall(spInsertarVehiculo);
            statement.setString(1, modelVehiculo.getMarca());
            statement.setString(2, modelVehiculo.getModelo());
            statement.setInt(3, modelVehiculo.getAño());
            statement.setString(4, modelVehiculo.getPlaca());
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
    
    public String modificarVehiculo(VehiculoModel modelVehiculo) {
    Connection cx = conexion.conectar();
    if (cx != null) {
        try {
            String spModificarVehiculo = "{call modificarVehiculo(?, ?, ?, ?, ?)}";
            CallableStatement statement = cx.prepareCall(spModificarVehiculo);
            statement.setInt(1, modelVehiculo.getIdVehiculo());
            statement.setString(2, modelVehiculo.getMarca());
            statement.setString(3, modelVehiculo.getModelo());
            statement.setInt(4, modelVehiculo.getAño());
            statement.setString(5, modelVehiculo.getPlaca());
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
    
public String eliminarVehiculo(int idVehiculo) {
    Connection cx = conexion.conectar();
    if (cx != null) {
        try {
            String spEliminarVehiculo = "{call eliminarVehiculo(?)}";
            CallableStatement statement = cx.prepareCall(spEliminarVehiculo);
            statement.setInt(1, idVehiculo);
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
