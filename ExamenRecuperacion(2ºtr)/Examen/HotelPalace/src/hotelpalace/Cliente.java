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
public class Cliente implements Comparable <Cliente> {
    
    private String idCliente;
    private String nombre;
    private String apellidos;
    private String nacionalidad;
    private String email;
    private String telefono; 
    
    // Constructor por defecto
    public Cliente(){
        idCliente= "";
         nombre= "";
         apellidos="";
         nacionalidad= "";
         email="";     
        telefono="";
                 
    }
// constructor parametrizado
    // Constructor parametrizado para la clase Cliente
public Cliente(String idCliente, String nombre, String apellidos, String nacionalidad, String email, String telefono) {
    if (validarIDCliente(idCliente)) {
        this.idCliente = idCliente;
    } else {
        this.idCliente = ""; // Asignación de valor por defecto en caso de ID no válido
        System.out.println("Error al asignar datos, el ID del cliente proporcionado no es válido.");
    }
    this.nombre = nombre;
    this.apellidos = apellidos;
    this.nacionalidad = nacionalidad;
    if (validarEmail(email)) {
        this.email = email;
    } else {
        this.email = ""; // Asignación de valor por defecto en caso de email no válido
        System.out.println("Error al asignar datos, el correo electrónico proporcionado no es válido.");
    }
    if (validarTelefono(telefono)) {
        this.telefono = telefono;
    } else {
        this.telefono = ""; // Asignación de valor por defecto en caso de teléfono no válido
        System.out.println("Error al asignar datos, el número de teléfono proporcionado no es válido.");
    }
}

    // contructor de coia
      public Cliente(Cliente otroCliente) {
        this.idCliente = otroCliente.idCliente;
        this.nombre = otroCliente.nombre;
        this.apellidos = otroCliente.apellidos;
        this.nacionalidad = otroCliente.nacionalidad;
        this.email = otroCliente.email;
        this.telefono = otroCliente.telefono;
    }
// geters y setters y comprovaciones 
    public String getIdCliente() {
        return idCliente;
    }

  public void setIdCliente(String idCliente) {
    if(validarIDCliente(idCliente)) {
        this.idCliente = idCliente;
    } else {
        System.out.println("Error al asignar datos, el ID del cliente proporcionado no es válido.");
    }
}

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getNacionalidad() {
        return nacionalidad;
    }

    public void setNacionalidad(String nacionalidad) {
        this.nacionalidad = nacionalidad;
    }

    public String getEmail() {
        return email;
    }

   public void setEmail(String emailCliente) {
    if(validarEmail(email)) {
        this.email = emailCliente;
    } else {
        System.out.println("Error al asignar datos, el correo electrónico proporcionado no es válido.");
    }
}

    public String getTelefono() {
        return telefono;
    }

   public void setTelefonoCliente(String telefonoCliente) {
    if(validarTelefono(telefonoCliente)) {
        this.telefono = telefonoCliente;
    } else {
        System.out.println("Error al asignar datos, el número de teléfono proproporcionado no es válido.");
}
   }
     
         
    // Metodo mostrar cliente 
         public void mostrarCliente(Cliente cliente) {
        System.out.println("ID del Cliente: " + cliente.getIdCliente());
        System.out.println("Nombre: " + cliente.getNombre());
        System.out.println("Apellidos: " + cliente.getApellidos());
        System.out.println("Nacionalidad: " + cliente.getNacionalidad());
        System.out.println("Correo electrónico: " + cliente.getEmail());
        System.out.println("Teléfono: " + cliente.getTelefono());
    }
         // leer Cliente 
         public boolean leerCliente() {
        Scanner leer = new Scanner(System.in);
        System.out.println("Escribe los datos respetando el formato del dato correspondiente.");
        System.out.println("Ingrese el ID del cliente (formato: 4 números seguidos de una letra): ");
        String idCliente = leer.nextLine();
        setIdCliente(idCliente);
        
        if (!this.idCliente.isEmpty()) {
            System.out.println("Ingrese el nombre del cliente: ");
            String nombre = leer.nextLine();
            setNombre(nombre);
            
            System.out.println("Ingrese los apellidos del cliente: ");
            String apellidos = leer.nextLine();
            setApellidos(apellidos);
            
            System.out.println("Ingrese la nacionalidad del cliente: ");
            String nacionalidad = leer.nextLine();
            setNacionalidad(nacionalidad);
            
            System.out.println("Ingrese el correo electrónico del cliente: ");
            String email = leer.nextLine();
            setEmail(email);
            
            System.out.println("Ingrese el número de teléfono del cliente: ");
            String telefono = leer.nextLine();
            setTelefonoCliente(telefono);
            
            return true;
        } else {
            return false;
        }
    }
         
    // VALIDACIONES
    public boolean validarIDCliente(String idCliente) {
    // Patrón que verifica si el ID tiene cuatro números seguidos de una letra
    String patronID = "\\d{4}[a-zA-Z]";
    return Pattern.matches(patronID, idCliente);
}

public boolean validarEmail(String email) {
    // Patrón que verifica si el email tiene el formato correcto
    String patronEmail = "^[a-zA-Z0-9_+&*-]+(?:\\.[a-zA-Z0-9_+&*-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,7}$";
    return Pattern.matches(patronEmail, email);
    
}

public boolean validarTelefono(String telefono) {
    // Patrón que verifica si el número de teléfono tiene el formato correcto
    String patronTelefono = "^\\+(?:[0-9] ?){6,14}[0-9]$";
    return Pattern.matches(patronTelefono, telefono);
}
@Override
    public int compareTo (Cliente otroCliente ) {
        return this.getIdCliente().compareTo(otroCliente.getIdCliente());
    }

}
