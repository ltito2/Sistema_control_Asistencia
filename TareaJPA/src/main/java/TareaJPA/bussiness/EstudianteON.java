package TareaJPA.bussiness;

import java.util.List;


import javax.ejb.Stateless;
import javax.inject.Inject;

import TareaJPA.dao.EstudianteDAO;
import TareaJPA.modelo.Estudiante;
import TareaJPA.modelo.Materia;
import TareaJPA.modelo.TipoMateria;


@Stateless
public class EstudianteON {
	
	@Inject
	private Instalacion init;
	
	@Inject
	private EstudianteDAO dao;
	
	//Guardar 
	public void guardar(Estudiante e) { //throws Exception {
		/*if(a.getNombre().length()<5)
			throw new Exception("Dimension Corta");*/
	
		List<TipoMateria> tipos = init.getMaterias();
	
		for(Materia mat : e.getMaterias()) {
			for(TipoMateria tm : tipos) {
				if(mat.getIdTipo() == tm.getCodigo())
					mat.setTipo(tm);
			}
		}
		
		dao.save(e);
		System.out.println(e);
		
	}
	
	//Listar
	public List<Estudiante> getListadoEstudiantes(){
		return dao.getEstudiantes2();
	}
	
	//Filtrado
	public List<Estudiante> getListarFiltroEstudiantes(String nombre){
		return dao.getEstudiantesPorNombre(nombre);
	}
		
	//Eliminar
	public void borrar(int codigo) throws Exception {
		try {
			dao.delete(codigo);
		} catch (Exception e) {
			throw new Exception("Error al borrar " + e.getMessage());
		}
	}
	
	//Editar
	public Estudiante getEstudiante(int codigo) {
		Estudiante aux = dao.read3(codigo);
		System.out.println(aux);
		return aux;
	}
	
	
}
