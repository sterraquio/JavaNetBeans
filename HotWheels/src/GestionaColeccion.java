import javax.swing.JOptionPane;

public class GestionaColeccion{

		//Atributos
		Coleccion miColeccion= new Coleccion();
		
		//Constructor		
		public GestionaColeccion(){}

		//Métodos
		/*****************************************************************************************/
		public void agregarAuto(){

			Auto miAuto= new Auto();

			int anhoSerie;
			String marca;
			String color;
			int cantTotalSerie;
			int numeroSerie;

			anhoSerie= Integer.parseInt(JOptionPane.showInputDialog(null,"Ingrese el año de la serie","Ingreso de atributos",1));
			marca= JOptionPane.showInputDialog(null, "Ingrese la marca del auto","Ingreso de atributos",1);
			color= JOptionPane.showInputDialog(null, "Ingrese el color del auto","Ingreso de atributos",1);
			cantTotalSerie= Integer.parseInt(JOptionPane.showInputDialog(null, "Ingrese la cantidad de autos de la serie","Ingreso de atributos",1));
			numeroSerie=  Integer.parseInt(JOptionPane.showInputDialog(null, "Ingrese el número del auto dentro de la serie","Ingreso de atributos",1));
			
			miAuto.setAnhoSerie(anhoSerie);
			miAuto.setMarca(marca);
			miAuto.setColor(color);
			miAuto.setCantTotalSerie(cantTotalSerie);
			miAuto.setnumeroSerie(numeroSerie);

			miColeccion.agregarAuto(miAuto);
		}
		/*****************************************************************************************/
		public void borrarAuto(){
			int anhoSer;
			int numeroSer;
			int resultado=0;

			anhoSer= Integer.parseInt(JOptionPane.showInputDialog(null,"Ingrese el año de la serie","Ingreso de valores",1));
			numeroSer=  Integer.parseInt(JOptionPane.showInputDialog(null, "Ingrese el número del auto dentro de la serie","Ingreso e valores",1));
			
			resultado= miColeccion.borrarAuto(anhoSer,numeroSer);
			if(resultado==1){
				JOptionPane.showMessageDialog(null, "Auto Borrado con Éxito","Resultado =)",1);
			}else{
				JOptionPane.showMessageDialog(null, "Auto no Encontrado","Resultado =)",1);
			}
		}
		/*****************************************************************************************/
		public void listarAutos(){

			JOptionPane.showMessageDialog(null, miColeccion.listarColeccion(),"Resultado =)",1);
		}
		/*****************************************************************************************/
		public void buscarAuto(){
			int anhoSer;
			int numeroSer;

			anhoSer= Integer.parseInt(JOptionPane.showInputDialog(null,"Ingrese el año de la serie","Ingreso de valores",1));
			numeroSer=  Integer.parseInt(JOptionPane.showInputDialog(null, "Ingrese el número del auto dentro de la serie","Ingreso e valores",1));
			
			JOptionPane.showMessageDialog(null, miColeccion.buscarAuto(anhoSer,numeroSer),"Resultado =)",1);
		}
		
}