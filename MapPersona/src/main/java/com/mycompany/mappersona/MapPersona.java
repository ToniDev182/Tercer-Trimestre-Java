/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package com.mycompany.mappersona;

import java.util.Scanner;

/**
 *
 * @author Antonio Atienza Cano
 */
public class MapPersona {

    public static void main(String[] args) {
        // Creamos un objeto de la clase ColeccionPersonas para manejar la coleccion de personas
        ColeccionPersonas coleccion = new ColeccionPersonas();
        // creamos un scanner para leer la entrada del usuario 
        Scanner scanner = new Scanner(System.in);

        int opcion;
        do {

            // menú con sus diferentes opciones 
            System.out.println("\nMenú:");
            System.out.println("0. Salir");
            System.out.println("1. Añadir persona");
            System.out.println("2. Buscar persona");
            System.out.println("3. Modificar persona");
            System.out.println("4. Borrar persona");
            System.out.println("5. Listar todas las personas");
            System.out.print("Seleccione una opción: ");
            // se lee la opcion 
            opcion = scanner.nextInt();
            // Limpiamos el buffer de scanner
            scanner.nextLine();
            // estructura switch para el menu 
            switch (opcion) {
                case 1:
                    // Se crea una nueva persona y se solicitga que ingrese sus datos
                    Persona nuevaPersona = new Persona();
                    nuevaPersona.leerPersona();

                    String dni = coleccion.getDni(); // Obtener el DNI desde la colección
                    if (!dni.isEmpty()) { // Verificar si el DNI es válido
                        coleccion.añadirPersona(dni, nuevaPersona); // Añadir la persona con el DNI obtenido
                    } else {
                        System.out.println("El DNI ingresado no es válido. No se agregó la persona.");
                    }
                    break;
                case 2:
                    // solicitamos al usuario que ingrese el dni que busca
                    System.out.print("Ingrese el DNI de la persona a buscar: ");
                    String dniBuscar = scanner.nextLine();
                    // se busca en la coleccion la persona por el dni insertado
                    coleccion.buscarPersona(dniBuscar);
                    break;
                case 3:
                    // solicitamos a la persona que ingrese el dni de la persona a modificar
                    System.out.print("Ingrese el DNI de la persona a modificar: ");
                    String dniModificar = scanner.nextLine();
                    // se crea una nueva persona modificada 
                    Persona personaModificada = new Persona();
                    personaModificada.leerPersona();
                    // Esta nueva persona se añade al conjunto/colección 
                    coleccion.modificarPersona(dniModificar, personaModificada);
                    break;
                case 4:
                    // solicitamos el dni de la persona 
                    System.out.print("Ingrese el DNI de la persona a borrar: ");

                    String dniBorrar = scanner.nextLine();
                    //borramos a la persona de la coleccion 
                    coleccion.borrarPersona(dniBorrar);
                    break;
                case 5:
                    // se muestra la lista de todas las personas de la coleccion 
                    coleccion.listarPersonas();
                    break;
                case 0:
                    // se sale del programa
                    System.out.println("Saliendo del programa...");
                    break;
                default:
                    System.out.println("Opción no válida. Por favor, seleccione una opción válida.");
            }
        } while (opcion != 0);
        // cierra scanner
        scanner.close();
    }
}
