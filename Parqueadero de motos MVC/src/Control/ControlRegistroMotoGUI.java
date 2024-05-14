
package Control;

import Modelo.Moto;
import Vista.RegistroMotoGUI;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.http.WebSocket.Listener;

import javax.swing.Action;

public class ControlRegistroMotoGUI implements ActionListener {
    //atributos
    private RegistroMotoGUI vistaRegistro = new RegistroMotoGUI();
    private Moto unaMoto;

    //Constructor
    public ControlRegistroMotoGUI(){
        this.vistaRegistro = new RegistroMotoGUI();
        this.vistaRegistro.setVisible(true);

        this.vistaRegistro.jBttRegistrar.addActionListener(this);
        
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource()==this.vistaRegistro.jBttRegistrar) {
            javax.swing.JOptionPane.showMessageDialog(vistaRegistro, "Ejecutando el botón");
        }
        
    }
    
}
