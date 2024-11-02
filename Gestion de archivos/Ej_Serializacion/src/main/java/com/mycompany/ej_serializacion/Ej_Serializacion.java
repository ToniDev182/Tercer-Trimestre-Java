/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.ej_serializacion;

import java.util.List;
import java.util.Scanner;


/**
 *
 * @author Antonio Atienza Cano
 */
public class Ej_Serializacion {
    public static void main(String[] args) {
        Colegio colegio = new Colegio();
        Scanner scanner = new Scanner(System.in);

        System.out.println("Bienvenido al sistema de gestión de alumnos.");

        while (true) {
            System.out.println("Menú:");
            System.out.println("1. Agregar alumno");
            System.out.println("2. Consultar alumno");
            System.out.println("3. Modificar alumno");
            System.out.println("4. Eliminar alumno");
            System.out.println("5. Listar alumnos");
            System.out.println("6. Salir");
            System.out.print("Selecciona una opción: ");
            int opcion = Integer.parseInt(scanner.nextLine());

            switch (opcion) {
                case 1:
                    Alumno nuevoAlumno = Alumno.leerAlumno();
                    colegio.agregarAlumno(nuevoAlumno);
                    colegio.guardarDatos();
                    System.out.println("Alumno agregado correctamente.");
                    break;
                case 2:
                    System.out.print("Ingrese el índice del alumno a consultar: ");
                    int indiceConsulta = Integer.parseInt(scanner.nextLine());
                    Alumno alumnoConsulta = colegio.consultarAlumno(indiceConsulta);
                    if (alumnoConsulta != null) {
                        System.out.println("Alumno encontrado:");
                        System.out.println(alumnoConsulta);
                    } else {
                        System.out.println("Alumno no encontrado.");
                    }
                    break;
                case 3:
                    System.out.print("Ingrese el índice del alumno a modificar: ");
                    int indiceModificacion = Integer.parseInt(scanner.nextLine());
                    Alumno alumnoModificacion = Alumno.leerAlumno(); 
                    colegio.modificarAlumno(indiceModificacion, alumnoModificacion);
                    colegio.guardarDatos();
                    System.out.println("Alumno modificado correctamente.");
                    break;
                case 4:
                    
                    System.out.print("Ingrese el índice del alumno a eliminar: ");
                    int indiceEliminacion = Integer.parseInt(scanner.nextLine());
                    colegio.eliminarAlumno(indiceEliminacion);
                    colegio.guardarDatos();
                    System.out.println("Alumno eliminado correctamente.");
                    break;
                case 5:
                    colegio.obtenerListadoAlumnos();
                    break;
                case 6:
                    System.out.println("Saliendo del programa.");
                    scanner.close();
                    System.exit(0);
                default:
                    System.out.println("Opción inválida. Inténtalo de nuevo.");
            }
        }
    }
}
