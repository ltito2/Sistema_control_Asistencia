package TareaJPA.modelo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class TipoMateria {
	
	@Id
	@GeneratedValue
	private int codigo;
	private String tipoNombre;
	
	public int getCodigo() {
		return codigo;
	}
	
	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}
	
	public String getTipoNombre() {
		return tipoNombre;
	}
	
	public void setTipoNombre(String tipoNombre) {
		this.tipoNombre = tipoNombre;
	}

	@Override
	public String toString() {
		return "TipoMateria [codigo=" + codigo + ", tipoNombre=" + tipoNombre + "]";
	}
	
	

}
