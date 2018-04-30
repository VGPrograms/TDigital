/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Negocio;
import Datos.*;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Desarrollo
 */
public class NProducto {
    public NProducto()
    {
        
    }
    
   public DefaultTableModel BusquedaPorClaveNombre(String Busqueda)
   {
       DProducto Producto= new DProducto();
       Producto.setBusqueda(Busqueda);
       return new DProducto().BusquedaPorClaveNombre(Producto);
       
   }
    public boolean GuardarProducto(String Codig,String Clave,String producto,String Desc,double precioComp,double precioVenta,double precioDolar,double DolarActual,String moneda,
            double stock,int idcat,int idunidad,String fechaconversion){
        
        DProducto Producto= new DProducto();
        Producto.setCodigo(Codig);
        Producto.setClave(Clave);
        Producto.setDescripcion(Desc);
        Producto.setIdUnidad(idunidad);
        Producto.setIdCategoria(idcat);
        Producto.setStock(stock);
        Producto.setDolarActual(DolarActual);
        Producto.setMoneda(moneda);
        Producto.setFechaConversion(fechaconversion);
        Producto.setPrecioDolar(precioDolar);
        Producto.setPrecioCompra(precioComp);
        Producto.setPrecioVenta(precioVenta);
        Producto.setProducto(producto);
        return Producto.GuardarProducto(Producto);
        
        
    }
    
    
}
