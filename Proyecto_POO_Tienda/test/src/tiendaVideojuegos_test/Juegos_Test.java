package tiendaVideojuegos_test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import mundo.TiendaVideojuegos.Juegos;
import mundo.TiendaVideojuegos.Juegos.Genero;

class Juegos_Test {

	private Juegos juego;

	public void escenario1() {
		juego = new Juegos("Call of Duty", 37465, Genero.Disparos, 30.5);
		juego.compra(2000);
	}

	public void escenario2() {
		juego = new Juegos("Call of Duty", 37465, Genero.Disparos, 30.5);
		juego.compra(2000);
	}

	@Test
	@DisplayName("Asignar nombre del juego")
	public void testNombre() {
		escenario1();
		assertEquals("Call of Duty", juego.getNombre());
	}

	@Test
	@DisplayName("Asignar codigo del juego")
	public void testCodigo() {
		escenario1();
		assertEquals(37465, juego.getCodigo());
	}

	@Test
	@DisplayName("Asignar genero del juego")
	public void testGenero() {
		escenario1();
		assertEquals(Genero.Disparos, juego.getGenero());
	}

	@Test
	@DisplayName("Asignar costo del juego")
	public void testCosto() {
		escenario1();
		assertEquals(30.5, juego.getCosto(), 0.5);
	}

	@Test
	@DisplayName("Compara el numero de compras")
	public void testCompra() {
		escenario1();
		assertTrue(2000 == juego.getCantidadActual());
	}

	@Test
	@DisplayName("Compara el numero de ventas")
	public void testVenta() {
		escenario2();
		juego.venta(1000);
		assertTrue(1000 == juego.getCantidadActual());
	}

	@Test
	@DisplayName("Compara numero de juego actual")
	public void testCantidadActual() {
		escenario1();
		assertTrue(2000 == juego.getCantidadActual());
		juego.compra(50);
		assertTrue(2050 == juego.getCantidadActual());
	}
	
	
	
}
