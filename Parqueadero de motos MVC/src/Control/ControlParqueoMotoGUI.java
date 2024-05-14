
package Control;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import Modelo.Parqueadero;
import Vista.ParqueoMotoGUI;

public class ControlParqueoMotoGUI implements ActionListener{
    //atributos
    private ParqueoMotoGUI vistaParqueadero;
    private Parqueadero unParqueadero; 

    //Constructor
    public ControlParqueoMotoGUI(){

        this.unParqueadero = new Parqueadero();
        this.vistaParqueadero = new Parqueadero();

        this.vistaParqueadero.setVisible(true);
        this.vistaParqueadero.jBttRegistrar.addActionListener(this);


    }
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource()==this.vistaParqueadero.jBttRegistrar) {
            ControlRegistroMotoGUI registrarMoto=new ControlRegistroMotoGUI();
        }
    }

}
