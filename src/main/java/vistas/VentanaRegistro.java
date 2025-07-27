/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package vistas;

import controladores.MascotaControlador;
import daos.DaoMascotas;
import daos.DaoPropietario;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import modelo.Mascotas;
import dto.DtoPropietario;
import controladores.PropietarioControlador;
import dto.DtoMascota;
import vistas.VentanaPrincipal;

/**
 *
 * @author kevin
 */
public class VentanaRegistro extends javax.swing.JFrame {

   
    private PropietarioControlador controladorPropietario;
    private MascotaControlador controladorMascota ;
    private VentanaPrincipal ventanaPrincipal;

    /**
     * Creates new form VentanaRegistro
     */
    public VentanaRegistro(VentanaPrincipal ventanaPrincipal, MascotaControlador controladorMascota, PropietarioControlador controladorPropietario) {
        this.ventanaPrincipal = ventanaPrincipal;
        this.controladorMascota = controladorMascota;
        this.controladorPropietario = controladorPropietario;
        initComponents();
        setTitle("Registro de Clientes");
        setLocationRelativeTo(this);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
       
        ListarMascota();
        ListarPropietario();
        DefaultTableModel modeloPropietarios = new DefaultTableModel(
                new Object[]{"Nombre", "Documento", "Teléfono"},
                0);
        tablePropietario.setModel(modeloPropietarios);

        // Columnas para la tabla de mascotas
        DefaultTableModel modeloMascotas = new DefaultTableModel(
                new Object[]{"ID", "Nombre", "Especie", "Edad", "Documento Propietario"},
                0 // No filas al inicio
        );
        tablamas.setModel(modeloMascotas);
    }

    private void ListarMascota() {
        String[] columnas = {"ID", "Nombre", "Especie", "Edad", "Documento Propietario"};
        DefaultTableModel modelo = new DefaultTableModel(columnas, 0);

        ArrayList<DtoMascota> lista = controladorMascota.obtenerTodasMascotas();

        if (lista != null && !lista.isEmpty()) {
            for (DtoMascota m : lista) {
                Object[] fila = {
                    m.getId(),
                    m.getNombre(),
                    m.getEspecie(),
                    m.getEdad(),
                    m.getDocumentoPropietario()
                };
                modelo.addRow(fila);
            }
        }

        tablamas.setModel(modelo);
    }

    private void ListarPropietario() {
        // Definir siempre los encabezados, aunque no haya datos
        String[] columnas = {"Nombre", "Documento", "Teléfono"};
        DefaultTableModel modelo = new DefaultTableModel(columnas, 0);

        ArrayList<DtoPropietario> lista = controladorPropietario.obtenerPropietarios();

        if (lista != null && !lista.isEmpty()) {
            for (DtoPropietario p : lista) {
                Object[] fila = {p.getNombre(), p.getDocumento(), p.getTelefono()};
                modelo.addRow(fila);
            }
        }

        tablePropietario.setModel(modelo);
    }


    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelPrincipal = new javax.swing.JPanel();
        separador = new javax.swing.JSeparator();
        tabbedResgiPropi = new javax.swing.JTabbedPane();
        panelRegistro = new javax.swing.JPanel();
        lblEdad = new javax.swing.JLabel();
        lblEspecie = new javax.swing.JLabel();
        lblNombre = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        lblInfo = new javax.swing.JLabel();
        txtNombre = new javax.swing.JTextField();
        txtEdad = new javax.swing.JTextField();
        lblInfo1 = new javax.swing.JLabel();
        jSeparator2 = new javax.swing.JSeparator();
        lblNomPro = new javax.swing.JLabel();
        lblDocumento = new javax.swing.JLabel();
        lblTel = new javax.swing.JLabel();
        txtDoc = new javax.swing.JTextField();
        txtNomProp = new javax.swing.JTextField();
        txtTel = new javax.swing.JTextField();
        bttGuardarprop = new javax.swing.JButton();
        lbBlId1 = new javax.swing.JLabel();
        txtId = new javax.swing.JTextField();
        btnGuardarMas = new javax.swing.JButton();
        lblDocProp = new javax.swing.JLabel();
        txtDocuPropietario = new javax.swing.JTextField();
        comboEspecie = new javax.swing.JComboBox<>();
        panelRegistrados = new javax.swing.JPanel();
        jSeparator3 = new javax.swing.JSeparator();
        jLabel1 = new javax.swing.JLabel();
        lblInfo2 = new javax.swing.JLabel();
        lbBlId = new javax.swing.JLabel();
        lblBEspecie = new javax.swing.JLabel();
        lblBEdad = new javax.swing.JLabel();
        txtBNombre = new javax.swing.JTextField();
        txtBEdad = new javax.swing.JTextField();
        bttEliminar = new javax.swing.JButton();
        bttBuscar = new javax.swing.JButton();
        bttEditar = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        tablamas = new javax.swing.JTable();
        lblBNombre = new javax.swing.JLabel();
        txtBId = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        txtDocumentoPropieta = new javax.swing.JTextField();
        ComboEspecialida2 = new javax.swing.JComboBox<>();
        jButton1 = new javax.swing.JButton();
        Actualizar = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        txtNombreRegistroPropietario = new javax.swing.JTextField();
        txtDocumentoResgitroProp = new javax.swing.JTextField();
        txtTelefonoRegistroProp = new javax.swing.JTextField();
        jScrollPane3 = new javax.swing.JScrollPane();
        tablePropietario = new javax.swing.JTable();
        btnBuscarResgitroProp = new javax.swing.JButton();
        btnEliminarProp = new javax.swing.JButton();
        btnEditarProp = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        lblTittle = new javax.swing.JLabel();
        bttMenu = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        panelPrincipal.setBackground(new java.awt.Color(132, 169, 140));

        separador.setBackground(new java.awt.Color(0, 0, 0));
        separador.setForeground(new java.awt.Color(0, 0, 0));

        tabbedResgiPropi.setBackground(new java.awt.Color(236, 236, 236));

        lblEdad.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lblEdad.setText("Edad:");

        lblEspecie.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lblEspecie.setText("Especie:");

        lblNombre.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lblNombre.setText("Nombre:");

        jSeparator1.setBackground(new java.awt.Color(204, 255, 255));
        jSeparator1.setForeground(new java.awt.Color(0, 0, 0));
        jSeparator1.setOrientation(javax.swing.SwingConstants.VERTICAL);

        lblInfo.setFont(new java.awt.Font("Segoe UI", 3, 14)); // NOI18N
        lblInfo.setText("Información mascota:");

        txtNombre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNombreActionPerformed(evt);
            }
        });

        lblInfo1.setFont(new java.awt.Font("Segoe UI", 3, 14)); // NOI18N
        lblInfo1.setText("Información Propietario:");

        jSeparator2.setBackground(new java.awt.Color(204, 255, 255));
        jSeparator2.setForeground(new java.awt.Color(0, 0, 0));
        jSeparator2.setOrientation(javax.swing.SwingConstants.VERTICAL);

        lblNomPro.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lblNomPro.setText("Nombre:");

        lblDocumento.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lblDocumento.setText("Documento");

        lblTel.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lblTel.setText("Telefono:");

        bttGuardarprop.setFont(new java.awt.Font("Dialog", 3, 14)); // NOI18N
        bttGuardarprop.setText("Guardar propietario");
        bttGuardarprop.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bttGuardarpropActionPerformed(evt);
            }
        });

        lbBlId1.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lbBlId1.setText("Id:");

        btnGuardarMas.setText("Guardar Mascota");
        btnGuardarMas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarMasActionPerformed(evt);
            }
        });

        lblDocProp.setText("Doc Propietario:");

        txtDocuPropietario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtDocuPropietarioActionPerformed(evt);
            }
        });

        comboEspecie.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Seleccione una opcion", "Perro", "Gato", " " }));
        comboEspecie.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboEspecieActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panelRegistroLayout = new javax.swing.GroupLayout(panelRegistro);
        panelRegistro.setLayout(panelRegistroLayout);
        panelRegistroLayout.setHorizontalGroup(
            panelRegistroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelRegistroLayout.createSequentialGroup()
                .addGroup(panelRegistroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelRegistroLayout.createSequentialGroup()
                        .addGap(16, 16, 16)
                        .addGroup(panelRegistroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(panelRegistroLayout.createSequentialGroup()
                                .addComponent(lblInfo, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(107, 107, 107))
                            .addGroup(panelRegistroLayout.createSequentialGroup()
                                .addGroup(panelRegistroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(panelRegistroLayout.createSequentialGroup()
                                        .addGroup(panelRegistroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelRegistroLayout.createSequentialGroup()
                                                .addGroup(panelRegistroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addComponent(lblEdad, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addComponent(lblEspecie, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addGap(40, 40, 40))
                                            .addGroup(panelRegistroLayout.createSequentialGroup()
                                                .addComponent(lblDocProp)
                                                .addGap(28, 28, 28)))
                                        .addGroup(panelRegistroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addComponent(txtEdad, javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(txtDocuPropietario, javax.swing.GroupLayout.DEFAULT_SIZE, 162, Short.MAX_VALUE)
                                            .addComponent(comboEspecie, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                                    .addGroup(panelRegistroLayout.createSequentialGroup()
                                        .addGroup(panelRegistroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelRegistroLayout.createSequentialGroup()
                                                .addComponent(lblNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(40, 40, 40))
                                            .addGroup(panelRegistroLayout.createSequentialGroup()
                                                .addComponent(lbBlId1, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(52, 52, 52)))
                                        .addGroup(panelRegistroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                            .addComponent(txtId, javax.swing.GroupLayout.DEFAULT_SIZE, 162, Short.MAX_VALUE)
                                            .addComponent(txtNombre, javax.swing.GroupLayout.Alignment.LEADING))))
                                .addGap(18, 18, 18))))
                    .addGroup(panelRegistroLayout.createSequentialGroup()
                        .addGap(76, 76, 76)
                        .addComponent(btnGuardarMas)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(panelRegistroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelRegistroLayout.createSequentialGroup()
                        .addGap(23, 23, 23)
                        .addComponent(lblInfo1))
                    .addGroup(panelRegistroLayout.createSequentialGroup()
                        .addGroup(panelRegistroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(panelRegistroLayout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(lblNomPro, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelRegistroLayout.createSequentialGroup()
                                .addGap(11, 11, 11)
                                .addGroup(panelRegistroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lblTel, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(lblDocumento))))
                        .addGap(44, 44, 44)
                        .addGroup(panelRegistroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(txtDoc, javax.swing.GroupLayout.PREFERRED_SIZE, 198, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtNomProp, javax.swing.GroupLayout.PREFERRED_SIZE, 198, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtTel, javax.swing.GroupLayout.PREFERRED_SIZE, 198, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(panelRegistroLayout.createSequentialGroup()
                        .addGap(81, 81, 81)
                        .addComponent(bttGuardarprop)))
                .addGap(181, 181, 181)
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(148, 148, 148))
        );
        panelRegistroLayout.setVerticalGroup(
            panelRegistroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jSeparator2)
            .addGroup(panelRegistroLayout.createSequentialGroup()
                .addGap(34, 34, 34)
                .addComponent(lblInfo)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(panelRegistroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbBlId1))
                .addGap(18, 18, 18)
                .addGroup(panelRegistroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblNombre)
                    .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(panelRegistroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblEspecie)
                    .addComponent(comboEspecie, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(panelRegistroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblEdad)
                    .addComponent(txtEdad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(panelRegistroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblDocProp)
                    .addComponent(txtDocuPropietario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 38, Short.MAX_VALUE)
                .addComponent(btnGuardarMas)
                .addGap(32, 32, 32))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelRegistroLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jSeparator1)
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelRegistroLayout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addComponent(lblInfo1)
                .addGap(29, 29, 29)
                .addGroup(panelRegistroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblNomPro)
                    .addComponent(txtNomProp, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(38, 38, 38)
                .addGroup(panelRegistroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblDocumento)
                    .addComponent(txtDoc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(41, 41, 41)
                .addGroup(panelRegistroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblTel)
                    .addComponent(txtTel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(bttGuardarprop)
                .addGap(34, 34, 34))
        );

        tabbedResgiPropi.addTab("Registrar", panelRegistro);

        jSeparator3.setBackground(new java.awt.Color(0, 0, 0));
        jSeparator3.setForeground(new java.awt.Color(0, 0, 0));
        jSeparator3.setOrientation(javax.swing.SwingConstants.VERTICAL);

        lblInfo2.setFont(new java.awt.Font("Segoe UI", 3, 14)); // NOI18N
        lblInfo2.setText("Buscar mascota:");

        lbBlId.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lbBlId.setText("Id:");

        lblBEspecie.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lblBEspecie.setText("Especie:");

        lblBEdad.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lblBEdad.setText("Edad:");

        bttEliminar.setText("Eliminar");
        bttEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bttEliminarActionPerformed(evt);
            }
        });

        bttBuscar.setText("Buscar");
        bttBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bttBuscarActionPerformed(evt);
            }
        });

        bttEditar.setText("Editar");
        bttEditar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bttEditarActionPerformed(evt);
            }
        });

        tablamas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane2.setViewportView(tablamas);

        lblBNombre.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lblBNombre.setText("Nombre:");

        jLabel2.setText("Documento Propietario:");

        ComboEspecialida2.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Seleccion una de las opciones", "Perro", "Gato", " " }));
        ComboEspecialida2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ComboEspecialida2ActionPerformed(evt);
            }
        });

        jButton1.setText("Limpiar campos");
        jButton1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        Actualizar.setText("Actualizar");
        Actualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ActualizarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panelRegistradosLayout = new javax.swing.GroupLayout(panelRegistrados);
        panelRegistrados.setLayout(panelRegistradosLayout);
        panelRegistradosLayout.setHorizontalGroup(
            panelRegistradosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelRegistradosLayout.createSequentialGroup()
                .addGroup(panelRegistradosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(panelRegistradosLayout.createSequentialGroup()
                        .addGap(23, 23, 23)
                        .addComponent(lblInfo2, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(panelRegistradosLayout.createSequentialGroup()
                        .addGroup(panelRegistradosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblBNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lbBlId, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblBEspecie, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(panelRegistradosLayout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(lblBEdad, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(68, 68, 68)
                        .addGroup(panelRegistradosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtBEdad, javax.swing.GroupLayout.DEFAULT_SIZE, 152, Short.MAX_VALUE)
                            .addComponent(txtBNombre)
                            .addComponent(txtBId)
                            .addComponent(ComboEspecialida2, 0, 1, Short.MAX_VALUE)))
                    .addGroup(panelRegistradosLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtDocumentoPropieta, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(panelRegistradosLayout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(panelRegistradosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(panelRegistradosLayout.createSequentialGroup()
                                .addComponent(bttBuscar)
                                .addGap(39, 39, 39)
                                .addComponent(bttEliminar)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(bttEditar))
                            .addGroup(panelRegistradosLayout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(Actualizar)
                                .addGap(33, 33, 33)
                                .addComponent(jButton1)
                                .addGap(51, 51, 51)))))
                .addGap(18, 18, 18)
                .addComponent(jSeparator3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 540, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(124, 124, 124)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 204, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        panelRegistradosLayout.setVerticalGroup(
            panelRegistradosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelRegistradosLayout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(panelRegistradosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelRegistradosLayout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(panelRegistradosLayout.createSequentialGroup()
                        .addComponent(lblInfo2)
                        .addGap(18, 18, 18)
                        .addGroup(panelRegistradosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lbBlId)
                            .addComponent(txtBId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(panelRegistradosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblBNombre)
                            .addComponent(txtBNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(panelRegistradosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblBEspecie)
                            .addComponent(ComboEspecialida2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(panelRegistradosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblBEdad)
                            .addComponent(txtBEdad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(panelRegistradosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(txtDocumentoPropieta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(panelRegistradosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(bttBuscar)
                            .addComponent(bttEliminar)
                            .addComponent(bttEditar))
                        .addGap(18, 18, 18)
                        .addGroup(panelRegistradosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jButton1)
                            .addComponent(Actualizar))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
            .addComponent(jSeparator3, javax.swing.GroupLayout.Alignment.TRAILING)
            .addGroup(panelRegistradosLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 279, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 50, Short.MAX_VALUE))
        );

        tabbedResgiPropi.addTab("Mascota Registrada", panelRegistrados);

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel3.setText("Buscar Propietario:");

        jLabel4.setText("Nombre :");

        jLabel5.setText("Documento :");

        jLabel6.setText("Telefono :");

        txtNombreRegistroPropietario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNombreRegistroPropietarioActionPerformed(evt);
            }
        });

        txtTelefonoRegistroProp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtTelefonoRegistroPropActionPerformed(evt);
            }
        });

        tablePropietario.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane3.setViewportView(tablePropietario);

        btnBuscarResgitroProp.setText("Buscar");
        btnBuscarResgitroProp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarResgitroPropActionPerformed(evt);
            }
        });

        btnEliminarProp.setText("Eliminar");
        btnEliminarProp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarPropActionPerformed(evt);
            }
        });

        btnEditarProp.setText("Editar");
        btnEditarProp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditarPropActionPerformed(evt);
            }
        });

        jButton2.setText("jButton2");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 501, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(btnBuscarResgitroProp)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(txtNombreRegistroPropietario)
                        .addComponent(txtDocumentoResgitroProp)
                        .addComponent(txtTelefonoRegistroProp, javax.swing.GroupLayout.PREFERRED_SIZE, 167, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(btnEliminarProp)
                        .addGap(18, 18, 18)
                        .addComponent(btnEditarProp)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton2))
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(86, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(36, 36, 36)
                .addComponent(jLabel3)
                .addGap(36, 36, 36)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(txtNombreRegistroPropietario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(27, 27, 27)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(txtDocumentoResgitroProp, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(28, 28, 28)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(txtTelefonoRegistroProp, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(37, 37, 37)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnBuscarResgitroProp)
                    .addComponent(btnEliminarProp)
                    .addComponent(btnEditarProp)
                    .addComponent(jButton2))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        tabbedResgiPropi.addTab("Propietario Registrado", jPanel1);

        lblTittle.setFont(new java.awt.Font("Dialog", 3, 36)); // NOI18N
        lblTittle.setText("Registro Clinica");

        bttMenu.setBackground(new java.awt.Color(225, 225, 225));
        bttMenu.setFont(new java.awt.Font("Dialog", 3, 14)); // NOI18N
        bttMenu.setText(" ");
        bttMenu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bttMenuActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panelPrincipalLayout = new javax.swing.GroupLayout(panelPrincipal);
        panelPrincipal.setLayout(panelPrincipalLayout);
        panelPrincipalLayout.setHorizontalGroup(
            panelPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(separador, javax.swing.GroupLayout.Alignment.TRAILING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelPrincipalLayout.createSequentialGroup()
                .addContainerGap(295, Short.MAX_VALUE)
                .addComponent(lblTittle)
                .addGap(234, 234, 234)
                .addComponent(bttMenu)
                .addGap(120, 120, 120))
            .addComponent(tabbedResgiPropi, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
        );
        panelPrincipalLayout.setVerticalGroup(
            panelPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelPrincipalLayout.createSequentialGroup()
                .addGap(2, 2, 2)
                .addGroup(panelPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblTittle)
                    .addComponent(bttMenu, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 26, Short.MAX_VALUE)
                .addComponent(separador, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(tabbedResgiPropi, javax.swing.GroupLayout.PREFERRED_SIZE, 370, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelPrincipal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(panelPrincipal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void bttMenuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bttMenuActionPerformed
        // TODO add your handling code here:
        this.setVisible(false);      // oculta Ventana2
        ventanaPrincipal.setVisible(true);   // muestra Ventana1
    }//GEN-LAST:event_bttMenuActionPerformed

    private void bttGuardarpropActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bttGuardarpropActionPerformed

        String documento = txtDoc.getText().trim();
        String nombreProp = txtNomProp.getText().trim();
        String telefono = txtTel.getText().trim();

        if (documento == null || documento.isBlank() || nombreProp == null
                || nombreProp.isBlank() || telefono == null || telefono.isBlank()) {
            JOptionPane.showMessageDialog(this, "Todos los campos deben estar llenos.", "Advertencia", JOptionPane.WARNING_MESSAGE);
            return;
        } else if (documento.length() < 5) {
            JOptionPane.showMessageDialog(this, " La cantidad de caracteres ingresados en documento no son validos.", "Advertencia", JOptionPane.WARNING_MESSAGE);
            return;
        } else if (telefono.length() < 5) {
            JOptionPane.showMessageDialog(this, " La cantidad de caracteres ingresados en telefono no son validos.", "Advertencia", JOptionPane.WARNING_MESSAGE);
            return;
        }

        DtoPropietario nuevoProp = new DtoPropietario(nombreProp, documento, telefono);
        boolean confirmacion = controladorPropietario.guardarPropietario(nuevoProp);

        if (confirmacion) {
            JOptionPane.showMessageDialog(this, " El registro fue exitoso.", "Confirmacion", JOptionPane.INFORMATION_MESSAGE);
            ListarPropietario();
            limpiarCampos();
        } else {
            JOptionPane.showMessageDialog(this, "El registro no se pudo completar.", "Advertencia", JOptionPane.WARNING_MESSAGE);

        }


    }//GEN-LAST:event_bttGuardarpropActionPerformed

    private void txtNombreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNombreActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNombreActionPerformed

    private void txtDocuPropietarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtDocuPropietarioActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtDocuPropietarioActionPerformed

    private void btnGuardarMasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarMasActionPerformed
        String nombre = txtNombre.getText().trim();
        String especie = comboEspecie.getSelectedItem() != null ? comboEspecie.getSelectedItem().toString() : "";

        String idStr = txtId.getText().trim();
        String edadStr = txtEdad.getText().trim();
        String documento = txtDocuPropietario.getText().trim();

        if (nombre == null || nombre.isBlank()
                || especie == null || especie.isBlank()
                || documento == null || documento.isBlank() || idStr == null || idStr.isBlank()
                || edadStr == null || edadStr.isBlank()) {
            JOptionPane.showMessageDialog(this, "Todos los campos deben estar llenos.", "Advertencia", JOptionPane.WARNING_MESSAGE);
            return;
        } 
        int id, edad;
    try {
        id = Integer.parseInt(idStr);
        edad = Integer.parseInt(edadStr);
    } catch (NumberFormatException e) {
        JOptionPane.showMessageDialog(this, "ID y Edad deben ser números válidos.", "Error", JOptionPane.ERROR_MESSAGE);
        return;
    }
    
        if(id <= 0  || edad <= 0) {
            JOptionPane.showMessageDialog(this, "No se pueden agregar datos con valores negativos", "Advertencia", JOptionPane.WARNING_MESSAGE);
            return;
        }

        DtoPropietario prop = controladorPropietario.buscarPropietario(documento);
        DtoMascota confirmacionMas = controladorMascota.buscarMascota(id);

        if (prop == null ) {
            JOptionPane.showMessageDialog(this, " propietario no encontrado, porfavor registrar un propietario primero", "ERROR", JOptionPane.ERROR_MESSAGE);
            return;
        }else if (confirmacionMas != null){
            JOptionPane.showMessageDialog(this, "Ya existe una mascota con el ID:" + id);
            return;
        }
        DtoMascota nuevaMascota = new DtoMascota(nombre, especie, edad,id,documento);
        boolean confirmacion = controladorMascota.guardarMascota(nuevaMascota);
        

        if (confirmacion) {
            JOptionPane.showMessageDialog(this, "La mascota fue guardada correctamente", "Confirmacion", JOptionPane.INFORMATION_MESSAGE);
            ListarMascota();
            limpiarCampos();
        } else {
            JOptionPane.showMessageDialog(this, "La mascota no se pudo guardar.", "Advertencia", JOptionPane.WARNING_MESSAGE);

        }


    }//GEN-LAST:event_btnGuardarMasActionPerformed

    private void txtNombreRegistroPropietarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNombreRegistroPropietarioActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNombreRegistroPropietarioActionPerformed

    private void txtTelefonoRegistroPropActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtTelefonoRegistroPropActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtTelefonoRegistroPropActionPerformed

    private void btnBuscarResgitroPropActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarResgitroPropActionPerformed
        String documento = txtDocumentoResgitroProp.getText();

        if (documento == null || documento.isBlank()) {
            JOptionPane.showMessageDialog(this, " Error, porfavor Ingresar valores validos");
        } else {
            DtoPropietario prop = controladorPropietario.buscarPropietario(documento);
            if (prop != null) {
                JOptionPane.showMessageDialog(this, "Nombre Propietario: " + prop.getNombre() + "\nDocumento Propietario: " + prop.getDocumento()
                        + "\nTelefono Propietario: " + prop.getTelefono());

                txtNombreRegistroPropietario.setText(prop.getNombre());
                txtTelefonoRegistroProp.setText(prop.getTelefono());
            } else {
                JOptionPane.showMessageDialog(this, "El propietario no fue encontrado", "Error", JOptionPane.ERROR_MESSAGE);

            }

        }


    }//GEN-LAST:event_btnBuscarResgitroPropActionPerformed

    private void bttEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bttEditarActionPerformed
   int fila = tablamas.getSelectedRow();
        if (fila != -1 && fila >= 0) {

            int id  = Integer.parseInt(tablamas.getValueAt(fila, 0).toString());
            DtoMascota mascota = controladorMascota.buscarMascota(id);
         if (mascota != null) {
        int idActual = mascota.getId();
        String nuevoNombre = JOptionPane.showInputDialog(this, "Nuevo nombre:");
        String nuevaEspecie = JOptionPane.showInputDialog(this, "Nueva Especie:\n(Recomendacion ingresar la especie (Perro o Gato) en mayuscula)");
        int nuevaEdad = Integer.parseInt(JOptionPane.showInputDialog(this, "Nueva Edad:"));
        String documento = mascota.getDocumentoPropietario();
          boolean editado = controladorMascota.editarMascota(idActual, nuevoNombre, nuevaEspecie, nuevaEdad,documento);
                if (editado) {
                    JOptionPane.showMessageDialog(this, "La mascota fue editado correctamente.");
                    ListarMascota();
                } else {
                    JOptionPane.showMessageDialog(this, "La mascota no se pudo editar.");
                }
            }
        } else {
            JOptionPane.showMessageDialog(this, "Seleccione una mascota valida.");
        }

    }//GEN-LAST:event_bttEditarActionPerformed

    private void bttBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bttBuscarActionPerformed
        // TODO add your handling code here:

        String textoId = txtBId.getText().trim();

        if (textoId.isEmpty() || !textoId.matches("\\d+")) {
            JOptionPane.showMessageDialog(this, "Debe ingresar un número válido en el campo ID.");
            return;
        }

        int id = Integer.parseInt(textoId);

        if (id <= 0) {
            JOptionPane.showMessageDialog(this, "El valor ingresado en el campo ID no es válido.");
        } else {
            DtoMascota mascota = controladorMascota.buscarMascota(id);

            if (mascota != null) {
                JOptionPane.showMessageDialog(this,
                        "Nombre Mascota: " + mascota.getNombre()
                        + "\nId Mascota: " + mascota.getId()
                        + "\nEspecie Mascota: " + mascota.getEspecie()
                        + "\nEdad Mascota: " + mascota.getEdad()
                        + "\nDocumento Propietario: " + mascota.getDocumentoPropietario()
                );

                txtBNombre.setText(mascota.getNombre());
                txtBId.setText(String.valueOf(mascota.getId()));
                ComboEspecialida2.setSelectedItem(mascota.getEspecie());
                txtBEdad.setText(String.valueOf(mascota.getEdad()));
                txtDocumentoPropieta.setText(mascota.getDocumentoPropietario());
            } else {
                JOptionPane.showMessageDialog(this, "Mascota no encontrada.");
            }
        }
    }//GEN-LAST:event_bttBuscarActionPerformed

    private void bttEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bttEliminarActionPerformed
        int fila = tablamas.getSelectedRow();
        if (fila == -1) {
            JOptionPane.showMessageDialog(this, "Seleccione una mascota para eliminar.");
            return;
        }
        int id = Integer.parseInt(tablamas.getValueAt(fila, 0).toString());
        DtoMascota mascota = controladorMascota.buscarMascota(id);

        if (mascota != null) {
            boolean eliminado = controladorMascota.eliminarMascota(id);
            if (eliminado) {
                JOptionPane.showMessageDialog(this, "Mascota eliminada correctamente.");
                ListarMascota();
            } else {
                JOptionPane.showMessageDialog(this, "Mascota no se pudo eliminar correctamente.");
            }
        } else {
            JOptionPane.showMessageDialog(this, "La mascota no existe.");
        }
    }//GEN-LAST:event_bttEliminarActionPerformed

    private void ComboEspecialida2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ComboEspecialida2ActionPerformed
        comboEspecie.removeAllItems(); // limpia
       
        comboEspecie.addItem("Perro");
        comboEspecie.addItem("Gato");
        comboEspecie.addItem("Conejo");
    }//GEN-LAST:event_ComboEspecialida2ActionPerformed

    private void btnEliminarPropActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarPropActionPerformed
        int fila = tablePropietario.getSelectedRow();
        if (fila != -1 && fila >= 0) {

            String documento = tablePropietario.getValueAt(fila, 1).toString();
            DtoPropietario prop = controladorPropietario.buscarPropietario(documento);
            if (prop != null) {
                boolean eliminado = controladorPropietario.eliminarPropietario(documento);
                if (eliminado) {
                    JOptionPane.showMessageDialog(this, "El propietario fue eliminado correctamente.");
                    ListarPropietario();
                } else {
                    JOptionPane.showMessageDialog(this, "El propietario no se pudo eliminar.");
                }
            } else {
                JOptionPane.showMessageDialog(this, "Propietario no encontrado.");
            }

        } else {
            JOptionPane.showMessageDialog(this, "Seleccione un propietario para eliminar.");
        }
    }//GEN-LAST:event_btnEliminarPropActionPerformed

    private void btnEditarPropActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditarPropActionPerformed

        int fila = tablePropietario.getSelectedRow();
        if (fila != -1 && fila >= 0) {

            String documento = tablePropietario.getValueAt(fila, 1).toString();
            DtoPropietario prop = controladorPropietario.buscarPropietario(documento);
            if (prop != null) {
        String DocumentoActual = prop.getDocumento();
        String nuevoNombre = JOptionPane.showInputDialog(this, "Nuevo nombre:");
        String nuevaTelefono = JOptionPane.showInputDialog(this, "Nueva Telefono:");
          boolean editado = controladorPropietario.editarPropietario(DocumentoActual, nuevoNombre, nuevaTelefono);
                if (editado) {
                    JOptionPane.showMessageDialog(this, "El propietario fue editado correctamente.");
                    ListarPropietario();
                } else {
                    JOptionPane.showMessageDialog(this, "El propietario no se pudo editar.");
                }
            }
        } else {
            JOptionPane.showMessageDialog(this, "Seleccione un propietario valido.");
        }


    }//GEN-LAST:event_btnEditarPropActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        txtBId.setText(null);
        txtBNombre.setText(null);
        ComboEspecialida2.setToolTipText(null);
        txtBEdad.setText(null);
        txtDocumentoPropieta.setText(null);    }//GEN-LAST:event_jButton1ActionPerformed

    private void comboEspecieActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboEspecieActionPerformed
    }//GEN-LAST:event_comboEspecieActionPerformed

    private void ActualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ActualizarActionPerformed
    ListarMascota();

    }//GEN-LAST:event_ActualizarActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
ListarPropietario();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void limpiarCampos() {
        txtDoc.setText(null);
        txtNomProp.setText(null);
        txtTel.setText(null);
        txtId.setText(null);
        txtNombre.setText(null);
        comboEspecie.setToolTipText(null);
        txtEdad.setText(null);
        txtDocuPropietario.setText(null);
    }

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
            java.util.logging.Logger.getLogger(VentanaRegistro.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(VentanaRegistro.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(VentanaRegistro.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(VentanaRegistro.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Actualizar;
    private javax.swing.JComboBox<String> ComboEspecialida2;
    private javax.swing.JButton btnBuscarResgitroProp;
    private javax.swing.JButton btnEditarProp;
    private javax.swing.JButton btnEliminarProp;
    private javax.swing.JButton btnGuardarMas;
    private javax.swing.JButton bttBuscar;
    private javax.swing.JButton bttEditar;
    private javax.swing.JButton bttEliminar;
    private javax.swing.JButton bttGuardarprop;
    private javax.swing.JButton bttMenu;
    private javax.swing.JComboBox<String> comboEspecie;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JLabel lbBlId;
    private javax.swing.JLabel lbBlId1;
    private javax.swing.JLabel lblBEdad;
    private javax.swing.JLabel lblBEspecie;
    private javax.swing.JLabel lblBNombre;
    private javax.swing.JLabel lblDocProp;
    private javax.swing.JLabel lblDocumento;
    private javax.swing.JLabel lblEdad;
    private javax.swing.JLabel lblEspecie;
    private javax.swing.JLabel lblInfo;
    private javax.swing.JLabel lblInfo1;
    private javax.swing.JLabel lblInfo2;
    private javax.swing.JLabel lblNomPro;
    private javax.swing.JLabel lblNombre;
    private javax.swing.JLabel lblTel;
    private javax.swing.JLabel lblTittle;
    private javax.swing.JPanel panelPrincipal;
    private javax.swing.JPanel panelRegistrados;
    private javax.swing.JPanel panelRegistro;
    private javax.swing.JSeparator separador;
    private javax.swing.JTabbedPane tabbedResgiPropi;
    private javax.swing.JTable tablamas;
    private javax.swing.JTable tablePropietario;
    private javax.swing.JTextField txtBEdad;
    private javax.swing.JTextField txtBId;
    private javax.swing.JTextField txtBNombre;
    private javax.swing.JTextField txtDoc;
    private javax.swing.JTextField txtDocuPropietario;
    private javax.swing.JTextField txtDocumentoPropieta;
    private javax.swing.JTextField txtDocumentoResgitroProp;
    private javax.swing.JTextField txtEdad;
    private javax.swing.JTextField txtId;
    private javax.swing.JTextField txtNomProp;
    private javax.swing.JTextField txtNombre;
    private javax.swing.JTextField txtNombreRegistroPropietario;
    private javax.swing.JTextField txtTel;
    private javax.swing.JTextField txtTelefonoRegistroProp;
    // End of variables declaration//GEN-END:variables
}
