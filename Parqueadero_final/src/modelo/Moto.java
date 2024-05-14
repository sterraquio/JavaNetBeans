package modelo;

/**
 *
 * @author UNIVALLE
 */
public class Moto {
    private String placa;
    private String marca;
    private int dniPropietario;
    
    public Moto(){};

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public int getDniPropietario() {
        return dniPropietario;
    }

    public void setDniPropietario(int dniPropietario) {
        this.dniPropietario = dniPropietario;
    }
    
    
}
