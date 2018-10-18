package datos;

import java.sql.*;

public class Conexion {
    private String controlador = "org.postgresql.Driver";
    private String cadenaConexion = "jdbc:postgresql://localhost:5432/examen_final_intento2";
    private String usuario = "postgres";
    private String clave = "silviopd";
    
    private Connection conexion;
    
    protected Connection abrirConexion() throws Exception{
        Class.forName( this.controlador );
        
        this.conexion = DriverManager.getConnection
            (
                this.cadenaConexion,
                this.usuario,
                this.clave
            );
        
        return this.conexion;
    }
    
    protected void cerrarConexion() throws Exception{
        this.conexion.close();
        this.conexion = null;
    }
    
    protected ResultSet ejecutarSQLSelect( String sql ) throws Exception{
        Statement sentencia = null;
        ResultSet resultado = null;
        sentencia = this.abrirConexion().createStatement();
        resultado = sentencia.executeQuery(sql);
        this.cerrarConexion();
        return resultado;
    }
    
    protected ResultSet ejecutarSQLSelectSP(PreparedStatement sentencia) throws Exception{
        ResultSet resultado = null;
        resultado = sentencia.executeQuery();
        this.cerrarConexion();
        return resultado;
    }
    
    
    protected int ejecutarSQL(PreparedStatement sentencia, Connection con) throws Exception{
        int resultado = 0;
        try {
            resultado = sentencia.executeUpdate();
        } catch (Exception e) {
            con.rollback();
            throw e;
        }
        return resultado;
    }
    
    
    
    
}
