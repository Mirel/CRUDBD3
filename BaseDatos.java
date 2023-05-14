package datos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import control.Libros;
import control.TransformarSQL;
import usuario.PedirDatos;

public class BaseDatos {

	/** método con la conexión de ejecución de actualizaciones (executeUpdate)
	 * @param sql
	 */
	public void ejecutarSQL(String sql) {

		Connection conexion = null;
		Statement sentenciaSQL = null;
		int resultado = 0;

		try {
			// conectar con la base de datos
			Class.forName("com.mysql.cj.jdbc.Driver");
			conexion = DriverManager.getConnection("jdbc:mysql://localhost:8889/biblioteca", "root", "root");

			// creamos sentencias ejecutables sobre esa conexi�n
			sentenciaSQL = conexion.createStatement();

			resultado = sentenciaSQL.executeUpdate(sql);

			if (resultado >= 1) {
				System.out.println("Operación realizada.");
			}

		} catch (SQLException ex) {
			ex.printStackTrace();
			// System.out.println("Error");
		} catch (ClassNotFoundException e) {

			e.printStackTrace();
		} finally {
			try {
				sentenciaSQL.close();
				conexion.close();
			} catch (SQLException e) {

				e.printStackTrace();
			}

		}

		System.out.println("Conectado/desconectado");

	}
    
	/**
	 * @param sql
	 * @return metodo con la conexion de execución de consultas(executeQuery), que recoje los datos y devuelve todos en un arrayList.
	 */
	public List<Libros> consultarSQL(String sql) {

		Connection conexion = null;
		Statement sentenciaSQL = null;
		ResultSet rs = null;
		List<Libros> libros = new ArrayList<Libros>();
		try {
			// conectar con la base de datos
			Class.forName("com.mysql.cj.jdbc.Driver");
			conexion = DriverManager.getConnection("jdbc:mysql://localhost:8889/biblioteca", "root", "root");

			// creamos sentencias ejecutables sobre esa conexi�n
			sentenciaSQL = conexion.createStatement();

			rs = sentenciaSQL.executeQuery(sql);
			/// IMprrimir eel total de filas devueltas en eel resultsset
			while (rs.next()) {
				String titulo = rs.getString("titulo");
				String autor = rs.getString("autor");
				String tipologia = rs.getString("tipologia");
				Libros libro = new Libros(titulo, autor, tipologia);
				libros.add(libro);
			}

		} catch (SQLException ex) {
			ex.printStackTrace();
			// System.out.println("Error");
		} catch (ClassNotFoundException e) {

			e.printStackTrace();
		} finally {
			try {
				sentenciaSQL.close();
				conexion.close();
			} catch (SQLException e) {

				e.printStackTrace();
			}
		}

		System.out.println("Conectado/desconectado");
		return libros;

	}
    //metodo que encargar de añadir en un array todos los datos y mostrarlos.
	public void mostrarColeccion() {
		
		String sql = TransformarSQL.mostrarSQL();
		List<Libros> libros = consultarSQL(sql);
		for (Libros libro : libros) {
			System.out.println(libro);
		}

	}

	/**
	 * @param miLibro metodo de añadir libro donde recibe un objeto de la clase libros, llamo a la clase de transformarSQL y 
	 * ejecuto la conexion.Me imprime el mensaje.
	 */
	public void addLibro(Libros miLibro) {
		String sql = TransformarSQL.pasarLibroSQL(miLibro);
		ejecutarSQL(sql);

		System.out.println("Libro añadido");
	}
    //metodo que ejecura la funcion del menu de modificar libro
	public void modificarLibro(Libros libro, String titulo) {

		String sql = TransformarSQL.modificarSQL(titulo, libro);
		ejecutarSQL(sql);
		System.out.println("Libro modificado");

	}
	//metodo que ejecura la funcion del menu de eliminar libro
	public void eliminararLibro(String titulo) {
		String sql = TransformarSQL.eliminarSQL(titulo);
		ejecutarSQL(sql);
		System.out.println("Libro eliminado");
	}
	//metodo que ejecura la funcion del menu de buscar libro por autor
	public void buscarTitulo(String titulo) {
		String sql = TransformarSQL.pasartituloSQL(titulo);
		List<Libros> libros = consultarSQL(sql);
		// Como solo hay un libro por titulo, nos sirve con imprimir la primera posicion
		// del listado
		System.out.println(libros.get(0));

	}
	//metodo que ejecura la funcion del menu de buscar libro por autor
	public void buscarAutor(String autor) {
		String sql = TransformarSQL.pasarAutorSQL(autor);
		List<Libros> libros = consultarSQL(sql);
		for (Libros libros2 : libros) {
			System.out.println(libros2);

		}

	}
	//metodo que ejecura la funcion del menu de de buscar libro por tipo
	public void buscartipo(String tipo) {

		String sql = TransformarSQL.pasartipoSQL(tipo);
		List<Libros> libros = consultarSQL(sql);

		for (Libros libros2 : libros) {
			System.out.println(libros2);
			;

		}

	}

}
