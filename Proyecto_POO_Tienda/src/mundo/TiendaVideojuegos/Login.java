package mundo.TiendaVideojuegos;

import com.mongodb.BasicDBObject;

public class Login {
	private String nombre;
	private String apellido;
	private String email;
	private String password;

	public Login(String nombre, String apellido, String email, String password) {
		this.nombre = nombre;
		this.apellido = apellido;
		this.email = email;
		this.password = password;
	}
	
	public BasicDBObject toDBObjectLogin() {
		BasicDBObject dBObjectLogin = new BasicDBObject();
		dBObjectLogin.append("Nombre", this.getNombre());
		dBObjectLogin.append("Apellido", this.getApellido());
		dBObjectLogin.append("Email", this.getEmail());
		dBObjectLogin.append("Password", this.getPassword());
		return dBObjectLogin;
	}
	
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getApellido() {
		return apellido;
	}
	public void setApellido(String apellido) {
		this.apellido = apellido;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String toString() {
		return "Login [nombre=" + nombre + ", apellido=" + apellido + ", email=" + email + ", password=" + password + "]";
	}
	
	
	
	
}
