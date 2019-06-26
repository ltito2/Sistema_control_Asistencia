package TareaJPA.bussiness;

import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;

import TareaJPA.dao.DocenteDAO;
import TareaJPA.modelo.Docente;

@Stateless
public class DocenteON {

	@Inject
	private DocenteDAO dao;
	
	public void guardar(Docente d) throws Exception {
		if (d.getNombre().length() < 5)
			throw new Exception("Dimensión Corta");
			
		dao.save(d);
	}
	
	public List<Docente> getListadoDocente(){
		return dao.getDocente();
	}
	
	public List<Docente> getListadoDocenteNombre(String nombre){
		return dao.getBusquedaDocente(nombre);
	}
	
	public void borrar(int codigo ) throws Exception {
		try {
			dao.delete(codigo);
		} catch (Exception  e) {
			throw new  Exception("Error al borrar "+e.getMessage());
		}
	}

public Docente getDocente(int codigo) {
	Docente aux=dao.read(codigo);
	return aux;
 }
}
