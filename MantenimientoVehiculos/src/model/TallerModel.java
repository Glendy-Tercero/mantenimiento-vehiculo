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

public class TallerModel {

    private int idTaller;
    private String nombre;
    private String direccion;
    private Conexion conexion;

    public TallerModel() {
        conexion = new Conexion();
    }

    public int getIdTaller() {
        return idTaller;
    }

    public void setIdTaller(int idTaller) {
        this.idTaller = idTaller;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public List<TallerModel> obtenerTalleres() {
        List<TallerModel> talleres = new ArrayList<>();
        String query = "{call obtenerTaller()}";
        try (Connection cx = conexion.conectar();
             CallableStatement statement = cx.prepareCall(query)) {
            try (ResultSet resultSet = statement.executeQuery()) {
                while (resultSet.next()) {
                    TallerModel taller = new TallerModel();
                    taller.setIdTaller(resultSet.getInt("idTaller"));
                    taller.setNombre(resultSet.getString("nombreTaller"));
                    taller.setDireccion(resultSet.getString("direccion"));
                    talleres.add(taller);
                }
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return talleres;
    }
    
    public String insertarTaller(TallerModel modelTaller) {
        Connection cx = conexion.conectar();
        if (cx != null) {
            try {
                String spInsertarTaller = "{call insertarTaller(?, ?)}";
                CallableStatement statement = cx.prepareCall(spInsertarTaller);
                statement.setString(1, modelTaller.getNombre());
                statement.setString(2, modelTaller.getDireccion());
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
    
    public String modificarTaller(TallerModel modelTaller) {
        Connection cx = conexion.conectar();
        if (cx != null) {
            try {
                String spModificarTaller = "{call modificarTaller(?, ?, ?)}";
                CallableStatement statement = cx.prepareCall(spModificarTaller);
                statement.setInt(1, modelTaller.getIdTaller());
                statement.setString(2, modelTaller.getNombre());
                statement.setString(3, modelTaller.getDireccion());
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

    public String eliminarTaller(int idTaller) {
        Connection cx = conexion.conectar();
        if (cx != null) {
            try {
                String spEliminarTaller = "{call eliminarTaller(?)}";
                CallableStatement statement = cx.prepareCall(spEliminarTaller);
                statement.setInt(1, idTaller);
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
