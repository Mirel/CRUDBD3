package usuario;

import java.util.Scanner;

import control.Libros;

public class PedirDatos {

	/**Este método encarga de pedir los datos al usuario. llamo al metodo pedir dato para unificar la petición.
	 * @return
	 */
	public static Libros pedLibros() {

		String titulo = pedirDato("Introduzca el titulo: ", 100);
		String autor = pedirDato("Introduzca el autor: ", 100);
		String tipologia = pedirDato("Introduzca la tipologia: ", 100);

		return new Libros(titulo, autor, tipologia);

	}

	public static String pedirDato(String mensaje, int maximo) {
		Scanner lector = new Scanner(System.in);
		String cadena = "";

		try {
			do {
				System.out.println(mensaje);
				cadena = lector.nextLine();

			} while (cadena.length() >= maximo);
		} catch (Exception e) {
			cadena = "";
		}
		return cadena;
	}
   
	/**Método que pide al usuario el número correspondiente a la opción del menú deseada.
	 * @param numInicial
	 * @param numFinal
	 * @param mensaje
	 * @return
	 */
	public static int pedirNumero(int numInicial, int numFinal, String mensaje) {

		Scanner lector = new Scanner(System.in);
		int numero = 0;

		try {

			do {
				System.out.println(mensaje);
				numero = lector.nextInt();
				lector.nextLine();

			} while (numero < numInicial || numero > numFinal);

		} catch (Exception e) {
			// si hay error devuelve salir
			numero = 8;
		}

		return numero;

	}

	/*
	 * public static String pedirAutor(String mensaje, int minimo) { Scanner lector
	 * = new Scanner(System.in); String cadena = "";
	 * 
	 * try { do { System.out.println(mensaje); cadena = lector.nextLine();
	 * 
	 * } while (cadena.length() <= minimo); } catch (Exception e) { cadena = ""; }
	 * return cadena; }
	 * 
	 * public static int pedirTipo(String mensaje, int minimo) {
	 * 
	 * Scanner lector = new Scanner(System.in); int numero = 0;
	 * 
	 * try {
	 * 
	 * do { System.out.println(mensaje); numero = lector.nextInt();
	 * lector.nextLine();
	 * 
	 * } while (numero < numInicial || numero > numFinal);
	 * 
	 * } catch (Exception e) { // si hay error devuelve salir numero = 8; }
	 * 
	 * return numero;
	 * 
	 * }
	 */

}
