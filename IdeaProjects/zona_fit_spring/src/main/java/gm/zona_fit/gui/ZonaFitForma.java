package gm.zona_fit.gui;

import gm.zona_fit.Servicio.ClienteServicio;
import gm.zona_fit.modelo.Cliente;
import org.springframework.stereotype.Component;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

@Component
public class ZonaFitForma extends JFrame {
    private final ClienteServicio clienteServicio;
    private JPanel panelPrincipal;
    private JTable clientesTabla;
    private JTextField nombreTexto;
    private JTextField apellidoTexto;
    private JTextField membresiaTexto;
    private JButton limpiarButton;
    private JButton eliminarButton;
    private JButton guardarButtom;
    private DefaultTableModel tablaModeloClientes;
    private Integer idCliente;

    // Spring inyecta ClienteServicio automáticamente
    public ZonaFitForma(ClienteServicio clienteServicio) {
        this.clienteServicio = clienteServicio;
        inicializarForma();
        guardarButtom.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                guardarCliente();
            }
        });
        clientesTabla.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                cargarClienteSeleccionado();
            }
        });
        eliminarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                eliminarCliente();
            }
        });
        limpiarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                limpiarFormulario();
            }
        });
    }

    private void eliminarCliente(){
        var renglon = clientesTabla.getSelectedRow();
        if (renglon!=-1) {
            var idClienteStr= clientesTabla.getModel().getValueAt(renglon,0).toString();
            this.idCliente =Integer.parseInt(idClienteStr);
            var cliente = new Cliente();
            cliente.setId(this.idCliente);
            clienteServicio.eliminarClinete(cliente);
            mostrarMensaje("Cliente con id " + this.idCliente + "eliminado");
            limpiarFormulario();
            listarClientes();
        }else {
            mostrarMensaje("Debe selecciona un cliente a eliminar ");
        }
    }

    private void  cargarClienteSeleccionado(){
        var renglon = clientesTabla.getSelectedRow();
        if (renglon!=-1){
            var id= clientesTabla.getModel().getValueAt(renglon,0).toString();
            this.idCliente=Integer.parseInt(id);
            var nombre = clientesTabla.getModel().getValueAt(renglon,1).toString();
            this.nombreTexto.setText(nombre);
            var apellido = clientesTabla.getModel().getValueAt(renglon,2).toString();
            this.apellidoTexto.setText(apellido);
            var membresia = clientesTabla.getModel().getValueAt(renglon,3).toString();
            this.membresiaTexto.setText(membresia);

        }
    }

    private void inicializarForma(){
        setContentPane(panelPrincipal);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(900,600);
        setLocationRelativeTo(null);
    }

    private void guardarCliente(){
        if (nombreTexto.getText().equals("")){
            mostrarMensaje("Proporciona un nombre ");
            nombreTexto.requestFocusInWindow() ;
            return;
        }

        if (membresiaTexto.getText().equals("")){
            mostrarMensaje("Proporciona una membresia");
            membresiaTexto.requestFocusInWindow();
            return;
        }


        var nombre = nombreTexto.getText();
        var apellido = apellidoTexto.getText();
        var membresia = Integer.parseInt(membresiaTexto.getText());

        var cliente = new Cliente(this.idCliente,nombre,apellido,membresia);
        cliente.setId(this.idCliente);
        cliente.setNombre(nombre);
        cliente.setApellido(apellido);
        cliente.setMembresia(membresia);
        this.clienteServicio.guardarCliente(cliente);
        if (this.idCliente==null){
            mostrarMensaje("se agrego el nuevo cliente");
        }

        if (this.idCliente!=null){
            mostrarMensaje("se actualizo el cliente" );
        }
        limpiarFormulario();
        listarClientes();

    }

    private void limpiarFormulario(){
        nombreTexto.setText("");
        apellidoTexto.setText("");
        membresiaTexto.setText("");

        this.idCliente=null;
        this.clientesTabla.getSelectionModel().clearSelection();

    }
    ;

    private void mostrarMensaje(String msj) {
        JOptionPane.showMessageDialog(this,msj);

    }

    ;

    private void createUIComponents() {
        this.tablaModeloClientes = new DefaultTableModel(0, 4);
        String[] cabeceros = {"id", "nombre", "apellido", "membresia"};
        this.tablaModeloClientes.setColumnIdentifiers(cabeceros);
        this.clientesTabla = new JTable(tablaModeloClientes);

        listarClientes();
    }

    private void listarClientes() {
        this.tablaModeloClientes.setRowCount(0);
        var clientes = clienteServicio.listarClientes();
        for (Cliente i : clientes){
            Object[] renglonCliente = {
                    i.getId(),
                    i.getNombre(),
                    i.getApellido(),
                    i.getMembresia()
            };
            this.tablaModeloClientes.addRow(renglonCliente);
        }
    }
}