package beans;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component("contact")
@Scope("prototype")
public class Contacto {

	private String nombre;
	private String apellidoPaterno;
	private String apellidoMaterno;
	private String direccion;
	private int telefono;
	private int id;
	
	public Contacto(String nombre, String apellidoPaterno, String apellidoMaterno, String direccion, int telefono, int id) {
		super();
		this.nombre = nombre;
		this.apellidoPaterno = apellidoPaterno;
		this.apellidoMaterno = apellidoMaterno;
		this.direccion = direccion;
		this.telefono = telefono;
		this.id = id;
	}

	public Contacto() {
		super();
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellidoPaterno() {
		return apellidoPaterno;
	}

	public void setApellidoPaterno(String apellidoPaterno) {
		this.apellidoPaterno = apellidoPaterno;
	}

	public String getApellidoMaterno() {
		return apellidoMaterno;
	}

	public void setApellidoMaterno(String apellidoMaterno) {
		this.apellidoMaterno = apellidoMaterno;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public int getTelefono() {
		return telefono;
	}

	public void setTelefono(int telefono) {
		this.telefono = telefono;
	}

	@Override
	public String toString() {
		return "Contacto [nombre=" + nombre + ", apellidoPaterno=" + apellidoPaterno + ", apellidoMaterno="
				+ apellidoMaterno + ", direccion=" + direccion + ", telefono=" + telefono + "]";
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
	
	
}
