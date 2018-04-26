/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Datos;

import javax.swing.table.DefaultTableModel;

/**
 *
 * @author JOSIAN
 */
public class DEmpleado {

    public String getBusqueda() {
        return _Busqueda;
    }

    public void setBusqueda(String _Busqueda) {
        this._Busqueda = _Busqueda;
    }

    /**
     * @return the Id_Empleado
     */
    public int getId_Empleado() {
        return Id_Empleado;
    }

    /**
     * @param Id_Empleado the Id_Empleado to set
     */
    public void setId_Empleado(int Id_Empleado) {
        this.Id_Empleado = Id_Empleado;
    }

    /**
     * @return the Nombre
     */
    public String getNombre() {
        return Nombre;
    }

    /**
     * @param Nombre the Nombre to set
     */
    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }

    /**
     * @return the Apellido_P
     */
    public String getApellido_P() {
        return Apellido_P;
    }

    /**
     * @param Apellido_P the Apellido_P to set
     */
    public void setApellido_P(String Apellido_P) {
        this.Apellido_P = Apellido_P;
    }

    /**
     * @return the Apellido_M
     */
    public String getApellido_M() {
        return Apellido_M;
    }

    /**
     * @param Apellido_M the Apellido_M to set
     */
    public void setApellido_M(String Apellido_M) {
        this.Apellido_M = Apellido_M;
    }

    /**
     * @return the Celular
     */
    public int getCelular() {
        return Celular;
    }

    /**
     * @param Celular the Celular to set
     */
    public void setCelular(int Celular) {
        this.Celular = Celular;
    }

    /**
     * @return the Correo
     */
    public String getCorreo() {
        return Correo;
    }

    /**
     * @param Correo the Correo to set
     */
    public void setCorreo(String Correo) {
        this.Correo = Correo;
    }

    /**
     * @return the Sueldo
     */
    public double getSueldo() {
        return Sueldo;
    }

    /**
     * @param Sueldo the Sueldo to set
     */
    public void setSueldo(double Sueldo) {
        this.Sueldo = Sueldo;
    }

    /**
     * @return the Pass
     */
    public String getPass() {
        return Pass;
    }

    /**
     * @param Pass the Pass to set
     */
    public void setPass(String Pass) {
        this.Pass = Pass;
    }
    
    private int Id_Empleado;
    private String Nombre  ;
    private String Apellido_P  ;
    private String Apellido_M  ;
    private int Celular  ;
    private String Correo  ;
   private double Sueldo  ;
    private String Pass  ;
    private String _Busqueda;
    private char _Estado;

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
  
    
    //METODOS
     SQL S= new SQL();
    
  
    
    public boolean GuardarEmpleado(DEmpleado Empleado){
    return S.Insertar("Insert into Empleados(Nombre,Apellido_P,Apellido_M,Celular,Correo,Sueldo,Pass) "
            + "Values('"+Empleado.getNombre()+"','"+Empleado.getApellido_P()+"',"
                    + "'"+Empleado.getApellido_M()+"','"+Empleado.getCelular()+"',"
                            + "'"+Empleado.getCorreo()+"',"+Empleado.getSueldo()+",'"+Empleado.getPass()+"');");
    }
    
    public DefaultTableModel MostrarEmpleados(){
    return S.MostrarDinamicamenteMod("Select Id_Empleado as ID,Nombre as Nombre,"
            + " Apellido_P as 'Apellido Paterno', Apellido_M as 'Apellido Materno',"
            + " Celular as Celular, Correo as Correo, Sueldo as Sueldo,"
            + " Pass as Contraseña from Empleados;");
    }
    
    public DefaultTableModel BusquedaPorX(DEmpleado Empleado){
    return S.MostrarDinamicamenteMod("Select Id_Empleado as ID,Nombre as Nombre,"
            + " Apellido_P as 'Apellido Paterno', Apellido_M as 'Apellido Materno',"
            + " Celular as Celular, Correo as Correo, Sueldo as Sueldo,"
            + " Pass as Contraseña from Empleados where Nombre like '"+Empleado.getBusqueda()+"%' "
                    + "or Apellido_P like '"+Empleado.getBusqueda()+"%' or Apellido_M like '"+Empleado.getBusqueda()+"%';");
    }
    
    public DefaultTableModel BusquedaPorEstado(DEmpleado Empleado){
    return S.MostrarDinamicamenteMod("Select Id_Empleado as ID, Nombre as Nombre,"
            + "Apellido_P as 'Apellido Paterno',Apellido_M as 'Apellido Materno', Celular as Celular,"
            + "Correo as Correo, Sueldo as Sueldo,"
            + "Pass as Contraseña from Empleados where Estado='1'");
    }
    
    public boolean ModificarEmpleado(DEmpleado Empleado){
    return S.Op("Update Empleados Set Nombre='"+Empleado.getNombre()+"',Apellido_P='"+Empleado.getApellido_P()+"',"
            + "Apellido_M='"+Empleado.getApellido_M()+"',Celular="+Empleado.getCelular()+",Correo='"+Empleado.getCorreo()+"',"
                    + "Sueldo="+Empleado.getSueldo()+",Pass='"+Empleado.getPass()+"' where Id_Empleado="+Empleado.getId_Empleado()+";");
    }
    
    
}
