package TareaJPA.modelo;

import javax.persistence.Entity;

import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Transient;

//import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Materia {
	
	@Id
	private int codigo;
	private String nMateria;
	
	//combobox
	@Transient
	private int selectMateria;
	
	@OneToOne
	@JoinColumn(name="tipo_materia")
	//@JsonIgnore
	private TipoMateria tipo;
	
	//Asociacion - bidireccionalidad
	@OneToOne
	@JoinColumn(name="alum_codigo")
	//@JsonIgnore
	private Estudiante alumno;
	
	@Transient
	private int idTipo;
	
	@Transient
	private int idAlumnoTemp;
	
	public int getCodigo() {
		return codigo;
	}
	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}
	public String getnMateria() {
		return nMateria;
	}
	public void setnMateria(String nMateria) {
		this.nMateria = nMateria;
	}
	
	public TipoMateria getTipo() {
		return tipo;
	}
	
	public void setTipo(TipoMateria tipo) {
		this.tipo = tipo;
	}
	
	public Estudiante getAlumno() {
		return alumno;
	}
	
	public void setAlumno(Estudiante alumno) {
		this.alumno = alumno;
	}
	
	public int getIdAlumnoTemp() {
		return idAlumnoTemp;
	}
	public void setIdAlumnoTemp(int idAlumnoTemp) {
		this.idAlumnoTemp = idAlumnoTemp;
	}
	/*Propiedad temporal*/
	public int getIdTipo() {
		return idTipo;
	}
	
	public void setIdTipo(int idTipo) {
		this.idTipo = idTipo;
	}
	
	//combobox
	public int getSelectMateria() {
		return selectMateria;
	}
	
	public void setSelectMateria(int selectMateria) {
		this.selectMateria = selectMateria;
	}
	
	@Override
	public String toString() {
		return "Materia [codigo=" + codigo + ", nMateria=" + nMateria + ", tipo=" + tipo + ", idTipo=" + idTipo + "]";
	}
	
	
}
