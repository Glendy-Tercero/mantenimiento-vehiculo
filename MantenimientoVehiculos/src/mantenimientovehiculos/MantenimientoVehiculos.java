/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package mantenimientovehiculos;

import controller.MantenimientoController;
import controller.RepuestoController;
import controller.TallerController;
import controller.VehiculoController;
import model.MantenimientoModel;
import model.RepuestoModel;
import model.TallerModel;
import model.VehiculoModel;
import view.VehiculosView;


public class MantenimientoVehiculos {

    public static void main(String[] args) {
    
        VehiculosView viewVehiculos = new VehiculosView();
        
        VehiculoModel modelVehiculo = new VehiculoModel();
        VehiculoController controllerVehiculo = new VehiculoController(modelVehiculo, viewVehiculos);
        
        MantenimientoModel modelMantenimiento = new MantenimientoModel();
        MantenimientoController controllerMantenimiento = new MantenimientoController(modelMantenimiento, viewVehiculos);
        
        RepuestoModel modelRepuesto = new RepuestoModel();
        RepuestoController controllerRepuesto = new RepuestoController(modelRepuesto, viewVehiculos);
        
        TallerModel modelTaller = new TallerModel();
        TallerController controllerTaller = new TallerController(modelTaller, viewVehiculos);
        
        viewVehiculos.SetViewVehiculos(controllerVehiculo, controllerMantenimiento, controllerRepuesto, controllerTaller);
        
        controllerVehiculo.iniciar();
    }
    
}
