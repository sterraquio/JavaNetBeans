package control;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import vista.RegistroMotoGUI;
import modelo.Moto;

/**
 *
 * @author UNIVALLE
 */
public class ControlRegistroMotoGUI implements ActionListener {

    private RegistroMotoGUI vistaRegistro;
    private Moto unaMoto;
    private ControlParqueoMotoGUI ctrlParkMotoGUI;
    
    public ControlRegistroMotoGUI(){
        
        this.vistaRegistro= new RegistroMotoGUI();
        this.vistaRegistro.setVisible(true);
        
        this.vistaRegistro.jbtn_agregarMoto.addActionListener(this);
    }    
    
    
    @Override
    //EVENTO BOTON REGISTRAR
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == this.vistaRegistro.jbtn_agregarMoto){
            unaMoto= new Moto();
            
            unaMoto.setPlaca(this.vistaRegistro.jtf_placa.getText());
            unaMoto.setMarca(this.vistaRegistro.jtf_marca.getText());
            unaMoto.setDniPropietario(Integer.parseInt(this.vistaRegistro.jtf_dniPropietario.getText()));
            
            this.ctrlParkMotoGUI.getUnParqueadero().getMotosRegistradas().add(unaMoto);
            
            javax.swing.JOptionPane.showMessageDialog(vistaRegistro, "La moto con placa: "+this.vistaRegistro.jtf_placa.getText()+
                                                                       "\nFue registrada con éxito");
            this.vistaRegistro.dispose();
        }
    }

    public RegistroMotoGUI getVistaRegistro() {
        return vistaRegistro;
    }

    public void setVistaRegistro(RegistroMotoGUI vistaRegistro) {
        this.vistaRegistro = vistaRegistro;
    }

    public Moto getUnaMoto() {
        return unaMoto;
    }

    public void setUnaMoto(Moto unaMoto) {
        this.unaMoto = unaMoto;
    }

    public ControlParqueoMotoGUI getCtrlParkMotoGUI() {
        return ctrlParkMotoGUI;
    }

    public void setCtrlParkMotoGUI(ControlParqueoMotoGUI ctrlParkMotoGUI) {
        this.ctrlParkMotoGUI = ctrlParkMotoGUI;        
        this.vistaRegistro.jtf_placa.setText(this.ctrlParkMotoGUI.getVistaParqueadero().jtf_placaMoto.getText());
    }

    
    
    
}
