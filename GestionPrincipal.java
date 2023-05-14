package control;

import datos.BaseDatos;
import usuario.MenuPrincipal;
import usuario.PedirDatos;

public class GestionPrincipal {
    
	/**En el main creo un objeto de la clase de conexión. Creo un bucle "DO While" donde dentro llamo a los métodos correspondientes
	 * a las opciones de ejecución del menu, que aparecerá hasta que el usuario solicite la opción 8 de salida que la pongo en 
	 * la condicion del while.
	 * @param args
	 */
	public static void main(String[] args) {
		int opcion = 0;
		BaseDatos miColeccion = new BaseDatos();

		do {
			MenuPrincipal.mostrar();
			opcion = PedirDatos.pedirNumero(1, 8, "Introduce una opcion del Menu");
			if (opcion >= 1 && opcion <= 7) { // es valido
				procesarOpcion(opcion, miColeccion);

			}

		} while (opcion != 8);

		System.out.println("Fin del programa");

	}

	/**Este método se encarga de procesar cada opción del Menu, llamando a los métodos de las clases correspondientes.
	 * @param opcion
	 * @param miColeccion
	 */
	private static void procesarOpcion(int opcion, BaseDatos miColeccion) {
		String titulo = "";
		String autor = "";
		String tipo = "";

		Libros miLibro = null;

		switch (opcion) {
		case 1:
			miColeccion.mostrarColeccion();
			break;

		case 2:
			miLibro = PedirDatos.pedLibros();
			miColeccion.addLibro(miLibro);
			break;

		case 3:
			miColeccion.mostrarColeccion();
			titulo = PedirDatos.pedirDato("Introduzca el título: ", 100);
			miLibro = PedirDatos.pedLibros();
			miColeccion.modificarLibro(miLibro, titulo);
			break;

		case 4:
			miColeccion.mostrarColeccion();
			titulo = PedirDatos.pedirDato("introduce el título del libro a eliminar ", 100);
			miColeccion.eliminararLibro(titulo);

			break;

		case 5: // buscar por nombre
			titulo = PedirDatos.pedirDato("introduce el título del libro a buscar ", 100);
			miColeccion.buscarTitulo(titulo);

			break;
		case 6: // buscar por tipo

			autor = PedirDatos.pedirDato("introduce el autor del libro a buscar ", 100);
			miColeccion.buscarAutor(autor);
			;
			break;

		case 7: // buscar por precio

			tipo = PedirDatos.pedirDato("introduce el tipo del libro a buscar ", 100);
			miColeccion.buscartipo(tipo);
			break;

		}

	}

}

//insertar tipo update o delete . tener un metodo que transforma el objeto que transforme
//el objeto en una sentencia update o delete en funcion de los atributos que contiene ese objeto
//