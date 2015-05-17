/**
 * Paquete que contiene los archivos del programa
 */
package concesionarioCoches;

import java.io.Serializable;
/**
 * Importación de la clase Pattern
 */
import java.util.regex.Pattern;

/**
 * Clase que contiene toda la información y las acciones de los coches
 * 
 * @author Roberto Carlos Flores Gomez
 * @version 1.0
 *
 */
public class Coche implements Serializable{
	
	/**
	 * Matrícula del coche
	 */
	private String matricula;
	
	/**
	 * Color del coche
	 */
	private Color color;
	
	/**
	 * Modelo del coche
	 */
	private Modelo modelo;
	
	/**
	 * Patrón para una matrícula válida
	 */
	static final private Pattern patternMatricula = Pattern
			.compile("^\\d{4}[ -]?[[B-Z]&&[^QEIOU]]{3}$");

	/**
	 * Construye un nuevo coche de matrícula, color y modelo especificado
	 * 
	 * @param matricula
	 *            Representa la matrícula del nuevo coche
	 * @param color
	 *            Representa el color del nuevo coche
	 * @param modelo
	 *            Representa el modelo del nuevo coche
	 */
	private Coche(String matricula, Color color, Modelo modelo) {
		super();
		setMatricula(matricula);
		setColor(color);
		setModelo(modelo);
	}

	/**
	 * Construye un nuevo coche de matrícula especificada
	 * 
	 * @param matricula
	 *            Representa la matrícula del nuevo coche
	 */
	private Coche(String matricula) {
		setMatricula(matricula);
	}

	/**
	 * Instancia un objeto de clase coche de matrícula, color y modelo
	 * especificado
	 * 
	 * @param matricula
	 *            Representa la matrícula del nuevo coche
	 * @param color
	 *            Representa el color del nuevo coche
	 * @param modelo
	 *            Representa el modelo del nuevo coche
	 * @return Objeto de clase coche. null si la matrícula, el color o el modelo
	 *         no son válidos
	 */
	static Coche instanciarCoche(String matricula, Color color, Modelo modelo) {
		if (esValida(matricula) && color != null && modelo != null)
			return new Coche(matricula, color, modelo);
		return null;
	}

	/**
	 * Instancia un objeto de clase coche de matrícula especificada
	 * 
	 * @param matricula
	 *            Representa la matrícula del nuevo coche
	 * @return Objeto de clase coche. null si la matrícula no es válida
	 */
	static Coche instanciarCoche(String matricula) {
		if (esValida(matricula))
			return new Coche(matricula);
		return null;
	}

	/**
	 * Comprueba si la matrícula del coche es válida o no
	 * 
	 * @param matricula
	 *            Representa la matrícula a validar
	 * @return true si la matrícula es válida, false si la matrícula no es
	 *         válida
	 */
	public static boolean esValida(String matricula) {
		return patternMatricula.matcher(matricula).matches();
	}

	/**
	 * Modifica la matrícula del coche
	 * 
	 * @param matricula
	 *            Representa la nueva matrícula del coche
	 */
	private void setMatricula(String matricula) {
		this.matricula = matricula;
	}

	/**
	 * Devuelve el color del coche
	 * 
	 * @return Color del coche
	 */
	public Color getColor() {
		return color;
	}
	
	public Modelo getModelo() {
		return modelo;
	}
	
	public String getMatricula() {
		return matricula;
	}

	/**
	 * Modifica el color del coche
	 * 
	 * @param color
	 *            Representa el nuevo color del coche
	 */
	private void setColor(Color color) {
		this.color = color;
	}

	/**
	 * Modifica el modelo del coche
	 * 
	 * @param modelo
	 *            Representa el nuevo modelo del coche
	 */
	private void setModelo(Modelo modelo) {
		this.modelo = modelo;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((matricula == null) ? 0 : matricula.hashCode());
		return result;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Coche other = (Coche) obj;
		if (matricula == null) {
			if (other.matricula != null)
				return false;
		} else if (!matricula.equals(other.matricula))
			return false;
		return true;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "\nCoche [matricula=" + matricula + ", color=" + color
				+ ", modelo=" + modelo + "]";
	}

}
