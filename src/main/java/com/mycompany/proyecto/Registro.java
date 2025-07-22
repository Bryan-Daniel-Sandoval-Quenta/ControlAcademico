package com.mycompany.proyecto;

public class Registro<T> {
    private T[] vecReg;
    private int nroReg;
    private String fechaModificacion;

    public Registro(T[] vecReg, int nroReg, String fechaModificacion) {
        this.vecReg = vecReg;
        this.nroReg = nroReg;
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
}
