package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import modelo.ProfesorDao;
import modelo.Profesor;
import vista.ProfesorGUI;
import java.util.List;
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class ControladorProfesor implements ActionListener {

    private ProfesorDao unProfeDao;
    private Profesor unProfe;
    private ProfesorGUI vista;
    private boolean verdadConsultado = false;

    public ControladorProfesor() {
        this.unProfe = new Profesor();
        this.unProfeDao = new ProfesorDao();

        this.vista = new ProfesorGUI();

        this.vista.setVisible(true);

        this.vista.jButtonIRegistrar.addActionListener(this);
        this.vista.jButtonConsultar.addActionListener(this);
        this.vista.jButtonEliminar.addActionListener(this);
        this.vista.jButtonListar.addActionListener(this);
        this.vista.jButtonModificar.addActionListener(this);

    }

    @Override
    public void actionPerformed(ActionEvent e) {

        //registrar profe
        if (e.getSource() == this.vista.jButtonIRegistrar) {
            this.unProfe.setNumCed(Integer.parseInt(this.vista.jTextFieldCedula.getText()));
            this.unProfe.setNombres(this.vista.jTextFieldNombres.getText());
            this.unProfe.setApellidos(this.vista.jTextFieldApellidos.getText());
            this.unProfe.setProfesion(this.vista.jTextFieldProfesion.getText());

            if (!this.vista.jTextFieldApellidos.getText().equals("") && !this.vista.jTextFieldNombres.getText().equals("") && !this.vista.jTextFieldProfesion.getText().equals("")) {
                if (this.unProfeDao.registrarProfe(unProfe)) {
                    JOptionPane.showMessageDialog(this.vista, "SE HA INGRESADO CORRECTAMENTE");
                    eliminarTextFields();
                } else {
                    JOptionPane.showMessageDialog(this.vista, "Error en el DAO");
                }

            } else {
                JOptionPane.showMessageDialog(this.vista, "los campos no deben estar vacíos");
            }

        }

        //Consultar profe x cedula
        if (e.getSource() == this.vista.jButtonConsultar) {
            
            
            this.unProfe = this.unProfeDao.consultarProfe(Integer.parseInt(this.vista.jTextFieldCedula.getText()));
            
            this.vista.jTextFieldNombres.setText(this.unProfe.getNombres());
            this.vista.jTextFieldApellidos.setText(this.unProfe.getApellidos());
            this.vista.jTextFieldProfesion.setText(this.unProfe.getProfesion());
            //this.vista.jTextFieldCedula.setText(this.unProfe.getNumCed() + "");
        }

        //Modificar profe por su cedula
        if (e.getSource() == this.vista.jButtonModificar) {
            
        }

        //Listar todos los profesores
        if (e.getSource() == this.vista.jButtonListar) {

        }
        //Eliminar profesor x cedula
        if (e.getSource() == this.vista.jButtonEliminar) {

        }
    }

    public void eliminarTextFields() {
        this.vista.jTextFieldCedula.setText("");
        this.vista.jTextFieldNombres.setText("");
        this.vista.jTextFieldApellidos.setText("");
        this.vista.jTextFieldProfesion.setText("");
    }

}
