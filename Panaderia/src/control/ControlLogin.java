package control;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import modelo.Persona;
import modelo.PersonaDao;
import vista.VistaLogin;
import vista.VistaPersona;

public class ControlLogin implements ActionListener{
    //atributos
    private Persona unaPersona;
    private PersonaDao unaPersonaDao;
    private VistaLogin vistaLogin;
    
    private String user;
    private String password;
    
    //constructor
    public ControlLogin(){
        this.unaPersona= new Persona();
        this.unaPersonaDao= new PersonaDao();
        
        this.vistaLogin= new VistaLogin();
        this.vistaLogin.setVisible(true);
        
        this.vistaLogin.jbtn_ingresar.addActionListener(this);
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        this.user= this.vistaLogin.jtf_user.getText().trim();
        this.password= this.vistaLogin.jpf_pwd.getText().trim();
        
        if(e.getSource() == this.vistaLogin.jbtn_ingresar){
            //validar que los campos no esten vacios
            if(!this.user.equals("") || !this.password.equals("")){
                //se pasan los parámetro al metodo loginQuery
                this.unaPersona= this.unaPersonaDao.loginQuery(this.user, this.password);
                
                //verificar si los datos son válidos
                if(this.unaPersona.getUser() != null){
                    if(this.unaPersona.getCedula() == 1){
                        JOptionPane.showMessageDialog(null, "Hola Don Administrador");
                        VistaPersona vistaPersona= new VistaPersona();
                        vistaPersona.setVisible(true);
                        this.vistaLogin.setVisible(false);
                    }else{
                        JOptionPane.showMessageDialog(null, "Pailas no es administrador X_X");
                    }
                }else{
                    JOptionPane.showMessageDialog(null, "Pailas el usuario no existe!!! X_X");
                }
            }else{
                JOptionPane.showMessageDialog(null, "Hay campos Vacíos X_X");
            }
        }
    }
}
   
