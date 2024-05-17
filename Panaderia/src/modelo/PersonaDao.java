package modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class PersonaDao {
    //Crear la conexión usando la clase Conexion;
    Conexion miConexion= new Conexion();
    
    Connection con;
    PreparedStatement pst; //para ejecutar las consultas
    ResultSet rs; //para obtener los resultados de la consulta
    
    //Variables para enviar datos entre interfaces
    public static int cedula_persona=0;
    public static String nombres_persona="";
    public static int edad_persona=0;
    public static String user_persona="";
    public static String password_persona="";
    
    //Login del usuario
    public Persona loginQuery(String user, String password){
        String query = "SELECT * FROM persona WHERE user = ? and password=?";
        Persona persona= new Persona();
        
        try{
            this.con= this.miConexion.obtenerconexion();
            pst = this.con.prepareStatement(query);
            
            //se pasan los parametro ingresados por el usuario
            pst.setString(1, user);
            pst.setString(2, password);
            System.out.println("contenido del query:\n"+pst);
            rs= pst.executeQuery();
            
            if(rs.next()){
                persona.setCedula(rs.getInt("id"));
                cedula_persona= persona.getCedula();
                persona.setNombres(rs.getString("nombres"));
                nombres_persona= persona.getNombres();
                persona.setEdad(rs.getInt("edad"));
                edad_persona= persona.getEdad();
                persona.setUser(rs.getString("user"));
                user_persona= persona.getUser();
            }
            
        }catch(SQLException e){
            JOptionPane.showMessageDialog(null, "Error al obtener los datos de la persona: "+e);
        }
        
        return persona;
    }
    
    //Registar persona
    public boolean insertarPersona(Persona unaPersona){
        String query= "INSERT INTO persona(id, nombres, edad, user, password, creado, actualizado)"
                + "VALUES(?,?,?,?,?,?,?)";
        Timestamp fechaHora = new Timestamp(new Date().getTime());
        
        try{
            this.con= this.miConexion.obtenerconexion();
            
            pst= this.con.prepareStatement(query);
            pst.setInt(1, unaPersona.getCedula());
            pst.setString(2, unaPersona.getNombres());
            pst.setInt(3, unaPersona.getEdad());
            pst.setString(4, unaPersona.getUser());
            pst.setString(5, unaPersona.getPassword());
            pst.setTimestamp(6, fechaHora);
            pst.setTimestamp(7, fechaHora);
            pst.execute();
            
            return true;
        }catch(SQLException e){
            
            JOptionPane.showMessageDialog(null, "Error al ingresar los datos: "+e);
            return false;
        }
        
    }
    
    //Listar personas
    public List listarPesonas(String value){
        List<Persona> listaPersonas = new ArrayList();
        String query = "SELECT * FROM pesona ORDER BY edad ASC";
        String query_Busqueda = "SELEC * FROM persona WHERE id="+value;
        
        try{
            this.con= this.miConexion.obtenerconexion();
            if(value.equalsIgnoreCase("")){
                pst= this.con.prepareStatement(query);
                rs= pst.executeQuery();
            }else{
                pst= this.con.prepareStatement(query_Busqueda);
                rs= pst.executeQuery();
            }
            
            while(rs.next()){
                Persona unaPersona= new Persona();
                
                unaPersona.setCedula(rs.getInt("id"));
                unaPersona.setNombres(rs.getString("nombres"));
                unaPersona.setEdad(rs.getInt("Edad"));
                unaPersona.setUser(rs.getString("user"));
                listaPersonas.add(unaPersona);
            }
            
        }catch(SQLException e ){
            JOptionPane.showMessageDialog(null, "Error al listar los datos: "+e);
        }
        
        return listaPersonas;
    }
    
    //Modificar Persona
    public boolean actualizarPersona(Persona unaPersona){
        String query= "UPDATE persona SET nombres=?, edad=?, user=?, actualizado=?"
                + "WHERE id=?)";
        Timestamp fechaHora = new Timestamp(new Date().getTime());
        
        try{
            this.con= this.miConexion.obtenerconexion();
            
            pst= this.con.prepareStatement(query);
            pst.setString(1, unaPersona.getNombres());
            pst.setInt(2, unaPersona.getEdad());
            pst.setString(3, unaPersona.getUser());
            pst.setTimestamp(4, fechaHora);
            pst.setInt(5, unaPersona.getCedula());
            pst.execute();
            
            return true;
        }catch(SQLException e){
            
            JOptionPane.showMessageDialog(null, "Error al modificar los datos: "+e);
            return false;
        }
        
    }
    
    //Eliminar Persona
    public boolean eliminarPersona(int cedula){
        String query= "DELETE FROM persona WHERE id="+cedula;
        
        try{
            //Obtener la conexión
            this.con= this.miConexion.obtenerconexion();
            //Pasar la consulta
            pst = this.con.prepareStatement(query);
            //Ejecutar la consulta
            pst.execute();
            
            return true;
        }catch(SQLException e){
            JOptionPane.showMessageDialog(null, "Error al eliminar los datos: "+e);
            return false;
        }
        
    }
    
    //Cambiar la contraseña
    public boolean actualizarContrasena(Persona unaPersona){
        String query= "UPDATE persona SET password=? WHERE user='"+unaPersona.getUser()+"'";
        
        try{
            //Obtener la conexión
            this.con= this.miConexion.obtenerconexion();
            //Pasar la consulta
            pst = this.con.prepareStatement(query);
            //Pasar datos para completar la consulta
            pst.setString(1, unaPersona.getPassword());
            //Ejecutar consulta
            pst.execute();
            
            return true;
        }catch(SQLException e){
            JOptionPane.showMessageDialog(null, "Error al actualizar el password: "+e);
            return false;
        }
        
    }
}
