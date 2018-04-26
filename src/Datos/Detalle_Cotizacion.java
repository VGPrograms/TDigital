/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Datos;

/**
 *
 * @author JOSIAN
 */
public class Detalle_Cotizacion {
    public Detalle_Cotizacion()
    {
    }
    
    public Detalle_Cotizacion(int _IdDetalle, int _idCotizacion, int _IdProducto, double _PrecioUnit, double _Cantidad, double _Subtotal) {
        this._IdDetalle = _IdDetalle;
        this._idCotizacion = _idCotizacion;
        this._IdProducto = _IdProducto;
        this._PrecioUnit = _PrecioUnit;
        this._Cantidad = _Cantidad;
        this._Subtotal = _Subtotal;
    }
    
    
    
    private int _IdDetalle;
    private int _idCotizacion;
    private int _IdProducto;
    private double _PrecioUnit;
    private double _Cantidad ;
    private double _Subtotal;

    public int getIdDetalle() {
        return _IdDetalle;
    }

    public void setIdDetalle(int _IdDetalle) {
        this._IdDetalle = _IdDetalle;
    }

    public int getIdCotizacion() {
        return _idCotizacion;
    }

    public void setIdCotizacion(int _idCotizacion) {
        this._idCotizacion = _idCotizacion;
    }

    public int getIdProducto() {
        return _IdProducto;
    }

    public void setIdProducto(int _IdProducto) {
        this._IdProducto = _IdProducto;
    }

    public double getPrecioUnit() {
        return _PrecioUnit;
    }

    public void setPrecioUnit(double _PrecioUnit) {
        this._PrecioUnit = _PrecioUnit;
    }

    public double getCantidad() {
        return _Cantidad;
    }

    public void setCantidad(double _Cantidad) {
        this._Cantidad = _Cantidad;
    }

    public double getSubtotal() {
        return _Subtotal;
    }

    public void setSubtotal(double _Subtotal) {
        this._Subtotal = _Subtotal;
    }
    
    
    
    
    
}
