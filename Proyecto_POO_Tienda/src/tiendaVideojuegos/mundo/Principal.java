package tiendaVideojuegos.mundo;

import java.util.ArrayList;

import mondgoDB.ConexionMongoDB;
import tiendaVideojuegos.mundo.Juegos.Genero;

public class Principal {
	static ArrayList<TiendaVideojuegos> tiendita = new ArrayList<TiendaVideojuegos>();

	public static void main(String[] args) {
		Principal main = new Principal();

		TiendaVideojuegos juego1 = new TiendaVideojuegos();
		juego1.nuevoJuego("Call of duty", 37465, Genero.Disparos, 30.5);

		TiendaVideojuegos juego2 = new TiendaVideojuegos();
		juego2.nuevoJuego("Left 4 Dead", 36412, Genero.Terror, 15);

		TiendaVideojuegos juego3 = new TiendaVideojuegos();
		juego3.nuevoJuego("Darksiders", 15698, Genero.Accion, 20);

		TiendaVideojuegos juego4 = new TiendaVideojuegos();
		juego4.nuevoJuego("FIFA 2021", 36942, Genero.Deportes, 50);

		TiendaVideojuegos juego5 = new TiendaVideojuegos();
		juego5.nuevoJuego("Five Nights at Freddy", 19684, Genero.Terror, 18);

		tiendita.add(juego1);
		tiendita.add(juego2);
		tiendita.add(juego3);
		tiendita.add(juego4);
		tiendita.add(juego5);
		
		main.guardarMongoDb();

	}

	public void guardarMongoDb() {
		ConexionMongoDB conexion = new ConexionMongoDB();
		conexion.ConexionMongoDB(tiendita);
	}

}
