/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package cadenarecursiva;

/**
 *
 * @author Antonio Atienza Cano
 */
import java.util.Scanner;

public class CadenaRecursiva {
    public static void main(String[] args) {
        // Instancia de la clase Scanner
        Scanner scanner = new Scanner(System.in);
        // pedimos que se nos ingrese una cadena de caracteres 
        System.out.print("Ingresa una cadena de caracteres: ");
        // Acanner que la lee 
        String cadena = scanner.nextLine();
         // llamada al medoto el liminar caracter de la cadena que elimina el ultimo caracter de la cadena 
        eliminarUltimoCaracter(cadena);
        // cerramos el Scanner 
        scanner.close();
    }
 // metodo para eliminar el ultimo caracter de la cadena, recibe una cadena de string como argumento 
    public static void eliminarUltimoCaracter(String cadena) {
        // Imprimir contenido actual de la cadena
        System.out.println(cadena);
        
        // Caso base: cuando la cadena tiene un solo caracter
        if (cadena.length() == 1) {
            // si llegamos a 1 la recursividad se detine 
            return;
        }
        
        // Llamar recursivamente con la cadena sin el último caracter, substring coge el primer caracter de la cadena y el ultimo,
        //al cual le restamos uno, esto se realiza recurisbamente hasta que el valor final sea uno. 
        eliminarUltimoCaracter(cadena.substring(0, cadena.length() - 1));
    }
}
