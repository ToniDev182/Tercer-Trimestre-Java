/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package hotelpalace;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;
import java.util.regex.Pattern;

/**
 *
 * @author Antonio Atienza Cano
 */
public class Reserva implements Comparable <Reserva> {
    String dniCliente;
    Date Fecha_entrada;
    Date Fecha_Salida;
    int numeroHabitaciones;
    double precioTotal;      
    
    
    // Constructor por defecto
    public Reserva(){
        this.dniCliente ="";
        this.numeroHabitaciones = 0;
        this.precioTotal = 0;
    }
// constructor parametrizado
    
public Reserva(String dniCliente, Date fechaEntrada, Date fechaSalida, int numeroHabitaciones, double precioTotal) {
    if (validardniCliente(dniCliente)) {
        this.dniCliente = dniCliente;
    } else {
        System.out.println("Error: el DNI del cliente proporcionado no es válido.");
    }
    this.Fecha_entrada = fechaEntrada;
    this.Fecha_Salida = fechaSalida;
    if (validarNumeroHabitaciones(numeroHabitaciones)) {
        this.numeroHabitaciones = numeroHabitaciones;
    } else {
        System.out.println("Error: el número de habitaciones debe ser mayor que 0.");
    }
    if (validarPrecio(precioTotal)) {
        this.precioTotal = precioTotal;
    } else {
        System.out.println("Error: el precio total debe ser mayor que 0.");
    }
}

    // constructor de copia 
     public Reserva (Reserva otraReserva){
        this.dniCliente = otraReserva.dniCliente;
        this.Fecha_Salida = otraReserva.Fecha_Salida;
        this.numeroHabitaciones = otraReserva.numeroHabitaciones;
        this.precioTotal = otraReserva.precioTotal;
        
    }
// metodos geter y seter y sus comprobaciones
    public String getDniCliente() {
        return dniCliente;
    }

  public void setDniCliente(String dniCliente) {
    if (validardniCliente(dniCliente)) {
        this.dniCliente = dniCliente;
    } else {
        System.out.println("Error: el DNI del cliente proporcionado no es válido.");
    }
}

    public Date getFecha_entrada() {
        return Fecha_entrada;
    }

    public void setFecha_entrada(Date Fecha_entrada) {
        this.Fecha_entrada = Fecha_entrada;
    }

    public Date getFecha_Salida() {
        return Fecha_Salida;
    }

    public void setFecha_Salida(Date Fecha_Salida) {
        this.Fecha_Salida = Fecha_Salida;
    }

    public int getNumeroHabitaciones() {
        return numeroHabitaciones;
    }

   public void setNumeroHabitaciones(int numeroHabitaciones) {
    if (numeroHabitaciones > 0) {
        this.numeroHabitaciones = numeroHabitaciones;
    } else {
        System.out.println("Error: el número de habitaciones debe ser mayor que 0.");
    }
}

    public double getPrecioTotal() {
        return precioTotal;
    }

   public void setPrecioTotal(double precioTotal) {
    if (validarPrecio(precioTotal)) {
        this.precioTotal = precioTotal;
    } else {
        System.out.println("Error: el precio total debe ser mayor que 0.");
    }
   }
    
    //  validaciones
   public boolean validardniCliente(String idCliente) {
    // Patrón que verifica si el ID tiene cuatro números seguidos de una letra
    String patronID = "\\d{4}[a-zA-Z]";
    return Pattern.matches(patronID, idCliente);
   }
   
   public boolean validarPrecio(double precio) {
    return precio > 0;
}

   
   public boolean validarNumeroHabitaciones(int numeroHabitaciones) {
    return numeroHabitaciones > 0;
}
   // metodo leer reserva 
   public boolean leerReserva() throws ParseException {
        Scanner leer = new Scanner(System.in);
        System.out.println("Ingrese el DNI del cliente:");
        String dniCliente = leer.nextLine();
        if (!validardniCliente(dniCliente)) {
            System.out.println("Error: DNI del cliente no válido.");
            return false;
        }
        setDniCliente(dniCliente);

        System.out.println("Ingrese la fecha de entrada (formato dd/MM/yyyy):");
        SimpleDateFormat formatoFecha = new SimpleDateFormat("dd/MM/yyyy");
        Date fechaEntrada = formatoFecha.parse(leer.nextLine());
        setFecha_entrada(fechaEntrada);

        System.out.println("Ingrese la fecha de salida (formato dd/MM/yyyy):");
        Date fechaSalida = formatoFecha.parse(leer.nextLine());
        setFecha_Salida(fechaSalida);

        System.out.println("Ingrese el número de habitaciones:");
        int numHabitaciones = Integer.parseInt(leer.nextLine());
        if (numHabitaciones <= 0) {
            System.out.println("Error: El número de habitaciones debe ser mayor que 0.");
            return false;
        }
        setNumeroHabitaciones(numHabitaciones);

        System.out.println("Ingrese el precio total:");
        double precioTotal = Double.parseDouble(leer.nextLine());
        if (precioTotal <= 0) {
            System.out.println("Error: El precio total debe ser mayor que 0.");
            return false;
        }
        setPrecioTotal(precioTotal);

        leer.close();
        return true; // La reserva se ha leído correctamente
    }
   
   // metodo para mostrar el hotel 
   @Override
    public String toString() {
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        return "Reserva{" +
                "dniCliente='" + dniCliente + '\'' +
                ", Fecha_entrada=" + dateFormat.format(Fecha_entrada) +
                ", Fecha_Salida=" + dateFormat.format(Fecha_Salida) +
                ", numeroHabitaciones=" + numeroHabitaciones +
                ", precioTotal=" + precioTotal +
                '}';
    }

    @Override
    public int compareTo (Reserva otraReserva) {
        return this.getDniCliente().compareTo(otraReserva.getDniCliente());
    }
}
