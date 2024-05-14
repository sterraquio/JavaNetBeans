
package Modelo;

import java.util.ArrayList;
import java.util.List;

public class Parqueadero {
    //Atributos
    private List<Moto> motosRegistradas = new ArrayList<>();
    private Moto espaciosParking[] = new Moto[20];
    

    //Constructor
    public Parqueadero(){}

    //métodos Getters y Setters
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

    //Métodos

    public boolean verificarMoto(String plak){
        for (int i = 0; i < motosRegistradas.size(); i++) {
            if (motosRegistradas.get(i).getPlaca().equals(plak)) {
                return true;
            }
        }
        return false;
    }

    public void agregarMoto(Moto motora){
        this.motosRegistradas.add(motora);
    }
    public int consultarDisponible(){
        for (int i = 0; i < 20; i++) {
            if (this.espaciosParking[i]==null) {
                return i;
            }
        }
        return -1;
    }

    public int parquearMoto(Moto motora){
        int espacioLibre= consultarDisponible();
        int parqueado=0;
        if (espacioLibre != -1) {
            this.espaciosParking[espacioLibre]=motora;
            parqueado=1;
        }
        return parqueado;
    }

    public int retirarMoto(String plak){
        int retiroExitoso=0;
        for (int i = 0; i < espaciosParking.length; i++) {
            if (this.espaciosParking[i].getPlaca().equals(plak)) {
                this.espaciosParking[i]=null;
                retiroExitoso = 1;
            }
        }
        return retiroExitoso;
    }

}

