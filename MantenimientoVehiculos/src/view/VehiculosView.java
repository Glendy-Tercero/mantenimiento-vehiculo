/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package view;

import java.awt.Color;
import java.awt.Font;
import java.util.List;
import javax.swing.JOptionPane;
import static javax.swing.SwingConstants.CENTER;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import controller.MantenimientoController;
import controller.RepuestoController;
import controller.TallerController;
import controller.VehiculoController;
import model.MantenimientoModel;
import model.RepuestoModel;
import model.VehiculoModel;

public class VehiculosView extends javax.swing.JFrame {
    
    private VehiculoController controllerVehiculo;
    private MantenimientoController controllerMantenimiento;
    private RepuestoController controllerRepuesto;
    private TallerController controllerTaller;
        
    public VehiculosView() {
        initComponents();
    }
    
    public void SetViewVehiculos(VehiculoController vehiculoController, MantenimientoController mantenimientoController, RepuestoController repuestoController, TallerController tallerController) {
        initComponents();
        controllerVehiculo = vehiculoController;
        controllerMantenimiento = mantenimientoController;
        controllerRepuesto = repuestoController;
        controllerTaller = tallerController;
        inicializarVista();
    }
    
    VehiculosView(VehiculoController vehiculoController, MantenimientoController mantenimientoController, RepuestoController repuestoController, TallerController tallerController) {
        initComponents();
        controllerVehiculo = vehiculoController;
        controllerMantenimiento = mantenimientoController;
        controllerRepuesto = repuestoController;
        controllerTaller = tallerController;
        inicializarVista();
    }
    
    private void inicializarVista() {
        textField();
        tablas();
        obtenerVehiculo();      
        obtenerMantenimiento();
        obtenerRepuesto();
        seleccionarVehiculo();
        seleccionarMantenimiento();
        seleccionarRepuesto();
    }
    
    private void textField() {
        TxtIdVehiculo.setVisible(false);
        TxtIdMantenimiento.setVisible(false);
        TxtIdRepuesto.setVisible(false);
    }
    
    private void tablas() {
        DefaultTableCellRenderer encabezado = new DefaultTableCellRenderer() {
        @Override
        public void setValue(Object value) {
        setBackground(new Color(190, 242, 228));
        setForeground(new Color(51, 51, 51));
        setHorizontalAlignment(CENTER);
        Font fuenteNegrita = new Font("Arial", Font.BOLD, 12);
        setFont(fuenteNegrita);
        super.setValue(value);
        }  
        }; TablaVehiculo.getTableHeader().setDefaultRenderer(encabezado);
            TablaVehiculo.setRowHeight(20);
            TablaMantenimiento.getTableHeader().setDefaultRenderer(encabezado);
            TablaMantenimiento.setRowHeight(20);
            TablaRepuesto.getTableHeader().setDefaultRenderer(encabezado);
            TablaRepuesto.setRowHeight(20);
    }
    
    private void actualizarTabla() {
        DefaultTableModel tablaVehiculo = (DefaultTableModel) TablaVehiculo.getModel();
        tablaVehiculo.setRowCount(0);
        obtenerVehiculo();
        
        DefaultTableModel tablaMantenimiento = (DefaultTableModel) TablaMantenimiento.getModel();
        tablaMantenimiento.setRowCount(0);
        obtenerMantenimiento();
        
        DefaultTableModel tablaRepuestos = (DefaultTableModel) TablaRepuesto.getModel();
        tablaRepuestos.setRowCount(0);
        obtenerRepuesto();
    }
    
    private void limpiarCampos() {
        TxtIdVehiculo.setText("");
        TxtMarcaV.setText("");
        TxtModeloV.setText("");
        TxtAñoV.setText("");
        TxtPlacaV.setText("");
        
        TxtIdMantenimiento.setText("");
        TxtIdVehiculoM.setText("");
        TxtFechaM.setText("");
        TxtTipoM.setText("");
        TxtCostoM.setText("");    
        
        TxtIdRepuesto.setText("");
        TxtIdManteR.setText("");
        TxtNombreR.setText("");
        TxtCostoR.setText("");
    }
    
    private void obtenerVehiculo() {
    DefaultTableModel tablaVehiculos = (DefaultTableModel) TablaVehiculo.getModel();
    List<VehiculoModel> vehiculos = controllerVehiculo.obtenerVehiculo();  
    tablaVehiculos.setRowCount(0);
    for (VehiculoModel vehiculo : vehiculos) {
        Object[] fila = {
            vehiculo.getIdVehiculo(), 
            vehiculo.getMarca(), 
            vehiculo.getModelo(), 
            vehiculo.getAño(), 
            vehiculo.getPlaca()};
        tablaVehiculos.addRow(fila);
         }
    }
    
    private void obtenerMantenimiento() { 
    DefaultTableModel tablaMantenimientos = (DefaultTableModel) TablaMantenimiento.getModel();
    List<MantenimientoModel> mantenimientos = controllerMantenimiento.obtenerMantenimiento();  
    tablaMantenimientos.setRowCount(0);
    for (MantenimientoModel mantenimiento : mantenimientos) {
        Object[] fila = {
            mantenimiento.getIdMantenimiento(), 
            mantenimiento.getIdVehiculo(), 
            mantenimiento.getFecha(), 
            mantenimiento.getTipo(), 
            mantenimiento.getCosto()};
        tablaMantenimientos.addRow(fila);
         }
    }
    
    private void obtenerRepuesto() { 
    DefaultTableModel tablaRepuestos = (DefaultTableModel) TablaRepuesto.getModel();
    List<RepuestoModel> repuestos = controllerRepuesto.obtenerRepuesto();  
    tablaRepuestos.setRowCount(0);
    for (RepuestoModel repuesto : repuestos) {
        Object[] fila = {
            repuesto.getIdRepuesto(),
            repuesto.getIdMantenimiento(),
            repuesto.getNombre(),
            repuesto.getCosto()};
        tablaRepuestos.addRow(fila);
    }
}
    
   private void seleccionarVehiculo() { 
    TablaVehiculo.getSelectionModel().addListSelectionListener(event -> {
        if (!event.getValueIsAdjusting() && TablaVehiculo.getSelectedRow() != -1) {
            int selectedRow = TablaVehiculo.getSelectedRow();
            TxtIdVehiculo.setText(TablaVehiculo.getValueAt(selectedRow, 0).toString());
            TxtMarcaV.setText(TablaVehiculo.getValueAt(selectedRow, 1).toString());
            TxtModeloV.setText(TablaVehiculo.getValueAt(selectedRow, 2).toString());
            TxtAñoV.setText(TablaVehiculo.getValueAt(selectedRow, 3).toString());
            TxtPlacaV.setText(TablaVehiculo.getValueAt(selectedRow, 4).toString());
        }
    });
}
   
   private void seleccionarMantenimiento() { 
    TablaMantenimiento.getSelectionModel().addListSelectionListener(event -> {
        if (!event.getValueIsAdjusting() && TablaMantenimiento.getSelectedRow() != -1) {
            int selectedRow = TablaMantenimiento.getSelectedRow();
            TxtIdMantenimiento.setText(TablaMantenimiento.getValueAt(selectedRow, 0).toString());
            TxtIdVehiculoM.setText(TablaMantenimiento.getValueAt(selectedRow, 1).toString());
            TxtFechaM.setText(TablaMantenimiento.getValueAt(selectedRow, 2).toString());
            TxtTipoM.setText(TablaMantenimiento.getValueAt(selectedRow, 3).toString());
            TxtCostoM.setText(TablaMantenimiento.getValueAt(selectedRow, 4).toString());
        }
    });
}
   
   private void seleccionarRepuesto() { 
    TablaRepuesto.getSelectionModel().addListSelectionListener(event -> {
        if (!event.getValueIsAdjusting() && TablaRepuesto.getSelectedRow() != -1) {
            int selectedRow = TablaRepuesto.getSelectedRow();
            TxtIdRepuesto.setText(TablaRepuesto.getValueAt(selectedRow, 0).toString());
            TxtIdManteR.setText(TablaRepuesto.getValueAt(selectedRow, 1).toString());
            TxtNombreR.setText(TablaRepuesto.getValueAt(selectedRow, 2).toString());
            TxtCostoR.setText(TablaRepuesto.getValueAt(selectedRow, 3).toString());
        }
    });
}
   
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        PanelFondo = new javax.swing.JPanel();
        PanelMenu = new javax.swing.JPanel();
        LabMantenimiento = new javax.swing.JLabel();
        LabRepuesto = new javax.swing.JLabel();
        LabVehiculo = new javax.swing.JLabel();
        LabTalleres = new javax.swing.JLabel();
        PanelVentana = new javax.swing.JPanel();
        PanelVacio = new javax.swing.JPanel();
        LabMensaje = new javax.swing.JLabel();
        PanelVehiculo = new javax.swing.JPanel();
        LabMarcaV = new javax.swing.JLabel();
        TxtMarcaV = new javax.swing.JTextField();
        LabModeloV = new javax.swing.JLabel();
        TxtModeloV = new javax.swing.JTextField();
        LabAñoV = new javax.swing.JLabel();
        TxtAñoV = new javax.swing.JTextField();
        LabPlacaV = new javax.swing.JLabel();
        TxtPlacaV = new javax.swing.JTextField();
        ScrollVehiculo = new javax.swing.JScrollPane();
        TablaVehiculo = new javax.swing.JTable();
        BtnAgregarVeh = new javax.swing.JButton();
        BtnModificarVeh = new javax.swing.JButton();
        BtnEliminarVeh = new javax.swing.JButton();
        TxtIdVehiculo = new javax.swing.JTextField();
        PanelMantenimiento = new javax.swing.JPanel();
        LabIdVehiculoM = new javax.swing.JLabel();
        TxtIdVehiculoM = new javax.swing.JTextField();
        LabFechaM = new javax.swing.JLabel();
        TxtFechaM = new javax.swing.JTextField();
        LabTipoM = new javax.swing.JLabel();
        TxtTipoM = new javax.swing.JTextField();
        LabCostoM = new javax.swing.JLabel();
        TxtCostoM = new javax.swing.JTextField();
        ScrollMantenimiento = new javax.swing.JScrollPane();
        TablaMantenimiento = new javax.swing.JTable();
        BtnAgregarMan = new javax.swing.JButton();
        BtnModificarMan = new javax.swing.JButton();
        BtnEliminarMan = new javax.swing.JButton();
        TxtIdMantenimiento = new javax.swing.JTextField();
        PanelRepuesto = new javax.swing.JPanel();
        LabIdManteR = new javax.swing.JLabel();
        TxtIdManteR = new javax.swing.JTextField();
        LabNombreR = new javax.swing.JLabel();
        TxtNombreR = new javax.swing.JTextField();
        LabCostoR = new javax.swing.JLabel();
        TxtCostoR = new javax.swing.JTextField();
        ScrollRepuesto = new javax.swing.JScrollPane();
        TablaRepuesto = new javax.swing.JTable();
        BtnAgregarRep = new javax.swing.JButton();
        BtnModificarRep = new javax.swing.JButton();
        BtnEliminarRep = new javax.swing.JButton();
        TxtIdRepuesto = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setFocusCycleRoot(false);

        PanelFondo.setBackground(new java.awt.Color(255, 255, 255));

        PanelMenu.setBackground(new java.awt.Color(207, 236, 228));
        PanelMenu.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 3, 0, new java.awt.Color(0, 156, 117)));

        LabMantenimiento.setBackground(new java.awt.Color(40, 197, 158));
        LabMantenimiento.setFont(new java.awt.Font("Trebuchet MS", 0, 14)); // NOI18N
        LabMantenimiento.setForeground(new java.awt.Color(255, 255, 255));
        LabMantenimiento.setText("    Mantenimientos");
        LabMantenimiento.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 0, 1, new java.awt.Color(204, 204, 204)));
        LabMantenimiento.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        LabMantenimiento.setOpaque(true);
        LabMantenimiento.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                LabMantenimientoMouseClicked(evt);
            }
        });

        LabRepuesto.setBackground(new java.awt.Color(40, 197, 158));
        LabRepuesto.setFont(new java.awt.Font("Trebuchet MS", 0, 14)); // NOI18N
        LabRepuesto.setForeground(new java.awt.Color(255, 255, 255));
        LabRepuesto.setText("    Repuestos");
        LabRepuesto.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        LabRepuesto.setOpaque(true);
        LabRepuesto.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                LabRepuestoMouseClicked(evt);
            }
        });

        LabVehiculo.setBackground(new java.awt.Color(40, 197, 158));
        LabVehiculo.setFont(new java.awt.Font("Trebuchet MS", 0, 14)); // NOI18N
        LabVehiculo.setForeground(new java.awt.Color(255, 255, 255));
        LabVehiculo.setText("    Vehículos");
        LabVehiculo.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 0, 1, new java.awt.Color(204, 204, 204)));
        LabVehiculo.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        LabVehiculo.setOpaque(true);
        LabVehiculo.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                LabVehiculoMouseClicked(evt);
            }
        });

        LabTalleres.setBackground(new java.awt.Color(190, 242, 228));
        LabTalleres.setFont(new java.awt.Font("Segoe UI Symbol", 1, 14)); // NOI18N
        LabTalleres.setForeground(new java.awt.Color(51, 51, 51));
        LabTalleres.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        LabTalleres.setText("Talleres 🢅");
        LabTalleres.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(160, 222, 205), 1, true));
        LabTalleres.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        LabTalleres.setOpaque(true);
        LabTalleres.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                LabTalleresMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                LabTalleresMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                LabTalleresMouseExited(evt);
            }
        });

        javax.swing.GroupLayout PanelMenuLayout = new javax.swing.GroupLayout(PanelMenu);
        PanelMenu.setLayout(PanelMenuLayout);
        PanelMenuLayout.setHorizontalGroup(
            PanelMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelMenuLayout.createSequentialGroup()
                .addComponent(LabVehiculo, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(LabMantenimiento, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(LabRepuesto, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(390, 390, 390)
                .addComponent(LabTalleres, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        PanelMenuLayout.setVerticalGroup(
            PanelMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(LabVehiculo, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addComponent(LabMantenimiento, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addComponent(LabRepuesto, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addComponent(LabTalleres, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        PanelVentana.setBackground(new java.awt.Color(255, 255, 255));
        PanelVentana.setLayout(new java.awt.CardLayout());

        PanelVacio.setBackground(new java.awt.Color(255, 255, 255));

        LabMensaje.setFont(new java.awt.Font("Copperplate Gothic Bold", 0, 18)); // NOI18N
        LabMensaje.setForeground(new java.awt.Color(204, 204, 204));
        LabMensaje.setText("¡BIENVENIDO!");

        javax.swing.GroupLayout PanelVacioLayout = new javax.swing.GroupLayout(PanelVacio);
        PanelVacio.setLayout(PanelVacioLayout);
        PanelVacioLayout.setHorizontalGroup(
            PanelVacioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 900, Short.MAX_VALUE)
            .addGroup(PanelVacioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(PanelVacioLayout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(LabMensaje)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
        PanelVacioLayout.setVerticalGroup(
            PanelVacioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 484, Short.MAX_VALUE)
            .addGroup(PanelVacioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(PanelVacioLayout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(LabMensaje)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );

        PanelVentana.add(PanelVacio, "card5");

        PanelVehiculo.setBackground(new java.awt.Color(255, 255, 255));

        LabMarcaV.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 12)); // NOI18N
        LabMarcaV.setForeground(new java.awt.Color(51, 51, 51));
        LabMarcaV.setText("Marca");

        TxtMarcaV.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        TxtMarcaV.setForeground(new java.awt.Color(102, 102, 102));
        TxtMarcaV.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(255, 193, 7)));
        TxtMarcaV.setSelectedTextColor(new java.awt.Color(0, 0, 0));
        TxtMarcaV.setSelectionColor(new java.awt.Color(153, 204, 255));

        LabModeloV.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 12)); // NOI18N
        LabModeloV.setForeground(new java.awt.Color(51, 51, 51));
        LabModeloV.setText("Modelo");

        TxtModeloV.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        TxtModeloV.setForeground(new java.awt.Color(102, 102, 102));
        TxtModeloV.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(255, 193, 7)));
        TxtModeloV.setSelectedTextColor(new java.awt.Color(0, 0, 0));
        TxtModeloV.setSelectionColor(new java.awt.Color(153, 204, 255));

        LabAñoV.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 12)); // NOI18N
        LabAñoV.setForeground(new java.awt.Color(51, 51, 51));
        LabAñoV.setText("Año");

        TxtAñoV.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        TxtAñoV.setForeground(new java.awt.Color(102, 102, 102));
        TxtAñoV.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(255, 193, 7)));
        TxtAñoV.setSelectedTextColor(new java.awt.Color(0, 0, 0));
        TxtAñoV.setSelectionColor(new java.awt.Color(153, 204, 255));

        LabPlacaV.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 12)); // NOI18N
        LabPlacaV.setForeground(new java.awt.Color(51, 51, 51));
        LabPlacaV.setText("Placa");

        TxtPlacaV.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        TxtPlacaV.setForeground(new java.awt.Color(102, 102, 102));
        TxtPlacaV.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(255, 193, 7)));
        TxtPlacaV.setSelectedTextColor(new java.awt.Color(0, 0, 0));
        TxtPlacaV.setSelectionColor(new java.awt.Color(153, 204, 255));

        TablaVehiculo.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        TablaVehiculo.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Marca", "Modelo", "Año", "Placa"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        TablaVehiculo.setGridColor(new java.awt.Color(231, 231, 231));
        TablaVehiculo.setInheritsPopupMenu(true);
        TablaVehiculo.setSelectionBackground(new java.awt.Color(249, 219, 132));
        TablaVehiculo.setSelectionForeground(new java.awt.Color(255, 255, 255));
        ScrollVehiculo.setViewportView(TablaVehiculo);
        if (TablaVehiculo.getColumnModel().getColumnCount() > 0) {
            TablaVehiculo.getColumnModel().getColumn(0).setPreferredWidth(10);
        }

        BtnAgregarVeh.setBackground(new java.awt.Color(40, 197, 158));
        BtnAgregarVeh.setFont(new java.awt.Font("SansSerif", 1, 10)); // NOI18N
        BtnAgregarVeh.setForeground(new java.awt.Color(255, 255, 255));
        BtnAgregarVeh.setText("AGREGAR");
        BtnAgregarVeh.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        BtnAgregarVeh.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnAgregarVehActionPerformed(evt);
            }
        });

        BtnModificarVeh.setBackground(new java.awt.Color(248, 204, 73));
        BtnModificarVeh.setFont(new java.awt.Font("SansSerif", 1, 10)); // NOI18N
        BtnModificarVeh.setForeground(new java.awt.Color(255, 255, 255));
        BtnModificarVeh.setText("MODIFICAR");
        BtnModificarVeh.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        BtnModificarVeh.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnModificarVehActionPerformed(evt);
            }
        });

        BtnEliminarVeh.setBackground(new java.awt.Color(217, 84, 84));
        BtnEliminarVeh.setFont(new java.awt.Font("SansSerif", 1, 10)); // NOI18N
        BtnEliminarVeh.setForeground(new java.awt.Color(255, 255, 255));
        BtnEliminarVeh.setText("ELIMINAR");
        BtnEliminarVeh.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        BtnEliminarVeh.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnEliminarVehActionPerformed(evt);
            }
        });

        TxtIdVehiculo.setEditable(false);
        TxtIdVehiculo.setBackground(new java.awt.Color(255, 255, 255));
        TxtIdVehiculo.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        TxtIdVehiculo.setForeground(new java.awt.Color(102, 102, 102));
        TxtIdVehiculo.setBorder(null);
        TxtIdVehiculo.setSelectedTextColor(new java.awt.Color(0, 0, 0));
        TxtIdVehiculo.setSelectionColor(new java.awt.Color(153, 204, 255));

        javax.swing.GroupLayout PanelVehiculoLayout = new javax.swing.GroupLayout(PanelVehiculo);
        PanelVehiculo.setLayout(PanelVehiculoLayout);
        PanelVehiculoLayout.setHorizontalGroup(
            PanelVehiculoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelVehiculoLayout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addGroup(PanelVehiculoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(LabMarcaV)
                    .addComponent(TxtMarcaV, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(LabModeloV)
                    .addComponent(TxtModeloV, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(LabAñoV)
                    .addComponent(TxtAñoV, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(LabPlacaV)
                    .addComponent(TxtPlacaV, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(PanelVehiculoLayout.createSequentialGroup()
                        .addComponent(BtnAgregarVeh)
                        .addGap(18, 18, 18)
                        .addComponent(BtnModificarVeh)
                        .addGap(18, 18, 18)
                        .addComponent(BtnEliminarVeh))
                    .addComponent(TxtIdVehiculo, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 63, Short.MAX_VALUE)
                .addComponent(ScrollVehiculo, javax.swing.GroupLayout.PREFERRED_SIZE, 501, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30))
        );
        PanelVehiculoLayout.setVerticalGroup(
            PanelVehiculoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelVehiculoLayout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addGroup(PanelVehiculoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(ScrollVehiculo, javax.swing.GroupLayout.PREFERRED_SIZE, 405, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(PanelVehiculoLayout.createSequentialGroup()
                        .addComponent(LabMarcaV)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(TxtMarcaV, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(33, 33, 33)
                        .addComponent(LabModeloV)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(TxtModeloV, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(36, 36, 36)
                        .addComponent(LabAñoV)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(TxtAñoV, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(35, 35, 35)
                        .addComponent(LabPlacaV)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(TxtPlacaV, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(TxtIdVehiculo, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(PanelVehiculoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(BtnAgregarVeh, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(BtnModificarVeh, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(BtnEliminarVeh, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(62, Short.MAX_VALUE))
        );

        PanelVentana.add(PanelVehiculo, "card2");

        PanelMantenimiento.setBackground(new java.awt.Color(255, 255, 255));

        LabIdVehiculoM.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 12)); // NOI18N
        LabIdVehiculoM.setForeground(new java.awt.Color(51, 51, 51));
        LabIdVehiculoM.setText("ID Vehículo");

        TxtIdVehiculoM.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        TxtIdVehiculoM.setForeground(new java.awt.Color(102, 102, 102));
        TxtIdVehiculoM.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(255, 193, 7)));
        TxtIdVehiculoM.setSelectedTextColor(new java.awt.Color(0, 0, 0));
        TxtIdVehiculoM.setSelectionColor(new java.awt.Color(153, 204, 255));

        LabFechaM.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 12)); // NOI18N
        LabFechaM.setForeground(new java.awt.Color(51, 51, 51));
        LabFechaM.setText("Fecha");

        TxtFechaM.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        TxtFechaM.setForeground(new java.awt.Color(102, 102, 102));
        TxtFechaM.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(255, 193, 7)));
        TxtFechaM.setSelectedTextColor(new java.awt.Color(0, 0, 0));
        TxtFechaM.setSelectionColor(new java.awt.Color(153, 204, 255));

        LabTipoM.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 12)); // NOI18N
        LabTipoM.setForeground(new java.awt.Color(51, 51, 51));
        LabTipoM.setText("Tipo de Mantenimiento");

        TxtTipoM.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        TxtTipoM.setForeground(new java.awt.Color(102, 102, 102));
        TxtTipoM.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(255, 193, 7)));
        TxtTipoM.setSelectedTextColor(new java.awt.Color(0, 0, 0));
        TxtTipoM.setSelectionColor(new java.awt.Color(153, 204, 255));

        LabCostoM.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 12)); // NOI18N
        LabCostoM.setForeground(new java.awt.Color(51, 51, 51));
        LabCostoM.setText("Costo");

        TxtCostoM.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        TxtCostoM.setForeground(new java.awt.Color(102, 102, 102));
        TxtCostoM.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(255, 193, 7)));
        TxtCostoM.setSelectedTextColor(new java.awt.Color(0, 0, 0));
        TxtCostoM.setSelectionColor(new java.awt.Color(153, 204, 255));

        TablaMantenimiento.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        TablaMantenimiento.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "ID Vh", "Fecha", "Tipo", "Costo"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.Double.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        TablaMantenimiento.setGridColor(new java.awt.Color(231, 231, 231));
        TablaMantenimiento.setInheritsPopupMenu(true);
        TablaMantenimiento.setSelectionBackground(new java.awt.Color(249, 219, 132));
        TablaMantenimiento.setSelectionForeground(new java.awt.Color(255, 255, 255));
        ScrollMantenimiento.setViewportView(TablaMantenimiento);
        if (TablaMantenimiento.getColumnModel().getColumnCount() > 0) {
            TablaMantenimiento.getColumnModel().getColumn(0).setPreferredWidth(10);
        }

        BtnAgregarMan.setBackground(new java.awt.Color(40, 197, 158));
        BtnAgregarMan.setFont(new java.awt.Font("SansSerif", 1, 10)); // NOI18N
        BtnAgregarMan.setForeground(new java.awt.Color(255, 255, 255));
        BtnAgregarMan.setText("AGREGAR");
        BtnAgregarMan.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        BtnAgregarMan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnAgregarManActionPerformed(evt);
            }
        });

        BtnModificarMan.setBackground(new java.awt.Color(248, 204, 73));
        BtnModificarMan.setFont(new java.awt.Font("SansSerif", 1, 10)); // NOI18N
        BtnModificarMan.setForeground(new java.awt.Color(255, 255, 255));
        BtnModificarMan.setText("MODIFICAR");
        BtnModificarMan.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        BtnModificarMan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnModificarManActionPerformed(evt);
            }
        });

        BtnEliminarMan.setBackground(new java.awt.Color(217, 84, 84));
        BtnEliminarMan.setFont(new java.awt.Font("SansSerif", 1, 10)); // NOI18N
        BtnEliminarMan.setForeground(new java.awt.Color(255, 255, 255));
        BtnEliminarMan.setText("ELIMINAR");
        BtnEliminarMan.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        BtnEliminarMan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnEliminarManActionPerformed(evt);
            }
        });

        TxtIdMantenimiento.setEditable(false);
        TxtIdMantenimiento.setBackground(new java.awt.Color(255, 255, 255));
        TxtIdMantenimiento.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        TxtIdMantenimiento.setForeground(new java.awt.Color(102, 102, 102));
        TxtIdMantenimiento.setBorder(null);
        TxtIdMantenimiento.setSelectedTextColor(new java.awt.Color(0, 0, 0));
        TxtIdMantenimiento.setSelectionColor(new java.awt.Color(153, 204, 255));

        javax.swing.GroupLayout PanelMantenimientoLayout = new javax.swing.GroupLayout(PanelMantenimiento);
        PanelMantenimiento.setLayout(PanelMantenimientoLayout);
        PanelMantenimientoLayout.setHorizontalGroup(
            PanelMantenimientoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelMantenimientoLayout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addGroup(PanelMantenimientoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(LabIdVehiculoM)
                    .addComponent(TxtIdVehiculoM, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(LabFechaM)
                    .addComponent(TxtFechaM, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(LabTipoM)
                    .addComponent(TxtTipoM, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(LabCostoM)
                    .addComponent(TxtCostoM, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(PanelMantenimientoLayout.createSequentialGroup()
                        .addComponent(BtnAgregarMan)
                        .addGap(18, 18, 18)
                        .addComponent(BtnModificarMan)
                        .addGap(18, 18, 18)
                        .addComponent(BtnEliminarMan))
                    .addComponent(TxtIdMantenimiento, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 44, Short.MAX_VALUE)
                .addComponent(ScrollMantenimiento, javax.swing.GroupLayout.PREFERRED_SIZE, 520, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30))
        );
        PanelMantenimientoLayout.setVerticalGroup(
            PanelMantenimientoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelMantenimientoLayout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addGroup(PanelMantenimientoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(ScrollMantenimiento, javax.swing.GroupLayout.PREFERRED_SIZE, 405, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(PanelMantenimientoLayout.createSequentialGroup()
                        .addComponent(LabIdVehiculoM)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(TxtIdVehiculoM, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(33, 33, 33)
                        .addComponent(LabFechaM)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(TxtFechaM, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(36, 36, 36)
                        .addComponent(LabTipoM)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(TxtTipoM, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(35, 35, 35)
                        .addComponent(LabCostoM)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(TxtCostoM, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(TxtIdMantenimiento, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(PanelMantenimientoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(BtnAgregarMan, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(BtnModificarMan, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(BtnEliminarMan, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(62, Short.MAX_VALUE))
        );

        PanelVentana.add(PanelMantenimiento, "card3");

        PanelRepuesto.setBackground(new java.awt.Color(255, 255, 255));

        LabIdManteR.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 12)); // NOI18N
        LabIdManteR.setForeground(new java.awt.Color(51, 51, 51));
        LabIdManteR.setText("ID Mantenimiento");

        TxtIdManteR.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        TxtIdManteR.setForeground(new java.awt.Color(102, 102, 102));
        TxtIdManteR.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(255, 193, 7)));
        TxtIdManteR.setSelectedTextColor(new java.awt.Color(0, 0, 0));
        TxtIdManteR.setSelectionColor(new java.awt.Color(153, 204, 255));

        LabNombreR.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 12)); // NOI18N
        LabNombreR.setForeground(new java.awt.Color(51, 51, 51));
        LabNombreR.setText("Nombre");

        TxtNombreR.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        TxtNombreR.setForeground(new java.awt.Color(102, 102, 102));
        TxtNombreR.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(255, 193, 7)));
        TxtNombreR.setSelectedTextColor(new java.awt.Color(0, 0, 0));
        TxtNombreR.setSelectionColor(new java.awt.Color(153, 204, 255));

        LabCostoR.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 12)); // NOI18N
        LabCostoR.setForeground(new java.awt.Color(51, 51, 51));
        LabCostoR.setText("Costo");

        TxtCostoR.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        TxtCostoR.setForeground(new java.awt.Color(102, 102, 102));
        TxtCostoR.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(255, 193, 7)));
        TxtCostoR.setSelectedTextColor(new java.awt.Color(0, 0, 0));
        TxtCostoR.setSelectionColor(new java.awt.Color(153, 204, 255));

        TablaRepuesto.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        TablaRepuesto.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "ID Mnto", "Nombre", "Costo"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.Integer.class, java.lang.String.class, java.lang.Double.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        TablaRepuesto.setGridColor(new java.awt.Color(231, 231, 231));
        TablaRepuesto.setInheritsPopupMenu(true);
        TablaRepuesto.setSelectionBackground(new java.awt.Color(249, 219, 132));
        TablaRepuesto.setSelectionForeground(new java.awt.Color(255, 255, 255));
        ScrollRepuesto.setViewportView(TablaRepuesto);
        if (TablaRepuesto.getColumnModel().getColumnCount() > 0) {
            TablaRepuesto.getColumnModel().getColumn(0).setPreferredWidth(10);
        }

        BtnAgregarRep.setBackground(new java.awt.Color(40, 197, 158));
        BtnAgregarRep.setFont(new java.awt.Font("SansSerif", 1, 10)); // NOI18N
        BtnAgregarRep.setForeground(new java.awt.Color(255, 255, 255));
        BtnAgregarRep.setText("AGREGAR");
        BtnAgregarRep.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        BtnAgregarRep.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnAgregarRepActionPerformed(evt);
            }
        });

        BtnModificarRep.setBackground(new java.awt.Color(248, 204, 73));
        BtnModificarRep.setFont(new java.awt.Font("SansSerif", 1, 10)); // NOI18N
        BtnModificarRep.setForeground(new java.awt.Color(255, 255, 255));
        BtnModificarRep.setText("MODIFICAR");
        BtnModificarRep.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        BtnModificarRep.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnModificarRepActionPerformed(evt);
            }
        });

        BtnEliminarRep.setBackground(new java.awt.Color(217, 84, 84));
        BtnEliminarRep.setFont(new java.awt.Font("SansSerif", 1, 10)); // NOI18N
        BtnEliminarRep.setForeground(new java.awt.Color(255, 255, 255));
        BtnEliminarRep.setText("ELIMINAR");
        BtnEliminarRep.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        BtnEliminarRep.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnEliminarRepActionPerformed(evt);
            }
        });

        TxtIdRepuesto.setEditable(false);
        TxtIdRepuesto.setBackground(new java.awt.Color(255, 255, 255));
        TxtIdRepuesto.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        TxtIdRepuesto.setForeground(new java.awt.Color(102, 102, 102));
        TxtIdRepuesto.setBorder(null);
        TxtIdRepuesto.setSelectedTextColor(new java.awt.Color(0, 0, 0));
        TxtIdRepuesto.setSelectionColor(new java.awt.Color(153, 204, 255));

        javax.swing.GroupLayout PanelRepuestoLayout = new javax.swing.GroupLayout(PanelRepuesto);
        PanelRepuesto.setLayout(PanelRepuestoLayout);
        PanelRepuestoLayout.setHorizontalGroup(
            PanelRepuestoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelRepuestoLayout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addGroup(PanelRepuestoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(LabIdManteR)
                    .addComponent(TxtIdManteR, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(LabNombreR)
                    .addComponent(TxtNombreR, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(LabCostoR)
                    .addComponent(TxtCostoR, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(PanelRepuestoLayout.createSequentialGroup()
                        .addComponent(BtnAgregarRep)
                        .addGap(18, 18, 18)
                        .addComponent(BtnModificarRep)
                        .addGap(18, 18, 18)
                        .addComponent(BtnEliminarRep))
                    .addComponent(TxtIdRepuesto, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 84, Short.MAX_VALUE)
                .addComponent(ScrollRepuesto, javax.swing.GroupLayout.PREFERRED_SIZE, 480, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30))
        );
        PanelRepuestoLayout.setVerticalGroup(
            PanelRepuestoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelRepuestoLayout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addGroup(PanelRepuestoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(ScrollRepuesto, javax.swing.GroupLayout.PREFERRED_SIZE, 405, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(PanelRepuestoLayout.createSequentialGroup()
                        .addComponent(LabIdManteR)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(TxtIdManteR, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(54, 54, 54)
                        .addComponent(LabNombreR)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(TxtNombreR, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(57, 57, 57)
                        .addComponent(LabCostoR)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(TxtCostoR, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(TxtIdRepuesto, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(PanelRepuestoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(BtnAgregarRep, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(BtnModificarRep, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(BtnEliminarRep, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(62, Short.MAX_VALUE))
        );

        PanelVentana.add(PanelRepuesto, "card4");

        javax.swing.GroupLayout PanelFondoLayout = new javax.swing.GroupLayout(PanelFondo);
        PanelFondo.setLayout(PanelFondoLayout);
        PanelFondoLayout.setHorizontalGroup(
            PanelFondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(PanelMenu, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(PanelVentana, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
        );
        PanelFondoLayout.setVerticalGroup(
            PanelFondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelFondoLayout.createSequentialGroup()
                .addComponent(PanelMenu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(PanelVentana, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(PanelFondo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(PanelFondo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void LabVehiculoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_LabVehiculoMouseClicked
        LabVehiculo.setBackground(new Color(0, 156, 117));
        PanelVehiculo.setVisible(true);
        
        PanelVacio.setVisible(false);
        
        LabMantenimiento.setBackground(new Color(40, 197, 158));
        PanelMantenimiento.setVisible(false);
        
        LabRepuesto.setBackground(new Color(40, 197, 158));
        PanelRepuesto.setVisible(false);
    }//GEN-LAST:event_LabVehiculoMouseClicked

    private void LabMantenimientoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_LabMantenimientoMouseClicked
        LabMantenimiento.setBackground(new Color(0, 156, 117));
        PanelMantenimiento.setVisible(true);
        
        PanelVacio.setVisible(false);
        
        LabVehiculo.setBackground(new Color(40, 197, 158));
        PanelVehiculo.setVisible(false);
        
        LabRepuesto.setBackground(new Color(40, 197, 158));
        PanelRepuesto.setVisible(false);
    }//GEN-LAST:event_LabMantenimientoMouseClicked

    private void LabRepuestoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_LabRepuestoMouseClicked
        LabRepuesto.setBackground(new Color(0, 156, 117));
        PanelRepuesto.setVisible(true);
        
        PanelVacio.setVisible(false);
        
        LabVehiculo.setBackground(new Color(40, 197, 158));
        PanelVehiculo.setVisible(false);
        
        LabMantenimiento.setBackground(new Color(40, 197, 158));
        PanelMantenimiento.setVisible(false);
    }//GEN-LAST:event_LabRepuestoMouseClicked

    private void LabTalleresMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_LabTalleresMouseClicked
        TalleresView taller = new TalleresView(controllerVehiculo, controllerMantenimiento, controllerRepuesto, controllerTaller);
        taller.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_LabTalleresMouseClicked

    private void LabTalleresMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_LabTalleresMouseEntered
        LabTalleres.setBackground(new Color(40, 197, 158));
        LabTalleres.setForeground(Color.white);
    }//GEN-LAST:event_LabTalleresMouseEntered

    private void LabTalleresMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_LabTalleresMouseExited
        LabTalleres.setBackground(new Color(190, 242, 228));
        LabTalleres.setForeground(new Color(51, 51, 51));
    }//GEN-LAST:event_LabTalleresMouseExited

    private void BtnAgregarVehActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnAgregarVehActionPerformed
    String marca, modelo, placa, mensaje;
    int año;

        controllerVehiculo = new VehiculoController();

        marca = this.TxtMarcaV.getText();
        modelo = this.TxtModeloV.getText();
        año = Integer.parseInt(this.TxtAñoV.getText());
        placa = this.TxtPlacaV.getText();

        mensaje = controllerVehiculo.insertarVehiculo(marca, modelo, año, placa);
        JOptionPane.showMessageDialog(null, mensaje, "Información", JOptionPane.INFORMATION_MESSAGE);
        
        limpiarCampos();
        actualizarTabla();
    }//GEN-LAST:event_BtnAgregarVehActionPerformed

    private void BtnModificarRepActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnModificarRepActionPerformed
        String nombre, mensaje;
        int idRepuesto, idMantenimiento;
        double costo;

        controllerRepuesto = new RepuestoController();

        int selectedRow = TablaRepuesto.getSelectedRow();
        if (selectedRow != -1) {

            idRepuesto = Integer.parseInt(this.TxtIdRepuesto.getText());
            idMantenimiento = Integer.parseInt(this.TxtIdManteR.getText());
            nombre = this.TxtNombreR.getText();
            costo = Double.parseDouble(this.TxtCostoR.getText());

        mensaje = controllerRepuesto.modificarRepuesto(idRepuesto, idMantenimiento, nombre, costo);
        JOptionPane.showMessageDialog(null, mensaje, "Información", JOptionPane.INFORMATION_MESSAGE);

        limpiarCampos();
        actualizarTabla();
        } else {
        JOptionPane.showMessageDialog(null, "Seleccione un repuesto para modificar", "Información", JOptionPane.INFORMATION_MESSAGE);
    }
    }//GEN-LAST:event_BtnModificarRepActionPerformed

    private void BtnModificarVehActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnModificarVehActionPerformed
        String marca, modelo, placa, mensaje;
        int idVehiculo, año;

        controllerVehiculo = new VehiculoController();

        int selectedRow = TablaVehiculo.getSelectedRow();
        if (selectedRow != -1) {
            
        idVehiculo = Integer.parseInt(this.TxtIdVehiculo.getText());
        marca = this.TxtMarcaV.getText();
        modelo = this.TxtModeloV.getText();
        año = Integer.parseInt(this.TxtAñoV.getText());
        placa = this.TxtPlacaV.getText();

    mensaje = controllerVehiculo.modificarVehiculo(idVehiculo, marca, modelo, año, placa);
    JOptionPane.showMessageDialog(null, mensaje, "Información", JOptionPane.INFORMATION_MESSAGE);
    
        limpiarCampos();
        actualizarTabla();
    } else {
    JOptionPane.showMessageDialog(null, "Seleccione una fila para modificar", "Información", JOptionPane.INFORMATION_MESSAGE);
}  
    }//GEN-LAST:event_BtnModificarVehActionPerformed

    private void BtnEliminarVehActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnEliminarVehActionPerformed
        int selectedRow = TablaVehiculo.getSelectedRow();
        if (selectedRow != -1) {
        int idVehiculo = Integer.parseInt(this.TxtIdVehiculo.getText());
        
            String mensaje = controllerVehiculo.eliminarVehiculo(idVehiculo);
            JOptionPane.showMessageDialog(null, mensaje, "Información", JOptionPane.INFORMATION_MESSAGE);
            
            limpiarCampos();
            actualizarTabla();
            
        } else {
            JOptionPane.showMessageDialog(null, "Seleccione un vehículo para eliminar", "Información", JOptionPane.INFORMATION_MESSAGE);
        }
    }//GEN-LAST:event_BtnEliminarVehActionPerformed

    private void BtnAgregarManActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnAgregarManActionPerformed
        String fecha, tipo, mensaje;
        int idVehiculo;
        double costo;

            controllerMantenimiento = new MantenimientoController();

            idVehiculo = Integer.parseInt(this.TxtIdVehiculoM.getText());
            fecha = this.TxtFechaM.getText();
            tipo = this.TxtTipoM.getText();
            costo = Double.parseDouble(this.TxtCostoM.getText());

            mensaje = controllerMantenimiento.insertarMantenimiento(idVehiculo, fecha, tipo, costo);
            JOptionPane.showMessageDialog(null, mensaje, "Información", JOptionPane.INFORMATION_MESSAGE);
        
        limpiarCampos();
        actualizarTabla();
    }//GEN-LAST:event_BtnAgregarManActionPerformed

    private void BtnModificarManActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnModificarManActionPerformed
        String fecha, tipo, mensaje;
        int idMantenimiento, idVehiculo;
        double costo;

        controllerMantenimiento = new MantenimientoController();

        int selectedRow = TablaMantenimiento.getSelectedRow();
        if (selectedRow != -1) {
            
            idMantenimiento = Integer.parseInt(this.TxtIdMantenimiento.getText());
            idVehiculo = Integer.parseInt(this.TxtIdVehiculoM.getText());
            fecha = this.TxtFechaM.getText();
            tipo = this.TxtTipoM.getText();
            costo = Double.parseDouble(this.TxtCostoM.getText());

        mensaje = controllerMantenimiento.modificarMantenimiento(idMantenimiento, idVehiculo, fecha, tipo, costo);
        JOptionPane.showMessageDialog(null, mensaje, "Información", JOptionPane.INFORMATION_MESSAGE);
    
            limpiarCampos();
            actualizarTabla();
    } else {
        JOptionPane.showMessageDialog(null, "Seleccione una fila para modificar", "Información", JOptionPane.INFORMATION_MESSAGE);
    }  
    }//GEN-LAST:event_BtnModificarManActionPerformed

    private void BtnEliminarManActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnEliminarManActionPerformed
        int selectedRow = TablaMantenimiento.getSelectedRow();
        if (selectedRow != -1) {
        int idMantenimiento = Integer.parseInt(this.TxtIdMantenimiento.getText());
        
            String mensaje = controllerMantenimiento.eliminarMantenimiento(idMantenimiento);
            JOptionPane.showMessageDialog(null, mensaje, "Información", JOptionPane.INFORMATION_MESSAGE);
            
            limpiarCampos();
            actualizarTabla();
            
        } else {
            JOptionPane.showMessageDialog(null, "Seleccione un vehículo para eliminar", "Información", JOptionPane.INFORMATION_MESSAGE);
        }
    }//GEN-LAST:event_BtnEliminarManActionPerformed

    private void BtnAgregarRepActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnAgregarRepActionPerformed
        String nombre, mensaje;
        int idMantenimiento;
        double costo;

            controllerRepuesto = new RepuestoController();

            idMantenimiento = Integer.parseInt(this.TxtIdManteR.getText());
            nombre = this.TxtNombreR.getText();
            costo = Double.parseDouble(this.TxtCostoR.getText());

        mensaje = controllerRepuesto.insertarRepuesto(idMantenimiento, nombre, costo);
        JOptionPane.showMessageDialog(null, mensaje, "Información", JOptionPane.INFORMATION_MESSAGE);

        
        limpiarCampos();
        actualizarTabla();
    }//GEN-LAST:event_BtnAgregarRepActionPerformed

    private void BtnEliminarRepActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnEliminarRepActionPerformed
        int selectedRow = TablaRepuesto.getSelectedRow();
        if (selectedRow != -1) {
        int idRepuesto = Integer.parseInt(this.TxtIdRepuesto.getText());

            String mensaje = controllerRepuesto.eliminarRepuesto(idRepuesto);
            JOptionPane.showMessageDialog(null, mensaje, "Información", JOptionPane.INFORMATION_MESSAGE);

        limpiarCampos();
        actualizarTabla();

    } else {
        JOptionPane.showMessageDialog(null, "Seleccione un repuesto para eliminar", "Información", JOptionPane.INFORMATION_MESSAGE);
    }
    }//GEN-LAST:event_BtnEliminarRepActionPerformed

    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(VehiculosView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(VehiculosView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(VehiculosView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(VehiculosView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                //new VehiculosView().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BtnAgregarMan;
    private javax.swing.JButton BtnAgregarRep;
    private javax.swing.JButton BtnAgregarVeh;
    private javax.swing.JButton BtnEliminarMan;
    private javax.swing.JButton BtnEliminarRep;
    private javax.swing.JButton BtnEliminarVeh;
    private javax.swing.JButton BtnModificarMan;
    private javax.swing.JButton BtnModificarRep;
    private javax.swing.JButton BtnModificarVeh;
    private javax.swing.JLabel LabAñoV;
    private javax.swing.JLabel LabCostoM;
    private javax.swing.JLabel LabCostoR;
    private javax.swing.JLabel LabFechaM;
    private javax.swing.JLabel LabIdManteR;
    private javax.swing.JLabel LabIdVehiculoM;
    private javax.swing.JLabel LabMantenimiento;
    private javax.swing.JLabel LabMarcaV;
    private javax.swing.JLabel LabMensaje;
    private javax.swing.JLabel LabModeloV;
    private javax.swing.JLabel LabNombreR;
    private javax.swing.JLabel LabPlacaV;
    private javax.swing.JLabel LabRepuesto;
    private javax.swing.JLabel LabTalleres;
    private javax.swing.JLabel LabTipoM;
    private javax.swing.JLabel LabVehiculo;
    private javax.swing.JPanel PanelFondo;
    private javax.swing.JPanel PanelMantenimiento;
    private javax.swing.JPanel PanelMenu;
    private javax.swing.JPanel PanelRepuesto;
    private javax.swing.JPanel PanelVacio;
    private javax.swing.JPanel PanelVehiculo;
    private javax.swing.JPanel PanelVentana;
    private javax.swing.JScrollPane ScrollMantenimiento;
    private javax.swing.JScrollPane ScrollRepuesto;
    private javax.swing.JScrollPane ScrollVehiculo;
    private javax.swing.JTable TablaMantenimiento;
    private javax.swing.JTable TablaRepuesto;
    private javax.swing.JTable TablaVehiculo;
    private javax.swing.JTextField TxtAñoV;
    private javax.swing.JTextField TxtCostoM;
    private javax.swing.JTextField TxtCostoR;
    private javax.swing.JTextField TxtFechaM;
    private javax.swing.JTextField TxtIdManteR;
    private javax.swing.JTextField TxtIdMantenimiento;
    private javax.swing.JTextField TxtIdRepuesto;
    private javax.swing.JTextField TxtIdVehiculo;
    private javax.swing.JTextField TxtIdVehiculoM;
    private javax.swing.JTextField TxtMarcaV;
    private javax.swing.JTextField TxtModeloV;
    private javax.swing.JTextField TxtNombreR;
    private javax.swing.JTextField TxtPlacaV;
    private javax.swing.JTextField TxtTipoM;
    // End of variables declaration//GEN-END:variables
}
