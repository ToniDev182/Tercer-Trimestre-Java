/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.mappersona;

import java.util.HashMap;
import java.util.Map;
import java.util.regex.Pattern;

/**
 *
 * @author Antonio Atienza Cano
 */
public class ColeccionPersonas {
    // Se definen los atributos privados de la clase: 
    // dni para el DNI y conjunto como un mapa que mapea DNIs a 
    // objetos de tipo Persona.

    private Map<String, Persona> conjunto;

    // Constructor por defecto para que sea un HashMap
    ColeccionPersonas() {
        conjunto = new HashMap<String, Persona>();
    }

    // Constructor de copia
    ColeccionPersonas(ColeccionPersonas p) {
        this.conjunto.putAll(p.conjunto);

    }

    public Map<String, Persona> getConjunto() {
        return conjunto;
    }

    public void setConjunto(Map<String, Persona> conjunto) {
        this.conjunto.putAll(conjunto);
    }

    // Método para añadir personas al conjunto
    public void añadirPersona(String dni, Persona persona) {
        // Verificar si la persona ya existe en el conjunto
        if (conjunto.containsKey(dni)) {
            System.out.println("La persona ya existe en la colección.");
        } else {
            // Agregar la persona al conjunto utilizando su DNI como clave
            conjunto.put(dni, persona);
            System.out.println("Persona agregada correctamente.");
        }
    }

    // Método para buscar una persona por su DNI
    public void buscarPersona(String dni) {
        if (conjunto.containsKey(dni)) { // verifica si el conjunto contiene la clave dni
            Persona persona = conjunto.get(dni); // obtiene la persona del conjunto
            System.out.println("Persona encontrada:");
            persona.MostrarDatos();// muestra la persona encontrada
        } else {
            System.out.println("No se encontró ninguna persona con ese DNI.");
        }
    }

    // Método para modificar los datos de una persona
    public void modificarPersona(String dni, Persona persona) {
        if (conjunto.replace(dni, persona) != null) { // Intenta reemplazar la persona con el mismo DNI
            System.out.println("Persona modificada correctamente.");
        } else {
            System.out.println("No se encontró ninguna persona con ese DNI para modificar.");
        }
    }

    // Método para eliminar una persona del conjunto
    public void borrarPersona(String dni) {
        if (conjunto.containsKey(dni)) { // verifica si el conjunto contiene la clave dni
            conjunto.remove(dni); // elimina una persona del conjunto 
            System.out.println("Persona eliminada correctamente.");
        } else {
            System.out.println("No se encontró ninguna persona con ese DNI para eliminar.");
        }
    }

    // Método para listar todas las personas del conjunto
    public void listarPersonas() {
        System.out.println("Listado de personas:");
        for (Map.Entry<String, Persona> entry : conjunto.entrySet()) { // Recorre todas las entradas del conjunto
            System.out.println("DNI: " + entry.getKey()); // imprime su DNI
            entry.getValue().MostrarDatos(); // Seguido  de todos los detalles como nombrea pellidos, etc , etc.. 
            // proporciona una lista de todas las personas almacenadas
        }
    }
}
