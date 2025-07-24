package com.mycompany.proyecto;

<<<<<<< HEAD
import java.util.Scanner;

public class Contratado extends Docente{
=======
import java.io.Serializable;
import java.util.Scanner;

public class Contratado extends Docente implements Serializable{
>>>>>>> 680e56a7c0d43cc4fa530c60b13b9fbe1d4ad9bc
    private int horasContratado;
    private double pagoHora;
    public Contratado(String nombre,int ci,int edad,String tipoDocente,double sueldo,int nroMateria,int horasContratado,double pagoHora){
        super(nombre,ci,edad,tipoDocente,sueldo,nroMateria);
        this.horasContratado=horasContratado;
        this.pagoHora=pagoHora;
    }
<<<<<<< HEAD

    public int getHorasContratado() {
        return horasContratado;
    }

    public void setHorasContratado(int horasContratado) {
        this.horasContratado = horasContratado;
    }

    public double getPagoHora() {
        return pagoHora;
    }

    public void setPagoHora(double pagoHora) {
        this.pagoHora = pagoHora;
    }
    
    public void leer(){
        Scanner a =new Scanner(System.in);
=======
    
    public Contratado(){
        super();
    }
    
    @Override
    public void leer(){
        Scanner a =new Scanner(System.in);
        super.leer();
>>>>>>> 680e56a7c0d43cc4fa530c60b13b9fbe1d4ad9bc
        System.out.println("Ingrese las horas de contrato");
        horasContratado= a.nextInt();
        System.out.println("Ingrese el pago por hora");
        pagoHora=a.nextDouble();
    }
    public void mostrar(){
        System.out.println("Las horas de contrato es: "+ horasContratado);
        System.out.println("El pago por horas es: "+ pagoHora);
    }
}
