package prin;

import imp.Administrador;
import imp.Empleado;

import java.util.Scanner;

public class MenuConsola {
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        while (true) {
            System.out.println("\n===== MENÚ PRINCIPAL =====");
            System.out.println("1. Ingresar como Administrador");
            System.out.println("2. Ingresar como Empleado");
            System.out.println("3. Salir");
            System.out.print("Seleccione una opción: ");

            int opcion = sc.nextInt();
            sc.nextLine(); // limpiar buffer

            switch (opcion) {
                case 1 -> menuAdministrador();
                case 2 -> menuEmpleado();
                case 3 -> {
                    System.out.println("Saliendo del sistema...");
                    return;
                }
                default -> System.out.println("Opción inválida. Intente de nuevo.");
            }
        }
    }

    private static void menuAdministrador() {
        while (true) {
            System.out.println("\n--- Menú Administrador ---");
            System.out.println("1. Generar informe de alquileres");
            System.out.println("2. Consultar historial de cliente");
            System.out.println("3. Consultar facturas");
            System.out.println("4. Modificar precio de alquiler");
            System.out.println("5. Alta empleado");
            System.out.println("6. Registrar mantenimiento de auto");
            System.out.println("7. Volver al menú principal");
            System.out.print("Seleccione una opción: ");

            int opcion = sc.nextInt();
            sc.nextLine();

            switch (opcion) {
                case 1 -> {
                    System.out.print("Ingrese marca: ");
                    String marca = sc.nextLine();
                    System.out.print("Ingrese modelo: ");
                    String modelo = sc.nextLine();
                    Administrador.generarInformeAlquileres(marca, modelo);
                }
                case 2 -> {
                    System.out.print("Ingrese ID de cliente: ");
                    int idCliente = sc.nextInt();
                    sc.nextLine();
                    Administrador.consultarHistorialCliente(idCliente);
                }
                case 3 -> {
                    System.out.print("Ingrese ID para consultar factura: ");
                    int idFactura = sc.nextInt();
                    sc.nextLine();
                    Administrador.consultarFacturas(idFactura);
                }
                case 4 -> {
                    System.out.print("Ingrese marca: ");
                    String marcaMod = sc.nextLine();
                    System.out.print("Ingrese modelo: ");
                    String modeloMod = sc.nextLine();
                    System.out.print("Ingrese nuevo precio: ");
                    double precio = sc.nextDouble();
                    sc.nextLine();
                    Administrador.modificarPrecioAlquiler(marcaMod, modeloMod, precio);
                }
                case 5 -> {
                    System.out.print("Ingrese nombre empleado: ");
                    String nombre = sc.nextLine();
                    System.out.print("Ingrese apellido empleado: ");
                    String apellido = sc.nextLine();
                    System.out.print("Ingrese cargo: ");
                    String cargo = sc.nextLine();
                    Administrador.altaEmpleado(nombre, apellido, cargo);
                }
                case 6 -> {
                    System.out.print("Ingrese patente del auto: ");
                    String patente = sc.nextLine();
                    Administrador.registrarMantenimientoAuto(patente);
                }
                case 7 -> {
                    return;
                }
                default -> System.out.println("Opción inválida.");
            }
        }
    }

    private static void menuEmpleado() {
        while (true) {
            System.out.println("\n--- Menú Empleado ---");
            System.out.println("1. Registrar cliente");
            System.out.println("2. Crear alquiler");
            System.out.println("3. Registrar devolución de auto");
            System.out.println("4. Filtrar autos por estado");
            System.out.println("5. Volver al menú principal");
            System.out.print("Seleccione una opción: ");

            int opcion = sc.nextInt();
            sc.nextLine();

            switch (opcion) {
                case 1 -> {
                    System.out.print("Nombre: ");
                    String nombre = sc.nextLine();
                    System.out.print("Apellido: ");
                    String apellido = sc.nextLine();
                    System.out.print("DNI: ");
                    String dni = sc.nextLine();
                    System.out.print("Teléfono: ");
                    String telefono = sc.nextLine();
                    System.out.print("Domicilio: ");
                    String domicilio = sc.nextLine();
                    Empleado.registrarCliente(nombre, apellido, dni, telefono, domicilio);
                }
                case 2 -> {
                    System.out.print("ID cliente: ");
                    int cliente = sc.nextInt();
                    System.out.print("ID seguro: ");
                    int idSeguro = sc.nextInt();
                    System.out.print("Días de alquiler: ");
                    int dias = sc.nextInt();
                    System.out.print("ID chofer : ");
                    int idChofer = sc.nextInt();
                    System.out.print("ID auto: ");
                    int idAuto = sc.nextInt();
                    sc.nextLine();
                    Empleado.crearAlquiler(cliente, idSeguro, dias, idChofer, idAuto);
                }
                case 3 -> {
                    System.out.print("Ingrese patente del auto: ");
                    String patente = sc.nextLine();
                    Empleado.registrarDevolucion(patente);
                }
                case 4 -> {
                    System.out.print("Estado (libre/alquilado/mantenimiento): ");
                    String estado = sc.nextLine();
                    Empleado.filtrarAutoEstado(estado);
                }
                case 5 -> {
                    return;
                }
                default -> System.out.println("Opción inválida.");
            }
        }
    }
}
