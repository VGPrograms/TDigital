/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Negocio;
import Datos.DCliente;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Desarrollo
 */
public class NCliente {
       
        
    public NCliente() {
    }
   public DefaultTableModel MostrarClientes()
   {
       return new DCliente().MostrarClientes();
   }
   public DefaultTableModel BusquedaPorX(String Busqueda){
    DCliente Cliente= new DCliente();
       Cliente.setBusqueda(Busqueda);
       return new DCliente().BusquedaPorX(Cliente);
    }
    
   public boolean GuardarCliente(String nombre,String apelliop,String apelliom,String empresa,
           String celular,String correo)    
   {
       DCliente Cliente = new DCliente();
       Cliente.setNombre(nombre);
       Cliente.setApellido_P(apelliop);
       Cliente.setApellido_M(apelliom);
       Cliente.setEmpresa(empresa);
       Cliente.setCelular(celular);
       Cliente.setCorreo(correo);
      
       return Cliente.GuradarCliente(Cliente);
       
   }
   public boolean ModificarCliente(int ID,String Nombre, String A_Paterno,
           String A_Materno,String Empresa, String Celular, String Correo)
     {
     DCliente Cliente= new DCliente();
     Cliente.setIdCliente(ID);
     Cliente.setNombre(Nombre);
     Cliente.setApellido_P(A_Paterno);
     Cliente.setApellido_M(A_Materno);
     Cliente.setEmpresa(Empresa);
     Cliente.setCelular(Celular);
     Cliente.setCorreo(Correo);
     return Cliente.ModificarCliente(Cliente);
     }
   
   public boolean BorrarCliente(int ID){
   DCliente Cliente= new DCliente();
   Cliente.setIdCliente(ID);
   return Cliente.BorrarCliente(Cliente);
   }
    
   
}
