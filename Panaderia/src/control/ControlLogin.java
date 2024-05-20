package control;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import modelo.Persona;
import modelo.PersonaDao;
import vista.VistaLogin;
import vista.VistaPersona;
import javax.swing.JOptionPane;

public class ControlLogin implements ActionListener{
    private Persona unaPersona;
    private PersonaDao unaPersonaDao;
    private VistaLogin vistaLogin;

    public ControlLogin(/*Persona unaPersona, PersonaDao unaPersonaDao, VistaLogin vistaLogin*/) {
        this.unaPersona = new Persona();
        this.unaPersonaDao = new PersonaDao();
        
        //Se crea la vista
        this.vistaLogin = new VistaLogin();
        this.vistaLogin.setVisible(true);
        
        this.vistaLogin.jbtn_ingresar.addActionListener(this);
        
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        //Obtener datos de la vista
        String user= this.vistaLogin.jtf_user.getText().trim();
        String pwd= this.vistaLogin.jpf_pwd.getText();
        
        if(e.getSource() == this.vistaLogin.jbtn_ingresar){
            //validar que los campos no esten vacios
            if(!user.equals("") || !pwd.equals("")){
                //pasar los parámetros al metodo lgin
                this.unaPersona= this.unaPersonaDao.loginQuery(user, pwd);
                //verifiar si los datos son válidos
                if(this.unaPersona.getUser() != null){
                    if(this.unaPersona.getCedula() == 1){
                        ControlPersona vistaPersona= new ControlPersona();                        
                        this.vistaLogin.dispose();
                    }else{
                        JOptionPane.showMessageDialog(null,"Pailas No Es Admin X_X");
                    }
                }else{
                    JOptionPane.showMessageDialog(null,"Pailas No Existe X_X");
                }                    
            }else{
                JOptionPane.showMessageDialog(null,"Pailas Campos vacíos X_X");
            }
        }
    }
    
    
    
}
