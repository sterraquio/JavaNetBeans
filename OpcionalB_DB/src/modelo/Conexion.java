
package modelo;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class Conexion {
    private String nombreDB="practica";
    private String user = "root";
    private String password ="";
    private String url="jdbc:mysql//127.0.0.1:3306/"+this.nombreDB;
    
    Connection conexion = null;
    
    public Connection obtenerConexion(){
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            conexion = DriverManager.getConnection(this.url, this.user, this.password);
            
        }catch(SQLException err){
            JOptionPane.showMessageDialog(null, "Error: "+err);
        }catch(ClassNotFoundException noex){
        JOptionPane.showMessageDialog(null, "Error: "+ noex);
        }
     
        return conexion;
        
    }
    
    
    public Conexion() {
    }
    
}
