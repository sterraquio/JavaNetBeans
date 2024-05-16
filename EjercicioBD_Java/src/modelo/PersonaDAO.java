package modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class PersonaDAO {

    //Atributos
    private Conexion miConexion = new Conexion();//Se crea conexión a partir de un objeto Conexion

    Connection con;

    PreparedStatement pst; //Para ejecutar consultas
    ResultSet rs;//Para obtener los resultados de la consutla

    //Variables para enviar datos entre la interfaces
    public static int cedulaPersona = 0;
    public static String nombresPersonas = "";
    public static int edadPersona = 0;
    public static String userPersona = "";

    //Login usuario
    public Persona LoginConsulta(String user, String password) {

        String query = "SELECT * FROM personas WHERE user=? AND password =?";
        Persona unaPersona = new Persona();

        try {
            //Aquí se entablaron la conexión con la base de datos
            this.con = this.miConexion.obtenerConexion();
            //prepareStatement sin el prepareDDDDD
            pst = this.con.prepareStatement(query);

            //Se pasan los datos ingresados por los usuarios para completar ...
            pst.setString(1, user);
            pst.setString(2, password);

            System.out.println("Contenido de la consutla: \n" + pst);

            //Se ejecuta la consulta 😊😎
            rs = pst.executeQuery();

            //Capturar los resultados
            //Posicionar puntero de null a los resultado (filas)
            if (rs.next()) {
                //Colocando valores de la base de datos a el objeto. El getInt("nombre de la columna que se quiere obtener")
                unaPersona.setCedula(rs.getInt("cedula"));
                cedulaPersona = unaPersona.getCedula();
                unaPersona.setNombres(rs.getString("nombres"));
                nombresPersonas = unaPersona.getNombres();
                unaPersona.setEdad(rs.getInt("edad"));
                edadPersona = unaPersona.getEdad();
                unaPersona.setUser(rs.getString("user"));
                userPersona = unaPersona.getUser();

            }

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al obtener los datos de la persona:\n" + e);
        }
        return unaPersona;
    }

}
