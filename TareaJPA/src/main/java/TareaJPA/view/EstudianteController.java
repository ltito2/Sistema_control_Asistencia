package TareaJPA.view;

import java.util.ArrayList;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.SessionScoped;
import javax.faces.bean.ViewScoped;
import javax.inject.Inject;

import TareaJPA.bussiness.EstudianteON;
import TareaJPA.bussiness.Instalacion;
import TareaJPA.modelo.Estudiante;
import TareaJPA.modelo.Materia;
import TareaJPA.modelo.TipoMateria;


@ManagedBean
@ViewScoped
public class EstudianteController {
	
	private Estudiante estudiante = new Estudiante();
	
	//Combobox
	private TipoMateria tipMa = new TipoMateria();
	private List<TipoMateria> tipoMat;
	private List<String> listaMat;
	
	private List<Estudiante> listadoEstudiantes;
	
	private List<Estudiante> listadoFiltro;
	
	private int id;
			
	@Inject
	private EstudianteON eON;
	
	@Inject
	private Instalacion iON;
	
	/*@Inject
	private OperacionesAS opeAS;*/
	
	@PostConstruct
	public void init() {
		estudiante = new Estudiante();
		estudiante.addMateria(new Materia());
		listadoEstudiantes = eON.getListadoEstudiantes();
		//listadoFiltro = aON.getFiltroAlumnos(nombre);
	}
	
	public void loadData() {
		System.out.println("Codigo editar " + id);
		if(id==0)
			return;
		estudiante = eON.getEstudiante(id);
		System.out.println(estudiante.getCodigo() + " " + estudiante.getNombre());
		System.out.println("# Materias " + estudiante.getMaterias().size());
		
		for(Materia m : estudiante.getMaterias()) {
			System.out.println("\t"+m);
		}
		
	}
	
	public Estudiante getEstudiante() {
		return estudiante;
	}

	public void setEstudiante(Estudiante estudiante) {
		this.estudiante = estudiante;
	}

	public List<Estudiante> getListadoEstudiantes() {
		return listadoEstudiantes;
	}

	public void setListadoEstudiantes(List<Estudiante> listadoEstudiantes) {
		this.listadoEstudiantes = listadoEstudiantes;
	}

	public List<Estudiante> getListadoFiltro() {
		return listadoFiltro;
	}

	public void setListadoFiltro(List<Estudiante> listadoFiltro) {
		this.listadoFiltro = listadoFiltro;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
	public TipoMateria getTipMa() {
		return tipMa;
	}

	public void setTipMa(TipoMateria tipMa) {
		this.tipMa = tipMa;
	}

	public List<TipoMateria> getTipoMat() {
		return tipoMat;
	}

	public void setTipoMat(List<TipoMateria> tipoMat) {
		this.tipoMat = tipoMat;
	}

	public List<String> getListaMat() {
		return listaMat;
	}

	public void setListaMat(List<String> listaMat) {
		this.listaMat = listaMat;
	}

	//Carga la informacion 
	public String cargarDatos() {
		try {
			eON.guardar(estudiante);
			init();
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	//Filtrado por nombre
	public String filtrarAlumnos() {
		System.out.println("Filtro " + estudiante.getNombre());
		eON.getListarFiltroEstudiantes(estudiante.getNombre());
		listadoFiltro = eON.getListarFiltroEstudiantes(estudiante.getNombre());
		return null;
	}
	
	public String editar(int codigo) {
		/*System.out.println("Codigo editar " + codigo);
		alumno = aON.getAlumno(codigo);
		System.out.println(alumno.getCodigo() + " " + alumno.getNombre());
		System.out.println("# Materias " + alumno.getMaterias().size());*/
		return "formulario?faces-redirect=true&id="+codigo;
	}
	
	public String borrar(int codigo) {
		System.out.println("Codigo borrar " + codigo);
		try {
			eON.borrar(codigo);
			init();
		} catch (Exception e) {
			System.out.println("Error " + e.getMessage());
			e.printStackTrace();
		}
		return null;
	}
	
	//Metodo para agregar materias
	public void addMateria() {
		estudiante.addMateria(new Materia());
		System.out.println("cnt " + estudiante.getMaterias().size());
	}
	
	//Borrar los datos de pantalla
	public String nuevo() {
		estudiante = new Estudiante();
		return "formulario";
	}
	
	//Combobox
	/*public List<String> Mat1(){
		tipoMat = iON.getMaterias();
		List<String> lista = new ArrayList<>();
		
		for(TipoMateria tm1: tipoMat) {
			lista.add(tm1.getTipoNombre());
		}
		return lista;
	}*/
	
	/*public void listarAS() {
		opeAS.listarAlumnos();
	}*/

}
