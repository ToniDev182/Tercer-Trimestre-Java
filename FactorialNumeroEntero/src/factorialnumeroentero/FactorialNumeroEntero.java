/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package factorialnumeroentero;

/**
 *
 * @author usuario
 */
public class FactorialNumeroEntero {
    public static void main(String[] args) {
        // Número para calcular el factorial
        int numero = 6;
        
        // Llamada al método recursivo para calcular el factorial
        int factorial = calcularFactorial(numero);
        
        // Imprimir el resultado
        System.out.println("El factorial de " + numero + " es: " + factorial);
    }
    
    // Método recursivo para calcular el factorial
    public static int calcularFactorial(int n) {
        // Caso base: factorial de 0 es 1
        if (n == 0) {
            return 1;
        }
        // Caso recursivo: n * factorial(n-1)
        else {
            return n * calcularFactorial(n - 1);
        }
        
        //Este método utiliza la recursividad para calcular el factorial de un número n, 
        //multiplicando n por el factorial de n - 1, y así sucesivamente hasta llegar 
        //al caso base donde simplemente devuelve 1.

    }
}