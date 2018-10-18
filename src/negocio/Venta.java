
package negocio;

import datos.Conexion;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class Venta extends Conexion{
    
    private int nro_venta;
    private java.sql.Date fecha;
    private int codigo_cliente;
    private String tipo_venta;
    private double total;
    private int codigo_usuario;

    public ArrayList<VentaDetalle> getProductosDetalleVenta() {
        return productosDetalleVenta;
    }

    public void setProductosDetalleVenta(ArrayList<VentaDetalle> productosDetalleVenta) {
        this.productosDetalleVenta = productosDetalleVenta;
    }

    public ArrayList<Caja> getDetalleCaja() {
        return DetalleCaja;
    }

    public void setDetalleCaja(ArrayList<Caja> DetalleCaja) {
        this.DetalleCaja = DetalleCaja;
    }
    
    
    
    private ArrayList<VentaDetalle> productosDetalleVenta = new ArrayList<VentaDetalle>();
    private ArrayList<Caja> DetalleCaja = new ArrayList<Caja>();
    
    public int getNro_venta() {
        return nro_venta;
    }

    public void setNro_venta(int nro_venta) {
        this.nro_venta = nro_venta;
    }

    public String getTipo_venta() {
        return tipo_venta;
    }

    public void setTipo_venta(String tipo_venta) {
        this.tipo_venta = tipo_venta;
    }

    
 

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public int getCodigo_cliente() {
        return codigo_cliente;
    }

    public void setCodigo_cliente(int codigo_cliente) {
        this.codigo_cliente = codigo_cliente;
    }


    public int getCodigo_usuario() {
        return codigo_usuario;
    }

    public void setCodigo_usuario(int codigo_usuario) {
        this.codigo_usuario = codigo_usuario;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }


    
    
    
    public boolean grabarVenta() throws Exception{
        String sql = "select * from f_generar_correlativo('venta') as nv";
        ResultSet resultado = this.ejecutarSQLSelect(sql);
        if(resultado.next()){
            int nuevoNv = resultado.getInt("nv");
            this.setNro_venta(nuevoNv);
            
            //iniciar transaccion
            Connection transaccion = this.abrirConexion();
            transaccion.setAutoCommit(false);
            
            /* 1. Inicio: insertar en la tabla comanda  */
            sql = "INSERT INTO venta(" +
        "            nro_venta, fecha, codigo_cliente, tipo_venta,  total, " +
        "           codigo_usuario )" +
        "    VALUES (?, ?, ?, ?, ?, " +
        "            ?);";
            
            PreparedStatement spInsertarComanda =
                    transaccion.prepareStatement(sql);
            spInsertarComanda.setInt(1, this.getNro_venta());
            spInsertarComanda.setDate(2, this.getFecha());
            spInsertarComanda.setInt(3, this.getCodigo_cliente());
            spInsertarComanda.setString(4, this.getTipo_venta());
            spInsertarComanda.setDouble(5, this.getTotal());
            spInsertarComanda.setInt(6, this.getCodigo_usuario());
            this.ejecutarSQL(spInsertarComanda,transaccion);
            
            /* 1. Fin: insertar en la tabla comanda  */
             
            /* 2. Inicio: insertar en la tabla compra detalle  */
            
            for (int i = 0; i < productosDetalleVenta.size(); i++) {
                VentaDetalle fila = productosDetalleVenta.get(i);
                sql = "INSERT INTO venta_detalle(" +
                "            nro_venta, codigo_combustible,  precio_galon, importe_venta, cantidad_galones)" +
                "    VALUES (?, ?, ?, ?, ?);";
                
                PreparedStatement spInsertarDetalle = transaccion.prepareStatement(sql);
                spInsertarDetalle.setInt(1, this.getNro_venta());
                spInsertarDetalle.setInt(2, fila.getCodigo_combustible());
                spInsertarDetalle.setDouble(3, fila.getPrecio_galon());
                spInsertarDetalle.setDouble(4, fila.getImporte_venta());
                spInsertarDetalle.setDouble(5, fila.getCantidad_galones());
                this.ejecutarSQL(spInsertarDetalle, transaccion);
                
                
                // 3 Actualizar Stock
                sql ="update combustible set stock = stock - ? where codigo = ?";
                     PreparedStatement spActualizarStock = transaccion.prepareStatement(sql);
                     spActualizarStock.setInt(1, (int)fila.getCantidad_galones());
                     spActualizarStock.setInt(2, fila.getCodigo_combustible());
                     this.ejecutarSQL(spActualizarStock, transaccion);
            } 
            
           if(tipo_venta == "1"){
                sql = "INSERT INTO caja("
                        + "            nro_venta, importe_venta, codigo_usuario)"
                        + "    VALUES (?, ?, ?);";
                PreparedStatement insertarCaja = transaccion.prepareStatement(sql);
                insertarCaja.setInt(1, this.getNro_venta());
                insertarCaja.setDouble(2, this.getTotal());
                insertarCaja.setInt(3, this.getCodigo_usuario());
                this.ejecutarSQL(insertarCaja, transaccion);
           }
               
            
            
            /* 2. Fin: insertar en la tabla compra detalle 
            
            /* 4. Inicio: insertar en la tabla compra detalle  */
            
            sql = "update correlativo set numero = numero +1 where tabla ='venta'";
            PreparedStatement spActualizarCorrelativo = transaccion.prepareStatement(sql);
            this.ejecutarSQL(spActualizarCorrelativo, transaccion);
            /* 4. Fin: insertar en la tabla compra detalle  */
            
            
            
            
            transaccion.commit();
            transaccion.close();
            
        }else {
            throw new Exception("No existe un correlativo para la tabla venta");
        }
        return true;
    }
    
    public ResultSet listar() throws Exception{
        
        String sql = "SELECT " +
            "  venta.nro_venta, " +
            "  cliente.nombre, " +
            "  venta.fecha, " +
            "  venta.total, " +
            "  venta.tipo_venta, " +
            "  usuario.nombre, " +
            "  venta.estado " +
            " FROM " +
            "  public.venta, " +
            "  public.cliente, " +
            "  public.usuario " +
            " WHERE " +
            "  cliente.codigo = venta.codigo_cliente AND" +
            "  usuario.codigo = venta.codigo_usuario " +
            " ORDER BY " +
            "  venta.nro_venta ASC;";
        PreparedStatement sentencia = 
                this.abrirConexion().prepareStatement(sql,ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
        
        ResultSet resultado = this.ejecutarSQLSelectSP(sentencia);
        return resultado;
    }
    
    public boolean anular(int numeroComanda) throws Exception{
        String sql = "select estado from venta where nro_venta = ?";
        
        PreparedStatement sentencia = this.abrirConexion().prepareStatement(sql);
        sentencia.setInt(1, numeroComanda);
        ResultSet resultado = this.ejecutarSQLSelectSP(sentencia);
        
        if (resultado.next()){
            if(resultado.getString("estado").equalsIgnoreCase("A")){
                throw new Exception("La venta que intenta anular ya esta anulada");
            }else{
                //procedo a implementar el codigo para anular la compra
                
                //inicio de la transaccion
           
                Connection transaccion = this.abrirConexion();
                transaccion.setAutoCommit(false);
                
                sql = "update venta set estado = 'A' where nro_venta =? ";
                PreparedStatement spAnular = transaccion.prepareStatement(sql);
                spAnular.setInt(1, numeroComanda);
                this.ejecutarSQL(spAnular, transaccion);
                
                sql = "select codigo_combustible,cantidad_galones " +
                    " from venta_detalle " +
                    " where nro_venta = ?";
                PreparedStatement spProductoComanda = this.abrirConexion().prepareStatement(sql);
                spProductoComanda.setInt(1, numeroComanda);
                
                ResultSet rsProductoComanda = this.ejecutarSQLSelectSP(spProductoComanda);
                while(rsProductoComanda.next()){
                    
                    
                   sql = "update combustible set stock = stock + ? where codigo = ?"; 
                   PreparedStatement spActualizarStock = transaccion.prepareStatement(sql);
                    spActualizarStock.setDouble(1, rsProductoComanda.getDouble("cantidad_galones"));
                  spActualizarStock.setInt(2, rsProductoComanda.getInt("codigo_combustible"));
                    this.ejecutarSQL(spActualizarStock, transaccion);
                }
                
                transaccion.commit();
                transaccion.close();
                
            }
        }else{
            throw new Exception("No se ah encontrado la comanda que intenta anular");
        }
        
        return true;
    }
    
}
