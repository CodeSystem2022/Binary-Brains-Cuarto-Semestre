import UNT.datos.EstudianteDAO;
import UNT.dominio.Estudiante;

import java.util.Scanner;

public class SistemaEstudiantesApp {
    public static void main(String[] args) {
        var salir = false;
        var consola = new Scanner(System.in);
        var estudianteDao= new EstudianteDao();
        while(!salir){
            try{
                mostrarMenu();
                salir = ejecutarOpciones(consola, estudianteDao);
            } catch(Exception e){
                System.out.println("Ocurrio un error al ejecutar la operacion "+ e.getMessage());
            }
        }
    }
}

private static void mostrarMenu(){
    System.out.println("""
            ******* Sistema de Estudiantes *******
            1. Listar Estudiantes
            2. Buscar Estudiantes
            3. Agregar Estudiante
            4. Modificar Estudiante
            5. Eliminar Estudiante
            6. Salir
            Elige una opcion: 
            """);
}

private static boolean ejecutarOpciones(Scanner consola, EstudianteDao estudianteDao){
    var opcion = Integer.parseInt(consola.nextLine());
    var salir = false;
    switch(opcion){
        case 1 -> {
            System.out.println("Listado de estudiantes...");
            var estudiantes =estudianteDao.listarEstudiantes();
            estudiantes.forEach(System.out::println);
        }
        case 2 -> {
            System.out.println("Introduce el id_estudiante a buscar: ");
            var id = Integer.parseInt(consola.nextLine());
            var estudiante = new Estudiante(id);
            var encontrado= estudianteDao.buscarEstudiantePorId(estudiante);
            if (encontrado)
                System.out.println("Estudiante encontrado: "+estudiante);
            else
                System.out.println("Estudiante no encontrado: "+estudiante);
        }

        case 3 -> {
            System.out.println("Ingresa el nombre del estudiante que desees agregar: ");
            var nombre = consola.nextLine();
            System.out.println(" Ingrese el apellido: ");
            var apellido = consola.nextLine();
            System.out.println("Telefono: ");
            var telefono = consola.nextLine();
            System.out.println("Email: ");
            var email = consola.nextLine();
            //crear objeto estudiante sin id
            var estudiante = new Estudiante (nombre, apellido, telefono, email);
            var agregado = estudianteDao.agregarEstudiante(estudiante);
            if (agregado)
                System.out.println("Estudiante agregado: "+estudiante);
            else
                System.out.println("Estudiante NO agregado: "+estudiante);
        }
        case 4-> {
            System.out.println("Modificar estudiante: ");
            System.out.println("Id estudiante: ");
            var id =Integer.parseInt(consola.nextLine());
            System.out.println("Nombre: ");
            var nombre = consola.nextLine();
            System.out.println("Apellido: ");
            var apellido = consola.nextLine();
            System.out.println("Telefono: ");
            var telefono = consola.nextLine();
            System.out.println("Email: ");
            var email = consola.nextLine();
            //crear objeto estudiante a modificar
            var estudiante = new Estudiante (id, nombre, apellido, telefono, email);
            var modificado = estudianteDao.modificarEstudiante(estudiante);
            if(modificado)
                System.out.println("Estudiante modificado: "+estudiante);
            else System.out.println("Estudiante no modificado: "+estudiante);
        }
        case 5 -> {
            System.out.println("Eliminar estudiante: ");
            System.out.println("Id estudiante: ");
            var id =Integer.parseInt(consola.nextLine());
            //crear objeto estudiante a eliminar
            var estudiante = new Estudiante (id);
            var eliminado = estudianteDao.eliminarEstudiante(estudiante);
            if(eliminado)
                System.out.println("Estudiante eliminado: "+estudiante);
            else System.out.println("Estudiante no eliminado: "+estudiante);

        }
        case 6 -> {
            System.out.println("Hasta pronto!!");
            salir=true;
        }
        default-> System.out.println("Opcion no reconocida, ingrese de nuevo: ");
    }
    return salir;
}