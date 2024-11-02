/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package hotelpalace;

/**
 *
 * @author Antonio Atienza Cano
 */
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.Iterator;
import java.util.Scanner;

public class Gestion_Reservas {
    // Escaner
     Scanner escaner = new Scanner (System.in);
     //Atributos
     private ArrayList <Hotel> hotel;
      private ArrayList <Cliente> cliente;
      private ArrayList <Reserva> reserva; 
      
      // constructor por defeto 
      
      public Gestion_Reservas (){
          hotel = new ArrayList<>();
          cliente = new ArrayList<>();
          reserva = new ArrayList<>();
      }
     
      // contructro de copia
      public Gestion_Reservas(ArrayList<Hotel> h, ArrayList<Cliente> c, ArrayList<Reserva> r){
          this.hotel = h;
          this.cliente = c;
          this.reserva = r;
                   
      }
      
      // constructor de copia
      public Gestion_Reservas (Gestion_Reservas gr){
          this.hotel = gr.hotel;
          this.cliente = gr.cliente;
          this.reserva = gr.reserva; 
          
      }
// getters y seters 
    public ArrayList<Hotel> getHotel() {
        return hotel;
    }

    public void setHotel(ArrayList<Hotel> hotel) {
        this.hotel = hotel;
    }

    public ArrayList<Cliente> getCliente() {
        return cliente;
    }

    public void setCliente(ArrayList<Cliente> cliente) {
        this.cliente = cliente;
    }

    public ArrayList<Reserva> getReserva() {
        return reserva;
    }

    public void setReserva(ArrayList<Reserva> reserva) {
        this.reserva = reserva;
    }
          
      //insertar cliente
    
    public boolean insertarCliente (){
        Cliente c = new Cliente();
        if (c.leerCliente()){ // si leemos el cliente lo insertamos
          return this.cliente.add(c); // devuelve true si se inserta el cliente
          
        }    
    else
            return false;
    }
    
    // isertar un hotel
      public boolean insertarHotel() {
        Hotel h = new Hotel();
        if(h.leerHotel()){ //Si hemos podido leer el hotel la insertamos
            return this.hotel.add(h); //Devuelve True si se pudo insertar el hotel y false en caso contrario
        }
        else
            return false; //Fallo en la lectura de datos
            
    }
      // insertar un reserva
            public boolean insertarReserva() throws ParseException {
        Reserva r = new Reserva();
        if(r.leerReserva()){ //Si hemos podido leer la reserva la insertamos
            return this.reserva.add(r); //Devuelve True si se pudo insertar la reserva y false en caso contrario
        }
        else
            return false; //Fallo en la lectura de datos
            
    }
       
             
    //Busca un cliente por su ID y devuelve un iterador a la posición de memoria en el arraylist que se encuentra este Cliente
    public Iterator<Cliente> BuscarCliente(String idCliente){
   /*Recorremos el arraylist de clientes con un iterador. 
     Si encontramos el cliente cuyo id coincide con el parámetro del método
        devolvemos su posición en el arraylist a través de el iterador*/
    Iterator<Cliente> it = cliente.iterator();
    while(it.hasNext()){
        if(it.next().getIdCliente().equals(idCliente))
            return it;
    }
    return it;
            
    }
       //Busca un Hotel por su ID y devuelve un iterador a la posición de memoria en el arraylist que se encuentra este hotel
    public Iterator<Hotel> BuscarHotel (String idHotel){
   /*Recorremos el arraylist de clientes con un iterador. 
     Si encontramos el cliente cuyo id coincide con el parámetro del método
        devolvemos su posición en el arraylist a través de el iterador*/
    Iterator<Hotel> it = hotel.iterator();
    while(it.hasNext()){
        if(it.next().getidHotel().equals(idHotel))
            return it;
    }
    return it;
            
    }
    
    // Eliminar cliente
     public boolean eliminarCliente() {
        System.out.println("Introduce el idCliente a eliminar: ");
        String idCliente = escaner.next();
        //Buscamos el Cliente
        Iterator<Cliente> it = BuscarCliente(idCliente);
        if(it==null) {
            System.out.println("El Cliente con ese ID no está en la base de datos");
            return false;
        } 
        else {
            it.remove();
            return true;
        }
     }
     
      public boolean eliminarHotel() {
        System.out.println("Introduce el idHotel a eliminar: ");
        String idHotel = escaner.next();
        //Buscamos el Hotel
        Iterator<Hotel> it = BuscarHotel(idHotel);
        if(it==null) {
            System.out.println("El Hotel con ese ID no está en la base de datos");
            return false;
        } 
        else {
            it.remove();
            return true;
        }
     }
      
         /*Método para listar todos los clientes*/
    public void ListarClientes(){
        for(Cliente c: cliente){
            c.mostrarCliente(c);
        }
    }
     /*Método para listar todas las vacunas*/
    public void ListarHotel(){
        for(Hotel h:hotel){
            h.mostrarHotel(h);
        }
    }
    // ordenar por nacionalidad mediante un short
      public void ordenarClientesPorNacionalidad() {
        Collections.sort(cliente, new Comparator<Cliente>() {
            @Override
            public int compare(Cliente c1, Cliente c2) {
                return c1.getNacionalidad().compareTo(c2.getNacionalidad());
            }
        });
      }
      
      // buscar por DNI creando un iterador sobre el cliente 
         public Cliente buscarClientePorDNI(String idCliente) {
        Iterator<Cliente> iterador = cliente.iterator();
        while (iterador.hasNext()) {
            Cliente clienteActual = iterador.next();
            if (clienteActual.getIdCliente().equals(idCliente)) {
                return clienteActual; // Devuelve el cliente si se encuentra
            }
        }
        return null; // Devuelve null si no se encuentra ningún cliente con ese DNI
    }
         
     public void listarReservasPorPeriodo(String idHotel, Date fechaInicio, Date fechaFin) {
    // Buscar el hotel por su ID iterando sobre un hotel
    Hotel hotelSeleccionado = null;
    for (Hotel h : hotel) {
        if (h.getidHotel().equals(idHotel)) { 
            hotelSeleccionado = h;
            break;
        }
    }
    
    if (hotelSeleccionado == null) {
        System.out.println("No se encontró un hotel con el ID especificado.");
        return;
    }
    
    // mostramos las fechas en un formato concreto
    SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
    
    // Iterar sobre las reservas para el hotel seleccionado
    for (Reserva r : reserva) {
        // Verificamos si la reserva pertenece al hotel seleccionado
        if (r.getidHotel().equals(idHotel)) { 
            // Verificar si la reserva está dentro del período especificado
            if (r.getFecha_entrada().compareTo(fechaInicio) >= 0 && r.getFechaSalida().compareTo(fechaFin) <= 0) { // Cambio "getFecha_entrada()" y "getFecha_Salida()" a "getFechaEntrada()" y "getFechaSalida()"
                // Mostrar la información de la reserva
                System.out.println("Nombre del Hotel: " + hotelSeleccionado.getNombre());
                System.out.println("ID del Cliente: " + r.getIdCliente()); // Asumiendo que getIdCliente() devuelve el ID del cliente asociado a la reserva
                System.out.println("Fecha de Entrada: " + dateFormat.format(r.getFecha_entrada())); // Cambio "getFecha_entrada()" a "getFechaEntrada()"
                System.out.println("Fecha de Salida: " + dateFormat.format(r.getFecha_Salida())); // Cambio "getFecha_Salida()" a "getFechaSalida()"
                System.out.println("--------------------------------------------");
            }
        }
    }
}
}
 





      
    

