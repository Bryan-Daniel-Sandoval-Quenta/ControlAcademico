package com.mycompany.proyecto;

import javax.swing.*;
import java.awt.*;
import java.io.*;

public class SistemaAcademicoGUI extends JFrame {
    private ArchEstudiante archEst;
    private ArchDocente archDoc;
    private JTextArea areaTexto;

    public SistemaAcademicoGUI() {
        setTitle("Sistema de Control Académico");
        setSize(1000, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        // Inicializar archivos
        ArchEstudiante archEst = ArchEstudiante.getInstancia();
        ArchDocente archDoc = ArchDocente.getInstancia();

        // Panel superior con botones
        JPanel panelBotones = new JPanel();
        JButton btnAddEst = new JButton("Adicionar Estudiante");
        JButton btnAddDoc = new JButton("Adicionar Docente");
        JButton btnListEst = new JButton("Listar Estudiantes");
        JButton btnListDoc = new JButton("Listar Docentes");
        JButton btnEliminarEst = new JButton("Eliminar Estudiante");
        JButton btnEliminarDoc = new JButton("Eliminar Docente");

        panelBotones.add(btnAddEst);
        panelBotones.add(btnAddDoc);
        panelBotones.add(btnListEst);
        panelBotones.add(btnListDoc);
        panelBotones.add(btnEliminarEst);
        panelBotones.add(btnEliminarDoc);

        add(panelBotones, BorderLayout.NORTH);

        // Área de texto para mostrar resultados
        areaTexto = new JTextArea();
        areaTexto.setEditable(false);
        add(new JScrollPane(areaTexto), BorderLayout.CENTER);

        // Acción: Adicionar Estudiante
        btnAddEst.addActionListener(e -> {
            Estudiante est = new Estudiante();
            est.leer();  // lee desde JOptionPane si ya fue migrado
            archEst.adicionarEstudiante(est);
            JOptionPane.showMessageDialog(this, "Estudiante registrado con éxito.");
        });

        // Acción: Adicionar Docente
        btnAddDoc.addActionListener(e -> {
            Docente doc = new Docente();
            doc.leer();  // lee desde JOptionPane si ya fue migrado
            archDoc.adicionarDocente(doc);
            JOptionPane.showMessageDialog(this, "Docente registrado con éxito.");
        });

        // Acción: Listar Estudiantes
        btnListEst.addActionListener(e -> {
            areaTexto.setText("");
            try {
                ByteArrayOutputStream buffer = new ByteArrayOutputStream();
                PrintStream ps = new PrintStream(buffer);
                PrintStream original = System.out;
                System.setOut(ps);
                archEst.listar();
                System.setOut(original);
                areaTexto.setText(buffer.toString());
            } catch (Exception ex) {
                areaTexto.setText("Error al listar estudiantes: " + ex.getMessage());
            }
        });

        // Acción: Listar Docentes
        btnListDoc.addActionListener(e -> {
            areaTexto.setText("");
            try {
                ByteArrayOutputStream buffer = new ByteArrayOutputStream();
                PrintStream ps = new PrintStream(buffer);
                PrintStream original = System.out;
                System.setOut(ps);
                archDoc.listar();
                System.setOut(original);
                areaTexto.setText(buffer.toString());
            } catch (Exception ex) {
                areaTexto.setText("Error al listar docentes: " + ex.getMessage());
            }
        });

        // Acción: Eliminar Estudiante por CI
        btnEliminarEst.addActionListener(e -> {
            try {
                int ci = Integer.parseInt(JOptionPane.showInputDialog(this, "Ingrese el CI del estudiante a eliminar:"));
                try {
                    archEst.eliminar(ci);
                    JOptionPane.showMessageDialog(this, "Estudiante eliminado si existía.");
                } catch (IOException | ClassNotFoundException ex) {
                    JOptionPane.showMessageDialog(this, "Error al eliminar estudiante: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
                }
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(this, "CI inválido.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        });

        // Acción: Eliminar Docente por CI
        btnEliminarDoc.addActionListener(e -> {
            try {
                int ci = Integer.parseInt(JOptionPane.showInputDialog(this, "Ingrese el CI del docente a eliminar:"));
                try {
                    archDoc.eliminar(ci);
                    JOptionPane.showMessageDialog(this, "Docente eliminado si existía.");
                } catch (IOException | ClassNotFoundException ex) {
                    JOptionPane.showMessageDialog(this, "Error al eliminar docente: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
                }
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(this, "CI inválido.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        });
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new SistemaAcademicoGUI().setVisible(true);
        });
    }
}
