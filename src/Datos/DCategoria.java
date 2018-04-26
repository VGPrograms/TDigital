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
public class DCategoria {
      SQL S= new SQL();
    public DCategoria(){
    }
    public DCategoria(int _IdCategoria, String _Categoria) {
        this._IdCategoria = _IdCategoria;
        this._Categoria = _Categoria;
    }
    
    private int _IdCategoria;
    private String _Categoria;

    public int getIdCategoria() {
        return _IdCategoria;
    }

    public void setIdCategoria(int _IdCategoria) {
        this._IdCategoria = _IdCategoria;
    }

    public String getCategoria() {
        return _Categoria;
    }

    public void setCategoria(String _Categoria) {
        this._Categoria = _Categoria;
    }
    
      @Override
    public String toString()
    {
       return getCategoria();
    }
    
    
    //METODOS
     public boolean GuardarCategoria(DCategoria Categoria){
    return S.Insertar("Insert Into Categorias(Categoria) "
            + "Values('"+Categoria.getCategoria()+"');");
    }
    
    public DefaultTableModel MostrarCategorias(){
    return S.MostrarDinamicamenteMod("Select Id_Categoria as ID, Categoria as Categoria from Categorias;");
    }
    
    public DefaultTableModel BusquedaPorX(DCategoria Categoria){
    return S.MostrarDinamicamenteMod("Select Id_Categoria as ID, Categoria as Categoria From Categorias where Categoria like '"+Categoria.getCategoria()+"%'");
    }
    
    public boolean ModificarCategoria(DCategoria Categoria){
    return S.Op("Update Categorias set Categora='"+Categoria.getCategoria()+"' where Id_Categoria="+Categoria.getIdCategoria()+"");
    }
    public JComboBox CBCategorias() throws SQLException{
      
        JComboBox<DCategoria> jcdev= new JComboBox<DCategoria>();
        
       ResultSet rs=S.getTablaRs("Select Id_Categoria as ID, Categoria as Categoria from Categorias;");
      while(rs.next())
      {
        jcdev.addItem(new DCategoria(rs.getInt(1),rs.getString(2)));
        
            
      }
      return jcdev;
    }

    public boolean NoRep(DCategoria Categoria){
        
          return S.MostrarDinamicamenteMod("Select Id_Categoria as ID, Categoria as Categoria From Categorias where Categoria like '"+Categoria.getCategoria()+"'")==null;
    
    }
}
