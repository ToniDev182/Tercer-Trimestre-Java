/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.excepcionesjava;

/**
 *
 * @author Antonio Atienza Cano
 */
import java.util.Scanner;

public class ExcepcionesJava {

    public static void main(String[] args) {
        int[] vector = null; // Inicializamos el vector como null
        try {
            vector = crearVector(); // Intentamos crear el vector
        } catch (java.util.InputMismatchException e) { // Capturamos una excepción si se introduce un tipo de dato incorrecto
            System.err.println("Error: Debes introducir un número entero.");
            return;
        } catch (java.util.NoSuchElementException e) { // Capturamos una excepción si no se proporcionan suficientes valores
            System.err.println("Error: No se proporcionaron suficientes valores.");
            return;
        } catch (Exception e) { // Capturamos cualquier otra excepción no esperada
            System.err.println("Error desconocido: " + e.getMessage());
            return;
        } finally { // Se ejecuta siempre, independientemente de si se produce una excepción o no
            System.out.println("\nPrograma finalizado.");
            if (vector != null) { // Verificamos si el vector se inicializó correctamente
                mostrarVector(vector); // Mostramos el vector si se inicializó correctamente
            }
        }
    }

    // Método para crear un vector de enteros
    public static int[] crearVector() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Introduce el tamaño del vector: ");
        int n = scanner.nextInt();

        int[] vector = new int[n]; // Creamos un array de enteros de tamaño n
        for (int i = 0; i < n; i++) {
            System.out.print("Introduce un número entero para la posición " + i + ": ");
            vector[i] = scanner.nextInt(); // Asignamos valores a cada posición del vector
        }

        return vector; // Devolvemos el vector creado
    }

    // Método para mostrar el contenido de un vector de enteros
    public static void mostrarVector(int[] vector) {
        System.out.println("Vector final:");
        for (int i = 0; i < vector.length; i++) {
            System.out.print(vector[i] + " "); // Mostramos cada elemento del vector
        }
    }
}
