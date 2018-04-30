/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;


import Datos.DCategoria;
import Datos.DUnidad;
import java.awt.event.ActionEvent;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import Negocio.*;
import java.awt.event.ItemEvent;
import java.sql.Date;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author JOSIAN
 */

public class FrmProductos extends javax.swing.JInternalFrame {

    /**
     * Creates new form Producto
     */
    
    double preciodolar=0,dolaractual=0;
    String fechaAct=Date.valueOf(LocalDate.now().format(DateTimeFormatter.ISO_DATE)).toString();
    NProducto Prod= new NProducto();
    String mov="";
   int idcat,idunidad; 
    
    public void OcultarControles(String accion)
    { 
        JLest.setText(accion);
        int fs =jtproductos.getSelectedRow();
    //
        boolean op=true;
        if ("Editar".equals(accion)) {
            btnGuardar.setVisible(op);
             btnuevo.setVisible(!op);
             btneditar.setVisible(!op);
             btneliminar.setVisible(!op);
             
             jtfcod.setText(jtproductos.getValueAt(fs,1).toString());
             jtfcodinter.setText(jtproductos.getValueAt(fs,2).toString());
             jtfprod.setText(jtproductos.getValueAt(fs,3).toString());
             jtfdesc.setText(jtproductos.getValueAt(fs,4).toString());
             jtfpventa.setText(jtproductos.getValueAt(fs,6).toString());
             jtfpcompra.setText(jtproductos.getValueAt(fs,5).toString());
             jtfstock.setText(jtproductos.getValueAt(fs,10).toString());
             jcbmoneda.setEnabled(op);
             
        }
        else if ("Nuevo".equals(accion)) {
             btnGuardar.setVisible(op);
             btnuevo.setVisible(!op);
             btneditar.setVisible(!op);
             btneliminar.setVisible(!op);
        jtfcod.setEditable(op);
        jtfcodinter.setEditable(op);
        jtfprod.setEditable(op);
        jtfdesc.setEditable(op);
        jtfpventa.setEditable(op);
        jtfpcompra.setEditable(op);
        jtfcodinter.setEditable(op);
        jtfstock.setEditable(op);
        jcbmoneda.setEnabled(op);
            jtfcod.setText("");
            jtfcodinter.setText("");
            jtfprod.setText("");
            jtfdesc.setText("");
            jtfpventa.setText("");
            jtfpcompra.setText("");
            jtfstock.setText("");
             jcbunidad.setEnabled(op);
        jcbcat.setEnabled(op);
            
        }
        else {
             jtfcod.setEditable(!op);
        jtfcodinter.setEditable(!op);
        jtfprod.setEditable(!op);
        jtfdesc.setEditable(!op);
        jtfpventa.setEditable(!op);
        jtfpcompra.setEditable(!op);
        jtfcodinter.setEditable(!op);
        jtfstock.setEditable(!op);
        jcbmoneda.setEnabled(!op);
        jcbunidad.setEnabled(!op);
        jcbcat.setEnabled(!op);
             btnGuardar.setVisible(!op);
             btnuevo.setVisible(op);
             btneditar.setVisible(op);
             btneliminar.setVisible(op);
        }
  
    }
    public void acciones()
    { NProducto prod=new NProducto();
        if ("Nuevo".equals(mov)) {
            mov="";
           
            if (prod.GuardarProducto(jtfcod.getText(), jtfcodinter.getText(), jtfprod.getText(),jtfdesc.getText(),Double.parseDouble(jtfpcompra.getText()),Double.parseDouble(jtfpventa.getText()),preciodolar,dolaractual,
                    jcbmoneda.getSelectedItem().toString(),Double.parseDouble(jtfstock.getText()),idcat,idunidad,fechaAct)) {
                JOptionPane.showMessageDialog(rootPane, "El producto ha sido registraddo en la base de datos");
                mov="";
                OcultarControles(mov);
                
            }
            
        
        }
    }
    public FrmProductos() throws SQLException {
        initComponents();
        OcultarControles(mov);
             recargar();
    }
    private void recargar() throws SQLException
    {
             this.setBorder(javax.swing.BorderFactory.createEmptyBorder(0, 0, 0, 0));
        try {
            DefaultTableModel modelo;
//            Fventa funcion = new Fventa();
             
            modelo =Prod.BusquedaPorClaveNombre(jtfBusqueda.getText());
       
            jtproductos.setModel(modelo);
            jtproductos.getTableHeader().setReorderingAllowed(false);
              jtproductos.getColumnModel().getColumn(7).setCellRenderer(new CurrencyCellRenderer());
             jtproductos.getColumnModel().getColumn(5).setCellRenderer(new CurrencyCellRenderer());
              jtproductos.getColumnModel().getColumn(6).setCellRenderer(new CurrencyCellRenderer());
           
           
            
                    ocultar_columnas();
            //lblTotalRegistros.setText("Total Registros " + Integer.toString(funcion.totalRegistros));

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
        jcbcat.setModel(new NCategoria().CBCategorias().getModel());
        
        jcbunidad.setModel(new NUnidad().CBUnidades().getModel());
    }
 public void ocultar_columnas() {
        jtproductos.getColumnModel().getColumn(0).setMaxWidth(0);
        jtproductos.getColumnModel().getColumn(0).setMinWidth(0);
        jtproductos.getColumnModel().getColumn(0).setPreferredWidth(0);

    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        JLest = new javax.swing.JLabel();
        lblimage = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jtproductos = jtproductos = new javax.swing.JTable(){
            public boolean isCellEditable(int rowIndex, int colIndex) {
                return false; //Disallow the editing of any cell
            }
        };
        jPDatos = new javax.swing.JPanel();
        jLabel21 = new javax.swing.JLabel();
        jtfcodinter = new javax.swing.JTextField();
        jtfstock = new javax.swing.JTextField();
        jtfprod = new javax.swing.JTextField();
        jLabel18 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jcbcat = new javax.swing.JComboBox<>();
        jLabel11 = new javax.swing.JLabel();
        jtfcod = new javax.swing.JTextField();
        jPanel4 = new javax.swing.JPanel();
        jLabel14 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        jtfpcompra = new javax.swing.JFormattedTextField();
        jLabel17 = new javax.swing.JLabel();
        jcbmoneda = new javax.swing.JComboBox<>();
        jtfpventa = new javax.swing.JFormattedTextField();
        jPbuttons = new javax.swing.JPanel();
        btnuevo = new javax.swing.JButton();
        btneditar = new javax.swing.JButton();
        btneliminar = new javax.swing.JButton();
        btnGuardar = new javax.swing.JButton();
        jLabel30 = new javax.swing.JLabel();
        jtfdesc = new javax.swing.JTextField();
        jcbunidad = new javax.swing.JComboBox<>();
        jLabel31 = new javax.swing.JLabel();
        jtfBusqueda = new javax.swing.JTextField();
        jLabel32 = new javax.swing.JLabel();

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);

        jPanel1.setBackground(new java.awt.Color(0, 0, 51));

        JLest.setFont(new java.awt.Font("Futura Bk BT", 1, 24)); // NOI18N
        JLest.setForeground(new java.awt.Color(255, 255, 255));
        java.util.ResourceBundle bundle = java.util.ResourceBundle.getBundle("Controlador/Bundle"); // NOI18N
        JLest.setText(bundle.getString("FrmProductos.JLest.text")); // NOI18N
        JLest.setRequestFocusEnabled(false);

        lblimage.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/menu/barscode3.png"))); // NOI18N
        lblimage.setText(bundle.getString("FrmProductos.lblimage.text")); // NOI18N
        lblimage.setName(""); // NOI18N
        lblimage.setPreferredSize(new java.awt.Dimension(50, 50));
        lblimage.setRequestFocusEnabled(false);

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));

        jtproductos.setBackground(new java.awt.Color(255, 255, 255));
        jtproductos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        jtproductos.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_ALL_COLUMNS);
        jtproductos.setFocusTraversalPolicyProvider(true);
        jtproductos.setGridColor(new java.awt.Color(255, 255, 255));
        jtproductos.setName(""); // NOI18N
        jtproductos.setShowVerticalLines(false);
        jtproductos.setUpdateSelectionOnSort(false);
        jScrollPane1.setViewportView(jtproductos);

        jPDatos.setBackground(new java.awt.Color(255, 255, 255));
        jPDatos.setBorder(javax.swing.BorderFactory.createTitledBorder(bundle.getString("FrmProductos.jPDatos.border.title"))); // NOI18N
        jPDatos.setAutoscrolls(true);

        jLabel21.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel21.setForeground(new java.awt.Color(0, 0, 102));
        jLabel21.setText(bundle.getString("FrmProductos.jLabel21.text")); // NOI18N

        jtfcodinter.setBackground(new java.awt.Color(255, 255, 255));
        jtfcodinter.setForeground(new java.awt.Color(153, 0, 0));

        jtfstock.setBackground(new java.awt.Color(255, 255, 255));
        jtfstock.setForeground(new java.awt.Color(153, 0, 0));

        jtfprod.setBackground(new java.awt.Color(255, 255, 255));
        jtfprod.setForeground(new java.awt.Color(153, 0, 0));

        jLabel18.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel18.setForeground(new java.awt.Color(0, 0, 102));
        jLabel18.setText(bundle.getString("FrmProductos.jLabel18.text")); // NOI18N

        jLabel13.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(0, 0, 102));
        jLabel13.setText(bundle.getString("FrmProductos.jLabel13.text")); // NOI18N

        jLabel12.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(0, 0, 102));
        jLabel12.setLabelFor(jtfprod);
        jLabel12.setText(bundle.getString("FrmProductos.jLabel12.text")); // NOI18N

        jLabel16.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(0, 0, 102));
        jLabel16.setText(bundle.getString("FrmProductos.jLabel16.text")); // NOI18N

        jcbcat.setBackground(new java.awt.Color(255, 255, 255));
        jcbcat.setForeground(new java.awt.Color(0, 0, 0));
        jcbcat.setAutoscrolls(true);
        jcbcat.setBorder(null);
        jcbcat.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jcbcatItemStateChanged(evt);
            }
        });

        jLabel11.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(0, 0, 102));
        jLabel11.setText(bundle.getString("FrmProductos.jLabel11.text")); // NOI18N

        jtfcod.setBackground(new java.awt.Color(255, 255, 255));
        jtfcod.setForeground(new java.awt.Color(153, 0, 0));

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));
        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder(null, bundle.getString("FrmProductos.jPanel4.border.title"), javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Dialog", 1, 12), new java.awt.Color(0, 0, 102))); // NOI18N

        jLabel14.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(153, 0, 0));
        jLabel14.setText(bundle.getString("FrmProductos.jLabel14.text")); // NOI18N

        jLabel20.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel20.setForeground(new java.awt.Color(0, 102, 0));
        jLabel20.setText(bundle.getString("FrmProductos.jLabel20.text")); // NOI18N

        jtfpcompra.setBackground(new java.awt.Color(255, 255, 255));
        jtfpcompra.setCaretColor(new java.awt.Color(0, 0, 0));

        jLabel17.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel17.setForeground(new java.awt.Color(0, 0, 102));
        jLabel17.setText(bundle.getString("FrmProductos.jLabel17.text")); // NOI18N

        jcbmoneda.setBackground(new java.awt.Color(255, 255, 255));
        jcbmoneda.setForeground(new java.awt.Color(204, 0, 0));
        jcbmoneda.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "MXN", "DLS" }));
        jcbmoneda.setBorder(null);

        jtfpventa.setBackground(new java.awt.Color(255, 255, 255));
        jtfpventa.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("¤#,##0.00"))));
        jtfpventa.setCaretColor(new java.awt.Color(0, 0, 0));

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel20)
                    .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jtfpcompra, javax.swing.GroupLayout.DEFAULT_SIZE, 161, Short.MAX_VALUE)
                    .addComponent(jtfpventa))
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(55, 55, 55)
                        .addComponent(jLabel17, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(jcbmoneda, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addComponent(jLabel17)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jcbmoneda)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jtfpventa, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel20, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jtfpcompra, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel4Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {jtfpcompra, jtfpventa});

        jPbuttons.setBackground(new java.awt.Color(255, 255, 255));
        jPbuttons.setAutoscrolls(true);

        btnuevo.setBackground(new java.awt.Color(255, 255, 255));
        btnuevo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ImagenesForm/Agregarr.png"))); // NOI18N
        btnuevo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnuevoActionPerformed(evt);
            }
        });

        btneditar.setBackground(new java.awt.Color(255, 255, 255));
        btneditar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ImagenesForm/editar.png"))); // NOI18N
        btneditar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btneditarActionPerformed(evt);
            }
        });

        btneliminar.setBackground(new java.awt.Color(255, 255, 255));
        btneliminar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ImagenesForm/eliminar.png"))); // NOI18N

        btnGuardar.setBackground(new java.awt.Color(255, 255, 255));
        btnGuardar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ImagenesForm/guardar.png"))); // NOI18N
        btnGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPbuttonsLayout = new javax.swing.GroupLayout(jPbuttons);
        jPbuttons.setLayout(jPbuttonsLayout);
        jPbuttonsLayout.setHorizontalGroup(
            jPbuttonsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPbuttonsLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnuevo, javax.swing.GroupLayout.DEFAULT_SIZE, 88, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btneditar, javax.swing.GroupLayout.DEFAULT_SIZE, 90, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btneliminar, javax.swing.GroupLayout.DEFAULT_SIZE, 89, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnGuardar, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPbuttonsLayout.setVerticalGroup(
            jPbuttonsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPbuttonsLayout.createSequentialGroup()
                .addGroup(jPbuttonsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(btneliminar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnuevo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btneditar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnGuardar, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        jLabel30.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel30.setForeground(new java.awt.Color(0, 0, 102));
        jLabel30.setText(bundle.getString("FrmProductos.jLabel30.text")); // NOI18N

        jtfdesc.setBackground(new java.awt.Color(255, 255, 255));
        jtfdesc.setForeground(new java.awt.Color(153, 0, 0));

        jcbunidad.setBackground(new java.awt.Color(255, 255, 255));
        jcbunidad.setForeground(new java.awt.Color(0, 0, 0));
        jcbunidad.setAutoscrolls(true);
        jcbunidad.setBorder(null);
        jcbunidad.setName(""); // NOI18N
        jcbunidad.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jcbunidadItemStateChanged(evt);
            }
        });

        javax.swing.GroupLayout jPDatosLayout = new javax.swing.GroupLayout(jPDatos);
        jPDatos.setLayout(jPDatosLayout);
        jPDatosLayout.setHorizontalGroup(
            jPDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
            .addGroup(jPDatosLayout.createSequentialGroup()
                .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPbuttons, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(jPDatosLayout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addGroup(jPDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPDatosLayout.createSequentialGroup()
                        .addGroup(jPDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPDatosLayout.createSequentialGroup()
                                .addGroup(jPDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(jPDatosLayout.createSequentialGroup()
                                        .addGap(20, 20, 20)
                                        .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(67, 67, 67)
                                        .addComponent(jLabel18, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(0, 0, Short.MAX_VALUE))
                                    .addGroup(jPDatosLayout.createSequentialGroup()
                                        .addComponent(jtfcod, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jtfprod)))
                                .addGap(10, 10, 10))
                            .addGroup(jPDatosLayout.createSequentialGroup()
                                .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(30, 30, 30)
                                .addComponent(jLabel16)))
                        .addGroup(jPDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPDatosLayout.createSequentialGroup()
                                .addGap(3, 3, 3)
                                .addComponent(jcbunidad, javax.swing.GroupLayout.PREFERRED_SIZE, 159, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jcbcat, javax.swing.GroupLayout.PREFERRED_SIZE, 159, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPDatosLayout.createSequentialGroup()
                                .addGroup(jPDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPDatosLayout.createSequentialGroup()
                                        .addGap(42, 42, 42)
                                        .addComponent(jLabel21, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(112, 112, 112)
                                        .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPDatosLayout.createSequentialGroup()
                                        .addGap(9, 9, 9)
                                        .addComponent(jLabel30)))
                                .addGap(47, 47, 47)))
                        .addContainerGap())
                    .addGroup(jPDatosLayout.createSequentialGroup()
                        .addComponent(jtfcodinter, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jtfdesc)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jtfstock, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(186, 186, 186))))
        );
        jPDatosLayout.setVerticalGroup(
            jPDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPDatosLayout.createSequentialGroup()
                .addGroup(jPDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel11)
                        .addComponent(jLabel18))
                    .addGroup(jPDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel21)
                        .addComponent(jLabel13)))
                .addGap(4, 4, 4)
                .addGroup(jPDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jtfcod, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jtfprod, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jcbunidad, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jcbcat, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(jPDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPDatosLayout.createSequentialGroup()
                        .addGap(4, 4, 4)
                        .addGroup(jPDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel12)
                            .addComponent(jLabel16, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPDatosLayout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel30, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jtfcodinter)
                    .addComponent(jtfdesc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jtfstock))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPDatosLayout.createSequentialGroup()
                        .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())
                    .addComponent(jPbuttons, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );

        jLabel31.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel31.setForeground(new java.awt.Color(0, 0, 102));
        jLabel31.setText(bundle.getString("FrmProductos.jLabel31.text")); // NOI18N

        jtfBusqueda.setBackground(new java.awt.Color(255, 255, 255));
        jtfBusqueda.setForeground(new java.awt.Color(153, 0, 0));
        jtfBusqueda.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jtfBusquedaActionPerformed(evt);
            }
        });
        jtfBusqueda.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jtfBusquedaKeyReleased(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1)
            .addComponent(jPDatos, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel31, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jtfBusqueda)
                .addGap(213, 213, 213))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(7, 7, 7)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel31)
                    .addComponent(jtfBusqueda, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 348, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPDatos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jLabel32.setFont(new java.awt.Font("Futura Bk BT", 1, 24)); // NOI18N
        jLabel32.setForeground(new java.awt.Color(255, 255, 255));
        jLabel32.setText(bundle.getString("FrmProductos.jLabel32.text")); // NOI18N

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addComponent(lblimage, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(JLest)
                .addGap(29, 29, 29))
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel1Layout.createSequentialGroup()
                    .addGap(72, 72, 72)
                    .addComponent(jLabel32)
                    .addContainerGap(493, Short.MAX_VALUE)))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(lblimage, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(JLest))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel1Layout.createSequentialGroup()
                    .addGap(16, 16, 16)
                    .addComponent(jLabel32)
                    .addContainerGap(636, Short.MAX_VALUE)))
        );

        JLest.getAccessibleContext().setAccessibleParent(jPanel1);
        lblimage.getAccessibleContext().setAccessibleParent(jPanel1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(6, 6, 6)
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(6, 6, 6)
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    
    private void btnuevoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnuevoActionPerformed
        mov="Nuevo";
        OcultarControles(mov);
    }//GEN-LAST:event_btnuevoActionPerformed
      
    private void jtfBusquedaKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtfBusquedaKeyReleased
        try {
            recargar();
        } catch (SQLException ex) {
            Logger.getLogger(FrmProductos.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jtfBusquedaKeyReleased

    private void jtfBusquedaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtfBusquedaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jtfBusquedaActionPerformed

    private void jcbcatItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jcbcatItemStateChanged
    
         if (evt.getStateChange() == ItemEvent.SELECTED) {
            DCategoria cat = (DCategoria) jcbcat.getSelectedItem();
            idcat= cat.getIdCategoria();
           
            
            //JOptionPane.showMessageDialog(rootPane,cat.getIdCategoria());
//          
        }
    }//GEN-LAST:event_jcbcatItemStateChanged

    private void btneditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btneditarActionPerformed
       mov="Editar";
        OcultarControles(mov);
        
    }//GEN-LAST:event_btneditarActionPerformed

    private void btnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarActionPerformed
       acciones();
    }//GEN-LAST:event_btnGuardarActionPerformed

    private void jcbunidadItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jcbunidadItemStateChanged
        // TODO add your handling code here:
        
         if (evt.getStateChange() == ItemEvent.SELECTED) {
            DUnidad unidad = (DUnidad) jcbunidad.getSelectedItem();
            idunidad= unidad.getIDUnidad();
           
            
            //JOptionPane.showMessageDialog(rootPane,cat.getIdCategoria());
//          
        }
    }//GEN-LAST:event_jcbunidadItemStateChanged


    // Variables declaration - do not modify//GEN-BEGIN:variables
    javax.swing.JLabel JLest;
    javax.swing.JButton btnGuardar;
    javax.swing.JButton btneditar;
    javax.swing.JButton btneliminar;
    javax.swing.JButton btnuevo;
    javax.swing.JLabel jLabel11;
    javax.swing.JLabel jLabel12;
    javax.swing.JLabel jLabel13;
    javax.swing.JLabel jLabel14;
    javax.swing.JLabel jLabel16;
    javax.swing.JLabel jLabel17;
    javax.swing.JLabel jLabel18;
    javax.swing.JLabel jLabel20;
    javax.swing.JLabel jLabel21;
    javax.swing.JLabel jLabel30;
    javax.swing.JLabel jLabel31;
    javax.swing.JLabel jLabel32;
    javax.swing.JPanel jPDatos;
    javax.swing.JPanel jPanel1;
    javax.swing.JPanel jPanel2;
    javax.swing.JPanel jPanel4;
    javax.swing.JPanel jPbuttons;
    javax.swing.JScrollPane jScrollPane1;
    javax.swing.JComboBox<String> jcbcat;
    javax.swing.JComboBox<String> jcbmoneda;
    javax.swing.JComboBox<String> jcbunidad;
    javax.swing.JTextField jtfBusqueda;
    javax.swing.JTextField jtfcod;
    javax.swing.JTextField jtfcodinter;
    javax.swing.JTextField jtfdesc;
    javax.swing.JFormattedTextField jtfpcompra;
    javax.swing.JTextField jtfprod;
    javax.swing.JFormattedTextField jtfpventa;
    javax.swing.JTextField jtfstock;
    javax.swing.JTable jtproductos;
    javax.swing.JLabel lblimage;
    // End of variables declaration//GEN-END:variables
}
