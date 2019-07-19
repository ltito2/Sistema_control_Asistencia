package TareaJPA.bussiness;

import java.util.List;


import javax.annotation.PostConstruct;
import javax.ejb.Singleton;
import javax.ejb.Startup;
import javax.inject.Inject;

import TareaJPA.dao.TipoMateriaDAO;
import TareaJPA.modelo.TipoMateria;


@Startup
@Singleton
public class Instalacion {
	
	@Inject
	private TipoMateriaDAO dao;
	
	private List<TipoMateria> materias;
	
	@PostConstruct
	public void init() {
		
		System.out.println("Se inicializo");
		
		materias = dao.getTiposMateria();
		if(materias.size()==0) {
			TipoMateria tm = new TipoMateria();
			tm.setTipoNombre("Presencial");
			dao.insert(tm);
			
			TipoMateria tm1 = new TipoMateria();
			tm1.setTipoNombre("Paracademica");
			dao.insert(tm1);
			
			materias = dao.getTiposMateria();
		}
	}

	public List<TipoMateria> getMaterias() {
		return materias;
	}
	

}
