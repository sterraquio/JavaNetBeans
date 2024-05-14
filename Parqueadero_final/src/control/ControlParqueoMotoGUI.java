package control;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import vista.ParqueoMotoGUI;
import modelo.Parqueadero;

/**
 *
 * @author UNIVALLE
 */
public class ControlParqueoMotoGUI implements ActionListener{
    
    private ParqueoMotoGUI vistaParqueadero;
    private Parqueadero unParqueadero;
    
    private int cantMotReg;
    private int bandMotReg=0;
    private int espacioAsignado;
    private int espaciosVacios=20;
    
    private boolean bandMotoNoPark=true;
    
    //constructor
    public ControlParqueoMotoGUI(){
            
        this.vistaParqueadero= new ParqueoMotoGUI();
        this.unParqueadero= new Parqueadero();
        
        this.vistaParqueadero.setVisible(true);
        
        //SE AGREGAN LOS ESCUCHAS O LISTENERS A LOS BOTONES
        this.vistaParqueadero.jbtn_registrarMoto.addActionListener(this);
        this.vistaParqueadero.jbtn_verificarMoto.addActionListener(this);
        this.vistaParqueadero.jbtn_parquearMoto.addActionListener(this);
        this.vistaParqueadero.jbtn_retirarMoto.addActionListener(this);
    }

    //Métodos
    @Override    
    public void actionPerformed(ActionEvent e) {
        //EVENTO BOTON REGISTRAR MOTO
        if(e.getSource() == this.vistaParqueadero.jbtn_registrarMoto){
            ControlRegistroMotoGUI registrarMoto= new ControlRegistroMotoGUI();
            registrarMoto.setCtrlParkMotoGUI(this);
        }
        
        //EVENTO BOTON VERIFICAR MOTO
        if(e.getSource() == this.vistaParqueadero.jbtn_verificarMoto){
            cantMotReg= this.unParqueadero.getMotosRegistradas().size();
            bandMotReg=0;
            
            if(cantMotReg != 0){
                for(int i=0;i<cantMotReg;i++){
                    if(this.vistaParqueadero.jtf_placaMoto.getText().equals(this.unParqueadero.getMotosRegistradas().get(i).getPlaca())){
                        javax.swing.JOptionPane.showMessageDialog(vistaParqueadero, "La moto esta registrada");
                        bandMotReg=1;
                        break;   
                    }                 
                } 
                                           
                if(bandMotReg==0){
                    javax.swing.JOptionPane.showMessageDialog(vistaParqueadero, "La moto no esta registrada\nPor favor registrela");
                    
                    ControlRegistroMotoGUI registrarMoto= new ControlRegistroMotoGUI();
                    registrarMoto.setCtrlParkMotoGUI(this);
                }               
                
            }else{
                javax.swing.JOptionPane.showMessageDialog(vistaParqueadero, "No hay motos registradas");
            } 
        }
        
        //EVENTO DEL BOTON PARQUEAR
        if(e.getSource() == this.vistaParqueadero.jbtn_parquearMoto){        
            
            cantMotReg= this.unParqueadero.getMotosRegistradas().size();
                for(int i=0;i<cantMotReg;i++){
                    if(this.vistaParqueadero.jtf_placaMoto.getText().equals(this.unParqueadero.getMotosRegistradas().get(i).getPlaca())){
                        
                        espacioAsignado= this.unParqueadero.parquearMoto(this.unParqueadero.getMotosRegistradas().get(i));
                        
                        if(espacioAsignado > -1){
                            javax.swing.JOptionPane.showMessageDialog(vistaParqueadero, "La moto se parqueo\nEn el esPAcio: "+(espacioAsignado+1));
                        }
                    }                 
                }      
        }
        
        //EVENTO BOTON RETIRAR MOTO
        if(e.getSource() == this.vistaParqueadero.jbtn_retirarMoto){
            bandMotoNoPark=true;
            espaciosVacios = 20;
            for(int i=0; i<20;i++){                
                if(this.unParqueadero.getEspaciosParking()[i] != null){
                    espaciosVacios--;
                    if(this.vistaParqueadero.jtf_placaMoto.getText().equals(this.unParqueadero.getEspaciosParking()[i].getPlaca())){
                        this.unParqueadero.getEspaciosParking()[i]=null;
                        bandMotoNoPark=false;
                        javax.swing.JOptionPane.showMessageDialog(vistaParqueadero, "LA MOTO FUE RETIRADA DEL ESPACIO: "+(i+1));
                        break;
                    }                    
                }
            } 
            
            if(espaciosVacios == 20){
                javax.swing.JOptionPane.showMessageDialog(vistaParqueadero,"EL parqueadero esta vacio");
            }else{
                if(bandMotoNoPark){
                    javax.swing.JOptionPane.showMessageDialog(vistaParqueadero,"La moto no esta parqueada");
                }
            }
        }
    }    

    public ParqueoMotoGUI getVistaParqueadero() {
        return vistaParqueadero;
    }

    public void setVistaParqueadero(ParqueoMotoGUI vistaParqueadero) {
        this.vistaParqueadero = vistaParqueadero;
    }

    public Parqueadero getUnParqueadero() {
        return unParqueadero;
    }

    public void setUnParqueadero(Parqueadero unParqueadero) {
        this.unParqueadero = unParqueadero;
    }
    
    
}
