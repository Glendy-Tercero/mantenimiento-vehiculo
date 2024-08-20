/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import java.util.List;
import model.VehiculoModel;
import view.VehiculosView;

public class VehiculoController {
    
    public VehiculoController() {}
    
    private VehiculoModel modelVehiculo;
    private VehiculosView viewVehiculos;
    
    public VehiculoController (VehiculoModel model, VehiculosView view) {
        this.modelVehiculo = model;
        this.viewVehiculos = view;
    }
    
    public List<VehiculoModel> obtenerVehiculo() {
    return modelVehiculo.obtenerVehiculo();
    }
    
    public String insertarVehiculo(String marca, String modelo, int año, String placa) {
    modelVehiculo = new VehiculoModel();
    modelVehiculo.setMarca(marca);
    modelVehiculo.setModelo(modelo);
    modelVehiculo.setAño(año);
    modelVehiculo.setPlaca(placa);
        
    return modelVehiculo.insertarVehiculo(modelVehiculo);
    }
    
    public String modificarVehiculo(int idVehiculo, String marca, String modelo, int año, String placa) {
    modelVehiculo = new VehiculoModel();
    modelVehiculo.setIdVehiculo(idVehiculo);
    modelVehiculo.setMarca(marca);
    modelVehiculo.setModelo(modelo);
    modelVehiculo.setAño(año);
    modelVehiculo.setPlaca(placa);

    return modelVehiculo.modificarVehiculo(modelVehiculo);
    }
    
    public String eliminarVehiculo(int idVehiculo) {
    return modelVehiculo.eliminarVehiculo(idVehiculo);
    }
    
    public void iniciar() {
    viewVehiculos.setVisible(true);
    } 
}
