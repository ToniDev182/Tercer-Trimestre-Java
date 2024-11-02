/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mapalmacenp;

/**
 *
 * @author Antonio Atienza Cano
 */
import java.util.Objects;
import java.util.Scanner;
import java.util.regex.Pattern;

public class Producto {

    private String marca, modelo, tipo, codigo;
    private int precio;

    // Constructor parametrizado con validación de precio y código
    public Producto(String marca, String modelo, String tipo, int precio, String codigo) {
        this.marca = marca;
        this.modelo = modelo;
        this.tipo = tipo;
        if (validarPrecio(precio)) {
            this.precio = precio;
        } else {
            throw new IllegalArgumentException("El precio no es válido.");
        }
        if (validarCodigo(codigo)) {
            this.codigo = codigo;
        } else {
            throw new IllegalArgumentException("El código no es válido.");
        }
    }

    // Validar precio con expresión regular
    public static boolean validarPrecio(int precio) {
        String regex = "\\d+";
        return String.valueOf(precio).matches(regex);
    }

    // Validar código con expresión regular
    public static boolean validarCodigo(String codigo) {
        String patronCodigo = "\\d{4}[a-zA-Z]";
        return Pattern.matches(patronCodigo, codigo);
    }

    // Leer datos del producto desde la entrada estándar
    public void leerProducto() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Introduce la marca del producto:");
        this.marca = scanner.nextLine();
        System.out.println("Introduce el modelo del producto:");
        this.modelo = scanner.nextLine();
        System.out.println("Introduce el tipo del producto:");
        this.tipo = scanner.nextLine();
        System.out.println("Introduce el precio del producto:");
        this.precio = scanner.nextInt();
        scanner.nextLine(); // Consumir el salto de línea
        System.out.println("Introduce el código del producto:");
        this.codigo = scanner.nextLine();
        // Validar el precio y el código
        if (!validarPrecio(this.precio) || !validarCodigo(this.codigo)) {
            throw new IllegalArgumentException("El precio o el código no son válidos.");
        }
    }

    // Getters y setters

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        if (validarCodigo(codigo)) {
            this.codigo = codigo;
        } else {
            throw new IllegalArgumentException("El código no es válido.");
        }
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public int getPrecio() {
        return precio;
    }

    public void setPrecio(int precio) {
        if (validarPrecio(precio)) {
            this.precio = precio;
        } else {
            throw new IllegalArgumentException("El precio no es válido.");
        }
    }

    // Otros métodos

    @Override
    public String toString() {
        return "Producto{" +
                "marca='" + marca + '\'' +
                ", modelo='" + modelo + '\'' +
                ", tipo='" + tipo + '\'' +
                ", codigo='" + codigo + '\'' +
                ", precio=" + precio +
                '}';
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        Producto producto = (Producto) obj;
        return Objects.equals(codigo, producto.codigo);
    }

    public int compareTo(Producto otroProducto) {
        return this.codigo.compareTo(otroProducto.codigo);
    }

    public void mostrarProducto() {
        System.out.println("Marca: " + marca);
        System.out.println("Modelo: " + modelo);
        System.out.println("Tipo: " + tipo);
        System.out.println("Precio: " + precio);
        System.out.println("Código: " + codigo);
    }
}
