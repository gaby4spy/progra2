package imp;

import javax.swing.*;
import java.awt.event.*;

public class Ventana {
    public static void main(String[] args) {
        // Crear ventana
        JFrame frame = new JFrame("SGSG");

        frame.setSize(500,500 );
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(null); // Posiciones absolutas

        // Etiqueta
        JLabel label = new JLabel("Tu nombre:");

        label.setBounds(10, 10, 100, 25);
        frame.add(label);
        // Campo de texto
        JTextField textField = new JTextField();
        textField.setBounds(100, 10, 160, 25);
        frame.add(textField);
        // Botón
        JButton boton = new JButton("Aceptar");
        boton.setBounds(100, 50, 100, 25);
        frame.add(boton);

        // Acción del botón
        boton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String nombre = textField.getText();
                JOptionPane.showMessageDialog(frame, "Hola, " + nombre + "!");
            }
        });
        // Mostrar ventana
        frame.setVisible(true);
    }
}

