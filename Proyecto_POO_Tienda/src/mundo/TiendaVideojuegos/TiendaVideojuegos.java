package mundo.TiendaVideojuegos;

import java.util.ArrayList;

import com.mongodb.BasicDBObject;

import mundo.TiendaVideojuegos.Juegos.Genero;

public class TiendaVideojuegos {
	// Atributos
	private ArrayList<Juegos> biblioteca;
	private ArrayList<Juegos> bibliotecaGratis;
	private double capital;

	// Constructor
	public TiendaVideojuegos() {
		biblioteca = new ArrayList<Juegos>();
		bibliotecaGratis = new ArrayList<Juegos>();
		capital = 1000000;
	}

	// Getters
	public ArrayList<Juegos> getBiblioteca() {
		return biblioteca;
	}

	public ArrayList<Juegos> getbibliotecaGratis() {
		return bibliotecaGratis;
	}

	public double getCapital() {
		return capital;
	}

	// Metodos
	public Juegos nuevoJuego(String nombre, int codigo, Genero genero, double costo) {
		Juegos buscadoJuego = buscarNombre(nombre);
		Juegos nuevoJuego = null;
		if (buscadoJuego == null) {
			nuevoJuego = new Juegos(nombre, codigo, genero, costo);
			biblioteca.add(nuevoJuego);
		}
		return nuevoJuego;
	}

	public Juegos buscarNombre(String nombre) {
		Juegos buscadoJuego = null;
		for (int i = 0; i < biblioteca.size() && buscadoJuego == null; i++) {
			Juegos actual = biblioteca.get(i);
			if (actual.getNombre().equals(nombre)) {
				buscadoJuego = actual;
			}
		}
		return buscadoJuego;
	}

	public boolean eliminarJuego(String nombre) {
		boolean eliminar = false;
		Juegos buscadoJuego = buscarNombre(nombre);
		if (buscadoJuego != null) {
			biblioteca.remove(buscadoJuego);
			eliminar = true;
		}
		return eliminar;
	}

	public boolean venderJuego(String nombre, int cantidad) {
		boolean vender = false;
		Juegos buscadoJuego = buscarNombre(nombre);
		if (buscadoJuego != null) {
			vender = buscadoJuego.venta(cantidad);
			capital += cantidad * buscadoJuego.getCosto();
		}
		return vender;
	}

	public Juegos masComprado() {
		Juegos masComprado = null;
		int ventas = 0;
		for (Juegos actual : biblioteca) {
			int ventasActual = 0;
			for (CompraVenta transaccionActual : actual.getComprita()) {
				if (transaccionActual.getTipo().equals(CompraVenta.Tipo.VENTA)) {
					ventasActual += transaccionActual.getCantidad();
				}
			}
			if (ventasActual > ventas) {
				masComprado = actual;
				ventas = ventasActual;
			}
		}
		return masComprado;
	}

	public Juegos juegoEconomico() {
		Juegos menosCostoso = null;
		double precioMenosCostoso = 0.0;
		if (biblioteca.size() > 0) {
			menosCostoso = biblioteca.get(0);
			precioMenosCostoso = biblioteca.get(0).getCosto();
			for (int i = 0; i < biblioteca.size(); i++) {
				Juegos actual = biblioteca.get(i);
				if (actual.getCosto() < precioMenosCostoso) {
					menosCostoso = actual;
					precioMenosCostoso = actual.getCosto();
				}
			}
		}
		return menosCostoso;
	}

	public ArrayList<Juegos> juegosGratis() {
		if (biblioteca.size() > 0) {
			for (int i = 0; i < biblioteca.size(); i++) {
				Juegos actualJuegos = biblioteca.get(i);
				if (actualJuegos.getCosto() == 0) {
					bibliotecaGratis.add(actualJuegos);
				}
			}
		}
		return bibliotecaGratis;
	}

	public boolean AumentarJuegos(String nombre, int cantidad) {
		Juegos buscadoJuego = buscarNombre(nombre);
		boolean aumento = false;
		if (buscadoJuego != null && capital >= cantidad * buscadoJuego.getCosto()) {
			buscadoJuego.compra(cantidad);
			capital -= cantidad * buscadoJuego.getCosto();
			aumento = true;
		}
		return aumento;
	}

	public BasicDBObject toDBObjectTiendaVideojuegos() {
		BasicDBObject dbObjectTiendaVideojuegos = new BasicDBObject();
		for (int i=0; i<biblioteca.size() ;i++) {
			dbObjectTiendaVideojuegos.append("Nombre", biblioteca.get(i).getNombre().toString());
			dbObjectTiendaVideojuegos.append("Codigo", biblioteca.get(i).getCodigo());
			dbObjectTiendaVideojuegos.append("Genero", biblioteca.get(i).getGenero().toString());
			dbObjectTiendaVideojuegos.append("Costo", biblioteca.get(i).getCosto());
			dbObjectTiendaVideojuegos.append("# Key's", biblioteca.get(i).getCantidadActual());
		}
		return dbObjectTiendaVideojuegos;
	}

	@Override
	public String toString() {
		return "TiendaVideojuegos [" + biblioteca + "]"+"\n";
	}

}
