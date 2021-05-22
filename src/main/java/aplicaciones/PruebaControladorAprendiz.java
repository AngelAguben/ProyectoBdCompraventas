package aplicaciones;

import controladores.ControladorAprendiz;
import controladores.ControladorTrabajador;
import entidades.Aprendiz;

public class PruebaControladorAprendiz {

	public static void main(String[] args) {
		// Se crea un nuevo controlador para poder trabajar con el
		ControladorAprendiz ca = new ControladorAprendiz();
		// También se crea controlador de trabajador para su uso como fk
		ControladorTrabajador ct = new ControladorTrabajador();

		// Se imprimen todos los registros que haya en la tabla Aprendiz
		imprimirEntidades(ca);

		// Creación de un Aprendiz, sin alquileres ni tarjeta
		Aprendiz a1 = new Aprendiz();
		a1.setDniapren("09338844Y");
		a1.setNomapren("Kiko");
		a1.setTlfnoapren("687958495");
		a1.setTrabajador(ct.findByPK(1));

		// Y luego se crea y se vuelve a imprimir la lista
		ca.createAprendiz(a1);
		imprimirEntidades(ca);

	}

	// Método para imprimir las entidades de la base de datos
	private static void imprimirEntidades(ControladorAprendiz ca) {
		System.out.println("ENTIDADES EN LA BASE DE DATOS ---------------");
		// Imprimiremos la lista de aprendices
		for (Aprendiz aprendiz : ca.findAll()) {
			System.out.println(aprendiz);
		}
	}
}