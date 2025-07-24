package com.mycompany.proyecto;

<<<<<<< HEAD
public class Asistencia {
=======
import java.io.Serializable;

public class Asistencia implements Serializable{
>>>>>>> 680e56a7c0d43cc4fa530c60b13b9fbe1d4ad9bc
   
    private String fecha;
    private boolean asistencia;
    private String materia;

<<<<<<< HEAD
    public Asistencia(String fecha, int ci, int registroUniv, String materia, boolean asistencia) {
=======
    public Asistencia(String fecha, String materia, boolean asistencia) {
>>>>>>> 680e56a7c0d43cc4fa530c60b13b9fbe1d4ad9bc
        this.fecha = fecha;
        this.asistencia = asistencia;
        this.materia = materia;
    }

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
        System.out.println("Fecha: " + fecha);
<<<<<<< HEAD
        System.out.println("Asistencia: " + (asistencia ?"Presente" : "Ausente"));
=======
        System.out.println("Asistencia: " + asistencia);
>>>>>>> 680e56a7c0d43cc4fa530c60b13b9fbe1d4ad9bc
        System.out.println("Materia: " + materia);
    }

    public void mostrar() {
<<<<<<< HEAD
        System.out.println("Asistencia registrada: " + fecha + ", " + materia + " - " + (asistencia ?"Presente" : "Ausente"));
=======
        System.out.println("Asistencia registrada: " + fecha + ", " + materia);
       if(asistencia){
              System.out.println("Presente");
    }else{
           System.out.println("ausente");
       }       
>>>>>>> 680e56a7c0d43cc4fa530c60b13b9fbe1d4ad9bc
    }
}
    

