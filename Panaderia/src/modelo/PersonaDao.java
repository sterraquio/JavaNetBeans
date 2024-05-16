package modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class PersonaDao {
    //atributos
    Conexion miConexion= new Conexion();//Se crea la conexión
    
    Connection con;
    //preparedStament??????????????????????????????
    PreparedStatement pst; //para ejecutar consultas
    // resultset???????????????????????
    ResultSet rs; //para obtener los resultados de la consulta
    
    //Variables para enviar datos entre las interfaces
    public static int cedula_persona=0;
    public static String nombres_persona="";
    public static int edad_persona=0;
    public static String user_persona="";
    
    //Login usuario
    public Persona loginQuery(String user, String password){
        String query="SELECT * FROM personas WHERE user=? AND password=?";
        Persona unaPersona= new Persona();
        
        try{
            this.con= this.miConexion.obtenerConexion();
            pst = this.con.prepareStatement(query);
            
            //se pasan los datos ingresados por el usuario para completar el query
            pst.setString(1, user);
            pst.setString(2, password);
            System.out.println("Contenido de la consulta:\n"+pst);
            //Se ejecuta la consulta
            rs= pst.executeQuery();
            // .next????????????????????????????????
            if(rs.next()){
                unaPersona.setCedula(rs.getInt("cedula"));
                cedula_persona=unaPersona.getCedula();
                unaPersona.setNombres(rs.getString("nombres"));
                nombres_persona = unaPersona.getNombres();
                unaPersona.setEdad(rs.getInt("edad"));
                edad_persona = unaPersona.getEdad();
                unaPersona.setUser(rs.getString("user"));
                user_persona = unaPersona.getUser();
            }
            
        }catch(SQLException e){
            JOptionPane.showMessageDialog(null, "Error al obtener los datos de la persona:\n"+e.getMessage());
        }
        
        return unaPersona;
    }
    
}
