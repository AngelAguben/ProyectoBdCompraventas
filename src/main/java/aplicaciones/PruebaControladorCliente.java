package aplicaciones;

import controladores.ControladorCliente;
import entidades.Cliente;

public class PruebaControladorCliente {

	public static void main(String[] args) {
		// Se crea un nuevo controlador para poder trabajar con el
		ControladorCliente cc = new ControladorCliente();

		// Se imprimen todos los registros que haya en la tabla cliente
		imprimirEntidades(cc);

		// Creación de un cliente
		Cliente c1 = new Cliente();
		c1.setNomclien("Manuel");
		c1.setApe1clien("Tellez");
		c1.setApe2clien("Jimenez");
		c1.setTlfnoclien("675645333");
		c1.setCorreoclien("manuu22@gmail.com");
		c1.setUsuclien("manuu22");
		c1.setContraclien("manuu22");

		// Y luego se crea y se vuelve a imprimir la lista
		cc.createEntidad(c1);
		imprimirEntidades(cc);

	}

	// Método para imprimir las entidades de la base de datos
	private static void imprimirEntidades(ControladorCliente cc) {
		System.out.println("ENTIDADES EN LA BASE DE DATOS ---------------");
		// Imprimiremos la lista de clientes
		for (Cliente cliente : cc.findAll()) {
			System.out.println(cliente);
		}
	}

}