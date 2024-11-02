/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.ej_academia_examen;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author Antonio Antonio Cano
 */
public class Curso {
    private String nombreCurso;
    private int evaluacion1;
    private int evaluacion2;
    private Date fecha;

    public Curso() {
        // Default constructor
    }

    public Curso(String nombreCurso, int evaluacion1, int evaluacion2, Date fecha) {
        if (nombreCurso.length() > 20 || !validarNombre(nombreCurso)) {
            throw new IllegalArgumentException("El nombre no es válido.");
        }
        if (evaluacion1 < 0 || evaluacion1 > 10) {
            throw new IllegalArgumentException("La nota tiene que ser un número entre 1 y 10");
        }
        if (evaluacion2 < 0 || evaluacion2 > 10) {
            throw new IllegalArgumentException("La nota tiene que ser un número entre 1 y 10");
        }
        this.nombreCurso = nombreCurso;
        this.evaluacion1 = evaluacion1;
        this.evaluacion2 = evaluacion2;
        this.fecha = fecha;
    }

    public Curso(Curso otroCurso) {
        this.nombreCurso = otroCurso.nombreCurso;
        this.evaluacion1 = otroCurso.evaluacion1;
        this.evaluacion2 = otroCurso.evaluacion2;
        this.fecha = otroCurso.fecha;
    }

    public String getNombreCurso() {
        return nombreCurso;
    }

    public void setNombreCurso(String nombreCurso) {
        if (nombreCurso.length() > 20 || !validarNombre(nombreCurso)) {
            throw new IllegalArgumentException("El nombre no es válido.");
        }
        this.nombreCurso = nombreCurso;
    }

    public int getEvaluacion1() {
        return evaluacion1;
    }

    public void setEvaluacion1(int evaluacion1) {
        if (evaluacion1 < 0 || evaluacion1 > 10) {
            throw new IllegalArgumentException("La nota tiene que ser un número entre 1 y 10");
        }
        this.evaluacion1 = evaluacion1;
    }

    public int getEvaluacion2() {
        return evaluacion2;
    }

    public void setEvaluacion2(int evaluacion2) {
        if (evaluacion2 < 0 || evaluacion2 > 10) {
            throw new IllegalArgumentException("La nota tiene que ser un número entre 1 y 10");
        }
        this.evaluacion2 = evaluacion2;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public void mostrarCurso() {
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        String fechaStr = dateFormat.format(fecha);
        System.out.println("Nombre del curso: " + nombreCurso);
        System.out.println("Nota de la primera evaluación: " + evaluacion1);
        System.out.println("Nota de la segunda evaluación: " + evaluacion2);
        System.out.println("Fecha: " + fechaStr);
    }

    public static Curso leerCurso() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Introduce el nombre del curso:");
        String nombreCurso = scanner.nextLine();

        System.out.println("Introduce la nota de la primera evaluación:");
        int evaluacion1 = scanner.nextInt();

        System.out.println("Introduce la nota de la segunda evaluación:");
        int evaluacion2 = scanner.nextInt();

        System.out.println("Introduce la fecha del curso (formato dd/MM/yyyy):");
        String fechaStr = scanner.next();

        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        Date fecha = null;
        try {
            fecha = dateFormat.parse(fechaStr);
        } catch (ParseException e) {
            System.out.println("Formato de fecha inválido. Introduce la fecha en formato dd/MM/yyyy.");
        }

        return new Curso(nombreCurso, evaluacion1, evaluacion2, fecha);
    }

    public static boolean validarNombre(String nombre) {
        String regex = "^[a-zA-ZáéíóúÁÉÍÓÚüÜñÑ\\s]+(?:\\s[a-zA-ZáéíóúÁÉÍÓÚüÜñÑ]+)*$";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(nombre);
        return matcher.matches();
    }
}