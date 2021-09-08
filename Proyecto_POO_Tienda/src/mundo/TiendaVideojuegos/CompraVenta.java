package mundo.TiendaVideojuegos;

public class CompraVenta {
	// Atributos
	public enum Tipo {
		COMPRA, VENTA
	}

	private Tipo tipo;
	private int cantidad;

	// Constructor
	public CompraVenta(Tipo tipo, int cantidad) {
		this.tipo = tipo;
		this.cantidad = cantidad;
	}

	// Getters and Setters
	public Tipo getTipo() {
		return tipo;
	}

	public void setTipo(Tipo tipo) {
		this.tipo = tipo;
	}

	public int getCantidad() {
		return cantidad;
	}

	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}
}
