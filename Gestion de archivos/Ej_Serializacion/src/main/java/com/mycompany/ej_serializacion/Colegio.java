/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.ej_serializacion;

import java.io.*;
import java.util.*;

/**
 *
 * @author Antonio Atienza Cano
 */
    class Colegio {

    private List<Alumno> listaAlumnos; // Lista que almacena los alumnos del colegio

    // Constructor por defecto que inicializa la lista de alumnos
    public Colegio() {
        listaAlumnos = new ArrayList<>();
    }

    // Método para agregar un alumno a la lista
    public void agregarAlumno(Alumno alumno) {
        listaAlumnos.add(alumno);
    }

    // Método para consultar un alumno por indice
    public Alumno consultarAlumno(int indice) {
        if (indice >= 0 && indice < listaAlumnos.size()) { // Verifica que el índice esté dentro del rango válido
            return listaAlumnos.get(indice);
        } else {
            return null; // Devuelve null si el índice está fuera del rango
        }
    }

    // Método para modificar los datos de un alumno 
    public void modificarAlumno(int indice, Alumno alumno) {
        if (indice >= 0 && indice < listaAlumnos.size()) { // Verifica que el índice esté dentro del rango válido
            listaAlumnos.set(indice, alumno); // Reemplaza el alumno en la posición indicada por el nuevo alumno
        }
    }

    // Método para eliminar un alumno de la lista por su índice
    public void eliminarAlumno(int indice) {
        if (indice >= 0 && indice < listaAlumnos.size()) { // Verifica que el índice esté dentro del rango válido
            listaAlumnos.remove(indice); // Elimina el alumno en la posición indicada
        }
    }

    // Método para obtener un listado de los alumnos (se devuelve una copia de la lista para evitar modificaciones no controladas)
    public List<Alumno> obtenerListadoAlumnos() {
       
         if (!listaAlumnos.isEmpty()) {
                        System.out.println("Listado de alumnos:");
                        for (int i = 0; i < listaAlumnos.size(); i++) {
                            System.out.println((i + 1) + ". " + listaAlumnos.get(i));
                        }
                    } else {
                        System.out.println("No hay alumnos registrados.");
                    }
        return new ArrayList<>(listaAlumnos); // Se devuelve una copia de la lista para evitar modificaciones no controladas
    }

    // Método para guardar los datos de los alumnos en un archivo mediante serialización
    public void guardarDatos() {
        File nombreArchivo = new File("datos_alumnos.ser");
        try (ObjectOutputStream salida = new ObjectOutputStream(new FileOutputStream(nombreArchivo))) {
            salida.writeObject(listaAlumnos); // Se escribe la lista de alumnos en el archivo
        } catch (IOException e) {
            e.printStackTrace(); // En caso de error, se imprime la traza de la excepción
        }
    }

    // Método para cargar los datos de los alumnos desde un archivo mediante deserialización
    public void cargarDatos() {
        File nombreArchivo = new File("datos_alumnos.ser");
        if (nombreArchivo.exists() && nombreArchivo.isFile()) {
            try (ObjectInputStream entrada = new ObjectInputStream(new FileInputStream(nombreArchivo))) {
                if(!listaAlumnos.isEmpty()){
                listaAlumnos = (List<Alumno>) entrada.readObject(); // Se lee la lista de alumnos desde el archivo
                System.out.println("Datos cargados correctamente");
                }
            } catch (IOException | ClassNotFoundException e) {
                e.printStackTrace(); // En caso de error, se imprime la traza de la excepción
            }
        }
    }
}
