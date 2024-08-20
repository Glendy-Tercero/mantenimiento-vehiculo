/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import java.util.List;
import model.RepuestoModel;
import view.VehiculosView;

public class RepuestoController {
    
    private RepuestoModel modelRepuesto;
    private VehiculosView viewVehiculos;
    
    public RepuestoController() {}

    public RepuestoController(RepuestoModel model, VehiculosView view) {
        this.modelRepuesto = model;
        this.viewVehiculos = view;
    }

    public List<RepuestoModel> obtenerRepuesto() {
        return modelRepuesto.obtenerRepuesto();
    }

    public String insertarRepuesto(int idMantenimiento, String nombre, double costo) {
        modelRepuesto = new RepuestoModel();
        modelRepuesto.setIdMantenimiento(idMantenimiento);
        modelRepuesto.setNombre(nombre);
        modelRepuesto.setCosto(costo);
        
        return modelRepuesto.insertarRepuesto(modelRepuesto);
    }

    public String modificarRepuesto(int idRepuesto, int idMantenimiento, String nombre, double costo) {
        modelRepuesto = new RepuestoModel();
        modelRepuesto.setIdRepuesto(idRepuesto);
        modelRepuesto.setIdMantenimiento(idMantenimiento);
        modelRepuesto.setNombre(nombre);
        modelRepuesto.setCosto(costo);
        
        return modelRepuesto.modificarRepuesto(modelRepuesto);
    }

    public String eliminarRepuesto(int idRepuesto) {
        return modelRepuesto.eliminarRepuesto(idRepuesto);
    }

}

