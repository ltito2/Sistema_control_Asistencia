package TareaJPA.modelo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
public class Docente {
	
	@Id
	@Column(name="Doc_Id")
	private int id;
	
	@NotNull
	@Size(min=10, max=10)
	@Column(name="Doc_Cedula")
	private String cedula;
	
	@NotNull
	@Size(min=3, max=40)
	@Column(name="Doc_Nombre")
	private String nombre;
	
	@NotNull
	@Size(min=3, max=40)
	@Column(name="Doc_Apellido")
	private String apellido;
	
	@NotNull
	@Size(min=3, max=40)
	@Column(name="Doc_Direccion")
	private String direccion;
	
	@NotNull
	@Size(min=9, max=10)
	@Column(name="Doc_Telefono")
	private String telefono;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCedula() {
		return cedula;
	}

	public void setCedula(String cedula) {
		this.cedula = cedula;
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

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	@Override
	public String toString() {
		return "Docente [id=" + id + ", cedula=" + cedula + ", nombre=" + nombre + ", apellido=" + apellido
				+ ", direccion=" + direccion + ", telefono=" + telefono + "]";
	}
	
	
	
}
