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
    
   public boolean GuardarCliente(String nombre,String apelliop,String apelliom,String empresa,
           String celular,String celularalt,String correo,String CorreoAlt)    
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
    
   
}
