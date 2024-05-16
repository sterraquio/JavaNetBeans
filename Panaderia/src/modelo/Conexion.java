package modelo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class Conexion {
    //atributos
    private String db_panaderia="panaderia";
    private String user="root";
    private String password="";
    private String url="jdbc:mysql://localhost:3306/"+db_panaderia;
    
    Connection conexion= null;
    
    public Connection obtenerConexion(){
        try{
            //Obtener el valor del driver
            Class.forName("com.mysql.cj.jdbc.Driver");
            //Obtener conexión DB
            conexion = DriverManager.getConnection(this.url, this.user, this.password);
        
        }catch(SQLException e){
            JOptionPane.showMessageDialog(null, "Ha ocurrido una excepcion SQLException: "+e.getMessage());
        }catch(ClassNotFoundException e){
            JOptionPane.showMessageDialog(null, "Ha ocurrido una excepcion ClassNotFoundException: "+e.getMessage());
        }
        return conexion;
    }
    
}
