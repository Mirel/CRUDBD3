package control;

/**
 * @author mirelle
 *clase con los metodos que se encargan de transformar los datos de entrada y salida a SQL.
 */
public class TransformarSQL {
    
	public static String pasarLibroSQL(Libros miLibro) {

		// INSERT INTO libros(titulo,autor,tipologia) VALUES ('"+ +"','"+ +"','"+ +"');

		return "INSERT INTO libros(titulo,autor,tipologia) VALUES ('" + miLibro.getTitulo() + "','" + miLibro.getAutor()
				+ "','" + miLibro.getTipologia() + "');";

	}
	//sentencia SQL de consulta de toda la tabla
	public static String mostrarSQL() {

		return "Select * from libros;";

	}
    //sentencia SQL de consulta por un dato especifico
	public static String pasartituloSQL(String titulo) {

		return "Select * from libros where titulo=('" + titulo + "');";

	}
	//sentencia SQL de consulta por un dato especifico
	public static String pasarAutorSQL(String autor) {

		return "Select * from libros where autor=('" + autor + "');";

	}
	//sentencia SQL de consulta por un dato especifico
	public static String pasartipoSQL(String tipo) {

		return "Select * from libros where tipologia=('" + tipo + "');";

	}
	//sentencia SQL de borrado por un dato especifico
	public static String eliminarSQL(String titulo) {

		return "Delete from libros where titulo=('" + titulo + "');";

	}
	//sentencia SQL de modificacion por un dato especifico.
	public static String modificarSQL(String titulo, Libros libro) {
		// update libros set titulo='titulo', autor='autor', tipologia = 'tipologia'
		// where titulo =''
		return "Update libros set titulo = '" + libro.getTitulo() + "', autor='" + libro.getAutor() + "', tipologia='"
				+ libro.getTipologia() + "' where titulo = ('" + titulo + "');";

	}
}
//....