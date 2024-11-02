/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.persona_serializable;

import java.io.*;
import java.util.*;

/**
 *
 * @author Antonio Atienaza Cano
 */
public class GestorPersonas  {

    
    //HashMap para almacenar las personas, con el ID de la persona
    private HashMap<Integer, Persona> personas = new HashMap<>();
    // constructor por defecto para inicializar la lista de personas
    public GestorPersonas() {
        personas = new HashMap<>(); 
    }

     
 //creamos un contador para incrementar en uno la ID
     
    private  static int incrementadorId = 0;
    // con esta funcion el valor se inicializará desdesde la ultima posicion 
    
    public static void inicializar(int lastId){
       incrementadorId = lastId; 
    }
    // Metodo para añadir una persona // tambien para comprovar dni
    public void añadirPersona(Persona persona) {
        
        // agarra la lista de personas con sus valores // persona registrada  es cada persona que estaba en la lista antes que esta // comparo el dni de esas personas con la nueva. 
        personas.values().forEach(personaRegistrada -> { if(persona.getDni().equals(personaRegistrada.getDni())){
            // Si alguno es igual lanzo la excepcion , si no simplemente sigue el flujo del codigo,
            throw new IllegalArgumentException("El Dni ya exixte");    
            
        }
            
        });
            // guarda la nueva persona, le das su id, lo incrementa y guarda la persona 
        persona.setId(++incrementadorId);
        // Guardar persona a traves de su ide en el hashmap
        personas.put(persona.getId(), persona);
        
    }
    
  //  public Persona consultarPersona(int id){
   //     return personas.get(id);
   // }
    
    //public void eliminarTodasPersonas (){
     //   personas.clear();
        
  //  }
    
    
    

    // metodo para mostrar una persona  // Obtener la persona del HashMap
    public Persona mostrarPersona(int id) {
        return personas.get(id);
    }

    // metodo para borrar una persona 
    public void borrarPersona(int id) {
        personas.remove(id);
    }

    // metodo para mostrar todas las personas oredenadas alfabeticamente por apellido y nombre
    public List<Persona> personasOrdenadas() {
        // Crear una lista a partir de los valores del HashMap
        List<Persona> listaPersonas = new ArrayList<>(personas.values());
        // Ordenar la lista utilizando comparadores
        listaPersonas.sort(Comparator.comparing(Persona::getApellido1).thenComparing(Persona::getNombre));
        return listaPersonas;
    }
    // Método para guardar los datos de personas en un archivo de bytes

    public void guardarDatos() {
        // creamos un objeto arcivos y le damos un nombre
        File archivo = new File("datos_personas.dat");
        // no compruebo porque si existe guarda en el, pero si no existe automaticamente lo crea
        // flujo de salida de datos 
        try (ObjectOutputStream salida = new ObjectOutputStream(new FileOutputStream(archivo))) {
            salida.writeObject(personas); // Escribir el HashMap en el archivo
        } catch (IOException e) {
            e.printStackTrace(); // Manejo de excepciones de E/S
        }
    }

    // Método para cargar los datos
    public void cargarDatos() {
        // creamos el archivo y verificamos si es un archivo y si existe
        File archivo = new File("datos_personas.dat");
        if (archivo.exists() && archivo.isFile()) {
             // flujo de entrada de datos
            try (ObjectInputStream entrada = new ObjectInputStream(new FileInputStream(archivo))) {
                personas = (HashMap<Integer, Persona>) entrada.readObject(); // Leer el HashMap desde el archivo
                System.out.println("Datos cargados correctamente");
                // obtenemos la lista de personas en un mapa y comprobamos si ya hay usuarios creados para obtener el ultimo id
                if (!personas.isEmpty()) {
                    // obtenemos los ids a traves de esta lista de personas con id
                    List<Integer> ids = new ArrayList<>(personas.keySet());
                    inicializar(ids.getLast());
                }
            } catch (IOException | ClassNotFoundException e) {
            }
        }
    }
}
