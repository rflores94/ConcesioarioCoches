/**
 * 
 */
package concesionarioCoches;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;


public class Fichero implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public static File fichero = new File("Sin-titulo.obj");


	public static void guardarComo(File file, Concesionario concesionario)
	
			throws IOException {
		file = annadirExtension(file);
		try (ObjectOutputStream objectOutputStream = new ObjectOutputStream(
				new BufferedOutputStream(new FileOutputStream(file, false)))) {
			objectOutputStream.writeObject(concesionario);
		}
	}
	
	public static void guardar(File file, Concesionario concesionario) throws IOException{
		if(!file.exists()){
			try (ObjectOutputStream objectOutputStream = new ObjectOutputStream(
					new BufferedOutputStream(new FileOutputStream(file, false)))) {
				objectOutputStream.writeObject(concesionario);
			}
		}else{
			try (ObjectOutputStream objectOutputStream = new ObjectOutputStream(
					new BufferedOutputStream(new FileOutputStream(file, false)))) {
				objectOutputStream.writeObject(concesionario);
			}
		}
	}

	public static Object leer(File archivo) throws FileNotFoundException,
			IOException, ClassNotFoundException {
		archivo = annadirExtension(archivo);
		try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(
				archivo))) {
			return (Object) ois.readObject();
		}
	}

	public static File annadirExtension(File archivo) {
		String extension = archivo.getPath();
		if (!extension.endsWith(".obj"))
			return new File(archivo + ".obj");
		return archivo;
	}

	public static boolean confirmarSiExiste(File archivo) {
		archivo = annadirExtension(archivo);
		return archivo.exists();
	}
}
