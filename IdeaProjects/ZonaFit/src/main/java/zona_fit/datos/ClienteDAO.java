package zona_fit.datos;

import zona_fit.conexion.Conexion;
import zona_fit.dominio.Cliente;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;



public class ClienteDAO implements  IClienteDAO{
    @Override
    public List<Cliente> listarClientes() {

        List<Cliente> clientes = new ArrayList<>();
        PreparedStatement ps;
        ResultSet rs;
        Connection con = Conexion.getConexion();
        var sql = "  SELECT * FROM cliente ";

        try {
            ps=con.prepareStatement(sql);
            rs=ps.executeQuery(sql);

            while (rs.next()){
                var cliente = new Cliente();
                cliente.setId(rs.getInt("id"));
                cliente.setNombre(rs.getString("nombre"));
                cliente.setApellido(rs.getString("apellido"));
                cliente.setMembresia(rs.getInt("membresia"));

                clientes.add(cliente);
            }
        }catch (Exception e){
            System.out.println("error" + e);
        }
        finally {
            try {
                con.close();
            }catch (Exception e ){

            }

        }

        return clientes;
    }

    @Override
    public boolean buscarClientePorId(Cliente cliente) {

        PreparedStatement ps;
        ResultSet rs;
        Connection con = Conexion.getConexion();
        var sql = "SELECT * FROM cliente where id = ?" ;

        try {
            ps=con.prepareStatement(sql);
            ps.setInt(1,cliente.getId());
            rs=ps.executeQuery();
            if (rs.next()){
                cliente.setNombre(rs.getString("nombre"));
                cliente.setApellido(rs.getString("apellido"));
                cliente.setMembresia(rs.getInt("membresia"));

                return  true;
            }
        } catch (Exception e) {
            System.out.println("error al recuperar clientre por id" + e);
        }finally {
            try {
                con.close();
            } catch (Exception e) {
                System.out.println("error al cerrar conexion " + e.getMessage());
            }
        }
        return false;
    }

    @Override
    public boolean agregarCliente(Cliente cliente) {
        PreparedStatement ps ;
        Connection con = Conexion.getConexion();
        String sql = "insert into cliente(nombre,apellido,membresia) "
                + "values(?,?,?)";
        try {
            ps =con.prepareStatement(sql);
            ps.setString(1,cliente.getNombre());
            ps.setString(2,cliente.getApellido());
            ps.setInt(3,cliente.getMembresia());
            ps.execute();
            return true;
        }catch (Exception e) {
            System.out.println("error al insertar usuario " + e.getMessage());
        }finally {
            try {
                con.close();
            } catch (Exception e) {
                System.out.println("error al cerrar conexion " + e.getMessage());
            }
        }
        return false;
    }

    @Override
    public boolean modificarCliente(Cliente cliente) {
        PreparedStatement ps;
        Connection con = Conexion.getConexion();
        var sql ="UPDATE cliente SET nombre=?, apellido=?,membresia=?" +
                " WHERE id = ?";

        try {
            ps=con.prepareStatement(sql);
            ps.setString(1,cliente.getNombre());
            ps.setString(2,cliente.getApellido());
            ps.setInt(3,cliente.getMembresia());
            ps.setInt(4,cliente.getId());
            ps.execute();
            return true;

        }catch (Exception e ){
            System.out.println("Erro al modifcar ciente: " + e.getMessage());
        }

        return false;
    }

    @Override
    public boolean eliminarCliente(Cliente cliente) {
        PreparedStatement ps;
        Connection con= Conexion.getConexion();
        String sql = "DELETE FROM cliente WHERE id = ?";

        try {
            ps=con.prepareStatement(sql);
            ps.setInt(1,cliente.getId());
            ps.execute();
            return  true;

        }catch (Exception e){
            System.out.println("error al elmiar cliente : " + e.getMessage());
        }finally {
            try {
                con.close();
            }catch (Exception e){
                System.out.println("error al cerrar conexion " + e.getMessage());
            }
        }

        return false;
    }


}
