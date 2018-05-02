/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Datos;

import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Desarrollo
 */
public class DCliente {
 
        SQL S=new SQL();
    /**
     * @return the _Estado
     */
    public char getEstado() {
        return _Estado;
    }

    /**
     * @param _Estado the _Estado to set
     */
    public void setEstado(char _Estado) {
        this._Estado = _Estado;
    }

    public String getBusqueda() {
        return _Busqueda;
    }

    public void setBusqueda(String _Busqueda) {
        this._Busqueda = _Busqueda;
    }
    
    //Constructor
    public DCliente(){
    
    }
   
    //Atributos
    private int _IdCliente;
    private String _Nombre;
    private String _Apellido_P;
    private String _Apellido_M;
    private String _Empresa;
    private String _Celular;
    private String _Correo;
    private String _Busqueda;
    private char _Estado;

    //Getters and Setters
    public int getIdCliente() {
        return _IdCliente;
    }

    public void setIdCliente(int _IdCliente) {
        this._IdCliente = _IdCliente;
    }

    public String getNombre() {
        return _Nombre;
    }

    public void setNombre(String _Nombre) {
        this._Nombre = _Nombre;
    }

    public String getApellido_P() {
        return _Apellido_P;
    }

    public void setApellido_P(String _Apellido_P) {
        this._Apellido_P = _Apellido_P;
    }

    public String getApellido_M() {
        return _Apellido_M;
    }

    public void setApellido_M(String _Apellido_M) {
        this._Apellido_M = _Apellido_M;
    }

    public String getEmpresa() {
        return _Empresa;
    }

    public void setEmpresa(String _Empresa) {
        this._Empresa = _Empresa;
    }

    public String getCelular() {
        return _Celular;
    }

    public void setCelular(String _Celular) {
        this._Celular = _Celular;
    }

   

   

    public String getCorreo() {
        return _Correo;
    }

    public void setCorreo(String _Correo) {
        this._Correo = _Correo;
    }

    

    
    
    
    //METODOS
    public boolean GuradarCliente(DCliente Cliente){
      return  S.Insertar("Insert into clientes(Nombre,Apellido_P,Apellido_M,Empresa,Celular,Correo) "
                + "values ('"+Cliente.getNombre()+"','"+Cliente.getApellido_P()+"',"
                        + "'"+Cliente.getApellido_M()+"','"+Cliente.getEmpresa()+"',"
                                + "'"+Cliente.getCelular()+"','"+Cliente.getCorreo()+"')");
      
       
      
      
    }
   public DefaultTableModel MostrarClientes(){
     return  S.MostrarDinamicamenteMod("select Id_Cliente as ID, Nombre as Nombre, Apellido_P as 'APellido Paterno',"
               + " Apellido_M as 'Apellido Materno', Empresa as Empresa, Celular as Celular, "
               + "Correo as Correo from Clientes where Estado='1';");
     
   }
    public DefaultTableModel BusquedaPorX(DCliente Cliente){
     return  S.MostrarDinamicamenteMod("SELECT Id_Cliente AS ID, Nombre as Nombre, Apellido_P AS 'APellido Paterno', "
             + "Apellido_M AS 'Apellido Materno', Empresa as Empresa, Celular as Celular,  Correo as Correo FROM"
             + " Clientes  "
             + "where (Nombre like '"+Cliente.getBusqueda()+"%' or Apellido_P like '"+Cliente.getBusqueda()+"%' or Apellido_M like '"+Cliente.getBusqueda()+"%') and (Estado='1')");
   }
    
    
    public boolean ModificarCliente(DCliente Cliente){
    return S.Op("update Clientes set Nombre='"+Cliente.getNombre()+"', Apellido_P= '"+Cliente.getApellido_P()
            +"', Apellido_M='"+Cliente.getApellido_M()+"', Empresa='"+Cliente.getEmpresa()+"', "
                    + "Celular='"+Cliente.getCelular()+"',  "
                            + "Correo='"+Cliente.getCorreo()+"' where Id_Cliente="+Cliente.getIdCliente()+" and estado=1;");
    }
    
    public boolean BorrarCliente(DCliente Cliente){
    return S.Op("Update Clientes set Estado='0' where Id_Cliente="+Cliente.getIdCliente()+"");
    }
    
    
}
