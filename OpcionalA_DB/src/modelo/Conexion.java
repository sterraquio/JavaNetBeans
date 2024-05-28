package modelo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexion {

    private String nombreBD = "cursos";
    private String user = "root";
    private String password = "";
    private String url = "jdbc:mysql://127.0.0.1:3306/" + this.nombreBD;

    Connection conexion = null;

    //Método
    public Connection obtenerConexion() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conexion = DriverManager.getConnection(this.url, this.user, this.password);
            
        } catch (SQLException xd) {
            System.out.println("Error " + xd.getMessage());

        }catch(ClassNotFoundException x){
            System.out.println("Error con la clase: "+x.getMessage());
        }
        return conexion;
    }

}
