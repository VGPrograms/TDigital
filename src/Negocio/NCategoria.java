/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Negocio;

import Datos.DCategoria;
import java.sql.SQLException;
import javax.swing.JComboBox;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Juan Carlos Vázquez
 */
public class NCategoria {
  
    public NCategoria(){
    
    }
    
    public DefaultTableModel MostrarCategorias()
    {
        return new DCategoria().MostrarCategorias();
    }
    public JComboBox CBCategorias() throws SQLException
    {
        return new DCategoria().CBCategorias();
    }
    
    public boolean guardar(String Categoria)
    {
        DCategoria cat = new DCategoria();
        cat.setCategoria(Categoria);
        
        return new DCategoria().GuardarCategoria(cat);
    }
       public boolean NoRep(String Categoria)
       {
           DCategoria cat = new DCategoria();
        cat.setCategoria(Categoria);
           return new DCategoria().NoRep(cat);
       }
    
}
