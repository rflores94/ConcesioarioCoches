/**
 * 
 */
package concesionarioCoches;

import java.io.IOException;

import utiles.Menu;
import utiles.Teclado;

/**
 * TestConcesionario
 * @author Roberto Carlos Flores Gomez
 * @version 1.0
 *
 */
public class TestConcesionario {
	static Menu menu = new Menu("Concesionario de coches", new String[] {
			"Alta Coche", "Baja Coche", "Mostrar Coche",
			"Mostrar concesionario", "Contar coches del concesionario",
			"Mostrar coches de un color", "Salir", "Fichero" });
	/**
	 * 
	 */
	static Menu menuFichero = new Menu("Menu de ficheros", new String[] {
			"Nuevo", "Abrir", "Guardar", "Guardar como..." });
	/**
	 * Menu que contiene los colores
	 */
	private static Menu menuColores = new Menu("Colores de los coches",
			Color.generarOpcionesMenu());
	/**
	 * Menu que contiene los modelos
	 */
	private static Menu menuModelos = new Menu("Modelos de los coches",
			Modelo.generarOpcionesMenu());
	/**
	 * Lista donde guardaremos los coches
	 */
	static Concesionario concesionario = new Concesionario();

	public static void main(String[] args) {

		do {
			switch (menu.gestionar()) {
			case 1:// "Añadir Coche
				annadirCoche();
				break;
			case 2:// Eliminar Coche
				eliminarCoche();
				break;
			case 3:// Obtener Coche
				getCoche();
				break;
			case 4:// Mostrar lista
				System.out.println(concesionario);
				break;
			case 5:// Contar coches
				System.out.println("Número de coches en el concesionario: "
						+ concesionario.size());
				break;
			case 6:// Mostrar coches de un color
				System.out.println(concesionario.getCochesColor(pedirColor()));
				break;

			case 8:
				realizarOpcion(menuFichero.gestionar());
				break;

			default:// Salir
				System.out.println("Aaaaaaaaaaaaaaaaaaaaadios");
				return;
			}
		} while (true);
	}

	/**
	 * 
	 * @param opcion
	 *            opcion del menú
	 */
	private static void realizarOpcion(int opcion) {
		char caracter;
		switch (opcion) {
		case 1:
			try {
				if (!concesionario.isModificado()) {
					concesionario = new Concesionario();
					System.out.println(Fichero.nuevo());
				} else {
					do {
						caracter = Character
								.toUpperCase(Teclado
										.leerCaracter("No has guardado. Desea guardar?"));
					} while (!(caracter == 'S' || caracter == 'N'));
					if (caracter == 'S') {
						Fichero.guardar(concesionario);
						concesionario = new Concesionario();
						System.out.println(Fichero.nuevo());
					} else {
						concesionario = new Concesionario();
						System.out.println(Fichero.nuevo());
					}
				}

			} catch (IOException e3) {
				System.out.println(e3.getMessage());
			}
			break;

		case 2:
			try {
				if (!concesionario.isModificado()) {
					concesionario = (Concesionario) Fichero
							.abrir(concesionario);
				} else {
					do {
						caracter = Character
								.toUpperCase(Teclado
										.leerCaracter("No has guardado. Desea guardar?"));
					} while (!(caracter == 'S' || caracter == 'N'));
					if (caracter == 'S') {
						Fichero.guardar(concesionario);
						concesionario = (Concesionario) Fichero
								.abrir(concesionario);
					} else {
						concesionario = (Concesionario) Fichero
								.abrir(concesionario);
					}
				}
			} catch (ClassNotFoundException | IOException e2) {
				System.out.println(e2.getMessage());
			}

			break;
		case 3:
			try {
				Fichero.guardar(concesionario);
				System.out.println("Archivo guardado");
			} catch (IOException e1) {
				System.out.println(e1.getMessage());
			}
			break;
		case 4:
			try {
				Fichero.guardarComo(concesionario);
				System.out.println("Archivo guardado");
			} catch (IOException e) {
				System.out.println(e.getMessage());
			}
			break;
		}
	}

	/**
	 * Metodo que devuelve un coche introduciendo la matricula correspondiente
	 */
	private static void getCoche() {
		Coche coche;
		try {
			coche = concesionario.get(Teclado
					.leerCadena("Introduce la matrícula"));
			System.out.println(coche);
		} catch (MatriculaNoValidaException e) {
			System.out.println(e.getMessage());
		} catch (CocheNoExistenteException e) {
			System.out.println(e.getMessage());
		}

	}

	/**
	 * Metodo que elimina un coche de la lista
	 */
	private static void eliminarCoche() {
		try {
			concesionario
					.eliminar(Teclado.leerCadena("Introduce la matrícula"));
			System.out.println("Coche eliminado");
		} catch (MatriculaNoValidaException | CocheNoExistenteException e) {
			System.out.println(e.getMessage() + " No se ha podido eliminar");
		}
	}

	/**
	 * Metodo que añade un coche a la lista
	 */
	private static void annadirCoche() {
		try {
			concesionario.annadir(Teclado.leerCadena("Introduce la matrícula"),
					pedirColor(), pedirModelo());
			System.out.println("Coche añadido con éxito");

		} catch (MatriculaNoValidaException e) {
			System.out.println(e.getMessage());
		} catch (ColorNoValidoException e) {
			System.out.println(e.getMessage());
		} catch (ModeloNoValidoException e) {
			System.out.println(e.getMessage());
		} catch (CocheYaExistenteException e) {
			System.out.println(e.getMessage());
		}
	}

	/**
	 * Metodo que solicita un modelo de coche
	 * 
	 * @return devuelve un modelo de coche
	 */
	private static Modelo pedirModelo() {
		int opcion = menuModelos.gestionar();
		Modelo[] arrModelos = Modelo.getValues();
		if (opcion == arrModelos.length + 1)
			return null;
		return arrModelos[opcion - 1];
	}

	/**
	 * Metodo que solicita un color de coche
	 * 
	 * @return devuelve un color de coche
	 */
	private static Color pedirColor() {
		int opcion = menuColores.gestionar();
		Color[] arrColores = Color.getValues();
		if (opcion == arrColores.length + 1)
			return null;
		return arrColores[opcion - 1];
	}
}
