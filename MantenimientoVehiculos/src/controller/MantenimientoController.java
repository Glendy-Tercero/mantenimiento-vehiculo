/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import java.util.List;
import model.MantenimientoModel;
import view.VehiculosView;

public class MantenimientoController {
    
    public MantenimientoController() {}
    
    private MantenimientoModel modelMantenimiento;
    private VehiculosView viewVehiculos;
    
    public MantenimientoController (MantenimientoModel model, VehiculosView view) {
        this.modelMantenimiento = model;
        this.viewVehiculos = view;
    }
    
    public List<MantenimientoModel> obtenerMantenimiento() {
    return modelMantenimiento.obtenerMantenimiento();
    }
    
    public String insertarMantenimiento(int idVehiculo, String fecha, String tipo, double costo) {
    modelMantenimiento = new MantenimientoModel();
    modelMantenimiento.setIdVehiculo(idVehiculo);
    modelMantenimiento.setFecha(fecha);
    modelMantenimiento.setTipo(tipo);
    modelMantenimiento.setCosto(costo);
        
    return modelMantenimiento.insertarMantenimiento(modelMantenimiento);
    }
    
    public String modificarMantenimiento(int idMantenimiento, int idVehiculo, String fecha, String tipo, double costo) {
    modelMantenimiento = new MantenimientoModel();
    modelMantenimiento.setIdMantenimiento(idMantenimiento);
    modelMantenimiento.setIdVehiculo(idVehiculo);
    modelMantenimiento.setFecha(fecha);
    modelMantenimiento.setTipo(tipo);
    modelMantenimiento.setCosto(costo);
        
    return modelMantenimiento.modificarMantenimiento(modelMantenimiento);
    }
    
    public String eliminarMantenimiento(int idMantenimiento) {
    return modelMantenimiento.eliminarMantenimiento(idMantenimiento);
    }
    
    public void iniciar() {
    viewVehiculos.setVisible(true);
    } 
}
