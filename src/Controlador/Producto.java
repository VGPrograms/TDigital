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
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author JOSIAN
 */
public class Producto extends javax.swing.JInternalFrame {

    /**
     * Creates new form Producto
     */
    NProducto Prod= new NProducto();
    
    public void Acciones(String accion)
    { int fs =jtproductos.getSelectedRow();
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
        }
  
    }
    public void Acciones(boolean op)
    {       
      int fs =jtproductos.getSelectedRow();
        if (op==true) {
            
             
             
        } else {
             
        
        
        btnGuardar.setVisible(!op);
        jtfcod.setEditable(!op);
        jtfcodinter.setEditable(!op);
        jtfprod.setEditable(!op);
        jtfdesc.setEditable(!op);
        jtfpventa.setEditable(!op);
        jtfpcompra.setEditable(!op);
        jtfcodinter.setEditable(!op);
        jtfstock.setEditable(!op);
        jcbmoneda.setEnabled(!op);
            jtfcod.setText("");
            jtfcodinter.setText("");
            jtfprod.setText("");
            jtfdesc.setText("");
            jtfpventa.setText("");
            jtfpcompra.setText("");
            jtfstock.setText("");
           
            
        }
        
        
    }
    public Producto() throws SQLException {
        initComponents();
        Acciones("");
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
        jLabel10 = new javax.swing.JLabel();
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
        jcbunidad = new javax.swing.JComboBox<>();
        jPbuttons = new javax.swing.JPanel();
        btnuevo = new javax.swing.JButton();
        btneditar = new javax.swing.JButton();
        btneliminar = new javax.swing.JButton();
        btnGuardar = new javax.swing.JButton();
        jLabel30 = new javax.swing.JLabel();
        jtfdesc = new javax.swing.JTextField();
        jLabel31 = new javax.swing.JLabel();
        jtfBusqueda = new javax.swing.JTextField();
        jInternalFrame1 = new javax.swing.JInternalFrame();
        jPanel3 = new javax.swing.JPanel();
        jLabel15 = new javax.swing.JLabel();
        lblimage1 = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable2 = new javax.swing.JTable();
        jPDatos1 = new javax.swing.JPanel();
        jLabel22 = new javax.swing.JLabel();
        jTextField5 = new javax.swing.JTextField();
        jTextField6 = new javax.swing.JTextField();
        jTextField7 = new javax.swing.JTextField();
        jLabel19 = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        jLabel24 = new javax.swing.JLabel();
        jLabel25 = new javax.swing.JLabel();
        jComboBox5 = new javax.swing.JComboBox<>();
        jLabel26 = new javax.swing.JLabel();
        jTextField8 = new javax.swing.JTextField();
        jPanel6 = new javax.swing.JPanel();
        jLabel27 = new javax.swing.JLabel();
        jFormattedTextField2 = new javax.swing.JFormattedTextField();
        jLabel28 = new javax.swing.JLabel();
        jFormattedTextField4 = new javax.swing.JFormattedTextField();
        jLabel29 = new javax.swing.JLabel();
        jComboBox6 = new javax.swing.JComboBox<>();
        jComboBox7 = new javax.swing.JComboBox<>();
        jPbuttons1 = new javax.swing.JPanel();
        jButton4 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);

        jPanel1.setBackground(new java.awt.Color(0, 0, 51));

        jLabel10.setFont(new java.awt.Font("Futura Bk BT", 1, 24)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        java.util.ResourceBundle bundle = java.util.ResourceBundle.getBundle("Controlador/Bundle"); // NOI18N
        jLabel10.setText(bundle.getString("Producto.jLabel10.text")); // NOI18N

        lblimage.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/menu/barscode3.png"))); // NOI18N
        lblimage.setText(bundle.getString("Producto.lblimage.text")); // NOI18N
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
        jPDatos.setBorder(javax.swing.BorderFactory.createTitledBorder(bundle.getString("Producto.jPDatos.border.title"))); // NOI18N
        jPDatos.setAutoscrolls(true);

        jLabel21.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel21.setForeground(new java.awt.Color(0, 0, 102));
        jLabel21.setText(bundle.getString("Producto.jLabel21.text")); // NOI18N

        jtfcodinter.setBackground(new java.awt.Color(255, 255, 255));
        jtfcodinter.setForeground(new java.awt.Color(153, 0, 0));

        jtfstock.setBackground(new java.awt.Color(255, 255, 255));
        jtfstock.setForeground(new java.awt.Color(153, 0, 0));

        jtfprod.setBackground(new java.awt.Color(255, 255, 255));
        jtfprod.setForeground(new java.awt.Color(153, 0, 0));

        jLabel18.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel18.setForeground(new java.awt.Color(0, 0, 102));
        jLabel18.setText(bundle.getString("Producto.jLabel18.text")); // NOI18N

        jLabel13.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(0, 0, 102));
        jLabel13.setText(bundle.getString("Producto.jLabel13.text")); // NOI18N

        jLabel12.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(0, 0, 102));
        jLabel12.setLabelFor(jtfprod);
        jLabel12.setText(bundle.getString("Producto.jLabel12.text")); // NOI18N

        jLabel16.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(0, 0, 102));
        jLabel16.setText(bundle.getString("Producto.jLabel16.text")); // NOI18N

        jcbcat.setBackground(new java.awt.Color(255, 255, 255));
        jcbcat.setForeground(new java.awt.Color(0, 0, 0));
        jcbcat.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jcbcat.setAutoscrolls(true);
        jcbcat.setBorder(null);
        jcbcat.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jcbcatItemStateChanged(evt);
            }
        });

        jLabel11.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(0, 0, 102));
        jLabel11.setText(bundle.getString("Producto.jLabel11.text")); // NOI18N

        jtfcod.setBackground(new java.awt.Color(255, 255, 255));
        jtfcod.setForeground(new java.awt.Color(153, 0, 0));

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));
        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder(null, bundle.getString("Producto.jPanel4.border.title"), javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Dialog", 1, 12), new java.awt.Color(0, 0, 102))); // NOI18N

        jLabel14.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(153, 0, 0));
        jLabel14.setText(bundle.getString("Producto.jLabel14.text")); // NOI18N

        jLabel20.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel20.setForeground(new java.awt.Color(0, 102, 0));
        jLabel20.setText(bundle.getString("Producto.jLabel20.text")); // NOI18N

        jtfpcompra.setBackground(new java.awt.Color(255, 255, 255));
        jtfpcompra.setCaretColor(new java.awt.Color(0, 0, 0));

        jLabel17.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel17.setForeground(new java.awt.Color(0, 0, 102));
        jLabel17.setText(bundle.getString("Producto.jLabel17.text")); // NOI18N

        jcbmoneda.setBackground(new java.awt.Color(255, 255, 255));
        jcbmoneda.setForeground(new java.awt.Color(204, 0, 0));
        jcbmoneda.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "MXN", "DLS" }));
        jcbmoneda.setBorder(null);

        jtfpventa.setBackground(new java.awt.Color(255, 255, 255));
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
                    .addComponent(jtfpcompra, javax.swing.GroupLayout.DEFAULT_SIZE, 160, Short.MAX_VALUE)
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

        jcbunidad.setBackground(new java.awt.Color(255, 255, 255));
        jcbunidad.setForeground(new java.awt.Color(0, 0, 0));
        jcbunidad.setAutoscrolls(true);
        jcbunidad.setBorder(null);
        jcbunidad.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jcbunidadItemStateChanged(evt);
            }
        });
        jcbunidad.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jcbunidadActionPerformed(evt);
            }
        });

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

        javax.swing.GroupLayout jPbuttonsLayout = new javax.swing.GroupLayout(jPbuttons);
        jPbuttons.setLayout(jPbuttonsLayout);
        jPbuttonsLayout.setHorizontalGroup(
            jPbuttonsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPbuttonsLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnuevo, javax.swing.GroupLayout.DEFAULT_SIZE, 88, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btneditar, javax.swing.GroupLayout.DEFAULT_SIZE, 88, Short.MAX_VALUE)
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
        jLabel30.setText(bundle.getString("Producto.jLabel30.text")); // NOI18N

        jtfdesc.setBackground(new java.awt.Color(255, 255, 255));
        jtfdesc.setForeground(new java.awt.Color(153, 0, 0));

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
                            .addGroup(jPDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPDatosLayout.createSequentialGroup()
                                    .addComponent(jcbunidad, javax.swing.GroupLayout.PREFERRED_SIZE, 159, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(21, 21, 21)
                                    .addComponent(jcbcat, javax.swing.GroupLayout.PREFERRED_SIZE, 159, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPDatosLayout.createSequentialGroup()
                                    .addComponent(jLabel21, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(112, 112, 112)
                                    .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(47, 47, 47)))
                            .addGroup(jPDatosLayout.createSequentialGroup()
                                .addGap(9, 9, 9)
                                .addComponent(jLabel30)))
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
                .addGap(5, 5, 5)
                .addGroup(jPDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jtfcod, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jtfprod, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jcbunidad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
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
        jLabel31.setText(bundle.getString("Producto.jLabel31.text")); // NOI18N

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
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 346, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPDatos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addComponent(lblimage, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel10)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblimage, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel10))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jLabel10.getAccessibleContext().setAccessibleParent(jPanel1);
        lblimage.getAccessibleContext().setAccessibleParent(jPanel1);

        jInternalFrame1.setClosable(true);
        jInternalFrame1.setIconifiable(true);
        jInternalFrame1.setMaximizable(true);

        jPanel3.setBackground(new java.awt.Color(0, 0, 51));

        jLabel15.setFont(new java.awt.Font("Futura Bk BT", 1, 24)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(255, 255, 255));
        jLabel15.setText(bundle.getString("Producto.jLabel15.text")); // NOI18N

        lblimage1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/menu/barscode3.png"))); // NOI18N
        lblimage1.setText(bundle.getString("Producto.lblimage1.text")); // NOI18N
        lblimage1.setName(""); // NOI18N
        lblimage1.setPreferredSize(new java.awt.Dimension(50, 50));
        lblimage1.setRequestFocusEnabled(false);

        jPanel5.setBackground(new java.awt.Color(255, 255, 255));

        jTable2.setBackground(new java.awt.Color(255, 255, 255));
        jTable2.setModel(new javax.swing.table.DefaultTableModel(
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
        jTable2.setFocusTraversalPolicyProvider(true);
        jTable2.setGridColor(new java.awt.Color(204, 204, 204));
        jTable2.setName(""); // NOI18N
        jTable2.setShowVerticalLines(false);
        jTable2.setUpdateSelectionOnSort(false);
        jScrollPane2.setViewportView(jTable2);

        jPDatos1.setBackground(new java.awt.Color(255, 255, 255));
        jPDatos1.setAutoscrolls(true);

        jLabel22.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel22.setForeground(new java.awt.Color(0, 0, 102));
        jLabel22.setText(bundle.getString("Producto.jLabel22.text")); // NOI18N

        jTextField5.setBackground(new java.awt.Color(255, 255, 255));
        jTextField5.setForeground(new java.awt.Color(153, 0, 0));

        jTextField6.setBackground(new java.awt.Color(255, 255, 255));
        jTextField6.setForeground(new java.awt.Color(153, 0, 0));

        jTextField7.setBackground(new java.awt.Color(255, 255, 255));
        jTextField7.setForeground(new java.awt.Color(153, 0, 0));

        jLabel19.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel19.setForeground(new java.awt.Color(0, 0, 102));
        jLabel19.setText(bundle.getString("Producto.jLabel19.text")); // NOI18N

        jLabel23.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel23.setForeground(new java.awt.Color(0, 0, 102));
        jLabel23.setText(bundle.getString("Producto.jLabel23.text")); // NOI18N

        jLabel24.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel24.setForeground(new java.awt.Color(0, 0, 102));
        jLabel24.setLabelFor(jtfprod);
        jLabel24.setText(bundle.getString("Producto.jLabel24.text")); // NOI18N

        jLabel25.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel25.setForeground(new java.awt.Color(0, 0, 102));
        jLabel25.setText(bundle.getString("Producto.jLabel25.text")); // NOI18N

        jComboBox5.setBackground(new java.awt.Color(0, 51, 102));
        jComboBox5.setForeground(new java.awt.Color(0, 0, 0));
        jComboBox5.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jComboBox5.setAutoscrolls(true);
        jComboBox5.setBorder(null);

        jLabel26.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel26.setForeground(new java.awt.Color(0, 0, 102));
        jLabel26.setText(bundle.getString("Producto.jLabel26.text")); // NOI18N

        jTextField8.setBackground(new java.awt.Color(255, 255, 255));
        jTextField8.setForeground(new java.awt.Color(153, 0, 0));

        jPanel6.setBackground(new java.awt.Color(255, 255, 255));
        jPanel6.setBorder(javax.swing.BorderFactory.createTitledBorder(null, bundle.getString("Producto.jPanel6.border.title"), javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Dialog", 1, 12), new java.awt.Color(0, 0, 102))); // NOI18N

        jLabel27.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel27.setForeground(new java.awt.Color(153, 0, 0));
        jLabel27.setText(bundle.getString("Producto.jLabel27.text")); // NOI18N

        jFormattedTextField2.setBackground(new java.awt.Color(255, 255, 255));
        jFormattedTextField2.setText(bundle.getString("Producto.jFormattedTextField2.text")); // NOI18N
        jFormattedTextField2.setCaretColor(new java.awt.Color(0, 0, 0));

        jLabel28.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel28.setForeground(new java.awt.Color(0, 102, 0));
        jLabel28.setText(bundle.getString("Producto.jLabel28.text")); // NOI18N

        jFormattedTextField4.setBackground(new java.awt.Color(255, 255, 255));
        jFormattedTextField4.setText(bundle.getString("Producto.jFormattedTextField4.text")); // NOI18N
        jFormattedTextField4.setCaretColor(new java.awt.Color(0, 0, 0));

        jLabel29.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel29.setForeground(new java.awt.Color(0, 0, 102));
        jLabel29.setText(bundle.getString("Producto.jLabel29.text")); // NOI18N

        jComboBox6.setBackground(new java.awt.Color(255, 255, 255));
        jComboBox6.setForeground(new java.awt.Color(204, 0, 0));
        jComboBox6.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "MXN", "DLS" }));
        jComboBox6.setBorder(null);

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel28)
                    .addComponent(jLabel27, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jFormattedTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, 1, Short.MAX_VALUE)
                    .addComponent(jFormattedTextField4, javax.swing.GroupLayout.PREFERRED_SIZE, 1, Short.MAX_VALUE))
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addGap(55, 55, 55)
                        .addComponent(jLabel29, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(jComboBox6, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(34, 34, 34))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addComponent(jLabel29)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jComboBox6)
                        .addGap(1, 1, 1))
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jFormattedTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel27, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel28, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jFormattedTextField4, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(12, Short.MAX_VALUE))
        );

        jComboBox7.setBackground(new java.awt.Color(0, 51, 102));
        jComboBox7.setForeground(new java.awt.Color(0, 0, 0));
        jComboBox7.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jComboBox7.setBorder(null);

        jPbuttons1.setBackground(new java.awt.Color(255, 255, 255));
        jPbuttons1.setAutoscrolls(true);
        jPbuttons1.setLayout(new java.awt.GridLayout(1, 0));

        jButton4.setBackground(new java.awt.Color(255, 255, 255));
        jButton4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ImagenesForm/Agregarr.png"))); // NOI18N
        jPbuttons1.add(jButton4);

        jButton5.setBackground(new java.awt.Color(255, 255, 255));
        jButton5.setText(bundle.getString("Producto.jButton5.text")); // NOI18N
        jButton5.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jButton5.setBorderPainted(false);
        jPbuttons1.add(jButton5);

        jButton6.setBackground(new java.awt.Color(255, 255, 255));
        jButton6.setText(bundle.getString("Producto.jButton6.text")); // NOI18N
        jButton6.setBorder(javax.swing.BorderFactory.createCompoundBorder());
        jButton6.setBorderPainted(false);
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });
        jPbuttons1.add(jButton6);

        javax.swing.GroupLayout jPDatos1Layout = new javax.swing.GroupLayout(jPDatos1);
        jPDatos1.setLayout(jPDatos1Layout);
        jPDatos1Layout.setHorizontalGroup(
            jPDatos1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPDatos1Layout.createSequentialGroup()
                .addGroup(jPDatos1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPDatos1Layout.createSequentialGroup()
                        .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPbuttons1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(24, 24, 24))
                    .addGroup(jPDatos1Layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addGroup(jPDatos1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPDatos1Layout.createSequentialGroup()
                                .addGroup(jPDatos1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPDatos1Layout.createSequentialGroup()
                                        .addComponent(jLabel24, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(100, 100, 100)
                                        .addComponent(jLabel25)
                                        .addGap(0, 0, Short.MAX_VALUE))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPDatos1Layout.createSequentialGroup()
                                        .addGroup(jPDatos1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addGroup(jPDatos1Layout.createSequentialGroup()
                                                .addGap(20, 20, 20)
                                                .addComponent(jLabel26, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(67, 67, 67)
                                                .addComponent(jLabel19, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(0, 0, Short.MAX_VALUE))
                                            .addGroup(jPDatos1Layout.createSequentialGroup()
                                                .addComponent(jTextField8, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(jTextField7)))
                                        .addGap(10, 10, 10)
                                        .addGroup(jPDatos1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPDatos1Layout.createSequentialGroup()
                                                .addComponent(jComboBox7, javax.swing.GroupLayout.PREFERRED_SIZE, 159, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(21, 21, 21)
                                                .addComponent(jComboBox5, javax.swing.GroupLayout.PREFERRED_SIZE, 159, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPDatos1Layout.createSequentialGroup()
                                                .addComponent(jLabel22, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(112, 112, 112)
                                                .addComponent(jLabel23, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(47, 47, 47)))))
                                .addGap(1, 1, 1))
                            .addGroup(jPDatos1Layout.createSequentialGroup()
                                .addComponent(jTextField5, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(10, 10, 10)
                                .addComponent(jTextField6)))))
                .addGap(25, 25, 25))
        );
        jPDatos1Layout.setVerticalGroup(
            jPDatos1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPDatos1Layout.createSequentialGroup()
                .addGroup(jPDatos1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPDatos1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel26)
                        .addComponent(jLabel19))
                    .addGroup(jPDatos1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel22)
                        .addComponent(jLabel23)))
                .addGap(5, 5, 5)
                .addGroup(jPDatos1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jTextField8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jComboBox7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jComboBox5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(4, 4, 4)
                .addGroup(jPDatos1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel24)
                    .addComponent(jLabel25, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(5, 5, 5)
                .addGroup(jPDatos1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jTextField5)
                    .addComponent(jTextField6))
                .addGap(6, 6, 6)
                .addGroup(jPDatos1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPbuttons1, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane2)
            .addComponent(jPDatos1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(45, 45, 45)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPDatos1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addComponent(lblimage1, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel15)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblimage1, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel15))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jInternalFrame1Layout = new javax.swing.GroupLayout(jInternalFrame1.getContentPane());
        jInternalFrame1.getContentPane().setLayout(jInternalFrame1Layout);
        jInternalFrame1Layout.setHorizontalGroup(
            jInternalFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jInternalFrame1Layout.createSequentialGroup()
                .addGap(6, 6, 6)
                .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jInternalFrame1Layout.setVerticalGroup(
            jInternalFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jInternalFrame1Layout.createSequentialGroup()
                .addGap(6, 6, 6)
                .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(6, 6, 6)
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 440, Short.MAX_VALUE)
                    .addComponent(jInternalFrame1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 440, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(6, 6, 6)
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 333, Short.MAX_VALUE)
                    .addComponent(jInternalFrame1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 332, Short.MAX_VALUE)))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton6ActionPerformed(ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton6ActionPerformed

    private void jcbunidadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jcbunidadActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jcbunidadActionPerformed

    private void btnuevoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnuevoActionPerformed
        Acciones("Nuevo");
    }//GEN-LAST:event_btnuevoActionPerformed
      
    private void jtfBusquedaKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtfBusquedaKeyReleased
        try {
            recargar();
        } catch (SQLException ex) {
            Logger.getLogger(Producto.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jtfBusquedaKeyReleased

    private void jtfBusquedaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtfBusquedaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jtfBusquedaActionPerformed

    private void jcbcatItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jcbcatItemStateChanged
    
         if (evt.getStateChange() == ItemEvent.SELECTED) {
            DCategoria cat = (DCategoria) jcbcat.getSelectedItem();
            
            //JOptionPane.showMessageDialog(rootPane,cat.getIdCategoria());
//          
        }
    }//GEN-LAST:event_jcbcatItemStateChanged

    private void jcbunidadItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jcbunidadItemStateChanged
      
         if (evt.getStateChange() == ItemEvent.SELECTED) {
            DUnidad Unidad = (DUnidad) jcbcat.getSelectedItem();
            
            //JOptionPane.showMessageDialog(rootPane,cat.getIdCategoria());
//          
        }
    }//GEN-LAST:event_jcbunidadItemStateChanged

    private void btneditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btneditarActionPerformed
        Acciones("Editar");
        
    }//GEN-LAST:event_btneditarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    javax.swing.JButton btnGuardar;
    javax.swing.JButton btneditar;
    javax.swing.JButton btneliminar;
    javax.swing.JButton btnuevo;
    javax.swing.JButton jButton4;
    javax.swing.JButton jButton5;
    javax.swing.JButton jButton6;
    javax.swing.JComboBox<String> jComboBox5;
    javax.swing.JComboBox<String> jComboBox6;
    javax.swing.JComboBox<String> jComboBox7;
    javax.swing.JFormattedTextField jFormattedTextField2;
    javax.swing.JFormattedTextField jFormattedTextField4;
    javax.swing.JInternalFrame jInternalFrame1;
    javax.swing.JLabel jLabel10;
    javax.swing.JLabel jLabel11;
    javax.swing.JLabel jLabel12;
    javax.swing.JLabel jLabel13;
    javax.swing.JLabel jLabel14;
    javax.swing.JLabel jLabel15;
    javax.swing.JLabel jLabel16;
    javax.swing.JLabel jLabel17;
    javax.swing.JLabel jLabel18;
    javax.swing.JLabel jLabel19;
    javax.swing.JLabel jLabel20;
    javax.swing.JLabel jLabel21;
    javax.swing.JLabel jLabel22;
    javax.swing.JLabel jLabel23;
    javax.swing.JLabel jLabel24;
    javax.swing.JLabel jLabel25;
    javax.swing.JLabel jLabel26;
    javax.swing.JLabel jLabel27;
    javax.swing.JLabel jLabel28;
    javax.swing.JLabel jLabel29;
    javax.swing.JLabel jLabel30;
    javax.swing.JLabel jLabel31;
    javax.swing.JPanel jPDatos;
    javax.swing.JPanel jPDatos1;
    javax.swing.JPanel jPanel1;
    javax.swing.JPanel jPanel2;
    javax.swing.JPanel jPanel3;
    javax.swing.JPanel jPanel4;
    javax.swing.JPanel jPanel5;
    javax.swing.JPanel jPanel6;
    javax.swing.JPanel jPbuttons;
    javax.swing.JPanel jPbuttons1;
    javax.swing.JScrollPane jScrollPane1;
    javax.swing.JScrollPane jScrollPane2;
    javax.swing.JTable jTable2;
    javax.swing.JTextField jTextField5;
    javax.swing.JTextField jTextField6;
    javax.swing.JTextField jTextField7;
    javax.swing.JTextField jTextField8;
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
    javax.swing.JLabel lblimage1;
    // End of variables declaration//GEN-END:variables
}
