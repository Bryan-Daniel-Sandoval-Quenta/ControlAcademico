package com.mycompany.proyecto;

public class ControlAcademico {
    private Estudiante vecEst[];
    private int nroEst;
    private Docente vecDoc[];
    private int nroDoc;

    public ControlAcademico() {
        this.nroEst = 0;
        this.nroDoc = 0;
        vecEst = new Estudiante[100];
        vecDoc = new Docente[50];
    }   
    
    public void mostrar(){
        System.out.println("nro de Estudiantes: " + nroEst + ", nro de Docentes: " + nroDoc);
        for(int i = 0; i < nroEst; i++){
            vecEst[i].mostrar();
        }
        
        for(int j = 0; j < nroDoc; j++){
            vecDoc[j].mostrar();
        }
    }
    
    public void agregarEstudiante(Estudiante e){
        if(nroEst == 100){
            System.out.println("no se pueden agregar mas estudiantes");
        } else {
            vecEst[nroEst] = e;
            nroEst = nroEst + 1;
            System.out.println("se agrego el estudiante");
        }
    }
    
    public void agregarDocente(Docente d){
        if(nroDoc == 50){
            System.out.println("no se pueden agregar mas docentes");
        } else {
            vecDoc[nroDoc] = d;
            nroDoc = nroDoc + 1;
            System.out.println("se agrego el docente");
        }
    } 
}
