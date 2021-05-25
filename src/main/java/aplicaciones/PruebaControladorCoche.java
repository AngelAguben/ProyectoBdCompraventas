package aplicaciones;

import controladores.ControladorCoche;
import entidades.Coche;

public class PruebaControladorCoche {

	public static void main(String[] args) {
		// Se crea un nuevo controlador para poder trabajar con el
		ControladorCoche cc = new ControladorCoche();

		// Se imprimen todos los registros que haya en la tabla coche
		imprimirEntidades(cc);

		// Creación de un coche
		Coche c1 = new Coche();
		c1.setMatricula("2876JHT");
		c1.setCambio(true);
		c1.setColor("Amarillo");
		c1.setMarca("Seat");
		c1.setModelo("Leon");
		c1.setCv("150");
		c1.setPrecio(3000);

		// Y luego se crea y se vuelve a imprimir la lista
		cc.createEntidad(c1);
		imprimirEntidades(cc);

	}

	// Método para imprimir las entidades de la base de datos
	private static void imprimirEntidades(ControladorCoche cc) {
		System.out.println("ENTIDADES EN LA BASE DE DATOS ---------------");
		// Imprimiremos la lista de coches
		for (Coche coche : cc.findAll()) {
			System.out.println(coche);
		}
	}

}