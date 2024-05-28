
package modelo;

public class Profesor {
    private int numCed;
    private String nombres;
    private String apellidos;
    private String profesion;

    public Profesor() {
    }

    public int getNumCed() {
        return numCed;
    }

    public void setNumCed(int numCed) {
        this.numCed = numCed;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getProfesion() {
        return profesion;
    }

    public void setProfesion(String profesion) {
        this.profesion = profesion;
    }
    
}
