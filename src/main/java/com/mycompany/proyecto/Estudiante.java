package com.mycompany.proyecto;

import java.io.Serializable;

public class Estudiante extends Persona implements Serializable{
    private int registroUniversitario;
    private String carrera;
    private String materiasInscrito[];
    private int nroMaterias;
    private Registro<Nota> regisNota; 
    private Registro<Asistencia> regisAsistencia; 
    
    public Estudiante(String nombre, int ci, int edad, int registroUniversitario, String carrera){
        super(nombre, ci, edad);
        this.registroUniversitario = registroUniversitario;
        this.carrera = carrera;
        this.nroMaterias = 0;
        this.regisNota = new Registro<>();
        this.regisAsistencia = new Registro<>();
    }
    
    @Override
    public void mostrar(){
        super.mostrar();
        System.out.println("registro universitario: " + registroUniversitario + ", carrera: " + carrera + ", nro de materias: " + nroMaterias);
        for(int i = 0; i < nroMaterias; i++){
            System.out.println("materia " + i + ": " + materiasInscrito[i]);
        }
    }
}