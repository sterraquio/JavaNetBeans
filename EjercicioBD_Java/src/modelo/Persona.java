package modelo;

import java.security.Timestamp;

public class Persona {

    //atribute
    private int cedula;
    private String nombres;
    private int edad;
    private String user;
    private String password;
    private String creado;
    private String actualizado;
    
    //Constructor method without parameters
    public Persona() {
    }
    
    //Constructor with parameters
    public Persona(int cedula, String nombres, int edad, String user, String password, String creado, String actualizado) {
        this.cedula = cedula;
        this.nombres = nombres;
        this.edad = edad;
        this.user = user;
        this.password = password;
        this.creado = creado;
        this.actualizado = actualizado;
    }
    
    

//Getters and setters

    public int getCedula() {
        return cedula;
    }

    public void setCedula(int cedula) {
        this.cedula = cedula;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getCreado() {
        return creado;
    }

    public void setCreado(String creado) {
        this.creado = creado;
    }

    public String getActualizado() {
        return actualizado;
    }

    public void setActualizado(String actualizado) {
        this.actualizado = actualizado;
    }



}
