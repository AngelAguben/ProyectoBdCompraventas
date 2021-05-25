package appfinal;

import java.sql.Date;
import java.time.LocalDate;
import java.util.Scanner;

import controladores.ControladorAprendiz;
import controladores.ControladorCliente;
import controladores.ControladorCoche;
import controladores.ControladorContratoCompra;
import controladores.ControladorDeportivo;
import controladores.ControladorSuv;
import controladores.ControladorTrabajador;
import entidades.Aprendiz;
import entidades.Cliente;
import entidades.Coche;
import entidades.Contratocompra;
import entidades.Deportivo;
import entidades.Suv;
import entidades.Trabajador;

public class ClaseDeMetodos {
	// Variable necesaria para la modificación de datos
	private static int numero;
	// Variable de datos necesaria para la petición de los datos
	private static Scanner teclado = new Scanner(System.in);

	// Método para insertar los datos de Aprendiz
	public static Aprendiz insertarDatosAprendiz() {
		// Se crea controlador de trabajador para su uso como fk
		ControladorTrabajador ct = new ControladorTrabajador();
		// Creamos un nuevo aprendiz para insertarle los datos necesarios para después
		// pasarlo por los métodos
		Aprendiz aprendiz = new Aprendiz();

		System.out.println("APRENDIZ");
		System.out.println("Enter para continuar");
		teclado.nextLine();
		System.out.println("Nombre");
		aprendiz.setNomapren(teclado.nextLine());
		System.out.println("Número teléfono");
		aprendiz.setTlfnoapren(teclado.nextLine());
		System.out.println("Dni");
		aprendiz.setDniapren(teclado.nextLine());
		System.out.println("¿A cargo de que trabajador está? (Inserte su código por favor)");
		aprendiz.setTrabajador(ct.findByPK(teclado.nextInt()));

		return aprendiz;
	}

	// Método para la moficación de datos de Aprendiz
	public static void modificarAprendiz() {
		// Creamos un controlador y un numero y luego pediremos el codigo del objeto y
		// crearemos un objeto vacio
		ControladorAprendiz cAprendiz = new ControladorAprendiz();
		int numero = 0;
		System.out.println("Introduzca el código a modificar: ");
		numero = teclado.nextInt();
		Aprendiz apren = new Aprendiz();

		// Y luego insertaremos los datos, le asignaremos el código y pasaremos el
		// objeto a modificar
		apren = ClaseDeMetodos.insertarDatosAprendiz();
		apren.setCodaprendiz(numero);
		cAprendiz.modifyEntidad(apren);
	}

	// Método para insertar los datos de Trabajador
	public static Trabajador insertarDatosTrabajador() {
		// Creamos un nuevo trabajador para insertarle los datos necesarios para después
		// pasarlo por los métodos
		Trabajador trabajador = new Trabajador();

		System.out.println("TRABAJADOR");
		System.out.println("Enter para continuar");
		teclado.nextLine();
		System.out.println("Nombre");
		trabajador.setNomtrab(teclado.nextLine());
		System.out.println("Dni");
		trabajador.setDnitrab(teclado.nextLine());
		System.out.println("Horario");
		trabajador.setHorario(teclado.nextLine());
		System.out.println("Número teléfono");
		trabajador.setTlfnotrab(teclado.nextLine());

		return trabajador;
	}

	// Método para la moficación de datos de Trabajador
	public static void modificarTrabajador() {
		// Creamos un controlador y un numero y luego pediremos el codigo del objeto y
		// crearemos un objeto vacio
		ControladorTrabajador cTrabajador = new ControladorTrabajador();
		System.out.println("Introduzca el código a modificar: ");
		numero = teclado.nextInt();
		Trabajador trab = new Trabajador();

		// Y luego insertaremos los datos, le asignaremos el código y pasaremos el
		// objeto a modificar
		trab = ClaseDeMetodos.insertarDatosTrabajador();
		trab.setCodtrabajador(numero);
		cTrabajador.modifyEntidad(trab);
	}

	// Método para insertar los datos de Cliente
	public static Cliente insertarDatosCliente() {
		// Creamos un nuevo Cliente para insertarle los datos necesarios para después
		// pasarlo por los métodos
		Cliente cliente = new Cliente();

		System.out.println("CLIENTE");
		System.out.println("Enter para continuar");
		teclado.nextLine();
		System.out.println("Nombre");
		cliente.setNomclien(teclado.nextLine());
		System.out.println("Apellido 1");
		cliente.setApe1clien(teclado.nextLine());
		System.out.println("Apellido 2");
		cliente.setApe2clien(teclado.nextLine());
		System.out.println("Número teléfono");
		cliente.setTlfnoclien(teclado.nextLine());
		System.out.println("Correo Electronico");
		cliente.setCorreoclien(teclado.nextLine());
		System.out.println("Usuario");
		cliente.setUsuclien(teclado.nextLine());
		System.out.println("Contraseña");
		cliente.setContraclien(teclado.nextLine());

		return cliente;
	}

	// Método para la moficación de datos de Cliente
	public static void modificarCliente() {
		// Creamos un controlador y un numero y luego pediremos el codigo del objeto y
		// crearemos un objeto vacio
		ControladorCliente cCliente = new ControladorCliente();
		int numero = 0;
		System.out.println("Introduzca el código a modificar: ");
		numero = teclado.nextInt();
		Cliente cli = new Cliente();

		// Y luego insertaremos los datos, le asignaremos el código y pasaremos el
		// objeto a modificar
		cli = ClaseDeMetodos.insertarDatosCliente();
		cli.setCodcliente(numero);
		cCliente.modifyEntidad(cli);
	}

	// Método para insertar los datos de Coche
	public static Coche insertarDatosCoche() {
		// Creamos un nuevo coche para insertarle los datos necesarios para después
		// pasarlo por los métodos
		Coche coche = new Coche();
		// He creado un String para guardar la respuesta del usuario
		String textoRespu = "";

		System.out.println("COCHE");
		System.out.println("Enter para continuar");
		teclado.nextLine();
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
				// Será true
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

		return coche;
	}

	// Método para la moficación de datos de Coche
	public static void modificarCoche() {
		// Creamos un controlador y un numero y luego pediremos el codigo del objeto y
		// crearemos un objeto vacio
		ControladorCoche cCoche = new ControladorCoche();
		int numero = 0;
		System.out.println("Introduzca el código a modificar: ");
		numero = teclado.nextInt();
		Coche coche = new Coche();

		// Y luego insertaremos los datos, le asignaremos el código y pasaremos el
		// objeto a modificar
		coche = ClaseDeMetodos.insertarDatosCoche();
		coche.setCodcoche(numero);
		cCoche.modifyEntidad(coche);
	}

	// Método para insertar los datos de Deportivo
	public static Deportivo insertarDatosDeportivo() {
		// Se crea un nuevo controlador para poder trabajar con el
		ControladorDeportivo cd = new ControladorDeportivo();
		// Se crea controlador de Coche para su uso como fk
		ControladorCoche cc = new ControladorCoche();
		// Creamos un nuevo deportivo para insertarle los datos necesarios para después
		// pasarlo por el los métodos
		Deportivo depor = new Deportivo();
		// He creado un String para guardar la respuesta del usuario
		String textoRespu = "";

		System.out.println("DEPORTIVO");
		System.out.println("Enter para continuar");
		teclado.nextLine();
		System.out.println("Dígame el código del coche");
		depor.setCoche(cc.findByPK(teclado.nextInt()));
		teclado.nextLine();

		do {
			System.out.println("¿El vehículo monta pack aero? (si/no)");
			textoRespu = teclado.nextLine();
			// Si es si...
			if (textoRespu.equalsIgnoreCase("si")) {
				// Será true
				depor.setPackaero(true);
				// Si no...
			} else if (textoRespu.equalsIgnoreCase("no")) {
				// Será false
				depor.setPackaero(false);
			}

		} while (!textoRespu.equalsIgnoreCase("no") && !textoRespu.equalsIgnoreCase("si"));

		// Repite hasta que sea si o no la respuesta
		do {
			System.out.println("¿El vehículo monta turbo? (si/no)");
			textoRespu = teclado.nextLine();
			// Si es si...
			if (textoRespu.equalsIgnoreCase("si")) {
				// Será true
				depor.setTurbo(true);
				// Si no...
			} else if (textoRespu.equalsIgnoreCase("no")) {
				// Será false
				depor.setTurbo(false);
			}

		} while (!textoRespu.equalsIgnoreCase("no") && !textoRespu.equalsIgnoreCase("si"));
		return depor;
	}

	// Método para la moficación de datos de Deportivo
	public static void modificarDeportivo() {
		// Creamos un controlador y un numero y luego pediremos el codigo del objeto y
		// crearemos un objeto vacio
		ControladorDeportivo cDeportivo = new ControladorDeportivo();
		int numero = 0;
		System.out.println("Introduzca el código a modificar: ");
		numero = teclado.nextInt();
		Deportivo depor = new Deportivo();

		// Y luego insertaremos los datos, le asignaremos el código y pasaremos el
		// objeto a modificar
		depor = ClaseDeMetodos.insertarDatosDeportivo();
		depor.setCoddepor(numero);
		cDeportivo.modifyEntidad(depor);
	}

	// Método para insertar los datos de Suv
	public static Suv insertarDatosSuv() {
		// Se crea controlador de Coche para su uso como fk
		ControladorCoche cc = new ControladorCoche();
		// Creamos un nuevo suv para insertarle los datos necesarios para después
		// pasarlo por el los métodos
		Suv suv = new Suv();

		int respu = 0;

		System.out.println("SUV");
		System.out.println("Enter para continuar");
		teclado.nextLine();
		System.out.println("Dígame el código del coche");
		suv.setCoche(cc.findByPK(teclado.nextInt()));
		teclado.nextLine();
		System.out.println("¿Cúantas plazas tiene el vehículo?");
		// Repite mientras que el numero de plazas sea menor a 1 o mayor a 10
		do {
			respu = teclado.nextInt();
		} while (respu < 1 && respu > 10);
		suv.setPlazas(respu);
		return suv;
	}

	// Método para la moficación de datos de Suv
	public static void modificarSuv() {
		// Creamos un controlador y un numero y luego pediremos el codigo del objeto y
		// crearemos un objeto vacio
		ControladorSuv cSuv = new ControladorSuv();
		int numero = 0;
		System.out.println("Introduzca el código a modificar: ");
		numero = teclado.nextInt();
		Suv suv = new Suv();

		// Y luego insertaremos los datos, le asignaremos el código y pasaremos el
		// objeto a modificar
		suv = ClaseDeMetodos.insertarDatosSuv();
		suv.setCodsuv(numero);
		cSuv.modifyEntidad(suv);
	}

	// Método para insertar los datos de ContratoCompra
	public static Contratocompra insertarDatosContratoCompra() {
		// Se crean controladores para su uso como fk
		ControladorTrabajador ct = new ControladorTrabajador();
		ControladorCoche cCoche = new ControladorCoche();
		ControladorCliente cCliente = new ControladorCliente();

		// Creamos 3 int para el año, mes y día para la peticion de fecha al usuario
		int anio = 0, mes = 0, dia = 0;

		// Creamos un nuevo Contratocompra para insertarle los datos necesarios para
		// después
		// pasarlo por los métodos
		Contratocompra contrato = new Contratocompra();

		System.out.println("CONTRATO DE COMPRA");
		System.out.println("Enter para continuar");
		teclado.nextLine();
		System.out.println("Dígame el código del cliente");
		contrato.setCliente(cCliente.findByPK(teclado.nextInt()));
		System.out.println("Dígame el código del coche");
		contrato.setCoche(cCoche.findByPK(teclado.nextInt()));
		System.out.println("Dígame el código del trabajador");
		contrato.setTrabajador(ct.findByPK(teclado.nextInt()));
		System.out.println("Dígame el día");
		dia = teclado.nextInt();
		System.out.println("Dígame el mes");
		mes = teclado.nextInt();
		System.out.println("Dígame el año");
		anio = teclado.nextInt();
		contrato.setFechaventa(Date.valueOf(LocalDate.of(anio, mes, dia)));
		System.out.println("Dígame el precio al que se vendió");
		contrato.setPrecioventa(teclado.nextDouble());
		return contrato;
	}

	// Método para la moficación de datos de ContratoCompra
	public static void modificarContratoCompra() {
		// Creamos un controlador y un numero y luego pediremos el codigo del objeto y
		// crearemos un objeto vacio
		ControladorContratoCompra cContratoCompra = new ControladorContratoCompra();
		int numero = 0;
		System.out.println("Introduzca el código a modificar: ");
		numero = teclado.nextInt();
		Contratocompra contrato = new Contratocompra();

		// Y luego insertaremos los datos, le asignaremos el código y pasaremos el
		// objeto a modificar
		contrato = ClaseDeMetodos.insertarDatosContratoCompra();
		contrato.setCodcontracompra(numero);
		cContratoCompra.modifyEntidad(contrato);
	}

}
