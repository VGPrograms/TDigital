/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Datos;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author JOSIAN
 */
public class SQL {
     Conexion cn = new Conexion();
    public SQL()
    {
    }
     public ResultSet getTablaRs(String consulta) throws SQLException
    {
        try 
        {
            Statement atm= cn.conectar().createStatement();
            PreparedStatement ps = cn.conectar().prepareStatement(consulta);
            ResultSet rst = atm.executeQuery(consulta);
            ResultSetMetaData rsMD =rst.getMetaData();
               
         //DefaultTableModel modelo= new DefaultTableModel();
          
         return rst;
        }
        catch(Exception e)
        {
            JOptionPane.showMessageDialog(null, e);
            return null;
        }
        
    }
     
     public boolean Insertar(String consulta) {

          try {

            PreparedStatement pst = cn.conectar().prepareStatement(consulta);

        //    pst.setString(1, datos.getNombre_categoria());
          //  pst.setString(2, datos.getDescripcion_categoria());
                    

          

              return pst.executeUpdate()!=0;
        } catch (SQLException e) {
           JOptionPane.showMessageDialog(null, e);
            return false;
        }
    }/*CIERRE FUNCION INSERTAR*/
     
     
      public boolean Op(String consulta) {

          try {

            PreparedStatement pst = cn.conectar().prepareStatement(consulta);

        //    pst.setString(1, datos.getNombre_categoria());
          //  pst.setString(2, datos.getDescripcion_categoria());
                    

            int N = pst.executeUpdate();

            if (N != 0) {
                return true;
            } else {
                return false;
            }
        } catch (Exception e) {
           // JOptionPane.showMessageDialog(null, e);
            return false;
        }
    }/*CIERRE FUNCION INSERTAR*/
      public DefaultTableModel MostrarDinamicamenteMod(String Consulta)
      {
                        try {
               //Para establecer el modelo al JTable
               DefaultTableModel modelo = new DefaultTableModel();
              // this.jtQuery.setModel(modelo);
               //Para conectarnos a nuestra base de datos
               //DriverManager.registerDriver(new com.mysql.jdbc.Driver());---------------------------------------------------------------------------
              //Connection conexion = DriverManager.getConnection("jdbc:mysql://localhost/bdproductos", "usuario", "clave"); -------Ya esta en otro metodo
               //Para ejecutar la consulta
               //Statement s = conexion.createStatement();-----------------------------------------------------------Solo es para el Rs
               //Ejecutamos la consulta que escribimos en la caja de texto
               //y los datos lo almacenamos en un ResultSet
               ResultSet rs = this.getTablaRs(Consulta);
               //Obteniendo la informacion de las columnas que estan siendo consultadas
               ResultSetMetaData rsMd = rs.getMetaData();
               //La cantidad de columnas que tiene la consulta
               int cantidadColumnas = rsMd.getColumnCount();
               //Establecer como cabezeras el nombre de las colimnas
               for (int i = 1; i <= cantidadColumnas; i++) {
                modelo.addColumn(rsMd.getColumnLabel(i));
               }
               //Creando las filas para el JTable
               while (rs.next()) {
                Object[] fila = new Object[cantidadColumnas];
                for (int i = 0; i < cantidadColumnas; i++) {
                  fila[i]=rs.getObject(i+1);
                }
                modelo.addRow(fila);
                
               }
               
               rs.close();
              // conexion.close(); -------------------------------------------------------------------------------------------------Cerrar conexion
              //JOptionPane.showMessageDialog(null, modelo.getValueAt(5, 10));
              return modelo;
              } catch (SQLException ex) {
               return null;
              }
                   
      
      }
      public boolean MostrarDinamicamenteCom(String Consulta)
      {
          int contador=1;
                        try {
               
                          
               ResultSet rs = this.getTablaRs(Consulta);
              
               ResultSetMetaData rsMd = rs.getMetaData();
        
             
              
               if (rs.next()) {
                    rs.close();
                   
                                return false;
                                
                            }
                            else{
                                return true;
                            }
   
         
              } catch (SQLException ex) {
               return false;
              }
                   
      
      }
     public DefaultTableModel MostrarTablas(String Consulta,String buscar) {

        DefaultTableModel modelo;

        String[] titulos
                = {"Codigo", "Nombre ",
                    "Descripcion", "Unidad  ",
                    "Precio Venta", "Stock", "Precio Compra", "Bodega"};

        String[] registros = new String[8];
       // totalRegistros = 0;
        modelo = new DefaultTableModel(null, titulos);

        Consulta = "select * from producto where cod_producto =" + buscar + " order by cod_producto desc";

        try {

          //  Statement st = cn.createStatement();
          ResultSet rs =this.getTablaRs(Consulta);
          //ResultSet rs = st.executeQuery(sSQL);
            

            while (rs.next()) {

                registros[0] = rs.getString("cod_producto");
                registros[1] = rs.getString("nombre_producto");
                registros[2] = rs.getString("descripcion_producto");
                registros[3] = rs.getString("unidad_producto");
                registros[4] = rs.getString("precio_producto");
                registros[5] = rs.getString("stock_producto");
                registros[6] = rs.getString("precio_compra");

                registros[7] = rs.getString("ubicacion_bodega");

               // totalRegistros = totalRegistros + 1;
                modelo.addRow(registros);
            }
            return modelo;

        } catch (SQLException e) {
            JOptionPane.showConfirmDialog(null, e);
            return null;
        }
      }
     public ArrayList<String> llenar_combo(String Consulta) {
        ArrayList<String> lista;
         lista = new ArrayList<>();
        
        try {
            Statement st = cn.conectar().createStatement();
            ResultSet rs = st.executeQuery(Consulta);

            while (rs.next()) {
                
               lista.add(rs.getString(0));
                
              
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e);
        }
        return lista;
    }
//     public Vector<estados> mostrarEstados() {
//
////        PreparedStatement ps = null;
////        ResultSet rs = null;
////        Conexion conn = new Conexion();
////        Connection con = conn.getConexion();
//
//        Vector<estados> datos = new Vector<estados>();
//        estados dat = null;
//        try {
//
////            String sql = "SELECT * FROM t_estado";
////            ps = con.prepareStatement(sql);
////            rs = ps.executeQuery();
//
//            dat = new estados();
//            dat.setId(0);
//            dat.setNombre("Selecciona estado");
//            datos.add(dat);
//
//            while (rs.next()) {
//                dat = new estados();
//                dat.setId(rs.getInt("id_estado"));
//                dat.setNombre(rs.getString("estado"));
//                datos.add(dat);
//            }
//            rs.close();
//        } catch (SQLException ex) {
//            System.err.println("Error consulta :" + ex.getMessage());
//        }
//        return datos;
//    }
     
     
}
