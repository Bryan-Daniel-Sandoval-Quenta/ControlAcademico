package com.mycompany.proyecto;

import java.io.*;
import java.util.*;

public class ArchDocente {
    private String nomArchDoc;
    private List<Docente> lista;

    public ArchDocente(String nomArchDoc) {
        this.nomArchDoc = nomArchDoc;
        this.lista = new ArrayList<>();
        cargar(); 
    }

    public void crear() throws IOException {
        File f = new File(nomArchDoc);
        if (f.exists()) {
            System.out.println("El archivo ya existe.");
        } else {
            guardar();
            System.out.println("Archivo creado correctamente.");
        }
    }

    public void adicionar() {
        Scanner sc = new Scanner(System.in);
        String resp;

        do {
            Docente d = new Docente("", 0, 0, "", 0.0, 0);  
            d.leer();
            lista.add(d);

            System.out.print("¿Desea agregar otro docente? (s/n): ");
            resp = sc.nextLine();
        } while (resp.equalsIgnoreCase("s"));

        guardar();
    }

    public void listar() {
        if (lista.isEmpty()) {
            System.out.println("No hay docentes registrados.");
        } else {
            for (Docente d : lista) {
                d.mostrar();
                System.out.println("---------------------");
            }
        }
    }

    public void eliminar(int ci) {
        boolean eliminado = lista.removeIf(d -> d.getCi() == ci);

        guardar();

        if (eliminado)
            System.out.println("Docente eliminado.");
        else
            System.out.println("Docente no encontrado.");
    }

    public void modificar(int ci) {
        Scanner sc = new Scanner(System.in);
        boolean modificado = false;

        for (Docente d : lista) {
            if (d.getCi() == ci) {
                System.out.print("¿Desea modificar el sueldo? (s/n): ");
                String resp = sc.nextLine();
                if (resp.equalsIgnoreCase("s")) {
                    System.out.print("Nuevo sueldo: ");
                    double nuevoSueldo = sc.nextDouble();
                    d.setSueldo(nuevoSueldo);
                    sc.nextLine(); 
                    modificado = true;
                    break;
                }
            }
        }

        guardar();

        if (modificado)
            System.out.println("Modificación realizada.");
        else
            System.out.println("Docente no encontrado.");
    }

    public void buscar(int ci) {
        boolean encontrado = false;

        for (Docente d : lista) {
            if (d.getCi() == ci) {
                System.out.println("Docente encontrado:");
                d.mostrar();
                encontrado = true;
                break;
            }
        }

        if (!encontrado) {
            System.out.println("Docente no encontrado.");
        }
    }

    private void guardar() {
        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(nomArchDoc))) {
            out.writeObject(lista);
        } catch (IOException e) {
            System.out.println("Error al guardar: " + e.getMessage());
        }
    }

    @SuppressWarnings("unchecked")
    private void cargar() {
        File f = new File(nomArchDoc);
        if (!f.exists()) return;

        try (ObjectInputStream in = new ObjectInputStream(new FileInputStream(nomArchDoc))) {
            lista = (List<Docente>) in.readObject();
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Error al cargar archivo: " + e.getMessage());
        }
    }
}
