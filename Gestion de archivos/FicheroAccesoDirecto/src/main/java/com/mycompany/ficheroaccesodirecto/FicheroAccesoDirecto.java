/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.ficheroaccesodirecto;

import java.io.*;

/**
 *
 * @author Antonio Atienza Cano 
 */
public class FicheroAccesoDirecto {

    public static void main(String[] args) {
  //  Nombre del archivo donde se almacenaran los numeros
  
  String nombreArchivo = "nuemros.bin";
  
  // llamada al metodo que esribe los numeros en el archivo
  escribirNumeros(nombreArchivo);
  
    // Leer los números del archivo y calcular la suma
        int suma = leerYCalcularSuma(nombreArchivo);

        // Mostrar la suma por pantalla
        System.out.println("La suma de los números del 0 al 100 es: " + suma);
    }

    public static void escribirNumeros(String nombreArchivo) {
        try (DataOutputStream dos = new DataOutputStream(new FileOutputStream(nombreArchivo))) {
            // Escribir los números del 0 al 100 en el archivo
            for (int i = 0; i <= 100; i++) {
                // escribimos en la posicion 
                dos.writeInt(i);
            }
            System.out.println("Se han escrito los números en el archivo correctamente.");
        } catch (IOException e) {
            System.err.println("Error al escribir en el archivo: " + e.getMessage());
        }
    }

    public static int leerYCalcularSuma(String nombreArchivo) {
        int suma = 0;
        try (DataInputStream dis = new DataInputStream(new FileInputStream(nombreArchivo))) {
            // Leer los números del archivo y calcular la suma
            while (true) {
                suma += dis.readInt();
            }
        } catch (EOFException e) {
            // Se llegó al final del archivo
            System.out.println("Se ha alcanzado el final del archivo.");
        } catch (IOException e) {
            System.err.println("Error al leer el archivo: " + e.getMessage());
        }
        return suma;
    }
}
  
 