package com.mycompany.proyecto;

<<<<<<< HEAD
import java.util.Scanner;

public class Titular extends Docente{
    private int antiguedadAños;
    private String nivelFormacion;
    public  Titular(String nombre,int ci,int edad,String tipoDocente,double sueldo,int nroMateria,int antiguedadAños,String nivelFormacion){
        super(nombre,ci,edad,tipoDocente,sueldo,nroMateria);
       this.antiguedadAños=antiguedadAños;
       this.nivelFormacion=nivelFormacion;
    }

    public int getAntiguedadAños() {
        return antiguedadAños;
    }

    public void setAntiguedadAños(int antiguedadAños) {
        this.antiguedadAños = antiguedadAños;
    }

    public String getNivelFormacion() {
        return nivelFormacion;
    }

    public void setNivelFormacion(String nivelFormacion) {
        this.nivelFormacion = nivelFormacion;
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
=======
import java.io.Serializable;
import java.util.Scanner;

public class Titular extends Docente implements Serializable{

    private int antiguedadAños;
    private String nivelFormacion;

    public Titular(String nombre, int ci, int edad, String tipoDocente, double sueldo, int nroMateria, int antiguedadAños, String nivelFormacion) {
        super(nombre, ci, edad, tipoDocente, sueldo, nroMateria);
        this.antiguedadAños = antiguedadAños;
        this.nivelFormacion = nivelFormacion;
    }
    
    public Titular(){
        super();
    }

    public void leer() {
        Scanner b = new Scanner(System.in);
        System.out.println("Ingrese su antiguedad de años de trabajo");
        antiguedadAños = b.nextInt();
        System.out.println("Ingrese su nivel de formacion academico");
        nivelFormacion = b.nextLine();

    }

    public void mostrar() {
        System.out.println("Su antiguedad ingresada es : " + antiguedadAños);
        System.out.println("Su nivel de formacion ingresada es : " + nivelFormacion);
    }

    public int getAntiguedadAños() {
        return antiguedadAños;
    }

    public void setAntiguedadAños(int antiguedadAños) {
        this.antiguedadAños = antiguedadAños;
    }

    public String getNivelFormacion() {
        return nivelFormacion;
    }

    public void setNivelFormacion(String nivelFormacion) {
        this.nivelFormacion = nivelFormacion;
>>>>>>> 680e56a7c0d43cc4fa530c60b13b9fbe1d4ad9bc
    }
}
