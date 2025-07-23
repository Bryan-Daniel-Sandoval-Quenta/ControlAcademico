package com.mycompany.proyecto;

import java.io.*;
import java.util.*;

public class ArchEstudiante {
    private String nomArchEst;
    private List<Estudiante> lista;

    public ArchEstudiante(String nomArchEst) {
        this.nomArchEst = nomArchEst;
        this.lista = new ArrayList<>();
        cargar();  // Carga los datos al iniciar
    }

    public void crear() throws IOException {
        File f = new File(nomArchEst);
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
            Estudiante est = new Estudiante();
            est.leer();
            lista.add(est);

            System.out.print("¿Desea agregar otro estudiante? (s/n): ");
            resp = sc.nextLine();
        } while (resp.equalsIgnoreCase("s"));

        guardar();
    }

    public void listar() {
        if (lista.isEmpty()) {
            System.out.println("No hay estudiantes registrados.");
        } else {
            for (Estudiante est : lista) {
                est.mostrar();
            }
        }
    }

    public void eliminar(int regUni) {
        boolean eliminado = lista.removeIf(est -> est.getRegistroUniversitario() == regUni);

        guardar();

        if (eliminado)
            System.out.println("Estudiante eliminado.");
        else
            System.out.println("Estudiante no encontrado.");
    }

    public void modificar(int regUni) {
        Scanner sc = new Scanner(System.in);
        boolean modificado = false;

        for (Estudiante est : lista) {
            if (est.getRegistroUniversitario() == regUni) {
                System.out.print("¿Desea modificar el nombre? (s/n): ");
                String resp = sc.nextLine();
                if (resp.equalsIgnoreCase("s")) {
                    System.out.print("Nuevo nombre: ");
                    String nuevoNombre = sc.nextLine();
                    est.setNombre(nuevoNombre);
                    modificado = true;
                    break;
                }
            }
        }

        guardar();

        if (modificado)
            System.out.println("Modificación realizada.");
        else
            System.out.println("Estudiante no encontrado.");
    }

    public void buscar(int regUni) {
        boolean encontrado = false;

        for (Estudiante est : lista) {
            if (est.getRegistroUniversitario() == regUni) {
                System.out.println("Estudiante encontrado:");
                est.mostrar();
                encontrado = true;
                break;
            }
        }

        if (!encontrado) {
            System.out.println("Estudiante no encontrado.");
        }
    }

    private void guardar() {
        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(nomArchEst))) {
            out.writeObject(lista);
        } catch (IOException e) {
            System.out.println("Error al guardar: " + e.getMessage());
        }
    }

    @SuppressWarnings("unchecked")
    private void cargar() {
        File f = new File(nomArchEst);
        if (!f.exists()) return;

        try (ObjectInputStream in = new ObjectInputStream(new FileInputStream(nomArchEst))) {
            lista = (List<Estudiante>) in.readObject();
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Error al cargar archivo: " + e.getMessage());
        }
    }
}
