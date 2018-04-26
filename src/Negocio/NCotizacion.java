/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Negocio;
import Datos.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Desarrollo
 */
public class NCotizacion {
    SQL S= new SQL();
 
    Connection conex = null;
    public NCotizacion(){
    }
    
    public boolean GuardarCotizacion(DCotizacion Cotizacion){
    return S.Insertar("Insert into Cotizaciones(Fecha,Folio,FechaVencimiento,Instalacion,Descuento,Total,CantidadProductos) "
            + "Values('"+Cotizacion.getFecha()+"','"+Cotizacion.getFolio()+"','"+Cotizacion.getFechaVencimiento()+"','"+Cotizacion.getInstalacion()+"',"
            + ""+Cotizacion.getDescuento()+","+Cotizacion.getTotal()+","+Cotizacion.getCantidadProductos()+");");
    }
    public boolean CotizacionGuardar(DCotizacion Cotizacion, List<DDetalleCotizacion> DetalleCot)
    {
        
        //insert Cotizacion
        PreparedStatement pstcot = null;
        //insert Detalle
        PreparedStatement pstdet = null;
        //OBTENER Cot ID
        ResultSet rs =null;
       
        try{
        conex = new Conexion().conectar();
        conex.setAutoCommit(false);
        
        String cad="Insert into Cotizaciones(Fecha,Folio,FechaVencimiento,Instalacion,Descuento,Total,CantidadProductos) "
            + "Values('"+Cotizacion.getFecha()+"','"+Cotizacion.getFolio()+"','"+Cotizacion.getFechaVencimiento()+"','"+Cotizacion.getInstalacion()+"',"
            + ""+Cotizacion.getDescuento()+","+Cotizacion.getTotal()+","+Cotizacion.getCantidadProductos()+");";
       //
     
      
        pstcot= conex.prepareStatement(cad,Statement.RETURN_GENERATED_KEYS);
          int filasafectadas= pstcot.executeUpdate();
          rs= pstcot.getGeneratedKeys();
          //ASIGNAR ID A COTIZACION
            if (rs.next()) {
             Cotizacion.setIdCotizacion(rs.getInt(1));
            }
            
            if (filasafectadas==1) {
                      
                for(DDetalleCotizacion dcot:DetalleCot){
                          
                          
                String insertDet="INSERT INTO detallecotizacion" +
                                            "(" +
                                            "id_cotizacion," +
                                            "id_producto," +
                                            "PrecioUnit," +
                                            "Cantidad," +
                                            "Subtotal)" +
                                            "VALUES" +
                                            "(" +
                                            Cotizacion.getIdCotizacion()+","+
                                            ""+ dcot.getIdProducto()+","+
                                            ""+dcot.getPrecioUnitario()+"," +
                                            ""+dcot.getCantidad()+","+
                                            ""+dcot.getSubtotal()+" );";
                pstdet=conex.prepareStatement(insertDet);
                pstdet.executeUpdate();
                
            }
                conex.commit();
            }
            else {
                conex.rollback();
            }
             
        }
        catch(SQLException  ex){
             try{
                if(conex != null)
                    conex.rollback();
            }catch(SQLException e){
                System.out.println(e.getMessage());
            }
        
             return false;
            
      //      System.out.println(ex.getMessage());
        } finally {
            try {
                if(rs != null)  rs.close();
                if(pstcot != null) pstcot.close();
                if(pstdet != null) pstdet.close();
                if(conex != null) conex.close();
                
            } catch (SQLException e) {
                System.out.println(e.getMessage());
            }
            return true;
        }
       
    }
    
    
    public DefaultTableModel MostrarCotizaciones(){
    return S.MostrarDinamicamenteMod("");
    }
    
}
