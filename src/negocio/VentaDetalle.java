
package negocio;

import datos.Conexion;
import java.sql.ResultSet;

public class VentaDetalle extends Conexion{
    
    private int codigo_combustible;
    private double precio_galon;
    private double importe_venta;
    private double cantidad_galones;

    public int getCodigo_combustible() {
        return codigo_combustible;
    }

    public void setCodigo_combustible(int codigo_combustible) {
        this.codigo_combustible = codigo_combustible;
    }

    public double getPrecio_galon() {
        return precio_galon;
    }

    public void setPrecio_galon(double precio_galon) {
        this.precio_galon = precio_galon;
    }

    public double getImporte_venta() {
        return importe_venta;
    }

    public void setImporte_venta(double importe_venta) {
        this.importe_venta = importe_venta;
    }

    public double getCantidad_galones() {
        return cantidad_galones;
    }

    public void setCantidad_galones(double cantidad_galones) {
        this.cantidad_galones = cantidad_galones;
    }

    
    
    public ResultSet configurarDetalleVenta() throws Exception{
        
        String sql ="SELECT " +
        "  codigo," +
        "  nombre," +
        "  precio," +
        "  0.00::numeric(14,2) as importe_venta," +
        "  0.00::numeric(14,2) as cantidad_galones " +
        " FROM " +
        " combustible " +
        " order by 2";
        
        //String sql = "select * from (" +
        //        " select " +
        //        "	0 as codigo," +
        //        "	''::character varying(100) as combustible," +
        //        "	0 as precio," +
        //        "	0.00 as importe," +
        //        "	0.00 as cantidad_venta" +
        //        ") as tb_temporal " +
        //        " where  tb_temporal.codigo <> 0	";
        
        ResultSet resultado = this.ejecutarSQLSelect(sql);
        return resultado;
        
    }
    
    public double calcularGalones(double precio, double importe){
        double galones = 0;
        
        galones = precio / importe;
        
        return galones;
                    
    }
    
    
}
