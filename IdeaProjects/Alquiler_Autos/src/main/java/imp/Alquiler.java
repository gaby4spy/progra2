package imp;

import com.google.gson.Gson;
import java.io.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class Alquiler {
    int idAlquiler;
    int idPago;
    int idSeguro;
    String fechaHoraAlquiler;
    int diasAlquiler;
    int idChofer;
    int idAuto;
    int idCliente;

    static File carpetaRaiz;
    static File carpetaAlquiler;
    static File archivoAlquiler;

    static {
        String userHome = System.getProperty("user.home");
        carpetaRaiz = new File(userHome, "Programa");
        carpetaAlquiler = new File(carpetaRaiz, "Alquileres");
        archivoAlquiler = new File(carpetaAlquiler, "alquileres.json");

        if (!carpetaAlquiler.exists()) {
            carpetaAlquiler.mkdirs();
        }
    }

    Alquiler(int idAlquiler, int idPago, int idSeguro, String fechaHoraAlquiler,
             int diasAlquiler, int idChofer, int idAuto, int idCliente) {
        this.idAlquiler = idAlquiler;
        this.idPago = idPago;
        this.idSeguro = idSeguro;
        this.fechaHoraAlquiler = fechaHoraAlquiler;
        this.diasAlquiler = diasAlquiler;
        this.idChofer= idChofer;
        this.idAuto = idAuto;
        this.idCliente = idCliente;
    }

    static int generarNuevoId() {
        Gson gson = new Gson();
        int maxId = 0;

        if (!archivoAlquiler.exists()) {
            try {
                archivoAlquiler.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        try (BufferedReader reader = new BufferedReader(new FileReader(archivoAlquiler))) {
            String linea;
            while ((linea = reader.readLine()) != null) {
                Alquiler alquiler = gson.fromJson(linea, Alquiler.class);
                if (alquiler != null && alquiler.idAlquiler > maxId) {
                    maxId = alquiler.idAlquiler;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return maxId + 1;
    }

    static void registrarAlquiler(int idSeguro, int diasAlquiler,int idChofer, int idAuto, int idCliente) {
        if (!carpetaRaiz.exists()) carpetaRaiz.mkdir();
        if (!carpetaAlquiler.exists()) carpetaAlquiler.mkdir();

        String conflicto = Seguro.verificarSeguro(idSeguro);
        String conflictoAuto = Auto.leerArchivoAuto(idAuto);
        String conflictoCliente=Cliente.existeCliente(idCliente);
        boolean conflictoCofer=Chofer.idChoferExiste(idChofer);

        if (conflicto != null || conflictoAuto != null || conflictoCliente!=null) {
            if (conflicto != null) System.out.println(conflicto);
            if (conflictoAuto != null) System.out.println(conflictoAuto);
            if (conflictoCliente!=null) System.out.println(conflictoCliente);

            return;
        }

        if (idChofer>0 && conflictoCofer==true){
            System.out.println("El chofer existe");
        }else {
            System.out.println("EL CHOFER NO EXISTE , desea crearlo ");
            System.out.println("SI= 1 / NO= 2");
            Scanner sacanner= new Scanner(System.in);
            int opcion = sacanner.nextInt();
            if (opcion==1){
                sacanner.nextLine();
                System.out.println("Ingrese el nombre completo y apellido del chofer");
                var nombre = sacanner.nextLine();
                System.out.println("Ingrese la licencia del chofer");
                var licencia= sacanner.nextLine();
                Chofer.registrarChofer(nombre,licencia);
                System.out.println("EL ALQUILER SE REGISTRO SIN CHOFER");
                idChofer=-1;
            }else {
                idChofer=-1;
                System.out.println("no se selecciono un chofer");
            };

        }



        int idAlquiler = generarNuevoId();
        Double montoAuto=Auto.calcularMontoAlquiler(idAuto,diasAlquiler);
        Double montoSeguro=Seguro.calcularMontoSeguro(idSeguro,diasAlquiler);
        Double total= montoAuto + montoSeguro;
        int idPago = Pago.registraPago(total);////modficiar para que funque el total FALTA seguro
        String fechaHoraAlquiler = LocalDateTime.now().format(DateTimeFormatter.ISO_LOCAL_DATE_TIME);

        Alquiler alquiler = new Alquiler(idAlquiler, idPago, idSeguro, fechaHoraAlquiler,
                diasAlquiler, idChofer, idAuto, idCliente);

        Gson gson = new Gson();
        String alquilerJson = gson.toJson(alquiler);

        try (FileWriter writer = new FileWriter(archivoAlquiler, true)) {
            Auto.cambiarEstadoAuto(idAuto, "Alquilado");
            writer.write(alquilerJson + System.lineSeparator());
            System.out.println("ALQUILER REGISTRADO " + idAlquiler);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    static void buscarAlquilerCliente(int idCliente) {
        Gson gson = new Gson();

        Object resultado = Cliente.obtenerClientePorId(idCliente);

        if (resultado instanceof String) {
            System.out.println((String) resultado);
            return; // No buscamos alquileres si no hay cliente
        }

        Cliente cliente = (Cliente) resultado;

        // Mostrar información del cliente
        System.out.println("CLIENTE ENCONTRADO:");
        System.out.println("ID: " + cliente.id);
        System.out.println("Nombre y apellido : " + cliente.nombre + " " + cliente.apellido);
        System.out.println("DNI: " + cliente.dni);
        System.out.println("Teléfono: " + cliente.telefono);
        System.out.println("Domicilio: " + cliente.domicilio);
        System.out.println("--------------------------------------");

        if (!archivoAlquiler.exists()) {
            try {
                archivoAlquiler.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
                return;
            }
        }

        boolean hayAlquileres = false;

        try (BufferedReader reader = new BufferedReader(new FileReader(archivoAlquiler))) {
            String linea;
            while ((linea = reader.readLine()) != null) {
                Alquiler alquiler = gson.fromJson(linea, Alquiler.class);
                if (alquiler != null && alquiler.idCliente == idCliente) {
                    double monto = Auto.calcularMontoAlquiler(alquiler.idAuto, alquiler.diasAlquiler);
                    System.out.println("ID Alquiler: " + alquiler.idAlquiler);
                    System.out.println("Fecha: " + alquiler.fechaHoraAlquiler);
                    System.out.println("Costo: $" + monto);
                    System.out.println("--------------------------------------");
                    hayAlquileres = true;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        if (!hayAlquileres) {
            System.out.println("No se encontraron alquileres para el cliente con ID " + idCliente);
        }
    }



    static void generarInformeAlquiler(String marca, String modelo) {
        Gson gson = new Gson();
        double totalRecaudado = 0;

        if (!archivoAlquiler.exists()) {
            System.out.println("No hay alquileres registrados.");
            return;
        }

        try (BufferedReader reader = new BufferedReader(new FileReader(archivoAlquiler))) {
            String linea;
            while ((linea = reader.readLine()) != null) {
                Alquiler alquiler = gson.fromJson(linea, Alquiler.class);
                if (alquiler != null) {
                    // Verifica si el auto alquilado coincide con la marca y modelo buscados
                    if (Auto.esModeloBuscado(alquiler.idAuto, marca, modelo)) {
                        // Calcula el monto según días alquilados y precio por día del auto
                        double montoAlquiler = Auto.calcularMontoAlquiler(alquiler.idAuto, alquiler.diasAlquiler);
                        totalRecaudado += montoAlquiler;

                        // Imprime detalles del alquiler
                        System.out.println("Fecha alquiler: " + alquiler.fechaHoraAlquiler);
                        System.out.println("Días alquilados: " + alquiler.diasAlquiler);
                        System.out.println("Costo alquiler: $" + montoAlquiler);
                        System.out.println("-------------------------------");
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Imprime el total recaudado por esa marca y modelo
        System.out.println("Total recaudado para " + marca + " " + modelo + ": $" + totalRecaudado);
    }

}
