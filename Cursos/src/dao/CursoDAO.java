package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

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
	 * Metodo para insertar el curso en la base de datos, Crea una consulta sql con los datos del curso pasado por parámetro y la ejecuta
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

}
