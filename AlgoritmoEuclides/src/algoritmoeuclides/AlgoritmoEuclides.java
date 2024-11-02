/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package algoritmoeuclides;

/**
 *
 * @author usuario
 */
// Algoritmo de Euclides para calcular el máximo común divisor
public class AlgoritmoEuclides {

    public static void main(String[] args) {
        // Definimos los números para los que queremos encontrar el MCD
        int num1 = 412;
        int num2 = 184;

        // Llamamos al método calcularMCD y almacenamos el resultado
        int mcd = calcularMCD(num1, num2);

        // Imprimimos el resultado
        System.out.println("El MCD de " + num1 + " y " + num2 + " es: " + mcd);
    }

    // Método para calcular el MCD utilizando recursividad al que le pasamos dos numeros enteros
    public static int calcularMCD(int a, int b) {
        // Caso base: si b es igual a cero, hemos encontrado el MCD y devolvemos a
        if (b == 0) {
            return a;
        } else {
            // Caso recursivo: llamamos a calcularMCD con b y a % b para seguir buscando
            return calcularMCD(b, a % b);
            //Aquí se utiliza la recursividad. Llamamos nuevamente a la función calcularMCD, 
            //pero con los argumentos intercambiados: b pasa a ser el primer argumento y a % b 
            //pasa a ser el segundo argumento. Esto se debe a que, según el algoritmo de Euclides, 
            //el MCD de dos números a y b es el mismo que el MCD de b y el residuo de dividir a entre b.
            // Recursión: Este proceso de llamadas recursivas se repite
            // hasta que se alcance el caso base (cuando b es igual a cero).
        }
    }
}
