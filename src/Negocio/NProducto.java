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
    
    
}
