package com.mycompany.proyecto;

import java.io.Serializable;
import java.util.Scanner;

public class Contratado extends Docente implements Serializable{
    private int horasContratado;
    private double pagoHora;
    public Contratado(String nombre,int ci,int edad,String tipoDocente,double sueldo,int nroMateria,int horasContratado,double pagoHora){
        super(nombre,ci,edad,tipoDocente,sueldo,nroMateria);
        this.horasContratado=horasContratado;
        this.pagoHora=pagoHora;
    }
    
    public Contratado(){
        super();
    }
    
    @Override
    public void leer(){
        Scanner a =new Scanner(System.in);
        super.leer();
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
