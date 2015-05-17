/**
 * 
 */
package concesionarioCoches;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.regex.Pattern;

import utiles.Teclado;

/**
 * Clase fichero que contiene todos los métodos necesarios para operar con ficheros
 * @author Roberto Carlos Flores Gomez
 * @version 1.0
 *
 */
public class Fichero implements Serializable {
	/**
	 * Campo que me añadio en el warming
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * Patrón que controla la extensión del archivo 
	 */
	private static Pattern patron = Pattern.compile("^((\\w)+(\\.obj))$");
	/**
	 * Fichero 
	 */
	private static File archivo = new File("Sin_titulo.obj");

	
	/**
	 * @param archivo the archivo to set
	 */
	private static void setArchivo(String fichero) {
		Fichero.archivo = new File(fichero);
	}

	/**
	 * @return the archivo
	 */
	public static File getArchivo() {
		return archivo;
	}
/**
 * 
 * @param concesionario
 * @return
 * @throws IOException
 */
	public static void guardarComo(Concesionario concesionario) throws IOException {
		String fichero = Teclado.leerCadena("nombre del archivo: ");
		fichero = comprobarArchivo(fichero);
		try (ObjectOutputStream out = new ObjectOutputStream(
				new FileOutputStream(fichero))) {
			setArchivo((comprobarArchivo(fichero)));
			out.writeObject(concesionario);
			concesionario.setModificado(false);
			//return "Archivo guardado ";
		}
	}
/**
 * 
 * @param fichero2
 * @return
 */
	private static String comprobarArchivo(String fichero2) {
		if (patron.matcher(fichero2).matches())
			return fichero2;
		else
			fichero2 += ".obj";
		return fichero2;
	}
/**
 * 
 * @param concesionario
 * @return
 * @throws IOException
 */
	public static void guardar(Concesionario concesionario)
			throws IOException {
		if (archivo == null || archivo.getPath().equalsIgnoreCase("Sin_Titulo.obj")) {
			concesionario.setModificado(false);
			 guardarComo(concesionario);
		} else {
			try (ObjectOutputStream out = new ObjectOutputStream(
					new FileOutputStream(archivo))) {
				out.writeObject(concesionario);
				concesionario.setModificado(false);
				
			}
		}

	}
/**
 * 
 * @return
 * @throws IOException
 */
	public static String nuevo()
			throws IOException {
			setArchivo((comprobarArchivo("Sin_Titulo.obj")));
			return "Nombre del archivo por defecto " + archivo;

	}
/**
 * 
 * @param concesionario
 * @return
 * @throws ClassNotFoundException
 * @throws IOException
 */
	public static Object abrir(Concesionario concesionario)
			throws ClassNotFoundException, IOException {
			String fichero = Teclado.leerCadena("Nombre del archivo: ");
			fichero = comprobarArchivo(fichero);
			Object aux;
			try (ObjectInputStream in = new ObjectInputStream(
					new FileInputStream(fichero))) {
				setArchivo((comprobarArchivo(fichero)));
				aux = in.readObject();
				return aux;
			}
	}
	
}
