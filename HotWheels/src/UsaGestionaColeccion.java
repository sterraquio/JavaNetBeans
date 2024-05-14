import javax.swing.JOptionPane;

public class UsaGestionaColeccion{

	public static void main(String [] args){
		
		GestionaColeccion miColeccion= new GestionaColeccion();

		String menu=	"Bienvenido a tu Colección\n"+
				"1: Agregar un Auto a la colección\n"+
				"2: Borrar un Auto de la colección\n"+
				"3: Listar los Autos de la colección\n"+
				"4: Buscar un Auto dentro la colección\n"+
				"5: Para salir del programa\n";
		int opcion=0;

		do{
			opcion= Integer.parseInt(JOptionPane.showInputDialog(null,menu, "Menú de Opciones",1));

			switch(opcion){
				case 1: miColeccion.agregarAuto();
					break;
				case 2: miColeccion.borrarAuto();
					break;
				case 3: miColeccion.listarAutos();
					break;
				case 4: miColeccion.buscarAuto();
					break;
				case 5: JOptionPane.showMessageDialog(null,"Gracias!!!!\nPor usar nuestro programa","Resultado =)",1);
					break;
				default: 
					JOptionPane.showMessageDialog(null,"Esa opción no es válida","Resultado",2);					 
			}
			
		}while(!(opcion==5));		
	}
}