/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Negocio;
import Datos.DEmpleado;
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
     public boolean GuardarEmpleado(String Nombre, String A_Paterno, String A_Materno, String Celular, String CelularAlt, String Correo, String CorreAlt){
     DEmpleado Empleado= new DEmpleado();
     Empleado.setNombre(Nombre);
     Empleado.setApellido_P(A_Paterno);
     Empleado.setApellido_M(A_Materno);
     Empleado.setCelular(Celular);
     Empleado.setCelularAlt(CelularAlt);
     Empleado.setCorreo(Correo);
     Empleado.setCorreoAlt(CorreAlt);
     return new DEmpleado().GuardarEmpleado(Empleado);
     }
     public boolean ModificarEmpleado(int ID,String Nombre, String A_Paterno, String A_Materno, String Celular, String CelularAlt, String Correo, String CorreAlt )
     {
     DEmpleado Empleado= new DEmpleado();
     Empleado.setId_Empleado(ID);
     Empleado.setNombre(Nombre);
     Empleado.setApellido_P(A_Paterno);
     Empleado.setApellido_M(A_Materno);
     Empleado.setCelular(Celular);
     Empleado.setCelularAlt(CelularAlt);
     Empleado.setCorreo(Correo);
     Empleado.setCorreoAlt(CorreAlt);
     return Empleado.ModificarEmpleado(Empleado);
     }
     public boolean BorrarEmpleado(int ID)
     {
     DEmpleado Empleado= new DEmpleado();
     Empleado.setId_Empleado(ID);
     return Empleado.BorrarEmpleado(Empleado);
     }
}
