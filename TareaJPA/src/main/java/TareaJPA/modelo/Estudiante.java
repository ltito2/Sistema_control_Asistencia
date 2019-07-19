package TareaJPA.modelo;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
public class Estudiante {
	
	@Id
	@Column(name="est_codigo")
	private int codigo;
	
	@NotNull
	@Column(name="est_nombre")
	@Size(min = 3, max = 25)
	private String nombre;
	
	@NotNull
	@Column(name="est_apellido")
	@Size(min = 3, max = 25)
	private String apellido;
	
	@NotNull
	@Column(name="est_cedula")
	//@Size(min = 3, max = 25)
	private String cedula;
	
	/*@NotNull
    @Size(min = 9, max = 10)
    @Digits(fraction = 0, integer = 10)*/
	@Column(name = "est_telefonor")
	private String telefono;
    
	/*@NotNull
	@NotEmpty
	@Email*/
	@Column(name="est_email")
	private String email;
		
	@NotNull
	@Column(name="est_direccion")
	@Size(min = 3, max = 75)
	private String direccion;

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JoinColumn(name="est_codigo")
	private List<Materia> materias;
	
	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
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

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public String getCedula() {
		return cedula;
	}

	public void setCedula(String cedula) {
		this.cedula = cedula;
	}
	
	public List<Materia> getMaterias() {
		return materias;
	}

	public void setMaterias(List<Materia> materias) {
		this.materias = materias;
	}

	
	public void addMateria(Materia mat) {
		if(materias==null) {
			materias = new ArrayList<>();
		}
		this.materias.add(mat);
	}

}
