/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;
import Negocio.NCliente;
import Negocio.NEmpleado;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author JOSIAN
 */
public class FrmClientes extends javax.swing.JInternalFrame {
    
    NCliente Clie= new NCliente();
    String mov="";
    
    public void Acciones(String accion)
    { int fs =jtClientes.getSelectedRow();
        boolean op=true;
        if ("Editar".equals(accion)) {
            btnGuardar.setVisible(op);
             btnuevo.setVisible(!op);
             btneditar.setVisible(!op);
             btneliminar.setVisible(!op);
             
             Jt_Nombre.setText(jtClientes.getValueAt(fs,1).toString());
             Jt_APaterno.setText(jtClientes.getValueAt(fs,2).toString());
             Jt_AMaterno.setText(jtClientes.getValueAt(fs,3).toString());
             Jt_Empresa.setText(jtClientes.getValueAt(fs,4).toString());
             Jt_Celular.setText(jtClientes.getValueAt(fs,5).toString());
             Jt_Correo.setText(jtClientes.getValueAt(fs,6).toString());

             
             
        }
        else if ("Nuevo".equals(accion)) {
             btnGuardar.setVisible(op);
             btnuevo.setVisible(!op);
             btneditar.setVisible(!op);
             btneliminar.setVisible(!op);
        Jt_Nombre.setEnabled(op);
        Jt_APaterno.setEnabled(op);
        Jt_AMaterno.setEnabled(op);
        Jt_Empresa.setEnabled(op);
        Jt_Celular.setEnabled(op);
        Jt_Correo.setEnabled(op);
     
        
            Jt_Nombre.setText("");
            Jt_APaterno.setText("");
            Jt_AMaterno.setText("");
            Jt_Empresa.setText("");
            Jt_Celular.setText("");
            Jt_Correo.setText("");
        
         
            
        }
        else {
             btnGuardar.setVisible(!op);
              btnuevo.setVisible(op);
             btneditar.setVisible(op);
             btneliminar.setVisible(op);
        }
  
    }
    
    public void Acciones(boolean op)
    {       
      int fs =jtClientes.getSelectedRow();
        if (op==true) {
            
             
             
        } else {
             
        
        
        btnGuardar.setVisible(!op);
        Jt_Nombre.setEditable(!op);
        Jt_APaterno.setEditable(!op);
        Jt_AMaterno.setEditable(!op);
        Jt_Empresa.setEditable(!op);
        Jt_Celular.setEditable(!op);
        Jt_Correo.setEditable(!op);
    
        
            Jt_Nombre.setText("");
            Jt_APaterno.setText("");
            Jt_AMaterno.setText("");
            Jt_Empresa.setText("");
            Jt_Celular.setText("");
            Jt_Correo.setText("");
      
            
        }
    }
  
    public FrmClientes() {
        initComponents();
        jtClientes.setModel(new Negocio.NCliente().MostrarClientes());
        ocultar_columnas();
        Acciones("");
    }
     private void recargar() throws SQLException
    {
             this.setBorder(javax.swing.BorderFactory.createEmptyBorder(0, 0, 0, 0));
        try {
            DefaultTableModel modelo;
//            Fventa funcion = new Fventa();
             
            modelo =Clie.BusquedaPorX(jtfBusqueda.getText());
            
            jtClientes.setModel(modelo);
            ocultar_columnas();
                    
            //lblTotalRegistros.setText("Total Registros " + Integer.toString(funcion.totalRegistros));

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }
     public void ocultar_columnas() {
        jtClientes.getColumnModel().getColumn(0).setMaxWidth(0);
        jtClientes.getColumnModel().getColumn(0).setMinWidth(0);
        jtClientes.getColumnModel().getColumn(0).setPreferredWidth(0);

    }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        Jl_Logo = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        Jt_Nombre = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        Jt_Empresa = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        Jt_Correo = new javax.swing.JTextField();
        Jt_APaterno = new javax.swing.JTextField();
        Jt_Celular = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        Jt_AMaterno = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        btnuevo = new javax.swing.JButton();
        btneditar = new javax.swing.JButton();
        btneliminar = new javax.swing.JButton();
        btnGuardar = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        jtClientes = new javax.swing.JTable();
        jLabel31 = new javax.swing.JLabel();
        jtfBusqueda = new javax.swing.JTextField();

        jPanel1.setBackground(new java.awt.Color(0, 0, 51));

        Jl_Logo.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        Jl_Logo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ImagenesForm/usuarioA.png"))); // NOI18N
        Jl_Logo.setText("jLabel10");
        Jl_Logo.setToolTipText("");
        Jl_Logo.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        jLabel1.setFont(new java.awt.Font("Microsoft YaHei Light", 0, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("GESTIÓN DE CLIENTES");

        jPanel2.setName(""); // NOI18N

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));
        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder("Datos del Cliente"));

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel2.setText("Nombre");

        Jt_Nombre.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel3.setText("Apellido Paterno");

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel6.setText("Empresa");

        Jt_Empresa.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        Jt_Empresa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Jt_EmpresaActionPerformed(evt);
            }
        });

        jLabel8.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel8.setText("Correo");

        Jt_Correo.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N

        Jt_APaterno.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N

        Jt_Celular.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N

        jLabel10.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel10.setText("Celular");

        Jt_AMaterno.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N

        jLabel11.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel11.setText("Apellido Materno");

        btnuevo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ImagenesForm/Agregarr.png"))); // NOI18N
        btnuevo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnuevoActionPerformed(evt);
            }
        });

        btneditar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ImagenesForm/editar.png"))); // NOI18N
        btneditar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btneditarActionPerformed(evt);
            }
        });

        btneliminar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ImagenesForm/eliminar.png"))); // NOI18N
        btneliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btneliminarActionPerformed(evt);
            }
        });

        btnGuardar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ImagenesForm/guardar.png"))); // NOI18N
        btnGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel6, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.TRAILING))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(Jt_Nombre, javax.swing.GroupLayout.DEFAULT_SIZE, 229, Short.MAX_VALUE)
                            .addComponent(Jt_Empresa))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel10)
                            .addComponent(jLabel3))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(Jt_Celular, javax.swing.GroupLayout.DEFAULT_SIZE, 230, Short.MAX_VALUE)
                            .addComponent(Jt_APaterno))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel11)
                            .addComponent(jLabel8))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(Jt_Correo)
                            .addComponent(Jt_AMaterno)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                        .addComponent(btnuevo, javax.swing.GroupLayout.DEFAULT_SIZE, 214, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btneditar, javax.swing.GroupLayout.DEFAULT_SIZE, 214, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btneliminar, javax.swing.GroupLayout.DEFAULT_SIZE, 214, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnGuardar, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Jt_Nombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3)
                    .addComponent(Jt_APaterno, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Jt_AMaterno, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel11))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(Jt_Empresa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Jt_Celular, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel10)
                    .addComponent(jLabel8)
                    .addComponent(Jt_Correo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 55, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(btneliminar, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnuevo, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btneditar, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnGuardar, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(26, 26, 26))
        );

        jtClientes.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null}
            },
            new String [] {
                "ID", "Apellido Paterno", "Apellido Materno", "Empresa", "Celular", "Celular Alterno", "Correo", "Correo Alterno"
            }
        ));
        jScrollPane2.setViewportView(jtClientes);

        jLabel31.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel31.setForeground(new java.awt.Color(0, 0, 102));
        jLabel31.setText("BUSQUEDA:");

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
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addComponent(jLabel31, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jtfBusqueda)
                .addGap(109, 109, 109))
            .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.TRAILING)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel31)
                    .addComponent(jtfBusqueda, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 224, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(Jl_Logo, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addComponent(Jl_Logo, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(0, 0, 0))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void Jt_EmpresaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Jt_EmpresaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_Jt_EmpresaActionPerformed

    private void btnuevoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnuevoActionPerformed
        mov="Nuevo";
        Acciones(mov);
    }//GEN-LAST:event_btnuevoActionPerformed

    private void btneditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btneditarActionPerformed
      mov="Editar";
        Acciones(mov);
    }//GEN-LAST:event_btneditarActionPerformed

    private void jtfBusquedaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtfBusquedaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jtfBusquedaActionPerformed

    private void jtfBusquedaKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtfBusquedaKeyReleased
        try {
            recargar();
        } catch (SQLException ex) {
            Logger.getLogger(FrmEmpleados.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jtfBusquedaKeyReleased

    private void btnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarActionPerformed
      
        if("Nuevo".equals(mov))
        {
            if(Jt_Nombre.getText().length()!=0 && Jt_APaterno.getText().length()!=0 && Jt_AMaterno.getText().length()!=0 && Jt_Empresa.getText().length()!=0 && Jt_Celular.getText().length()!=0 && Jt_Correo.getText().length()!=0)
            {
        NCliente clie = new  NCliente();
       
       clie.GuardarCliente(Jt_Nombre.getText(),Jt_APaterno.getText(),
                Jt_AMaterno.getText(),Jt_Empresa.getText(),
                Jt_Celular.getText(),Jt_Correo.getText());
        try {
            mov="";
       Acciones(mov);
            recargar();
        } catch (SQLException ex) {
            Logger.getLogger(FrmEmpleados.class.getName()).log(Level.SEVERE, null, ex);
        }
            }
            else
            {
                JOptionPane.showMessageDialog(rootPane, "Debe llenar todos los campos","ERROR",1);
            }
        }
        else if("Editar".equals(mov))
        {
            
        try {
            NCliente clie = new  NCliente();
            int op=jtClientes.getSelectedRow();
           clie.ModificarCliente(Integer.parseInt(jtClientes.getValueAt(op, 0).toString()),Jt_Nombre.getText(),Jt_APaterno.getText(),Jt_AMaterno.getText(),Jt_Empresa.getText(),Jt_Celular.getText(),Jt_Correo.getText());
            recargar();
        } catch (SQLException ex) {
            Logger.getLogger(FrmClientes.class.getName()).log(Level.SEVERE, null, ex);
        }
        }
       else
        {
            
        }
       
    }//GEN-LAST:event_btnGuardarActionPerformed

    private void btneliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btneliminarActionPerformed
       if(JOptionPane.showConfirmDialog(rootPane, "Confirmar", "Borrar Cliente", 2)==0)
     {
          try {
         NCliente clie= new NCliente();
         int op=jtClientes.getSelectedRow();
         clie.BorrarCliente(Integer.parseInt(jtClientes.getValueAt(op, 0).toString()));
        recargar();
        } catch (SQLException ex) {
            Logger.getLogger(FrmClientes.class.getName()).log(Level.SEVERE, null, ex);
        }
     }
     else
     {
         
     }
    }//GEN-LAST:event_btneliminarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Jl_Logo;
    private javax.swing.JTextField Jt_AMaterno;
    private javax.swing.JTextField Jt_APaterno;
    private javax.swing.JTextField Jt_Celular;
    private javax.swing.JTextField Jt_Correo;
    private javax.swing.JTextField Jt_Empresa;
    private javax.swing.JTextField Jt_Nombre;
    private javax.swing.JButton btnGuardar;
    private javax.swing.JButton btneditar;
    private javax.swing.JButton btneliminar;
    private javax.swing.JButton btnuevo;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jtClientes;
    private javax.swing.JTextField jtfBusqueda;
    // End of variables declaration//GEN-END:variables
}
