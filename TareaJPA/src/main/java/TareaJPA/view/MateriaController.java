package TareaJPA.view;

import java.util.List;



import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;

import TareaJPA.bussiness.GestionMateriaON;
import TareaJPA.bussiness.Instalacion;
import TareaJPA.modelo.Estudiante;
import TareaJPA.modelo.Materia;
import TareaJPA.modelo.TipoMateria;

@ManagedBean
@ViewScoped
public class MateriaController {
	
	private Materia materia;

	@Inject
	private Instalacion inON;
	
	@Inject
	private GestionMateriaON matON;
	
	@Inject
	private FacesContext fc;
	
	@PostConstruct
	public void init() {
		materia = new Materia();
		
	}
	
	public Materia getMateria() {
		return materia;
	}

	public void setMateria(Materia materia) {
		this.materia = materia;
	}
	
	public String guardarDatos() {
		matON.guardarMateria(materia);
		return "listado";
	}
	
	public void consultarTipoMateria() {
		
		List<TipoMateria> tipos = inON.getMaterias();
		for(TipoMateria tipo: tipos ) {
			if(materia.getIdTipo() == tipo.getCodigo())
				materia.setTipo(tipo);
		}
		
	}
	
	public void consultarAlumno() {
		
		Estudiante e;
		try {
			e = matON.consultarAlumno(materia.getIdEstudianteTemp());
			materia.setEstudiante(e);
		} catch (Exception e1) {
			materia.setEstudiante(null);
			FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_ERROR, e1.getMessage(), "Error");
			fc.addMessage(null, msg);
			e1.printStackTrace();
		}
		
	}

}
