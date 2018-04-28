/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Negocio;
import Datos.DEmpleado;
import Datos.DProducto;
import javax.swing.table.DefaultTableModel;
/**
 *
 * @author Desarrollo
 */
public class NEmpleado {
   
    public NEmpleado(){
    
    }
    public DefaultTableModel MostrarEmpleados()
   {
       return new DEmpleado().MostrarEmpleados();
   }
    public DefaultTableModel BusquedaPorX(String Busqueda){
    DEmpleado Empleado= new DEmpleado();
       Empleado.setBusqueda(Busqueda);
       return new DEmpleado().BusquedaPorX(Empleado);
    }
}
