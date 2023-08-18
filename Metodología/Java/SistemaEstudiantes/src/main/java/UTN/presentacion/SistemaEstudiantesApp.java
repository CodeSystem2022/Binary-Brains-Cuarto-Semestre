package UTN.presentacion;

import UTN.conexion.Conexion;
import UTN.datos.EstudianteDao;
import UTN.dominio.Estudiante;

import java.util.Scanner;

public class SistemaEstudiantesApp {
    public static void main(String[] args) {
        var salir = false;
        var consola = new Scanner(System.in);//Para leer informacion de la consola
        //Se crea una instancia de la clase servicio, esto lo hacemos fuera del ciclo
        var estudianteDao = new EstudianteDao();//esta instancia debe hacerse una vez
        while(!salir){
            try{
                mostrarMenu(); //Este sera el metodo que devolvera un booleano
                salir = ejecutarOpciones(consola, estudianteDao);//Este arroja una exception
            } catch (Exception e){
                System.out.println("Ocurrio un error al ejecutar la operacion: "+e.getMessage());
            }
        }//Fin while
    } //Fin Main

    private static void mostrarMenu(){
        System.out.println("""
                   *** Sistema de Estudiantes ***
                   1. Listar estudiantes
                   2. Buscar estudiante
                   3. Agregar estudiante
                   4. Modificar estudiante
                   5. Eliminar estudiante
                   6. Salir
                   Elige una opción:
                   """);
    }
    //Metodo para ejecutar las opciones, va a regresar un valor booleano, ya que es el que
    //puede modificar el valor de la variable salir, si es verdadero termina el ciclo while.
    private static boolean ejecutarOpciones(Scanner consola, EstudianteDao estudianteDAO){
        var opcion = Integer.parseInt(consola.nextLine());
        var salir = false;
        switch (opcion){
            case 1 -> {//Listar estudiantes
                System.out.println("Listado de Estudiantes...");
                //no muestra la informacion, solo recupera la info y regresa una lista
                var estudiantes = estudianteDAO.listarEstudiante();//recibe el listado
                //vamos a iterar cada objeto de tipo estudiante
                estudiantes.forEach(System.out::println);//para imprimir la lista
                }//Fin caso 1
            case 2 ->{//Buscar estudiante por id
                System.out.println("Introduce el id_estudiante a buscar: ");
                var idEstudiante = Integer.parseInt(consola.nextLine());
                var estudiante = new Estudiante(idEstudiante);
                var encontrado = estudianteDAO.buscarEstudiantePorId(estudiante);
                if(encontrado)
                    System.out.println("Estudiante encontrador: "+estudiante);
                else
                    System.out.println("Estudiante no encontrado: "+estudiante);
            }//Fin caso 2

            case 3 ->{//Agregar estudiante
                System.out.println("Agregar estudiante: ");
                System.out.println("Nombre: ");
                var nombre = consola.nextLine();
                System.out.println("Apellido: ");
                var apellido = consola.nextLine();
                System.out.println("Telefono: ");
                var telefono = consola.nextLine();
                System.out.println("Email: ");
                var email = consola.nextLine();
                //crear objeto estudiante(sin id)
                var estudiante = new Estudiante(nombre, apellido,telefono,email);
                var agregado = estudianteDAO.agregarEstudiante(estudiante);
                if(agregado)
                    System.out.println("Estudiante agregado: "+estudiante);
                else
                    System.out.println("Estudiante no agregado: "+estudiante);
            }//Fin caso 3
            case 4 ->{//Modificar estudiante
                System.out.println("Modificar estudiante: ");
                //Aqui lo primero es especificar cual es el id del objeto a modificar
                System.out.println("ID Estudiante: ");
                var idEstudiante = Integer.parseInt(consola.nextLine());
                System.out.println("Nombre: ");
                var nombre = consola.nextLine();
                System.out.println("Apellido: ");
                var apellido = consola.nextLine();
                System.out.println("Telefono: ");
                var telefono = consola.nextLine();
                System.out.println("Email: ");
                var email = consola.nextLine();
                //crea el objeto estudiante a modificar
                var estudiante=
                        new Estudiante(idEstudiante, nombre, apellido,telefono,email);
                var modificado = estudianteDAO.modificarEstudiante(estudiante);
                if(modificado)
                    System.out.println("Estudiante agregado: "+estudiante);
                else
                    System.out.println("Estudiante no agregado: "+estudiante);
            }//Fin caso 4
            case 5 -> {//Eliminar estudiante
                System.out.println("Eliminar estudiante: ");
                System.out.println("Id Estudiante: ");
                var idEstudiante = Integer.parseInt(consola.nextLine());
                var estudiante = new Estudiante(idEstudiante);
                var eliminado = estudianteDAO.eliminarEstudiante(estudiante);
                if(eliminado)
                    System.out.println("Estudiante eliminado: "+estudiante);
                else
                    System.out.println("Estudiante no eliminado: "+estudiante);
            }//Fin caso 5
            case 6 ->{//salir
                System.out.println("Hasta Pronto!!!");
                salir = true;
            }//Fin caso 6
            default -> System.out.println("Opcion no reconocida, ingrese otra opcion");
        }//Fin Switch
        return salir;
    }
}// Fin clase

