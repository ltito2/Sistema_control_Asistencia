package TareaJPA.dao;

import java.util.List;


import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.Query;

import TareaJPA.modelo.Estudiante;


@Stateless
public class EstudianteDAO {
	
	@Inject
	private EntityManager em;
	
	public void save(Estudiante e) {
		if(this.read(e.getCodigo())!= null)
			this.update(e);
		else
			this.create(e);
	}
	
	public void create(Estudiante e) {
		em.persist(e);
		
	}
	
	public Estudiante read(int id) {
		return em.find(Estudiante.class, id);
	}
	
	/*Opcion 1 de demanda para relacion lazy*/
	public Estudiante read2(int id) {
		Estudiante a = em.find(Estudiante.class, id);
		a.getMaterias().size();
		return a;
	}
	
	public Estudiante read3(int id) {
		String jpql = "SELECT e FROM Estudiante e "
					+ " JOIN FETCH e.materias m "
					+ " WHERE e.codigo = :codigo";
		
		Query q = em.createQuery(jpql, Estudiante.class);
		q.setParameter("codigo", id);
		Estudiante e = (Estudiante) q.getSingleResult();
		
		return e;
	}
	
	public void update(Estudiante e) {
		em.merge(e);
	}
	
	public void delete(int id) {
		Estudiante e = read(id);
		em.remove(e);
		
	}
	
	public List<Estudiante> getEstudiantes(){
		String jpql = "SELECT e  FROM Estudiante e ";
		
		Query q = em.createQuery(jpql, Estudiante.class);
		
		List<Estudiante> estudiantes = q.getResultList();
		return estudiantes;
	}
	
	public List<Estudiante> getEstudiantes2(){
		String jpql = "SELECT e  FROM Estudiante e ";
		
		Query q = em.createQuery(jpql, Estudiante.class);
		
		List<Estudiante> estudiantes = q.getResultList();
		for(Estudiante e: estudiantes) {
			e.getMaterias().size();
		}
		return estudiantes;
	}
	
	public List<Estudiante> getEstudiantesPorNombre(String filtroBusqueda){
		String jpql = "SELECT e  FROM Estudiante e "
				    + " WHERE e.nombre LIKE :filtro ";
		
		Query q = em.createQuery(jpql, Estudiante.class);
		q.setParameter("filtro", "%"+filtroBusqueda+"%");
		
		List<Estudiante> estudiantes = q.getResultList();
		return estudiantes;
	}


}
