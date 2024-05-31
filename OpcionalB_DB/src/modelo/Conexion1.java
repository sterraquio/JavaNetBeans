
package modelo;
import java.sql.DriverManager;
import java.sql.SQLException;

import java.sql.Connection;
import javax.swing.JOptionPane;


public class Conexion1 {
    private String nombreBD="practica";
    private String user = "root";
    private String password = "";
    private String url = "jdbc:mysql://127.0.0.1:3306"+this.nombreBD;
    
    public Connection obtenerConexion(){
    Connection conexion = null;
    try{
        Class.forName("com.mysql.cj.jdbc.Driver");
        conexion = DriverManager.getConnection(this.url, this.user, this.password);
        
    }catch(SQLException xd){
    
        JOptionPane.showMessageDialog(null, "error: " + xd);
    }catch(ClassNotFoundException noxd){
    JOptionPane.showMessageDialog(null, "Error de clase: "+noxd);
    }
    return conexion;
    }
    
}
