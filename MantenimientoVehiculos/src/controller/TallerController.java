/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import java.util.List;
import model.TallerModel;
import view.VehiculosView;

public class TallerController {

    private TallerModel modelTaller;
    private VehiculosView viewVehiculos;

    public TallerController() {}

    public TallerController(TallerModel model, VehiculosView view) {
        this.modelTaller = model;
        this.viewVehiculos = view;
    }

    public List<TallerModel> obtenerTalleres() {
        return modelTaller.obtenerTalleres();
    }
    
    public String insertarTaller(String nombre, String direccion) {
        modelTaller = new TallerModel();
        modelTaller.setNombre(nombre);
        modelTaller.setDireccion(direccion);

        return modelTaller.insertarTaller(modelTaller);
    }
    
    public String modificarTaller(int idTaller, String nombre, String direccion) {
        modelTaller = new TallerModel();
        modelTaller.setIdTaller(idTaller);
        modelTaller.setNombre(nombre);
        modelTaller.setDireccion(direccion);

        return modelTaller.modificarTaller(modelTaller);
    }

    public String eliminarTaller(int idTaller) {
        return modelTaller.eliminarTaller(idTaller);
    }
}

