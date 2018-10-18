
package negocio;

import datos.Conexion;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class Combustible extends Conexion{
    
    private int codigo_producto;
    private String nombre;
    private double precio;
    private int stock;
    private int codigoCategoria;

    public int getCodigo_producto() {
        return codigo_producto;
    }

    public void setCodigo_producto(int codigo_producto) {
        this.codigo_producto = codigo_producto;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public int getCodigoCategoria() {
        return codigoCategoria;
    }

    public void setCodigoCategoria(int codigoCategoria) {
        this.codigoCategoria = codigoCategoria;
    }
    
    
    public ResultSet listar() throws Exception{
     String sql ="SELECT " +
        "  combustible.codigo,  " +
        "  combustible.nombre,  " +
        "  combustible.precio " +
        " FROM " +
        "  public.combustible " +
        " ORDER BY " +
        "  combustible.nombre ASC;";
     
     PreparedStatement sentencia 
                = this.abrirConexion().prepareStatement
                    (
                        sql,
                        ResultSet.TYPE_SCROLL_INSENSITIVE,
                        ResultSet.CONCUR_READ_ONLY
                    );
        ResultSet resultado = this.ejecutarSQLSelectSP(sentencia);
        return resultado;
     
            }
    
}
