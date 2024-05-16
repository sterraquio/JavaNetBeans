package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import modelo.Persona;
import vista.VistaLogin;
import vista.VistaPersona;
import modelo.PersonaDAO;

public class ControlLogin implements ActionListener {

    //atributos
    private Persona unaPersona;
    private PersonaDAO unaPersonaDao;
    private VistaLogin vista;
    private VistaPersona vistaPersona;

    private String user;
    private String password;

    public ControlLogin() {
        this.unaPersona = new Persona();
        this.unaPersonaDao = new PersonaDAO();
        this.vista = new VistaLogin();
        this.vista.setVisible(true);

        this.vista.jButtonIngresar.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        //SUPER IMPORTANTE EL MÉTODO .trim() ELIMINA LOS ESPACIOS EN BLANCO DE LOS TEXTOS
        this.user = this.vista.jTextFieldUser.getText().trim();
        //Aparece así el gettex porque está pasado de moda
        this.password = this.vista.jPasswordFieldPassword.getText().trim();

        if (e.getSource() == this.vista.jButtonIngresar) {
            //validar que los campos no estén vacíos
            if (!this.user.equals("") || !this.password.equals("")) {
                //Se pasan los parámetros al método loginConsulta
                this.unaPersona = this.unaPersonaDao.LoginConsulta(this.user, this.password);

                //Verificar si los datos son válidos
                if (this.unaPersona.getUser() != null) {
                    if (this.unaPersona.getCedula() == 1) {
                        JOptionPane.showMessageDialog(this.vista, "SOS el admin 😎");
                        this.vistaPersona = new VistaPersona();
                        this.vistaPersona.setVisible(true);
                    } else {
                        JOptionPane.showMessageDialog(this.vista, "USTED NO ES EL ADMINNNMM");
                    }
                } else {
                    JOptionPane.showMessageDialog(this.vista, "NO EXISTE EL USUARIOOOOOOOOOOOO");
                }
            } else {
                JOptionPane.showMessageDialog(this.vista, "Hay campos vacíos en la contraseña o usuario");
            }
        }
    }

}
