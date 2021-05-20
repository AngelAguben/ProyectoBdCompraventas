package appfinal;

import java.util.Scanner;

import controladores.ControladorAprendiz;
import controladores.ControladorCliente;
import entidades.Aprendiz;
import entidades.Cliente;

public class Aplicacion {

	private static Scanner teclado = new Scanner(System.in);
	public static void main(String[] args) {
		
		int opcionMenu = 0, opCrear = 0, opBorrar = 0, opBuscar = 0, opMod = 0;
		do {
		System.out.println("¿Qué desea hacer? \n"
				+ "1. Crear \n"
				+ "2. Borrar \n"
				+ "3. Buscar \n"
				+ "4. Modioficar \n"
				+ "5. Salir");
		opcionMenu = teclado.nextInt();
		} while(opcionMenu < 1 || opcionMenu > 5);

		// Switch de las opciones del Menu
		switch (opcionMenu) {
		case 1: // REGISTAR
			do {
			System.out.println("¿Qué desea registar? \n"
					+ "1. Crear Aprendiz \n"
					+ "2. Crear Trabajador \n"
					+ "3. Crear Cliente \n"
					+ "4. Crear Coche \n"
					+ "5. Salir");
			opCrear = teclado.nextInt();
			} while(opCrear < 1 || opCrear > 5);
			break;
			
		case 2: // BORRAR
			do {
			System.out.println("¿Qué desea borrar? \n"
					+ "1. Borrar Aprendiz \n"
					+ "2. Borrar Trabajador \n"
					+ "3. Borrar Cliente \n"
					+ "4. Borrar Coche \n"
					+ "5. Salir");
			opBorrar = teclado.nextInt();
			} while(opBorrar < 1 || opBorrar > 5);
			break;
			
		case 3: // BUSCAR
			do {
			System.out.println("¿Qué desea buscar? \n"
					+ "1. Buscar Aprendiz \n"
					+ "2. Buscar Trabajador \n"
					+ "3. Buscar Cliente \n"
					+ "4. Buscar Coche \n"
					+ "5. Salir");
			opBuscar = teclado.nextInt();
			} while(opBuscar < 1 || opBuscar > 5);
			break;
			
		case 4: // MODIFICAR
			do {
			System.out.println("¿Qué desea modificar? \n"
					+ "1. Modificar Aprendiz \n"
					+ "2. Modificar Trabajador \n"
					+ "3. Modificar Cliente \n"
					+ "4. Modificar Coche \n"
					+ "5. Salir");
			opMod = teclado.nextInt();
			} while(opMod < 1 || opMod > 5);
			break;
			
		case 5: // SALIR
			System.out.println("Saliendo del programa...");
			break;
		}
		
		// Switch de las opciones de Crear
		switch (opCrear) {
		
		case 1: // Aprendiz
			ClaseCrear.crearAprendizEntero();
			break;
		case 2: // Trabajador
			ClaseCrear.crearTrabajadorEntero();
			break;
		case 3: // Cliente
			ClaseCrear.crearClienteEntero();
			break;
		case 4: // Coche
			ClaseCrear.crearCocheEntero();
			break;
		case 5: // SALIR
			System.out.println("Saliendo del programa");
			break;
		}
		
		// Switch de las opciones de Borrar
			switch (opBorrar) {
			
			case 1: // Aprendiz
				
				break;
			case 2: // Trabajador
				
				break;
			case 3: // Cliente

				break;
			case 4: // Coche
				
				break;
			case 5: // SALIR
				System.out.println("Saliendo del programa");
				break;
			}
			
			// Switch de las opciones de Buscar
			switch (opBuscar) {
			
			case 1: // Aprendiz
				
				break;
			case 2: // Trabajador
				
				break;
			case 3: // Cliente

				break;
			case 4: // Coche
				
				break;
			case 5: // SALIR
				System.out.println("Saliendo del programa");
				break;
			}
			
			// Switch de las opciones de Modificar 
			switch (opMod) {
			
			case 1: // Aprendiz
				
				break;
			case 2: // Trabajador
				
				break;
			case 3: // Cliente

				break;
			case 4: // Coche
				
				break;
			case 5: // SALIR
				System.out.println("Saliendo del programa");
				break;
			}
	}
}
