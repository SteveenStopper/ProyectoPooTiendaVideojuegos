package mundo.ConexionMongoDB;

import java.util.ArrayList;
import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.DBObject;
import com.mongodb.MongoClient;
import mundo.TiendaVideojuegos.Juegos;
import mundo.TiendaVideojuegos.TiendaVideojuegos;

public class ConexionMongoDB {
	
	private TiendaVideojuegos tienda = new TiendaVideojuegos();
	public static DBCollection coll;
	private DB db;
	
	public void ConexionMongoDB(Juegos juego) {
		
		ArrayList<TiendaVideojuegos> tiendita = new ArrayList<TiendaVideojuegos>();
		
		try {
			//Conectar con DB
			MongoClient mongoClient = new MongoClient("localhost", 27017);
			db = mongoClient.getDB("Tienda_de_VideoJuegos");
			coll = db.getCollection("Juegos");
			System.out.println("Conexion Exitosa ");
			
			//Crear BD
			tienda.nuevoJuego(juego.getNombre(), juego.getCodigo(), juego.getGenero(), juego.getCosto());
			tiendita.add(tienda);
			
			for (TiendaVideojuegos tiendaVideojuegos : tiendita) {
				coll.insert(tiendaVideojuegos.toDBObjectTiendaVideojuegos());
			}
			
			//Leer BD
			DBCursor cursor = coll.find();
			try {
				while (cursor.hasNext()) {
					System.out.println(cursor.next().toString());
				}
			} finally {
				cursor.close();
			}
			
			mongoClient.close();
			System.out.println("Datos guardados de manera exitosa");
		} catch (Exception e) {
			System.out.println("Error al conectar al Server MongoDB");
		}
		
	}
	
	//Borrar DB
	public void deleteDB(String juego) {
		MongoClient mongo = new MongoClient("localhost", 27017);
		db = mongo.getDB("Tienda_de_VideoJuegos");
		coll = db.getCollection("Juegos");
		
		DBObject findDoc = new BasicDBObject("Nombre", juego);
		coll.remove(findDoc);
		
		mongo.close();
	}
	
	//Update DB
	public void updateBD(String juego, int num) {
		MongoClient mongo = new MongoClient("localhost", 27017);
		db = mongo.getDB("Tienda_de_VideoJuegos");
		coll = db.getCollection("Juegos");
		
		BasicDBObject update = new BasicDBObject();
		update.append("$set", new BasicDBObject().append("# Key's", num));
		BasicDBObject buscarNombreBD = new BasicDBObject();
		buscarNombreBD.append("Nombre", juego);
		coll.update(buscarNombreBD, update);
		
		mongo.close();
	}
	
}
