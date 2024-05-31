package modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import java.util.List;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;

public class ProfesorDao {

    public ProfesorDao() {
    }

    Conexion miConexion = new Conexion();

    Connection con;
    PreparedStatement pst;
    ResultSet rs;

    public static int cedProfe = 0;
    public static String nombreProfe = "";
    public static String apellidosProfe = "";
    public static String profesionProfe = "";

    public boolean registrarProfe(Profesor unProfe) {
        String query = "INSERT INTO profesor(numCed, nombres, apellidos, profesion)"
                + "VALUES (?, ?, ?, ?)";
        try {
            this.con = this.miConexion.obtenerConexion();

            pst = this.con.prepareStatement(query);
            pst.setInt(1, unProfe.getNumCed());
            pst.setString(2, unProfe.getNombres());
            pst.setString(3, unProfe.getApellidos());
            pst.setString(4, unProfe.getProfesion());
            System.out.println("Contenido del ingreso: " + query);
            pst.execute();

            return true;
            
        } catch (SQLException err) {
            JOptionPane.showMessageDialog(null, "Error: " + err.getMessage());
            return false;
        }
    }

    public Profesor consultarProfe(int cedula) {
        String query = "SELECT * FROM profesor where numCed = ?";
        Profesor unProfe = new Profesor();
        try {
            this.con = this.miConexion.obtenerConexion();
            pst = this.con.prepareStatement(query);

            pst.setInt(1, cedula);
            System.out.println("Contenido de la consutla: " + pst);
            rs = pst.executeQuery();
            if (rs.next()) {
                unProfe.setNumCed(rs.getInt("numCed"));
                unProfe.setNombres(rs.getString("nombres"));
                unProfe.setApellidos(rs.getString("apellidos"));
                unProfe.setProfesion(rs.getString("profesion"));

                cedProfe = unProfe.getNumCed();
                nombreProfe = unProfe.getNombres();
                apellidosProfe = unProfe.getApellidos();
                profesionProfe = unProfe.getProfesion();

            } else {
                JOptionPane.showMessageDialog(null, "Usuario no encontrado");
            }

        } catch (SQLException err) {
            JOptionPane.showMessageDialog(null, "Error: " + err.getMessage());
        }
        return unProfe;
    }

    public boolean actualizarProfe(Profesor unProfe) {
        String query = "UPDATE profesor set nombres=?, apellidos=?, profesion=?"
                + "WHERE numCed=?";
        Timestamp fechaHora = new Timestamp(new Date().getTime());
        try {
            this.con = this.miConexion.obtenerConexion();

            pst = this.con.prepareStatement(query);
            pst.setString(1, unProfe.getNombres());
            pst.setString(2, unProfe.getApellidos());
            pst.setString(3, unProfe.getProfesion());
            pst.setInt(4, unProfe.getNumCed());
            System.out.println("Consulta: "+pst);
            pst.execute();
            
            
            return true;
        } catch (SQLException error) {
            JOptionPane.showMessageDialog(null, "Error al modificar \n" + error.getMessage());
            return false;
        }

    }

    public List listarProfesor() {
        List<Profesor> listaProfes = new ArrayList<>();
        String query = "SELECT * FROM profesor ORDER BY nombres ASC";

        try {
            this.con = this.miConexion.obtenerConexion();

            pst = this.con.prepareStatement(query);
            rs = pst.executeQuery();
            while (rs.next()) {
                Profesor unProfe = new Profesor();

                unProfe.setNumCed(rs.getInt("numCed"));
                unProfe.setNombres(rs.getString("nombres"));
                unProfe.setApellidos(rs.getString("apellidos"));
                unProfe.setProfesion(rs.getString("profesion"));
                listaProfes.add(unProfe);
            }

        } catch (SQLException err) {
            JOptionPane.showMessageDialog(null, "Error con listar los datos" + err);
        }
        return listaProfes;
    }

    public boolean borrarProfe(int cedula) {
        String query = "DELETE FROM profesor WHERE numCed =?";
        Timestamp fechaHora = new Timestamp(new Date().getTime());

        try {
            this.con = this.miConexion.obtenerConexion();

            pst = this.con.prepareStatement(query);
            pst.setInt(1, cedula);
            pst.execute();
            return true;

        } catch (SQLException err) {
            JOptionPane.showMessageDialog(null, "Error con borrar al profe. \n" + err);
            return false;
        }

    }

}
