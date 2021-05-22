package appfinal;

import java.util.InputMismatchException;
import java.util.Scanner;

import javax.persistence.NoResultException;

import controladores.ControladorAprendiz;
import controladores.ControladorCliente;
import controladores.ControladorCoche;
import controladores.ControladorDeportivo;
import controladores.ControladorSuv;
import controladores.ControladorTrabajador;
import entidades.Aprendiz;
import entidades.Cliente;
import entidades.Coche;
import entidades.Deportivo;
import entidades.Suv;
import entidades.Trabajador;

public class ClaseCrear {
	private static Scanner teclado = new Scanner(System.in);

	// M�todo para insertar los datos de Aprendiz
	public static Aprendiz insertarDatosAprendiz() {
		// Se crea controlador de trabajador para su uso como fk
		ControladorTrabajador ct = new ControladorTrabajador();
		// Creamos un nuevo aprendiz para insertarle los datos necesarios para despu�s
		// pasarlo por los m�todos
		Aprendiz aprendiz = new Aprendiz();
		try {
			System.out.println("APRENDIZ");
			System.out.println("Nombre");
			aprendiz.setNomapren(teclado.nextLine());
			System.out.println("N�mero tel�fono");
			aprendiz.setTlfnoapren(teclado.nextLine());
			System.out.println("Dni");
			aprendiz.setDniapren(teclado.nextLine());
			System.out.println("�A cargo de que trabajador est�? (Inserte su c�digo por favor)");
			aprendiz.setTrabajador(ct.findByPK(teclado.nextInt()));
		} catch (InputMismatchException ime) {
			System.out.println("El dato no es el que se pide");
		}
		return aprendiz;
	}
	
	// M�todo para insertar los datos de Trabajador
	public static Trabajador insertarDatosTrabajador() {
		Trabajador trabajador = new Trabajador();
		try {
			System.out.println("Trabajador");
			System.out.println("Nombre");
			trabajador.setNomtrab(teclado.nextLine());
			System.out.println("Dni");
			trabajador.setDnitrab(teclado.nextLine());
			System.out.println("Horario");
			trabajador.setHorario(teclado.nextLine());
			System.out.println("N�mero tel�fono");
			trabajador.setTlfnotrab(teclado.nextLine());

		} catch (InputMismatchException ime) {
			System.out.println("El dato no es el que se pide");
		}
		return trabajador;
	}
	
	// M�todo para insertar los datos de Cliente
	public static Cliente insertarDatosCliente() {
		Cliente cliente = new Cliente();
		try {
			System.out.println("CLIENTE");
			System.out.println("Nombre");
			cliente.setNomclien(teclado.nextLine());
			System.out.println("Apellido 1");
			cliente.setApe1clien(teclado.nextLine());
			System.out.println("Apellido 2");
			cliente.setApe2clien(teclado.nextLine());
			System.out.println("N�mero tel�fono");
			cliente.setTlfnoclien(teclado.nextLine());
			System.out.println("Correo Electronico");
			cliente.setCorreoclien(teclado.nextLine());
			System.out.println("Usuario");
			cliente.setUsuclien(teclado.nextLine());
			System.out.println("Contrase�a");
			cliente.setContraclien(teclado.nextLine());

		} catch (InputMismatchException ime) {
			System.out.println("El dato no es el que se pide");
		}
		return cliente;
	}

	// M�todo para insertar los datos de Coche
	public static Coche insertarDatosCoche() {
		Coche coche = new Coche();
		// He creado un String para guardar la respuesta del usuario
		String textoRespu = "";

		try {
			System.out.println("COCHE");
			System.out.println("Matricula");
			coche.setMatricula(teclado.nextLine());
			do {
				System.out.println("Cambio (Manual/Automatico)");
				textoRespu = teclado.nextLine();
				// Si es manual
				if (textoRespu.equalsIgnoreCase("manual")) {
					coche.setCambio(false);
					// Si no...
				} else if (textoRespu.equalsIgnoreCase("automatico")) {
					// Ser� true
					coche.setCambio(true);
				}
			} while (!textoRespu.equalsIgnoreCase("manual") && !textoRespu.equalsIgnoreCase("automatico"));

			System.out.println("Color");
			coche.setColor(teclado.nextLine());
			System.out.println("Marca");
			coche.setMarca(teclado.nextLine());
			System.out.println("Modelo");
			coche.setModelo(teclado.nextLine());
			System.out.println("Cv");
			coche.setCv(teclado.nextLine());
			System.out.println("Precio");
			coche.setPrecio(teclado.nextDouble());

		} catch (InputMismatchException ime) {
			System.out.println("El dato no es el que se pide");
		}
		return coche;
	}

	// M�todo para insertar los datos de Deportivo
	public static Deportivo insertarDatosDeportivo() {
		// Se crea un nuevo controlador para poder trabajar con el
		ControladorDeportivo cd = new ControladorDeportivo();
		// Se crea controlador de Coche para su uso como fk
		ControladorCoche cc = new ControladorCoche();
		// Creamos un nuevo deportivo para insertarle los datos necesarios para despu�s
		// pasarlo por el los m�todos
		Deportivo depor = new Deportivo();
		// He creado un String para guardar la respuesta del usuario
		String textoRespu = "";

		try {
			try {
				System.out.println("DEPORTIVO");
				System.out.println("D�game el c�digo del coche");
				depor.setCoche(cc.findByPK(teclado.nextInt()));

				do {
					System.out.println("�El veh�culo monta pack aero? (si/no)");
					textoRespu = teclado.nextLine();
					// Si es si...
					if (textoRespu.equalsIgnoreCase("si")) {
						// Ser� true
						depor.setPackaero(true);
						// Si no...
					} else if (textoRespu.equalsIgnoreCase("no")) {
						// Ser� false
						depor.setPackaero(false);
					}

				} while (!textoRespu.equalsIgnoreCase("no") && !textoRespu.equalsIgnoreCase("si"));

				// Repite hasta que sea si o no la respuesta
				do {
					System.out.println("�El veh�culo monta turbo? (si/no)");
					textoRespu = teclado.nextLine();
					// Si es si...
					if (textoRespu.equalsIgnoreCase("si")) {
						// Ser� true
						depor.setTurbo(true);
						// Si no...
					} else if (textoRespu.equalsIgnoreCase("no")) {
						// Ser� false
						depor.setTurbo(false);
					}

				} while (!textoRespu.equalsIgnoreCase("no") && !textoRespu.equalsIgnoreCase("si"));
			} catch (NoResultException nre) {
				System.out.println("Dicho valor no se encuentra en la base de datos");
			}
		} catch (InputMismatchException ime) {
			System.out.println("El dato no es el que se pide");
		}
		return depor;
	}

	// M�todo para insertar los datos de Suv
	public static Suv insertarDatosSuv() {
		ControladorSuv cd = new ControladorSuv();
		// Se crea controlador de Coche para su uso como fk
		ControladorCoche cc = new ControladorCoche();
		// Creamos un nuevo suv para insertarle los datos necesarios para despu�s
		// pasarlo por el los m�todos
		Suv suv = new Suv();

		int respu = 0;

		try {
			try {
				System.out.println("SUV");
				System.out.println("D�game el c�digo del coche");
				suv.setCoche(cc.findByPK(teclado.nextInt()));
				System.out.println("�C�antas plazas tiene el veh�culo?");
				// Repite mientras que el numero de plazas sea menor a 1 o mayor a 10
				do {
					respu = teclado.nextInt();
				} while (respu < 1 && respu > 10);
				suv.setPlazas(respu);
			} catch (NoResultException nre) {
				System.out.println("Dicho valor no se encuentra en la base de datos");
			}
		} catch (InputMismatchException ime) {
			System.out.println("El dato no es el que se pide");
		}
		return suv;
	}

}
