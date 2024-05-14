package modelo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class Conexion {

    //Atributos
    //Se coloca en "" el nombre de la base de datos
    private String db_panaderia = "panaderia";
    private String user = "root";
    private String password = "univalle";
    //generico
    private String url = "jdbc:mysql://localhost:3306/" + db_panaderia;

    Connection conexion = null;

    public Connection obtenerConexion() {
        try {
            //Obtener valor del driver
            Class.forName("com.mysql.cj.jdbc.Driver");
            //Obtener conexion DB
            conexion = DriverManager.getConnection(this.url, this.user, this.password);
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Ha ocurrido una exepción de SQLException: "+ e.getMessage());
        }catch(ClassNotFoundException x){
        JOptionPane.showMessageDialog(null, "Ha ocurrido una exepción de : ClassNotFoundException"+ x.getMessage());
        }
        return conexion;
    }
}
