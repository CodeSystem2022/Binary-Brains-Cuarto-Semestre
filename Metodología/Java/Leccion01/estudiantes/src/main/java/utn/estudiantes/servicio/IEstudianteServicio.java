package utn.estudiantes.servicio;
import utn.estudiantes.modelo.Estudiante;
import java.util.List;
public interface IEstudianteServicio {
    public List<Estudiante> listarestudiantes();
    public Estudiante buscarEstudiantePorId(Integer estudiante);
    public void guardarEstudiante(Estudiante estudiante);
    public void eliminarEstudiante(Estudiante estudiante);

}
