/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.ej_academia_examen;

import java.io.*;
import java.util.*;


/**
 *
 * @author Antonio Atienza Cano
 */
public class GestionAlumnos {

    // coleccion de alumnos 
    private HashMap<Integer, Alumno> alumnos = new HashMap<>();

    // contructor  por defecto
    // creamos un contador para incrementar la id
    private static int incrementadorId = 0;

    public static void inicializar(int lastId) {
        incrementadorId = lastId;
    }

    // metodo para añadir una persona y verificar si su dni existe
    public void añadirPersona(Alumno alumno) {

        // Verificar si el DNI ya existe en el grupo de alumnos
        for (Alumno alumnoRegistrado : alumnos.values()) {
            if (alumno.getDni().equals(alumnoRegistrado.getDni())) {
                // Si el DNI ya existe, lanzar una excepción
                throw new IllegalArgumentException("El DNI ya existe.");
            }
        }
        // guarda la nueva persona, le das su id, lo incrementa y guarda la persona 
        alumno.setId(++incrementadorId);
        // Guardar persona a traves de su ide en el hashmap
        alumnos.put(alumno.getId(), alumno);

    }
    // mostrar un alumno por id

    public Alumno mostrarAlumno(int id) {
        return alumnos.get(id);
    }
    // borrrar un alumno 

    public void borrarAlumno(int id) {
        alumnos.remove(id);
    } // metodo para mostrar todas las personas oredenadas alfabeticamente por apellido y nombre

    public List<Alumno> alumnoOrdenados() {
        // Crear una lista a partir de los valores del HashMap
        List<Alumno> listaAlumnos = new ArrayList<>(alumnos.values());
        // Ordenar la lista utilizando comparadores
        listaAlumnos.sort(Comparator.comparing(Persona::getApellido1).thenComparing(Persona::getNombre));
        return listaAlumnos;
    }
    // metodo para mostrar todos los alumnos matriculados en un curso 

    public List<Alumno> alumnosCurso(String nombreCur) {

        List<Alumno> alumnosEnCurso = new ArrayList<>();
        // entryset te devuelve todos los valores del mapa como una lista
        alumnos.values().forEach(alumno -> {
            alumno.getCursos().forEach(curso -> {
                if (curso.getNombreCurso().equals(nombreCur)) {
                    alumnosEnCurso.add(alumno);

                }
            });

        });
        
        return alumnosEnCurso;
    }

    public List<Alumno> alumnosAprovados() {

        // cremos un alista para guardar los aprobados
        List<Alumno> alumnosAprovados = new ArrayList<>();
        for (Alumno alumno : alumnos.values()) {
            // Creamos una bandera para saber si en algun momento hay algo no aprobado 
            boolean todoaprobado = true;
            for (Curso curso : alumno.getCursos()) {
                // recorreos los alumnos con sus valores y los cursos y despues de recorrer los cursos si ningun 
                // esta suspenso lo agrega a la lista. 
                if (curso.getEvaluacion1() < 5 && curso.getEvaluacion2() < 5) {
                    todoaprobado = false;
                }
            }
            if (todoaprobado) {
                alumnosAprovados.add(alumno);
            }
        }
        return alumnosAprovados;
    }
    
     // Método para leer un archivo binario existente y guardar en texto
       public void binarioATxt(String archivoBin, String archivoTxt) {
        File archivoBinario = new File("archivo.dat");
        if (!archivoBinario.exists() || !archivoBinario.isFile()) {
            System.out.println("El archivo binario no existe o no es un archivo válido.");
            return;
        }
        File archivoTexto = new File(archivoTxt);
        try (ObjectInputStream entrada = new ObjectInputStream(new FileInputStream(archivoBinario));
             PrintWriter pw = new PrintWriter(new FileWriter(archivoTexto))) {
HashMap<Integer, Alumno> mapaAlumnos = (HashMap<Integer, Alumno>) entrada.readObject();
            for (Map.Entry<Integer, Alumno> entry : mapaAlumnos.entrySet()) {
                Alumno alumno = entry.getValue();
                // Escribimos los datos en el formato "id nombre edad"
                pw.println(alumno.getId() + " " + alumno.getNombre() + " ");
            }
            System.out.println("Archivo de texto creado correctamente.");
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
       
       
   // Método para leer un archivo de texto existente y guardar en binario
    public void txtABinario(String archivoTxt, String archivoBin) {
        File archivoTexto = new File(archivoTxt);
        if (!archivoTexto.exists() || !archivoTexto.isFile()) {
            System.out.println("El archivo de texto no existe o no es un archivo válido.");
            return;
        }
        File archivoBinario = new File(archivoBin);
        try (BufferedReader br = new BufferedReader(new FileReader(archivoTexto));
             ObjectOutputStream salida = new ObjectOutputStream(new FileOutputStream(archivoBinario))) {
            String linea;
            HashMap<Integer, Alumno> mapaAlumnos = new HashMap<>();
            while ((linea = br.readLine()) != null) {
                String[] partes = linea.split(" ");
                int id = Integer.parseInt(partes[0]);
                byte[] bytes = linea.getBytes();
                String dni = partes[1];
                String nombre = partes[2];
                String apellido1 = partes[3];
                String apellido2 = partes[4];
                String direccion = partes[5];
                mapaAlumnos.put(id, new Alumno(id, dni, nombre, apellido1, apellido2, direccion));
            }
            salida.writeObject(mapaAlumnos);
            System.out.println("Archivo binario creado correctamente.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public void guardarDatos() {
        // creamos un objeto arcivos y le damos un nombre
        File archivo = new File("datos_Alumnos.bin");
        // no compruebo porque si existe guarda en el, pero si no existe automaticamente lo crea
        // flujo de salida de datos 
        try (ObjectOutputStream salida = new ObjectOutputStream(new FileOutputStream(archivo))) {
            salida.writeObject(alumnos); // Escribir el HashMap en el archivo
        } catch (IOException e) {
            e.printStackTrace(); // Manejo de excepciones de E/S
        }
    }

    // Método para cargar los datos
    public void cargarDatos() {
        // creamos el archivo y verificamos si es un archivo y si existe
        File archivo = new File("datos_Alumnos.bin");
        if (archivo.exists() && archivo.isFile()) {
            // flujo de entrada de datos
            try (ObjectInputStream entrada = new ObjectInputStream(new FileInputStream(archivo))) {
                alumnos = (HashMap<Integer, Alumno>) entrada.readObject(); // Leer el HashMap desde el archivo
                System.out.println("Datos cargados correctamente");
                // obtenemos la lista de personas en un mapa y comprobamos si ya hay usuarios creados para obtener el ultimo id
                if (!alumnos.isEmpty()) {
                    // obtenemos los ids a traves de esta lista de personas con id
                    List<Integer> ids = new ArrayList<>(alumnos.keySet());
                    inicializar(ids.getLast());
                }
            } catch (IOException | ClassNotFoundException e) {
            }
        }
    }
}