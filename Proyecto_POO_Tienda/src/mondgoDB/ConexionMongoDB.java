package mondgoDB;

import java.util.ArrayList;

import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.MongoClient;

import tiendaVideojuegos.mundo.TiendaVideojuegos;

public class ConexionMongoDB {

	public void ConexionMongoDB(ArrayList<TiendaVideojuegos> tiendita) {
		try {
			MongoClient mongoClient = new MongoClient("localhost", 27017);
			DB db = mongoClient.getDB("Tienda_de_VideoJuegos");
			DBCollection coll = db.getCollection("Juegos");
			System.out.println("Conexion Exitosa ");

			for (TiendaVideojuegos tiendaVideojuegos : tiendita) {
				coll.insert(tiendaVideojuegos.toDBObjectTiendaVideojuegos());
			}

			mongoClient.close();
			System.out.println("Datos guardados de manera exitosa");
		} catch (Exception e) {
			System.out.println("Error al conectar al Server MongoDB");
		}
	}

}
