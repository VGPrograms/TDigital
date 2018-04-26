/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Datos;

/**
 *
 * @author Desarrollo
 */
public class DCotizacion {

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
    public DCotizacion(){
        
    }
    
    private int _IdCotizacion;
    private String _Fecha;
    private int _IDEmpleado;
    private int _IdCliente;
    private String Folio;
    private String _FechaVencimiento;
    private String _Instalacion;
    private double _Descuento;
    private double _Total;
    private int _CantidadProductos;
    private String _Busqueda;
    private char _Estado;

    public int getIdCotizacion() {
        return _IdCotizacion;
    }

    public void setIdCotizacion(int _IdCotizacion) {
        this._IdCotizacion = _IdCotizacion;
    }

    public String getFecha() {
        return _Fecha;
    }

    public void setFecha(String _Fecha) {
        this._Fecha = _Fecha;
    }

    public int getIDEmpleado() {
        return _IDEmpleado;
    }

    public void setIDEmpleado(int _IDEmpleado) {
        this._IDEmpleado = _IDEmpleado;
    }

    public int getIdCliente() {
        return _IdCliente;
    }

    public void setIdCliente(int _IdCliente) {
        this._IdCliente = _IdCliente;
    }

    public String getFolio() {
        return Folio;
    }

    public void setFolio(String Folio) {
        this.Folio = Folio;
    }

    public String getFechaVencimiento() {
        return _FechaVencimiento;
    }

    public void setFechaVencimiento(String _FechaVencimiento) {
        this._FechaVencimiento = _FechaVencimiento;
    }

    public String getInstalacion() {
        return _Instalacion;
    }

    public void setInstalacion(String _Instalacion) {
        this._Instalacion = _Instalacion;
    }

    public double getDescuento() {
        return _Descuento;
    }

    public void setDescuento(double _Descuento) {
        this._Descuento = _Descuento;
    }

    public double getTotal() {
        return _Total;
    }

    public void setTotal(double _Total) {
        this._Total = _Total;
    }

    public int getCantidadProductos() {
        return _CantidadProductos;
    }

    public void setCantidadProductos(int _CantidadProductos) {
        this._CantidadProductos = _CantidadProductos;
    }
    
}
