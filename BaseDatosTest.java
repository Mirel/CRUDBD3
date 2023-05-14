package datos;

import static org.junit.Assert.*;

import org.junit.Test;

import control.Libros;

public class BaseDatosTest {

	@Test
	public void testAddLibro() {
		fail("Not yet implemented");
		
		BaseDatos mislibros= new BaseDatos();
		Libros libros = new Libros("la cabaña", "pepe", "drama");
		mislibros.addLibro(libros);
		
	}
	
	@Test
	public void testModificarLibro() {
		fail("Not yet implemented");
	}

	@Test
	public void testEliminararLibro() {
		fail("Not yet implemented");
	}

}
