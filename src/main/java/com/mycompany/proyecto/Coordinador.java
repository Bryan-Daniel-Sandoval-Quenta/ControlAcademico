package com.mycompany.proyecto;
import java.util.Scanner;
public class Coordinador extends Persona {
    private String semestreCoordinado;
    private String areaResponsable;
    
    public Coordinador(String semestreCoordinado, String areaResposable, String nombre, int ci, int edad, String tipoDocente, double sueldo, int nroMateria) {
        super(nombre, ci, edad, tipoDocente, sueldo, nroMateria);
        this.semestreCoordinado = semestreCoordinado;
        this.areaResponsable = areaResposable;
    }
    public void leer()
    {   Scanner sc=new Scanner(System.in);
    
        System.out.println("Semestre Coordinado");
        semestreCoordinado=sc.nextLine();
        
        System.out.println("Area Responsable: ");
        areaResponsable=sc.nextLine();
        
    }
    
    
    public void mostrar()
    { System.out.println("Smestre Coordinador: "+semestreCoordinado);
        System.out.println("Area Responsable: "+areaResponsable);
    }
}
