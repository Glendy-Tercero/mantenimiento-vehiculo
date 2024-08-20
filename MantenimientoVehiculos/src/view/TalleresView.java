/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package view;

import java.awt.Color;
import java.awt.Font;
import static javax.swing.SwingConstants.CENTER;
import javax.swing.table.DefaultTableCellRenderer;
import controller.MantenimientoController;
import controller.RepuestoController;
import controller.TallerController;
import controller.VehiculoController;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import model.TallerModel;

public class TalleresView extends javax.swing.JFrame {

    private VehiculoController controllerVehiculo;
    private MantenimientoController controllerMantenimiento;
    private RepuestoController controllerRepuesto;
    private TallerController controllerTaller;
    
    public TalleresView(VehiculoController vehiculoController, MantenimientoController mantenimientoController, RepuestoController repuestoController, TallerController tallerController) {
        initComponents();
        controllerVehiculo = vehiculoController;
        controllerMantenimiento = mantenimientoController;
        controllerRepuesto = repuestoController;
        controllerTaller = tallerController;
        tablas();
        textField();
        obtenerTaller();
        seleccionarTaller();
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
        }; TablaTaller.getTableHeader().setDefaultRenderer(encabezado);
            TablaTaller.setRowHeight(20);
            TablaManteTaller.getTableHeader().setDefaultRenderer(encabezado);
            TablaManteTaller.setRowHeight(20);
    }
    
    private void textField() {
        TxtIdTaller.setVisible(false);
        TxtIdManteTaller.setVisible(false);
    }
    
    private void limpiarCampos() {
        TxtNombreT.setText("");
        TxtDireccionT.setText("");
        
        TxtIdManteMT.setText("");
        TxtIdTallerMT.setText("");
    }

    private void actualizarTabla() {
        DefaultTableModel tablaTaller = (DefaultTableModel) TablaTaller.getModel();
        tablaTaller.setRowCount(0);
        obtenerTaller();
    }
    
    private void obtenerTaller() {
    DefaultTableModel tablaTalleres = (DefaultTableModel) TablaTaller.getModel();
    List<TallerModel> talleres = controllerTaller.obtenerTalleres();
    tablaTalleres.setRowCount(0);
    for (TallerModel taller : talleres) {
        Object[] fila = {taller.getIdTaller(), taller.getNombre(), taller.getDireccion()};
        tablaTalleres.addRow(fila);
        }
    }
    
    private void seleccionarTaller() { 
    TablaTaller.getSelectionModel().addListSelectionListener(event -> {
        if (!event.getValueIsAdjusting() && TablaTaller.getSelectedRow() != -1) {
            int selectedRow = TablaTaller.getSelectedRow();
            TxtIdTaller.setText(TablaTaller.getValueAt(selectedRow, 0).toString());
            TxtNombreT.setText(TablaTaller.getValueAt(selectedRow, 1).toString());
            TxtDireccionT.setText(TablaTaller.getValueAt(selectedRow, 2).toString());
            }
        });
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        PanelFondo = new javax.swing.JPanel();
        PanelMenu = new javax.swing.JPanel();
        LabMantenimiento = new javax.swing.JLabel();
        LabTaller = new javax.swing.JLabel();
        LabVehiculos = new javax.swing.JLabel();
        PanelVentana = new javax.swing.JPanel();
        PanelVacio = new javax.swing.JPanel();
        LabMensaje = new javax.swing.JLabel();
        PanelTaller = new javax.swing.JPanel();
        LabNombreT = new javax.swing.JLabel();
        TxtNombreT = new javax.swing.JTextField();
        LabDireccionT = new javax.swing.JLabel();
        TxtDireccionT = new javax.swing.JTextField();
        ScrollTaller = new javax.swing.JScrollPane();
        TablaTaller = new javax.swing.JTable();
        BtnAgregarTal = new javax.swing.JButton();
        BtnModificarTal = new javax.swing.JButton();
        BtnEliminarTal = new javax.swing.JButton();
        TxtIdTaller = new javax.swing.JTextField();
        PanelManteTaller = new javax.swing.JPanel();
        LabIdManteMT = new javax.swing.JLabel();
        TxtIdManteMT = new javax.swing.JTextField();
        LabIdTallerMT = new javax.swing.JLabel();
        TxtIdTallerMT = new javax.swing.JTextField();
        ScrollManteTaller = new javax.swing.JScrollPane();
        TablaManteTaller = new javax.swing.JTable();
        BtnAgregarMan = new javax.swing.JButton();
        BtnModificarMan = new javax.swing.JButton();
        BtnEliminarMan = new javax.swing.JButton();
        TxtIdManteTaller = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        PanelFondo.setBackground(new java.awt.Color(255, 255, 255));

        PanelMenu.setBackground(new java.awt.Color(207, 236, 228));
        PanelMenu.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 3, 0, new java.awt.Color(0, 156, 117)));

        LabMantenimiento.setBackground(new java.awt.Color(40, 197, 158));
        LabMantenimiento.setFont(new java.awt.Font("Trebuchet MS", 0, 14)); // NOI18N
        LabMantenimiento.setForeground(new java.awt.Color(255, 255, 255));
        LabMantenimiento.setText("    Mantenimiento - Taller");
        LabMantenimiento.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        LabMantenimiento.setOpaque(true);
        LabMantenimiento.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                LabMantenimientoMouseClicked(evt);
            }
        });

        LabTaller.setBackground(new java.awt.Color(40, 197, 158));
        LabTaller.setFont(new java.awt.Font("Trebuchet MS", 0, 14)); // NOI18N
        LabTaller.setForeground(new java.awt.Color(255, 255, 255));
        LabTaller.setText("    Talleres");
        LabTaller.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 0, 1, new java.awt.Color(204, 204, 204)));
        LabTaller.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        LabTaller.setOpaque(true);
        LabTaller.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                LabTallerMouseClicked(evt);
            }
        });

        LabVehiculos.setBackground(new java.awt.Color(190, 242, 228));
        LabVehiculos.setFont(new java.awt.Font("Segoe UI Symbol", 1, 14)); // NOI18N
        LabVehiculos.setForeground(new java.awt.Color(51, 51, 51));
        LabVehiculos.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        LabVehiculos.setText("Vehículos 🢇");
        LabVehiculos.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(160, 222, 205), 1, true));
        LabVehiculos.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        LabVehiculos.setOpaque(true);
        LabVehiculos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                LabVehiculosMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                LabVehiculosMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                LabVehiculosMouseExited(evt);
            }
        });

        javax.swing.GroupLayout PanelMenuLayout = new javax.swing.GroupLayout(PanelMenu);
        PanelMenu.setLayout(PanelMenuLayout);
        PanelMenuLayout.setHorizontalGroup(
            PanelMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelMenuLayout.createSequentialGroup()
                .addComponent(LabTaller, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(LabMantenimiento, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(460, 460, 460)
                .addComponent(LabVehiculos, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        PanelMenuLayout.setVerticalGroup(
            PanelMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(LabTaller, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addComponent(LabMantenimiento, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addComponent(LabVehiculos, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
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
            .addGap(0, 454, Short.MAX_VALUE)
            .addGroup(PanelVacioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(PanelVacioLayout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(LabMensaje)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );

        PanelVentana.add(PanelVacio, "card4");

        PanelTaller.setBackground(new java.awt.Color(255, 255, 255));

        LabNombreT.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 12)); // NOI18N
        LabNombreT.setForeground(new java.awt.Color(51, 51, 51));
        LabNombreT.setText("Nombre del Taller");

        TxtNombreT.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        TxtNombreT.setForeground(new java.awt.Color(102, 102, 102));
        TxtNombreT.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(255, 193, 7)));
        TxtNombreT.setSelectedTextColor(new java.awt.Color(0, 0, 0));
        TxtNombreT.setSelectionColor(new java.awt.Color(153, 204, 255));

        LabDireccionT.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 12)); // NOI18N
        LabDireccionT.setForeground(new java.awt.Color(51, 51, 51));
        LabDireccionT.setText("Dirección");

        TxtDireccionT.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        TxtDireccionT.setForeground(new java.awt.Color(102, 102, 102));
        TxtDireccionT.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(255, 193, 7)));
        TxtDireccionT.setSelectedTextColor(new java.awt.Color(0, 0, 0));
        TxtDireccionT.setSelectionColor(new java.awt.Color(153, 204, 255));

        TablaTaller.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        TablaTaller.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Nombre", "Dirección"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        TablaTaller.setGridColor(new java.awt.Color(231, 231, 231));
        TablaTaller.setInheritsPopupMenu(true);
        TablaTaller.setSelectionBackground(new java.awt.Color(249, 219, 132));
        TablaTaller.setSelectionForeground(new java.awt.Color(255, 255, 255));
        ScrollTaller.setViewportView(TablaTaller);
        if (TablaTaller.getColumnModel().getColumnCount() > 0) {
            TablaTaller.getColumnModel().getColumn(0).setPreferredWidth(10);
        }

        BtnAgregarTal.setBackground(new java.awt.Color(40, 197, 158));
        BtnAgregarTal.setFont(new java.awt.Font("SansSerif", 1, 10)); // NOI18N
        BtnAgregarTal.setForeground(new java.awt.Color(255, 255, 255));
        BtnAgregarTal.setText("AGREGAR");
        BtnAgregarTal.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        BtnAgregarTal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnAgregarTalActionPerformed(evt);
            }
        });

        BtnModificarTal.setBackground(new java.awt.Color(248, 204, 73));
        BtnModificarTal.setFont(new java.awt.Font("SansSerif", 1, 10)); // NOI18N
        BtnModificarTal.setForeground(new java.awt.Color(255, 255, 255));
        BtnModificarTal.setText("MODIFICAR");
        BtnModificarTal.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        BtnModificarTal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnModificarTalActionPerformed(evt);
            }
        });

        BtnEliminarTal.setBackground(new java.awt.Color(217, 84, 84));
        BtnEliminarTal.setFont(new java.awt.Font("SansSerif", 1, 10)); // NOI18N
        BtnEliminarTal.setForeground(new java.awt.Color(255, 255, 255));
        BtnEliminarTal.setText("ELIMINAR");
        BtnEliminarTal.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        BtnEliminarTal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnEliminarTalActionPerformed(evt);
            }
        });

        TxtIdTaller.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        TxtIdTaller.setForeground(new java.awt.Color(102, 102, 102));
        TxtIdTaller.setBorder(null);
        TxtIdTaller.setSelectedTextColor(new java.awt.Color(0, 0, 0));
        TxtIdTaller.setSelectionColor(new java.awt.Color(153, 204, 255));

        javax.swing.GroupLayout PanelTallerLayout = new javax.swing.GroupLayout(PanelTaller);
        PanelTaller.setLayout(PanelTallerLayout);
        PanelTallerLayout.setHorizontalGroup(
            PanelTallerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelTallerLayout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addGroup(PanelTallerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(LabNombreT)
                    .addComponent(TxtNombreT, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(LabDireccionT)
                    .addComponent(TxtDireccionT, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(PanelTallerLayout.createSequentialGroup()
                        .addComponent(BtnAgregarTal)
                        .addGap(18, 18, 18)
                        .addComponent(BtnModificarTal)
                        .addGap(18, 18, 18)
                        .addComponent(BtnEliminarTal))
                    .addComponent(TxtIdTaller, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 74, Short.MAX_VALUE)
                .addComponent(ScrollTaller, javax.swing.GroupLayout.PREFERRED_SIZE, 490, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30))
        );
        PanelTallerLayout.setVerticalGroup(
            PanelTallerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelTallerLayout.createSequentialGroup()
                .addGroup(PanelTallerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(PanelTallerLayout.createSequentialGroup()
                        .addGap(17, 17, 17)
                        .addComponent(ScrollTaller, javax.swing.GroupLayout.PREFERRED_SIZE, 405, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(PanelTallerLayout.createSequentialGroup()
                        .addGap(59, 59, 59)
                        .addComponent(LabNombreT)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(TxtNombreT, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(60, 60, 60)
                        .addComponent(LabDireccionT)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(TxtDireccionT, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(63, 63, 63)
                        .addComponent(TxtIdTaller, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(PanelTallerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(BtnAgregarTal, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(BtnModificarTal, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(BtnEliminarTal, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(32, Short.MAX_VALUE))
        );

        PanelVentana.add(PanelTaller, "card2");

        PanelManteTaller.setBackground(new java.awt.Color(255, 255, 255));

        LabIdManteMT.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 12)); // NOI18N
        LabIdManteMT.setForeground(new java.awt.Color(51, 51, 51));
        LabIdManteMT.setText("ID Mantenimiento");

        TxtIdManteMT.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        TxtIdManteMT.setForeground(new java.awt.Color(102, 102, 102));
        TxtIdManteMT.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(255, 193, 7)));
        TxtIdManteMT.setSelectedTextColor(new java.awt.Color(0, 0, 0));
        TxtIdManteMT.setSelectionColor(new java.awt.Color(153, 204, 255));

        LabIdTallerMT.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 12)); // NOI18N
        LabIdTallerMT.setForeground(new java.awt.Color(51, 51, 51));
        LabIdTallerMT.setText("ID Taller");

        TxtIdTallerMT.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        TxtIdTallerMT.setForeground(new java.awt.Color(102, 102, 102));
        TxtIdTallerMT.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(255, 193, 7)));
        TxtIdTallerMT.setSelectedTextColor(new java.awt.Color(0, 0, 0));
        TxtIdTallerMT.setSelectionColor(new java.awt.Color(153, 204, 255));

        TablaManteTaller.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        TablaManteTaller.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "ID Mantenimiento", "ID Taller"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.Integer.class, java.lang.Integer.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        TablaManteTaller.setGridColor(new java.awt.Color(231, 231, 231));
        TablaManteTaller.setInheritsPopupMenu(true);
        TablaManteTaller.setSelectionBackground(new java.awt.Color(249, 219, 132));
        TablaManteTaller.setSelectionForeground(new java.awt.Color(255, 255, 255));
        ScrollManteTaller.setViewportView(TablaManteTaller);
        if (TablaManteTaller.getColumnModel().getColumnCount() > 0) {
            TablaManteTaller.getColumnModel().getColumn(0).setPreferredWidth(10);
        }

        BtnAgregarMan.setBackground(new java.awt.Color(40, 197, 158));
        BtnAgregarMan.setFont(new java.awt.Font("SansSerif", 1, 10)); // NOI18N
        BtnAgregarMan.setForeground(new java.awt.Color(255, 255, 255));
        BtnAgregarMan.setText("AGREGAR");
        BtnAgregarMan.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        BtnModificarMan.setBackground(new java.awt.Color(248, 204, 73));
        BtnModificarMan.setFont(new java.awt.Font("SansSerif", 1, 10)); // NOI18N
        BtnModificarMan.setForeground(new java.awt.Color(255, 255, 255));
        BtnModificarMan.setText("MODIFICAR");
        BtnModificarMan.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        BtnEliminarMan.setBackground(new java.awt.Color(217, 84, 84));
        BtnEliminarMan.setFont(new java.awt.Font("SansSerif", 1, 10)); // NOI18N
        BtnEliminarMan.setForeground(new java.awt.Color(255, 255, 255));
        BtnEliminarMan.setText("ELIMINAR");
        BtnEliminarMan.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        TxtIdManteTaller.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        TxtIdManteTaller.setForeground(new java.awt.Color(102, 102, 102));
        TxtIdManteTaller.setBorder(null);
        TxtIdManteTaller.setSelectedTextColor(new java.awt.Color(0, 0, 0));
        TxtIdManteTaller.setSelectionColor(new java.awt.Color(153, 204, 255));

        javax.swing.GroupLayout PanelManteTallerLayout = new javax.swing.GroupLayout(PanelManteTaller);
        PanelManteTaller.setLayout(PanelManteTallerLayout);
        PanelManteTallerLayout.setHorizontalGroup(
            PanelManteTallerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelManteTallerLayout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addGroup(PanelManteTallerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(LabIdManteMT)
                    .addComponent(TxtIdManteMT, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(LabIdTallerMT)
                    .addComponent(TxtIdTallerMT, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(PanelManteTallerLayout.createSequentialGroup()
                        .addComponent(BtnAgregarMan)
                        .addGap(18, 18, 18)
                        .addComponent(BtnModificarMan)
                        .addGap(18, 18, 18)
                        .addComponent(BtnEliminarMan))
                    .addComponent(TxtIdManteTaller, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 122, Short.MAX_VALUE)
                .addComponent(ScrollManteTaller, javax.swing.GroupLayout.PREFERRED_SIZE, 442, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30))
        );
        PanelManteTallerLayout.setVerticalGroup(
            PanelManteTallerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelManteTallerLayout.createSequentialGroup()
                .addGroup(PanelManteTallerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(PanelManteTallerLayout.createSequentialGroup()
                        .addGap(17, 17, 17)
                        .addComponent(ScrollManteTaller, javax.swing.GroupLayout.PREFERRED_SIZE, 405, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(PanelManteTallerLayout.createSequentialGroup()
                        .addGap(61, 61, 61)
                        .addComponent(LabIdManteMT)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(TxtIdManteMT, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(57, 57, 57)
                        .addComponent(LabIdTallerMT)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(TxtIdTallerMT, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(55, 55, 55)
                        .addComponent(TxtIdManteTaller, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(PanelManteTallerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(BtnAgregarMan, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(BtnModificarMan, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(BtnEliminarMan, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(32, Short.MAX_VALUE))
        );

        PanelVentana.add(PanelManteTaller, "card3");

        javax.swing.GroupLayout PanelFondoLayout = new javax.swing.GroupLayout(PanelFondo);
        PanelFondo.setLayout(PanelFondoLayout);
        PanelFondoLayout.setHorizontalGroup(
            PanelFondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(PanelMenu, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(PanelVentana, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
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

    private void LabMantenimientoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_LabMantenimientoMouseClicked
        LabMantenimiento.setBackground(new Color(0, 156, 117));
        PanelManteTaller.setVisible(true);
        
        PanelVacio.setVisible(false);

        LabTaller.setBackground(new Color(40, 197, 158));
        PanelTaller.setVisible(false);
    }//GEN-LAST:event_LabMantenimientoMouseClicked

    private void LabTallerMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_LabTallerMouseClicked
        LabTaller.setBackground(new Color(0, 156, 117));
        PanelTaller.setVisible(true);
        
        PanelVacio.setVisible(false);

        LabMantenimiento.setBackground(new Color(40, 197, 158));
        PanelManteTaller.setVisible(false);
    }//GEN-LAST:event_LabTallerMouseClicked

    private void LabVehiculosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_LabVehiculosMouseClicked
        VehiculosView vehiculo = new VehiculosView(controllerVehiculo, controllerMantenimiento, controllerRepuesto, controllerTaller);
        vehiculo.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_LabVehiculosMouseClicked

    private void LabVehiculosMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_LabVehiculosMouseEntered
        LabVehiculos.setBackground(new Color(40, 197, 158));
        LabVehiculos.setForeground(Color.white);
    }//GEN-LAST:event_LabVehiculosMouseEntered

    private void LabVehiculosMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_LabVehiculosMouseExited
        LabVehiculos.setBackground(new Color(190, 242, 228));
        LabVehiculos.setForeground(new Color(51, 51, 51));
    }//GEN-LAST:event_LabVehiculosMouseExited

    private void BtnAgregarTalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnAgregarTalActionPerformed
        String nombre, direccion, mensaje;

            controllerTaller = new TallerController();

            nombre = this.TxtNombreT.getText();
            direccion = this.TxtDireccionT.getText();

        mensaje = controllerTaller.insertarTaller(nombre, direccion);
        JOptionPane.showMessageDialog(null, mensaje, "Información", JOptionPane.INFORMATION_MESSAGE);

        limpiarCampos();
        obtenerTaller();
    }//GEN-LAST:event_BtnAgregarTalActionPerformed

    private void BtnModificarTalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnModificarTalActionPerformed
        int selectedRow = TablaTaller.getSelectedRow();
        if (selectedRow != -1) {
            
            int idTaller = Integer.parseInt(TxtIdTaller.getText());
            String nombreTaller = TxtNombreT.getText();
            String direccion = TxtDireccionT.getText();

        String mensaje = controllerTaller.modificarTaller(idTaller, nombreTaller, direccion);
        JOptionPane.showMessageDialog(null, mensaje, "Información", JOptionPane.INFORMATION_MESSAGE);
    
        limpiarCampos();
        actualizarTabla();
        } else {
        JOptionPane.showMessageDialog(null, "Seleccione un taller para eliminar", "Información", JOptionPane.INFORMATION_MESSAGE);
    }
    }//GEN-LAST:event_BtnModificarTalActionPerformed

    private void BtnEliminarTalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnEliminarTalActionPerformed
        int selectedRow = TablaTaller.getSelectedRow();
        if (selectedRow != -1) {
            
            int idTaller = Integer.parseInt(TxtIdTaller.getText());
        
        String mensaje = controllerTaller.eliminarTaller(idTaller);
        JOptionPane.showMessageDialog(null, mensaje, "Información", JOptionPane.INFORMATION_MESSAGE);
        
        limpiarCampos();
        actualizarTabla();
    } else {
        JOptionPane.showMessageDialog(null, "Seleccione un taller para eliminar", "Información", JOptionPane.INFORMATION_MESSAGE);
    }
    }//GEN-LAST:event_BtnEliminarTalActionPerformed

    /**
     * @param args the command line arguments
     */
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
            java.util.logging.Logger.getLogger(TalleresView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TalleresView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TalleresView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TalleresView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                //new TalleresView().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BtnAgregarMan;
    private javax.swing.JButton BtnAgregarTal;
    private javax.swing.JButton BtnEliminarMan;
    private javax.swing.JButton BtnEliminarTal;
    private javax.swing.JButton BtnModificarMan;
    private javax.swing.JButton BtnModificarTal;
    private javax.swing.JLabel LabDireccionT;
    private javax.swing.JLabel LabIdManteMT;
    private javax.swing.JLabel LabIdTallerMT;
    private javax.swing.JLabel LabMantenimiento;
    private javax.swing.JLabel LabMensaje;
    private javax.swing.JLabel LabNombreT;
    private javax.swing.JLabel LabTaller;
    private javax.swing.JLabel LabVehiculos;
    private javax.swing.JPanel PanelFondo;
    private javax.swing.JPanel PanelManteTaller;
    private javax.swing.JPanel PanelMenu;
    private javax.swing.JPanel PanelTaller;
    private javax.swing.JPanel PanelVacio;
    private javax.swing.JPanel PanelVentana;
    private javax.swing.JScrollPane ScrollManteTaller;
    private javax.swing.JScrollPane ScrollTaller;
    private javax.swing.JTable TablaManteTaller;
    private javax.swing.JTable TablaTaller;
    private javax.swing.JTextField TxtDireccionT;
    private javax.swing.JTextField TxtIdManteMT;
    private javax.swing.JTextField TxtIdManteTaller;
    private javax.swing.JTextField TxtIdTaller;
    private javax.swing.JTextField TxtIdTallerMT;
    private javax.swing.JTextField TxtNombreT;
    // End of variables declaration//GEN-END:variables
}
