package TareaJPA.bussiness;

import javax.ejb.Stateless;

import javax.inject.Inject;
import javax.persistence.EntityManager;

import TareaJPA.dao.EstudianteDAO;
import TareaJPA.modelo.Estudiante;
import TareaJPA.modelo.Materia;


@Stateless
public class GestionMateriaON {
	
	@Inject
	private EstudianteDAO daoEstudiante;
	
	@Inject
	private EntityManager em;
	
	public void guardarMateria(Materia materia) {
		em.persist(materia);
	}
	
	public Estudiante consultarAlumno(int codigoEstudiante) throws Exception {
		Estudiante e = daoEstudiante.read(codigoEstudiante);
		if(e == null)
			throw new Exception("Estudiante no Existe");
		return e;
	}

}
