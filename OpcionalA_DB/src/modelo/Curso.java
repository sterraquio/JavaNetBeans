
package modelo;


 
public class Curso {
    private int codigoCurso;
    private String nombreCurso;
    private Programa unPrograma= new Programa();
    private Profesor unprofe=  new Profesor();

    public Curso() {
    }

    public int getCodigoCurso() {
        return codigoCurso;
    }

    public void setCodigoCurso(int codigoCurso) {
        this.codigoCurso = codigoCurso;
    }

    public String getNombreCurso() {
        return nombreCurso;
    }

    public void setNombreCurso(String nombreCurso) {
        this.nombreCurso = nombreCurso;
    }

    public Programa getUnPrograma() {
        return unPrograma;
    }

    public void setUnPrograma(Programa unPrograma) {
        this.unPrograma = unPrograma;
    }

    public Profesor getUnprofe() {
        return unprofe;
    }

    public void setUnprofe(Profesor unprofe) {
        this.unprofe = unprofe;
    }
    
    
}
