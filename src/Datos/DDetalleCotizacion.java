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
public class DDetalleCotizacion {
    public DDetalleCotizacion(){
    }
    
    private int _IdDetalle;
    private int _IdCotizacion;
    private int _IdProducto;
    private double _PrecioUnitario;
    private int _Cantidad;
    private double _Subtotal;

    public int getIdDetalle() {
        return _IdDetalle;
    }

    public void setIdDetalle(int _IdDetalle) {
        this._IdDetalle = _IdDetalle;
    }

    public int getIdCotizacion() {
        return _IdCotizacion;
    }

    public void setIdCotizacion(int _IdCotizacion) {
        this._IdCotizacion = _IdCotizacion;
    }

    public int getIdProducto() {
        return _IdProducto;
    }

    public void setIdProducto(int _IdProducto) {
        this._IdProducto = _IdProducto;
    }

    public double getPrecioUnitario() {
        return _PrecioUnitario;
    }

    public void setPrecioUnitario(double _PrecioUnitario) {
        this._PrecioUnitario = _PrecioUnitario;
    }

    public int getCantidad() {
        return _Cantidad;
    }

    public void setCantidad(int _Cantidad) {
        this._Cantidad = _Cantidad;
    }

    public double getSubtotal() {
        return _Subtotal;
    }

    public void setSubtotal(double _Subtotal) {
        this._Subtotal = _Subtotal;
    }
    
}
