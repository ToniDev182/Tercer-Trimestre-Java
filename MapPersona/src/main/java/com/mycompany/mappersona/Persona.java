/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.mappersona;

import java.util.Scanner;
import java.util.regex.Pattern;

/**
 *
 * @author Antonio Atienza cano
 */
public class Persona {
    private String nombre, apellidos, direccion, telefono;
  
    //constructor de copia
    public Persona (Persona p){
        this.nombre = p.nombre;
        this.apellidos = p.apellidos;        
        this.telefono = p.telefono;
        this.direccion = p.direccion;
    }
    //constructor por defecto
    public Persona (){
    }
    // constructor parametrizado
    public Persona(String nombre, String apellidos, String dni, String direccion, String telefono) {
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.direccion = direccion;
        if(validarTelefono(telefono))
            this.telefono=telefono;
        else
            this.telefono="";
    }

    // Métodos getter y setter

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


    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }
    public String getTelefono(){
        return telefono;
    }
    public void setTelefono(String telefono){
        if(!validarTelefono(telefono)){
            System.out.println("No se ha actualizado el telefono por que el telefono introducido es incorrecto");
            this.telefono = "";
        }else{
            this.telefono = telefono;
        }
    }
    
   
 //consideramos que el numero de telefono debe tener 9 digitos
    private boolean validarTelefono (String t){
        String patronTelefono = "\\d{9}[0-9]";
        return Pattern.matches(patronTelefono, t);
    }

    /**
     * Método que nos permite leer los datos de una persona por teclado
     * y crear un nuevo objeto de tipo persona con estos datos
     */
    public void leerPersona(){
        Scanner leer = new Scanner(System.in);
        System.out.println("Ingrese su nombre:");
        String Nombre = leer.nextLine();
        setNombre(Nombre);
        System.out.println("Ingrese sus apellidos:");
        String Apellidos = leer.nextLine();
        setApellidos(Apellidos);
        System.out.println("Ingrese la direccion:");
        String Direccion = leer.nextLine();
        setDireccion(Direccion);
        System.out.println("Ingrese el telefono");
        String Telefono = leer.nextLine();
        setTelefono(Telefono);
      
    }
        public void MostrarDatos(){
        System.out.println("El nombre de la persona " + getNombre() + ", los apellidos de la persona" + getApellidos() 
        +" la direción es " + getDireccion() + " y el telefono es " + getTelefono()+'\n');
        
        
    }
    }