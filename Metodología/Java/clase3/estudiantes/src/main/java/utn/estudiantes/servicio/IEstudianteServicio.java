package utn.estudiantes.servicio;

public interface IEstudianteServicio {
    public List<Estudiante> listarEstudiantes();
    public Estudiante buscarEstudiantePorId(Integer IdEstudiante);
    public void guardarEsudiante(Estudiante estudiante);
    public void eliminarEstudiante(Estudiante estudiante);

}
