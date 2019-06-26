package TareaJPA.dao;

import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.Query;

import TareaJPA.modelo.Docente;

@Stateless
public class DocenteDAO {

	@Inject
	private EntityManager em;
	
	public void save(Docente d) {
		if (this.read(d.getId())!=null) {
			this.update(d);
		}else {
			this.create(d);
		}
	}
	
	public void create(Docente d) {
		em.persist(d);
	}
	
	public Docente read(int id) {
		return em.find(Docente.class, id);
	}
	
	public void update(Docente d) {
		em.merge(d);
	}
	
	public void delete(int id) {
		Docente d=read(id);
		em.remove(d);
	}
	
	public List<Docente> getDocente(){
		String jpql="SELECT d FROM Docente d";
		Query q=em.createQuery(jpql, Docente.class);
		
		List<Docente> docentes=q.getResultList();
		return docentes;
	}
	
	public List<Docente> getBusquedaDocente(String filBusqueda){
		String jpql="SELECT d FROM Docente d "
				    +" WHERE d.nombre LIKE :filtro ";
		Query q=em.createQuery(jpql, Docente.class);
		q.setParameter("filtro", "%"+filBusqueda+"%");
		
		List<Docente> docentes=q.getResultList();
		System.out.println(docentes);
		return docentes;
	}
}
