package com.mycompany.proyecto;
import java.io.Serializable;
import java.util.Scanner;

public class Docente extends Persona implements Serializable{
    protected String tipoDocente;
    protected double sueldo;
    protected String MateriasAsignadas[]=new String[4];
    protected int nroMateria;
    
    public Docente(String nombre,int ci,int edad,String tipoDocente,double sueldo,int nroMateria){
        super(nombre,ci,edad);
        this.tipoDocente=tipoDocente;
        this.sueldo=sueldo;
        
        this.nroMateria=nroMateria;
        Scanner sc=new Scanner(System.in);
        System.out.println("INGRESE MATERIAS");
        for (int i =0;i<nroMateria;i++)
        {   
            System.out.println("Materia"+(i+1)+":");
            MateriasAsignadas[i]=sc.nextLine();
        }
    }
    public void leer()
    {   Scanner sc=new Scanner(System.in);
    
        System.out.println("Ingrese nombre:.  ");
        nombre=sc.nextLine();
                
        System.out.println("Ingrese ci: ");
        ci=sc.nextInt();
        
        System.out.println("Ingrese edad: ");
        edad=sc.nextInt();
        sc.nextLine();
        
        System.out.println("Ingrese Tipo docente: ");
        tipoDocente=sc.nextLine();
        
        System.out.println("Ingrese sueldo: ");
        sueldo=sc.nextDouble();
        
        System.out.println("Ingrese Numero de materias: ");
        nroMateria=sc.nextInt();
        
        System.out.println("INGRESE MATERIAS: ");
        for (int i =0;i<nroMateria;i++)
        {   
            System.out.println("Materia"+(i+1)+": ");
            MateriasAsignadas[i]=sc.nextLine();
        }
    
    
         
    }
    public void mostrar()
    {   System.out.println("Nombre: "+nombre);
        System.out.println("CI: "+ci);
        System.out.println("Edad: "+edad);
        System.out.println("Tipo de Docente:"+tipoDocente);
        System.out.println("Sueldo:"+sueldo);
        System.out.println("Numero de materias del docente:"+nroMateria);
        System.out.println("MATERIAS ASIGNADAS");
        for(int i=0;i<nroMateria;i++)
        {   System.out.println(""+MateriasAsignadas[i]);
        }
    }

    public String getTipoDocente() {
        return tipoDocente;
    }

    public void setTipoDocente(String tipoDocente) {
        this.tipoDocente = tipoDocente;
    }

    public double getSueldo() {
        return sueldo;
    }

    public void setSueldo(double sueldo) {
        this.sueldo = sueldo;
    }

    public String[] getMateriasAsignadas() {
        return MateriasAsignadas;
    }

    public void setMateriasAsignadas(String[] MateriasAsignadas) {
        this.MateriasAsignadas = MateriasAsignadas;
    }

    public int getNroMateria() {
        return nroMateria;
    }

    public void setNroMateria(int nroMateria) {
        this.nroMateria = nroMateria;
    }
}
