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
public class DProducto {

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
    public DProducto(){

}
    
    private int _IdProducto;
    private String _Codigo;
    private String _Clave;
    private String _Producto;
    private String _Descripcion;
    private double _PrecioCompra;
    private double _PrecioVenta;
    private double _PrecioDolar;
    private double _DolarActual;
    private String _Moneda;
    private int _Stock;
    private int _IdCategoria;
    private int _IdUnidad;
    private String _FechaConversion;
    private String _Busqueda;
    private char _Estado;

    public int getIdProducto() {
        return _IdProducto;
    }

    public void setIdProducto(int _IdProducto) {
        this._IdProducto = _IdProducto;
    }

    public String getCodigo() {
        return _Codigo;
    }

    public void setCodigo(String _Codigo) {
        this._Codigo = _Codigo;
    }

    public String getClave() {
        return _Clave;
    }

    public void setClave(String _Clave) {
        this._Clave = _Clave;
    }

    public String getProducto() {
        return _Producto;
    }

    public void setProducto(String _Producto) {
        this._Producto = _Producto;
    }

    public String getDescripcion() {
        return _Descripcion;
    }

    public void setDescripcion(String _Descripcion) {
        this._Descripcion = _Descripcion;
    }

    public double getPrecioCompra() {
        return _PrecioCompra;
    }

    public void setPrecioCompra(double _PrecioCompra) {
        this._PrecioCompra = _PrecioCompra;
    }

    public double getPrecioVenta() {
        return _PrecioVenta;
    }

    public void setPrecioVenta(double _PrecioVenta) {
        this._PrecioVenta = _PrecioVenta;
    }

    public double getPrecioDolar() {
        return _PrecioDolar;
    }

    public void setPrecioDolar(double _PrecioDolar) {
        this._PrecioDolar = _PrecioDolar;
    }

    public double getDolarActual() {
        return _DolarActual;
    }

    public void setDolarActual(double _DolarActual) {
        this._DolarActual = _DolarActual;
    }

    public String getMoneda() {
        return _Moneda;
    }

    public void setMoneda(String _Moneda) {
        this._Moneda = _Moneda;
    }

    public int getStock() {
        return _Stock;
    }

    public void setStock(int _Stock) {
        this._Stock = _Stock;
    }

    public int getIdCategoria() {
        return _IdCategoria;
    }

    public void setIdCategoria(int _IdCategoria) {
        this._IdCategoria = _IdCategoria;
    }

    public int getIdUnidad() {
        return _IdUnidad;
    }

    public void setIdUnidad(int _IdUnidad) {
        this._IdUnidad = _IdUnidad;
    }

    public String getFechaConversion() {
        return _FechaConversion;
    }

    public void setFechaConversion(String _FechaConversion) {
        this._FechaConversion = _FechaConversion;
    }

    public String getBusqueda() {
        return _Busqueda;
    }

    public void setBusqueda(String _Busqueda) {
        this._Busqueda = _Busqueda;
    }
   
    SQL S= new SQL();
    
  
    
    public boolean GuardarProducto(DProducto Producto){
    return S.Insertar("Insert into Productos(Codigo,Clave,Producto,Descripcion,PrecioCompra,PrecioVenta,PrecioDolar,DolarActual,Moneda,Stock,FechaConversion,Id_Categoria,Id_Unidad) "
            + "Values('"+Producto.getCodigo()+"','"+Producto.getClave()+"','"+Producto.getProducto()+
            "','"+Producto.getDescripcion()+"',"+Producto.getPrecioCompra()+","+Producto.getPrecioVenta()+","
                    + ""+Producto.getPrecioDolar()+","+Producto.getDolarActual()+",'"+Producto.getMoneda()+"',"
                            + ""+Producto.getStock()+",'"+Producto.getFechaConversion()+"',"+Producto.getIdCategoria()+","+Producto.getIdUnidad()+");");
    }
    
    public DefaultTableModel MostrarProductos(){
    return S.MostrarDinamicamenteMod("Select Id_Producto as ID,Codigo as Codigo,Clave as Clave,Producto as Producto,"
            + "Descripcion as Descripcion,PrecioCompra as 'Precio Compra',PrecioVenta as 'Precio Venta',"
            + "PrecioDolar as 'Precio Dolar',DolarActual as 'Dolar Actual',Moneda as Moneda,Stock as Stock,"
            + "FechaConversion as 'Fecha de Conversion', C.Categoria as Categoria from Productos as P inner join Categorias as C on P.Id_Categoria= C.Id_Categoria where p.estado='1'");
    }
    
    public DefaultTableModel BusquedaPorClaveNombre(DProducto Producto){
    return S.MostrarDinamicamenteMod("Select Id_Producto as ID, Codigo as Codigo, Clave as Clave, Producto as Producto,"
            + "Descripcion as Descripcion, PrecioCompra as 'Precio Compra', PrecioVenta as 'Precio venta', PrecioDolar as 'Precio Dolar',"
            + "DolarActual as 'Dolar Actual',Moneda as Moneda,Stock as Stock, FechaConversion as 'Fecha de Conversion' from Productos"
            + " Where Clave like '%"+Producto.getBusqueda()+"%' or Producto like '%"+Producto.getBusqueda()+"%'");
    }
    
    public DefaultTableModel BusquedaPorClave(DProducto Producto){
    return S.MostrarDinamicamenteMod("Select Id_Producto as ID, Codigo as Codigo, Clave as Clave, Producto as Producto,"
            + "Descripcion as Descripcion, PrecioCompra as 'Precio Compra', PrecioVenta as 'Precio venta', PrecioDolar as 'Precio Dolar',"
            + "DolarActual as 'Dolar Actual',Moneda as Moneda,Stock as Stock, FechaConversion as 'Fecha de Conversion' from Productos"
            + "Where Clave like '"+Producto.getBusqueda()+"%'");
    }
    
    public DefaultTableModel BusquedaPorCodigo(DProducto Producto){
    return S.MostrarDinamicamenteMod("Select Id_Producto as ID, Codigo as Codigo, Clave as Clave, Producto as Producto,"
            + "Descripcion as Descripcion, PrecioCompra as 'Precio Compra', PrecioVenta as 'Precio venta', PrecioDolar as 'Precio Dolar',"
            + "DolarActual as 'Dolar Actual',Moneda as Moneda,Stock as Stock, FechaConversion as 'Fecha de Conversion' from Productos"
            + "Where Codigo like '"+Producto.getBusqueda()+"%'");
    }
    
    public DefaultTableModel BusquedaPorEstado(DProducto Producto){
    return S.MostrarDinamicamenteMod("Select Id_Producto as ID, Codigo as Codigo, Clave as Clave, Producto as Producto,"
            + "Descripcion as Descripcion, PrecioCompra as 'Precio Compra', PrecioVenta as 'Precio Venta', PrecioDolar as 'Precio Dolar',"
            + "DolarActual as 'Dolar Actual', Moneda as Moneda, Stock as Stock, FechaConversion as 'Fecha de Conversion' from Productos"
            + "where Estado='1'");
    }
    
    public boolean ModificarProducto(DProducto Producto){
    return S.Op("Update Productos set Codigo='"+Producto.getCodigo()+"',clave='"+Producto.getClave()+"',"
            + "Producto='"+Producto.getProducto()+"',Descripcion='"+Producto.getDescripcion()+"',PrecioCompra="+Producto.getPrecioCompra()+","
                    + "PrecioVenta="+Producto.getPrecioVenta()+",PrecioDolar="+Producto.getPrecioDolar()+",DolarActual="+Producto.getDolarActual()+","
                            + "Moneda='"+Producto.getMoneda()+"',Stock="+Producto.getStock()+",FechaConversion='"+Producto.getFechaConversion()+"' where Id_Producto="+Producto.getIdProducto()+"");
    }
    
    public DefaultTableModel MostrarParaVenta(DProducto Producto){
    return S.MostrarDinamicamenteMod("Select Id_Producto as ID, Codigo as Codigo, Producto as Producto,"
            + "PrecioVenta as 'Precio venta Where Clave like '"+Producto.getBusqueda()+"%' or Producto like '"+Producto.getBusqueda()+"%'");
    }
    
    public DefaultTableModel MostrarParaVentaPorClave(DProducto Producto){
    return S.MostrarDinamicamenteMod("Select Id_Producto as ID, Codigo as Codigo, Producto as Producto,"
            + "PrecioVenta as 'Precio venta Where Clave like '"+Producto.getBusqueda()+"'");
    }
    
    public DefaultTableModel MostrarParaVentaPorCodigo(DProducto Producto){
    return S.MostrarDinamicamenteMod("Select Id_Producto as ID, Codigo as Codigo, Producto as Producto,"
            + "PrecioVenta as 'Precio venta Where Codigo like '"+Producto.getBusqueda()+"'");
    }
    
}
