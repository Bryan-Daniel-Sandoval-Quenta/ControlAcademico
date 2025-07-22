package com.mycompany.proyecto;

public class Asistencia {
   
    private String fecha;
    private boolean asistencia;
    private String materia;

    public Asistencia(String fecha, int ci, int registroUniv, String materia, boolean asistencia) {
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
        System.out.println("Asistencia: " + (asistencia ? "Presente" : "Ausente"));
        System.out.println("Materia: " + materia);
    }

    public void mostrar() {
        System.out.println("Asistencia registrada: " + fecha + ", " + materia + " - " + (asistencia ? "Presente" : "Ausente"));
    }
}
    

