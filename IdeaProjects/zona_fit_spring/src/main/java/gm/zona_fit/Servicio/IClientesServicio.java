package gm.zona_fit.Servicio;

import gm.zona_fit.modelo.Cliente;

import java.util.List;

public interface IClientesServicio {


    public List<Cliente> listarClientes();
    public Cliente buscarClientePorId(Integer idCliente);
    public void guardarCliente(Cliente cliente);
    public void  eliminarClinete(Cliente cliente);

}
