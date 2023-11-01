package UTN.presentacion;

import UTN.datos.EstudianteDAO;
import UTN.dominio.Estudiante;


import java.util.Scanner;

public class SistemaEstudiantesApp{
    public static void main(String[] args) {
        var salir = false;
        var consola = new Scanner(System.in);//Para leer informacion de la consola
        //Se crea una instancia de la clase servicio. Esto lo hacemos fuera del ciclo
        var estudianteDao = new EstudianteDAO(); //Esta instancia debe hacerse una vez
        while(!salir){
            try{
                mostrarMenu(); //Mostramos el menú
                //Este será el método ejecutarOpciones que devolverá un booleano
                salir = ejecutarOpciones(consola,estudianteDao); //Arroja una exception
            } catch(Exception e){
                System.out.println("Ocurrió un error al ejecutar la operación" +e.getMessage());
            }
        }//Fin while

    }//Fin main

    //Método para ejecutar las opciones, va a regresar un valor booleano, ya que es el que
    //puede modificar el valor de la variable salir, si es verdadero termina el ciclo while
    private static boolean ejecutarOpciones(Scanner consola, EstudianteDAO estudianteDao) {
        var opcion = Integer.parseInt(consola.nextLine());
        var salir = false;
        switch(opcion){
            case 1 -> { //Listar estudiantes
                System.out.println("Listado de Estudiantes....");
                //No muestra la información,  solo recupera la info y regresa una lista
                var estudiantes = estudianteDao.listarEstudiantes(); //Recibe el listado
                //vamos a iterar cada objeto de tipo estudiante
                estudiantes.forEach(System.out::println); //para imprimir la lista
            } //Fin caso 1
            case 2 -> { //Buscar estudiante por id
                System.out.println("Introduce el id_estudiante a buscar: ");
                var idEstudiante = Integer.parseInt(consola.nextLine());
                var estudiante = new Estudiante(idEstudiante);
                var encontrado = estudianteDao.buscarEstudiantePorid(estudiante);
                if(encontrado)
                    System.out.println("Estudiante encontrado: " + estudiante);
                else
                    System.out.println("Estudiante NO encontrado: " + estudiante);
            } //Fin caso 2
            case 3 -> {//Agregar estudiante
                System.out.println("Agregar estudiante: ");
                System.out.println("Nombre: ");
                var nombre = consola.nextLine();
                System.out.println("Apellido: ");
                var apellido = consola.nextLine();
                System.out.println("Teléfono: ");
                var telefono = consola.nextLine();
                System.out.println("Email: ");
                var email = consola.nextLine();
                //crear objeto estudiante(sin id)
                var estudiante = new Estudiante(nombre,apellido, telefono, email);
                var agregado = estudianteDao.agregarEstudiante(estudiante);
                if(agregado)
                    System.out.println("Estudiante agregado: " + estudiante);
                else System.out.println("Estudiante NO agregado: " + estudiante);
            } //Fin caso 3
            case 4 -> {//Modificar estudiante
                System.out.println("Modificar estudiante: ");
                //Aquí lo primero es especificar cuál es el id del objeto a modificar
                System.out.println("Id Estudiante: ");
                var idEstudiante = Integer.parseInt(consola.nextLine());
                System.out.println("Nombre: ");
                var nombre = consola.nextLine();
                System.out.println("Apellido: ");
                var apellido = consola.nextLine();
                System.out.println("Teléfono: ");
                var telefono = consola.nextLine();
                System.out.println("Email: ");
                var email = consola.nextLine();
                //crea el objeto estudiante a modificar
                var estudiante = new Estudiante(idEstudiante, nombre,apellido, telefono, email);
                var modificado = estudianteDao.modificarEstudiante(estudiante);
                if(modificado)
                    System.out.println("Estudiante modificado: " + estudiante);
                else System.out.println("Estudiante NO modificado: " + estudiante);
            }//Fin caso 4
            case 5 -> {//Eliminar estudiante
                System.out.println("Eliminar estudiante: ");
                System.out.println("Id Estudiante: ");
                var idEstudiante = Integer.parseInt(consola.nextLine());
                var estudiante = new Estudiante(idEstudiante);
                var eliminado = estudianteDao.eliminarEstudiante(estudiante);
                if(eliminado)
                    System.out.println("Estudiante eliminado: " + estudiante);
                else System.out.println("Estudiante NO eliminado: " + estudiante);
            }//Fin caso 5
            case 6 -> {//salir
                System.out.println("Hasta pronto!!!");
                salir = true;
            }//Fin caso 6
        }//Fin switch
        return salir;
    }//Fin clase

    //Metodo mostrar menu
    private static void mostrarMenu() { // es privado y estatico
        System.out.println("""
                **** SIstema de estudiantes ****
                1. Listar estudiantes
                2. BUscar estudiantes
                3. Agregar estudiante
                4. Modificar estudiante
                5. Eliminar estudiante
                6. Salir
                Elige una opcion:                                                   
                """);
    }//fin menu
}//fin class
