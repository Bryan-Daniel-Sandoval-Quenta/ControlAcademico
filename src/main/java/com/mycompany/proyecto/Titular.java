package com.mycompany.proyecto;

import java.util.Scanner;

public class Titular extends Docente{
    private int antiguedadAños;
    private String nivelFormacion;
    public  Titular(String nombre,int ci,int edad,String tipoDocente,double sueldo,int nroMateria,int antiguedadAños,String nivelFormacion){
        super(nombre,ci,edad,tipoDocente,sueldo,nroMateria);
       this.antiguedadAños=antiguedadAños;
       this.nivelFormacion=nivelFormacion;
    }
    public void leer(){
        Scanner b=new Scanner(System.in);
        System.out.println("Ingrese su antiguedad de años de trabajo");
        antiguedadAños=b.nextInt();
        System.out.println("Ingrese su nivel de formacion academico");
        nivelFormacion=b.nextLine();
        
    }
    public void mostrar(){
        System.out.println("Su antiguedad ingresada es : "+antiguedadAños);
        System.out.println("Su nivel de formacion ingresada es : "+nivelFormacion);
    }
}
