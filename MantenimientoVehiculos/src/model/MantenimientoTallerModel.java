/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import mantenimientovehiculos.Conexion;

public class MantenimientoTallerModel {
    
    private int idMantenimientoTaller, idMantenimiento, idTaller;
    private Conexion conexion;
    
    public MantenimientoTallerModel() {
        conexion = new Conexion();
    }
    public int getIdMantenimientoTaller() {
        return idMantenimientoTaller;
    }
    public int getIdMantenimiento() {
        return idMantenimiento;
    }
    public int getIdTaller() {
        return idTaller;
    }
    
    public void setIdMantenimientoTaller(int idMantenimientoTaller) {
        this.idMantenimientoTaller = idMantenimientoTaller;
    }
    public void setIdMantenimiento(int idMantenimiento) {
        this.idMantenimiento = idMantenimiento;
    }
    public void setIdTaller(int idTaller) {
        this.idTaller = idTaller;
    }
}
