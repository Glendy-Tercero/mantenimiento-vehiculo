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

public class RepuestoModel {
    
    private int idRepuesto, idMantenimiento;
    private String nombre;
    private double costo;
    private Conexion conexion;
    
    public RepuestoModel() {
        conexion = new Conexion();
    }
    public int getIdRepuesto() {
        return idRepuesto;
    }
    public int getIdMantenimiento() {
        return idMantenimiento;
    }
    public String getNombre() {
        return nombre;
    }
    public double getCosto() {
        return costo;
    }
    
    public void setIdRepuesto(int idRepuesto) {
        this.idRepuesto = idRepuesto;
    }
    public void setIdMantenimiento(int idMantenimiento) {
        this.idMantenimiento = idMantenimiento;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public void setCosto(double costo) {
        this.costo = costo;
    }

    public List<RepuestoModel> obtenerRepuesto() {
        List<RepuestoModel> repuestos = new ArrayList<>();
        String query = "{call obtenerRepuesto()}"; 
        try (Connection cx = conexion.conectar();
             CallableStatement statement = cx.prepareCall(query);
             ResultSet resultSet = statement.executeQuery()) {
            while (resultSet.next()) {
                RepuestoModel repuesto = new RepuestoModel();
                repuesto.setIdRepuesto(resultSet.getInt("idRepuesto"));
                repuesto.setIdMantenimiento(resultSet.getInt("idMantenimiento"));
                repuesto.setNombre(resultSet.getString("nombreRepuesto"));
                repuesto.setCosto(resultSet.getDouble("costoRepuesto"));
                repuestos.add(repuesto);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return repuestos;
    }

    public String insertarRepuesto(RepuestoModel modelRepuesto) {
        Connection cx = conexion.conectar();
        if (cx != null) {
            try {
                String spInsertarRepuesto = "{call insertarRepuesto(?, ?, ?)}";
                CallableStatement statement = cx.prepareCall(spInsertarRepuesto);
                statement.setInt(1, modelRepuesto.getIdMantenimiento());
                statement.setString(2, modelRepuesto.getNombre());
                statement.setDouble(3, modelRepuesto.getCosto());
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

    public String modificarRepuesto(RepuestoModel modelRepuesto) {
        Connection cx = conexion.conectar();
        if (cx != null) {
            try {
                String spModificarRepuesto = "{call modificarRepuesto(?, ?, ?, ?)}";
                CallableStatement statement = cx.prepareCall(spModificarRepuesto);
                statement.setInt(1, modelRepuesto.getIdRepuesto());
                statement.setInt(2, modelRepuesto.getIdMantenimiento());
                statement.setString(3, modelRepuesto.getNombre());
                statement.setDouble(4, modelRepuesto.getCosto());
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

    public String eliminarRepuesto(int idRepuesto) {
        Connection cx = conexion.conectar();
        if (cx != null) {
            try {
                String spEliminarRepuesto = "{call eliminarRepuesto(?)}";
                CallableStatement statement = cx.prepareCall(spEliminarRepuesto);
                statement.setInt(1, idRepuesto);
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

