package com.mycompany.proyecto;

import java.io.Serializable;
import java.util.Scanner;

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
        this.materiasInscrito = new String[7];
        this.regisNota = new Registro<>(null,0,"");
        this.regisAsistencia = new Registro<>(null,0,"");
    }
    
    public Estudiante(){
        super("", 0, 0);
    }
    
    @Override
    public void mostrar(){
        super.mostrar();
        System.out.println("registro universitario: " + registroUniversitario + ", carrera: " + carrera + ", nro de materias: " + nroMaterias);
        for(int i = 0; i < nroMaterias; i++){
            System.out.println("materia " + i + ": " + materiasInscrito[i]);
        }
    }
    
    public void leer(){
        Scanner lec = new Scanner(System.in);
        this.nombre = lec.nextLine();
        this.ci = lec.nextInt();
        this.edad = lec.nextInt();
        this.registroUniversitario = lec.nextInt();
        this.carrera = lec.nextLine();
    }
    
    public void adicionarMateria(String materia){
        if(nroMaterias == 7){
            System.out.println("Maximo de materias inscrito");
        } else {
            materiasInscrito[nroMaterias] = materia;
            nroMaterias++;
            System.out.println("Inscripcion con exito a " + materia);
        }
    }
    
    public void registrarNota(){
        Nota n = new Nota("", "", "", null);
        n.leer();
        regisNota.agregar(n);
    }
    
    public void registrarAsistencia(){
        Asistencia a = new Asistencia("", "", false);
        a.leer();
        regisAsistencia.agregar(a);
    }

    public int getRegistroUniversitario() {
        return registroUniversitario;
    }

    public void setRegistroUniversitario(int registroUniversitario) {
        this.registroUniversitario = registroUniversitario;
    }

    public String getCarrera() {
        return carrera;
    }

    public void setCarrera(String carrera) {
        this.carrera = carrera;
    }

    public String[] getMateriasInscrito() {
        return materiasInscrito;
    }

    public void setMateriasInscrito(String[] materiasInscrito) {
        this.materiasInscrito = materiasInscrito;
    }

    public int getNroMaterias() {
        return nroMaterias;
    }

    public void setNroMaterias(int nroMaterias) {
        this.nroMaterias = nroMaterias;
    }

    public Registro<Nota> getRegisNota() {
        return regisNota;
    }

    public void setRegisNota(Registro<Nota> regisNota) {
        this.regisNota = regisNota;
    }

    public Registro<Asistencia> getRegisAsistencia() {
        return regisAsistencia;
    }

    public void setRegisAsistencia(Registro<Asistencia> regisAsistencia) {
        this.regisAsistencia = regisAsistencia;
    }
    
    
}