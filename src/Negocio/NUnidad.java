/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Negocio;
import Datos.*;
import java.sql.SQLException;
import javax.swing.JComboBox;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Juan Carlos Vázquez
 */
public class NUnidad {

    public NUnidad() {
    }
   
     public JComboBox CBUnidades() throws SQLException
    {
        return new DUnidad().CBUnidades();
    }
    
    
}
