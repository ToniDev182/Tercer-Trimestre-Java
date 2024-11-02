/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.lecturaescriturasecuencial;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class LecturaEscrituraSecuencial {
    public static void main(String[] args) {
        // Ruta del archivo de entrada y salida
      

        try {
            FileReader archivoEntrada = new FileReader("ruta//de//la//fruta");
             FileWriter archivoSalida = new FileWriter ("ruta//de//la//verdura");
            // Abre el archivo de entrada
            BufferedReader lector = new BufferedReader(archivoEntrada);
            // Abre el archivo de salida
            BufferedWriter escritor = new BufferedWriter (archivoSalida);

            // Lee cada línea del archivo de entrada
            String linea;
            // Esta parte lee una línea del archivo de entrada y la asigna a la variable linea
            while ((linea = lector.readLine()) != null) {
                // Verifica si la línea está en mayúsculas
                if (linea.equals(linea.toUpperCase())) {
                    // Escribe la línea en el archivo de salida
                    escritor.write(linea);
                    escritor.newLine(); // Agrega un salto de línea
                }
            }

            // Cierra los archivos
            lector.close();
            escritor.close();

            System.out.println("Se han filtrado las líneas en mayúsculas en el archivo de salida.");

        } catch (IOException e) {
            System.err.println("Error al procesar el archivo: " + e.getMessage());
            e.printStackTrace();
        }
    }
}