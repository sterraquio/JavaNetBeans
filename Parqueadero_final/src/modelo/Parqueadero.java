package modelo;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author UNIVALLE
 */
public class Parqueadero {
    private List<Moto> motosRegistradas= new ArrayList<>();
    private Moto espaciosParking[]= new Moto[20];
    
    public Parqueadero(){
    
        for(int i=0; i<20;i++){
            espaciosParking[i]=null;
        }
    }

    public List<Moto> getMotosRegistradas() {
        return motosRegistradas;
    }

    public void setMotosRegistradas(List<Moto> motosRegistradas) {
        this.motosRegistradas = motosRegistradas;
    }

    public Moto[] getEspaciosParking() {
        return espaciosParking;
    }

    public void setEspaciosParking(Moto[] espaciosParking) {
        this.espaciosParking = espaciosParking;
    }
    
    //boolean verificarMoto(String)
    public boolean verificarMoto(String plak){
        
        for(int i=0; i<motosRegistradas.size(); i++){
            if(this.motosRegistradas.get(i).getPlaca().equals(plak)){
                return true;
            }            
        }        
        return false;
    }
    
    //void agregarMoto(Moto)
    public void agregarMoto(Moto motora){
        this.motosRegistradas.add(motora);
    }
    
    //int consultarDisponibilidad()
    public int consultarDisponibilidad(){
        for(int i=0; i<20;i++){
            if(this.espaciosParking[i]== null)
                return i;
        }
        return -1;
    }
    
    //void parquearMoto(Moto)
    public int parquearMoto(Moto motora){
        int espacioLibre= consultarDisponibilidad();
        
        if(espacioLibre != -1){
            this.espaciosParking[espacioLibre] = motora;
        }
        return espacioLibre;        
    }
    
    //void retirarMoto(String plak)
    public int retirarMoto(String plak){
        
        int retiroExitoso=0;
        for(int i=0; i<20; i++){
            if(this.espaciosParking[i].getPlaca().equals(plak)){
                this.espaciosParking[i]=null;
                retiroExitoso=1;
            }
        }
        return retiroExitoso;
    }
}
