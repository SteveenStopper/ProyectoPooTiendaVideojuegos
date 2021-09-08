package mundo.ConexionMongoDB;


import java.util.ArrayList;

import javax.swing.JOptionPane;

import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.MongoClient;

import mundo.TiendaVideojuegos.Login;

public class ConexionUsuarioMongoDB {
	
	public static ArrayList<Login> loge = new ArrayList<Login>();
	public static DBCollection coll;
	private DB db;
	
	public void UsuarioAdmin (Login log) {	
		try {
			MongoClient mongoClient = new MongoClient("localhost", 27017);
			db = mongoClient.getDB("Tienda_de_VideoJuegos");
			coll = db.getCollection("Login");
			System.out.println("Conexion Exitosa");
			
			loge. add(log);
			
			for (Login login : loge) {
				coll.insert(login.toDBObjectLogin());
			}
				
			mongoClient.close();
			
		} catch(Exception ex) {
			System.out.println("Error al conectar al server de Mongo: " + ex.getMessage());
		}
	}
	
	public void comparacionDatos() {
		MongoClient mongoClient = new MongoClient("localhost", 27017);
		db = mongoClient.getDB("Tienda_de_VideoJuegos");
		coll = db.getCollection("Login");
		System.out.println("Conexion Exitosa");
		
		
		mongoClient.close();
		
	}
}
