package com.mycompany.proyecto;

import java.io.Serializable;
import java.lang.reflect.Array;

public class Registro<T> implements Serializable{

    private T[] vecReg;
    private int nroReg;
    private String fechaModificacion;

    public Registro(T[] vecReg, int nroReg, String fechaModificacion) {
        this.vecReg = vecReg;
        this.nroReg = nroReg;
        this.fechaModificacion = fechaModificacion;
    }

    public Registro(Class<T> clazz, String fechaModificacion){
        this.vecReg = (T[]) Array.newInstance(clazz, 4); 
        this.nroReg = 0;
        this.fechaModificacion = fechaModificacion;
    }

    public T[] getVecReg() {
        return vecReg;
    }

    public void setVecReg(T[] vecReg) {
        this.vecReg = vecReg;
    }

    public int getNroReg() {
        return nroReg;
    }

    public void setNroReg(int nroReg) {
        this.nroReg = nroReg;
    }

    public String getFechaModificacion() {
        return fechaModificacion;
    }

    public void setFechaModificacion(String fechaModificacion) {
        this.fechaModificacion = fechaModificacion;
    }

    public void agregar(T elemento) {
        if (nroReg < vecReg.length) {
            vecReg[nroReg] = elemento;
            nroReg++;
            fechaModificacion = java.time.LocalDate.now().toString();
        } else {
            System.out.println("No se puede agregar más elementos. Capacidad llena.");
        }
    }

    public void mostrarTodo() {
        for (int i = 0; i < nroReg; i++) {
            System.out.println(vecReg[i]);
        }
    }
}
