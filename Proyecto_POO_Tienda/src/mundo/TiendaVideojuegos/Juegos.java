package mundo.TiendaVideojuegos;

import java.util.ArrayList;

public class Juegos {
	public enum Genero {
		Accion, Terror, Aventura, Disparos, Roll, Deportes, Carreras;
	}

	// Atributos
	private String nombre;
	private int codigo;
	private Genero genero;
	private double costo;

	private ArrayList<CompraVenta> comprita;
	private int cantidadActual;

	// Constructor
	public Juegos(String nombre, int codigo, Genero genero, double costo) {
		this.nombre = nombre;
		this.codigo = codigo;
		this.genero = genero;
		this.costo = costo;
		comprita = new ArrayList<CompraVenta>();
	}

	public Juegos() {
		nombre = "";
		codigo = 0;
		genero = null;
		costo = 0;
	}
	
	// Getters and Setters
	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public double getCosto() {
		return costo;
	}

	public void setCosto(double costo) {
		this.costo = costo;
	}

	public ArrayList<CompraVenta> getComprita() {
		return comprita;
	}

	public void setComprita(ArrayList<CompraVenta> comprita) {
		this.comprita = comprita;
	}

	public Genero getGenero() {
		return genero;
	}

	public void setGenero(Genero genero) {
		this.genero = genero;
	}

	public int getCantidadActual() {
		return cantidadActual;
	}

	public void setCantidadActual(int cantidadActual) {
		this.cantidadActual = cantidadActual;
	}

	// Metodos

	public void compra(int Cantidad) {
		cantidadActual += Cantidad;
		CompraVenta nuevo = new CompraVenta(CompraVenta.Tipo.COMPRA, Cantidad);
		comprita.add(nuevo);
	}

	public boolean venta(int Cantidad) {
		boolean vendido = false;
		if (Cantidad <= cantidadActual) {
			cantidadActual -= Cantidad;
			CompraVenta nuevo = new CompraVenta(CompraVenta.Tipo.VENTA, Cantidad);
			comprita.add(nuevo);
			vendido = true;
		}
		return vendido;
	}

	@Override
	public String toString() {
		return "Juegos [nombre=" + nombre + ", codigo=" + codigo + ", genero=" + genero + ", costo=" + costo + "]";
	}
	

}
