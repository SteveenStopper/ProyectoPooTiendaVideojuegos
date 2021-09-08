package tiendaVideojuegos_test;

import static org.junit.Assert.assertFalse;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import mundo.TiendaVideojuegos.Juegos;
import mundo.TiendaVideojuegos.TiendaVideojuegos;
import mundo.TiendaVideojuegos.Juegos.Genero;

class TiendaVideojuegos_Test {

	private TiendaVideojuegos tiendaVideojuegos;

	public void escenario1() {
		tiendaVideojuegos = new TiendaVideojuegos();
	}

	public void escenario2() {
		tiendaVideojuegos = new TiendaVideojuegos();
		tiendaVideojuegos.nuevoJuego("Call of duty", 37465, Genero.Disparos, 30);
		tiendaVideojuegos.nuevoJuego("PES 2021", 38978, Genero.Deportes, 20);
	}
	/*
	@Test
	@DisplayName("Juego mas Vendido en la Tienda")
	public void testDarLibroMasVendido() {
		escenario2();
		tiendaVideojuegos.AumentarJuegos("Call of duty", 400);
		tiendaVideojuegos.AumentarJuegos("PES 2021", 800);
		tiendaVideojuegos.venderJuego("Call of duty", 400);
		tiendaVideojuegos.venderJuego("PES 2021", 800);
		assertEquals("Call of duty", tiendaVideojuegos.masComprado().getNombre());
	}
	*/
	@Test
	@DisplayName("Buscar juego por el nombre ")
	public void testBuscarPorNombre() {
		escenario1();
		tiendaVideojuegos.nuevoJuego("Call of duty", 37465, Genero.Disparos, 30);
		Juegos juegito = new Juegos("Call of duty", 37465, Genero.Disparos, 30);
		assertEquals(juegito.getNombre(), tiendaVideojuegos.buscarNombre("Call of duty").getNombre());
	}

	@Test
	@DisplayName("Añadir un nuevo juego a la Biblioteca")
	public void testNuevoJuego() {
		escenario1();
		assertTrue(0 == tiendaVideojuegos.getBiblioteca().size());
		tiendaVideojuegos.nuevoJuego("Call of duty", 37465, Genero.Disparos, 30);
		assertTrue(1 == tiendaVideojuegos.getBiblioteca().size());
		tiendaVideojuegos.nuevoJuego("Call of duty", 37465, Genero.Disparos, 30);
		assertTrue(1 == tiendaVideojuegos.getBiblioteca().size());
	}

	@Test
	@DisplayName("Eliminar un juego de la Biblioteca")
	public void testEliminarJuego() {
		escenario1();
		tiendaVideojuegos.nuevoJuego("Call of duty", 37465, Genero.Disparos, 30);
		tiendaVideojuegos.nuevoJuego("PES 2021", 38978, Genero.Deportes, 20);
		tiendaVideojuegos.eliminarJuego("PES 2021");
		assertTrue(1 == tiendaVideojuegos.getBiblioteca().size());
		tiendaVideojuegos.eliminarJuego("PES 2021");
		assertTrue(1 == tiendaVideojuegos.getBiblioteca().size());
	}

	@Test
	@DisplayName("Vender Juego")
	public void testVenderJuego() {
		escenario2();
		tiendaVideojuegos.AumentarJuegos("Call of duty", 500);
		tiendaVideojuegos.venderJuego("Call of duty", 300);
		assertEquals(200, tiendaVideojuegos.buscarNombre("Call of duty").getCantidadActual());
		boolean venta = tiendaVideojuegos.venderJuego("Call of duty", 2001);
		assertFalse("No se vende",venta);
	}

	

	@Test
	@DisplayName("Juego mas economico en la Tienda")
	public void testJuegoEconomico() {
		escenario2();
		Juegos jueguito = new Juegos("Five nights at freddy's", 35496, Genero.Terror, 15);
		tiendaVideojuegos.nuevoJuego("Five nights at freddy's", 35496, Genero.Terror, 15);
		assertEquals(jueguito.getNombre(), tiendaVideojuegos.juegoEconomico().getNombre());
	}

	@Test
	@DisplayName("Aumenta un juego")
	public void testAumentarJuego() {
		escenario2();
		tiendaVideojuegos.AumentarJuegos("Call of duty", 100);
		assertTrue(100 == tiendaVideojuegos.buscarNombre("Call of duty").getCantidadActual());
	}

	@Test
	@DisplayName("Muestra juegos gratis")
	public void testJuegosGratis() {
		escenario1();
		Juegos jueguito = new Juegos("Overwatch", 25698, Genero.Disparos, 0);
		assertTrue(0 == jueguito.getCosto());
	}

}
