/**
 * Paquete que contiene herramientas que se utilizaran en el programa
 */
package utiles;



/**
 * Clase utilizada para la gestión de un menú. Se dedica a:
 * <ol>
 * <li>Mostrar las opciones del menú</li>
 * 
 * <li>Recoger y devolver las opciones de un menú</li>
 * </ol>
 * @author Roberto Carlos Flores Gomez
 * @version 1.0
 * 
 */
public class Menu {
	/**
	 * Titulo del menu
	 */
	String titulo = null;
	/**
	 * Opciones que tiene el menu
	 */
	String opciones[] = null;
	/**
	 * Número máximo de opciones
	 */
	int numOpciones = 2;
	/**
	 * Constructor del menu
	 * @param titulo titulo del menu
	 * @param opciones opciones que contiene el menu
	 */
	public Menu(String titulo, String[] opciones) {
		this.titulo = titulo;
		this.opciones = opciones;
		this.numOpciones = this.opciones.length;
	}
	/**
	 * Metodo gestionar que esta compuesto del metodo mostrar y el metodo recoger opcion
	 * @return devuelve una opcion valida
	 */
	public int gestionar() {
		mostrar();
		return recogerOpcion();
	}

	/**
	 * Muestra las opciones del menu
	 */
	private void mostrar() {
		int i = 1;
		System.out.println("**" + titulo);
		for (String elemento : opciones)
			System.out.println("(" + (i++) + ") " + elemento);
	}

	/**
	 * Metodo que recoge la opcion valida
	 * @return devuelve un número entero
	 */
	private int recogerOpcion() {
		int opcion;
		do {
			opcion = Teclado.leerEntero();
		} while (opcion < 1 || opcion > numOpciones);
		return opcion;
	}

}
