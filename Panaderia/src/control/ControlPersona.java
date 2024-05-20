package control;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import javax.swing.JOptionPane;
import modelo.Persona;
import modelo.PersonaDao;
import vista.VistaLogin;
import vista.VistaPersona;

public class ControlPersona implements ActionListener{
    
    private Persona unaPersona;
    private PersonaDao unaPersonaDao;
    
    private VistaPersona vistaPersona;
    
    public ControlPersona() {
        this.unaPersona = new Persona();
        this.unaPersonaDao = new PersonaDao();
        
        //Se crea la vista y se hace visible
        this.vistaPersona = new VistaPersona();
        this.vistaPersona.setVisible(true);
        
        //Se agrega el listener al botón Guardar
        this.vistaPersona.jbtn_guardar.addActionListener(this);      
        //Se agrega el listener al botón Consultar
        this.vistaPersona.jbtn_consultar.addActionListener(this);     
        //Se agrega el listener al botón Modificar
        this.vistaPersona.jbtn_modificar.addActionListener(this);     
        //Se agrega el listener al botón Eliminar
        this.vistaPersona.jbtn_eliminar.addActionListener(this);   
        //Se agrega el listener al botón Listar Todos
        this.vistaPersona.jbtn_listar.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {        
        //Boton Guardar
        if(e.getSource() == this.vistaPersona.jbtn_guardar){
            //se obtienen los datos de la lista        
            //se valida que los datos numéricos no vengan vacios o con datos diferentes a números por conversión de tipos o parseo
            try{
                this.unaPersona.setCedula(Integer.parseInt(this.vistaPersona.jtf_cedula.getText()));
                this.unaPersona.setEdad(Integer.parseInt(this.vistaPersona.jtf_edad.getText()));
                                
                this.unaPersona.setNombres(this.vistaPersona.jtf_nombres.getText());        
                this.unaPersona.setUser(this.vistaPersona.jtf_user.getText());
                this.unaPersona.setPassword(this.vistaPersona.jtf_pwd.getText());
                
                //se valida que los campos tipo texto no esten vacíos
                if(!this.unaPersona.getNombres().equals("") && !this.unaPersona.getUser().equals("") && !this.unaPersona.getPassword().equals("")){
                    //se ejecuta la inserción en la base de datos
                    if(this.unaPersonaDao.insertarPersona(unaPersona)){
                        JOptionPane.showMessageDialog(this.vistaPersona, "Datos ingresados con éxito!!!");
                        limpiarCampos();
                    }else{
                        JOptionPane.showMessageDialog(this.vistaPersona, "Datos ingresados con éxito!!!");
                    }
                }else{
                    JOptionPane.showMessageDialog(this.vistaPersona,"Todos los campos son obligatorios\nY ninguno debe ir en blanco");
                }                
            }catch(NumberFormatException ex){
                JOptionPane.showMessageDialog(this.vistaPersona,"Los campos Cédula y Edad son obligatorios\nY deben ser en formato numérico");
            }
        }
        
        //Boton Consultar
        if(e.getSource() == this.vistaPersona.jbtn_consultar){
            
            try{
                this.unaPersona= this.unaPersonaDao.consultarQuery(Integer.parseInt(this.vistaPersona.jtf_cedula.getText()));                
                
                this.vistaPersona.jtf_nombres.setText(this.unaPersona.getNombres());
                this.vistaPersona.jtf_edad.setText(this.unaPersona.getEdad()+"");
                this.vistaPersona.jtf_user.setText(this.unaPersona.getUser());
                this.vistaPersona.jtf_pwd.setText(this.unaPersona.getPassword());
            }catch(NumberFormatException ex){
                JOptionPane.showMessageDialog(this.vistaPersona,"El campo Cédula es obligatorio\nY deben ser en formato numérico");
            }
        }
        
        //Boton Modificar
        if(e.getSource() == this.vistaPersona.jbtn_modificar){
            //se obtienen los datos de la lista        
            //se valida que los datos numéricos no vengan vacios o con datos diferentes a números por conversión de tipos o parseo
            try{
                this.unaPersona.setCedula(Integer.parseInt(this.vistaPersona.jtf_cedula.getText()));
                this.unaPersona.setEdad(Integer.parseInt(this.vistaPersona.jtf_edad.getText()));
                                
                this.unaPersona.setNombres(this.vistaPersona.jtf_nombres.getText());        
                this.unaPersona.setUser(this.vistaPersona.jtf_user.getText());
                this.unaPersona.setPassword(this.vistaPersona.jtf_pwd.getText());
                
                //se valida que los campos tipo texto no esten vacíos
                if(!this.unaPersona.getNombres().equals("") && !this.unaPersona.getUser().equals("")){
                    //se ejecuta la inserción en la base de datos
                    if(this.unaPersonaDao.actualizarPersona(unaPersona)){
                        JOptionPane.showMessageDialog(this.vistaPersona, "Datos actualizados con éxito!!!");
                        limpiarCampos();
                    }else{
                        JOptionPane.showMessageDialog(this.vistaPersona, "Datos no actualizados!!!");
                    }
                }else{
                    JOptionPane.showMessageDialog(this.vistaPersona,"Todos los campos son obligatorios\nY ninguno debe ir en blanco");
                }                
            }catch(NumberFormatException ex){
                JOptionPane.showMessageDialog(this.vistaPersona,"Los campos Cédula y Edad son obligatorios\nY deben ser en formato numérico");
            }
            
        }
        
        //Boton Eliminar 
        if(e.getSource() == this.vistaPersona.jbtn_eliminar){
            
            try{
                int ced= Integer.parseInt(this.vistaPersona.jtf_cedula.getText());
            
                if(this.unaPersonaDao.eliminarPersona(ced)){
                    JOptionPane.showMessageDialog(this.vistaPersona, "Datos Eliminados!!!");
                    limpiarCampos();
                }else{
                    JOptionPane.showMessageDialog(this.vistaPersona, "Datos No Eliminados!!!");
                }
                
            }catch(NumberFormatException ex){
                JOptionPane.showMessageDialog(this.vistaPersona,"El campo Cédula es obligatorio\nY deben ser en formato numérico");
            }            
        } 
        
        //Boton Listar Todos
        if(e.getSource() == this.vistaPersona.jbtn_listar){
            
            Persona personaTemp= new Persona();
            List<Persona> miListaPersonas;
            
            String listado= "CÉDULA--NOMBRES--EDAD\n";
            
            miListaPersonas= this.unaPersonaDao.listarPesonas();
            
            for(int i=0; i<miListaPersonas.size();i++){
                personaTemp= miListaPersonas.get(i);
                listado += personaTemp.getCedula()+"--"+personaTemp.getNombres()+"--"+personaTemp.getEdad()+"\n";
            }
            
            JOptionPane.showMessageDialog(this.vistaPersona,listado);
            
        }
    }
    
    public void limpiarCampos(){
        this.vistaPersona.jtf_cedula.setText("");
        this.vistaPersona.jtf_edad.setText("");
        this.vistaPersona.jtf_nombres.setText("");
        this.vistaPersona.jtf_user.setText("");
        this.vistaPersona.jtf_pwd.setText("");
    }
    
}
