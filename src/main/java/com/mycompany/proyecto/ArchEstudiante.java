package com.mycompany.proyecto;

import java.io.*;
import java.util.Scanner;

public class ArchEstudiante {
    private String nomArchEst;
    private Estudiante est;

    public ArchEstudiante(String nomArchEst) {
        this.nomArchEst = nomArchEst;
    }

    public void crear() throws IOException {
        File f = new File(nomArchEst);
        if (f.exists()) {
            System.out.println("El archivo ya existe.");
        } else {
            try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(nomArchEst))) {
                System.out.println("Archivo creado correctamente.");
            }
        }
    }

    public void adicionar() throws IOException {
        Scanner sc = new Scanner(System.in);
        String resp;

        try (ObjectOutputStream out = new File(nomArchEst).exists()
                ? new AddObjectOutputStream(new FileOutputStream(nomArchEst, true))
                : new ObjectOutputStream(new FileOutputStream(nomArchEst))) {

            do {
                est = new Estudiante();
                est.leer();  
                out.writeObject(est);

                System.out.print("¿Desea agregar otro estudiante? (s/n): ");
                resp = sc.nextLine();
            } while (resp.equalsIgnoreCase("s"));

        } catch (Exception e) {
            System.out.println("Error al adicionar: " + e.getMessage());
        }
    }
    
    public void adicionarEstudiante(Estudiante est) {
        try (ObjectOutputStream out = new File(nomArchEst).exists()
                ? new AddObjectOutputStream(new FileOutputStream(nomArchEst, true))
                : new ObjectOutputStream(new FileOutputStream(nomArchEst))) {

            out.writeObject(est);
            System.out.println("Estudiante añadido correctamente.");

        } catch (IOException e) {
            System.out.println("Error al adicionar estudiante: " + e.getMessage());
        }
    }


    public void listar() throws IOException, ClassNotFoundException {
        try (ObjectInputStream in = new ObjectInputStream(new FileInputStream(nomArchEst))) {
            while (true) {
                est = new Estudiante();
                est = (Estudiante) in.readObject();
                est.mostrar();  
            }
        } catch (EOFException e) {
            System.out.println("Fin del listado.");
        }
    }

    public void eliminar(int regUni) throws IOException, ClassNotFoundException {
        boolean eliminado = false;

        try (ObjectInputStream in = new ObjectInputStream(new FileInputStream(nomArchEst));
             ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("copia.dat"))) {

            while (true) {
                est = (Estudiante) in.readObject();
                if (est.getRegistroUniversitario() == regUni) {
                    eliminado = true;
                } else {
                    out.writeObject(est);
                }
            }
        } catch (EOFException e) {
            // Fin del archivo
        }

        File original = new File(nomArchEst);
        File copia = new File("copia.dat");
        original.delete();
        copia.renameTo(original);

        if (eliminado)
            System.out.println("Estudiante eliminado.");
        else
            System.out.println("Estudiante no encontrado.");
    }

    public void modificar(int regUni) throws IOException, ClassNotFoundException {
        boolean modificado = false;
        Scanner sc = new Scanner(System.in);

        try (ObjectInputStream in = new ObjectInputStream(new FileInputStream(nomArchEst));
             ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("copia.dat"))) {

            while (true) {
                est = (Estudiante) in.readObject();
                if (est.getRegistroUniversitario() == regUni) {
                    System.out.print("¿Desea modificar el nombre? (s/n): ");
                    String resp = sc.nextLine();
                    if (resp.equalsIgnoreCase("s")) {
                        System.out.print("Nuevo nombre: ");
                        String nuevoNombre = sc.nextLine();
                        est.setNombre(nuevoNombre);  
                        modificado = true;
                    }
                }
                out.writeObject(est);
            }
        } catch (EOFException e) {
            // Fin del archivo
        }

        File original = new File(nomArchEst);
        File copia = new File("copia.dat");
        original.delete();
        copia.renameTo(original);

        if (modificado)
            System.out.println("Modificación realizada.");
        else
            System.out.println("Estudiante no encontrado.");
    }

    public void buscar(int  regUni) throws IOException, ClassNotFoundException {
        boolean encontrado = false;

        try (ObjectInputStream in = new ObjectInputStream(new FileInputStream(nomArchEst))) {
            while (true) {
                est = (Estudiante) in.readObject();
                if (est.getRegistroUniversitario() == regUni) {
                    System.out.println("Estudiante encontrado:");
                    est.mostrar();
                    encontrado = true;
                }
            }
        } catch (EOFException e) {
            if (!encontrado) {
                System.out.println("Estudiante no encontrado.");
            }
        }
    }
}