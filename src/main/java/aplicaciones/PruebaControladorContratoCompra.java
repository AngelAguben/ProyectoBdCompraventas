package aplicaciones;

import java.sql.Date;
import java.text.ParseException;
import java.time.LocalDate;
import java.time.Month;

import controladores.ControladorCliente;
import controladores.ControladorCoche;
import controladores.ControladorContratoCompra;
import controladores.ControladorTrabajador;
import entidades.Contratocompra;

public class PruebaControladorContratoCompra {

	public static void main(String[] args) throws ParseException {
		// Se crea un nuevo controlador para poder trabajar con el
		ControladorContratoCompra ccc = new ControladorContratoCompra();
		// También se crean controladores para su uso como fk
		ControladorTrabajador ct = new ControladorTrabajador();
		ControladorCoche cCoche = new ControladorCoche();
		ControladorCliente cCliente = new ControladorCliente();

		// Se imprimen todos los registros que haya en la tabla Contratocompra
		imprimirEntidades(ccc);

		// Creación de un Contratocompra
		Contratocompra contrato = new Contratocompra();
		contrato.setCliente(cCliente.findByPK(2));
		contrato.setCoche(cCoche.findByPK(2));
		contrato.setTrabajador(ct.findByPK(1));
		contrato.setFechaventa((Date.valueOf(LocalDate.of(2021, Month.MARCH, 5))));
		contrato.setPrecioventa(5000);

		// Y luego se crea y se vuelve a imprimir la lista
		ccc.createContratocompra(contrato);
		imprimirEntidades(ccc);

	}

	// Método para imprimir las entidades de la base de datos
	private static void imprimirEntidades(ControladorContratoCompra ccc) {
		System.out.println("--------------- ENTIDADES EN LA BASE DE DATOS ---------------");
		// Imprimiremos la lista de Contratocompraes
		for (Contratocompra contrato : ccc.findAll()) {
			System.out.println(contrato);
		}
	}

}
