package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import entidades.Curso;

import static utils.Constantes.*;

/*
 * Clase CursoDAO que maneja los accesos a la base de datos, así como las operaciones de
 * lectura, escritura y actualizacion
 */
public class CursoDAO {

	/**
	 * Atrobuto para guardar la conexion con la base de datos
	 */
	private Connection conexion;

	/**
	 * Constructor de CursoDAO que inicializa la conexion con la base de datos
	 */
	public CursoDAO() {
		try {
			conexion = DriverManager.getConnection(URL, USER, PASSWORD);
		} catch (SQLException e) {
			System.out.println("Error de Conexion a la BD");
			e.printStackTrace();
		}
	}

	/**
	 * Conexion con la BD
	 * 
	 * @return Devuelve la conexion de la base de datos
	 */
	public Connection getConexion() {
		return conexion;
	}

	/**
	 * Metodo para insertar el curso en la base de datos, Crea una consulta sql con
	 * los datos del curso pasado por parámetro y la ejecuta
	 * 
	 * @param curso Curso que se va a insertar en la BD
	 * @return True si se ha insertado correctamente y false en caso contrario
	 */
	public boolean crearCurso(Curso curso) {
		boolean created = false;

		String creation;

		creation = "insert into cursos (nombre, descripcion, año_escolar) " + "values ('" + curso.getNombre() + "',"
				+ "'" + curso.getDescripcion() + "'," + " '" + curso.getAño_escolar() + "')";

		Statement st;

		try {
			st = conexion.createStatement();
			created = st.executeUpdate(creation) > 0;
		} catch (SQLException e) {
			System.out.println("Error en la consulta sql: " + e);
		}

		return created;
	}

	/**
	 * Metodo que hace una consulta a la base de datos para obtener todos los cursos
	 * y añadirlos a una lista que va a devolver
	 * 
	 * @return Una lista con todos los cursos
	 */
	public ArrayList<Curso> listaCurso() {
		// Lista final
		ArrayList<Curso> lista = new ArrayList<Curso>();

		// Lista resultante de la consulta
		ResultSet res;

		// Consulta
		String consulta;
		consulta = "select * from cursos";

		// Atributos del curso
		int id;
		int fecha;
		String nombre;
		String descripcion;

		// Hacemos la select
		try {
			Statement st = conexion.createStatement();
			res = st.executeQuery(consulta);
			// Recorremos la lista formando cursos y añadiendolos a la lista final
			while (res.next()) {
				id = res.getInt(1);
				nombre = res.getString(2);
				descripcion = res.getString(3);
				fecha = res.getInt(4);

				Curso c1 = new Curso(id, nombre, descripcion, fecha);
				lista.add(c1);
			}
		} catch (SQLException e) {
			System.out.println("Error en la consulta sql " + e);
		}
		return lista;
	}

	/**
	 * Asigna un Profesor a un curso en la tabla cursoprofesor de la BD
	 * 
	 * @param idProfe ID del profesor
	 * @param idCurso ID del curso
	 * @return True si se ha podido relacionar False si no se ha podido relacionar o
	 *         alguno de los campos no existe
	 */
	public boolean asignarProfeACurso(int idProfe, int idCurso) {
		boolean res = false;
		String consulta = "insert into cursoprofesor (id_profesor, id_curso) values (" + idProfe + "," + idCurso + ")";

		try {
			Statement st = conexion.createStatement();
			st.executeUpdate(consulta);
			res = true;
		} catch (SQLException e) {
			System.out.println("Error en la consulta sql " + e);
		}

		return res;
	}

	/**
	 * Metodo que lee los estudiantes que hay en la base de datos con ese idCurso
	 * relacionado. Guarda los atributos de los mismos en un String y lo añade a una
	 * lista para devolverla
	 * 
	 * @param idCurso ID del curso por el que se va a filtrar a los estudiantes
	 * @return Lista de Strings, en cada String se encuentran los atributos de cada estudiante
	 */
	public ArrayList<String> listarEstudiantes(int idCurso) {
		//Lista final
		ArrayList<String> lista = new ArrayList<String>();
		
		//String auxliar para los datos del estudiante
		String aux;
		
		//Variables auxiliares para los atributos del estudiante
		int id;
		int tel;
		String nombre;
		String apellido;
		String fecha;
		String email;
		
		// Lista resultante de la consulta
				ResultSet res;

				// Consulta
				String consulta;
				consulta = "select * from estudiantes where id_estudiante in (select id_estudiante from matriculas"
						+ "where id_curso = " + idCurso + ")";

				// Hacemos la select
				try {
					Statement st = conexion.createStatement();
					res = st.executeQuery(consulta);
					// Recorremos la lista formando estudiantes y añadiendolos a la lista final
					while (res.next()) {
						id = res.getInt(1);
						nombre = res.getString(2);
						apellido = res.getString(3);
						nombre = res.getString(2);
						nombre = res.getString(2);
						
						
						aux = "ID: ";	

					}
				} catch (SQLException e) {
					System.out.println("Error en la consulta sql " + e);
				}
		
		
		return lista;
	}

}
