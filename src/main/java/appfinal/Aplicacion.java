package appfinal;

import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

import javax.persistence.NoResultException;

import controladores.ControladorAprendiz;
import controladores.ControladorCliente;
import controladores.ControladorCoche;
import controladores.ControladorContratoCompra;
import controladores.ControladorDeportivo;
import controladores.ControladorSuv;
import controladores.ControladorTrabajador;
import entidades.Coche;

public class Aplicacion {

	private static Scanner teclado = new Scanner(System.in);

	public static void main(String[] args) {

		// Metemos todos los controladores para poder trabajar con ellos en un
		ControladorAprendiz cAprendiz = new ControladorAprendiz();
		ControladorTrabajador cTrabajador = new ControladorTrabajador();
		ControladorCliente cCliente = new ControladorCliente();
		ControladorCoche cCoche = new ControladorCoche();
		ControladorDeportivo cDeportivo = new ControladorDeportivo();
		ControladorSuv cSuv = new ControladorSuv();
		ControladorContratoCompra cContratoCompra = new ControladorContratoCompra();

		// Creamos varios int para poder trabajar con ellos al meterle el número y poder
		// utilizarlo en los switch
		int opcionMenu = 0, opCrear = 0, opBorrar = 0, opBuscar = 0, opMod = 0;
		//
		boolean error = false;
		boolean fin = false;
		// Lista del catálogo de vehículos para poder ver cuál comprar
		List<Coche> catalogoCoches = cCoche.findAll();

		// El do general para controlar si error es true o false y si es true finá
		// el programa ya que tendrá un error
		do {
			// try para controlar si se inserta un dato indebido a lo que se pide
			try {
				// try para controlar el fallo de que no encuentre algo en la base de datos
				try {
					// El do para el menú principal
					do {
						error = false;
						System.out.println("----- COMPRAVENTAS AGUBEN -----");
						System.out.println("Lista de vehículos: ");
						imprimirListaCoches(catalogoCoches);
						System.out.println("¿Qué desea hacer? \n" + "1. Crear \n" + "2. Borrar \n" + "3. Buscar \n"
								+ "4. Modificar \n" + "5. Salir");
						opcionMenu = teclado.nextInt();
						// Valores válidos entre 1-6, si no se repetirá el bucle
					} while (opcionMenu < 1 || opcionMenu > 5);

					// Switch de las opciones del Menu
					switch (opcionMenu) {
					case 1: // CREAR
						do {
							do {
								System.out.println(
										"¿Qué desea registar? \n" + "1. Crear Aprendiz \n" + "2. Crear Trabajador \n"
												+ "3. Crear Cliente \n" + "4. Crear Coche \n" + "5. Crear Deportivo \n"
												+ "6. Crear SUV \n" + "7. Crear ContratoCompra \n" + "8. Salir");
								opCrear = teclado.nextInt();
								// Valores válidos entre 1-8, si no se repetirá el bucle
							} while (opCrear < 1 || opCrear > 8);

							// Switch de las opciones de Crear
							switch (opCrear) {
							// CASOS
							case 1: // Aprendiz
								cAprendiz.createAprendiz(ClaseCrear.insertarDatosAprendiz());
								break;
							case 2: // Trabajador
								cTrabajador.createTrabajador(ClaseCrear.insertarDatosTrabajador());
								break;
							case 3: // Cliente
								cCliente.createCliente(ClaseCrear.insertarDatosCliente());
								break;
							case 4: // Coche
								cCoche.createCoche(ClaseCrear.insertarDatosCoche());
								break;
							case 5: // Deportivo
								cDeportivo.createDeportivo(ClaseCrear.insertarDatosDeportivo());
								break;
							case 6: // Suv
								cSuv.createSuv(ClaseCrear.insertarDatosSuv());
								break;
							case 7: // ContratoCompra
//								cContratoCompra.createContratoCompra(ClaseCrear.insertarDatosContratoCompra());
								break;
							case 8: // SALIR
								System.out.println("Saliendo del menu");
								break;
							}
						} while (opCrear != 8);
						break;

					case 2: // BORRAR
						do {
							do {
								System.out.println("¿Qué desea borrar? \n" + "1. Borrar Aprendiz \n"
										+ "2. Borrar Trabajador \n" + "3. Borrar Cliente \n" + "4. Borrar Coche \n"
										+ "5. Borrar Deportivo \n" + "6. Borrar Suv \n" + "7. Borrar ContratoCompra \n"
										+ "8. Salir");
								opBorrar = teclado.nextInt();
								// Valores válidos entre 1-8, si no se repetirá el bucle
							} while (opBorrar < 1 || opBorrar > 8);

							System.out.println("--- BORRAR ---");
							System.out.println("Introduzca el código a borrar: ");
							// Switch de las opciones de Borrar
							switch (opBorrar) {
							// CASOS
							case 1: // Aprendiz
								cAprendiz.borrarAprendiz(cAprendiz.findByPK(teclado.nextInt()));
								break;
							case 2: // Trabajador
								cTrabajador.borrarTrabajador(cTrabajador.findByPK(teclado.nextInt()));
								break;
							case 3: // Cliente
								cCliente.borrarCliente(cCliente.findByPK(teclado.nextInt()));
								break;
							case 4: // Coche
								cCoche.borrarCoche(cCoche.findByPK(teclado.nextInt()));
								break;
							case 5: // Deportivo
								cDeportivo.borrarDeportivo(cDeportivo.findByPK(teclado.nextInt()));
								break;
							case 6: // Suv
								cSuv.borrarSuv(cSuv.findByPK(teclado.nextInt()));
								break;
							case 7: // ContratoCompra
//								cContratoCompra.createContratoCompra(ClaseCrear.insertarDatosContratoCompra());
								break;
							case 8: // SALIR
								System.out.println("Saliendo del menu");
								break;
							}
						} while (opBorrar != 8);
						break;

					case 3: // BUSCAR
						do {
							do {
								System.out.println("¿Qué desea buscar? \n" + "1. Buscar Aprendiz \n"
										+ "2. Buscar Trabajador \n" + "3. Buscar Cliente \n" + "4. Buscar Coche \n"
										+ "5. Buscar Deportivo \n" + "6. Buscar Suv \n" + "7. Buscar ContratoCompra \n"
										+ "8. Salir");
								opBuscar = teclado.nextInt();
								// Valores válidos entre 1-8, si no se repetirá el bucle
							} while (opBuscar < 1 || opBuscar > 8);

							System.out.println("--- BUSCAR ---");
							System.out.println("Introduzca el código a buscar: ");
							// Switch de las opciones de Buscar
							switch (opBuscar) {
							// CASOS
							case 1: // Aprendiz
								cAprendiz.findByPK(teclado.nextInt());
								break;
							case 2: // Trabajador
								cTrabajador.findByPK(teclado.nextInt());
								break;
							case 3: // Cliente
								cCliente.findByPK(teclado.nextInt());
								break;
							case 4: // Coche
								cCoche.findByPK(teclado.nextInt());
								break;
							case 5: // Deportivo
								cDeportivo.findByPK(teclado.nextInt());
								break;
							case 6: // Suv
								cSuv.findByPK(teclado.nextInt());
								break;
							case 7: // ContratoCompra
//								cContratoCompra.createContratoCompra(ClaseCrear.insertarDatosContratoCompra());
								break;
							case 8: // SALIR
								System.out.println("Saliendo del menu");
								break;
							}
						} while (opBuscar != 8);
						break;

					case 4: // MODIFICAR
						do {
							do {
								System.out.println("¿Qué desea modificar? \n" + "1. Modificar Aprendiz \n"
										+ "2. Modificar Trabajador \n" + "3. Modificar Cliente \n"
										+ "4. Modificar Coche \n" + "5. Modificar Deportivo \n" + "6. Modificar Suv \n"
										+ "7. Modificar ContratoCompra \n" + "8. Salir");
								opMod = teclado.nextInt();
								// Valores válidos entre 1-8, si no se repetirá el bucle
							} while (opMod < 1 || opMod > 8);

							System.out.println("--- MODIFICAR ---");
							System.out.println("Introduzca el código a modificar: ");
							// Switch de las opciones de Modificar
							switch (opMod) {
							// CASOS
							case 1: // Aprendiz
								cAprendiz.modifyAprendiz(ClaseCrear.insertarDatosAprendiz());
								break;
							case 2: // Trabajador
								cTrabajador.modifyTrabajador(ClaseCrear.insertarDatosTrabajador());
								break;
							case 3: // Cliente
								cCliente.modifyCliente(ClaseCrear.insertarDatosCliente());
								break;
							case 4: // Coche
								cCoche.modifyCoche(ClaseCrear.insertarDatosCoche());
								break;
							case 5: // Deportivo
								cDeportivo.modifyDeportivo(ClaseCrear.insertarDatosDeportivo());
								break;
							case 6: // Suv
								cSuv.modifySuv(ClaseCrear.insertarDatosSuv());
								break;
							case 7: // ContratoCompra
//							cContratoCompra.createContratoCompra(ClaseCrear.insertarDatosContratoCompra());
								break;
							case 8: // SALIR
								System.out.println("Saliendo del menu");
								break;
							}
						} while (opMod != 8);
						break;

					case 5: // SALIR
						System.out.println("Saliendo del programa...");
						fin = true;
						break;
					}

					// Control del error de que la base de datos no arroje ningún resultado
				} catch (NoResultException nre) {
					System.out.println("VALOR NO ENCONTRADO EN LA BASE DE DATOS");
					// La variable error la ponemos a true
					error = true;
					// Y limpiamos el búffer
					teclado.nextLine();
				}
				// Control del error de que espera un valor como un int y le insertamos un
				// String
			} catch (InputMismatchException ime) {
				System.out.println("VALOR IRRECONOCIBLE");
				// La variable error la ponemos a true
				error = true;
				// Y limpiamos el búffer
				teclado.nextLine();
			}

			// Mientras error sea true y fin sea false se seguirá repitiendo el programa
			// ya que si hay un error de una excepción anterior se pondrá a true la
			// variable error y si fin es false significará que no ha seleccionado
			// la opción de salir
		} while (error == true || opcionMenu != 5);
//		fin = true;
		// Muestro por pantalla para saber cuando termina el programa
		System.out.println("----- LA EJECUCIÓN DEL PROGRAMA HA TERMINADO -----");
	}

	private static void imprimirListaCoches(List<Coche> listaVehiculos) {
		for (Coche vehiculo : listaVehiculos) {
			System.out.println("\tMatricula: " + vehiculo.getMatricula() + "\tMarca : " + vehiculo.getMarca()
					+ "\tModelo: " + vehiculo.getModelo() + "\tPrecio: " + vehiculo.getPrecio());
		}
	}
}
