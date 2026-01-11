import com.formdev.flatlaf.FlatDarculaLaf;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class Forma  extends  JFrame{
    private JPanel panelPrinciapal;
    private JTextField campoTexto;
    private JLabel replicadorLabel;

    public Forma (){
        inicializarForma();
        /*campoTexto.addActionListener(new ActionListener() {


            @Override
            public void actionPerformed(ActionEvent e) {
                replicadorTexto();
            }
        });*/


        campoTexto.addKeyListener(new KeyAdapter() {

            @Override
            public void keyTyped(KeyEvent e) {
                replicadorTexto();
                super.keyTyped(e);

            }
        });
    }

    private void replicadorTexto() {
        this.replicadorLabel.setText(  this.campoTexto.getText());
    }

    private void  inicializarForma(){
        setContentPane(panelPrinciapal);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(600,400);
        setLocationRelativeTo(null);

    }

    public static void main(String[] args) {
        FlatDarculaLaf.setup();
        Forma forma = new Forma();
        forma.setVisible(true);
    }
}
