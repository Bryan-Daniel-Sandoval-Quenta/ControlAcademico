package com.mycompany.proyecto;

import java.util.Scanner;

public class Persona {
    protected String nombre;
    protected int ci;
    protected int edad;

    public Persona(String nombre, int ci, int edad) {
        this.nombre = nombre;
        this.ci = ci;
        this.edad = edad;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getCi() {
        return ci;
    }

    public void setCi(int ci) {
        this.ci = ci;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }
    
    public void mostrar() {
        System.out.println("Nombre: " + nombre);
        System.out.println("CI: " + ci);
        System.out.println("Edad: " + edad);
    }
    
    public void leer(){
        Scanner sc=new Scanner(System.in);
    
        System.out.println("Ingrese nombre:.  ");
        nombre=sc.nextLine();
                
        System.out.println("Ingrese ci: ");
        ci=sc.nextInt();
        
        System.out.println("Ingrese edad: ");
        edad=sc.nextInt();
        sc.nextLine();
    }
}
