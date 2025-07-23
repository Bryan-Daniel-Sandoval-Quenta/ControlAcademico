package com.mycompany.proyecto;

import java.util.Scanner;

public class Nota {
   
    private double valor;
    private String fecha;
    private String materia;
    private String tipoParcial;
    private Docente docenteEvaluador;

    public Nota(String fecha, String materia, String tipoParcial, Docente docenteEvaluador) {
        this.fecha = fecha;
        this.materia = materia;
        this.tipoParcial = tipoParcial;
        this.docenteEvaluador = docenteEvaluador;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getMateria() {
        return materia;
    }

    public void setMateria(String materia) {
        this.materia = materia;
    }

    public String getTipoParcial() {
        return tipoParcial;
    }

    public void setTipoParcial(String tipoParcial) {
        this.tipoParcial = tipoParcial;
    }

    public Docente getDocenteEvaluador() {
        return docenteEvaluador;
    }

    public void setDocenteEvaluador(Docente docenteEvaluador) {
        this.docenteEvaluador = docenteEvaluador;
    }

    public void leer() {
        Scanner sc=new Scanner(System.in);
    
        System.out.println("Ingrese el valor:.  ");
        valor=sc.nextInt();
                
        System.out.println("Ingrese la fecha: ");
        fecha=sc.nextLine();
        
        System.out.println("Ingrese la materia: ");
        materia=sc.nextLine();
        
        System.out.println("Ingrese Tipo de parcial: ");
        tipoParcial=sc.nextLine();
        
        System.out.println("Ingrese los datos del docente: ");
        docenteEvaluador.leer();
       
    }

    public void mostrar() {
        System.out.println("Nota registrada: " + fecha + ", " + materia + " - " + tipoParcial);
          if(docenteEvaluador != null){
            System.out.println("Evaluador: " + docenteEvaluador.getNombre());
      }
    }
}
