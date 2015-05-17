/**
 * Paquete que contiene los archivos del programa
 */
package concesionarioCoches;

//import pgn.examenMarzo.utiles.Menu;

/**
 * Enum que contiene una lista de colores y los metodos necesarios para mostrarlos y elegir uno de ellos
 * 
 * @author Roberto Carlos Flores Gomez
 * @version 1.0
 * 
 */
public enum Color {
	/**
	 * Color plata
	 */
	PLATA,
	/**
	 * Color rojo
	 */
	ROJO, 
	/**
	 * Color Azul
	 */
	AZUL;
	/**
	 * Array que contiene el número de colores que tiene la enum
	 */
	private static final Color[] VALUES = Color.values();
	/**
	 * Genera las opciones para un menu de colores
	 * @return devuelve un array de cadenas con todas las opciones del menu
	 */
	public static String[] generarOpcionesMenu() {
		String[] opcionesMenu = new String[getValues().length + 1];
		int i = 0;
		for (Color color : getValues()) {
			opcionesMenu[i++] = color.name();
		}
		opcionesMenu[i] = "Salir";
		return opcionesMenu;
	}
	/**
	 * Metodo que devuelve un array de colores
	 * @return devuelve el campo values
	 */
	public static Color[] getValues() {
		return VALUES;
	}

}
