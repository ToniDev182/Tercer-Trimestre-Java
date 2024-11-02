/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package hotelpalace;
import java.text.ParseException;
import java.util.Scanner;
/**
 *
 * @author Antonio Atienza Cano
 */



public class HotelPalace {
    public static void main(String[] args) throws ParseException {
        //escaner para el usuario
        Scanner scanner = new Scanner(System.in);
        
        Gestion_Reservas gestionReservas = new Gestion_Reservas();
        // menu
        int opcion;
        do {
            System.out.println("=== Menú de Gestión de Reservas ===");
            System.out.println("1. Insertar Cliente");
            System.out.println("2. Eliminar Cliente");
            System.out.println("3. Listar Clientes");
            System.out.println("4. Insertar Hotel");
            System.out.println("5. Eliminar Hotel");
            System.out.println("6. Listar Hoteles");
            System.out.println("7. Insertar Reserva");       
            System.out.println("8. Salir");
            System.out.print("Ingrese la opción deseada: ");
            opcion = scanner.nextInt();
            scanner.nextLine(); 

            switch (opcion) {
                case 1:
                    gestionReservas.insertarCliente();
                    break;
                case 2:
                    gestionReservas.eliminarCliente();
                    break;
                case 3:
                    gestionReservas.ListarClientes();
                    break;
                case 4:
                    gestionReservas.insertarHotel();
                    break;
                case 5:
                    gestionReservas.eliminarHotel();
                    break;
                case 6:
                    gestionReservas.ListarHotel();
                    break;
                case 7:
                    gestionReservas.insertarReserva();
                    break;              
                case 8:
                    
                    System.out.println("Saliendo del programa...");
                    break;
                default:
                    System.out.println("Opción inválida. Inténtelo de nuevo.");
            }
        } while (opcion != 9);

        scanner.close();
    }
}
