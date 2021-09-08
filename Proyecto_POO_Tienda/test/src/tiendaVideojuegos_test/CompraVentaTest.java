package tiendaVideojuegos_test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import mundo.TiendaVideojuegos.CompraVenta;
import mundo.TiendaVideojuegos.Juegos;
import mundo.TiendaVideojuegos.CompraVenta.Tipo;
import mundo.TiendaVideojuegos.Juegos.Genero;

class CompraVentaTest {
	private Juegos juego;

	public void escenario1() {
		juego = new Juegos("Call of Duty", 37465, Genero.Disparos, 30.5);
	}

	public void escenario2() {
		juego = new Juegos("Call of Duty", 37465, Genero.Disparos, 30.5);
		juego.compra(2000);
		juego.venta(600);
		juego.venta(88);
	}

	@Test
	@DisplayName("Tipo")
	public void testTipo() {
		escenario2();
		ArrayList<CompraVenta> tipo = juego.getComprita();
		assertEquals(tipo.get(0).getTipo(), Tipo.COMPRA);
		assertEquals(tipo.get(1).getTipo(), Tipo.VENTA);
		assertEquals(tipo.get(2).getTipo(), Tipo.VENTA);
	}

	@Test
	@DisplayName("Cuanto venta o compra")
	public void testDarCantidad() {
		escenario1();
		juego.compra(1000);
		juego.venta(600);
		ArrayList<CompraVenta> tipo = juego.getComprita();
		assertTrue(tipo.get(0).getCantidad() == 1000);
		assertTrue(tipo.get(1).getCantidad() == 600);
	}
	
	
}
