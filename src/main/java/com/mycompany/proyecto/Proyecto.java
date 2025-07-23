package com.mycompany.proyecto;

import java.io.IOException;

public class Proyecto {

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        ArchEstudiante archEst = new ArchEstudiante("nomArchEst.dat");
        ArchDocente archDoc = new ArchDocente("nomArchDoc.dat");
        
        archEst.crear();
        archDoc.crear();
        
        Estudiante est1 = new Estudiante();
        Coordinador DocCoo1 = new Coordinador();
        est1.leer();
        DocCoo1.leer();
        
        archEst.adicionarEstudiante(est1);
        archDoc.adicionarDocente(DocCoo1);
        
        archEst.listar();
        archDoc.listar();
    }
}
