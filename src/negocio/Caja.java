
package negocio;

import datos.Conexion;
import java.sql.ResultSet;
import java.util.ArrayList;
import javax.swing.JComboBox;

public class Caja extends Conexion{
    
    private double importe_venta;
    private int codigo_usuario;

    public double getImporte_venta() {
        return importe_venta;
    }

    public void setImporte_venta(double importe_venta) {
        this.importe_venta = importe_venta;
    }

    public int getCodigo_usuario() {
        return codigo_usuario;
    }

    public void setCodigo_usuario(int codigo_usuario) {
        this.codigo_usuario = codigo_usuario;
    }
    

    

    
}
