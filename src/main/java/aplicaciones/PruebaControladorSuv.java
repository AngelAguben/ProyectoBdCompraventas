package aplicaciones;

import controladores.ControladorCoche;
import controladores.ControladorSuv;
import entidades.Suv;

public class PruebaControladorSuv {

	public static void main(String[] args) {
		// Se crea un nuevo controlador para poder trabajar con el
		ControladorSuv cs = new ControladorSuv();
		// También se crea controlador de Coche para su uso como fk
		ControladorCoche cc = new ControladorCoche();

		// Se imprimen todos los registros que haya en la tabla Suv
		imprimirEntidades(cs);

		// Creación de un Suv
		Suv s1 = new Suv();
		s1.setCoche(cc.findByPK(2));
		s1.setPlazas(5);

		// Y luego se crea y se vuelve a imprimir la lista
		cs.createSuv(s1);
		imprimirEntidades(cs);

	}

	// Método para imprimir las entidades de la base de datos
	private static void imprimirEntidades(ControladorSuv cs) {
		System.out.println("ENTIDADES EN LA BASE DE DATOS ---------------");
		// Imprimiremos la lista de Suvs
		for (Suv suv : cs.findAll()) {
			System.out.println(suv);
		}
	}

}
