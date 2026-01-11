package zona_fit.conexion;

import zona_fit.datos.ClienteDAO;
import zona_fit.dominio.Cliente;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        ClienteDAO c = new ClienteDAO();


        var z = c.listarClientes();

        for (Cliente a:z){
            System.out.println(a.toString());
        }

    }
}
