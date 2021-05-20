package aplicaciones;

import controladores.ControladorTrabajador;
import entidades.Trabajador;

public class PruebaControladorTrabajador {

	public static void main(String[] args) {
		ControladorTrabajador ct = new ControladorTrabajador();

		// Se imprimen todos los registros que haya en la tabla trabajador
		imprimirEntidades(ct);

		// Creación de un trabajador
		Trabajador t1 = new Trabajador();
		t1.setNomtrab("Paco Jones");
		t1.setDnitrab("84756567U");
		t1.setHorario("De lunes a viernes de 7 a 3");
		t1.setTlfnotrab("695847384");

		// Y luego se crea y se vuelve a imprimir la lista
		ct.createTrabajador(t1);
		imprimirEntidades(ct);

	}

	// Método para imprimir las entidades de la base de datos
	private static void imprimirEntidades(ControladorTrabajador ct) {
		System.out.println("ENTIDADES EN LA BASE DE DATOS ---------------");
		// Imprimiremos la lista de trabajadores
		for (Trabajador t : ct.findAll()) {
			System.out.println(t);
		}
	}
}
