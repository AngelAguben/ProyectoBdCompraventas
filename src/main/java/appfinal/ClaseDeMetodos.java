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
	// Variable necesaria para la modificaci�n de datos
	private static int numero;
	// Variable de datos necesaria para la petici�n de los datos
	private static Scanner teclado = new Scanner(System.in);

	// M�todo para insertar los datos de Aprendiz
	public static Aprendiz insertarDatosAprendiz() {
		// Se crea controlador de trabajador para su uso como fk
		ControladorTrabajador ct = new ControladorTrabajador();
		// Creamos un nuevo aprendiz para insertarle los datos necesarios para despu�s
		// pasarlo por los m�todos
		Aprendiz aprendiz = new Aprendiz();

		System.out.println("APRENDIZ");
		System.out.println("Enter para continuar");
		teclado.nextLine();
		System.out.println("Nombre");
		aprendiz.setNomapren(teclado.nextLine());
		System.out.println("N�mero tel�fono");
		aprendiz.setTlfnoapren(teclado.nextLine());
		System.out.println("Dni");
		aprendiz.setDniapren(teclado.nextLine());
		System.out.println("�A cargo de que trabajador est�? (Inserte su c�digo por favor)");
		aprendiz.setTrabajador(ct.findByPK(teclado.nextInt()));

		return aprendiz;
	}

	// M�todo para la moficaci�n de datos de Aprendiz
	public static void modificarAprendiz() {
		// Creamos un controlador y un numero y luego pediremos el codigo del objeto y
		// crearemos un objeto vacio
		ControladorAprendiz cAprendiz = new ControladorAprendiz();
		int numero = 0;
		System.out.println("Introduzca el c�digo a modificar: ");
		numero = teclado.nextInt();
		Aprendiz apren = new Aprendiz();

		// Y luego insertaremos los datos, le asignaremos el c�digo y pasaremos el
		// objeto a modificar
		apren = ClaseDeMetodos.insertarDatosAprendiz();
		apren.setCodaprendiz(numero);
		cAprendiz.modifyEntidad(apren);
	}

	// M�todo para insertar los datos de Trabajador
	public static Trabajador insertarDatosTrabajador() {
		// Creamos un nuevo trabajador para insertarle los datos necesarios para despu�s
		// pasarlo por los m�todos
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
		System.out.println("N�mero tel�fono");
		trabajador.setTlfnotrab(teclado.nextLine());

		return trabajador;
	}

	// M�todo para la moficaci�n de datos de Trabajador
	public static void modificarTrabajador() {
		// Creamos un controlador y un numero y luego pediremos el codigo del objeto y
		// crearemos un objeto vacio
		ControladorTrabajador cTrabajador = new ControladorTrabajador();
		System.out.println("Introduzca el c�digo a modificar: ");
		numero = teclado.nextInt();
		Trabajador trab = new Trabajador();

		// Y luego insertaremos los datos, le asignaremos el c�digo y pasaremos el
		// objeto a modificar
		trab = ClaseDeMetodos.insertarDatosTrabajador();
		trab.setCodtrabajador(numero);
		cTrabajador.modifyEntidad(trab);
	}

	// M�todo para insertar los datos de Cliente
	public static Cliente insertarDatosCliente() {
		// Creamos un nuevo Cliente para insertarle los datos necesarios para despu�s
		// pasarlo por los m�todos
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
		System.out.println("N�mero tel�fono");
		cliente.setTlfnoclien(teclado.nextLine());
		System.out.println("Correo Electronico");
		cliente.setCorreoclien(teclado.nextLine());
		System.out.println("Usuario");
		cliente.setUsuclien(teclado.nextLine());
		System.out.println("Contrase�a");
		cliente.setContraclien(teclado.nextLine());

		return cliente;
	}

	// M�todo para la moficaci�n de datos de Cliente
	public static void modificarCliente() {
		// Creamos un controlador y un numero y luego pediremos el codigo del objeto y
		// crearemos un objeto vacio
		ControladorCliente cCliente = new ControladorCliente();
		int numero = 0;
		System.out.println("Introduzca el c�digo a modificar: ");
		numero = teclado.nextInt();
		Cliente cli = new Cliente();

		// Y luego insertaremos los datos, le asignaremos el c�digo y pasaremos el
		// objeto a modificar
		cli = ClaseDeMetodos.insertarDatosCliente();
		cli.setCodcliente(numero);
		cCliente.modifyEntidad(cli);
	}

	// M�todo para insertar los datos de Coche
	public static Coche insertarDatosCoche() {
		// Creamos un nuevo coche para insertarle los datos necesarios para despu�s
		// pasarlo por los m�todos
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

		return coche;
	}

	// M�todo para la moficaci�n de datos de Coche
	public static void modificarCoche() {
		// Creamos un controlador y un numero y luego pediremos el codigo del objeto y
		// crearemos un objeto vacio
		ControladorCoche cCoche = new ControladorCoche();
		int numero = 0;
		System.out.println("Introduzca el c�digo a modificar: ");
		numero = teclado.nextInt();
		Coche coche = new Coche();

		// Y luego insertaremos los datos, le asignaremos el c�digo y pasaremos el
		// objeto a modificar
		coche = ClaseDeMetodos.insertarDatosCoche();
		coche.setCodcoche(numero);
		cCoche.modifyEntidad(coche);
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

		System.out.println("DEPORTIVO");
		System.out.println("Enter para continuar");
		teclado.nextLine();
		System.out.println("D�game el c�digo del coche");
		depor.setCoche(cc.findByPK(teclado.nextInt()));
		teclado.nextLine();

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
		return depor;
	}

	// M�todo para la moficaci�n de datos de Deportivo
	public static void modificarDeportivo() {
		// Creamos un controlador y un numero y luego pediremos el codigo del objeto y
		// crearemos un objeto vacio
		ControladorDeportivo cDeportivo = new ControladorDeportivo();
		int numero = 0;
		System.out.println("Introduzca el c�digo a modificar: ");
		numero = teclado.nextInt();
		Deportivo depor = new Deportivo();

		// Y luego insertaremos los datos, le asignaremos el c�digo y pasaremos el
		// objeto a modificar
		depor = ClaseDeMetodos.insertarDatosDeportivo();
		depor.setCoddepor(numero);
		cDeportivo.modifyEntidad(depor);
	}

	// M�todo para insertar los datos de Suv
	public static Suv insertarDatosSuv() {
		// Se crea controlador de Coche para su uso como fk
		ControladorCoche cc = new ControladorCoche();
		// Creamos un nuevo suv para insertarle los datos necesarios para despu�s
		// pasarlo por el los m�todos
		Suv suv = new Suv();

		int respu = 0;

		System.out.println("SUV");
		System.out.println("Enter para continuar");
		teclado.nextLine();
		System.out.println("D�game el c�digo del coche");
		suv.setCoche(cc.findByPK(teclado.nextInt()));
		teclado.nextLine();
		System.out.println("�C�antas plazas tiene el veh�culo?");
		// Repite mientras que el numero de plazas sea menor a 1 o mayor a 10
		do {
			respu = teclado.nextInt();
		} while (respu < 1 && respu > 10);
		suv.setPlazas(respu);
		return suv;
	}

	// M�todo para la moficaci�n de datos de Suv
	public static void modificarSuv() {
		// Creamos un controlador y un numero y luego pediremos el codigo del objeto y
		// crearemos un objeto vacio
		ControladorSuv cSuv = new ControladorSuv();
		int numero = 0;
		System.out.println("Introduzca el c�digo a modificar: ");
		numero = teclado.nextInt();
		Suv suv = new Suv();

		// Y luego insertaremos los datos, le asignaremos el c�digo y pasaremos el
		// objeto a modificar
		suv = ClaseDeMetodos.insertarDatosSuv();
		suv.setCodsuv(numero);
		cSuv.modifyEntidad(suv);
	}

	// M�todo para insertar los datos de ContratoCompra
	public static Contratocompra insertarDatosContratoCompra() {
		// Se crean controladores para su uso como fk
		ControladorTrabajador ct = new ControladorTrabajador();
		ControladorCoche cCoche = new ControladorCoche();
		ControladorCliente cCliente = new ControladorCliente();

		// Creamos 3 int para el a�o, mes y d�a para la peticion de fecha al usuario
		int anio = 0, mes = 0, dia = 0;

		// Creamos un nuevo Contratocompra para insertarle los datos necesarios para
		// despu�s
		// pasarlo por los m�todos
		Contratocompra contrato = new Contratocompra();

		System.out.println("CONTRATO DE COMPRA");
		System.out.println("Enter para continuar");
		teclado.nextLine();
		System.out.println("D�game el c�digo del cliente");
		contrato.setCliente(cCliente.findByPK(teclado.nextInt()));
		System.out.println("D�game el c�digo del coche");
		contrato.setCoche(cCoche.findByPK(teclado.nextInt()));
		System.out.println("D�game el c�digo del trabajador");
		contrato.setTrabajador(ct.findByPK(teclado.nextInt()));
		System.out.println("D�game el d�a");
		dia = teclado.nextInt();
		System.out.println("D�game el mes");
		mes = teclado.nextInt();
		System.out.println("D�game el a�o");
		anio = teclado.nextInt();
		contrato.setFechaventa(Date.valueOf(LocalDate.of(anio, mes, dia)));
		System.out.println("D�game el precio al que se vendi�");
		contrato.setPrecioventa(teclado.nextDouble());
		return contrato;
	}

	// M�todo para la moficaci�n de datos de ContratoCompra
	public static void modificarContratoCompra() {
		// Creamos un controlador y un numero y luego pediremos el codigo del objeto y
		// crearemos un objeto vacio
		ControladorContratoCompra cContratoCompra = new ControladorContratoCompra();
		int numero = 0;
		System.out.println("Introduzca el c�digo a modificar: ");
		numero = teclado.nextInt();
		Contratocompra contrato = new Contratocompra();

		// Y luego insertaremos los datos, le asignaremos el c�digo y pasaremos el
		// objeto a modificar
		contrato = ClaseDeMetodos.insertarDatosContratoCompra();
		contrato.setCodcontracompra(numero);
		cContratoCompra.modifyEntidad(contrato);
	}

}
