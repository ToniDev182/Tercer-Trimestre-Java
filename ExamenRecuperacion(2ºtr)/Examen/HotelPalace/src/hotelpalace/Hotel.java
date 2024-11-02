/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package hotelpalace;

import java.util.Scanner;
import java.util.regex.Pattern;

/**
 *
 * @author Antonio Atienza Cano
 */
public class Hotel implements Comparable <Hotel> {
    private String idHotel;
    private String zona;
    private String nombre;
    private double precio;
    private int numeroHabitacionesTotales;
    private int numeroHabitacionesReservadas;

    // constructor por defecto
    public Hotel() {
        idHotel = "";
        nombre="";
        zona = ""; // Por defecto no tiene zona asignada
        precio = 0.0; // Por defecto el precio es 55.0
        numeroHabitacionesTotales = 0;
        numeroHabitacionesReservadas = 0;
    }

    // Constructor parametrizado
   public Hotel(String idHotel, String zona, double precio, int numeroHabitacionesTotales, int numeroHabitacionesReservadas) {
    if (validarIDHotel(idHotel)) {
        this.idHotel = idHotel;
    } else {
        this.idHotel = null;
    }
    this.zona = zona;
    this.precio = precio;
    if (validarNumeroHabitacionesTotales(numeroHabitacionesTotales)) {
        this.numeroHabitacionesTotales = numeroHabitacionesTotales;
    } else {
        this.numeroHabitacionesTotales = 0;
    }
    if (validarNumeroHabitacionesReservadas(numeroHabitacionesReservadas)) {
        this.numeroHabitacionesReservadas = numeroHabitacionesReservadas;
    } else {
        this.numeroHabitacionesReservadas = 0;
    }
}
    //Constructor Copia
    public Hotel(Hotel otroHotel){
        this.idHotel=otroHotel.idHotel;
        this.nombre=otroHotel.nombre;
        this.numeroHabitacionesTotales=otroHotel.numeroHabitacionesTotales;
        this.numeroHabitacionesReservadas=otroHotel.numeroHabitacionesReservadas;
    }
    
    // Getters y setters y sus comprobaciones en los sets
    public String getidHotel() {
        return idHotel;
    }

public void setIdHotel(String idHotel) {
    if(validarIDHotel(idHotel)) {
        this.idHotel = idHotel;
    } else {
        System.out.println("Error al asignar datos, debido a que el ID es erróneo.");
        this.idHotel = "";
    }
}


// metodos get y set
    public String getZona() {
        return zona;
    }

    public void setZona(String zona) {
    if(validarZona(zona)) {
        this.zona = zona;
    } else {
        System.out.println("Error al asignar datos, la zona proporcionada no es válida.");
        
    }
}
    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
    if(validarPrecio(precio)) {
        this.precio = precio;
    } else {
        System.out.println("Error al asignar datos, el precio proporcionado no es válido.");
    }
}


    public int getNumeroHabitacionesTotales() {
        return numeroHabitacionesTotales;
    }

   public void setNumeroHabitacionesTotales(int numeroHabitacionesTotales) {
    if(validarNumeroHabitacionesTotales(numeroHabitacionesTotales)) {
        this.numeroHabitacionesTotales = numeroHabitacionesTotales;
    } else {
        System.out.println("Error al asignar datos, el número total de habitaciones proporcionado no es válido.");
        // Aquí podrías elegir qué hacer en caso de que el número total de habitaciones no sea válido.
        // Por ejemplo, podrías asignar un valor por defecto, lanzar una excepción, etc.
    }
}


    public int getNumeroHabitacionesReservadas() {
        return numeroHabitacionesReservadas;
    }

  public void setNumeroHabitacionesReservadas(int numeroHabitacionesReservadas) {
    if(validarNumeroHabitacionesReservadas(numeroHabitacionesReservadas)) {
        this.numeroHabitacionesReservadas = numeroHabitacionesReservadas;
    } else {
        System.out.println("Error al asignar datos, el número de habitaciones reservadas proporcionado no es válido.");
      
    }
}

    public boolean leerHotel() {
    Scanner leer = new Scanner(System.in);
    System.out.println("Escribe los datos respetando el formato del dato correspondiente.");
    System.out.println("Ingrese el ID del hotel (formato: 4 números seguidos de una letra): ");
    String idHotel = leer.nextLine();
    if (validarIDHotel(idHotel)) {
        setIdHotel(idHotel);
        System.out.println("Ingrese la zona del hotel (playa, montaña, rural): ");
        String zona = leer.nextLine();
        if (validarZona(zona)) {
            setZona(zona);
            System.out.println("Ingrese el precio del hotel: ");
            double precio = leer.nextDouble();
            setPrecio(precio);
            System.out.println("Ingrese el número total de habitaciones del hotel (entre 1 y 40): ");
            int numHabitacionesTotales = leer.nextInt();
            if (validarNumeroHabitacionesTotales(numHabitacionesTotales)) {
                setNumeroHabitacionesTotales(numHabitacionesTotales);
                System.out.println("Ingrese el número de habitaciones reservadas del hotel (entre 1 y 40): ");
                int numHabitacionesReservadas = leer.nextInt();
                if (validarNumeroHabitacionesReservadas(numHabitacionesReservadas)) {
                    setNumeroHabitacionesReservadas(numHabitacionesReservadas);
                    return true;
                }
    return false;
}
         
    // metodo para mostrar el hotel
 
    public void mostrarHotel(Hotel hotel) {
    System.out.println("ID del Hotel: " + getidHotel());
    System.out.println("Zona: " + getZona());
    System.out.println("Precio: " + getPrecio());
    System.out.println("Número de habitaciones totales: " + getNumeroHabitacionesTotales());
    System.out.println("Número de habitaciones reservadas: " + getNumeroHabitacionesReservadas());
}

     
     
    
// metodo para validar id de hotel
       private boolean validarIDHotel(String id) {
        String patronId = "\\d{4}[a-zA-Z]";
        return Pattern.matches(patronId, id);
    }
       // metodo para validar la zona 
        private boolean validarZona(String zona) {
        return zona.equalsIgnoreCase("playa") || zona.equalsIgnoreCase("montaña") || zona.equalsIgnoreCase("rural");
    }
        // metodo para validar precio
        private boolean validarPrecio(double precio) {
        return precio >= 0; // Consideramos que el precio debe ser mayor o igual a cero
    }
        // metodo para validar Habitaciones reservadas
         private boolean validarNumeroHabitacionesReservadas(int numeroHabitacionesReservadas) {
        return numeroHabitacionesReservadas >= 1 && numeroHabitacionesReservadas <= 40;
    }
         
         // metodo para validar Habitaciones Totales
         private boolean validarNumeroHabitacionesTotales(int numeroHabitacionesTotales) {
        return numeroHabitacionesTotales >= 1 && numeroHabitacionesTotales <= 40;
    }
  @Override
    public int compareTo (Hotel otroHotel ) {
        return this.getidHotel().compareTo(otroHotel.getidHotel());
    }

}

        


