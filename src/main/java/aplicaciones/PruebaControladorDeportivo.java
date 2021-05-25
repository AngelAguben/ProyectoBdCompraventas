package aplicaciones;

import controladores.ControladorCoche;
import controladores.ControladorDeportivo;
import entidades.Deportivo;

public class PruebaControladorDeportivo {

	public static void main(String[] args) {
		// Se crea un nuevo controlador para poder trabajar con el
		ControladorDeportivo cd = new ControladorDeportivo();
		// También se crea controlador de Coche para su uso como fk
		ControladorCoche cc = new ControladorCoche();

		// Se imprimen todos los registros que haya en la tabla Deportivo
		imprimirEntidades(cd);

		// Creación de un Deportivo
		Deportivo d1 = new Deportivo();
		d1.setCoche(cc.findByPK(1));
		d1.setPackaero(false);
		d1.setTurbo(true);

		// Y luego se crea y se vuelve a imprimir la lista
		cd.createEntidad(d1);
		imprimirEntidades(cd);

	}

	// Método para imprimir las entidades de la base de datos
	private static void imprimirEntidades(ControladorDeportivo cd) {
		System.out.println("ENTIDADES EN LA BASE DE DATOS ---------------");
		// Imprimiremos la lista de Deportivos
		for (Deportivo deportivo : cd.findAll()) {
			System.out.println(deportivo);
		}

	}

}
