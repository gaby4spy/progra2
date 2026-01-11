package zona_fit.presentacion;

import zona_fit.datos.ClienteDAO;
import zona_fit.datos.IClienteDAO;
import zona_fit.dominio.Cliente;

import java.util.Scanner;

public class ZonaFitApp {
    public static void main(String[] args) {

        zonaFitAPP();
    }

    private static void  zonaFitAPP(){
        var salir =false;
        var consola = new Scanner(System.in);
        //creamos un objeto de la clase clientedao

        IClienteDAO clienteDao= new ClienteDAO();

        while (!salir){
            try {

               var opcion= mostrarMenu(consola);
               salir=ejecutarOpciones(consola,opcion,clienteDao);
            }catch (Exception e){
                System.out.println("error al ejecutar opciones : " + e.getMessage());
            }
            System.out.println();

        }
    }


    private static int  mostrarMenu(Scanner consola){
        System.out.println("""
                ***ZONA FIT (GYM) ***
                1. Listar Cleintes 
                2. Buscar Cliente
                3. Agregar Cliente
                4. Modificar Cliente
                5. Eliminar Cliente
                6. Salir
                Elije un opcion : 
                """);

        return Integer.parseInt(consola.nextLine());

    };

    private  static  boolean ejecutarOpciones (Scanner consola, int opcion , IClienteDAO clienteDAO){

        var salir = false;
        switch (opcion){
          case 1->{
              System.out.println("=====listar cliente====");
              var clientes = clienteDAO.listarClientes();
              for (Cliente i : clientes){
                  System.out.println(i);
              }
          } case 2 -> {
                System.out.println("Introduzca el id del cliente a buscar ");
                var idCliente= Integer.parseInt(consola.nextLine());
                var cliente= new Cliente((idCliente));
                var encontrado = clienteDAO.buscarClientePorId(cliente);
                if (encontrado){
                    System.out.println(cliente);
                }else {
                    System.out.println("No se encontro cliente : " + cliente);
                }

            }case 3->{
                System.out.println("---agregar cliente---");

                System.out.println("Nombe:");
                var nombre = consola.nextLine();
                System.out.println("Apellido:");
                var apellido = consola.nextLine();
                System.out.println("Mmebresia:");
                var membresia= Integer.parseInt(consola.nextLine());
                var cliente = new  Cliente(nombre,apellido,membresia);
                var agregado = clienteDAO.agregarCliente(cliente);

                if (agregado){
                    System.out.println("Cliente agregado :" + cliente);
                }else {
                    System.out.println("Cliente no agregado ");
                };


            } case 4->{
                System.out.println("---modificar cliente ---");
                System.out.println("Id cliente : ");
                var idCliente = Integer.parseInt(consola.nextLine());
                System.out.println("Nombre : ");
                var nombre= consola.nextLine();
                System.out.println("Apellido : ");
                var apellido = consola.nextLine();
                System.out.println("Membresia");
                var membresia = Integer.parseInt(consola.nextLine());

                var cliente = new Cliente(idCliente,nombre,apellido,membresia);
                var modificado = clienteDAO.modificarCliente(cliente);
                if (modificado){
                    System.out.println("Cliente modificado : " + cliente);

                }else {
                    System.out.println("no se pudo modificar el cleinte : " + cliente);
                }

            }case 5->{
                System.out.println("---eliminar cliente---");

                System.out.println("ingrese el id");
                var idCliente=Integer.parseInt(consola.nextLine());
                var cliente = new Cliente(idCliente);

                var eliminado = clienteDAO.eliminarCliente(cliente);
                if (eliminado){
                    System.out.println("Cliente eliminado: " +cliente);

                }else {
                    System.out.println("No se pudo eliminar");
                }
            }case 6->{
                System.out.println("hata pronto");
                salir=true;
            }default -> {
                System.out.println("accion no reconocida");
            }
        };
        return salir;


    };
}
