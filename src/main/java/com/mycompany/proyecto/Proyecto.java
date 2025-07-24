package com.mycompany.proyecto;

import java.io.IOException;

public class Proyecto {

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        ArchEstudiante archEst = new ArchEstudiante("nomArchEst.dat");
        ArchDocente archDoc = new ArchDocente("nomArchDoc.dat");
        
        //archEst.crear();
        //archDoc.crear();
        
        archEst.adicionar();
        //archDoc.adicionar();
        
        archEst.listar();
        archDoc.listar();
    }
}
