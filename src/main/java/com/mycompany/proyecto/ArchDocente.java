package com.mycompany.proyecto;

import java.io.*;
import java.util.Scanner;

public class ArchDocente {
    private String nomArchDoc;
    private Docente doc;

    public ArchDocente(String nomArchDoc) {
        this.nomArchDoc = nomArchDoc;
    }

    public void crear() throws IOException {
        File f = new File(nomArchDoc);
        if (f.exists()) {
            System.out.println("El archivo ya existe.");
        } else {
            try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(nomArchDoc))) {
                System.out.println("Archivo creado correctamente.");
            }
        }
    }

    public void adicionar() throws IOException {
        Scanner sc = new Scanner(System.in);
        String resp;

        try (ObjectOutputStream out = new File(nomArchDoc).exists()
                ? new AddObjectOutputStream(new FileOutputStream(nomArchDoc, true))
                : new ObjectOutputStream(new FileOutputStream(nomArchDoc))) {

            do {
                doc = new Docente();
                doc.leer();  
                out.writeObject(doc);

                System.out.print("¿Desea agregar otro docente? (s/n): ");
                resp = sc.nextLine();
            } while (resp.equalsIgnoreCase("s"));

        } catch (Exception e) {
            System.out.println("Error al adicionar: " + e.getMessage());    
        }
    }
    
    public void adicionarDocente(Docente doc) {
        try (ObjectOutputStream out = new File(nomArchDoc).exists()
                ? new AddObjectOutputStream(new FileOutputStream(nomArchDoc, true))
                : new ObjectOutputStream(new FileOutputStream(nomArchDoc))) {

            out.writeObject(doc);
            System.out.println("Docente añadido correctamente.");

        } catch (IOException e) {
            System.out.println("Error al adicionar docente: " + e.getMessage());
        }
    }

    public void listar() throws IOException, ClassNotFoundException {
        try (ObjectInputStream in = new ObjectInputStream(new FileInputStream(nomArchDoc))) {
            while (true) {
                doc = (Docente) in.readObject();
                doc.mostrar();  
            }
        } catch (EOFException e) {
            System.out.println("Fin del listado.");
            System.out.println("");
        }
    }

    public void eliminar(int ci) throws IOException, ClassNotFoundException {
        boolean eliminado = false;

        try (ObjectInputStream in = new ObjectInputStream(new FileInputStream(nomArchDoc));
             ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("copiaDoc.dat"))) {

            while (true) {
                doc = (Docente) in.readObject();
                if (doc.getCi() == ci) {
                    eliminado = true;
                } else {
                    out.writeObject(doc);
                }
            }
        } catch (EOFException e) {
            // Fin del archivo
        }

        File original = new File(nomArchDoc);
        File copia = new File("copiaDoc.dat");
        original.delete();
        copia.renameTo(original);

        if (eliminado)
            System.out.println("Docente eliminado.");
        else
            System.out.println("Docente no encontrado.");
    }

    public void modificar(int ci) throws IOException, ClassNotFoundException {
        boolean modificado = false;
        Scanner sc = new Scanner(System.in);

        try (ObjectInputStream in = new ObjectInputStream(new FileInputStream(nomArchDoc));
             ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("copiaDoc.dat"))) {

            while (true) {
                doc = (Docente) in.readObject();
                if (doc.getCi() == ci) {
                    System.out.print("¿Desea modificar el nombre? (s/n): ");
                    String resp = sc.nextLine();
                    if (resp.equalsIgnoreCase("s")) {
                        System.out.print("Nuevo nombre: ");
                        String nuevoNombre = sc.nextLine();
                        doc.setNombre(nuevoNombre);  
                        modificado = true;
                    }
                }
                out.writeObject(doc);
            }
        } catch (EOFException e) {
            // Fin del archivo
        }

        File original = new File(nomArchDoc);
        File copia = new File("copiaDoc.dat");
        original.delete();
        copia.renameTo(original);

        if (modificado)
            System.out.println("Modificación realizada.");
        else
            System.out.println("Docente no encontrado.");
    }

    public void buscar(int ci) throws IOException, ClassNotFoundException {
        boolean encontrado = false;

        try (ObjectInputStream in = new ObjectInputStream(new FileInputStream(nomArchDoc))) {
            while (true) {
                doc = (Docente) in.readObject();
                if (doc.getCi() == ci) {
                    System.out.println("Docente encontrado:");
                    doc.mostrar();
                    encontrado = true;
                }
            }
        } catch (EOFException e) {
            if (!encontrado) {
                System.out.println("Docente no encontrado.");
            }
        }
    }
}
