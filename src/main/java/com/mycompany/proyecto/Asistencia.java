package com.mycompany.proyecto;

import java.io.Serializable;
import java.util.Scanner;

public class Asistencia implements Serializable{
   
    private String fecha;
    private boolean asistencia;
    private String materia;

    public Asistencia(String fecha, String materia, boolean asistencia) {
        this.fecha = fecha;
        this.asistencia = asistencia;
        this.materia = materia;
    }
    
    public Asistencia(){}

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public boolean isAsistencia() {
        return asistencia;
    }

    public void setAsistencia(boolean asistencia) {
        this.asistencia = asistencia;
    }

    public String getMateria() {
        return materia;
    }

    public void setMateria(String materia) {
        this.materia = materia;
    }

    public void leer() {
        Scanner lec = new Scanner(System.in);
        System.out.println("Ingrese la fecha: ");
        fecha = lec.nextLine();
        
        System.out.println("Ingrese si asistio (true) si falto (false): ");
        asistencia = lec.nextBoolean();
        lec.nextLine();
        
        System.out.println("ingrese la materia del parcial: ");
        materia = lec.nextLine();
    }

    public void mostrar() {
        System.out.println("Asistencia registrada: " + fecha + ", " + "materia: " + materia);
       if(asistencia){
              System.out.println("Presente");
    }else{
           System.out.println("ausente");
       }       
    }
}
    

