/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.binarioatexto;

import java.io.*;

/**
 *
 * @author 34639
 */
public class BinarioAtexto {
    public static void main(String[] args) {
        // Archivos de entrada y salida
        File archivoEntrada = new File("ruta//de//la//fruta.bin");
        File archivoSalida = new File("ruta//de//la//verdura.txt");

        try {
            // Abre el archivo de entrada para lectura de bits
            DataInputStream lector = new DataInputStream(new FileInputStream(archivoEntrada));
            // Abre el archivo de salida para escritura de texto
            BufferedWriter escritor = new BufferedWriter(new FileWriter(archivoSalida));

            // Lee cada byte del archivo de entrada
            int byteLeido;
            while ((byteLeido = lector.read()) != -1) {
                // Convierte el byte a carácter y escribe en el archivo de salida
                escritor.write((char) byteLeido);
            }

            // Cierra los archivos
            lector.close();
            escritor.close();

            System.out.println("Se ha completado la escritura en el archivo de texto.");

        } catch (IOException e) {
            System.err.println("Error al procesar el archivo: " + e.getMessage());
            e.printStackTrace();
        }
    }
}
