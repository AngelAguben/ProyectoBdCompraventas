package appfinal;

import java.util.Scanner;

import controladores.ControladorAprendiz;
import controladores.ControladorCliente;
import controladores.ControladorCoche;
import controladores.ControladorTrabajador;
import entidades.Aprendiz;
import entidades.Cliente;
import entidades.Coche;
import entidades.Trabajador;

public class ClaseCrear {
	private static Scanner teclado = new Scanner(System.in);

	// Método para crear un aprendiz entero
	public static void crearAprendizEntero() {
		ControladorAprendiz ca = new ControladorAprendiz();
		Aprendiz a1 = new Aprendiz();
		teclado.nextLine();
		System.out.println("APRENDIZ");
		System.out.println("Nombre");
		a1.setNomapren(teclado.nextLine());
		System.out.println("Número teléfono");
		a1.setTlfnoapren(teclado.nextLine());
		System.out.println("Dni");
		a1.setDniapren(teclado.nextLine());
		// Y luego se crea
		ca.createAprendiz(a1);
	}

	// Método para crear un aprendiz entero
	public static void crearTrabajadorEntero() {
		ControladorTrabajador ct = new ControladorTrabajador();
		Trabajador t1 = new Trabajador();
		teclado.nextLine();
		System.out.println("Trabajador");
		System.out.println("Nombre");
		t1.setNomtrab(teclado.nextLine());
		System.out.println("Dni");
		t1.setDnitrab(teclado.nextLine());
		System.out.println("Horario");
		t1.setHorario(teclado.nextLine());
		System.out.println("Número teléfono");
		t1.setTlfnotrab(teclado.nextLine());

		// Y luego se crea
		ct.createTrabajador(t1);
	}

	// Método para crear un cliente entero
	public static void crearClienteEntero() {
		ControladorCliente cc = new ControladorCliente();
		Cliente c1 = new Cliente();
		teclado.nextLine();
		System.out.println("CLIENTE");
		System.out.println("Nombre");
		c1.setNomclien(teclado.nextLine());
		System.out.println("Apellido 1");
		c1.setApe1clien(teclado.nextLine());
		System.out.println("Apellido 2");
		c1.setApe2clien(teclado.nextLine());
		System.out.println("Número teléfono");
		c1.setTlfnoclien(teclado.nextLine());
		System.out.println("Correo Electronico");
		c1.setCorreoclien(teclado.nextLine());
		System.out.println("Usuario");
		c1.setUsuclien(teclado.nextLine());
		System.out.println("Contraseña");
		c1.setContraclien(teclado.nextLine());

		// Y luego se crea
		cc.createCliente(c1);
	}

	public static void crearCocheEntero() {
		ControladorCoche cc = new ControladorCoche();

		Coche c1 = new Coche();
		teclado.nextLine();
		System.out.println("COCHE");
		System.out.println("Matricula");
		c1.setMatricula(teclado.nextLine());
		System.out.println("Cambio (0 - Manual | 1 - Automático)");
		c1.setCambio(teclado.nextBoolean());
		System.out.println("Color");
		c1.setColor(teclado.nextLine());
		System.out.println("Marca");
		c1.setMarca(teclado.nextLine());
		System.out.println("Modelo");
		c1.setModelo(teclado.nextLine());
		System.out.println("Cv");
		c1.setCv(teclado.nextLine());
		System.out.println("Precio");
		c1.setPrecio(teclado.nextDouble());
		// Y luego se crea
		cc.createCoche(c1);
	}

}
