package imp;

import com.google.gson.Gson;

import java.io.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Pago {

    int idPago;
    String fechaHoraPago;
    Double monto;

    static File carpetaRaiz;
    static File carpetaPago;
    static File archivoPago;

    static {
        // Ruta raíz (podés cambiarla si querés usar una ruta relativa)
        String userHome = System.getProperty("user.home");
        carpetaRaiz = new File(userHome,"Programa");
        carpetaPago = new File(carpetaRaiz, "Pagos");
        archivoPago = new File(carpetaPago, "pagos.json");
    }

    // Constructor
    public Pago(int idPago, String fechaHoraPago, Double monto) {
        this.idPago = idPago;
        this.fechaHoraPago = fechaHoraPago;
        this.monto = monto;
    }

    // Genera un nuevo ID leyendo el archivo actual
    static int generarNuevoId() {
        Gson gson = new Gson();
        int maxId = 0;

        if (!archivoPago.exists()) {
            try {
                archivoPago.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        try (BufferedReader reader = new BufferedReader(new FileReader(archivoPago))) {
            String linea;
            while ((linea = reader.readLine()) != null) {
                Pago pago = gson.fromJson(linea, Pago.class);
                if (pago != null && pago.idPago > maxId) {
                    maxId = pago.idPago;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return maxId + 1;
    }

    // Registra un nuevo pago
    static int registraPago(Double monto) {
        // Crear carpetas si no existen
        if (!carpetaRaiz.exists()) carpetaRaiz.mkdir();
        if (!carpetaPago.exists()) carpetaPago.mkdir();

        int idPago = generarNuevoId();
        String fechaHora = LocalDateTime.now().format(DateTimeFormatter.ISO_LOCAL_DATE_TIME);
        Pago pago = new Pago(idPago, fechaHora, monto);
        Gson gson = new Gson();
        String pagoJson = gson.toJson(pago);

        try (FileWriter writer = new FileWriter(archivoPago, true)) {
            writer.write(pagoJson + System.lineSeparator());
            System.out.println("PAGO REGISTRADO: ID " + idPago);
        } catch (IOException e) {
            e.printStackTrace();
        }

        return idPago;
    }

    // Muestra un pago por ID
    static void mostrarPago(int idPago) {
        Gson gson = new Gson();
        boolean encontrado = false;

        if (!archivoPago.exists()) {
            System.out.println(" No hay pagos registrados.");
            return;
        }

        try (BufferedReader reader = new BufferedReader(new FileReader(archivoPago))) {
            String linea;
            while ((linea = reader.readLine()) != null) {
                Pago pago = gson.fromJson(linea, Pago.class);
                if (pago != null && pago.idPago == idPago) {
                    System.out.println(" Pago encontrado:");
                    System.out.println("ID: " + pago.idPago);
                    System.out.println("Fecha: " + pago.fechaHoraPago);
                    System.out.println("Monto: $" + pago.monto);
                    encontrado = true;
                    break;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        if (!encontrado) {
            System.out.println(" No se encontró un pago con el ID " + idPago);
        }
    }


}

