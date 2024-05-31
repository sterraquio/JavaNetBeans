
package modelo;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ProgramaDao {
    Conexion miConexion = new Conexion();
    
    Connection con;
    PreparedStatement pst;
    ResultSet rs;
    
    public static int codigoPrograma=0;
    public static String nombrePrograma="";
    
    public boolean ingresarPrograma(Programa unPrograma){
    
    
    }
    
}
