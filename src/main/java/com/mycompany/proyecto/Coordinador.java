package com.mycompany.proyecto;
import java.util.Scanner;
public class Coordinador extends Persona {
    private String semestreCoordinado;
    private String areaResponsable;
    
    public Coordinador(String nombre,int ci,int edad,String tipodocente,double sueldo,
            int nroMateria,String semestreCoordinado,String areaResponsable)
    {   super(nombre,ci,edad,tipodocente,sueldo,nroMateria);
        this.semestreCoordinado=semestreCoordinado;
        this.areaResponsable=areaResponsable;
        
    }
    public void leer()
    {   Scanner sc=new Scanner(System.in);
        
        sout
    }
    
    
    public void mostrar()
    {
    }
}
