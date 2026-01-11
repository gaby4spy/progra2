import com.formdev.flatlaf.FlatDarculaLaf;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LogginForm  extends  JFrame{
    private JPanel PanelPrincipal;
    private JTextField usuarioTexto;
    private JPasswordField passwordTexto;
    private JButton enviarBoton;


    public  LogginForm (){
        inicilizarForma();
        enviarBoton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                validar ();
            }
        });
    }

    private void validar() {
        var usuario = this.usuarioTexto.getText();
        var password = new String(this.passwordTexto.getPassword()) ;

        if ("root".equals(usuario) && "admin".equals(password)) {
            mostrarMensaje("Datos correctos , bienvenido");
        }else if ("root".equals(usuario) ){
            mostrarMensaje("Contraseña incorrecta");
        }else {
            mostrarMensaje("Usuario incorrecto");
        }
    }

    private void mostrarMensaje(String mesaje) {
        JOptionPane.showMessageDialog(this,mesaje);

    }

    private void inicilizarForma(){
        setContentPane(PanelPrincipal);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(600,400);
        setLocationRelativeTo(null);

    }

    public static void main(String[] args) {

        FlatDarculaLaf.setup();
        LogginForm logginForm = new LogginForm();
        logginForm.setVisible(true);

    }
}
