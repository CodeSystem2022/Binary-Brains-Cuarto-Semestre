package UNT.datos;

import UNT.dominio.Estudiante;
import static UNT.conexion.Conexion.getConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import java.util.List;

public class EstudianteDAO {

    //Metodo Modificar estudiante
    public boolean modificarEstudiante(Estudiante estudiante){
        PreparedStatement ps;
        Connection con = getConnection();
        String sql = "UPDATE estudiantes2022 SET nombre=?, apellido=?, telefono=?, email=? WHERE id=?";
        try{
            ps = con.prepareStatement(sql);
            ps.setString(1, estudiante.getNombre());
            ps.setString(2, estudiante.getApellido());
            ps.setString(3, estudiante.getTelefono());
            ps.setString(4, estudiante.getEmail());
            ps.setInt(5, estudiante.getIdEstudiante());
            ps.execute();
             } catch (Exception e){
            System.out.println("Error al modificar el estudiante"+ e.getMessage());
        }
        finally{
            try{
                con.close();
            } catch (Exception e){
                System.out.println("Error al cerrar la conexion" + e.getMessage());
            }
        }
        return false;
    }

    //Metodo listar
    public List<Estudiante> listarEstudiantes() {
        List<Estudiante> estudiantes = new ArrayList<>();

        //Creamos algunos objetos ncesarios para comunicarnos con la bdd
        PreparedStatement ps; //Envía la sentencia a la bdd
        ResultSet rs; // Obtenemos el resultado de la bdd
        Connection con = getConnection();
        String sql = "SELECT * FROM estudiantes.estudiantes2022 ORDER BY id";
        try {
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                var estudiante = new Estudiante();
                estudiante.setIdEstudiante(rs.getInt("id"));
                estudiante.setNombre(rs.getString("nombre"));
                estudiante.setApellido(rs.getString("apellido"));
                estudiante.setEmail(rs.getString("email"));
                estudiante.setTelefono(rs.getString("telefono"));
                estudiantes.add(estudiante);
            }

        } catch (Exception e) {
            System.out.println("Ocurrio un error al seleccionar datos: " + e.getMessage());
        } finally {
            try {
                con.close();
            } catch (Exception e) {
                System.out.println("Ocurrio un error al cerrar la conexion " + e.getMessage());
            }
        }
        return estudiantes;
    }

    //Metodo buscar por id
    public boolean buscarEstudiantePorId(Estudiante estudiante) {
        PreparedStatement ps;
        ResultSet rs;
        Connection con = getConnection();
        String sql = "SELECT * FROM estudiantes2022 WHERE id=?";
        try {
            ps = con.prepareStatement(sql);
            ps.setInt(1, estudiante.getIdEstudiante());
            rs = ps.executeQuery();
            if (rs.next()) {
                estudiante.setNombre(rs.getString("nombre"));
                estudiante.setApellido(rs.getString("apellido"));
                estudiante.setTelefono(rs.getString("telefono"));
                estudiante.setEmail(rs.getString("email"));
                return true;
            }
        } catch (Exception e) {
            System.out.println("Ocurrió un error al buscar el estudiante: " + e.getMessage());
        } finally {
            try {
                con.close();
            } catch (Exception e) {
                System.out.println("Ocurrió un error al cerrar la conexión: " + e.getMessage());
            }
        }
        return false;
    }

    // Método agregar nuevo estudiante
    public boolean agregarEstudiante(Estudiante estudiante) {
        PreparedStatement ps;
        Connection con = getConnection();
        String sql = "INSERT INTO estudiantes2022 (nombre, apellido, telefono, email) VALUES (?,?,?,?)";
        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, estudiante.getNombre());
            ps.setString(2, estudiante.getApellido());
            ps.setString(3, estudiante.getTelefono());
            ps.setString(4, estudiante.getEmail());
            ps.executeUpdate(); // Ejecutar la inserción en la base de datos
            return true; // El estudiante se agregó correctamente
        } catch (Exception e) {
            System.out.println("Ocurrió un error al agregar estudiante: " + e.getMessage());
            return false; // El estudiante no se pudo agregar
        } finally {
            try {
                con.close();
            } catch (Exception e) {
                System.out.println("Error al cerrar la conexión: " + e.getMessage());
            }
        }
    }

    // Método para eliminar estudiante

    public boolean eliminarEstudiante(Estudiante estudiante){
        PreparedStatement ps;
        Connection con = getConnection();
        String sql = "DELETE FROM estudiantes2022 WHERE id=?";
        try {
            ps = con.prepareStatement(sql);
            ps.setInt(1, estudiante.getIdEstudiante());
            ps.execute();
            return true;
        } catch (Exception e){
            System.out.println("Error al eliminar estudiante: "+ e.getMessage());
        }
        finally{
            try {
                con.close();
            } catch (Exception e) {
                System.out.println("Error al cerrar la conexion: "+e.getMessage());
            }
        }
        return false;
    }

    public static void main(String[] args) {
        var estudianteDao = new EstudianteDAO();

        // Modificar estudiante
        var estudianteModificado = new Estudiante(2,"Alejandra", "costas", "alecostas@gmail.com", "8456156");
        var modificado = estudianteDao.modificarEstudiante(estudianteModificado);
        if (modificado)
            System.out.println("Estudiante modificado" + estudianteModificado);
        else
            System.out.println("No se modifico estudiante" + estudianteModificado);


        // Agregar estudiante
        var nuevoEstudiante = new Estudiante (0,"Carlos", "Lara", "2457863", "carloslara@gmail.com");
        var agregado = estudianteDao.agregarEstudiante(nuevoEstudiante);
        if (agregado)
            System.out.println("Estudiante agregado" + nuevoEstudiante);
        else
            System.out.println("No se agrego estudiante" + nuevoEstudiante);

        // Eliminar estudiante con id 3
        var estudianteEliminar = new Estudiante(3);
        var eliminado = estudianteDao.eliminarEstudiante(estudianteEliminar);
        if(eliminado)
            System.out.println("Estudiante eliminado: "+ estudianteEliminar);
        else
            System.out.println("No se elimino estudiante: "+estudianteEliminar);

        //Listar estudiantes

        System.out.println("Listado de estudiantes: ");
        List<Estudiante> estudiantes = estudianteDao.listarEstudiantes();
        estudiantes.forEach(System.out::println);

        //Buscar por ID
        var estudiante10 = new Estudiante(10, "", "", "", "");
        System.out.println("Estudiantes antes de la busqueda" +estudiante10);
        var encontrado = estudianteDao.buscarEstudiantePorId(estudiante10);
        if (encontrado)
            System.out.println("Estudiante encontrado: " + estudiante10);
        else
            System.out.println("No se encontro el estudiante"+ estudiante10.getIdEstudiante());
    }
}

// Morales María Rosa