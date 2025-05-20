package entidades;

/**
 * Clase curso que representa como entidad a un curso escolar, tiene un id, un
 * nombre, una descripción y un año escolar
 */
public class Curso {
	/**
	 * ID del curso
	 */
	private int id_curso;

	/**
	 * Nombre del Curso
	 */
	private String nombre;

	/**
	 * Descripcion del curso
	 */
	private String descripcion;

	/**
	 * Año escolar del curso
	 */
	private int año_escolar;

	
	/**
	 * Constructor de Curso con todos sus atributos menos el id
	 * @param nombre Nombre del curso. No puede venir nulo ni vacio
	 * @param descripcion Descripcion del curso. No puede venir nulo ni vacio
	 * @param año_escolar Año escolar del curso. No puede ser negativo
	 */
	public Curso(String nombre, String descripcion, int año_escolar) {
		if (nombre != null && !nombre.isBlank()) {
			this.nombre = nombre;
		}
		if (descripcion != null && !descripcion.isBlank()) {
			this.descripcion = descripcion;
		}
		if (año_escolar >= 0) {
			this.año_escolar = año_escolar;
		}
	}

	
	/**
	 * Constructor de Curso con todos sus atributos
	 * @param id_curso ID del curso. No puede ser negativo
	 * @param nombre Nombre del curso. No puede venir nulo ni vacio
	 * @param descripcion Descripcion del curso. No puede venir nulo ni vacio
	 * @param año_escolar Año escolar del curso. No puede ser negativo
	 */
	public Curso(int id_curso, String nombre, String descripcion, int año_escolar) {
		if (id_curso >= 0) {
			this.id_curso = id_curso;
		}
		if (nombre != null && !nombre.isBlank()) {
			this.nombre = nombre;
		}
		if (descripcion != null && !descripcion.isBlank()) {
			this.descripcion = descripcion;
		}
		if (año_escolar >= 0) {
			this.año_escolar = año_escolar;
		}
	}

	
	/**
	 * Getter del ID del curso
	 * @return Devuelve el id del curso
	 */
	public int getId_curso() {
		return id_curso;
	}

	/**
	 * Getter del nombre del curso
	 * @return Devuelve el nombre del curso
	 */
	public String getNombre() {
		return nombre;
	}
	/**
	 * Getter de la descripcion del curso
	 * @return Devuelve la descripcion del curso
	 */
	public String getDescripcion() {
		return descripcion;
	}

	/**
	 * Getter del año escolar del curso
	 * @return Devuelve el año escolar del curso
	 */
	public int getAño_escolar() {
		return año_escolar;
	}
	
	/**
	 * Metodo to String para representar a un curso con sus atributos por consola
	 */
	@Override
	public String toString() {
		String res = "";
		res += "ID: " + this.id_curso;
		res += " | Nombre: " + this.nombre;
		res += " | Descripción: " + this.descripcion;
		res += " | Año Escolar: " + this.año_escolar;
		
		return res;
	}
	
	
}
