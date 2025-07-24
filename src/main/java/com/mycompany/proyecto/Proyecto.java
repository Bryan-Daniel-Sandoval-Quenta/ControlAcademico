package com.mycompany.proyecto;

import java.io.IOException;

public class Proyecto {

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        ArchEstudiante archEst = ArchEstudiante.getInstancia();
        ArchDocente archDoc = ArchDocente.getInstancia();
        
        //archEst.crear();
        //archDoc.crear();
        
        //archEst.adicionar();
        //archDoc.adicionar();
        
        archEst.listar();
        archDoc.listar();
    }
}
