
package negocio;

import datos.Conexion;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import javax.swing.JComboBox;

public class Cliente extends Conexion{
    
    private int codigo_cliente;
    private String nombre;

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
        public static ArrayList<Cliente> listaC = new ArrayList<Cliente>();

    public int getCodigo_cliente() {
        return codigo_cliente;
    }

    public void setCodigo_cliente(int codigo_cliente) {
        this.codigo_cliente = codigo_cliente;
    }

    public static ArrayList<Cliente> getListaC() {
        return listaC;
    }

    public static void setListaC(ArrayList<Cliente> listaC) {
        Cliente.listaC = listaC;
    }
        
        

    public ResultSet listar() throws Exception{
        String sql = "select "
                + "     codigo_cliente," +
                    "	apellidos," +
                    "	nombres," +
                    "	direccion" +
                    " from " +
                    "	cliente" +
                    " order " +
                    "	by 2 ";
        
        PreparedStatement sentencia =
                this.abrirConexion().prepareStatement(
                            sql,
                            ResultSet.FETCH_FORWARD,
                            ResultSet.TYPE_FORWARD_ONLY
                        );
        
        ResultSet resultado 
                = this.ejecutarSQLSelectSP(sentencia);
        
        return resultado;
    }
    
    private void cargarTablaC() throws Exception{
        String sql = "select codigo,nombre from cliente";
        ResultSet resultado = this.ejecutarSQLSelect(sql);
        listaC.clear();
        while(resultado.next()){
            Cliente objC = new Cliente();
            objC.setCodigo_cliente(resultado.getInt("codigo") );
            objC.setNombre(resultado.getString("nombre"));
            listaC.add(objC);
        }
    }
    
    public void llenarComboC(JComboBox objCombo) throws Exception{
        objCombo.removeAllItems();
        this.cargarTablaC();
        for (int i = 0; i < listaC.size(); i++) {
            objCombo.addItem(listaC.get(i).getNombre());
        }
    }
    
    
}
