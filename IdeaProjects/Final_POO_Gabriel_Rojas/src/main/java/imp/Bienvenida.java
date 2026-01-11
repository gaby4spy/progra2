package imp;

import javax.swing.JOptionPane;

public class Bienvenida {

    public static void mostrar() {
        JOptionPane.showMessageDialog(
                null,
                "Bienvenido al Sistema de Gestión de flota de Vehículos!\n\n" +
                        "podrá registrar, consultar y gestionar su flota de manera eficiente.",
                "Bienvenida",
                JOptionPane.INFORMATION_MESSAGE
        );
    }
}
