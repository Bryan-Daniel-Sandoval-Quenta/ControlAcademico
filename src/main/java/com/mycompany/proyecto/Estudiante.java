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
        this.regisNota = new Registro<>("");
        this.regisAsistencia = new Registro<>("");
    }
    
    public Estudiante(){
        super("", 0, 0);
        this.materiasInscrito = new String[7];
        for(int i = 0; i < materiasInscrito.length; i++){
            materiasInscrito[i] = "";
        }
        this.regisNota = new Registro<>("");
        this.regisAsistencia = new Registro<>("");
    }
    
    @Override
    public void mostrar(){
        System.out.println("DATOS DE ESTUDIANTE");
        super.mostrar();
        System.out.println("registro universitario: " + registroUniversitario);
        System.out.println("carrera: " + carrera);
        System.out.println("nro de materias: " + nroMaterias);
        for(int i = 0; i < nroMaterias; i++){
            System.out.println("materia " + (i+1) + ": " + materiasInscrito[i]);
        }
    }
    
    public void leer(){
        Scanner lec = new Scanner(System.in);
        String mat = "";
        System.out.println("Ingrese nombre:.  ");
        this.nombre = lec.nextLine();
        
        System.out.println("Ingrese ci:  ");
        this.ci = lec.nextInt();
        
        System.out.println("Ingrese edad:  ");
        this.edad = lec.nextInt();
        lec.nextLine();
        
        System.out.println("Ingrese registro universitario:  ");
        this.registroUniversitario = lec.nextInt();
        lec.nextLine();
        
        System.out.println("Ingrese carrera:  ");
        this.carrera = lec.nextLine();
        
        System.out.println("Ingrese la cantidad de materias ya inscritas:  ");
        this.setNroMaterias(lec.nextInt());
        lec.nextLine();
        
        for (int i = 0; i < nroMaterias; i++){
            System.out.println("Ingrese la materia nro: " + (i+1));
            mat = lec.nextLine();
            materiasInscrito[i] = mat;
        }
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