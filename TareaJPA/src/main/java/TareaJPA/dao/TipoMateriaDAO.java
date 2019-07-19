package TareaJPA.dao;

import java.util.List;


import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.Query;

import TareaJPA.modelo.TipoMateria;


@Stateless
public class TipoMateriaDAO {
	
	@Inject
	private EntityManager em;
	
	public void insert(TipoMateria tipo) {
		em.persist(tipo);
	}
	
	public List<TipoMateria> getTiposMateria(){
		String jpql = "SELECT tm  FROM TipoMateria tm ";
		
		Query q = em.createQuery(jpql, TipoMateria.class);
		
		List<TipoMateria> tipos = q.getResultList();
		return tipos;
	}
}
