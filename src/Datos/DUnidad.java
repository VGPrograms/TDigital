/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Datos;

import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JComboBox;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Desarrollo
 */
public class DUnidad {
    public DUnidad(){
    
    }
    
    private int _IDUnidad;
    private String _Unidad;
    private String _Abrev;

    public DUnidad(int _IDUnidad, String _Unidad, String _Abrev) {
        this._IDUnidad = _IDUnidad;
        this._Unidad = _Unidad;
        this._Abrev = _Abrev;
    }

    public DUnidad(int _IDUnidad, String _Unidad) {
        this._IDUnidad = _IDUnidad;
        this._Unidad = _Unidad;
    }

    public int getIDUnidad() {
        return _IDUnidad;
    }

    public void setIDUnidad(int _IDUnidad) {
        this._IDUnidad = _IDUnidad;
    }

    public String getUnidad() {
        return _Unidad;
    }

    public void setUnidad(String _Unidad) {
        this._Unidad = _Unidad;
    }

    public String getAbrev() {
        return _Abrev;
    }

    public void setAbrev(String _Abrev) {
        this._Abrev = _Abrev;
    }
     SQL S= new SQL();

     public String toString()
     {
        return getUnidad();
         
     }
    
    public boolean GuardarUnidad(DUnidad Unidad){
    return S.Insertar("Insert Into Unidades(Unidad,Abrev) "
            + "Values('"+Unidad.getUnidad()+"','"+Unidad.getAbrev()+"')");
    }
    
    public DefaultTableModel MostrarUnidades(){
    return S.MostrarDinamicamenteMod("Select Id_Unidad as ID, Unidad as Unidad, Abrev as Abreviatura from Unidades");
    }
    
    public DefaultTableModel BusquedaPorX(DUnidad Unidad){
    return S.MostrarDinamicamenteMod("Select Id_Unidad as ID, Unidad as Unidad, Abrev as Abreviatura from Unidades where Unidad like '"+Unidad.getUnidad()+"%'");
    }
    
    public boolean ModificarUnidad(DUnidad Unidad){
    return S.Op("Update Unidades set Unidad='"+Unidad.getUnidad()+"',Abrev='"+Unidad.getAbrev()+"' where Id_Unidad="+Unidad.getIDUnidad()+"");
    }
     public JComboBox CBUnidades() throws SQLException{
      
        JComboBox<DUnidad> jcdev= new JComboBox<DUnidad>();
        
       ResultSet rs=S.getTablaRs("Select Id_Unidad as ID, Unidad as Unidad, Abrev as Abreviatura from Unidades;");
      while(rs.next())
      {
        jcdev.addItem(new DUnidad(rs.getInt(1),rs.getString(2)));
        
            
      }
      return jcdev;
    }
}
