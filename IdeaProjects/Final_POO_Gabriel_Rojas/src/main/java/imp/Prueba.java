package imp;

import java.util.Scanner;

public class Prueba {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Bienvenida.mostrar();

        int opcion;
        do {
            System.out.println("\n--- MENÚ ---");
            System.out.println("1. Listar marcas de vehículos");
            System.out.println("2. Calcular kilometraje por tipo");
            System.out.println("3. Imprimir datos de la flota");
            System.out.println("4. Agregar vehículo");
            System.out.println("0. Salir");
            System.out.print("Seleccione una opción: ");

            while (!sc.hasNextInt()) {
                System.out.print("Ingrese un número válido: ");
                sc.next();
            }
            opcion = sc.nextInt();
            sc.nextLine(); // limpiar buffer

            switch (opcion) {
                case 1:
                    Flota.listarMarcasVehiculos();
                    break;
                case 2:
                    Flota.calcularKilometrajePorTipo();
                    break;
                case 3:
                    Flota.imprimirDatosFlota();
                    break;
                case 4:
                    agregarVehiculoMenu(sc);
                    break;
                case 0:
                    System.out.println("Saliendo...");
                    break;
                default:
                    System.out.println("Opción inválida.");
            }
        } while (opcion != 0);

        sc.close();
    }

    private static void agregarVehiculoMenu(Scanner sc) {
        System.out.println("\nSeleccione el tipo de vehículo a agregar:");
        System.out.println("1. Automóvil");
        System.out.println("2. Camión");
        System.out.println("3. Motocicleta");
        System.out.print("Opción: ");

        int tipo = sc.nextInt();
        sc.nextLine();

        System.out.print("Identificador: ");
        int id = sc.nextInt();
        sc.nextLine();

        System.out.print("Marca: ");
        String marca = sc.nextLine();

        System.out.print("Kilometraje: ");
        int km = sc.nextInt();
        sc.nextLine();

        switch (tipo) {
            case 1: // Automóvil
                System.out.print("Capacidad del motor (cc): ");
                int capacidadMotor = sc.nextInt();
                sc.nextLine();
                System.out.print("Número de puertas: ");
                int puertas = sc.nextInt();
                sc.nextLine();
                Flota.agregarVehiculo(new Automovil(id, marca, km, capacidadMotor, puertas));
                break;

            case 2: // Camión
                System.out.print("Capacidad de carga (kg): ");
                double carga = sc.nextDouble();
                sc.nextLine();
                Flota.agregarVehiculo(new Camion(id, marca, km, carga));
                break;

            case 3: // Motocicleta (sin capacidad de carga)
                System.out.print("Tipo de motor: ");
                String tipoMotor = sc.nextLine();
                System.out.print("Capacidad del tanque: ");
                String capacidadTanque = sc.nextLine();
                Flota.agregarVehiculo(new Motocicleta(id, marca, km, tipoMotor, capacidadTanque));
                break;

            default:
                System.out.println("Tipo no válido.");
        }
    }
}
